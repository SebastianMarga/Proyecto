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
public class ServiciosMedico implements Operaciones{
    private String idservicio;
    private String idusuario;
    private String tipo_servicio;
    private String fecha_servicio;
    private String estado_servicio;
    Services instancia=Services.getInstance();

    public ServiciosMedico(String idservicio, String idusuario, String tipo_servicio, String fecha_servicio, String estado_servicio) throws SQLException{
        this.idservicio = idservicio;
        this.idusuario = idusuario;
        this.tipo_servicio = tipo_servicio;
        this.fecha_servicio = fecha_servicio;
        this.estado_servicio = estado_servicio;
    }

    public String getIdservicio() {
        return idservicio;
    }

    public void setIdservicio(String idservicio) {
        this.idservicio = idservicio;
    }

    public String getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(String idusuario) {
        this.idusuario = idusuario;
    }

    public String getTipo_servicio() {
        return tipo_servicio;
    }

    public void setTipo_servicio(String tipo_servicio) {
        this.tipo_servicio = tipo_servicio;
    }

    public String getFecha_servicio() {
        return fecha_servicio;
    }

    public void setFecha_servicio(String fecha_servicio) {
        this.fecha_servicio = fecha_servicio;
    }

    public String getEstado_servicio() {
        return estado_servicio;
    }

    public void setEstado_servicio(String estado_servicio) {
        this.estado_servicio = estado_servicio;
    }

    @Override
    public Operaciones clonar() {
        try {
            return (ServiciosMedico) super.clone(); // Clonación superficial
        } catch (CloneNotSupportedException e) {
            // Esto nunca debería ocurrir, ya que estamos implementando Cloneable
            throw new RuntimeException("Error al clonar el objeto Servicios Medicos", e);
        }
    }

    @Override
    public void insertar() throws SQLException {
        Connection conexion = instancia.getConnection();
        String query = "{call sp_InsertarServicioMedico(?, ?, ?, ?, ?)}";
        
        try {
            CallableStatement stmt = conexion.prepareCall(query);
            // Establecer los parámetros del procedimiento
        stmt.setString(1, idservicio);
        stmt.setString(2, idusuario);
        stmt.setString(3, tipo_servicio);
        stmt.setString(4, fecha_servicio);
        stmt.setString(5, estado_servicio);
        
        stmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void seleccionar() throws SQLException {
        Connection conexion = instancia.getConnection();
        String sql = "{call sp_ConsultarServiciosMedicos}";
        try{
            CallableStatement stmt =conexion.prepareCall(sql);
            
            // Asignar parámetro de entrada (ID del usuario a seleccionar)
        stmt.setString(1, idservicio);

        // Ejecutar el procedimiento
         ResultSet rs = stmt.executeQuery();

        // Procesar los resultados
        while (rs.next()) {
            String idusuario = rs.getString("ID_SERVICIO");
            String tipo_servicio = rs.getString("TIPO_SERVICIO");
            String fecha_servicio = rs.getString("FECHA_SERVICIO");
            String estado_servicio = rs.getString("ESTADO_SERVICIO");

            System.out.println("ID Usuario: " + idusuario);
            System.out.println("Tipo de servicio: " + tipo_servicio);
            System.out.println("Fecha de servicio: "+fecha_servicio);
            System.out.println("Estado de servicio: "+estado_servicio);}
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar() throws SQLException {
        Connection conexion = instancia.getConnection();
        String sql = "{call sp_EliminarServicioMedico(?)}";
        try{
        CallableStatement stmt = conexion.prepareCall(sql);
        // Asignar parámetro de entrada (ID del usuario a eliminar)
        stmt.setString(1, idservicio);

        // Ejecutar el procedimiento
        stmt.execute();
        JOptionPane.showMessageDialog(null, "Servicios Medicos eliminado correctamente");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
