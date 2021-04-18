import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.apachecommons.ReflectionEquals;

public class addFlightTest {
  private Flight flight;
  private addflight addflight;

  /**
   * The code within @BeforeEach is run before each test method execution. An object of flight is created
   * so that test cases can be compared to the expected results.
   */
  @BeforeEach
  public void setUp() {
    addflight = new addflight();
    flight = new Flight("FO009", "JetBlue", "USA", "UK",
        "2021-09-13", "9:00AM", "10:00PM", "9000");
  }

  /**
   * Test Case ID:
   * Requirement ID/Description: REQ-13 The system shall save information for each flight.
   * Purpose: To test that a flight object can be created an store into the database.
   * Test setup: An object of the Flight class is created with valid credentials
   * Test Strategy:
   */
  @Test
  @DisplayName("")
  void handleValidFlight() {
    Flight newflight = addflight.addFlight(flight.getId(), flight.getFlightName(), flight.getSource(),
        flight.getDepart(), flight.getDate(), flight.getDepartTime(), flight.getArrivalTime(), flight.getFlightCharge());

    assertTrue(new ReflectionEquals(flight).matches(newflight));
  }

  /**
   * Test Case ID:
   * Requirement ID/Description: REQ-15 The system shall require each flight to have a name.
   */
  @Test
  @DisplayName("")
  void handleEmptyFlightName() {
    Exception exception =
        assertThrows(NullPointerException.class, () -> addflight.addFlight("FO008", "", "USA", "UK", "2021-10-09", "9.00 AM",
            "8.00PM", "8000"));

    assertEquals("Fields must not be empty.", exception.getMessage());
  }

  /**
   * Test Case ID:
   * Requirement ID/Description: REQ-16 The system shall require each flight to have a source and departure location.
   */
  @Test
  @DisplayName("")
  void handleEmptySourceDepart() {
    Exception exception =
        assertThrows(NullPointerException.class, () -> addflight.addFlight("FO008", "JetBlue", "", "", "2021-10-09", "9.00 AM",
            "8.00PM", "8000"));

    assertEquals("Fields must not be empty.", exception.getMessage());
  }

  /**
   * Test Case ID:
   * Requirement ID/Description: REQ-14 The system shall require each flight to have a date for the day of the flight.
   */
  @Test
  @DisplayName("")
  void handleEmptyDate() {
    Exception exception =
        assertThrows(NullPointerException.class, () -> addflight.addFlight("FO008", "JetBlue", "USA", "UK", "", "9.00 AM",
            "8.00PM", "8000"));

    assertEquals("Fields must not be empty.", exception.getMessage());
  }

  /**
   * Test Case ID:
   * Requirement ID/Description: REQ-18 The system shall require each flight to have a departure and arrival time.
   */
  @Test
  @DisplayName("")
  void handleEmptySourceDepartTime() {
    Exception exception =
        assertThrows(NullPointerException.class, () -> addflight.addFlight("FO008", "JetBlue", "USA", "UK", "2021-10-09", "",
            "", "8000"));

    assertEquals("Fields must not be empty.", exception.getMessage());
  }

  /**
   * Test Case ID:
   * Requirement ID/Description: REQ-19 The system shall require each flight to have a flight charge.
   */
  @Test
  @DisplayName("")
  void handleEmptyFlightCharge() {
    Exception exception =
        assertThrows(NullPointerException.class, () -> addflight.addFlight("FO008", "JetBlue", "USA", "UK", "2021-10-09", "9.00 AM",
            "8.00PM", ""));

    assertEquals("Fields must not be empty.", exception.getMessage());
  }
}
