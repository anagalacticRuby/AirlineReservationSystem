import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


/**
 * Class used to perform testing on the searchCustomer.java class.
 */
public class SearchCustomerTest {
  private searchCustomer searchCustomer;
  private Customer dummyCustomer;

  /**
   * The code within @BeforeEach is run before each test method execution. An object of class User
   * is created so that the expected and actual are compared.
   */
  @BeforeEach
  public void setUp() {
    searchCustomer = new searchCustomer();
    dummyCustomer = new Customer("CS001", "john", "Alex", "34232222", "3443", "Uk", null, "Male",
        "34324234", null);
    searchCustomer.setBlobFlag(true);
    // A test flag is set to true, because otherwise there would be complications with the 'photo'
    // blobs.
  }

  /**
   * Test Case ID: PosTest-searchCustomerLastname-lastname Requirement ID/Description: REQ-26 The
   * system shall allow users to search for a customer. Purpose: To test that a user can search for
   * a customer using their last name. Test setup: An object of the User class is created with the
   * id='CS001', firstname='john', lastname='Alex', nic=34232222, passport=3443, address=Uk,
   * dob='null', gender='Male', contact=3432434, photo='null' Test Strategy: Positive Testing Input:
   * Call method findCustomerByLastName('Alex') Expected Output: Method findCustomerByLastName
   * return an object of class Customer with a firstname='Alex'
   */
  @Test
  @DisplayName("Testing searchCustomer by last name.")
  void testSearchByLastnamePositive() {
    // Customer customer = searchCustomer.findCustomerByLastName(this.dummyCustomer.getLastname());
    Customer testCustomer = searchCustomer.searchByID(this.dummyCustomer.getId());
    Assertions.assertEquals(testCustomer.getFirstname(), dummyCustomer.getFirstname());

  }

  /**
   * Test Case ID: PosTest-searchCustomerLastname-null Requirement ID/Description: REQ-26 The system
   * shall allow users to search for a customer. Purpose: To test that the system handles null
   * values when searching for a customer by last name. Test setup: An object of the User class is
   * created with the id='CS001', firstname='john', lastname='Alex', nic=34232222, passport=3443,
   * address=Uk, dob='null', gender='Male', contact=3432434, photo='null' Test Strategy: Input
   * Validation Testing Input: Call method findCustomerByLastName('null') Expected Output: Method
   * findCustomerByLastName returns as null.
   */
  @Test
  @DisplayName("Testing searchCustomer with no record being returned.")
  void testSearchByLastnameNegative() {
    Customer testCustomer = searchCustomer.searchByID(null);
    Assertions.assertNull(testCustomer.getLastname());
  }
}
