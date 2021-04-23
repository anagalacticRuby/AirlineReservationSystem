import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import javax.security.auth.login.LoginException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MainUnitTest {

  /**
   * Test Case ID: UnitTest-Login-001
   * Requirement ID/Description: REQ-1 The system shall require a user to log in before they can
   *                             access the full program.
   * Purpose: This test is supposed to pass in order to indicate that the system has not terminated
   *          after a successful login
   * Test setup: An dummy object of the Main class is created with boolean flag of True.
   * Test Strategy: Positive Testing
   * Input: Dummy object of type Main with loginFlag field set to true.
   * Expected Output: The new instance of Main class returns a boolean value of true to denote a
   * successful login to the system.
   */
  @Test
  @DisplayName("Test Case 1: A user has successfully logged into the system, "
      + "obtaining access to Main")
  public void loginAuthTest() {
    Main dummyMain = new Main(true);
    assertNotNull(dummyMain);
  }


  /**
   * Test Case ID: UnitTest-Login-002
   * Requirement ID/Description: REQ-1 The system shall require a user to log in before they can
   *                             access the full program.
   * Purpose: This test is supposed to fail in order to indicate that the system has caught and
   *          handled a login exception.
   * Test setup: An dummy object of the Main class is created with boolean flag of False.
   * Test Strategy: Negative Testing
   * Input: Dummy object of type Main with loginFlag field set to false.
   * Expected Output: The new instance of Main class returns a boolean value of false to denote an
   *                  invalid access to the system.
   */
  @Test
  @DisplayName("Test Case 2: A user attempts to access the system illegally without permission.")
  public void loginIllegalAuthTest() {
    Main illegalMain = new Main(false);
    assertThrows(LoginException.class, () -> illegalMain.terminateSystem());
  }
}
