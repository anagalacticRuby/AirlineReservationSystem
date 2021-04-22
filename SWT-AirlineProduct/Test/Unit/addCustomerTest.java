import java.util.Date;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.*;

public class addCustomerTest {

	@Test
	@DisplayName("Customer creation should be executed.")
	public void testAddCustomer() {
		addCustomer addCustomer = new addCustomer();
		addCustomer.txtaddress.setText("Test");
		addCustomer.txtcontact.setText("1");
		addCustomer.txtfirstname.setText("Test");
		addCustomer.txtlastname.setText("Test");
		addCustomer.txtnic.setText("Test");
		addCustomer.txtpassport.setText("Test");
		addCustomer.txtdob.setDate(new Date());
		addCustomer.userimage = new byte[0];
		
		int i = addCustomer.prepareCustomer(null);
		assertNotNull(i);
		assertEquals(1, i);
	}
}
