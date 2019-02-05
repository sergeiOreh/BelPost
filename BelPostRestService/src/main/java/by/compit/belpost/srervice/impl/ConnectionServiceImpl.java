package by.compit.belpost.srervice.impl;

import by.compit.belpost.srervice.ConnectionService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Класс ConnectionServiceImpl предназначен для получения подключения к базе данных через соответствующие свойства.
 */
@Service
public class ConnectionServiceImpl implements ConnectionService {

    @Value("${spring.datasource.driverclassname}")
    private String DRIVER;
    @Value("${spring.datasource.url}")
    private String URL;
    @Value("${spring.datasource.username}")
    private String USER;
    @Value("${spring.datasource.password}")
    private String PASSWORD;

    /**
     * @return подключение к базе данных
     */
    @Override
    public Connection getConnection() {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASSWORD);
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
