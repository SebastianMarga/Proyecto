/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Controlador;

import PatronPrototype.Usuario;
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
        Usuario usuario =new Usuario("1","Hola","Perez","12/12/24","hola@gmail.com");
         Usuario usuarioclonado=(Usuario) usuario.clonar();
        System.out.println(usuarioclonado);
    }
    
}
