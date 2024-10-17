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
        try {
            return (IMC) super.clone(); // Clonación superficial
        } catch (CloneNotSupportedException e) {
            // Esto nunca debería ocurrir, ya que estamos implementando Cloneable
            throw new RuntimeException("Error al clonar el objeto IMC", e);
        }
    }

    @Override
    public void insertar() throws SQLException {
        Connection conexion = instancia.getConnection();
        String query = "{call sp_InsertarIMC(?, ?, ?, ?)}";
        
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
        Connection conexion = instancia.getConnection();
        String sql = "{call sp_ConsultarIMC}";
        try{
            CallableStatement stmt =conexion.prepareCall(sql);
            
            // Asignar parámetro de entrada (ID del usuario a seleccionar)
        stmt.setString(1, idIMC);

        // Ejecutar el procedimiento
        ResultSet rs = stmt.executeQuery();

        // Procesar los resultados
        while (rs.next()) {
            String idUsuario = rs.getString("ID_USUARIO");
            Double peso = rs.getDouble("PESO");
            Double altura = rs.getDouble("ALTURA");

            System.out.println("ID USUARIO: " +  idUsuario);
            System.out.println("Peso: " + peso);
            System.out.println("Altura: " + altura);}
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }

    @Override
    public void eliminar() throws SQLException {
        Connection conexion = instancia.getConnection();
        String sql = "{call sp_EliminarIMC(?)}";
        try{
        CallableStatement stmt = conexion.prepareCall(sql);
        // Asignar parámetro de entrada (ID del usuario a eliminar)
        stmt.setString(1, idIMC);

        // Ejecutar el procedimiento
        stmt.execute();
        JOptionPane.showMessageDialog(null, "IMC eliminado correctamente");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
