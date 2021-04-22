import static org.mockito.Mockito.when;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.internal.util.reflection.FieldSetter;
import com.mysql.jdbc.PreparedStatement;

public class ticketIntegrationTest {
	
	@Test
	@DisplayName("Mocking the search ticket functionality.")
	public void testSearchTicket() throws NoSuchFieldException, SecurityException, SQLException {
		ticket ticket = new ticket(true, false);
		
		JComboBox<String> txtsource = Mockito.mock(JComboBox.class);
		when(txtsource.getSelectedItem()).thenReturn("");
		FieldSetter.setField(ticket, ticket.getClass().getDeclaredField("txtsource"), txtsource);
		
		JComboBox<String> txtdepart = Mockito.mock(JComboBox.class);
		when(txtdepart.getSelectedItem()).thenReturn("");
		FieldSetter.setField(ticket, ticket.getClass().getDeclaredField("txtdepart"), txtdepart);		
		
		
		MockedStatic<DBUtil> staticClass = Mockito.mockStatic(DBUtil.class);

		Connection conn = Mockito.mock(Connection.class);
		PreparedStatement pst = Mockito.mock(PreparedStatement.class);
		when(DBUtil.dbConnect()).thenReturn(conn);
		
		when(conn.prepareStatement(Mockito.anyString())).thenReturn(pst);
		ResultSet rs = Mockito.mock(ResultSet.class);
		when(pst.executeQuery()).thenReturn(rs);
		
		ResultSetMetaData rsm = Mockito.mock(ResultSetMetaData.class);
		when(rs.getMetaData()).thenReturn(rsm);
		when(rsm.getColumnCount()).thenReturn(1);
		
		JTable jTable1 = Mockito.mock(JTable.class);
		DefaultTableModel Df = Mockito.mock(DefaultTableModel.class);
		when(jTable1.getModel()).thenReturn(Df);
		
		when(rs.next()).thenReturn(true).thenReturn(false);
		
		when(rs.getString("id")).thenReturn("CS000");
		when(rs.getString("flightname")).thenReturn("");
		when(rs.getString("source")).thenReturn("");
		when(rs.getString("depart")).thenReturn("");
		when(rs.getString("date")).thenReturn("");
		when(rs.getString("deptime")).thenReturn("");
		when(rs.getString("arrtime")).thenReturn("");
		when(rs.getString("flightcharge")).thenReturn("");
		
		ticket.search(null);
		
		staticClass.close();
	}
}
