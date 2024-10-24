/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Modelo;

import java.sql.SQLException;

public interface IMCComponente {
    void insertar() throws SQLException;
    void seleccionar() throws SQLException;
    void eliminar() throws SQLException;
}
