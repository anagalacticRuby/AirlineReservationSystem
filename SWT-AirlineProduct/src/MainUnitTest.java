import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import javax.security.auth.login.LoginException;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

public class MainUnitTest {


  // This test is supposed to pass in order to indicate that the system has not terminated after a
  // successful login.
  @Test
  @DisplayName("Test Case 1: A user has sucessfully logged into the system, "
      + "obtaining access to Main")
  public void loginAuthTest() {
    Main dummyMain = new Main(true);
    assertNotNull(dummyMain);
  }

  // This test is supposed to fail. It indicates that the loginexception has been caught and
  // handled.
  @Test
  @DisplayName("Test Case 2: A user attempts to access the system illegally without permission.")
  public void loginIllegalAuthTest() {
    Main illegalMain = new Main(false);
    assertThrows(LoginException.class, () -> illegalMain.terminateSystem());
  }


}
