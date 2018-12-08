
public class Room {
	private String number;
	private RoomStatus status;
	private Guest guest;
	
	public Room(String number) {
		this.number = number;
		this.status = RoomStatus.VALID;
		this.guest = null;
	}
	
	public String getRoomNumber() {
		return this.number;
	}
	
	public void checkIn(Guest guest) {
		this.guest = guest;
		this.status = RoomStatus.INVALID;
	}
	
	public void checkOut() {
		this.guest = null;
		this.status = RoomStatus.VALID;
	}
	
	public void reserve() {
		this.status = RoomStatus.INVALID;
	}
	
	public void cancelReservation() {
		this.status = RoomStatus.VALID;
	}
	
	public Guest getGuest() {
		return this.guest;
	}
	
	public RoomStatus getStatus() {
		return this.status;
	}
	
	public String toString() {
		return "Room " + number + ": " + this.status + " " + (this.guest == null ? "" : guest.getEmail());
	}
}
