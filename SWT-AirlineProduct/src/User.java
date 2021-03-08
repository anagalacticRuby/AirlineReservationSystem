import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class User {

  private String username;
  private String password;
  private String firstname;
  private String lastname;
  private String id;

  public User(String username, String password, String firstname, String lastname, String id) {
    this.username = username;
    this.password = password;
    this.firstname = firstname;
    this.lastname = lastname;
    this.id = id;
  }

  public User (String username, String password)  {
    this.username = username;
    this.password = password;

    getUserInfo();
  }

  private void getUserInfo() {
    Connection con = DBUtil.dbConnect();

    try {
      String sql = "SELECT * FROM USERFi WHERE USERNAME = ?";
      PreparedStatement ps = con.prepareStatement(sql);
      ps.setString(1, username);

      ResultSet rs = ps.executeQuery();
      while(rs.next()){
        username = rs.getString("username");
        password = rs.getString("password");
        firstname = rs.getString("firstname");
        lastname = rs.getString("lastname");
        id = rs.getString("id");
      }
      DBUtil.closeResultSet(rs);
      DBUtil.closePreparedStatement(ps);
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    DBUtil.dbDisconnect();
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }
}
