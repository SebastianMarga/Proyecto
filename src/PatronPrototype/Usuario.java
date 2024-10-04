/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PatronPrototype;

import conection.data.Conection;
import java.sql.PreparedStatement;
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
    private String fechaNacimiento;
    private String email;
    private Conection conexion;

    public Usuario(String idUsuario, String nombres, String apellidos, String fechaNacimiento, String email) throws SQLException {
        this.idUsuario = idUsuario;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.email = email;
        this.conexion=Conection.getInstance();
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

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    @Override
    public String toString() {
    return "Usuario{id=" + idUsuario + ", nombre=" + nombres + "Apellido "+apellidos+"Fecha de Nacimiento "+fechaNacimiento+"Email "+email;
    }
    @Override
    public void insertar() throws SQLException{
        try{
            Connection conect = conexion.getConnection();
            String query = "INSERT INTO USUARIO (ID_USUARIO, NOMBRES, APELLIDOS, FECHA_NACIMIENTO, EMAIL) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = conexion.getConnection().prepareStatement(query);
            stmt.setString(1, this.idUsuario);
            stmt.setString(2, this.nombres);
            stmt.setString(3, this.apellidos);
            stmt.setString(4, this.fechaNacimiento);
            stmt.setString(5, this.email);
            stmt.executeUpdate();
            System.out.println("Usuario insertado: " + this.idUsuario);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error");
        }
    }

    // Implementación del método actualizar (de la interfaz Operacion)
    @Override
    public void actualizar() throws SQLException {
        String query = "UPDATE USUARIO SET NOMBRES = ?, APELLIDOS = ?, FECHA_NACIMIENTO = ?, EMAIL = ? WHERE ID_USUARIO = ?";
        try (PreparedStatement stmt = conexion.getConnection().prepareStatement(query)) {
            stmt.setString(1, this.nombres);
            stmt.setString(2, this.apellidos);
            stmt.setString(3, this.fechaNacimiento);
            stmt.setString(4, this.email);
            stmt.setString(5, this.idUsuario);
            stmt.executeUpdate();
            System.out.println("Usuario actualizado: " + this.idUsuario);
        }
    }

    // Implementación del método eliminar (de la interfaz Operacion)
    @Override
    public void eliminar() throws SQLException{
        String query = "DELETE FROM USUARIO WHERE ID_USUARIO = ?";
        try (PreparedStatement stmt = conexion.getConnection().prepareStatement(query)) {
            stmt.setString(1, this.idUsuario);
            stmt.executeUpdate();
            System.out.println("Usuario eliminado: " + this.idUsuario);
        }
    }

    @Override
    public Operaciones clonar() {
        Usuario usuario =null;
        try{
            usuario = (Usuario)clone();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al clonar");
        }
        return usuario;
    }
    
}
