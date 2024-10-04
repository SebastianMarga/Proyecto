/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PatronPrototype;

import conection.data.Conection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author vsmv0
 */
public class IMC implements Operaciones{
    private String idIMC;
    private String idUsuario;
    private double peso;
    private double altura;
    private Conection conexion;

    public IMC(String idIMC, String idUsuario, double peso, double altura) throws SQLException {
        this.idIMC = idIMC;
        this.idUsuario = idUsuario;
        this.peso = peso;
        this.altura = altura;
        this.conexion=Conection.getInstance();
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
        IMC imc =null;
        try{
            imc = (IMC)clone();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al clonar");
        }
        return imc;    }

    @Override
    public void insertar() throws SQLException {
        try{
            String query = "INSERT INTO IMC (ID_IMC, ID_USUARIO,PESO, ALTURA) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conexion.getConnection().prepareStatement(query);
            stmt.setString(1, this.idIMC);
            stmt.setString(2, this.idUsuario);
            stmt.setDouble(3, this.peso);
            stmt.setDouble(4, this.altura);
            stmt.executeUpdate();
            System.out.println("IMC insertado: " + this.idIMC);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error");
        }    }

    @Override
    public void actualizar() throws SQLException {
        String query = "UPDATE IMC SET ID_USUARIO = ?, PESO = ?, ALTURA=?, WHERE ID_IMC = ?";
        try {
            PreparedStatement stmt = conexion.getConnection().prepareStatement(query);
            stmt.setString(1, this.idIMC);
            stmt.setString(2, this.idUsuario);
            stmt.setDouble(3, this.peso);
            stmt.setDouble(4, this.altura);
            stmt.executeUpdate();
            System.out.println("IMC actualizado: " + this.idIMC);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error");
        }    }

    @Override
    public void eliminar() throws SQLException {
        try {
            String query = "DELETE FROM USUARIO WHERE ID_IMC = ?";
            PreparedStatement stmt = conexion.getConnection().prepareStatement(query);
            stmt.setString(1, this.idIMC);
            stmt.executeUpdate();
            System.out.println("IMC eliminada: " + this.idIMC);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error");
        }    }
    
}
