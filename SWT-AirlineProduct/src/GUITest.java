import java.awt.AWTException;
import java.awt.Component;
import java.awt.Robot;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import org.junit.Test;

public class GUITest {

  /**
   * Test Case ID: UnitTest-GUI-001
   * Requirement ID/Description: N/A
   * Purpose: To ensure that the GUI for the Login Screen works properly.
   * Test Setup: We simply run the program and verify the GUI for the specified screen is in
   * proper condition.
   * Test Strategy: A Unit Test where we run the program and verify everything is in order.
   * Input: Running the program.
   * Expected Output: A normal Login screen without any discrepancies.
   */
  @Test
  public void testLogin() throws AWTException {
    Login login = new Login();
    login.main(null);
    Robot bot = new Robot();
    Component[] componentsList = login.getComponents();

    for (Component component : componentsList) {
      if (component instanceof JRootPane) {
        Component[] paneComponents = ((JRootPane) component).getComponents();
        for (Component paneComponent : paneComponents) {
          if (paneComponent instanceof JLayeredPane) {
            Component[] panelComponents = ((JLayeredPane) paneComponent).getComponents();
            for (Component panelComponent : panelComponents) {
              if (panelComponent instanceof JPanel) {
                Component[] panelComponentsOne = ((JPanel) panelComponent).getComponents();
                for (Component panelComponentOne : panelComponentsOne) {
                  if (panelComponentOne instanceof JPanel) {
                    Component[] panelComponentsTwo = ((JPanel) panelComponentOne).getComponents();
                    for (Component panelComponentTwo : panelComponentsTwo) {
                      if (panelComponentTwo instanceof JButton
                          && ((JButton) panelComponentTwo).getText().equalsIgnoreCase("Login")) {
                        bot.mouseMove(login.getX() + panelComponentTwo.getX(),
                            login.getY() + panelComponentTwo.getY());
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }

    System.out.println();
  }
}
