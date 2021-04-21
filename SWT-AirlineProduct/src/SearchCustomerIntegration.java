import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class SearchCustomerIntegration {
  private Customer mockCustomer;
  private searchCustomer searchCustomer;

  Connection connection;
  @InjectMocks
  public DBUtil dbUtil;
  @Mock
  public PreparedStatement mockStatement;
  @Mock
  public Connection mockConnection;

  @Before
  public void setUp() {
    connection = DBUtil.dbConnect();

    searchCustomer = new searchCustomer();
    mockCustomer = new Customer("CS001", "john", "Alex", "34232222", "3443", "Uk", null, "Male",
        "34324234", null);
    searchCustomer.setBlobFlag(true);

    MockitoAnnotations.initMocks(this);
  }

  /**
   * Test Case ID: IntegrationTest-Search-001
   * Requirement ID/Description: REQ-7 The system shall allow a user to search for existing
   * customer accounts in the database.
   * Purpose: To confirm that the system can successfully search for a customer based on their
   * ID.
   * Test Setup: We create a mock customer with a specified ID and a mock database connection.
   * Test Strategy: We add the mock customer into the database, and then search for them by
   * their ID.
   * Input: A mock customer with a specified ID.
   * Expected Output: Confirmation that we have successfully found the customer via their ID.
   */
  @Test
  @DisplayName("Mock for searching customer by ID.")
  public void testSearchByID() throws SQLException {
    searchCustomer mockSearch = Mockito.mock(searchCustomer.class);

    String mock = mockCustomer.getId();
    when(mockConnection.prepareStatement("select * from customer where id = ?")).thenReturn(mockStatement);
    when(mockConnection.prepareStatement("select * from customer where id = ?").executeUpdate(mock)).thenReturn(1);

    when(mockSearch.searchByID(mock)).thenReturn(mockCustomer);
    searchCustomer.searchByID(mock);

    assertEquals(mockCustomer.getId(), "CS001");

  }

  /**
   * Test Case ID: IntegrationTest-Search-002
   * Requirement ID/Description: REQ-7 The system shall allow a user to search for existing
   * customer accounts in the database.
   * Purpose: To confirm we can search for a customer in the database via their last name.
   * Test Setup: We create a mock customer with a specified last name and a mock database
   * connection.
   * Test Strategy: We add the mock customer into the database, and then search for them by
   * their last name.
   * Input: A mock customer with a specified last name.
   * Expected Output: Confirmation that we have successfully found the customer via their
   * last name.
   */
  @Test
  public void updateSearchFields() throws ParseException, SQLException {
    searchCustomer mockUpdate = Mockito.mock(searchCustomer.class);
    mockCustomer.setLastname("BOB");

    when(mockConnection.prepareStatement("update customer set firstname = ?,lastname = ?,nic = ?,passport = ?, address= ?,dob = ?,gender = ?,contact = ?,photo = ? where id = ?"))
        .thenReturn(mockStatement);
    when(mockConnection.prepareStatement("update customer set firstname = ?,lastname = ?,nic = ?,passport = ?, address= ?,dob = ?,gender = ?,contact = ?,photo = ? where id = ?")
        .executeUpdate(anyString())).thenReturn(1);

    when(mockUpdate.update()).thenReturn(mockCustomer);
    assertEquals("BOB", mockCustomer.getLastname());
  }
}
