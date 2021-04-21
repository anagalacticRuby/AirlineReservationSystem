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

  @Test
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

  @Test
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
