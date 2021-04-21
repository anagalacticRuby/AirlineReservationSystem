import java.sql.Blob;
import java.util.Date;

/**
 * A class designed for the construction of Customer objects before they are inserted into the
 * database.
 *
 */
public class Customer {
  private String id;
  private String firstname;
  private String lastname;
  private String nic;
  private String passport;
  private String address;
  private Date dob;
  private String gender;
  private String contact;
  private byte[] photo;

  /**
   * Empty constructor for Customer objects.
   */
  public Customer() {};

  /**
   * A completely outfitted constructor for Customer Objects.
   * 
   * @param id A customer ID that is generally automatically generated by the system.
   * @param firstname A customer's first name in a string format.
   * @param lastname A customer's last name in a string format.
   * @param nic A customer's nickname in a string format.
   * @param passport A customer's passport-id, stored in a string format.
   * @param address A customer's home address, stored in a string format.
   * @param dob A customer's date of birth, in a Date format.
   * @param gender A customer's gender. The system only supports Male or Female as options.
   * @param contact A customer's phone number, saved as a string.
   * @param photo A path that tells the system where to find a customer's photo.
   */
  public Customer(String id, String firstname, String lastname, String nic, String passport,
      String address, Date dob, String gender, String contact, byte[] photo) {
    this.id = id;
    this.firstname = firstname;
    this.lastname = lastname;
    this.nic = nic;
    this.passport = passport;
    this.address = address;
    this.dob = dob;
    this.gender = gender;
    this.contact = contact;
    this.photo = photo;
  }

  /**
   * Accessor for the ID attribute of a Customer object
   * 
   * @return the value contained in the ID attribute
   */
  public String getId() {
    return id;
  }

  /**
   * Mutator for the ID attribute of a Customer object.
   * 
   * @param id The new ID value to assign to the Customer.
   */
  public void setId(String id) {
    this.id = id;
  }

  /**
   * Accessor for the firstname attribute of a Customer object.
   * 
   * @return the value contained in the firstname attribute.
   */
  public String getFirstname() {
    return firstname;
  }

  /**
   * Mutator for the ID attribute of a Customer object.
   * 
   * @param firstname The new first name to assign to the Customer.
   */
  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  /**
   * Accessor for the lastname attribute of a Customer object.
   * 
   * @return the last name of the calling Customer object.
   */
  public String getLastname() {
    return lastname;
  }

  /**
   * Mutator for the lastname attribute of a Customer object.
   * 
   * @param lastname The new last name to assign to the Customer.
   */
  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  /**
   * Accessor for the nickname attribute of a Customer object.
   * 
   * @return Returns the nickname of a Customer.
   */
  public String getNic() {
    return nic;
  }

  /**
   * Mutator for the nickname attribute of a Customer.
   * 
   * @param nic The new nickname to assign to the Customer.
   */
  public void setNic(String nic) {
    this.nic = nic;
  }

  /**
   * Accessor for the passport attribute of a Customer.
   * 
   * @return Returns the current passport value of a Customer.
   */
  public String getPassport() {
    return passport;
  }

  /**
   * Mutator for the passport attribute of a Customer.
   * 
   * @param passport The new value to assign to the passport attribute.
   */
  public void setPassport(String passport) {
    this.passport = passport;
  }

  /**
   * Getter for the address of a Customer.
   * 
   * @return Returns the address (in a string) of a Customer.
   */
  public String getAddressString() {
    return address;
  }

  /**
   * Setter for the address of a Customer.
   * 
   * @param address The new value to set a Customer's address attribute to.
   */
  public void setAddressString(String address) {
    this.address = address;
  }

  /**
   * Getter for a Customer's date of birth.
   * 
   * @return Returns the date of birth of the Customer.
   */
  public Date getDob() {
    return dob;
  }

  /**
   * Setter for a Customer's date of birth.
   * 
   * @param dob The new date of birth to set a Customer's dob to.
   */
  public void setDob(Date dob) {
    this.dob = dob;
  }

  /**
   * Getter for the gender value of a Customer object.
   * 
   * @return Returns the value stored in the gender attribute of a Customer.
   */
  public String getGender() {
    return gender;
  }

  /**
   * Sets the gender of a Customer Object. Only Male or Female are currently valid.
   * 
   * @param gender The new gender value to assign to a Customer.
   */
  public void setGender(String gender) {
    this.gender = gender;
  }

  /**
   * Gets the phone number of a Customer object.
   * 
   * @return
   */
  public String getContact() {
    return contact;
  }

  /**
   * Sets the phone number of a Customer object.
   * 
   * @param contact The new phone number to assign to a Customer.
   */
  public void setContact(String contact) {
    this.contact = contact;
  }

  /**
   * Getter for the photo path of a Customer
   * 
   * @return Returns the photo path of an image file
   */
  public byte[] getPhoto() {
    return photo;
  }

  /**
   * Mutator for the photo attribute of Customers.
   * 
   * @param photo The path of an image path assigned to the photo attribute.
   */
  public void setPhoto(byte[] photo) {
    this.photo = photo;
  }
}
