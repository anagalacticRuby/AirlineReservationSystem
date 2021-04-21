import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

public class ticketUnitTest {

	/**
	 * Test Case ID:
	 * Requirement ID/Description:
	 * Purpose:
	 * Test Setup:
	 * Test Strategy:
	 * Input:
	 */
	@Test
	public void testSearchTicket() {
		ticket ticket = new ticket();
		ticket.txtsource.setSelectedItem("India");
		ticket.txtdepart.setSelectedItem("Uk");
		ticket.search(null);
		assertTrue(ticket.jTable1.getModel().getRowCount() > 0);
	}
}
