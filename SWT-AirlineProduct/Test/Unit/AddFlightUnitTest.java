import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.naming.NameAlreadyBoundException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AddFlightUnitTest {
  private Flight dummyFlight;
  private addflight addflight;

  /**
   * The code within @BeforeEach is run before each test method execution. An object of flight is
   * created so that test cases can be compared to the expected results.
   */
  @BeforeEach
  public void setUp() {
    addflight = new addflight();
    dummyFlight =
        new Flight("FO009", "JetBlue", "USA", "UK", "2021-09-13", "9:00AM", "10:00PM", "9000");
  }

  /**
   * The code within @AfterEach is run after each test method executes. This is necessary to return
   * the environment back to the state it was in after each test so that all tests can run under the
   * same circumstances and environment state.
   * <p>
   * This tearDown method will remove the flight objects that are added within each test case of the
   * AddFlightUnitTest class, so that the database does not get overwhelmed with dummy entries.
   */
  @AfterEach
  public void tearDown() {
    Connection con = DBUtil.dbConnect();
    PreparedStatement pst;

    try {
      pst = con.prepareStatement("Delete from flight where id=?");
      /*
       * SQL will know what rows to delete based on the condition. Because all of the dummyFlight
       * objects have the same ID, we are able to delete them before the next test is run, and
       * therefore do not require hundreds of dummy items.
       */
      pst.setString(1, "FO009");
      pst.executeUpdate();
      // Execute the delete operation on the database
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }

  /**
   * Test Case ID: UnitTest-AddFlight-001
   * Requirement ID/Description: REQ-5 The system shall allow a user to add flights into the
   * database.
   * Purpose: To confirm that any flights the user adds will be successfully added into the
   * database.
   * Test Setup: We create a dummy flight to act as the input, and attempt to add it into the
   * database.
   * Test Strategy: A unit test to confirm if a flight has been added or not.
   * Input: A dummy flight to be added into the database.
   * Expected Output: Confirmation that the flight has been successfully added into the databse.
   */
  @Test
  @DisplayName("Test Case 1: A flight object is created and stored in the database.")
  void validFlightTest() {
    Flight newflight = addflight.addFlight(dummyFlight);
    assertEquals(newflight, dummyFlight);

  }

  /**
   * Test Case ID: Requirement: #4, The system shall require that every field is filled before
   * processing requests.
   */
  @Test
  @DisplayName("Empty Flight Test: A flight object with an empty field attempts to be added.")
  public void emptyFlightTest() {
    dummyFlight.setArrivalTime("");
    Exception testExcept = assertThrows(NullPointerException.class,
        () -> addflight.addFlight(dummyFlight), "Fields must not be empty.");
    assertEquals("Fields must not be empty.", testExcept.getMessage());
  }

  /**
   * Test Case ID: UnitTest-AddFlight-002
   * Requirement ID/Description: REQ-4 The system shall require that every field is filled before
   * processing requests.
   * Purpose: To test if the program will not allow flights that are missing a field to be
   * processed and added into the database.
   * Test Setup: We will create a dummy flight with an empty Arrival Time field, and observe
   * how the system reacts.
   * Test Strategy: We'll use a Unit Test to confirm that the system will not accept the input
   * we give it.
   * Input: A dummy flight with an empty Arrival Time field.
   * Expected Output: An exception and an error message that reads "Fields must not be empty."
   */
  @Test
  @DisplayName("Test that the system generates new IDs after each database insertion")
  public void flightIDTest() {
    String originalID = dummyFlight.getId();
    // First store the original ID of dummyFlight
    dummyFlight = addflight.addFlight(dummyFlight);
    /*
     * Add dummyFlight to the database. addFlight should return a flight with a different ID than
     * the ID of the flight that was passed into addFlight. Assign this returned flight to the
     * dummyFlight object, and then a comparison can be performed to validate the different IDs.
     */
    assertNotEquals(dummyFlight.getId(), originalID);
  }

  /**
   * Test Case ID: UnitTest-ProcessTime-001
   * Requirement ID/Description: REQ-15 The system shall take no longer than 3 seconds to perform
   * database operations.
   * Purpose: To ensure that all database operations are being completed and processed at an
   * acceptable rate of time.
   * Test Setup: Creating a dummy flight to be inputted into the database so we can have it
   * process an operation for us to take the runtime of.
   * Test Strategy: A Unit Test to confirm that the response time for database operations is
   * less than 3 seconds by inputting a dummy value into the database and recording how long
   * it takes by taking the time before and after the process to find the total time spent.
   * Input: A dummy flight to be added to the database.
   * Expected Output: The time we receive as output should be less than 3 seconds.
   */
  @Test
  @DisplayName("Test that the system does not allow duplicate IDs")
  public void uniqueFlightIDTest() {
    System.out.println(dummyFlight.getId());
    addflight.addFlight(dummyFlight);
    dummyFlight.setId("FO009");
    assertThrows(NameAlreadyBoundException.class, () -> addflight.addFlight(dummyFlight),
        "Flights must have a unique ID!");
  }
  
}
