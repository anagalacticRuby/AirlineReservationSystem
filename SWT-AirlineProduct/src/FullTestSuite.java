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
@SelectClasses({AddFlightUnitTest.class, AddFlightIntegrationTest.class, LoginUnitTest.class,
    userCreationTest.class, UserCreationIntegrationTest.class,MainUnitTest.class})
public class FullTestSuite {

}
