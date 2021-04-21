import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockitoSession;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

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
   *
   * @throws SQLException
   */
  @Test
  public void closeStatement() throws SQLException {
    PreparedStatement statement = connection.prepareStatement("");
    DBUtil.closePreparedStatement(statement);
    assertTrue(statement.isClosed());
  }

  @Test
  public void closeResultSet() throws SQLException {
    when(resultSet.next()).thenReturn(false).thenReturn(false);
    DBUtil.closeResultSet(resultSet);
    assertEquals(false, resultSet.isClosed());
  }

  /**
   *
   * @throws Exception
   */
  @Test
  public void mockDBUtilConnection() throws Exception {
    when(mockConnection.prepareStatement("")).thenReturn(mockStatement);
    when(mockConnection.prepareStatement("").executeUpdate(Mockito.any())).thenReturn(0);
    int mockValue = mockStatement.executeUpdate();
    assertEquals(mockValue, 0);
    Mockito.verify(mockConnection.prepareStatement(""), Mockito.times(1));
  }
}
