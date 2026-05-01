package org.parkinglot;

import java.sql.*;
import java.time.LocalDateTime;

public class ParkingDAO {
    public int logEntry(String plate){
        String sql="INSERT INTO parking_history (license_plate, entry_time) VALUES (?, ?) RETURNING id";
        try(Connection conn=DatabaseConfig.getConnection();
            PreparedStatement stmt=conn.prepareStatement(sql)){
            stmt.setString(1,plate);
            stmt.setTimestamp(2,Timestamp.valueOf(LocalDateTime.now()));

            ResultSet result=stmt.executeQuery();
            if(result.next()) return result.getInt(1);

        }catch(SQLException e){
            System.out.println("Database log failed "+ e.getMessage());
        }
        return -1;
    }

    public void logExist(int recordId,double fee){
        String sql="UPDATE parking_history SET exit_time = ?, fee = ? WHERE id = ?";
        try(Connection conn=DatabaseConfig.getConnection();
            PreparedStatement stmt=conn.prepareStatement(sql)){
                stmt.setTimestamp(1,Timestamp.valueOf(LocalDateTime.now()));
                stmt.setDouble(2,fee);
                stmt.setInt(3,recordId);
                stmt.executeUpdate();



        }catch(SQLException e){
            System.out.println("Database update failed " + e.getMessage());
        }
    }


}
