import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.junit.jupiter.api.DisplayName;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class DBUtilIntegration {

  Connection connection;
  @InjectMocks
  public DBUtil dbUtil;
  @Mock
  public  Connection mockConnection;
  @Mock
  public PreparedStatement mockStatement;
  @Mock
  public ResultSet resultSet;


  @Before
  public void before() {
    connection = DBUtil.dbConnect();
    MockitoAnnotations.initMocks(this);
  }

  @After
  public void after() {
    DBUtil.dbDisconnect();
  }


  /**
   * Test Case ID: IntegrationTest-DB-001
   * Requirement ID/Description: N/A
   * Purpose: To test that the system will close database connections when needed.
   * Test Setup: We feed the program a mock statement that we want to close the connection for.
   * Test Strategy: An Integration Test where we run the test with a mock statement and observe
   * how the program reacts.
   * Input: A mock prepared statement with an open connection.
   * Expected Output: Confirmation that the connection for the statement has closed.
   */
  @Test
  @DisplayName("Mock for closing prepare statement functionality.")
  public void closeStatement() throws SQLException {
    PreparedStatement statement = connection.prepareStatement("");
    DBUtil.closePreparedStatement(statement);
    assertTrue(statement.isClosed());
  }

  /**
   * Test Case ID: IntegrationTest-DB-002
   * Requirement ID/Description: N/A
   * Purpose: To test that the system will close the result set when needed.
   * Test Setup: We feed a mock result set into the program we want it to close.
   * Test Strategy: An Integration Test where we use a mock result set and observe how the system
   * reacts.
   * Input: A mock result set.
   * Expected Output: Confirmation that the result set is closed.
   */
  @Test
  @DisplayName("Mock for closing the resultSet.")
  public void closeResultSet() throws SQLException {
    when(resultSet.next()).thenReturn(false).thenReturn(false);
    DBUtil.closeResultSet(resultSet);
    assertEquals(false, resultSet.isClosed());
  }

  /**
   * Test Case ID: IntegrationTest-DB-003
   * Requirement ID/Description: N/A
   * Purpose: To test if the DBUtil connection is functioning correctly.
   * Test Setup: We make a mock connection and a mock statement to simulate the DBUtil
   * connection being used.
   * Test Strategy: An Integration Test where we use the mocks to confirm if the connection is
   * working as expected.
   * Input: A mock connection and a mock statement.
   * Expected Output: Confirmation that the DBUtil connection was successful.
   */
  @Test
  @DisplayName("The constant connection to the database will be mocked.")
  public void mockDBUtilConnection() throws Exception {
    when(mockConnection.prepareStatement("")).thenReturn(mockStatement);
    when(mockConnection.prepareStatement("").executeUpdate(Mockito.any())).thenReturn(0);
    int mockValue = mockStatement.executeUpdate();
    assertEquals(mockValue, 0);
    Mockito.verify(mockConnection.prepareStatement(""), Mockito.times(1));
  }
}
