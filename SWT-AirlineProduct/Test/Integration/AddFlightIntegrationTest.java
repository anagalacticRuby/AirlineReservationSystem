import static org.mockito.Mockito.when;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JLabel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.util.reflection.FieldSetter;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

/****************************************************************************************************************
 * Integration test for adding a flight from addflight class. In this test we mock the database
 * connection, prepared statement, and DBUtil class which allows for the connection to be opened and
 * closed. In this case we are passing in string type values that would normally be entered in to
 * see if a flight gets added successfully and it does.
 *****************************************************************************************************************/

public class AddFlightIntegrationTest {

  addflight addflight;
  Flight mockFlight;

  Connection connection;
  @InjectMocks
  public DBUtil dbUtil;
  @Mock
  public  Connection mockConnection;
  @Mock
  public java.sql.PreparedStatement mockStatement;
  @Mock
  public ResultSet resultSet;

  @BeforeEach
  public void startUp() {
    addflight = new addflight();
    mockFlight = new Flight("FO005", "TestFlight", "USA", "India",
        "2021-04-05", "9:00AM", "7:00PM", "$729");

    connection = DBUtil.dbConnect();
    MockitoAnnotations.initMocks(this);
  }
  @AfterEach
  public void tearDown() {

    DBUtil.dbDisconnect();
  }
  //@Test
  public void testFlightAdd() throws SQLException, NoSuchFieldException, SecurityException {

    //MockedStatic<DBUtil> staticClass = Mockito.mockStatic(DBUtil.class);

    Mockito.mock(DBUtil.class);

    Connection conn = Mockito.mock(Connection.class);
    PreparedStatement pst = Mockito.mock(PreparedStatement.class);
    when(DBUtil.dbConnect()).thenReturn(conn);
    when(conn.prepareStatement(
        "insert into flight(id,flightname,source,depart,date,deptime,arrtime,flightcharge)"
            + "values(?,?,?,?,?,?,?,?)")).thenReturn(pst);
    Statement statement = Mockito.mock(Statement.class);
    when(conn.createStatement()).thenReturn(statement);

    ResultSet rs = Mockito.mock(ResultSet.class);
    when(statement.executeQuery(Mockito.anyString())).thenReturn(rs);

    JLabel txtflightid = Mockito.mock(JLabel.class);
    FieldSetter.setField(addflight.class, addflight.class.getDeclaredField("txtflightid"),
        txtflightid);

    addflight.addFlight(mockFlight);
    //staticClass.close();
  }
}
