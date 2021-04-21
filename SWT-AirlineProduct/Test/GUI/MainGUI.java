import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.junit.testcase.AssertJSwingJUnitTestCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MainGUI extends AssertJSwingJUnitTestCase {

  FrameFixture frameFixture;

  @BeforeEach
  @Override
  protected void onSetUp() throws Exception {
    Main main = new Main(true);
    Login login = new Login();
    login.setLoginValidity(true);
    frameFixture = new FrameFixture(main);
    frameFixture.show();
  }

  @Test
  public void userMenu() {
    frameFixture.menuItem("user").click().requireVisible();
    frameFixture.cleanUp();
  }

  @Test
  public void flightMenu() {
    frameFixture.menuItem("customer").click().requireVisible();
    frameFixture.cleanUp();
  }

  @Test
  public void ticketMenu() {
    frameFixture.menuItem("ticket").click().requireVisible();
    frameFixture.cleanUp();
  }

  @Test
  public void customerMenu() {
    frameFixture.menuItem("customer").click().requireVisible();
    frameFixture.cleanUp();
  }
}
