
package hotel_reservation;
import java.util.*;

public class hotelSystem {
    static ArrayList<Room> rooms = new ArrayList<>();
    static ArrayList<booking> bookings = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        createRooms();
        int choice;
        do {
            System.out.println("\n--- Hotel Reservation Menu ---");
            System.out.println("1. Show Available Rooms");
            System.out.println("2. Book a Room");
            System.out.println("3. Cancel Booking");
            System.out.println("4. View Bookings");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1: showAvailableRooms(); break;
                case 2: bookRoom(); break;
                case 3: cancelBooking(); break;
                case 4: viewBookings(); break;
                case 5: System.out.println("Thank you!"); break;
                default: System.out.println("Invalid choice!");
            }
        } while (choice != 5);
    }

    public static void createRooms() {
        for (int i = 1; i <= 3; i++) rooms.add(new Room(i, "Standard"));
        for (int i = 4; i <= 6; i++) rooms.add(new Room(i, "Deluxe"));
        for (int i = 7; i <= 9; i++) rooms.add(new Room(i, "Suite"));
    }

    public static void showAvailableRooms() {
        System.out.println("\nAvailable Rooms:");
        for (Room r : rooms) {
            if (r.Available()) r.displayInfo();
        }
    }

    public static void bookRoom() {
        System.out.print("Enter your name: ");
        sc.nextLine(); 
        String name = sc.nextLine();
        System.out.print("Enter desired room type (Standard/Deluxe/Suite): ");
        String type = sc.nextLine();

        for (Room r : rooms) {
            if (r.type.equalsIgnoreCase(type) && r.Available()) {
                r.bookRoom();
                booking b = new booking(name, r.roomNumber, r.type);
                bookings.add(b);
                System.out.println("Room booked successfully!");
                return;
            }
        }
        System.out.println("No available rooms of this type.");
    }
    public static void cancelBooking() {
        System.out.print("Enter your name to cancel booking: ");
        sc.nextLine(); 
        String name = sc.nextLine();
        boolean found = false;

        for (booking b : bookings) {
            if (b.customerName.equalsIgnoreCase(name)) {
                for (Room r : rooms) {
                    if (r.roomNumber == b.roomNumber) {
                        r.cancelBooking();
                        break;
                    }
                }
                bookings.remove(b);
                System.out.println("Booking canceled.");
                found = true;
                break;
            }
        }
        if (!found) System.out.println("Booking not found.");
    }

    public static void viewBookings() {
        if (bookings.isEmpty()) {
            System.out.println("No bookings yet.");
        } else {
            for (booking b : bookings){
                b.displayBooking();
            }
        }
    }
}



