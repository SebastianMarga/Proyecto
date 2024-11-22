/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import Modelo.Doctor;
import Modelo.Services;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase para manejar la creación, inserción, selección, eliminación y clonación de doctores.
 * 
 * @author SANDRO
 */
public class DoctorFactory {
    private static Services instancia;  // Instancia para obtener la conexión

    static {
        try {
            instancia = Services.getInstance();  // Aquí manejamos la excepción
        } catch (SQLException e) {
            e.printStackTrace();  // Imprimir la traza de la excepción
            // Otras acciones si es necesario, como terminar la ejecución o reintentar
        }
    }

    // Crear un nuevo doctor
    public Doctor crearDoctor(int id_doctor, String nombre, String apellido, String especialidad, String telefono, String correo) throws SQLException {
        return new Doctor(id_doctor, nombre, apellido, especialidad, telefono, correo);
    }

    // Insertar un doctor en la base de datos
    public void insertarDoctor(Doctor doctor) throws SQLException {
        Connection conexion = instancia.getConnection();
        String query = "{call InsertarDoctor(?, ?, ?, ?, ?)}";

        try (CallableStatement stmt = conexion.prepareCall(query)) {
            stmt.setString(1, doctor.getNombre());
            stmt.setString(2, doctor.getApellido());
            stmt.setString(3, doctor.getEspecialidad());
            stmt.setString(4, doctor.getTelefono());
            stmt.setString(5, doctor.getCorreo());
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Error al insertar doctor.");
        }
    }

    // Obtener todos los doctores desde la base de datos
    public List<Doctor> seleccionarDoctores() throws SQLException {
        List<Doctor> doctores = new ArrayList<>();
        Connection conexion = instancia.getConnection();
        String sql = "{call SeleccionarDoctores}";

        try (CallableStatement stmt = conexion.prepareCall(sql)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String especialidad = rs.getString("especialidad");
                String telefono = rs.getString("telefono");
                String correo = rs.getString("correo_electronico");

                doctores.add(new Doctor(rs.getInt("id_doctor"), nombre, apellido, especialidad, telefono, correo));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Error al obtener doctores.");
        }

        return doctores;
    }

    // Eliminar un doctor según su ID
    public void eliminarDoctor(int id_doctor) throws SQLException {
        Connection conexion = instancia.getConnection();
        String sql = "{call EliminarDoctor(?)}";

        try (CallableStatement stmt = conexion.prepareCall(sql)) {
            stmt.setInt(1, id_doctor);
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Error al eliminar doctor.");
        }
    }

    // Clonar un doctor
    public Doctor clonarDoctor(Doctor original) throws SQLException {
        // Crear un nuevo objeto Doctor con los mismos valores del original
        return new Doctor(
                original.getId_doctor(),
                original.getNombre(),
                original.getApellido(),
                original.getEspecialidad(),
                original.getTelefono(),
                original.getCorreo()
        );
    }
}
