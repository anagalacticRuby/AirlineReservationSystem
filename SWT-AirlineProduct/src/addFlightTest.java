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

  @BeforeEach
  public void setUp() {
    addflight = new addflight();
    flight = new Flight("FO009", "JetBlue", "USA", "UK",
        "2021-09-13", "9:00AM", "10:00PM", "9000");
  }

  @Test
  void handleValidFlight() {
    Flight newflight = addflight.addFlight(flight.getId(), flight.getFlightName(), flight.getSource(),
        flight.getDepart(), flight.getDate(), flight.getDepartTime(), flight.getArrivalTime(), flight.getFlightCharge());

    assertTrue(new ReflectionEquals(flight).matches(newflight));
  }

  @Test
  void handleEmptyFlightName() {
    Exception exception =
        assertThrows(NullPointerException.class, () -> addflight.addFlight("FO008", "", "USA", "UK", "2021-10-09", "9.00 AM",
            "8.00PM", "8000"));

    assertEquals("Fields must not be empty.", exception.getMessage());
  }

  @Test
  void handleEmptySourceDepart() {
    Exception exception =
        assertThrows(NullPointerException.class, () -> addflight.addFlight("FO008", "JetBlue", "", "", "2021-10-09", "9.00 AM",
            "8.00PM", "8000"));

    assertEquals("Fields must not be empty.", exception.getMessage());
  }

  @Test
  void handleEmptyDate() {
    Exception exception =
        assertThrows(NullPointerException.class, () -> addflight.addFlight("FO008", "JetBlue", "USA", "UK", "", "9.00 AM",
            "8.00PM", "8000"));

    assertEquals("Fields must not be empty.", exception.getMessage());
  }

  @Test
  void handleEmptySourceDepartTime() {
    Exception exception =
        assertThrows(NullPointerException.class, () -> addflight.addFlight("FO008", "JetBlue", "USA", "UK", "2021-10-09", "",
            "", "8000"));

    assertEquals("Fields must not be empty.", exception.getMessage());
  }

  @Test
  void handleEmptyFlightCharge() {
    Exception exception =
        assertThrows(NullPointerException.class, () -> addflight.addFlight("FO008", "JetBlue", "USA", "UK", "2021-10-09", "9.00 AM",
            "8.00PM", ""));

    assertEquals("Fields must not be empty.", exception.getMessage());
  }
}
