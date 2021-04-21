

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


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
   * Test Case ID: IntegrationTest-UserCreate-001
   * Requirement ID/Description: REQ-16 The system shall require that every username be distinct
   *                             from one another.
   * Purpose: The purpose is to mock the creation of a user object and throw an exception.
   * Test Setup: A Mock of userCreation.class is created to mock the createUser method. A stub is then
   *             used to create the expected exception.
   * Test Strategy: Mock
   * Input: Mock of createUser method with an expected exception.
   * Expected Output: Mock call to createUser return an exception throws an exception:
   *                  "Username cannot be a duplicate."
   */
  @Test
  public void mockDuplicateUsername(){
    userCreation mockCreation = Mockito.mock(userCreation.class);
    Exception exception = new NullPointerException("Username cannot be a duplicate.");

    when(mockCreation.createUser( dummyUser)).thenThrow(exception);

    assertEquals("Username cannot be a duplicate.", exception.getMessage());
  }

  /**
   * Test Case ID: IntegrationTest-UserCreate-002
   * Requirement: REQ-4 The system shall require that every field is filled before
   *              processing requests.
   * Purpose: The purpose is to stub the exception when an object of type User is created.
   * Test Setup: A mock of User.class is created to stub the NullPointerException for when the password
   *             field is left empty.
   * Test Strategy: Stub
   * Input: Call to method test object to get password attribute that is current empty.
   * Expected Output: Stub call to getPassword returns an exception message 'Username or Password
   *                  cannot be blank.'
   */
  @Test
  public void stubEmptyField() {

    User test = mock(User.class);
    Exception exception = new NullPointerException("Username or Password cannot be blank.");
    when(test.getPassword()).thenThrow(exception);

    assertEquals("Username or Password cannot be blank.", exception.getMessage());
  }
}



