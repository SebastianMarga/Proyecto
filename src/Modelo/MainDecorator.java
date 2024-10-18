/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.SQLException;

public class MainDecorator {
    public static void main(String[] args) {
        try {
            // Crear la cita usando el CitasBuilder con id_cita inicial
            Citas cita = new Citas.CitasBuilder("123")
                    .Usuario("456")
                    .Medico("789")
                    .Fecha("2024-10-17")
                    .Hora("10:30 AM")
                    .motivo("Consulta general")
                    .estado("Programada")
                    .construir();

            // Decorar la cita con el recordatorio
            Operaciones citaConRecordatorio = new CitasConRecordatorio(cita);

            // Llamar al método insertar (siempre con recordatorio)
            System.out.println("Cita con recordatorio:");
            citaConRecordatorio.insertar();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

