/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.SQLException;

/**
 *
 * @author vsmv0
 */
public class DisponibilidadMedica implements Operaciones{
    private String id_disponibilidad;
    private String id_medico;
    private String fecha_disponibilidad;
    private String estado_disponibilidad;

    public DisponibilidadMedica(String id_disponibilidad, String id_medico, String fecha_disponibilidad, String estado_disponibilidad) {
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insertar() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void seleccionar() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminar() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
