/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Controlador;

import Modelo.Doctor;
import Modelo.Citas;
import java.sql.SQLException;
import java.util.List;

public class Principal {

    public static void main(String[] args) throws SQLException {
        // Primero, gestionamos las citas (como en tu código original)
        try {
            // Crear y procesar una cita
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

        // Ahora, gestionamos los doctores con DoctorFactory
        try {
            // Crear una instancia de DoctorFactory
            DoctorFactory doctorFactory = new DoctorFactory();

            // Crear un nuevo doctor
            Doctor nuevoDoctor = doctorFactory.crearDoctor(1, "Juan", "Pérez", "Cardiología", "555-1234", "juan.perez@ejemplo.com");
            
            // Insertar el doctor en la base de datos
            doctorFactory.insertarDoctor(nuevoDoctor);

            // Obtener todos los doctores desde la base de datos
            List<Doctor> doctores = doctorFactory.seleccionarDoctores();
            System.out.println("Lista de Doctores:");
            for (Doctor doctor : doctores) {
                System.out.println("Doctor: " + doctor.getNombre() + " " + doctor.getApellido() + " - Especialidad: " + doctor.getEspecialidad());
            }

            // Eliminar un doctor por su ID
            doctorFactory.eliminarDoctor(1);

            // Clonar un doctor
            Doctor doctorClon = doctorFactory.clonarDoctor(nuevoDoctor);
            System.out.println("Clon del doctor: " + doctorClon.getNombre() + " " + doctorClon.getApellido());
            
        } catch (SQLException ex) {
            System.err.println("Error al gestionar los doctores: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
