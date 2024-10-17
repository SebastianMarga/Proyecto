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
public class DisponibilidadMedica implements Operaciones{
    private String id_disponibilidad;
    private String id_medico;
    private String fecha_disponibilidad;
    private String estado_disponibilidad;
    Services instancia=Services.getInstance();

    public DisponibilidadMedica(String id_disponibilidad, String id_medico, String fecha_disponibilidad, String estado_disponibilidad) throws SQLException {
        this.id_disponibilidad = id_disponibilidad;
        this.id_medico = id_medico;
        this.fecha_disponibilidad = fecha_disponibilidad;
        this.estado_disponibilidad = estado_disponibilidad;
    }

    public String getId_disponibilidad() {
        return id_disponibilidad;
    }

    public void setId_disponibilidad(String id_disponibilidad) {
        this.id_disponibilidad = id_disponibilidad;
    }

    public String getId_medico() {
        return id_medico;
    }

    public void setId_medico(String id_medico) {
        this.id_medico = id_medico;
    }

    public String getFecha_disponibilidad() {
        return fecha_disponibilidad;
    }

    public void setFecha_disponibilidad(String fecha_disponibilidad) {
        this.fecha_disponibilidad = fecha_disponibilidad;
    }

    public String getEstado_disponibilidad() {
        return estado_disponibilidad;
    }

    public void setEstado_disponibilidad(String estado_disponibilidad) {
        this.estado_disponibilidad = estado_disponibilidad;
    }

    @Override
    public Operaciones clonar() {
        try {
            return (DisponibilidadMedica) super.clone(); // Clonación superficial
        } catch (CloneNotSupportedException e) {
            // Esto nunca debería ocurrir, ya que estamos implementando Cloneable
            throw new RuntimeException("Error al clonar el objeto Disponibilidad Medica", e);
        }
    }

    @Override
    public void insertar() throws SQLException {
        Connection conexion = instancia.getConnection();
        String query = "{call sp_InsertarCita(?, ?, ?, ?)}";
        
        try {
            CallableStatement stmt = conexion.prepareCall(query);
            // Establecer los parámetros del procedimiento
        stmt.setString(1, id_disponibilidad);
        stmt.setString(2, id_medico);
        stmt.setString(3,  fecha_disponibilidad);
        stmt.setString(4, estado_disponibilidad);
        
        
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
        stmt.setString(1, id_disponibilidad);

        // Ejecutar el procedimiento
         ResultSet rs = stmt.executeQuery();

        // Procesar los resultados
        while (rs.next()) {
            String id_medico = rs.getString("ID_MEDICO");
            String fecha_disponibilidad = rs.getString("FECHA_DISPONIBILIDAD");
            String estado_disponibilidad = rs.getString("ESTADO_DISPONIBILIDAD");

            System.out.println("ID Medico: " + id_medico);
            System.out.println("Medico: " + fecha_disponibilidad);
            System.out.println("Estado de disponibilidad: "+estado_disponibilidad);}
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
        stmt.setString(1, id_disponibilidad);

        // Ejecutar el procedimiento
        stmt.execute();
        JOptionPane.showMessageDialog(null, "Disponibilidad Medica eliminado correctamente");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
}
