import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.junit.testcase.AssertJSwingJUnitTestCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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

  /**
   * Test Case ID: GUITest-MainGUI-001
   * Requirement ID/Description: N/A
   * Purpose: To ensure that the GUI for the userMenu Screen is displayed properly when the
   * specified button is selected.
   * Test Setup: We simply run the program and click the necessary button to verify that
   * the userMenu screen appears.
   * Test Strategy: A GUI Test where we run the program and verify action events are working
   * properly.
   * Input: Running the program.
   * Expected Output: The userMenu screen will appear without issue.
   */
  @Test
  @DisplayName("GUI Test for menu click.")
  public void userMenu() {
    frameFixture.menuItem("user").click().requireVisible();
    frameFixture.cleanUp();
  }

  /**
   * Test Case ID: GUITest-MainGUI-002
   * Requirement ID/Description: N/A
   * Purpose: To ensure that the GUI for the flightMenu Screen is displayed properly when the
   * specified button is selected.
   * Test Setup: We simply run the program and click the necessary button to verify that
   * the flightMenu screen appears.
   * Test Strategy: A GUI Test where we run the program and verify action events are working
   * properly.
   * Input: Running the program.
   * Expected Output: The flightMenu screen will appear without issue.
  @Test
  @DisplayName("GUI Test for flight click.")
  public void flightMenu() {
    frameFixture.menuItem("customer").click().requireVisible();
    frameFixture.cleanUp();
  }

  /**
   * Test Case ID: GUITest-MainGUI-003
   * Requirement ID/Description: N/A
   * Purpose: To ensure that the GUI for the ticketMenu Screen is displayed properly when the
   * specified button is selected.
   * Test Setup: We simply run the program and click the necessary button to verify that
   * the ticketMenu screen appears.
   * Test Strategy: A GUI Test where we run the program and verify action events are working
   * properly.
   * Input: Running the program.
   * Expected Output: The ticketMenu screen will appear without issue.
  @Test
  @DisplayName("GUI Test for ticket click.")
  public void ticketMenu() {
    frameFixture.menuItem("ticket").click().requireVisible();
    frameFixture.cleanUp();
  }

 /**
   * Test Case ID: GUITest-MainGUI-004
   * Requirement ID/Description: N/A
   * Purpose: To ensure that the GUI for the customerMenu Screen is displayed properly when the
   * specified button is selected.
   * Test Setup: We simply run the program and click the necessary button to verify that
   * the customerMenu screen appears.
   * Test Strategy: A GUI Test where we run the program and verify action events are working
   * properly.
   * Input: Running the program.
   * Expected Output: The customerMenu screen will appear without issue.
  @Test
  @DisplayName("GUI Test for menu click.")
  public void customerMenu() {
    frameFixture.menuItem("customer").click().requireVisible();
    frameFixture.cleanUp();
  }
}
