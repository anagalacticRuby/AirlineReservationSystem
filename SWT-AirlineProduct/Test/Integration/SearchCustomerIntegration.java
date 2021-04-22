import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;

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
   *
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

  @Test
  @DisplayName("Mock for the update of customer functionality.")
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
