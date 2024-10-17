/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author SANDRO
 */
// Clase que simula un sistema de salud que registra mediciones de salud y genera reportes.
public class SistemaMonitoreoSalud {
    public void registrarMedicion(String nombrePaciente, String tipoMedicion, double valor) {
        System.out.println("Medición registrada: " + tipoMedicion + " de " + nombrePaciente + " es " + valor);
    }
    
    public String obtenerReporteSalud(String nombrePaciente) {
        return "Reporte de Salud de " + nombrePaciente + ": Peso 70kg, Pulso 72 LPM.";
    }
}
