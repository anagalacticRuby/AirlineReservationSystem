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


  @Test
  @DisplayName("Mock for closing prepare statement functionality.")
  public void closeStatement() throws SQLException {
    PreparedStatement statement = connection.prepareStatement("");
    DBUtil.closePreparedStatement(statement);
    assertTrue(statement.isClosed());
  }

  @Test
  @DisplayName("Mock for closing the resultSet.")
  public void closeResultSet() throws SQLException {
    when(resultSet.next()).thenReturn(false).thenReturn(false);
    DBUtil.closeResultSet(resultSet);
    assertEquals(false, resultSet.isClosed());
  }


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
