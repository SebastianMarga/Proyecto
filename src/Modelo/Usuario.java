/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.SQLException;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author vsmv0
 */
public class Usuario implements Operaciones {
    private String idUsuario;
    private String nombres;
    private String apellidos;
    private String genero;
    private String telefono;
    private Date fechaNacimiento;
    private String email;
    Services instancia=Services.getInstance();

    public Usuario(String idUsuario, String nombres, String apellidos, String genero, String telefono, Date fechaNacimiento, String email) throws SQLException {
        this.idUsuario = idUsuario;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.genero=genero;
        this.telefono=telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.email = email;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    //Patron Prototype
    @Override
    public String toString() {
    return "Usuario{id=" + idUsuario + ", nombre=" + nombres + "Apellido "+apellidos+"Fecha de Nacimiento "+fechaNacimiento+"Email "+email;
    }

    @Override
    public Operaciones clonar() {
        try {
            return (Usuario) super.clone(); // Clonación superficial
        } catch (CloneNotSupportedException e) {
            // Esto nunca debería ocurrir, ya que estamos implementando Cloneable
            throw new RuntimeException("Error al clonar el objeto Usuario", e);
        }
    }

    @Override
    public void insertar() throws SQLException {
        Connection conexion = instancia.getConnection();
        String query = "{call sp_InsertarPaciente(?, ?, ?, ?,?,?,?)}";
        
        try {
            CallableStatement stmt = conexion.prepareCall(query);
            // Establecer los parámetros del procedimiento
        stmt.setString(1, idUsuario);
        stmt.setString(2, nombres);
        stmt.setString(3, apellidos);
        stmt.setString(4, genero);
        stmt.setString(5, genero);
        stmt.setDate(4, fechaNacimiento);
        stmt.setString(5, email);
        
        stmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void seleccionar() throws SQLException {
        Connection conexion = instancia.getConnection();
        String sql = "{call sp_SeleccionarPacientes}";
        try{
            CallableStatement stmt =conexion.prepareCall(sql);
            
            // Asignar parámetro de entrada (ID del usuario a seleccionar)
        stmt.setString(1, idUsuario);

        // Ejecutar el procedimiento
         ResultSet rs = stmt.executeQuery();

        // Procesar los resultados
        while (rs.next()) {
            String nombres = rs.getString("nombre");
            String apellidos = rs.getString("apellido");
            String genero = rs.getString("genero");
            String telefono = rs.getString("telefono");
            Date fechaNacimiento = rs.getDate("fecha_nacimiento");
            String email = rs.getString("correo_electronico");

            System.out.println("Usuario: " + nombres + " " + apellidos);
            System.out.println("Genero: "+genero);
            System.out.println("Fecha de Nacimiento: " + fechaNacimiento);
            System.out.println("Email: " + email);}
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }

    @Override
    public void eliminar() throws SQLException {
        Connection conexion = instancia.getConnection();
        String sql = "{call sp_EliminarPaciente(?)}";
        try{
        CallableStatement stmt = conexion.prepareCall(sql);
        // Asignar parámetro de entrada (ID del usuario a eliminar)
        stmt.setString(1, idUsuario);

        // Ejecutar el procedimiento
        stmt.execute();
        JOptionPane.showMessageDialog(null, "Usuario eliminado correctamente");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
