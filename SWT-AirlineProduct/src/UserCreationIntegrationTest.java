
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.OngoingStubbing;

@RunWith(MockitoJUnitRunner.class)
public class UserCreationIntegrationTest {

  private User tempUser;
  private userCreation userCreation;

  /**
   * The code within @BeforeEach is run before each test method execution. An object of class User is
   * created so that the expected and actual are compared.
   */
  @BeforeEach
  public void setUp() {
    tempUser = new User("Rmontoya", "1234", "Ricardo", "Montoya", "UO014");
    userCreation = new userCreation();
  }

  /**
   *
   */
  @Test()
  public void mockDuplicateUsername(){
    userCreation mockCreation = Mockito.mock(userCreation.class);
    Exception exception = new NullPointerException("Username cannot be a duplicate.");
    when(mockCreation.handleCreation(null, "Rmontoya", "1234", "Ricardo",
        "Montoya", "UO014")).thenThrow(exception);

    assertEquals("Username cannot be a duplicate.", exception.getMessage() );
  }
}



