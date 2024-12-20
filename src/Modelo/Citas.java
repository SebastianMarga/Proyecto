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
public class Citas implements Operaciones, Cloneable{


/**
 *
 * @author vsmv0
 */

    private int id_cita;
    private int id_usuario;
    private int id_medico;
    private int id_clinica;
    private  String fecha_cita;
    private String motivo;
    private String estado_cita;
    Services instancia=Services.getInstance();

    public Citas(CitasBuilder builder) throws SQLException {
        this.id_cita = builder.id_cita;
        this.id_usuario = builder.id_usuario;
        this.id_medico = builder.id_medico;
        this.id_clinica = builder.id_clinica;
        this.fecha_cita = builder.fecha_cita;
        this.motivo = builder.motivo;
        this.estado_cita = builder.estado_cita;
    }

    public int getId_cita() {
        return id_cita;
    }

    public void setId_cita(int id_cita) {
        this.id_cita = id_cita;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_medico() {
        return id_medico;
    }

    public void setId_medico(int id_medico) {
        this.id_medico = id_medico;
    }

    public int getId_clinica() {
        return id_clinica;
    }

    public void setId_clinica(int id_clinica) {
        this.id_clinica = id_clinica;
    }

    public String getFecha_Cita() {
        return fecha_cita;
    }

    public void setFecha_Cita(String fecha_cita) {
        this.fecha_cita = fecha_cita;
    }

    public String getMotivocita() {
        return motivo;
    }

    public void setMotivocita(String motivocita) {
        this.motivo = motivocita;
    }

    public String getEstado_cita() {
        return estado_cita;
    }

    public void setEstado_cita(String estado_cita) {
        this.estado_cita = estado_cita;
    }
    
    //Ptron Builder
    public static class CitasBuilder{
        private int id_cita;
        private int id_usuario;
        private int id_medico;
        private int id_clinica;
        private String fecha_cita;
        private String motivo;
        private String estado_cita;
    
       public CitasBuilder(int id_cita){
           this.id_cita=id_cita;
       }
       public CitasBuilder Usuario(int id_usuario){
           this.id_usuario=id_usuario;
           return this;
       }
       public CitasBuilder Medico(int id_medico){
           this.id_medico=id_medico;
           return this;
       }
       public CitasBuilder Clinica(int id_clinica){
           this.id_clinica=id_clinica;
           return this;
       }
       public CitasBuilder Fecha_cita(String fecha_cita){
           this.fecha_cita=fecha_cita;
           return this;
       }
       public CitasBuilder motivo(String motivo){
           this.motivo=motivo;
           return this;
       }
       public CitasBuilder estado(String estado_cita){
           this.estado_cita=estado_cita;
           return this;
       }
       public Citas construir() throws SQLException  {
           return new Citas(this);
       }
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
        String query = "{call InsertarCita(?, ?, ?, ?, ?, ?)}";
        
        try {
            CallableStatement stmt = conexion.prepareCall(query);
            // Establecer los parámetros del procedimiento
        stmt.setInt(1, id_usuario);
        stmt.setInt(2, id_medico);
        stmt.setInt(3, id_clinica);
        stmt.setString(4,  fecha_cita);
        stmt.setString(5, motivo);
        stmt.setString(6, estado_cita);
        
        stmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void seleccionar() throws SQLException {
        Connection conexion = instancia.getConnection();
        String sql = "{call SeleccionarCitas}";
        try{
            CallableStatement stmt =conexion.prepareCall(sql);
            

        // Ejecutar el procedimiento
         ResultSet rs = stmt.executeQuery();

        // Procesar los resultados
        while (rs.next()) {
            String id_usuario = rs.getString("paciente_id");
            String id_medico = rs.getString("doctor_id");
            String id_clinica = rs.getString("clinica_id");
            String fecha_cita =rs.getString("fecha_cita");
            String motivo =rs.getString("motivo");
            String estado_cita =rs.getString("estado");

            System.out.println("ID Usuario: " + id_usuario);
            System.out.println("Medico: " + id_medico);
            System.out.println("Clinica: "+id_clinica);
            System.out.println("Fecha de la cita: "+fecha_cita);
            System.out.println("Motivo de la cita: "+motivo);
            System.out.println("Estado de la cita: "+estado_cita);}
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar() throws SQLException {
         Connection conexion = instancia.getConnection();
        String sql = "{call EliminarCita(?)}";
        try{
        CallableStatement stmt = conexion.prepareCall(sql);
        // Asignar parámetro de entrada (ID del usuario a eliminar)
        stmt.setInt(1, id_cita);

        // Ejecutar el procedimiento
        stmt.execute();
        JOptionPane.showMessageDialog(null, "Citas eliminado correctamente");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
}


