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
   * Test Case ID: Requirement: #4,The system shall require that every field is filled before
   * processing requests.
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
   * Test Case ID: Requirement ID/Description: REQ-5 The system shall require the user to create a
   * password for their profile. Purpose: Test setup: An object of the User class is created with
   * the id='CS001', firstname='john', lastname='Alex', nic=34232222, passport=3443, address=Uk,
   * dob='null', gender='Male', contact=3432434, photo='null' Test Strategy: ID Condition/Action
   * Test Case 1 Test Case 2 Condition 1 Valid Username T T Condition 2 Valid Password T F Action 1
   * User Created Execute Action 2 Show a message displaying 'Username or password cannot' Execute
   * be blank Input: Call method handleLoginEnter(null, "rjumar", "321", "Ravi", "Kumar", "UO004")
   * Expected Output: Method handleCreation return a object of User with password='321' that results
   * in a successful user creation.
   */
  @Test
  @DisplayName("User creation should be valid due to an full password.")
  void handleValidPWCreation() {
    User result = userCreation.createUser(dummyUser);

    assertEquals("1234", result.getPassword(), "Password matches.");
  }

  /**
   * Test Case ID: Requirement ID/Description: #16, The system shall require that every username be
   * distinct from one another.
   * This test class uses negative testing to validate that the exception is caught by a handler
   * and therefore will prevent users from having duplicate usernames.
   */
  @Test
  @DisplayName("System shall prevent duplicate usernames from existing")
  void handleDuplicateUsername() {
    Exception exception =
        assertThrows(IllegalArgumentException.class, () -> userCreation.createUser(dummyUser));
    assertEquals("Username cannot be a duplicate.", exception.getMessage());
  }



  /**
   * Test Case ID: Requirement ID/Description: REQ-9 The system shall save all user profiles in a
   * database.
   */
  @Test
  @DisplayName("The user credentials should be stored within the database.")
  void handleDatabaseStorage() {

    User newUser = new User("UO004","Ronald","Smith", "rsmith32","ronsmith" );
    userCreation.createUser(newUser);
    User currentUser = new User("rsmith32", "ronsmith");

    assertEquals(newUser.getUsername(), currentUser.getUsername());
    assertEquals(newUser.getPassword(), currentUser.getPassword());
    assertEquals(newUser.getFirstname(), currentUser.getFirstname());
    assertEquals(newUser.getLastname(), currentUser.getLastname());
    assertEquals(newUser.getId(), currentUser.getId());
  }


}
