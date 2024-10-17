/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author SANDRO
 */
// Adaptador que permite que el SistemaMonitoreoSalud funcione como un SistemaCitasMedicas.
public class SaludAdapter implements SistemasCitasMedicas {
    // Aquí declaras el sistema de salud correctamente como una variable privada
    private SistemaMonitoreoSalud sistemaSalud;

    // Constructor que recibe una instancia del sistema de salud
    public SaludAdapter(SistemaMonitoreoSalud sistemaSalud) {
        this.sistemaSalud = sistemaSalud; // Inicializas la variable en el constructor
    }
    
    @Override
    public void registrarCita(String nombrePaciente, String fecha, String especialidad) {
        System.out.println("Adaptando sistema de salud para registrar cita.");
        // No hace nada con el sistema de salud en este caso, solo pasa la cita
        System.out.println("Cita registrada para " + nombrePaciente + " el " + fecha + " en " + especialidad);
    }
    
    @Override
    public String obtenerDatosPaciente(String nombrePaciente) {
        // Adaptamos la forma en que se obtienen los datos de salud del paciente
        return sistemaSalud.obtenerReporteSalud(nombrePaciente);
    }
}
