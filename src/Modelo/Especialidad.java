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
public class Especialidad implements Operaciones{
    private String id_especialidad;
    private String nombre_especialidad;
    private String descripcion;
    Services instancia=Services.getInstance();

    public Especialidad(String id_especialidad, String nombre_especialidad, String descripcion) throws SQLException {
        this.id_especialidad = id_especialidad;
        this.nombre_especialidad = nombre_especialidad;
        this.descripcion = descripcion;
    }

    public String getId_especialidad() {
        return id_especialidad;
    }

    public void setId_especialidad(String id_especialidad) {
        this.id_especialidad = id_especialidad;
    }

    public String getNombre_especialidad() {
        return nombre_especialidad;
    }

    public void setNombre_especialidad(String nombre_especialidad) {
        this.nombre_especialidad = nombre_especialidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public Operaciones clonar() {
       try {
            return (Especialidad) super.clone(); // Clonación superficial
        } catch (CloneNotSupportedException e) {
            // Esto nunca debería ocurrir, ya que estamos implementando Cloneable
            throw new RuntimeException("Error al clonar el objeto Especialidad", e);
        }
    }

    @Override
    public void insertar() throws SQLException {
        Connection conexion = instancia.getConnection();
        String query = "{call sp_InsertarEspecialidad(?, ?, ?)}";
        
        try {
            CallableStatement stmt = conexion.prepareCall(query);
            // Establecer los parámetros del procedimiento
        stmt.setString(1, id_especialidad);
        stmt.setString(2, nombre_especialidad);
        stmt.setString(3, descripcion);
        
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
        stmt.setString(1, id_especialidad);

        // Ejecutar el procedimiento
         ResultSet rs = stmt.executeQuery();

        // Procesar los resultados
        while (rs.next()) {
            String nombre_especialidad = rs.getString("NOMBRE_ESPECIALIDAD");
            String descripcion = rs.getString("DESCRIPCION");

            System.out.println("ID Usuario: " + nombre_especialidad);
            System.out.println("Tipo de servicio: " + descripcion);}
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar() throws SQLException {
        Connection conexion = instancia.getConnection();
        String sql = "{call sp_EliminarEspecialidad(?)}";
        try{
        CallableStatement stmt = conexion.prepareCall(sql);
        // Asignar parámetro de entrada (ID del usuario a eliminar)
        stmt.setString(1, id_especialidad);

        // Ejecutar el procedimiento
        stmt.execute();
        JOptionPane.showMessageDialog(null, "Especialidad eliminado correctamente");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
