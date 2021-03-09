import java.sql.Blob;
import java.util.Date;

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
	private Blob photo;
	
	public Customer() {};
	
	public Customer (String id, 
			String firstname,
			String lastname,
			String nic,
			String passport,
			String address,
			Date dob,
			String gender,
			String contact,
			Blob photo) {
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
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getNic() {
		return nic;
	}
	public void setNic(String nic) {
		this.nic = nic;
	}
	public String getPassport() {
		return passport;
	}
	public void setPassport(String passport) {
		this.passport = passport;
	}
	public String getAddressString() {
		return address;
	}
	public void setAddressString(String address) {
		this.address = address;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public Blob getPhoto() {
		return photo;
	}
	public void setPhoto(Blob photo) {
		this.photo = photo;
	}
}
