/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.SQLException;

public class MainComposite {
    public static void main(String[] args) {
        try {
            IMC imc1 = new IMC("1", "Usuario1", 70, 1.75);
            IMC imc2 = new IMC("2", "Usuario2", 60, 1.65);
            IMCGrupo grupoIMC = new IMCGrupo();
            grupoIMC.add(imc1);
            grupoIMC.add(imc2);

            // Insertar todos los IMCs en el grupo
            grupoIMC.insertar();

            // Seleccionar todos los IMCs en el grupo
            grupoIMC.seleccionar();
            
            // Eliminar todos los IMCs en el grupo
            grupoIMC.eliminar();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
