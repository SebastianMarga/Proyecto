/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package abstractFactory;
import java.util.Scanner;

/**
 *
 * @author SANDRO
 */
public class MainAbstractFactory {
    public static void main(String[] args) {
        // Array con las fábricas de las 5 especialidades
        EspecialidadFactory[] factories = {
            new CardiologiaFactory(),
            new NeurologiaFactory(),
            new PediatriaFactory(),
            new DermatologiaFactory(),
            new OncologiaFactory(),
        };
        
        // Nombres de las especialidades para mostrar al usuario
        String[] especialidades = {
            "Cardiologia",
            "Neurologia",
            "Pediatria",
            "Dermatologia",
            "Oncologia"
        };
        
        // Escáner para la entrada del usuario
        Scanner scanner = new Scanner(System.in);
        int opcion = -1;
        
        // Bucle para repetir la elección hasta que la opción sea válida
        while (opcion < 1 || opcion > especialidades.length) {
            // Mostrar opciones al usuario
            System.out.println("Seleccione una especialidad para ver detalles:");
            for (int i = 0; i < especialidades.length; i++) {
                System.out.println((i + 1) + ". " + especialidades[i]);
            }
            
            // Leer la opción del usuario
            opcion = scanner.nextInt();
            
            // Verificar que la opción esté dentro del rango válido
            if (opcion >= 1 && opcion <= especialidades.length) {
                // Añadir un espacio antes de mostrar la información
                System.out.println();  // Espacio en blanco
                
                // Seleccionar la fábrica correspondiente según la opción
                EspecialidadFactory factory = factories[opcion - 1];
                
                // Crear el médico y la herramienta
                Medico medico = factory.crearMedico();
                Herramienta herramienta = factory.crearHerramienta();
                
                // Ejecutar los métodos
                medico.atender();
                herramienta.usar();
            } else {
                System.out.println("Opcion no valida. Por favor, intente de nuevo.");
                System.out.println(); // Salto de línea para mejor presentación
            }
        }
        
        // Cerrar el scanner
        scanner.close();
    }
}