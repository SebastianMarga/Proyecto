/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Modelo;

/**
 *
 * @author SANDRO
 */
public class MainAdapter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Sistema original de monitoreo de salud
        // Ejemplo de uso del sistema de citas médicas real
        System.out.println("'Sistema de citas medicas real'");
        SistemasCitasMedicas sistemaCitasReal = new SistemaCitasMedicasImpl();
        sistemaCitasReal.registrarCita("Maria Lopez", "2024-10-19", "Pediatria");
        System.out.println(sistemaCitasReal.obtenerDatosPaciente("Maria Lopez"));
        System.out.println();
        
        // Ejemplo de uso del sistema adaptado (SaludAdapter) / Adapta el Ssitema de Monitoreo al Sistema de Citas
        System.out.println("'Sistema de citas medicas adaptado'");
        SistemaMonitoreoSalud sistemaSalud = new SistemaMonitoreoSalud();
        SistemasCitasMedicas sistemaAdaptado = new SaludAdapter(sistemaSalud);
        sistemaAdaptado.registrarCita("Juan Perez", "2024-10-18", "Cardiologia");
        System.out.println(sistemaAdaptado.obtenerDatosPaciente("Juan Perez"));
        System.out.println();
    }
    
}
