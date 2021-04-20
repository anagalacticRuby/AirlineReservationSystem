import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class ticketTest {
	private ticket ticket;
	
	@BeforeEach
	public void setUp() {
		ticket = new ticket();
	}
	
	@Test
	public void testAutoID() {
		ticket.autoID();
	}
}
