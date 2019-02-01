package by.compit.belpost.srervice.impl;

import by.compit.belpost.srervice.ConnectionService;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Service
public class ConnectionServiceImpl implements ConnectionService {

    private static final String DRIVER = "${driverclassname}";
    private static final String URL = "${url}";
    private static final String USER = "${username}";
    private static final String PASSWORD = "${password}";

    @Override
    public Connection getConnection() {
        try {
            Class.forName("oracle.jdbc.OracleDriver");

            return DriverManager.getConnection(
                    "jdbc:oracle:thin:@//10.0.0.77:1521/belpost",
                    "TRACKSYS",
                    "TRACKSYS"
            );
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
