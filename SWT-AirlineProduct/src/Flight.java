import java.sql.Blob;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * A class designed for the construction of Flight objects before they are inserted into the
 * database.
 *
 *
 */
public class Flight {
  private String id;
  private String flightName;
  private String source;
  private String depart;
  private String date;
  private String departTime;
  private String arrivalTime;
  private String flightCharge;

  /**
   * A constructor of type Flight with parameters:
   * @param id — String parameter used to hold a Flight's ID.
   * @param flightName — String parameter used to hold a Flight's name.
   * @param source — String parameter used to hold a Flight's source.
   * @param depart — String parameter used to hold a Flight's departure.
   * @param date — String parameter used to hold a Flight's date.
   * @param departTime — String parameter used to hold a Flight's departure time.
   * @param arrivalTime — String parameter used to hold a Flight's arrival time.
   * @param flightCharge — String parameter used to hold a Flight's charge.
   */
  public Flight(String id, String flightName, String source, String depart, String date,
      String departTime, String arrivalTime, String flightCharge) {
    this.id = id;
    this.flightName = flightName;
    this.source = source;
    this.depart = depart;
    this.date = date;
    this.departTime = departTime;
    this.arrivalTime = arrivalTime;
    this.flightCharge = flightCharge;
  }

  /**
   * Getter method for ID attribute.
   * @return id — String parameter used to hold a Flight's ID.
   */
  public String getId() {
    return id;
  }

  /**
   * Setter method for Flight ID attribute.
   * @param id — String parameter used to hold a Flight's ID.
   */
  public void setId(String id) {
    this.id = id;
  }

  /**
   * Getter method for Flight Name attribute.
   * @return flightName — String parameter used to hold a Flight's name.
   */
  public String getFlightName() {
    return flightName;
  }

  /**
   * Setter method for Flight Name attribute.
   * @param flightName — String parameter used to hold a Flight's name.
   */
  public void setFlightName(String flightName) {
    this.flightName = flightName;
  }

  /**
   * Getter method for Flight Source attribute.
   * @return source — String parameter used to hold a Flight's source.
   */
  public String getSource() {
    return source;
  }

  /**
   * Setter method for Flight Source attribute.
   * @param source — String parameter used to hold a Flight's source.
   */
  public void setSource(String source) {
    this.source = source;
  }

  /**
   * Getter method for Flight Departure attribute.
   * @return depart — String parameter used to hold a Flight's departure.
   */
  public String getDepart() {
    return depart;
  }

  /**
   * Setter method for Flight Departure attribute.
   * @param depart — String parameter used to hold a Flight's departure.
   */
  public void setDepart(String depart) {
    this.depart = depart;
  }

  /**
   * Getter method for Flight Date attribute.
   * @return date — String parameter used to hold a Flight's date.
   */
  public String getDate() {
    return date;
  }

  /**
   * Setter method for Flight Date attribute.
   * @param date — String parameter used to hold a Flight's date.
   */
  public void setDate(String date) {
    this.date = date;
  }

  /**
   * Getter method for Flight Departure Time attribute.
   * @return departTime — String parameter used to hold a Flight's departure time.
   */
  public String getDepartTime() {
    return departTime;
  }

  /**
   * Setter method for Flight Departure Time attribute.
   * @param departTime — String parameter used to hold a Flight's departure time.
   */
  public void setDepartTime(String departTime) {
    this.departTime = departTime;
  }

  /**
   * Getter method for Flight Arrival Time attribute.
   * @return arrivalTime — String parameter used to hold a Flight's arrival time.
   */
  public String getArrivalTime() {
    return arrivalTime;
  }

  /**
   * Setter method for Flight Arrival Time attribute.
   * @param arrivalTime — String parameter used to hold a Flight's arrival time.
   */
  public void setArrivalTime(String arrivalTime) {
    this.arrivalTime = arrivalTime;
  }

  /**
   * Getter method for Flight Charge attribute.
   * @return flightCharge — String parameter used to hold a Flight's charge.
   */
  public String getFlightCharge() {
    return flightCharge;
  }

  /**
   * Setter method for Flight Charge attribute.
   * @param flightCharge — String parameter used to hold a Flight's charge.
   */
  public void setFlightCharge(String flightCharge) {
    this.flightCharge = flightCharge;
  }
}
