package Bus_Reser;

import java.sql.*;
import java.sql.SQLException;

public class BusDAO {
    public void displayBusinfo() throws SQLException {
        String query= "select * from Bus";
        Connection conec = DBconnection.getConnection();
        Statement st = conec.createStatement();
        ResultSet resultSet= st.executeQuery(query);

        while(resultSet.next()){
            System.out.println("BusNo: " + resultSet.getInt(1));
            if(resultSet.getInt(2) ==0){
                System.out.println("AC: No");
            }
            else{
                System.out.println("AC: Yes");
            }
            System.out.println("Capacity: "+ resultSet.getInt(3));
        }
        System.out.println("------------------------------------------");
    }

    public int getCapacity(int id) throws SQLException {
        String query = "select capacity from Bus where id="+id;
        Connection conec = DBconnection.getConnection();
        Statement st = conec.createStatement();
        ResultSet resultSet= st.executeQuery(query);

        resultSet.next();
        return resultSet.getInt(1);
    }
}
