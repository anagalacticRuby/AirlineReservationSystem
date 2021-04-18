
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * A utility class designed to facilitate easier connections to the 'airline' database.
 *
 */
public class DBUtil {

  // Declare JDBC Driver
  private final static String JDBC_DRIVER = "com.mysql.jdbc.Driver";

  // Connection
  private static Connection con = null;

  // Database Credentials
  private final static String DB_URL = "jdbc:mysql://localhost/airline";
  private final static String USER = "root";
  private final static String PASS = "";

  /**
   * Method used to connect to the database.
   *
   * @throws SQLException
   * @throws ClassNotFoundException
   */
  public static Connection dbConnect() {
    // Setting MySQL JDBC Driver
    try {
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
   */
  public static void dbDisconnect() {
    try {
      if (con != null && !con.isClosed()) {
        con.close();
        System.out.println("Connection closed.");
      }

    } catch (SQLException e) {
    }
  }

  /**
   * Method used to close the ResultSet.
   * 
   * @param rs ResultSet.
   */
  public static void closeResultSet(ResultSet rs) {
    try {
      rs.close();
      System.out.println("ResultSet closed.");
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  /**
   * Method used to close the PreparedStatement.
   * 
   * @param ps PreparedStatement.
   */
  public static void closePreparedStatement(PreparedStatement ps) {
    try {
      ps.close();
      System.out.println("PreparedStatement closed.");
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
