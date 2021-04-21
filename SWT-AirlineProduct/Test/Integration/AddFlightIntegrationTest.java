
import static org.mockito.Mockito.when;
import com.toedter.calendar.JDateChooser;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.internal.util.reflection.FieldSetter;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

/****************************************************************************************************************
 * Integration test for adding a flight from addflight class. In this test we mock the database
 * connection, prepared statement, and DBUtil class which allows for the connection to be opened and
 * closed. In this case we are passing in string type values that would normally be entered in to
 * see if a flight gets added successfully and it does.
 *****************************************************************************************************************/

public class AddFlightIntegrationTest {

  addflight addflight;
  Flight mockFlight;

  @BeforeEach
  public void startUp() {
    addflight = new addflight();
    mockFlight = new Flight("FO010", "TestFlight", "USA", "India",
        "2021-04-05", "9:00AM", "7:00PM", "$729");

  }

  @Test
  public void handleFlightAdd() throws SQLException, NoSuchFieldException, ParseException {
    JLabel txtFlightID = Mockito.mock(JLabel.class);
    when(txtFlightID.getText()).thenReturn(mockFlight.getId());
    FieldSetter.setField(addflight, addflight.getClass().getDeclaredField("txtflightid"), txtFlightID);

    JTextField txtFlightName = Mockito.mock(JTextField.class);
    when(txtFlightName.getText()).thenReturn(mockFlight.getFlightName());
    FieldSetter.setField(addflight, addflight.getClass().getDeclaredField("txtflightname"), txtFlightName);

    JComboBox txtSource = Mockito.mock(JComboBox.class);
    when(txtSource.getActionCommand()).thenReturn(mockFlight.getSource());
    FieldSetter.setField(addflight, addflight.getClass().getDeclaredField("txtsource"), txtSource);

    JComboBox txtDepart = Mockito.mock(JComboBox.class);
    when(txtDepart.getActionCommand()).thenReturn(mockFlight.getDepart());
    FieldSetter.setField(addflight, addflight.getClass().getDeclaredField("txtdepart"), txtDepart);

    JDateChooser txtDate = Mockito.mock(JDateChooser.class);
    when(txtDate.getDate()).thenReturn(new Date());
    FieldSetter.setField(addflight, addflight.getClass().getDeclaredField("txtdate"), txtDate);


    JTextField txtDepartTme = Mockito.mock(JTextField.class);
    when(txtDepartTme.getText()).thenReturn(mockFlight.getDepartTime());
    FieldSetter.setField(addflight, addflight.getClass().getDeclaredField("txtdtime"), txtDepartTme);

    JTextField txtArrivalTime = Mockito.mock(JTextField.class);
    when(txtArrivalTime.getText()).thenReturn(mockFlight.getArrivalTime());
    FieldSetter.setField(addflight, addflight.getClass().getDeclaredField("txtarrtime"), txtArrivalTime);

    JTextField txtFlightCharge = Mockito.mock(JTextField.class);
    when(txtFlightCharge.getText()).thenReturn(mockFlight.getFlightCharge());
    FieldSetter.setField(addflight, addflight.getClass().getDeclaredField("txtflightcharge"), txtFlightCharge);

    MockedStatic<DBUtil> staticClass = Mockito.mockStatic(DBUtil.class);

    Connection conn = Mockito.mock(Connection.class);
    PreparedStatement pst = Mockito.mock(PreparedStatement.class);
    when(DBUtil.dbConnect()).thenReturn(conn);

    when(conn.prepareStatement(Mockito.anyString())).thenReturn(pst);
    Statement statement = Mockito.mock(Statement.class);
    when(conn.createStatement()).thenReturn(statement);

    ResultSet rs = Mockito.mock(ResultSet.class);
    when(statement.executeQuery(Mockito.anyString())).thenReturn(rs);

    Flight flight = new Flight(txtFlightID.getText(), txtFlightName.getText(), txtSource.getActionCommand(),
        txtDepart.getActionCommand(), txtDate.getDate().toString(), txtDepartTme.getText(),
        txtArrivalTime.getText(), txtFlightCharge.getText());


    addflight.addFlight(flight);

    staticClass.close();
  }


}
