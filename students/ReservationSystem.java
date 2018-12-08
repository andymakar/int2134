import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class ReservationSystem {
	List<Guest> guests;
	List<Reservation> reservations;
	Room[] rooms;
	
	public ReservationSystem() {
		this.guests = new LinkedList<>();
		this.reservations = new LinkedList<>();
		rooms = new Room[12];
		for (int i = 0; i < rooms.length; i++) {
			rooms[i] = new Room((i + 1) + "");
		}
	}
	
	public int menu(Scanner reader) {
		StringBuilder builder = new StringBuilder();
		builder.append("1. Add a guest\n");
		builder.append("2. Update a guest information\n");
		builder.append("3. Delete a guest\n");
		builder.append("4. Check in a customer\n");
		builder.append("5. Check out a customer\n");
		builder.append("6. Make a reservation\n");
		builder.append("7. Cancel a reservation\n");
		builder.append("8. Report: List of Open Rooms\n");
		builder.append("9. Report: Print the Guest Register\n");
		builder.append("10. Menu System\n");
		builder.append("Choose a menu: ");
		System.out.println(builder.toString());
		return Integer.parseInt(reader.nextLine());
	}
	
	public boolean addGuest(Scanner reader) {
		System.out.print("Enter the email address: ");
		String email = reader.nextLine();
		for (Guest guest : guests) {
			if (guest.getEmail().equals(email)) {
				return false;
			}
		}
		Guest guest = new Guest(email);
		System.out.print("Enter the name: ");
		String name = reader.nextLine();
		guest.setName(name);
		System.out.print("Enter the phone number: ");
		String phoneNo = reader.nextLine();
		guest.setPhoneNo(phoneNo);
		System.out.print("Enter the street: ");
		String street = reader.nextLine();
		guest.setStreet(street);
		System.out.print("Enter the city: ");
		String city = reader.nextLine();
		guest.setCity(city);
		System.out.print("Enter the state: ");
		String state = reader.nextLine();
		guest.setState(state);
		System.out.print("Enter the zip: ");
		String zip = reader.nextLine();
		guest.setZip(zip);
		guest.setStatus(Status.OUT);
		guests.add(guest);
		return true;
	}
	
	public void updateInfo(Scanner reader) {
		System.out.print("Enter the email: ");
		String email = reader.nextLine();
		for (Guest guest : guests) {
			if (guest.getEmail().equals(email)) {
				System.out.println("1. email");
				System.out.println("2. name");
				System.out.println("3. phone number");
				System.out.println("4. street");
				System.out.println("5. city");
				System.out.println("6. state");
				System.out.println("7. zip");
				System.out.print("Choose one that needs modification: ");
				int choice = Integer.parseInt(reader.nextLine());
				switch(choice) {
				case 1:
					System.out.print("Enter the new email: ");
					String newEmail = reader.nextLine();
					guest.setEmail(newEmail);
					break;
				case 2:
					System.out.print("Enter the new name: ");
					String newName = reader.nextLine();
					guest.setName(newName);
					break;
				case 3:
					System.out.print("Enter the new phone number: ");
					String newPhoneNo = reader.nextLine();
					guest.setPhoneNo(newPhoneNo);
					break;
				case 4:
					System.out.print("Enter the new street: ");
					String newStreet = reader.nextLine();
					guest.setStreet(newStreet);
					break;
				case 5:
					System.out.print("Enter the new city: ");
					String newCity = reader.nextLine();
					guest.setCity(newCity);
					break;
				case 6:
					System.out.print("Enter the new state: ");
					String newState = reader.nextLine();
					guest.setState(newState);
					break;
				case 7:
					System.out.print("Enter the new zip: ");
					String newZip = reader.nextLine();
					guest.setZip(newZip);
					break;
				default:
					System.out.println("Not in the menus");
					break;
				}
				return;
			}
		}
		System.out.println("No such guest");
	}
	
	public boolean deleteGuest(Scanner reader) {
		System.out.print("Enter the email address: ");
		String email = reader.nextLine();
		Guest tmp = null;
		for (Guest guest : guests) {
			if (guest.getEmail().equals(email)) {
				tmp = guest;
				break;
			}
		}
		if (tmp != null) {
			guests.remove(tmp);
			System.out.println("Deleted");
			return true;
		}
		System.out.println("Not a valid email address.");
		return false;
	}
	
	public boolean checkIn(Scanner reader) {
		System.out.print("Enter the email address: ");
		String email = reader.nextLine();
		for (Guest guest : guests) {
			if (guest.getEmail().equals(email)) {
				boolean reserved = false;
				for (Reservation r : reservations) {
					if (r.getEmail().equals(guest.getEmail())) {
						r.getRoom().checkIn(guest);
						Calendar c = Calendar.getInstance();
						String checkInDate = c.get(Calendar.YEAR) + "-" + (c.get(Calendar.MONTH) + 1) + "-" + c.get(Calendar.DAY_OF_MONTH);
						r.setCheckInDate(checkInDate);
						reserved = true;
						guest.setStatus(Status.IN);
						return true;
					}
				}
				if(!reserved) {
					for (int i = 0; i < rooms.length; i++) {
						if (rooms[i].getStatus() == RoomStatus.VALID) {
							rooms[i].checkIn(guest);
							guest.setStatus(Status.IN);
							return true;
						}
					}
				}
			}
		}
		System.out.println("Not a valid email address.");
		return false;
	}
	
	public boolean checkOut(Scanner reader) {
		System.out.print("Enter the email address: ");
		String email = reader.nextLine();
		for (Guest guest : guests) {
			if (guest.getEmail().equals(email)) {
				for (int i = 0; i < rooms.length; i++) {
					if (rooms[i].getGuest().getEmail().equals(guest.getEmail()) 
							&& rooms[i].getStatus() == RoomStatus.INVALID) {
						rooms[i].checkOut();
						for (Reservation r : reservations) {
							if (r.getEmail().equals(guest.getEmail())) {
								Calendar c = Calendar.getInstance();
								String checkInDate = c.get(Calendar.YEAR) + "-" + (c.get(Calendar.MONTH) + 1) + "-" + c.get(Calendar.DAY_OF_MONTH);
								r.setCheckOutDate(checkInDate);
							}
						}
						guest.setStatus(Status.OUT);
						return true;
					}
				}
			}
		}
		System.out.println("Not a valid email address.");
		return false;
	}
	
	public boolean makeReservation(Scanner reader) {
		System.out.print("Enter the email address: ");
		String email = reader.nextLine();
		for (Guest guest : guests) {
			if (guest.getEmail().equals(email)) {
				System.out.print("Enter the reservation number: ");
				String number = reader.nextLine();
				for (int i = 0; i < rooms.length; i++) {
					System.out.println(i + ": " + rooms[i].toString());
				}
				System.out.println("Choose a room: ");
				int roomNo = Integer.parseInt(reader.nextLine());
				if (roomNo >= 0 && roomNo < rooms.length) {
					if (rooms[roomNo].getStatus() == RoomStatus.VALID) {
						System.out.print("Enter the check in date(YYYY-mm-DD): ");
						String inDate = reader.nextLine();
						System.out.print("Enter the check out date(YYYY-mm-DD): ");
						String outDate = reader.nextLine();
						Reservation r = new Reservation(number, guest.getEmail(), rooms[roomNo]);
						guest.setStatus(Status.P_VISIT);
						r.setCheckInDate(inDate);
						r.setCheckOutDate(outDate);
						rooms[roomNo].reserve();
						reservations.add(r);
						return true;
					} else {
						System.out.println("The room is in use");
						return false;
					}
				} else {
					System.out.println("Not in the range");
					return false;
				}
			}
		}
		System.out.println("Not a valid email address.");
		return false;
	}
	
	public boolean cancelReservation(Scanner reader) {
		System.out.print("Enter the Reservation number: ");
		String number = reader.nextLine();
		for (Reservation r : reservations) {
			if (r.getNumber().equals(number)) {
				r.setStatus(R_Status.CANCELLED);
				r.getRoom().cancelReservation();
				return true;
			}
		}
		System.out.println("Not a valid reservation number.");
		return false;
	}
	
	public void listOpenRoom(Scanner reader) {
		System.out.println("Report: List of Open Rooms");
		Calendar c = Calendar.getInstance();
		String date = c.get(Calendar.YEAR) + "-" + (c.get(Calendar.MONTH) + 1) + "-" + c.get(Calendar.DAY_OF_MONTH);
		System.out.println("Date: " + date);
		System.out.print("Enter the check in date(YYYY-mm-DD): ");
		String startDate = reader.nextLine();
		System.out.print("Enter the check out date(YYYY-mm-DD): ");
		String endDate = reader.nextLine();
		for (int i = 0; i < rooms.length; i++) {
			if (rooms[i].getStatus() == RoomStatus.VALID) {
				System.out.println(rooms[i].toString());
			} else {
				boolean valid = true;
				for (Reservation r : reservations) {
					if (r.getRoom().getRoomNumber().equals(rooms[i].getRoomNumber())) {
						if (!validRoomBetweenDate(startDate, endDate, r.getCheckInDate(), r.getCheckOutDate())) {
							valid = false;
						}
					}
				}
				if (valid) {
					System.out.println(rooms[i].toString());
				}
			}
		}
	}
	
	public boolean validRoomBetweenDate(String start, String end, String in, String out) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd",
                Locale.CHINA);
        try {
            Date startDate = sdf.parse(start);
            Date endDate = sdf.parse(end);
            Date inDate = sdf.parse(in);
            Date outDate = sdf.parse(out);
            return startDate.compareTo(outDate) >= 0 || endDate.compareTo(inDate) <= 0;
        } catch (ParseException e) {
        	System.out.println("Invalid date format.");
        }
        return false;
	}
	
	public void listGuests() {
		System.out.println("Report: List of Guest Register");
		Calendar c = Calendar.getInstance();
		String date = c.get(Calendar.YEAR) + "-" + (c.get(Calendar.MONTH) + 1) + "-" + c.get(Calendar.DAY_OF_MONTH);
		System.out.println("Date: " + date);
		Map<String, Reservation> ids = new HashMap<String, Reservation>();
		for (Reservation r : reservations) {
			if (ids.get(r.getEmail()) == null) {
				ids.put(r.getEmail(), r);
			}
		}
		for (Guest g : guests) {
			if (ids.get(g.getEmail()) != null) {
				System.out.println(g.getName()
						+ " \n\tCheck in date: " + ids.get(g.getEmail()).getCheckInDate()
						+ " \n\tCheck out date: " + ids.get(g.getEmail()).getCheckOutDate());
			}
		}
	}
	
	public static void main(String[] args) {
		ReservationSystem sys = new ReservationSystem();
		Scanner reader = new Scanner(System.in);
		OUT: 
		while (true) {
			int choice = sys.menu(reader);
			switch(choice) {
			case 1:
				sys.addGuest(reader);
				break;
			case 2:
				sys.updateInfo(reader);
				break;
			case 3:
				sys.deleteGuest(reader);
				break;
			case 4:
				sys.checkIn(reader);
				break;
			case 5:
				sys.checkOut(reader);
				break;
			case 6:
				sys.makeReservation(reader);
				break;
			case 7:
				sys.cancelReservation(reader);
				break;
			case 8:
				sys.listOpenRoom(reader);
				break;
			case 9:
				sys.listGuests();
				break;
			case 10:
				System.out.println("Goodbye");
				break OUT;
			default:
				System.out.println("Not in the menu range");
				break;
			}
		}
		reader.close();
	}
}
