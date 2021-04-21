import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Test;

public class addCustomerTest {

	@Test
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
		
		Integer i = addCustomer.addCustomer(null);
		assertNotNull(i);
		assertTrue(i==1);
	}
}
