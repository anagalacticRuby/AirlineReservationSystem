import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class Performance {

  Login login;
  userCreation userCreation;
  Main main;
  searchCustomer searchCustomer;
  User user;

  @BeforeEach
  public void setUp() {
    login = new Login();
    login.setLoginValidity(true);
    main = new Main(true);
    userCreation = new userCreation();
    searchCustomer = new searchCustomer();
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
   * Test Case ID:
   * Requirement ID/Description: REQ-15 The system shall take no more than three seconds to perform
   *                             database operations.
   * Purpose: To test that the response time is less than three seconds.
   * Test setup: System time before and after handleLoginEnter is established to determine the total
   *             time the system took. The assertTrue is used to compare the condition where the
   *             duration is less than 3000 milliseconds, 3 seconds.
   * Test Strategy: Positive Testing
   * Input: Call to handleLoginEnter is executed with valid credentials.
   * Expected Output: Method handleLoginEnter return an message: "Maximum number of attempts exceeded."
   *                  The login visibility is retrieved is false.
   */
  @Test
  @DisplayName("Database Response Time Test")
  public void databaseResponseTest() {
    long start_time = System.currentTimeMillis();
    login.handleLoginEnter(null, "john", "123");
    long finish_time = System.currentTimeMillis();
    long duration = finish_time - start_time;
    assertTrue(duration <= 3000);
  }

  @Test
  public void handleUserCreationSpeed() {
    long start_time = System.currentTimeMillis();
    user = new User("UO004", "Ricardo", "Montoya", "Rmontoya", "Montoya1");
    userCreation.createUser(user);
    long finish_time = System.currentTimeMillis();
    long duration = finish_time - start_time;
    assertTrue(duration <= 3000);
  }


}
