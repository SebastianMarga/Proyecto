/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Modelo;

/**
 *
 * @author SANDRO
 */

// Interfaz para el sistema de citas médicas
public interface SistemasCitasMedicas {
    void registrarCita(String nombrePaciente, String fecha, String especialidad);
    String obtenerDatosPaciente(String nombrePaciente);
}
