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
public class Historial implements Operaciones{
    private String idhistorial;
    private String idusuario;
    private String fecha_visita;
    private String tipo_visita;
    private String Resultados;
    private String observaciones;
    private String prox_visita;

    public Historial(String idhistorial, String idusuario, String fecha_visita, String tipo_visita, String Resultados, String observaciones, String prox_visita) {
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
