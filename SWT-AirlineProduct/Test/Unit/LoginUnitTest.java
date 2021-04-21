import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.apachecommons.ReflectionEquals;

/**
 * This class is solely designed to perform unit testing on requirements tied to the Login.Java
 * class.
 */
public class LoginUnitTest {
  private Login testingLogin;
  private User testUser;


  /**
   * The code within @BeforeEach is run before each test method execution. An object of class User
   * is created so that the expected and actual are compared.
   */
  @BeforeEach
  public void setUp() {
    testingLogin = new Login();
  }

  /**
   * Test Case ID: NegTest-LoginCase1
   * Requirement ID/Description: REQ-1 The system shall require a user to log in before they can
   *                             access the full program.
   * Purpose: To test that a user can access the home page by ensuring that the login validity is
   *          true and the login flag for Main.class is true.
   * Test setup: An object of type User is created with the username='john' and password='123'
   * Test Strategy: Decision Table Testing
   * ID	          Condition/Action                  Test Case 1
   * Condition 1	Valid Username	                       T
   * Condition 2	Valid Password	                       T
   * Action 1	    Home Page	                           Execute
   * Action 2   	Show a message displaying
   *              'Username or password do not match.'
   * Input: Call method handleLoginEnter(null, "john", "123"). Dummy object of type Main is set to
   *        True.
   * Expected Output: The login validity is retrieved after handleLoginEnter method is called and
   *                  access the the home page is visible.
   */
  @Test
  @DisplayName("Login Case 1: Valid username and password supplied")
  void handleValidLogin() {
    Main dummyMain = new Main(true);
    testingLogin.handleLoginEnter(null, "john", "123");

    assertEquals(dummyMain.getLoginFlag(), testingLogin.getLoginValidity());
  }

  /**
   * Test Case ID: NegTest-LoginCase2
   * Requirement ID/Description: REQ-1 The system shall require a user to log in before they can
   *                             access the full program.
   * Purpose: To test that a user cannot access the home page by ensuring that the login validity is
   *          false.
   * Test setup: An object of the User class is created with the username='john' and password='1234'
   * Test Strategy: Decision Table Testing
   * ID	          Condition/Action                        Test Case 2
   * Condition 1	Valid Username	                            T
   * Condition 2	Valid Password	                            F
   * Action 1	    Home Page
   * Action 2   	Show a message displaying                Execute
   *              'Username or password do not match.'
   * Input: Call method handleLoginEnter(null, "john", "1234")
   * Expected Output: Method handleLoginEnter return an object of User with username='john' and
   *                  password='1234'. The login validity is retrieved and is false to denote an
   *                  invalid login.
   */
  @Test
  @DisplayName("Login Case 2: Valid username, invalid password")
  void handleInvalidPasswordLogin() {
    testingLogin.handleLoginEnter(null, "john", "1234");

    assertFalse(testingLogin.getLoginValidity(), "Invalid password.");
  }

  /**
   * Test Case ID: NegTest-LoginCase3
   * Requirement ID/Description: REQ-1 The system shall require a user to log in before they can
   *                             access the full program.
   * Purpose: To test that a user cannot access the home page by ensuring that the login validity is
   *          false.
   * Test setup: An object of the User class is created with the username='rjumarr' and password='1234'
   * Test Strategy: Decision Table Testing
   * ID	          Condition/Action                        Test Case 3
   * Condition 1	Valid Username	                            F
   * Condition 2	Valid Password	                            T
   * Action 1	    Home Page
   * Action 2   	Show a message displaying                Execute
   *              'Username or password do not match.'
   * Input: Call method handleLoginEnter(null, "rjumarr", "123")
   * Expected Output: Method handleLoginEnter return an object of User with username='rjumarr' and
   *                  password='123'. The login validity is retrieved and is false to denote an
   *                  invalid login.
   */
  @Test
  @DisplayName("Login Case 3: Invalid username, valid password")
  void handleInvalidUsernameLogin() {
    testingLogin.handleLoginEnter(null, "rjumarr", "123");

    assertFalse(testingLogin.getLoginValidity(), "Invalid username.");
  }

  /**
   * Test Case ID: NegTest-LoginCase4
   * Requirement ID/Description: REQ-1 The system shall require a user to log in before they can
   *                             access the full program.
   * Purpose: To test that a user cannot access the home page by ensuring that the login validity is
   *          false.
   * Test setup: An object of the User class is created with the username='' and password=''
   * Test Strategy: Decision Table Testing
   * ID	          Condition/Action                        Test Case 4
   * Condition 1	Valid Username	                            F
   * Condition 2	Valid Password	                            F
   * Action 1	    Home Page
   * Action 2   	Show a message displaying                Execute
   *              'Username or password do not match.'
   * Input: Call method handleLoginEnter(null, "", "")
   * Expected Output: Method handleLoginEnter return an message: "Username and Password cannot be blank."
   *                  The login validity is retrieved and is false to denote an
   *                  invalid login.
   */
  @Test
  @DisplayName("Login Case 4: Empty username and password fields")
  void handleLoginEmpty() {
    testingLogin.handleLoginEnter(null, "", "");

    assertFalse(testingLogin.getLoginValidity(), "Username and Password cannot be blank.");
  }

  /**
   * Test Case ID:
   * Requirement ID/Description: REQ-21 The system shall prevent illegal access by terminating after
   *                             three failed login attempts.
   * Purpose: To test that a user cannot access the system after three unsuccessful attempts.
   * Test setup: Attempts are set to zero and User(null, "blah, "blah")
   * Test Strategy: Negative Testing
   * Input: Attempts left are set to zero and a call method handleLoginEnter(null, "blah", "blah")
   *        is executed.
   * Expected Output: Method handleLoginEnter return an message: "Maximum number of attempts exceeded."
   *                  The login visibility is retrieved is false.
   */
  @Test
  @DisplayName("Failed Login Case 1: A user fails to log in three times and the system terminates.")
  void failedLoginTest() {
    testingLogin.setAttemptsLeft(0);
    testingLogin.handleLoginEnter(null, "blah", "blah");
    assertFalse(testingLogin.isVisible());
  }
}
