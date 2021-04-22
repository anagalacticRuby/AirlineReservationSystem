import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ticketUnitTest {
	
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
