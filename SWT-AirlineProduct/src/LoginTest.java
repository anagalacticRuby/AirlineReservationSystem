import java.awt.event.ActionEvent;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LoginTest {
  private Login login;
  private User user;

  @BeforeEach
  public void setUp() {
    login = new Login();
    user = new User("rjumar", "123", "Ravi", "Kumar", "UO004");

  }

  @Test
  @DisplayName("User login credentials shall allow access to the Airline Reservation System.")
  void handleLoginEnter() {
    assertEquals(user.getUsername(), login.handleLoginEnter(null, "rjumar", "123").getUsername());

  }

  @Test
  @DisplayName("User login should be invalid due to an empty login or username.")
  void handleLoginEmpty() {
    Exception exception =
        assertThrows(ArithmeticException.class, () -> login.handleLoginEnter(null, "",
            ""));
    assertEquals("Username or Password cannot be blank.", exception.getMessage());
  }
}
