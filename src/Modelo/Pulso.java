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
public class Pulso implements Operaciones{
    private String idRegistropulso;
    private String idUsuario;
    private String fechaHora;
    private int valorpulso;

    public Pulso(String idRegistropulso, String idUsuario, String fechaHora, int valorpulso) {
        this.idRegistropulso = idRegistropulso;
        this.idUsuario = idUsuario;
        this.fechaHora = fechaHora;
        this.valorpulso = valorpulso;
    }

    public String getIdRegistropulso() {
        return idRegistropulso;
    }

    public void setIdRegistropulso(String idRegistropulso) {
        this.idRegistropulso = idRegistropulso;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    public int getValorpulso() {
        return valorpulso;
    }

    public void setValorpulso(int valorpulso) {
        this.valorpulso = valorpulso;
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
