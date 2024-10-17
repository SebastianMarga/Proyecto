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
public class Movimiento implements Operaciones{
    private String idregisMov;
    private String idusuario;
    private String fecha;
    private int pasototal;
    private String notificacion;    
    Services instancia=Services.getInstance();

    public Movimiento(String idregisMov, String idusuario, String fecha, int pasototal, String notificacion)throws SQLException {
        this.idregisMov = idregisMov;
        this.idusuario = idusuario;
        this.fecha = fecha;
        this.pasototal = pasototal;
        this.notificacion = notificacion;
    }

    public String getIdregisMov() {
        return idregisMov;
    }

    public void setIdregisMov(String idregisMov) {
        this.idregisMov = idregisMov;
    }

    public String getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(String idusuario) {
        this.idusuario = idusuario;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getPasototal() {
        return pasototal;
    }

    public void setPasototal(int pasototal) {
        this.pasototal = pasototal;
    }

    public String getNotificacion() {
        return notificacion;
    }

    public void setNotificacion(String notificacion) {
        this.notificacion = notificacion;
    }

    @Override
    public Operaciones clonar() {
    try {
            return (Movimiento) super.clone(); // Clonación superficial
        } catch (CloneNotSupportedException e) {
            // Esto nunca debería ocurrir, ya que estamos implementando Cloneable
            throw new RuntimeException("Error al clonar el objeto Movimiento", e);
        }
    }

    @Override
    public void insertar() throws SQLException {
        Connection conexion = instancia.getConnection();
        String query = "{call sp_InsertarPulso(?, ?, ?, ?, ?)}";
        
        try {
            CallableStatement stmt = conexion.prepareCall(query);
            // Establecer los parámetros del procedimiento
        stmt.setString(1, idregisMov);
        stmt.setString(2, idusuario);
        stmt.setString(3, fecha);
        stmt.setInt(4, pasototal);
        stmt.setString(5, notificacion);
        
        stmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void seleccionar() throws SQLException {
        Connection conexion = instancia.getConnection();
        String sql = "{call sp_ConsultarMovimiento}";
        try{
            CallableStatement stmt =conexion.prepareCall(sql);
            
            // Asignar parámetro de entrada (ID del usuario a seleccionar)
        stmt.setString(1, idregisMov);

        // Ejecutar el procedimiento
         ResultSet rs = stmt.executeQuery();

        // Procesar los resultados
        while (rs.next()) {
            String idusuario = rs.getString("ID_USUARIO");
            Date fecha = rs.getDate("FECHA");
            int pasototal = rs.getInt("PASOS_TOTALES");
            String notificacion= rs.getString("NOTIFICACION_1000_PASOS");

            System.out.println("Id Usuario: " + idusuario);
            System.out.println("Fecha y Hora: " + fecha);
            System.out.println("Valor Pulso: " + pasototal);
            System.out.println("Notificacion: "+ notificacion);}
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar() throws SQLException {
        Connection conexion = instancia.getConnection();
        String sql = "{call sp_EliminarMovimiento(?)}";
        try{
        CallableStatement stmt = conexion.prepareCall(sql);
        // Asignar parámetro de entrada (ID del usuario a eliminar)
        stmt.setString(1, idregisMov);

        // Ejecutar el procedimiento
        stmt.execute();
        JOptionPane.showMessageDialog(null, "Movimiento eliminado correctamente");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
}
