import java.awt.event.ActionEvent;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LoginTest {
  private Login login;
  private User user;

  @BeforeEach
  public void setUp() {
    login = new Login();
    user = new User("rjumar", "123", "Ravi", "Kumar", "UO004");

  }


  @Test
  @DisplayName("User login should be valid.")
  void handleLoginEnter() {
    assertEquals(user, login.handleLoginEnter(null, "rjumar", "123"));
    System.out.println();
  }





}
