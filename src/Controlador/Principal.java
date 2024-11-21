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
       try{
        Citas citas = new Citas.CitasBuilder(4)
                .Usuario(1)
                .Clinica(1)
                .Medico(1)
                .Fecha_cita("2024/12/22")
                .motivo("Dolor de Cabeza")
                .estado("Confirmado")
                .construir();
        citas.insertar();
        citas.seleccionar();
        citas.eliminar();
        } catch (SQLException ex) {
            System.err.println("Error al procesar la cita: " + ex.getMessage());
            ex.printStackTrace();
        }    
    }
    
}
