/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author vsmv0
 */
public class Clinica implements Operaciones{
    private String id_clinica;
    private String nombre;
    private String direccion;
    private String telefono;
    private String correo;
    Services instancia=Services.getInstance();


    public Clinica(String id_clinica, String nombre, String direccion, String telefono, String correo) throws SQLException {
        this.id_clinica = id_clinica;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
    }

    public String getId_clinica() {
        return id_clinica;
    }

    public void setId_clinica(String id_clinica) {
        this.id_clinica = id_clinica;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public Operaciones clonar() {
         try {
            return (Clinica) super.clone(); // Clonación superficial
        } catch (CloneNotSupportedException e) {
            // Esto nunca debería ocurrir, ya que estamos implementando Cloneable
            throw new RuntimeException("Error al clonar el objeto Clinica", e);
        }
    }

    @Override
    public void insertar() throws SQLException {
        Connection conexion = instancia.getConnection();
        String query = "{call sp_InsertarClinica(?, ?, ?, ?, ?)}";
        
        try {
            CallableStatement stmt = conexion.prepareCall(query);
            // Establecer los parámetros del procedimiento
        stmt.setString(1, id_clinica);
        stmt.setString(2, nombre);
        stmt.setString(3, direccion);
        stmt.setString(4, telefono);
        stmt.setString(5, correo);
        
        stmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void seleccionar() throws SQLException {
        Connection conexion = instancia.getConnection();
        String sql = "{call sp_ConsultarClinicas}";
        try{
            CallableStatement stmt =conexion.prepareCall(sql);
            
            // Asignar parámetro de entrada (ID del usuario a seleccionar)
        stmt.setString(1, id_clinica);

        // Ejecutar el procedimiento
         ResultSet rs = stmt.executeQuery();

        // Procesar los resultados
        while (rs.next()) {
            String nombre = rs.getString("nombre");
            String direccion = rs.getString("direccion");
            String telefono = rs.getString("telefono");
            String correo = rs.getString("correo_electronico");

            System.out.println("Nombre de la clinica: " + nombre);
            System.out.println("Direccion de la clinica: " + direccion);
            System.out.println("Telefono: "+telefono);
            System.out.println("Correo: "+correo);}
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar() throws SQLException {
Connection conexion = instancia.getConnection();
        String sql = "{call sp_EliminarServicioMedico(?)}";
        try{
        CallableStatement stmt = conexion.prepareCall(sql);
        // Asignar parámetro de entrada (ID del usuario a eliminar)
        stmt.setString(1, id_clinica);

        // Ejecutar el procedimiento
        stmt.execute();
        JOptionPane.showMessageDialog(null, "Servicios Medicos eliminado correctamente");
        }catch(Exception e){
            e.printStackTrace();
        }    }
    
    
}
