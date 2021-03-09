import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SearchCustomerTest {
	private searchCustomer searchCustomer;
  private Customer customer;

  @BeforeEach
  public void setUp() {
    searchCustomer = new searchCustomer();
    customer = new Customer("CS001", "john", "Alex", "34232222", "3443", "Uk", null, "Male", "34324234", null);
  }

  @Test
  @DisplayName("Testing searchCustomer by last name.")
  void testSearchByLastnamePositive() {
	Customer customer = searchCustomer.findCustomerByLastName(this.customer.getLastname());
    assertEquals(customer.getFirstname(), customer.getFirstname());

  }

  @Test
  @DisplayName("Testing searhCustomer with no record being returned.")
  void testSearchByLastnameNegative() {
    Customer customer = searchCustomer.findCustomerByLastName(null);
    assertNull(customer);
  }
}
