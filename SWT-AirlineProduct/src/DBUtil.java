
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {

  // Declare JDBC Driver
  private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

  // Connection
  private static Connection con = null;

  // Database Credentials
  private static final String DB_URL = "jdbc:mysql://localhost/airline";
  private static final String USER = "root";
  private static final String PASS = "";

  /**
   * Method used to connect to the database.
   *
   * @throws SQLException
   * @throws ClassNotFoundException
   */
  public static Connection dbConnect() {
    //Setting MySQL JDBC Driver
    try{
      Class.forName(JDBC_DRIVER);
    } catch (ClassNotFoundException e) {
      System.out.println("Where is your JDBC Driver?");
      e.printStackTrace();
    }

    try {
      con = DriverManager.getConnection(DB_URL, USER, PASS);
    } catch (SQLException e) {
      System.out.println("Connection Failed! Check output console" + e);
      e.printStackTrace();
    }
    return con;
  }

  /**
   * Method used to disconnect to the database.
   *
   * @throws SQLException
   */
  public static void dbDisconnect(){
    try {
      if (con != null && !con.isClosed()) {
        con.close();
        System.out.println("Connection closed.");
      }

    } catch (SQLException e) {
    }
  }

  public static void closeResultSet(ResultSet rs) {
    try {
      rs.close();
      System.out.println("ResultSet closed.");
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public static void closePreparedStatement(PreparedStatement ps) {
    try {
      ps.close();
      System.out.println("PreparedStatement closed.");
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}