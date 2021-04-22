import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MainIntegrationTest {

  Main main;

  @Test
  public void handleInvalidAuthentication() {

    Main mockMain = Mockito.mock(Main.class);
    main = new Main(false);
    mockMain.setLoginFlag(false);
    when(mockMain.getLoginFlag()).thenReturn(false);

    assertEquals(main.getLoginFlag(), false);
  }

  @Test
  public void handleValidAuthentication() {
    Main mockMain = Mockito.mock(Main.class);
    main = new Main(true);
    mockMain.setLoginFlag(true);
    when(mockMain.getLoginFlag()).thenReturn(true);

    assertEquals(main.getLoginFlag(), true);
  }
}
