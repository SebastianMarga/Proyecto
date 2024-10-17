/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author SANDRO
 */
public class SistemaCitasMedicasImpl implements SistemasCitasMedicas {
    @Override
    public void registrarCita(String nombrePaciente, String fecha, String especialidad) {
        System.out.println("Cita registrada para " + nombrePaciente + " el " + fecha + " en " + especialidad);
    }
    
    @Override
    public String obtenerDatosPaciente(String nombrePaciente) {
        return "Paciente: " + nombrePaciente + ", Edad: 15, Estado: Estable";
    }
}
