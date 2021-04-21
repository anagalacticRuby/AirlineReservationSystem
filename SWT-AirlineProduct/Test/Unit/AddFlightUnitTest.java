import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
   * Test Case ID: Requirement: #5, The system shall allow a user to add flights into the database.
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
   * Test Case ID: Requirement #14, The system shall automatically handle the generation of unique
   * IDs for items inserted into the airline database.
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
   * Test Case ID: Requirement #13, The system shall require that all entries to the airline
   * database have unique IDs. The testing technique used here is negative testing, because the test
   * failure indicates that the exceptional behavior has been caught.
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
