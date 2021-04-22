import org.junit.jupiter.api.*;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(Lifecycle.PER_CLASS)
public class Performance {

  Main main;
  Login login;
  User user;
  Flight flight;
  Customer customer;
  userCreation userCreation;
  searchCustomer searchCustomer;
  addflight addflight;
  addCustomer addCustomer;

  @BeforeEach
  public void setUp() {
    login = new Login();
    login.setLoginValidity(true);
    main = new Main(true);
    addflight = new addflight();
    addCustomer = new addCustomer();
    userCreation = new userCreation();

  }

  @AfterEach
  public void tearDown() {
    deleteUser();
    deleteFlight();
    deleteCustomer();
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
  @DisplayName("Database Response Time for Logging into the System")
  public void databaseResponseTestLogin() {
    long start_time = System.currentTimeMillis();
    login.handleLoginEnter(null, "john", "123");
    long finish_time = System.currentTimeMillis();
    long duration = finish_time - start_time;
    assertTrue(duration <= 3000);
  }

  /**
   * Test Case ID: Requirement #15, The system shall take no longer than 3 seconds to perform
   * database operations.
   */
  @Test
  @DisplayName("Database Response Time for Adding Users")
  public void databaseResponseTestUserCreation() {
    long start_time = System.currentTimeMillis();
    user = new User("UO004", "Ricardo", "Montoya", "Rmontoya", "Montoya1");
    userCreation.createUser(user);
    long finish_time = System.currentTimeMillis();
    long duration = finish_time - start_time;
    assertTrue(duration <= 3000);
  }

  /**
   * Test Case ID: Requirement #15, The system shall take no longer than 3 seconds to perform
   * database operations.
   */
  @Test
  @DisplayName("Database Response Time for Adding Flight")
  public void databaseResponseAddFlight() {
    flight = new Flight("FO009", "JetBlue", "USA", "UK", "2021-09-13",
        "9:00AM", "10:00PM", "9000");
    long start_time = System.currentTimeMillis();
    addflight.addFlight(flight);
    long finish_time = System.currentTimeMillis();
    long duration = finish_time - start_time;
    assertTrue(duration <= 3000);
  }

  @Test
  @DisplayName("Database Response Time for Adding Customers ")
  public void databaseResponseAddCustomer() {
    addCustomer.userimage = new byte[0];
    customer = new Customer("CS010", "Peter", "Park", "415685486", "551513", "USA", new Date(), "Male",
        "123485495", addCustomer.userimage);

    long start_time = System.currentTimeMillis();
    addCustomer.handleAddCustomer(customer);
    long finish_time = System.currentTimeMillis();
    long duration = finish_time - start_time;
    assertTrue(duration <= 3000);
  }

  @Test
  @DisplayName("Database Response Time for Searching for Tickets")
  public void databaseResponseTicketSearch() {
    ticket ticket = new ticket();
    ticket.txtsource.setSelectedItem("India");
    ticket.txtdepart.setSelectedItem("Uk");
    long start_time = System.currentTimeMillis();
    ticket.search(null);
    long finish_time = System.currentTimeMillis();
    long duration = finish_time - start_time;
    assertTrue(duration <= 3000);
  }

  public void deleteUser() {
    Connection con = DBUtil.dbConnect();
    PreparedStatement pst;
    try {
      pst = con.prepareStatement("Delete from user where id=?");
      pst.setString(1, "UO004");
      pst.executeUpdate();
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  public void deleteFlight() {
    Connection con = DBUtil.dbConnect();
    PreparedStatement pst;
    try {
      pst = con.prepareStatement("Delete from flight where id=?");
      pst.setString(1, "FO009");
      pst.executeUpdate();
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  public void deleteCustomer() {
    Connection con = DBUtil.dbConnect();
    PreparedStatement pst;
    try {
      pst = con.prepareStatement("Delete from customer where id=?");
      pst.setString(1, "CS010");
      pst.executeUpdate();
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
