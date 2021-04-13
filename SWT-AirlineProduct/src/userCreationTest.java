import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.apachecommons.ReflectionEquals;


public class userCreationTest {
  private User user;
  private userCreation userCreation;

  /**
   * The code within @BeforeEach is run before each test method execution. An object of class User is
   * created so that the expected and actual are compared.
   */
  @BeforeEach
  public void setUp() {
    userCreation = new userCreation();
  }

  /**
   * Test Case ID: PosTest—UserCreation1
   * Requirement ID/Description: REQ-5 The system shall require the user to create a password for
   *                             their profile.
   * Purpose:
   * Test setup: An object of the User class is created with the id='CS001', firstname='john',
   *            lastname='Alex', nic=34232222, passport=3443, address=Uk, dob='null', gender='Male',
   *            contact=3432434, photo='null'
   * Test Strategy:
   * ID	          Condition/Action                  Test Case 1	        Test Case 2
   * Condition 1	Valid Username	                       T	                T
   * Condition 2	Valid Password	                       T	                F
   * Action 1	    User Created	                      Execute
   * Action 2   	Show a message displaying
   *              'Username or password cannot'	 	                       Execute
   *              be blank
   * Input: Call method handleLoginEnter(null, "rjumar", " ", "Ravi", "Kumar", "UO004")
   * Expected Output: Method call handleCreation returns an exception message 'Username or Password
   *                  cannot be blank.'
   */
  @Test
  @DisplayName("User creation should be invalid due to an empty password.")
  void handleInvalidPWCreation() {
    Exception exception =
        assertThrows(NullPointerException.class, () -> userCreation.handleCreation(null, "rjumar",
            "", "Ravi", "Kumar", "UO004"));

    assertEquals("Username or Password cannot be blank.", exception.getMessage());
  }

  /**
   * Test Case ID:
   * Requirement ID/Description: REQ-5 The system shall require the user to create a password for
   *                             their profile.
   * Purpose:
   * Test setup: An object of the User class is created with the id='CS001', firstname='john',
   *            lastname='Alex', nic=34232222, passport=3443, address=Uk, dob='null', gender='Male',
   *            contact=3432434, photo='null'
   * Test Strategy:
   * ID	          Condition/Action                  Test Case 1	        Test Case 2
   * Condition 1	Valid Username	                       T	                T
   * Condition 2	Valid Password	                       T	                F
   * Action 1	    User Created	                      Execute
   * Action 2   	Show a message displaying
   *              'Username or password cannot'	 	                       Execute
   *              be blank
   * Input: Call method handleLoginEnter(null, "rjumar", "321", "Ravi", "Kumar", "UO004")
   * Expected Output: Method handleCreation return a object of User with password='321' that
   *                  results in a successful user creation.
   */
  @Test
  @DisplayName("User creation should be valid due to an full password.")
  void handleValidPWCreation() {
    User result = userCreation.handleCreation(null, "rjumar2",
        "4321", "Ravi", "Kumar", "UO008");

    assertEquals("4321", result.getPassword(), "Password matches.");
  }

  /**
   * Test Case ID: NegTest—DuplicateUsername1
   * Requirement ID/Description:
   */
  @Test
  @DisplayName("User creation should be invalid due to a duplicate username.")
  void handleDuplicateUsername() {
    Exception exception =
        assertThrows(IllegalArgumentException.class, () -> userCreation.handleCreation(null, "rjumar",
            "4321", "Ravi", "Kumar", "UO004"));
    assertEquals("Username cannot be a duplicate.", exception.getMessage());
  }

  /**
   * Test Case ID:
   * Requirement ID/Description: REQ-1 The user shall be able to create their profile in the system.
   */
  @Test
  @DisplayName("User creation should be executed.")
  void handleUserCreation() {
    user = new User("rmontoya", "montoya1", "Ricardo", "Montoya", "UO014");

    User tempUser = userCreation.handleCreation(null, user.getUsername(), user.getPassword(), user.getFirstname(), user.getLastname(), user.getId());

    assertTrue(new ReflectionEquals(user).matches(tempUser));
  }

  /**
   * Test Case ID:
   * Requirement ID/Description: REQ-9 The system shall save all user profiles in a database.
   */
  @Test
  @DisplayName("The user credentials should be stored within the database.")
  void handleDatabaseStorage() {

    User newUser = userCreation.handleCreation(null, "ronsmith", "rsmith32", "Ronald", "Smith", "UO0013");
    User currentUser = new User("ronsmith", "rsmith32");

    assertEquals(newUser.getUsername(), currentUser.getUsername());
    assertEquals(newUser.getPassword(), currentUser.getPassword());
    assertEquals(newUser.getFirstname(), currentUser.getFirstname());
    assertEquals(newUser.getLastname(), currentUser.getLastname());
    assertEquals(newUser.getId(), currentUser.getId());
  }

  /**
   * Test Case ID:
   * Requirement ID/Description: REQ-4 The system shall require the user to create a username for
   * their profile.
   */
  @Test
  @DisplayName("User creation should be invalid due to an empty username field.")
  void handleInvalidUNCreation() {
    Exception exception = assertThrows(NullPointerException.class, () -> userCreation.handleCreation(null,
        "", "123", "Ravi", "Kumar", "UO004"));

    assertEquals("Username or Password cannot be blank.", exception.getMessage());

  }
}
