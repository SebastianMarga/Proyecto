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
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

public class IMC implements IMCComponente {
    private String idIMC;
    private String idUsuario;
    private double peso;
    private double altura;  // Asumiendo que esta variable está definida
    private Services instancia = Services.getInstance();
    
    // Lista para contener subcomponentes IMC (si es necesario)
    private List<IMCComponente> children = new ArrayList<>();

    public IMC(String idIMC, String idUsuario, double peso, double altura) throws SQLException {
        this.idIMC = idIMC;
        this.idUsuario = idUsuario;
        this.peso = peso;
        this.altura = altura;
    }

    // Métodos getter y setter...

    @Override
    public void insertar() throws SQLException {
        Connection conexion = instancia.getConnection();
        String query = "{call sp_InsertarIMC(?, ?, ?, ?)}";
        
        try {
            CallableStatement stmt = conexion.prepareCall(query);
            stmt.setString(1, idIMC);
            stmt.setString(2, idUsuario);
            stmt.setDouble(3, peso);
            stmt.setDouble(4, altura);
            
            stmt.execute();
            // Insertar también en hijos, si hay
            for (IMCComponente child : children) {
                child.insertar();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void seleccionar() throws SQLException {
        Connection conexion = instancia.getConnection();
        String sql = "{call sp_ConsultarIMC}";
        try {
            CallableStatement stmt = conexion.prepareCall(sql);
            stmt.setString(1, idIMC);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                String idUsuario = rs.getString("ID_USUARIO");
                double peso = rs.getDouble("PESO");
                double altura = rs.getDouble("ALTURA");

                System.out.println("ID USUARIO: " + idUsuario);
                System.out.println("Peso: " + peso);
                System.out.println("Altura: " + altura);
            }
            // Seleccionar también en hijos, si hay
            for (IMCComponente child : children) {
                child.seleccionar();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar() throws SQLException {
        Connection conexion = instancia.getConnection();
        String sql = "{call sp_EliminarIMC(?)}";
        try {
            CallableStatement stmt = conexion.prepareCall(sql);
            stmt.setString(1, idIMC);
            stmt.execute();
            JOptionPane.showMessageDialog(null, "IMC eliminado correctamente");

            // Eliminar también en hijos, si hay
            for (IMCComponente child : children) {
                child.eliminar();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Método para agregar un hijo
    public void addChild(IMCComponente child) {
        children.add(child);
    }

    // Método para remover un hijo
    public void removeChild(IMCComponente child) {
        children.remove(child);
    }
}
