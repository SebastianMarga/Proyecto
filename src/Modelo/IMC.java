/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.CallableStatement;
import java.sql.*;
import java.sql.ResultSet;
import java.sql.Date;




/**
 *
 * @author vsmv0
 */
public class IMC implements Operaciones {
    private String idIMC;
    private String idUsuario;
    private double peso;
    private double altura;
    Services instancia=Services.getInstance();
    public IMC(String idIMC, String idUsuario, double peso, double altura) throws SQLException {
        this.idIMC = idIMC;
        this.idUsuario = idUsuario;
        this.peso = peso;
        this.altura = altura;
    }

    public String getIdIMC() {
        return idIMC;
    }

    public void setIdIMC(String idIMC) {
        this.idIMC = idIMC;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    @Override
    public Operaciones clonar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insertar() throws SQLException {
        Connection conexion = instancia.getConnection();
        String query = "{call sp_InsertarUsuario(?, ?, ?, ?)}";
        
        try {
            CallableStatement stmt = conexion.prepareCall(query);
            // Establecer los parámetros del procedimiento
        stmt.setString(1, idIMC);
        stmt.setString(2, idUsuario);
        stmt.setDouble(3, peso);
        stmt.setDouble(4, altura);
        
        stmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void seleccionar() throws SQLException {
        /*Connection conexion = instancia.getConnection();
        String sql = "{call sp_ConsultarUsuarios}";
        try{
            CallableStatement stmt =conexion.prepareCall(sql);
            
            // Asignar parámetro de entrada (ID del usuario a seleccionar)
        stmt.setString(1, idUsuario);

        // Ejecutar el procedimiento
         rs = stmt.executeQuery();

        // Procesar los resultados
        while (rs.next()) {
            String nombres = rs.getString("NOMBRES");
            String apellidos = rs.getString("APELLIDOS");
            Date fechaNacimiento = rs.getDate("FECHA_NACIMIENTO");
            String email = rs.getString("EMAIL");

            System.out.println("Usuario: " + nombres + " " + apellidos);
            System.out.println("Fecha de Nacimiento: " + fechaNacimiento);
            System.out.println("Email: " + email);}
        }catch(Exception e){
            e.printStackTrace();
        }
        */
    }

    @Override
    public void eliminar() throws SQLException {
        Connection conexion = instancia.getConnection();
        String sql = "{call sp_ActualizarUsuario(?)}";
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
