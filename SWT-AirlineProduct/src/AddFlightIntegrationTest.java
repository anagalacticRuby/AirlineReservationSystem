import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import com.mysql.jdbc.PreparedStatement;
/****************************************************************************************************************
 * Integration test for adding a flight from addflight class. In this test we mock the database connection,
 * prepared statement, and DBUtil class which allows for the connection to be opened and closed.
 * In this case we are passing in string type values that would normally be entered in to see 
 * if a flight gets added successfully and it does.
*****************************************************************************************************************/

public class AddFlightIntegrationTest {

	@Test
	public void testFlightAdd() throws SQLException {
		addflight addflight = new addflight();
		String id = "FO005";
		String flightname = "Test Flight";
		String source = "USA";
		String depart = "India";
		String date = "04/05/2021";
		String departtime = "9:00 AM";
		String arrtime = "7:00 PM";
		String flightcharge = "$729";

    Mockito.mockStatic(DBUtil.class);

    Connection conn = Mockito.mock(Connection.class);
    PreparedStatement pst = Mockito.mock(PreparedStatement.class);
    when(DBUtil.dbConnect()).thenReturn(conn);
    when(conn.prepareStatement(
        "insert into flight(id,flightname,source,depart,date,deptime,arrtime,flightcharge)"
        + "values(?,?,?,?,?,?,?,?)"))
            .thenReturn(pst);
    addflight.addFlight(id, flightname, source, depart, 
        date, departtime, arrtime, flightcharge);
  }
}
