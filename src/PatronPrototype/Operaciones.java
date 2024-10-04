/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package PatronPrototype;

import java.sql.SQLException;

/**
 *
 * @author vsmv0
 */
public interface Operaciones extends Cloneable{
    Operaciones clonar() ;
     void insertar() throws SQLException;
    void actualizar() throws SQLException;
    void eliminar() throws SQLException;
}
