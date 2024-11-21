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
public class Doctor implements Operaciones{
    private int id_doctor;
    private String nombre;
    private String apellido;
    private String especialidad;
    private String telefono;
    private String correo;    
    Services instancia=Services.getInstance();

    public Doctor(int id_doctor, String nombre, String apellido, String especialidad, String telefono, String correo) throws SQLException {
        this.id_doctor = id_doctor;
        this.nombre = nombre;
        this.apellido = apellido;
        this.especialidad = especialidad;
        this.telefono = telefono;
        this.correo = correo;
    }
    
    

    public int getId_doctor() {
        return id_doctor;
    }

    public void setId_doctor(int id_doctor) {
        this.id_doctor = id_doctor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
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
            return (Doctor) super.clone(); // Clonación superficial
        } catch (CloneNotSupportedException e) {
            // Esto nunca debería ocurrir, ya que estamos implementando Cloneable
            throw new RuntimeException("Error al clonar el objeto Doctor", e);
        }    }

    @Override
    public void insertar() throws SQLException {
Connection conexion = instancia.getConnection();
        String query = "{call InsertarDoctor(?, ?, ?, ?)}";
        
        try {
            CallableStatement stmt = conexion.prepareCall(query);
            // Establecer los parámetros del procedimiento
        stmt.setString(1, nombre);
        stmt.setString(2, especialidad);
        stmt.setString(3, telefono);
        stmt.setString(4, correo);
        
        stmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }    }

    @Override
    public void seleccionar() throws SQLException {
        Connection conexion = instancia.getConnection();
        String sql = "{call SeleccionarDoctores}";
        try{
            CallableStatement stmt =conexion.prepareCall(sql);

        // Ejecutar el procedimiento
         ResultSet rs = stmt.executeQuery();

        // Procesar los resultados
        while (rs.next()) {
            String nombre = rs.getString("nombre");
            String apellido = rs.getString("apellido");
            String especialidad = rs.getString("especialidad");
            String telefono = rs.getString("telefono");
            String correo = rs.getString("correo_electronico");

            System.out.println("Nombre del doctor: " + nombre+" "+apellido);
            System.out.println("Direccion de la clinica: " + especialidad);
            System.out.println("Telefono: "+telefono);
            System.out.println("Correo: "+correo);}
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar() throws SQLException {
Connection conexion = instancia.getConnection();
        String sql = "{call EliminarDoctor(?)}";
        try{
        CallableStatement stmt = conexion.prepareCall(sql);
        // Asignar parámetro de entrada (ID del usuario a eliminar)
        stmt.setInt(1, id_doctor);

        // Ejecutar el procedimiento
        stmt.execute();
        JOptionPane.showMessageDialog(null, "Servicios Medicos eliminado correctamente");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
