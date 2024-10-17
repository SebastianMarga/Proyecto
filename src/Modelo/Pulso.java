/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import javax.swing.JOptionPane;


/**
 *
 * @author vsmv0
 */
public class Pulso implements Operaciones{
    private String idRegistropulso;
    private String idUsuario;
    private String fechaHora;
    private int valorpulso;
    Services instancia=Services.getInstance();

    public Pulso(String idRegistropulso, String idUsuario, String fechaHora, int valorpulso) throws SQLException {
        this.idRegistropulso = idRegistropulso;
        this.idUsuario = idUsuario;
        this.fechaHora = fechaHora;
        this.valorpulso = valorpulso;
    }

    public String getIdRegistropulso() {
        return idRegistropulso;
    }

    public void setIdRegistropulso(String idRegistropulso) {
        this.idRegistropulso = idRegistropulso;
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

    public int getValorpulso() {
        return valorpulso;
    }

    public void setValorpulso(int valorpulso) {
        this.valorpulso = valorpulso;
    }

    @Override
    public Operaciones clonar() {
        try {
            return (Pulso) super.clone(); // Clonación superficial
        } catch (CloneNotSupportedException e) {
            // Esto nunca debería ocurrir, ya que estamos implementando Cloneable
            throw new RuntimeException("Error al clonar el objeto Pulso", e);
        }
    }

    @Override
    public void insertar() throws SQLException {
        Connection conexion = instancia.getConnection();
        String query = "{call sp_InsertarPulso(?, ?, ?, ?)}";
        
        try {
            CallableStatement stmt = conexion.prepareCall(query);
            // Establecer los parámetros del procedimiento
        stmt.setString(1, idRegistropulso);
        stmt.setString(2, idUsuario);
        stmt.setString(3, fechaHora);
        stmt.setInt(4, valorpulso);
        
        stmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void seleccionar() throws SQLException {
        Connection conexion = instancia.getConnection();
        String sql = "{call sp_ConsultarPulso}";
        try{
            CallableStatement stmt =conexion.prepareCall(sql);
            
            // Asignar parámetro de entrada (ID del usuario a seleccionar)
        stmt.setString(1, idRegistropulso);

        // Ejecutar el procedimiento
         ResultSet rs = stmt.executeQuery();

        // Procesar los resultados
        while (rs.next()) {
            String idUsuario = rs.getString("ID_USUARIO");
            Date fechaHora = rs.getDate("FECHA_HORA");
            String valorpulso = rs.getString("VALOR_PULSO");

            System.out.println("Id Usuario: " + idUsuario);
            System.out.println("Fecha y Hora: " + fechaHora);
            System.out.println("Valor Pulso: " + valorpulso);}
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar() throws SQLException {
        Connection conexion = instancia.getConnection();
        String sql = "{call sp_EliminarPulso(?)}";
        try{
        CallableStatement stmt = conexion.prepareCall(sql);
        // Asignar parámetro de entrada (ID del usuario a eliminar)
        stmt.setString(1, idRegistropulso);

        // Ejecutar el procedimiento
        stmt.execute();
        JOptionPane.showMessageDialog(null, "Pulso eliminado correctamente");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
}
