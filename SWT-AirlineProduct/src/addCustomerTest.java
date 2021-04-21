import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Test;

public class addCustomerTest {

	/**
	 * Test Case ID: UnitTest-AddCustomer-001
	 * Requirement ID/Description: REQ-29: The user shall be able to add customers.
	 * Purpose: To test if the user will be able to add a customer into the system successfully.
	 * Test Setup: The user creates a customer with the information required by the system.
	 * Test Strategy: We utilize a unit test that will confirm a customer has been created and
	 * added into the system successfully.
	 * Input: A new customer inputted by the user with the needed information.
	 * Expected Output: The system will confirm a customer has been added.
	 */
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
