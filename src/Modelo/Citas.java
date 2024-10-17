/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author vsmv0
 */
public class Citas implements Operaciones{
    private String id_cita;
    private String id_usuario;
    private String id_medico;
    private String fechacita;
    private String horacita;
    private String motivocita;
    private String estado_cita;
    Services instancia=Services.getInstance();

    public Citas(String id_cita, String id_usuario, String id_medico, String fechacita, String horacita, String motivocita, String estado_cita) throws SQLException {
        this.id_cita = id_cita;
        this.id_usuario = id_usuario;
        this.id_medico = id_medico;
        this.fechacita = fechacita;
        this.horacita = horacita;
        this.motivocita = motivocita;
        this.estado_cita = estado_cita;
    }

    public String getId_cita() {
        return id_cita;
    }

    public void setId_cita(String id_cita) {
        this.id_cita = id_cita;
    }

    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getId_medico() {
        return id_medico;
    }

    public void setId_medico(String id_medico) {
        this.id_medico = id_medico;
    }

    public String getFechacita() {
        return fechacita;
    }

    public void setFechacita(String fechacita) {
        this.fechacita = fechacita;
    }

    public String getHoracita() {
        return horacita;
    }

    public void setHoracita(String horacita) {
        this.horacita = horacita;
    }

    public String getMotivocita() {
        return motivocita;
    }

    public void setMotivocita(String motivocita) {
        this.motivocita = motivocita;
    }

    public String getEstado_cita() {
        return estado_cita;
    }

    public void setEstado_cita(String estado_cita) {
        this.estado_cita = estado_cita;
    }

    @Override
    public Operaciones clonar() {
        try {
            return (Citas) super.clone(); // Clonación superficial
        } catch (CloneNotSupportedException e) {
            // Esto nunca debería ocurrir, ya que estamos implementando Cloneable
            throw new RuntimeException("Error al clonar el objeto Citas", e);
        }
    }

    @Override
    public void insertar() throws SQLException {
        Connection conexion = instancia.getConnection();
        String query = "{call sp_InsertarCita(?, ?, ?, ?, ?, ?, ?)}";
        
        try {
            CallableStatement stmt = conexion.prepareCall(query);
            // Establecer los parámetros del procedimiento
        stmt.setString(1, id_cita);
        stmt.setString(2, id_usuario);
        stmt.setString(3, id_medico);
        stmt.setString(4, fechacita);
        stmt.setString(5, horacita);
        stmt.setString(6, motivocita);
        stmt.setString(7, estado_cita);
        
        stmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void seleccionar() throws SQLException {
        Connection conexion = instancia.getConnection();
        String sql = "{call sp_ConsultarCitas}";
        try{
            CallableStatement stmt =conexion.prepareCall(sql);
            
            // Asignar parámetro de entrada (ID del usuario a seleccionar)
        stmt.setString(1, id_cita);

        // Ejecutar el procedimiento
         ResultSet rs = stmt.executeQuery();

        // Procesar los resultados
        while (rs.next()) {
            String id_usuario = rs.getString("ID_USUARIO");
            String id_medico = rs.getString("ID_MEDICO");
            String fechacita = rs.getString("FECHA_CITA");
            String horacita =rs.getString("HORA_CITA");
            String motivocita =rs.getString("MOTIVO_CITA");
            String estado_cita =rs.getString("ESTADO_CITA");

            System.out.println("ID Usuario: " + id_usuario);
            System.out.println("Medico: " + id_medico);
            System.out.println("Fecha de la cita: "+fechacita);
            System.out.println("Hora de la cita: "+horacita);
            System.out.println("Motivo de la cita: "+motivocita);
            System.out.println("Estado de la cita: "+estado_cita);}
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar() throws SQLException {
         Connection conexion = instancia.getConnection();
        String sql = "{call sp_EliminarCita(?)}";
        try{
        CallableStatement stmt = conexion.prepareCall(sql);
        // Asignar parámetro de entrada (ID del usuario a eliminar)
        stmt.setString(1, id_cita);

        // Ejecutar el procedimiento
        stmt.execute();
        JOptionPane.showMessageDialog(null, "Citas eliminado correctamente");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
}
