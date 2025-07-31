
package hotel_reservation;
public class Room {
    int roomNumber;
    String type;
    boolean isBooked;
    public Room(int roomNumber,String type){
        this.roomNumber = roomNumber;
        this.type= type;
        this.isBooked=false;

    }
    public void bookRoom(){
        this.isBooked = true;
    }
    public void cancelBooking(){
        this.isBooked= false;
    } 
    public  boolean Available(){
       return !isBooked;
    }
       public void displayInfo() {
        System.out.println("Room No: " + roomNumber + ", Type: " + type + ", Available: " + (Available() ? "Yes" : "No"));
    }
}

    
    
    




