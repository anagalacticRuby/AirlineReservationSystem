import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ticketUnitTest {
	
	/**
	 * Test Case ID: UnitTest-Ticket-001
	 * Requirement ID/Description: REQ-11 The system shall allow a user to view every ticket entry
	 * stored in the database.
	 * Purpose: To ensure we can search for a ticket within the database, specifically in this test
	 * case by source and departure locations.
	 * Test Setup: A new ticket with specified source and departure locations we can search for.
	 * Test Strategy: A Unit Test with Input Validation to verify that the ticket has been
	 * found successfully.
	 * Input: A new ticket with specified source and departure locations.
	 * Expected Output: Verification that the ticket has been found.
	 */
	@Test
	@DisplayName("Test to ensure search functionality.")
	public void testSearchTicket() {
		ticket ticket = new ticket();
		ticket.txtsource.setSelectedItem("India");
		ticket.txtdepart.setSelectedItem("Uk");
		ticket.search(null);
		Assertions.assertTrue(ticket.jTable1.getModel().getRowCount() > 0);
	}
}
