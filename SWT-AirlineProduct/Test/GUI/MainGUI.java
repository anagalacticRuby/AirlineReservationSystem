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
   * Test Case ID: UnitTest-MainGUI-001
   * Requirement ID/Description: N/A
   * Purpose: To ensure that the GUI for the userMenu Screen works properly.
   * Test Setup: We simply run the program and verify the GUI for the specified screen is in
   * proper condition.
   * Test Strategy: A Unit Test where we run the program and verify everything is in order.
   * Input: Running the program.
   * Expected Output: A normal Login screen without any discrepancies.
   */
  @Test
  @DisplayName("GUI Test for menu click.")
  public void userMenu() {
    frameFixture.menuItem("user").click().requireVisible();
    frameFixture.cleanUp();
  }

  /**
   * Test Case ID: UnitTest-MainGUI-002
   * Requirement ID/Description: N/A
   * Purpose: To ensure that the GUI for the flightMenu Screen works properly.
   * Test Setup: We simply run the program and verify the GUI for the specified screen is in
   * proper condition.
   * Test Strategy: A Unit Test where we run the program and verify everything is in order.
   * Input: Running the program.
   * Expected Output: A normal Login screen without any discrepancies.
   */
  @Test
  @DisplayName("GUI Test for flight click.")
  public void flightMenu() {
    frameFixture.menuItem("customer").click().requireVisible();
    frameFixture.cleanUp();
  }

  /**
   * Test Case ID: UnitTest-MainGUI-003
   * Requirement ID/Description: N/A
   * Purpose: To ensure that the GUI for the ticketMenu Screen works properly.
   * Test Setup: We simply run the program and verify the GUI for the specified screen is in
   * proper condition.
   * Test Strategy: A Unit Test where we run the program and verify everything is in order.
   * Input: Running the program.
   * Expected Output: A normal Login screen without any discrepancies.
   */
  @Test
  @DisplayName("GUI Test for ticket click.")
  public void ticketMenu() {
    frameFixture.menuItem("ticket").click().requireVisible();
    frameFixture.cleanUp();
  }

  /**
   * Test Case ID: UnitTest-MainGUI-004
   * Requirement ID/Description: N/A
   * Purpose: To ensure that the GUI for the customerMenu Screen works properly.
   * Test Setup: We simply run the program and verify the GUI for the specified screen is in
   * proper condition.
   * Test Strategy: A Unit Test where we run the program and verify everything is in order.
   * Input: Running the program.
   * Expected Output: A normal Login screen without any discrepancies.
   */
  @Test
  @DisplayName("GUI Test for menu click.")
  public void customerMenu() {
    frameFixture.menuItem("customer").click().requireVisible();
    frameFixture.cleanUp();
  }
}
