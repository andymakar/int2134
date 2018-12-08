
public class Guest {
	private String email;
	private String name;
	private String phoneNo;
	private String street;
	private String city;
	private String state;
	private String zip;
	private Status status;
	
	public Guest(String email) {
		this.email = email;
	}
	
	public Guest(String email, String name) {
		this.email = email;
		this.name = name;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	
	public void setStreet(String street) {
		this.street = street;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public void setZip(String zip) {
		this.zip = zip;
	}
	
	public void setStatus(Status status) {
		this.status = status;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getPhoneNo() {
		return this.phoneNo;
	}
	
	public String getStreet() {
		return this.street;
	}
	
	public String getCity() {
		return this.city;
	}
	
	public String getState() {
		return this.state;
	}
	
	public String getZip() {
		return this.zip;
	}
	
	public Status getStatus() {
		return this.status;
	}
}
