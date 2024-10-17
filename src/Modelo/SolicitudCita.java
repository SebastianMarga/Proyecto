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
public class SolicitudCita implements Operaciones{
    private String id_solicitud;
    private String id_usuario;
    private String fecha_solicitud;
    private String fecha_cita;
    private String estado_cita;
    private String recordatorio;
    Services instancia=Services.getInstance();

    public SolicitudCita(SolicitudCitasBuilder builder) throws SQLException {
        this.id_solicitud = builder.id_solicitud;
        this.id_usuario = builder.id_usuario;
        this.fecha_solicitud = builder.fecha_solicitud;
        this.fecha_cita = builder.fecha_cita;
        this.estado_cita = builder.estado_cita;
        this.recordatorio = builder.recordatorio;
    }

    public String getId_solicitud() {
        return id_solicitud;
    }

    public void setId_solicitud(String id_solicitud) {
        this.id_solicitud = id_solicitud;
    }

    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getFecha_solicitud() {
        return fecha_solicitud;
    }

    public void setFecha_solicitud(String fecha_solicitud) {
        this.fecha_solicitud = fecha_solicitud;
    }

    public String getFecha_cita() {
        return fecha_cita;
    }

    public void setFecha_cita(String fecha_cita) {
        this.fecha_cita = fecha_cita;
    }

    public String getEstado_cita() {
        return estado_cita;
    }

    public void setEstado_cita(String estado_cita) {
        this.estado_cita = estado_cita;
    }

    public String getRecordatorio() {
        return recordatorio;
    }

    public void setRecordatorio(String recordatorio) {
        this.recordatorio = recordatorio;
    }
    
    public static class SolicitudCitasBuilder{
        private String id_solicitud;
        private String id_usuario;
        private String fecha_solicitud;
        private String fecha_cita;
        private String estado_cita;
        private String recordatorio;
        public SolicitudCitasBuilder(String id_solicitud){
            this.id_solicitud=id_solicitud;
        }
        public SolicitudCitasBuilder Usuario(String id_usuario){
            this.id_usuario=id_usuario;
            return this;
        }
        public SolicitudCitasBuilder Solicitud(String fecha_solicitud){
            this.fecha_solicitud=fecha_solicitud;
            return this;
        }
        public SolicitudCitasBuilder Fecha(String fecha_cita){
            this.fecha_cita=fecha_cita;
            return this;
        }
        public SolicitudCitasBuilder Estado(String estado_cita){
            this.estado_cita=estado_cita;
            return this;
        }
        public SolicitudCitasBuilder Recordatorio(String recordatorio){
            this.recordatorio=recordatorio;
            return this;
        }
        public SolicitudCita construir() throws SQLException{
            return new SolicitudCita(this);
        }
    }
    @Override
    public Operaciones clonar() {
        try {
            return (SolicitudCita) super.clone(); // Clonación superficial
        } catch (CloneNotSupportedException e) {
            // Esto nunca debería ocurrir, ya que estamos implementando Cloneable
            throw new RuntimeException("Error al clonar el objeto Solicitud", e);
        }
    }

    @Override
    public void insertar() throws SQLException {
        Connection conexion = instancia.getConnection();
        String query = "{call sp_InsertarSolicitudCita(?, ?, ?, ?, ?, ?)}";
        
        try {
            CallableStatement stmt = conexion.prepareCall(query);
            // Establecer los parámetros del procedimiento
        stmt.setString(1, id_solicitud);
        stmt.setString(2, id_usuario);
        stmt.setString(3, fecha_solicitud);
        stmt.setString(4, fecha_cita);
        stmt.setString(5, estado_cita);
        stmt.setString(6, recordatorio);
        
        stmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void seleccionar() throws SQLException {
        Connection conexion = instancia.getConnection();
        String sql = "{call sp_ConsultarHistorialMedico}";
        try{
            CallableStatement stmt =conexion.prepareCall(sql);
            
            // Asignar parámetro de entrada (ID del usuario a seleccionar)
        stmt.setString(1, id_solicitud);

        // Ejecutar el procedimiento
         ResultSet rs = stmt.executeQuery();

        // Procesar los resultados
        while (rs.next()) {
            String idUsuario = rs.getString("ID_USUARIO");
            Date fecha_solicitud = rs.getDate("FECHA_SOLICITUD");
            Date fecha_cita = rs.getDate("FECHA_CITA");
            String estado_cita = rs.getString("ESTADO_CITA");
            String recordatorio = rs.getString("RECORDATORIO_ENVIADO");

            System.out.println("Id Usuario: " + idUsuario);
            System.out.println("Fecha de solicitud: " + fecha_solicitud);
            System.out.println("Fecha de la cita: "+fecha_cita);
            System.out.println("Estado de cita: "+estado_cita);
            System.out.println("Recordatorio: " + recordatorio);}
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar() throws SQLException {
        Connection conexion = instancia.getConnection();
        String sql = "{call sp_EliminarHistorialMedica(?)}";
        try{
        CallableStatement stmt = conexion.prepareCall(sql);
        // Asignar parámetro de entrada (ID del usuario a eliminar)
        stmt.setString(1, id_solicitud);

        // Ejecutar el procedimiento
        stmt.execute();
        JOptionPane.showMessageDialog(null, "Solicitud Cita eliminado correctamente");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
}
