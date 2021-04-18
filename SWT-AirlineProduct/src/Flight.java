import java.sql.Blob;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Flight {
  private String id;
  private String flightName;
  private String source;
  private String depart;
  private String date;
  private String departTime;
  private String arrivalTime;
  private String flightCharge;

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

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getFlightName() {
    return flightName;
  }

  public void setFlightName(String flightName) {
    this.flightName = flightName;
  }

  public String getSource() {
    return source;
  }

  public void setSource(String source) {
    this.source = source;
  }

  public String getDepart() {
    return depart;
  }

  public void setDepart(String depart) {
    this.depart = depart;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public String getDepartTime() {
    return departTime;
  }

  public void setDepartTime(String departTime) {
    this.departTime = departTime;
  }

  public String getArrivalTime() {
    return arrivalTime;
  }

  public void setArrivalTime(String arrivalTime) {
    this.arrivalTime = arrivalTime;
  }

  public String getFlightCharge() {
    return flightCharge;
  }

  public void setFlightCharge(String flightCharge) {
    this.flightCharge = flightCharge;
  }
}
