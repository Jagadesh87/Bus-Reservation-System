package Bus_Reser;

import java.sql.SQLException;
import java.util.Scanner; //nested package/ hierarchical package


public class Bus_Main{

    public static void main(String[] args) throws SQLException {

        BusDAO busdao = new BusDAO();
        busdao.displayBusinfo();


        int userOpt = 1;
        Scanner scanner = new Scanner(System.in);



        while(userOpt==1) {
            System.out.println("Enter 1 to Book and 2 to exit");
            userOpt = scanner.nextInt();
            if(userOpt == 1) {
                Booking booking = new Booking(); // new booking by user.
                if(booking.isAvailable()) {//check availability.
                    BookingDAO bookingdao = new BookingDAO();
                    bookingdao.addBooking(booking); // availability true add to the bookings
                    System.out.println("Your booking is confirmed");
                }
                else
                    System.out.println("Sorry. Bus is full. Try another bus or date.");
            }
        }
    }

}