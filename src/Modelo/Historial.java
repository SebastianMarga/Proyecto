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
public class Historial implements Operaciones{
    private int idhistorial;
    private int idusuario;
    private String diagnostico;
    private String tratamiento;
    private String fecha_registro;
    Services instancia=Services.getInstance();


    public Historial(HistorialBuilder builder) throws SQLException {
        this.idhistorial = builder.idhistorial;
        this.idusuario = builder.idusuario;
        this.diagnostico = builder.diagnostico;
        this.tratamiento = builder.tratamiento;
        this.fecha_registro = builder.fecha_registro;
    }

    public int getIdhistorial() {
        return idhistorial;
    }

    public void setIdhistorial(int idhistorial) {
        this.idhistorial = idhistorial;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public String getdiagnostico() {
        return diagnostico;
    }

    public void setdiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public String getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(String Fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public static class HistorialBuilder{
        private int idhistorial;
        private int idusuario;
        private String diagnostico;
        private String tratamiento;
        private String fecha_registro;
        
        public HistorialBuilder(int idhistorial){
            this.idhistorial=idhistorial;
        }
        public HistorialBuilder usuario(int idusuario){
            this.idusuario=idusuario;
            return this;
        }
        public HistorialBuilder diagnostico(String diagnostico){
            this.diagnostico=diagnostico;
            return this;
        }
        public HistorialBuilder tratamiento(String tratamiento){
            this.tratamiento=tratamiento;
            return this;
        }
        public HistorialBuilder fecha_registro(String fecha_registro){
            this.fecha_registro=fecha_registro;
            return this;
        }
        public Historial construir() throws SQLException{
            return new Historial(this);
        }
    }

    @Override
    public Operaciones clonar() {
        try {
            return (Historial) super.clone(); // Clonación superficial
        } catch (CloneNotSupportedException e) {
            // Esto nunca debería ocurrir, ya que estamos implementando Cloneable
            throw new RuntimeException("Error al clonar el objeto Historial", e);
        }
    }

    @Override
    public void insertar() throws SQLException {
        Connection conexion = instancia.getConnection();
        String query = "{call InsertarHistorialMedico(?, ?, ?, ?)}";
        
        try {
            CallableStatement stmt = conexion.prepareCall(query);
            // Establecer los parámetros del procedimiento
        stmt.setInt(1, idusuario);
        stmt.setString(2, diagnostico);
        stmt.setString(3, tratamiento);
        stmt.setString(4, fecha_registro);
        
        stmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void seleccionar() throws SQLException {
        Connection conexion = instancia.getConnection();
        String sql = "{call SeleccionarHistorialMedico}";
        try{
            CallableStatement stmt =conexion.prepareCall(sql);
            
            // Asignar parámetro de entrada (ID del usuario a seleccionar)
        stmt.setInt(1, idhistorial);

        // Ejecutar el procedimiento
         ResultSet rs = stmt.executeQuery();

        // Procesar los resultados
        while (rs.next()) {
            String idUsuario = rs.getString("paciente_id");
            String diagnostico = rs.getString("diagnostico");
            String tratamiento = rs.getString("tratamiento");
            Date fecha_registro = rs.getDate("fecha_registro");

            System.out.println("Id Usuario: " + idUsuario);
            System.out.println("Diagnostico: " + diagnostico);
            System.out.println("Tratamiento: "+tratamiento);
            System.out.println("Fecha_registro: " + fecha_registro);}
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar() throws SQLException {
        Connection conexion = instancia.getConnection();
        String sql = "{call EliminarHistorialMedico(?)}";
        try{
        CallableStatement stmt = conexion.prepareCall(sql);
        // Asignar parámetro de entrada (ID del usuario a eliminar)
        stmt.setInt(1, idhistorial);

        // Ejecutar el procedimiento
        stmt.execute();
        JOptionPane.showMessageDialog(null, "Historial Medico eliminado correctamente");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
}
