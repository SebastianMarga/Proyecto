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
    private String idhistorial;
    private String idusuario;
    private String fecha_visita;
    private String tipo_visita;
    private String Resultados;
    private String observaciones;
    private String prox_visita;
    Services instancia=Services.getInstance();


    public Historial(String idhistorial, String idusuario, String fecha_visita, String tipo_visita, String Resultados, String observaciones, String prox_visita) throws SQLException {
        this.idhistorial = idhistorial;
        this.idusuario = idusuario;
        this.fecha_visita = fecha_visita;
        this.tipo_visita = tipo_visita;
        this.Resultados = Resultados;
        this.observaciones = observaciones;
        this.prox_visita = prox_visita;
    }

    public String getIdhistorial() {
        return idhistorial;
    }

    public void setIdhistorial(String idhistorial) {
        this.idhistorial = idhistorial;
    }

    public String getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(String idusuario) {
        this.idusuario = idusuario;
    }

    public String getFecha_visita() {
        return fecha_visita;
    }

    public void setFecha_visita(String fecha_visita) {
        this.fecha_visita = fecha_visita;
    }

    public String getTipo_visita() {
        return tipo_visita;
    }

    public void setTipo_visita(String tipo_visita) {
        this.tipo_visita = tipo_visita;
    }

    public String getResultados() {
        return Resultados;
    }

    public void setResultados(String Resultados) {
        this.Resultados = Resultados;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getProx_visita() {
        return prox_visita;
    }

    public void setProx_visita(String prox_visita) {
        this.prox_visita = prox_visita;
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
        String query = "{call sp_InsertarHistorialMedico(?, ?, ?, ?, ?, ?, ?)}";
        
        try {
            CallableStatement stmt = conexion.prepareCall(query);
            // Establecer los parámetros del procedimiento
        stmt.setString(1, idhistorial);
        stmt.setString(2, idusuario);
        stmt.setString(3, fecha_visita);
        stmt.setString(4, tipo_visita);
        stmt.setString(5, Resultados);
        stmt.setString(6, observaciones);
        stmt.setString(7, prox_visita);
        
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
        stmt.setString(1, idhistorial);

        // Ejecutar el procedimiento
         ResultSet rs = stmt.executeQuery();

        // Procesar los resultados
        while (rs.next()) {
            String idUsuario = rs.getString("ID_USUARIO");
            Date fecha_visita = rs.getDate("FECHA_VISITA");
            String tipo_visita = rs.getString("TIPO_VISITA");
            String Resultados = rs.getString("RESULTADOS_EXAMENES");
            String observaciones = rs.getString("OBSERVACIONES");
            String prox_visita = rs.getString("PROXIMA_VISITA");

            System.out.println("Id Usuario: " + idUsuario);
            System.out.println("Fecha: " + fecha_visita);
            System.out.println("Tipo de visita: "+tipo_visita);
            System.out.println("Resultados: " + Resultados);
            System.out.println("Observaciones: "+observaciones);
            System.out.println("Proxima visita: "+prox_visita);}
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
        stmt.setString(1, idhistorial);

        // Ejecutar el procedimiento
        stmt.execute();
        JOptionPane.showMessageDialog(null, "Historial Medico eliminado correctamente");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
}
