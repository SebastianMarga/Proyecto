/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.SQLException;

public class CitasDecorator implements Operaciones{
     protected Operaciones citas;  

    public CitasDecorator(Operaciones citas) {
        this.citas = citas; 
    }

    @Override
    public Operaciones clonar() {
        return citas.clonar();  
    }

    @Override
    public void insertar() throws SQLException {
        citas.insertar();  
    }

    @Override
    public void seleccionar() throws SQLException {
        citas.seleccionar(); 
    }

    @Override
    public void eliminar() throws SQLException {
        citas.eliminar();  
    }
}
