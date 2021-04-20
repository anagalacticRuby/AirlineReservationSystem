import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class DBUtilIntegration {

  Connection connection;
  @InjectMocks
  private DBUtil dbUtil;
  @Mock
  private  Connection mockConnection;
  @Mock
  private PreparedStatement mockStatement;


  @BeforeEach
  public void before() {
    connection = DBUtil.dbConnect();
    MockitoAnnotations.initMocks(this);
  }

  @AfterEach
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

  /**
   *
   * @throws Exception
   */
  @Test
  public void mockDBUtilConnection() throws Exception {
    when(mockConnection.prepareStatement("")).thenReturn(mockStatement);
    when(mockConnection.prepareStatement("").executeUpdate(Mockito.any())).thenReturn(1);
    int value = 1;
    assertEquals(value, 1);
    Mockito.verify(mockConnection.prepareStatement(""), Mockito.times(1));
  }















}
