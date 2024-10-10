/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author vsmv0
 */
public class Services {
    private static Services instance;
    private Connection connection;
    
    private String url = "jdbc:mysql://localhost:3306/tu_base_datos";
    private String username = "Eliana";
    private String password = "1234";
    
    // Constructor privado para evitar la creación de más instancias
    private Services() throws SQLException {
        try {
            // Registrar el driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establecer la conexión
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException ex) {
            throw new SQLException("Error al cargar el driver de MySQL", ex);
        }
    }

    // Método público para obtener la única instancia de la conexión
    public static Services getInstance() throws SQLException {
        if (instance == null) {
            instance = new Services();
        } else if (instance.getConnection().isClosed()) {
            instance = new Services();
        }
        return instance;
    }

    // Método para obtener la conexión
    public Connection getConnection() {
        return connection;
    }
}
