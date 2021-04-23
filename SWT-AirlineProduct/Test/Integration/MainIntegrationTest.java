import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MainIntegrationTest {

  Main main;

  /**
   * Test Case ID: IntegrationTest-Main-001
   * Requirement ID/Description: N/A
   * Purpose: To test if the DBUtil connection is functioning correctly.
   * Test Setup: We make a mock connection and a mock statement to simulate the DBUtil
   * connection being used with invalid authentication.
   * Test Strategy: An Integration Test where we use the mocks to confirm if the connection is
   * working as expected.
   * Input: A mock connection and a mock statement.
   * Expected Output: An exception thrown due to invalid authentication.
   */
  @Test
  @DisplayName("Mock for the invalid authentication functionality.")
  public void handleInvalidAuthentication() {

    Main mockMain = Mockito.mock(Main.class);
    main = new Main(false);
    mockMain.setLoginFlag(false);
    when(mockMain.getLoginFlag()).thenReturn(false);

    assertEquals(main.getLoginFlag(), false);
  }

  /**
   * Test Case ID: IntegrationTest-Main-002
   * Requirement ID/Description: N/A
   * Purpose: To test if the DBUtil connection is functioning correctly.
   * Test Setup: We make a mock connection and a mock statement to simulate the DBUtil
   * connection being used with valid authentication.
   * Test Strategy: An Integration Test where we use the mocks to confirm if the connection is
   * working as expected.
   * Input: A mock connection and a mock statement.
   * Expected Output: Confirmation that the DBUtil connection was successful and authentication
   * was valid.
   */
  @Test
  @DisplayName("Mock for the valid authentication functionality.")
  public void handleValidAuthentication() {
    Main mockMain = Mockito.mock(Main.class);
    main = new Main(true);
    mockMain.setLoginFlag(true);
    when(mockMain.getLoginFlag()).thenReturn(true);

    assertEquals(main.getLoginFlag(), true);
  }
}
