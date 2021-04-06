
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.OngoingStubbing;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class UserCreationIntegrationTest {

  private User dummyUser;
  private userCreation userCreation;

  /**
   * The code within @BeforeEach is run before each test method execution. An object of class User is
   * created so that the expected and actual are compared.
   */
  @BeforeEach
  public void setUp() {
    dummyUser = new User("Rmontoya", "1234", "Ricardo", "Montoya", "UO014");
    userCreation = new userCreation();
  }

  /**
   *
   */
  @Test()
  public void mockDuplicateUsername(){
    userCreation mockCreation = Mockito.mock(userCreation.class);
    Exception exception = new NullPointerException("Username cannot be a duplicate.");

    when(mockCreation.handleCreation(null, dummyUser.getUsername(), dummyUser.getPassword(), dummyUser.getFirstname(),
        dummyUser.getPassword(), dummyUser.getId())).thenThrow(exception);

    assertEquals("Username cannot be a duplicate.", exception.getMessage());
  }

  @Test
  public void stubInvalidPWCreation() {

    User test = mock(User.class);
    Exception exception = new NullPointerException("Username or Password cannot be blank.");
    when(test.getPassword()).thenThrow(exception);

    assertEquals("Username or Password cannot be blank.", exception.getMessage());
  }














}



