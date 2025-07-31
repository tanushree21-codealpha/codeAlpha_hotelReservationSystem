
package hotel_reservation;
public class booking {
    String customerName;
    int roomNumber;
    String roomType;
     
    public booking(String customerName, int roomNumber,String roomType){
        this.customerName=customerName;
        this.roomNumber=roomNumber;
        this.roomType=roomType;
    }
    public void displayBooking() {
        System.out.println("Booking - Name: " + customerName + ", Room No: " + roomNumber + ", Type: " + roomType);
    }
}

    

