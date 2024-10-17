/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author vsmv0
 */
public class Temperatura implements Operaciones{
    private String idRegistroTemp;
    private String idUsuario;
    private String fechaHora;
    private double temperatura;
    Services instancia=Services.getInstance();

    public Temperatura(String idRegistroTemp, String idUsuario, String fechaHora, double temperatura) throws SQLException {
        this.idRegistroTemp = idRegistroTemp;
        this.idUsuario = idUsuario;
        this.fechaHora = fechaHora;
        this.temperatura = temperatura;
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
        try {
            return (Temperatura) super.clone(); // Clonación superficial
        } catch (CloneNotSupportedException e) {
            // Esto nunca debería ocurrir, ya que estamos implementando Cloneable
            throw new RuntimeException("Error al clonar el objeto Temperatura", e);
        }
    }

    @Override
    public void insertar() throws SQLException {
        Connection conexion = instancia.getConnection();
        String query = "{call sp_InsertarTemperatura(?, ?, ?, ?)}";
        
        try {
            CallableStatement stmt = conexion.prepareCall(query);
            // Establecer los parámetros del procedimiento
        stmt.setString(1, idRegistroTemp);
        stmt.setString(2, idUsuario);
        stmt.setString(3, fechaHora);
        stmt.setDouble(4, temperatura);
        
        stmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void seleccionar() throws SQLException {
        Connection conexion = instancia.getConnection();
        String sql = "{call sp_ConsultarTemperatura}";
        try{
            CallableStatement stmt =conexion.prepareCall(sql);
            
            // Asignar parámetro de entrada (ID del usuario a seleccionar)
        stmt.setString(1, idRegistroTemp);

        // Ejecutar el procedimiento
         ResultSet rs = stmt.executeQuery();

        // Procesar los resultados
        while (rs.next()) {
            String idUsuario = rs.getString("ID_USUARIO");
            Date fechaHora = rs.getDate("FECHA_HORA");
            String temperatura = rs.getString("TEMPERATURA");

            System.out.println("Id Usuario: " + idUsuario);
            System.out.println("Fecha y Hora: " + fechaHora);
            System.out.println("Temperatura: " + temperatura+"°");}
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar() throws SQLException {
        Connection conexion = instancia.getConnection();
        String sql = "{call sp_EliminarTemperatura(?)}";
        try{
        CallableStatement stmt = conexion.prepareCall(sql);
        // Asignar parámetro de entrada (ID del usuario a eliminar)
        stmt.setString(1, idRegistroTemp);

        // Ejecutar el procedimiento
        stmt.execute();
        JOptionPane.showMessageDialog(null, "Temperatura eliminada correctamente");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
