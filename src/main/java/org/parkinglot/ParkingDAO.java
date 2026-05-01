package org.parkinglot;

import java.sql.*;
import java.time.LocalDateTime;

public class ParkingDAO {
    public int logEntry(String plate){
        String sql="INSERT INTO parking_history (license_plate, entry_time) VALUES (?, CURRENT_TIMESTAMP) RETURNING id";
        try(Connection conn=DatabaseConfig.getConnection();PreparedStatement stmt=conn.prepareStatement(sql)
        ){
            stmt.setString(1,plate);

            try(ResultSet result=stmt.executeQuery()){
                if(result.next()){
                    return result.getInt(1);
                }
            }
        }catch (SQLException e){
            System.out.println("Database log failed : " +e.getMessage());
        }
        return -1;

    }

    public void logExit(int recordId,double fee){
        String sql="UPDATE parking_history SET exit_time = NOW(), fee = ? WHERE id = ?";

        System.out.println("DEBUG: Attempting to update ID [" + recordId + "] with fee[ " +fee + " ]");
        try(Connection conn=DatabaseConfig.getConnection()){
            conn.setAutoCommit(true);

            try(PreparedStatement stmt=conn.prepareStatement(sql)){
                stmt.setDouble(1,fee);
                stmt.setInt(2,recordId);

                int rowsAffected=stmt.executeUpdate();

                if(rowsAffected > 0){
                    System.out.println("DB SUCCESS : ID "+ recordId + " updated");
                }else{
                    System.out.println("DB MISS: NO row found with ID " + recordId);
                }
            }
        }catch (SQLException e){
            System.out.println("SQL ERROR " + e.getMessage());
        }
    }


}
