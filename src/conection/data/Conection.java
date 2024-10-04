/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conection.data;

/**
 *
 * @author Ryzen
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conection {
    private static Conection instance;
    private Connection connection;
    
    private String url = "jdbc:mysql://localhost:3306/tu_base_datos";
    private String username = "Eliana";
    private String password = "1234";
    
    // Constructor privado para evitar la creación de más instancias
    private Conection() throws SQLException {
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
    public static Conection getInstance() throws SQLException {
        if (instance == null) {
            instance = new Conection();
        } else if (instance.getConnection().isClosed()) {
            instance = new Conection();
        }
        return instance;
    }

    // Método para obtener la conexión
    public Connection getConnection() {
        return connection;
    }
}

