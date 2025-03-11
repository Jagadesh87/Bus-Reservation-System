package Bus_Reser;

import java.sql.*;
import java.util.Date;

public class BookingDAO {
    public int getbookedcount(int busNo,Date date) throws SQLException{

        String query = "select count(passengerName) from Booking where bus_no=? and travel_date=?";
        Connection con = DBconnection.getConnection();
        PreparedStatement pst = con.prepareStatement(query);
        java.sql.Date sqldate = new java.sql.Date(date.getTime());
        pst.setInt(1, busNo);
        pst.setDate(2, sqldate);
        ResultSet rs = pst.executeQuery();
        rs.next();
        return rs.getInt(1);
    }

    public void addBooking(Booking booking) throws SQLException{
        String query = "Insert into Booking values(?,?,?)";
        Connection con = DBconnection.getConnection();
        java.sql.Date sqldate = new java.sql.Date(booking.date.getTime());
        PreparedStatement pst = con.prepareStatement(query);
        pst.setString(1, booking.passengerName);
        pst.setInt(2, booking.busNo);
        pst.setDate(3, sqldate);

        pst.executeUpdate();

    }
}
