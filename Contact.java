package ContactInformation;

public class Contact {
	
	private String firstName;
	private String lastName;
	private String id;
	private String phone;
	private String address;
	
	
	public Contact (String firstName, String lastName, String id, String phone, String address) {
		
		if (id != null && id.length() <= 10) {
			this.id = id;
		}
		else {
			throw new IllegalArgumentException("Invalid Id");
		}
		
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setPhone(phone);
		this.setAddress(address);
	}
		
	//Throws error if any parameter is greater than 10 characters
	public void setFirstName(String firstName) {
		if (firstName != null && firstName.length() <= 10) {
			this.firstName = firstName;
		}
		else {
			throw new IllegalArgumentException("Invalid First Name");
		}
	}
	public void setLastName(String lastName) {	
		if (lastName != null && lastName.length() <= 10) {
			this.lastName = lastName;
			}
		else {
			throw new IllegalArgumentException("Invalid Last Name");
		}
	}
	public void setPhone(String phone) {
		if (phone != null && phone.length() == 10) {
			this.phone = phone;
		}
		
		else {
			throw new IllegalArgumentException("Invalid Phone Number");
		}
	}
		// Throws error if address is greater than 30 characters
	public void setAddress(String address) {	
		if (address != null && address.length() <= 30) {
			this.address = address;
		}
		
		else {
			throw new IllegalArgumentException("Invalid Address");
		}
	}
		
	
	// getters
	
	public String getfirstName() {
		return firstName;
	}
	
	public String getlastName() {
		return lastName;
	}
	
	public String getid() {
		return id;
	}
	
	public String getphone() {
		return phone;
	}
	
	public String getaddress() {
		return address;
	}
}
