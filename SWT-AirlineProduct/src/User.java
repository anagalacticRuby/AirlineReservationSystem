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

  /**
   * User constructor used to create or store a new User.
   * @param username — String parameter used to hold a User's username.
   * @param password — String parameter used to hold a User's password.
   * @param firstname — String parameter used to hold a User's firstname.
   * @param lastname — String parameter used to hold a User's lastname.
   * @param id — String parameter used to hold a User's ID.
   */
  public User(String username, String password, String firstname, String lastname, String id) {
    this.username = username;
    this.password = password;
    this.firstname = firstname;
    this.lastname = lastname;
    this.id = id;
  }

  /**
   * User constructor used to create a new user.
   * @param username — String parameter used to hold a User's username.
   * @param password — String parameter used to hold a User's password.
   * @param firstname — String parameter used to hold a User's firstname.
   * @param lastname — String parameter used to hold a User's lastname.
   */
  public User(String username, String password, String firstname, String lastname) {
    this.username = username;
    this.password = password;
    this.firstname = firstname;
    this.lastname = lastname;
  }

  /**
   * User constructor used to obtain information pertaining to a User.
   * @param username — String parameter used to hold a User's username.
   * @param password — String parameter used to hold a User's password.
   */
  public User (String username, String password)  {
    this.username = username;
    this.password = password;

    getUserInfo();
  }

  /**
   * This method is called within the User constructor to obtain a User's username, password,
   * firstname, lastname, and id. The information is obtained using a SQL statement tied to the
   * username input.
   */
  public void getUserInfo() {
    Connection con = DBUtil.dbConnect();

    try {
      String sql = "SELECT * FROM USER WHERE USERNAME = ?";
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

  /**
   * Username Getter method.
   * @return username.
   */
  public String getUsername() {
    return username;
  }

  /**
   * Username Setter method.
   * @param username
   */
  public void setUsername(String username) {
    this.username = username;
  }

  /**
   * Password Getter method.
   * @return password.
   */
  public String getPassword() {
    return password;
  }

  /**
   * Password Setter method.
   * @param password
   */
  public void setPassword(String password) {
    this.password = password;
  }

  /**
   * Firstname Getter method.
   * @return firstname.
   */
  public String getFirstname() {
    return firstname;
  }

  /**
   * Firstname Setter method.
   * @param firstname
   */
  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  /**
   * Lastname Getter method.
   * @return lastname.
   */
  public String getLastname() {
    return lastname;
  }

  /**
   * Lastname Setter method.
   * @param lastname
   */
  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  /**
   * ID Getter method.
   * @return id.
   */
  public String getId() {
    return id;
  }

  /**
   * ID Setter method.
   * @param id
   */
  public void setId(String id) {
    this.id = id;
  }
}
