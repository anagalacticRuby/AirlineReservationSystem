
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * This class is solely designed to perform unit testing on requirements tied to the Login.Java
 * class.
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
  @DisplayName("Login Case 1: Valid username and password supplied")
  void handleValidLogin() {
    User result = login.handleLoginEnter(null, "rjumar", "123");

    assertEquals(user.getUsername(), result.getUsername(), "Username matches.");
    assertEquals(user.getPassword(), result.getPassword(), "Password matches.");
    assertTrue(login.getLoginValidity());
  }


  /**
   * Test Case ID: NegTest-LoginCase2
   * Requirement ID/Description: REQ-10 The system shall allow users to log in to the system if they
   *                             provide the correct credentials (Username & Password).
   * Purpose: To test that the system performs correct exception handling by not allowing a user to
   *          access the home page if password is incorrect.
   * Test setup: An object of the User class is created with the username='rjumar' and password='123'
   * Test Strategy: Decision Table Testing
   * ID           Condition/Action                  Test Case 1 Test Case 2 Test Case 3 Test Case 4
   * Condition 1    Valid Username                         T            T               F           F
   * Condition 2    Valid Password                         T            F               T           F
   * Action 1       Home Page                              Execute
   * Action 2       Show a message displaying
   *              'Username or password do not match.'                Execute        Execute      Execute
   * Input: Call method handleLoginEnter(null, "rjumar", "1234")
   * Expected Output: Method handleLoginEnter returns an exception message 'Username or Password
   *                  do not match.'
   */
  @Test
  @DisplayName("Login Case 2: Valid username, invalid password")
  void handleInvalidPasswordLogin() {
    login.handleLoginEnter(null, "rjumar", "1234");
    assertFalse(login.getLoginValidity(), "Invalid password.");
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
  @DisplayName("Login Case 3: Invalid username, valid password")
  void handleInvalidUsernameLogin() {
    login.handleLoginEnter(null, "rjumarr", "123");
    assertFalse(login.getLoginValidity(), "Username and Password do not match.");
  }

  /**
   * Test Case ID: NegTest-LoginCase4
   * Requirement ID/Description: REQ-10 The system shall allow users to log in to the system if they
   *                             provide the correct credentials (Username & Password).
   * Purpose: To test that the system performs correct exception handling by not allowing a user to
   *          access the home page if username and password is incorrect.
   * Test setup: An object of the User class is created with the username='rjumar' and password='123'
   * Test Strategy: Decision Table Testing
   * ID           Condition/Action                  Test Case 1 Test Case 2 Test Case 3 Test Case 4
   * Condition 1    Valid Username                         T            T               F           F
   * Condition 2    Valid Password                         T            F               T           F
   * Action 1       Home Page                              Execute
   * Action 2       Show a message displaying
   *              'Username and Password must be filled.'  Execute      Execute   Execute
   * Input: Call method handleLoginEnter(null, "", "")
   * Expected Output: Method handleLoginEnter returns an exception message 'Username or Password
   *                  cannot be blank.'
   */
  @Test
  @DisplayName("Login Case 4: Empty username and password fields")
  void handleLoginEmpty() {
    login.handleLoginEnter(null,"","");
    assertFalse(login.getLoginValidity(), "Username and Password cannot be blank.");
  }
}
