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
public class Movimiento implements Operaciones{
    private String idregisMov;
    private String idusuario;
    private String fecha;
    private int pasototal;
    private String notificacion;

    public Movimiento(String idregisMov, String idusuario, String fecha, int pasototal, String notificacion) {
        this.idregisMov = idregisMov;
        this.idusuario = idusuario;
        this.fecha = fecha;
        this.pasototal = pasototal;
        this.notificacion = notificacion;
    }

    public String getIdregisMov() {
        return idregisMov;
    }

    public void setIdregisMov(String idregisMov) {
        this.idregisMov = idregisMov;
    }

    public String getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(String idusuario) {
        this.idusuario = idusuario;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getPasototal() {
        return pasototal;
    }

    public void setPasototal(int pasototal) {
        this.pasototal = pasototal;
    }

    public String getNotificacion() {
        return notificacion;
    }

    public void setNotificacion(String notificacion) {
        this.notificacion = notificacion;
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
