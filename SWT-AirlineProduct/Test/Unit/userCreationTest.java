import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.apachecommons.ReflectionEquals;


public class userCreationTest {
  private User dummyUser;
  private userCreation userCreation;

  /**
   * The code within @BeforeEach is run before each test method execution. An object of class User
   * is created so that the expected and actual are compared.
   */
  @BeforeEach
  public void setUp() {
    userCreation = new userCreation();
    dummyUser = new User("UO004", "Ricky", "Jumar", "rjumar", "1234");
  }

  /**
   * The code within @AfterEach is run after each test method execution. It is so that the database
   * returns to it original state after each user creation.
   */
  @AfterEach
  public void tearDown() {
    Connection con = DBUtil.dbConnect();
    PreparedStatement pst;

    try {
      pst = con.prepareStatement("Delete from user where id=?");
      /*
       * SQL will know what rows to delete based on the condition. Because all of the dummyUser
       * objects have the same ID, we are able to delete them before the next test is run, and
       * therefore do not require hundreds of dummy items.
       */
      pst.setString(1, "UO004");
      pst.executeUpdate();
      // Execute the delete operation on the database
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  /**
   * Test Case ID:
   * Requirement: REQ-4 The system shall require that every field is filled before
   *              processing requests.
   * Purpose: The purpose is to test when a user has left an empty field on user creation and
   *          shows the response from the system.
   * Test Setup: A dummy object of type User is declared within the setup method with the following
   *             data: User("UO004", "Ricky", "Jumar", "rjumar", "1234"). Within emptyUserFieldTest,
   *             the username is set to "" so that it denotes an empty field.
   * Test Strategy: Decision Table Testing
   * ID	            Condition/Action                    Test Case 1
   * Condition 1	  Valid Username	                        F
   * Condition 2	  Valid Password	                        T
   * Action 1	      User Created
   * Action 2   	  Show a message displaying            Execute
   *                "Username or password is blank"
   * Input: Call to method createUser with dummyUser attributes and a modified username.
   * Expected Output: Method call createUser returns an exception message 'Username or Password
   *                  cannot be blank.'
   */
  @Test
  @DisplayName("System shall prevent user accounts from having empty fields")
  void emptyUserFieldTest() {
    dummyUser.setUsername("");
    Exception exception =
        assertThrows(NullPointerException.class, () -> userCreation.createUser(dummyUser));

    assertEquals("Username or Password cannot be blank.", exception.getMessage());
  }

  /**
   * Test Case ID:
   * Requirement ID/Description: REQ-3 The system shall allow users to create user accounts for other users.
   * Purpose: The purpose is to test the creation of a user with valid credentials.
   * Test Setup: A dummy object of type User is declared within the setup method with the following
   *             data: User("UO004", "Ricky", "Jumar", "rjumar", "1234"). A result object of class User is
   *             returned after insertion to the database. The ReflectionEquals is used to compare the
   *             dummyUser object to the result object to determine if createUser was executed properly.
   * Test Strategy: Decision Table Testing
   * ID	            Condition/Action                    Test Case 1
   * Condition 1	  Valid Username	                        T
   * Condition 2	  Valid Password	                        T
   * Action 1	      User Created                         Execute
   * Action 2   	  Show a message displaying
   *                "Username or password is blank"
   * Input: Call to method createUser with dummyUser attributes.
   * Expected Output: Method call createUser returns an object of type User to be compared and display
   *                  message, "User Created.", is display to confirm the creation.
   */
  @Test
  @DisplayName("System shall allow for user creation.")
  void handleUserCreation() {
    User result = userCreation.createUser(dummyUser);

    assertTrue(new ReflectionEquals(dummyUser).matches(result));
  }

  /**
   * Test Case ID:
   * Requirement ID/Description: REQ-16 The system shall require that every username be distinct
   *                             from one another.
   * Purpose: The purpose is to test the system for exception handling when the user enters a username
   *          that current exists in the database.
   * Test Setup: A dummy object of type User is declared within the setup method with the following
   *             data: User("UO004", "Ricky", "Jumar", "rjumar", "1234"). The dummy User object is then
   *             created and stored to the database before the second user creation.
   * Test Strategy: Negative Testing
   * Input: Initial call to method createUser with dummyUser attributes. Second call to createUser
   *        with the same username attribute.
   * Expected Output: Method call createUser throws an exception: "Username cannot be a duplicate."
   *                  to prevent duplication of usernames.
   */
  @Test
  @DisplayName("System shall prevent duplicate usernames from existing")
  void handleDuplicateUsername() {
    userCreation.createUser(dummyUser);

    Exception exception =
        assertThrows(IllegalArgumentException.class, () -> userCreation.createUser(dummyUser));
    assertEquals("Username cannot be a duplicate.", exception.getMessage());
  }

  /**
   * Test Case ID:
   * ID/Description: REQ-2 The system shall store all user accounts in a database.
   * Purpose: The purpose is to test that the new user's data is stored to the database.
   * Test Setup: A dummy object of type User is declared within the setup method with the following
   *             data: User("UO004", "Ricky", "Jumar", "rjumar", "1234"). A current user object of
   *             type User is created data: User("rjumar", "1234"). Within the current user, a call to
   *             getUserInfo() method is created to retrieve the data from the database.
   * Testing Strategy: Positive Testing
   * Input: Initial call to method createUser with dummyUser attributes. New current user object of
   *        type User is created to retrieve database data.
   * Expected Output: Method call createUser returns an object of type User to be compared and display
   *                  message, "User Created.", is display to confirm the creation. The assertEquals
   *                  compared the dummy attributes from what currentUser retrieved from the database.
   */
  @Test
  @DisplayName("The user credentials should be stored within the database.")
  void handleDatabaseStorage() {

    userCreation.createUser(dummyUser);
    User currentUser = new User("rjumar", "1234");

    assertEquals(dummyUser.getUsername(), currentUser.getUsername());
    assertEquals(dummyUser.getPassword(), currentUser.getPassword());
    assertEquals(dummyUser.getFirstname(), currentUser.getFirstname());
    assertEquals(dummyUser.getLastname(), currentUser.getLastname());
    assertEquals(dummyUser.getId(), currentUser.getId());
  }
}
