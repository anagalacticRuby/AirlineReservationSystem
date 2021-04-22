import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.internal.util.reflection.FieldSetter;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import com.toedter.calendar.JDateChooser;
/****************************************************************************************************************
 * Integration test for adding a flight from addflight class. In this test we mock the database connection,
 * prepared statement, and DBUtil class which allows for the connection to be opened and closed.
 * In this case we are passing in string type values that would normally be entered in to see 
 * if a flight gets added successfully and it does.
*****************************************************************************************************************/

public class AddCustomerIntegrationTest {

	@Test
	@DisplayName("Mocking the addCustomer functionality.")
	public void testAddCustomer() throws SQLException, NoSuchFieldException, SecurityException {
		addCustomer addCustomer = new addCustomer(true, false);
		
		JLabel txtid = Mockito.mock(JLabel.class);
		when(txtid.getText()).thenReturn("CS020");
		FieldSetter.setField(addCustomer, addCustomer.getClass().getDeclaredField("txtid"), txtid);
		
		JTextField txtfirstname = Mockito.mock(JTextField.class);
		when(txtfirstname.getText()).thenReturn("Peter");
		FieldSetter.setField(addCustomer, addCustomer.getClass().getDeclaredField("txtfirstname"), txtfirstname);
		
		JTextField txtlastname = Mockito.mock(JTextField.class);
		when(txtlastname.getText()).thenReturn("Parker");
		FieldSetter.setField(addCustomer, addCustomer.getClass().getDeclaredField("txtlastname"), txtlastname);
		
		JTextField txtnic = Mockito.mock(JTextField.class);
		when(txtnic.getText()).thenReturn("56155");
		FieldSetter.setField(addCustomer, addCustomer.getClass().getDeclaredField("txtnic"), txtnic);
		
		JTextField txtpassport = Mockito.mock(JTextField.class);
		when(txtpassport.getText()).thenReturn("56156");
		FieldSetter.setField(addCustomer, addCustomer.getClass().getDeclaredField("txtpassport"), txtpassport);
		
		JTextArea txtaddress = Mockito.mock(JTextArea.class);
		when(txtaddress.getText()).thenReturn("56151");
		FieldSetter.setField(addCustomer, addCustomer.getClass().getDeclaredField("txtaddress"), txtaddress);
		
		JDateChooser txtdob = Mockito.mock(JDateChooser.class);
		when(txtdob.getDate()).thenReturn(new Date());
		FieldSetter.setField(addCustomer, addCustomer.getClass().getDeclaredField("txtdob"), txtdob);
		
		JRadioButton r1 = Mockito.mock(JRadioButton.class);
		when(r1.isSelected()).thenReturn(true);
		FieldSetter.setField(addCustomer, addCustomer.getClass().getDeclaredField("r1"), r1);
		
		JTextField txtcontact = Mockito.mock(JTextField.class);
		when(txtcontact.getText()).thenReturn("245954891");
		FieldSetter.setField(addCustomer, addCustomer.getClass().getDeclaredField("txtcontact"), txtcontact);
		
		MockedStatic<DBUtil> staticClass = Mockito.mockStatic(DBUtil.class);

		Connection conn = Mockito.mock(Connection.class);
		PreparedStatement pst = Mockito.mock(PreparedStatement.class);
		when(DBUtil.dbConnect()).thenReturn(conn);
		
		when(conn.prepareStatement(Mockito.anyString())).thenReturn(pst);
		Statement statement = Mockito.mock(Statement.class);
		when(conn.createStatement()).thenReturn(statement);
		
		ResultSet rs = Mockito.mock(ResultSet.class);
		when(statement.executeQuery(Mockito.anyString())).thenReturn(rs);

		Customer customer = new Customer(txtid.getText(), txtfirstname.getText(), txtlastname.getText(), txtnic.getText(),
				txtpassport.getText(), txtaddress.getText(), txtdob.getDate(), r1.getText(), txtcontact.getText(), null);

		addCustomer.handleAddCustomer(customer);
		
		staticClass.close();
	}
}
