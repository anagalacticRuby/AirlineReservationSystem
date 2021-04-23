import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JDesktopPane;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.Containers;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.junit.testcase.AssertJSwingJUnitTestCase;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserCreationGUI extends AssertJSwingJUnitTestCase {

  FrameFixture frameFixture;
  JDesktopPane pane;

  @BeforeEach
  @Override
  protected void onSetUp() {
    userCreation userCreation = GuiActionRunner.execute(userCreation::new);
    pane = new JDesktopPane();
    pane.add(userCreation);
    userCreation.setVisible(true);

    frameFixture = new FrameFixture(Containers.frameFor(userCreation));
    frameFixture.show();
  }

  /**
   * Test Case ID: IntegrationTest-UserCreate-001
   * Requirement ID/Description: REQ-4 The system shall require that every field is filled
   * before processing requests.
   * Purpose: To ensure that a user can be created within the database, and the GUI reacts
   * accordingly.
   * Test Setup: We input a new user with all the needed information.
   * Test Strategy: A GUI Test where we determine if the GUI reacts accordingly when the specified
   * process is executed.
   * Input: A new user with all of the specified fields.
   * Expected Output: Confirmation that the new user has been added, and the GUI reacting
   * as it should.
   */
  @Test
  @DisplayName("GUI Testing for user creation.")
  public void handleValidUserCreation() {

    User user = new User("UO004", "Ricardo", "Montoya", "Rmontoya", "Montoya1");

    frameFixture.textBox("firstname").setText(user.getFirstname());
    frameFixture.textBox("lastname").setText(user.getLastname());
    frameFixture.textBox("username").setText(user.getUsername());
    frameFixture.textBox("password").setText(user.getPassword());
    frameFixture.button("create").click();
    frameFixture.dialog().requireVisible();
    frameFixture.dialog().button().click();
    frameFixture.cleanUp();
  }

  /**
   * Test Case ID: IntegrationTest-UserCreate-002
   * Requirement ID/Description: REQ-16 The system shall require that every username be distinct
   * from one another.
   * Purpose: To ensure that a new user with a username that already exists is not allowed by the
   * system, and the GUI react accordingly.
   * Test Setup: We will create a new user, but with a username that is already within the
   * database.
   * Test Strategy: A GUI Test where we determine if the GUI reacts accordingly when the specified
   * process is executed.
   * Input: A new user with a username that has already been entered into the database.
   * Expected Output: An exception telling the user that duplicate usernames are not allowed, and
   * the GUI reacting as it should.
   */
  @Test
  @DisplayName("GUI Testing for duplicate user creation.")
  public void handleDuplicateUserCreation() {
    User user = new User("john", "123");

    frameFixture.textBox("firstname").setText(user.getFirstname());
    frameFixture.textBox("lastname").setText(user.getLastname());
    frameFixture.textBox("username").setText(user.getUsername());
    frameFixture.textBox("password").setText(user.getPassword());
    frameFixture.button("create").click();
    frameFixture.dialog().requireVisible();
    frameFixture.dialog().button().click();
    frameFixture.cleanUp();
  }


  @AfterEach
  public void clear() {
    Connection con = DBUtil.dbConnect();
    PreparedStatement pst;

    try {
      pst = con.prepareStatement("Delete from user where id=?");
      /*
       * SQL will know what rows to delete based on the condition. Because all of the dummyUser
       * objects have the same ID, we are able to delete them before the next test is run, and
       * therefore do not require hundreds of dummy items.
       */
      pst.setString(1, "UO004");
      pst.executeUpdate();
      // Execute the delete operation on the database
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
