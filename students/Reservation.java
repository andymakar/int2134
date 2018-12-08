
public class Reservation {
	private String number;
	private String email;
	private R_Status status;
	private String checkInDate;
	private String checkOutDate;
	private Room room;
	
	public Reservation(String number, String email, Room room) {
		this.number = number;
		this.email = email;
		this.room = room;
		status = R_Status.CONFIRMED;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setStatus(R_Status status) {
		this.status = status;
	}
	
	public void setCheckInDate(String checkInDate) {
		this.checkInDate = checkInDate;
	}
	
	public void setCheckOutDate(String checkOutDate) {
		this.checkOutDate = checkOutDate;
	}
	
	public String getNumber() {
		return this.number;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public R_Status getStatus() {
		return this.status;
	}
	
	public Room getRoom() {
		return this.room;
	}
	
	public String getCheckInDate() {
		return this.checkInDate;
	}
	
	public String getCheckOutDate() {
		return this.checkOutDate;
	}
}
