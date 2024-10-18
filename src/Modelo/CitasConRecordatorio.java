/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.SQLException;

public class CitasConRecordatorio extends CitasDecorator {

    public CitasConRecordatorio(Operaciones citas) {
        super(citas); 
    }

    @Override
    public void insertar() throws SQLException {
        citas.insertar();
        System.out.println("Enviando recordatorio de la cita...");
    }
}