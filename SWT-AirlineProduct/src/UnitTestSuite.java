import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

/**
 * 
 */

/**
 * @author Nicholas Hansen
 *
 */
@RunWith(JUnitPlatform.class)
@SelectClasses({AddFlightUnitTest.class, LoginUnitTest.class, MainUnitTest.class, 
	SearchCustomerTest.class, userCreationTest.class, ticketUnitTest.class, addCustomerTest.class})
public class UnitTestSuite {

}
