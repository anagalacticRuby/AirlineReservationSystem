import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class Performance {

  Login login;
  userCreation userCreation;
  Main main;
  searchCustomer searchCustomer;
  User user;

  @BeforeEach
  public void setUp() {
    login = new Login();
    login.setLoginValidity(true);
    main = new Main(true);
    userCreation = new userCreation();
    searchCustomer = new searchCustomer();
    user = new User("UO004", "Ricardo", "Montoya", "Rmontoya", "Montoya1");
  }

  @AfterEach
  public void tearDown() {
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


  @Test
  public void handleUserCreationSpeed() {
    userCreation.createUser(user);

  }





}
