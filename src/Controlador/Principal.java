/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Controlador;

import Modelo.Citas;
import java.sql.SQLException;

/**
 *
 * @author vsmv0
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
       
        Citas citas = new Citas.CitasBuilder("C001")
                .Usuario("u001")
                .Clinica("cl001")
                .Fecha_cita("12/12/2024")
                .motivo("Dolor de Cabeza")
                .estado("Confirmado")
                .construir();
                
    }
    
}
