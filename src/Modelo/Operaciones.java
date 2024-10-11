/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Modelo;

import java.sql.SQLException;

/**
 *
 * @author vsmv0
 */
public interface Operaciones {
    Operaciones clonar() ;
     void insertar() throws SQLException;
    void seleccionar() throws SQLException;
    void eliminar() throws SQLException;
}
