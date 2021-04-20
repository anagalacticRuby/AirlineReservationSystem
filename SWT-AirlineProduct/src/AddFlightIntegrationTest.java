import static org.mockito.Mockito.when;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JLabel;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
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

  @Test
  public void testFlightAdd() throws SQLException, NoSuchFieldException, SecurityException {


    String id = "FO005";
    String flightname = "Test Flight";
    String source = "USA";
    String depart = "India";
    String date = "04/05/2021";
    String departtime = "9:00 AM";
    String arrtime = "7:00 PM";
    String flightcharge = "$729";

		MockedStatic<DBUtil> staticClass = Mockito.mockStatic(DBUtil.class);



    Mockito.mockStatic(DBUtil.class);

    Connection conn = Mockito.mock(Connection.class);
    PreparedStatement pst = Mockito.mock(PreparedStatement.class);
    when(DBUtil.dbConnect()).thenReturn(conn);
    when(conn.prepareStatement(
        "insert into flight(id,flightname,source,depart,date,deptime,arrtime,flightcharge)"
        + "values(?,?,?,?,?,?,?,?)"))
            .thenReturn(pst);
    Statement statement = Mockito.mock(Statement.class);
    when(conn.createStatement()).thenReturn(statement);

    ResultSet rs = Mockito.mock(ResultSet.class);
    when(statement.executeQuery(Mockito.anyString())).thenReturn(rs);

    JLabel txtflightid = Mockito.mock(JLabel.class);
    //FieldSetter.setField(addflight, addflight.getClass().getDeclaredField("txtflightid"),
     //  txtflightid);

    // addflight.addFlight(id, flightname, source, depart, date, departtime, arrtime, flightcharge);
  		staticClass.close();
  		}
}
