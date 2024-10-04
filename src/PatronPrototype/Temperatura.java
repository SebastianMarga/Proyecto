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
public class Temperatura implements Operaciones {
    private String idRegistroTemp;
    private String idUsuario;
    private String fechaHora;
    private double temperatura;
    private Conection conexion;

    public Temperatura(String idRegistroTemp, String idUsuario, String fechaHora, double temperatura) throws SQLException {
        this.idRegistroTemp = idRegistroTemp;
        this.idUsuario = idUsuario;
        this.fechaHora = fechaHora;
        this.temperatura = temperatura;
        this.conexion=Conection.getInstance();
    }

    public String getIdRegistroTemp() {
        return idRegistroTemp;
    }

    public void setIdRegistroTemp(String idRegistroTemp) {
        this.idRegistroTemp = idRegistroTemp;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }
   
    @Override
    public Operaciones clonar() {
      Temperatura temperatura =null;
        try{
            temperatura = (Temperatura)clone();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al clonar");
        }
        return temperatura;
        
    }
    
    @Override
    public void insertar() throws SQLException {
   
        try{
            
            String query = "INSERT INTO TEMPERATURA (ID_REGIS_TEMP, ID_USUARIO,FECHA_HORA, TEMPERATURA) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = this.conexion.getConnection().prepareStatement(query);
            stmt.setString(1, this.idRegistroTemp);
            stmt.setString(2, this.idUsuario);
            stmt.setString(3, this.fechaHora);
            stmt.setDouble(4, this.temperatura);
            stmt.executeUpdate();
            System.out.println("Temperatura insertada: " + this.idRegistroTemp);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error");
        }
    
        
    }

    @Override
    public void actualizar() throws SQLException {
        String query = "UPDATE TEMPERATURA SET ID_USUARIO = ?, FECHA_HORA = ?, TEMPERATURA=?, WHERE ID_REGIS_TEMP = ?";
        try {
            PreparedStatement stmt = conexion.getConnection().prepareStatement(query);
            stmt.setString(1, this.idRegistroTemp);
            stmt.setString(2, this.idUsuario);
            stmt.setString(3, this.fechaHora);
            stmt.setDouble(4, this.temperatura);
            stmt.executeUpdate();
            System.out.println("Temperatura actualizada: " + this.idRegistroTemp);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error");
        }
    }

    @Override
    public void eliminar() throws SQLException {
        Connection conect = conexion.getConnection();
        try {
            String query = "DELETE FROM USUARIO WHERE ID_REGIS_TEMP = ?";
            PreparedStatement stmt = conexion.getConnection().prepareStatement(query);
            stmt.setString(1, this.idRegistroTemp);
            stmt.executeUpdate();
            System.out.println("Temperatura eliminada: " + this.idRegistroTemp);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error");
        }
    }
    
}
