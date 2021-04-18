
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Class used to perform testing on the Login.java class.
 */
public class LoginTest {
  private Login login;
  private User user;

  /**
   * The code within @BeforeEach is run before each test method execution. An object of class User is
   * created so that the expected and actual are compared.
   */
  @BeforeEach
  public void setUp() {
    login = new Login();
    user = new User("rjumar", "123", "Ravi", "Kumar", "UO004");

  }

  /**
   * Test Case ID: NegTest-LoginCase1
   * Requirement ID/Description: REQ-10 The system shall allow users to log in to the system if they
   *                             provide the correct credentials (Username & Password).
   * Purpose: To test that a user can access the home page by ensuring that both username and
   *          password are valid.
   * Test setup: An object of the User class is created with the username='rjumar' and password='123'
   * Test Strategy: Decision Table Testing
   * ID	          Condition/Action                  Test Case 1	Test Case 2	Test Case 3	Test Case 4
   * Condition 1	Valid Username	                       T	        T	            F	        F
   * Condition 2	Valid Password	                       T	        F	            T	        F
   * Action 1	    Home Page	                           Execute
   * Action 2   	Show a message displaying
   *              'Username or password do not match.'	 	          Execute	     Execute	  Execute
   * Input: Call method handleLoginEnter(null, "rjumar", "123")
   * Expected Output: Method handleLoginEnter return an object of User with username='rjumar' and
   *                  password='123'
   */
  @Test
  @DisplayName("User login credentials shall allow access to the Airline Reservation System.")
  void handleValidLogin() {
    User result = login.handleLoginEnter(null, "rjumar", "123");

    assertEquals(user.getUsername(), result.getUsername(), "Username matches.");
    assertEquals(user.getPassword(), result.getPassword(), "Password matches.");
  }

  /**
   * Test Case ID: NegTest-LoginCase4
   * Requirement ID/Description: REQ-10 The system shall allow users to log in to the system if they
   *                             provide the correct credentials (Username & Password).
   * Purpose: To test that the system performs correct exception handling by not allowing a user to
   *          access the home page if username and password is incorrect.
   * Test setup: An object of the User class is created with the username='rjumar' and password='123'
   * Test Strategy: Decision Table Testing
   * ID	          Condition/Action                  Test Case 1	Test Case 2	Test Case 3	Test Case 4
   * Condition 1	Valid Username	                       T	        T	            F	        F
   * Condition 2	Valid Password	                       T	        F	            T	        F
   * Action 1	    Home Page	                           Execute
   * Action 2   	Show a message displaying
   *              'Username or password do not match.'	 	          Execute	     Execute	  Execute
   * Input: Call method handleLoginEnter(null, "", "")
   * Expected Output: Method handleLoginEnter returns an exception message 'Username or Password
   *                  cannot be blank.'
   */
  @Test
  @DisplayName("User login should be invalid due to an invalid login and username.")
  void handleLoginEmpty() {
    Exception exception =
        assertThrows(NullPointerException.class, () -> login.handleLoginEnter(null, "",
            ""));
    assertEquals("Username or Password cannot be blank.", exception.getMessage());
  }

  /**
   * Test Case ID: NegTest-LoginCase3
   * Requirement ID/Description: REQ-10 The system shall allow users to log in to the system if they
   *                             provide the correct credentials (Username & Password).
   * Purpose: To test that the system performs correct exception handling by not allowing a user to
   *          access the home page if username is incorrect.
   * Test setup: An object of the User class is created with the username='rjumar' and password='123'
   * Test Strategy: Decision Table Testing
   * ID	          Condition/Action                  Test Case 1	Test Case 2	Test Case 3	Test Case 4
   * Condition 1	Valid Username	                       T	        T	            F	        F
   * Condition 2	Valid Password	                       T	        F	            T	        F
   * Action 1	    Home Page	                           Execute
   * Action 2   	Show a message displaying
   *              'Username or password do not match.'	 	          Execute	     Execute	  Execute
   * Input: Call method handleLoginEnter(null, "rjumarr", "123")
   * Expected Output: Method handleLoginEnter returns an exception message 'Username or Password
   *                  do not match.'
   */
  @Test
  @DisplayName("User login should be invalid due to an incorrect username.")
  void handleInvalidUsernameLogin() {
    Exception exception =
        assertThrows(NullPointerException.class, () -> login.handleLoginEnter(null, "rjumarr",
            "123"));
    assertEquals("Username or password do not match.", exception.getMessage());
  }

  /**
   * Test Case ID: NegTest-LoginCase2
   * Requirement ID/Description: REQ-10 The system shall allow users to log in to the system if they
   *                             provide the correct credentials (Username & Password).
   * Purpose: To test that the system performs correct exception handling by not allowing a user to
   *          access the home page if password is incorrect.
   * Test setup: An object of the User class is created with the username='rjumar' and password='123'
   * Test Strategy: Decision Table Testing
   * ID	          Condition/Action                  Test Case 1	Test Case 2	Test Case 3	Test Case 4
   * Condition 1	Valid Username	                       T	        T	            F	        F
   * Condition 2	Valid Password	                       T	        F	            T	        F
   * Action 1	    Home Page	                           Execute
   * Action 2   	Show a message displaying
   *              'Username or password do not match.'	 	          Execute	     Execute	  Execute
   * Input: Call method handleLoginEnter(null, "rjumar", "1234")
   * Expected Output: Method handleLoginEnter returns an exception message 'Username or Password
   *                  do not match.'
   */
  @Test
  @DisplayName("User login should be invalid due to an incorrect password.")
  void handleInvalidPasswordLogin() {
    Exception exception =
        assertThrows(ArithmeticException.class, () -> login.handleLoginEnter(null, "rjumar",
            "1234"));
    assertEquals("Username or password do not match.", exception.getMessage());
  }

/**
 * Test Case ID:
 * Requirement ID/Description: REQ-31 The system shall prevent users from logging into the system
 * upon three failed login attempts.
 */
  @Test
  @DisplayName("The system should terminate on three invalid login attempts.")
  void handleAttempts() {

  }
}
