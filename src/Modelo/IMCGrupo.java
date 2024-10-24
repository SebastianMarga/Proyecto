/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IMCGrupo implements IMCComponente{
   private List<IMCComponente> children = new ArrayList<>();

    public void add(IMCComponente component) {
        children.add(component);
    }

    public void remove(IMCComponente component) {
        children.remove(component);
    }

    @Override
    public void insertar() throws SQLException {
        for (IMCComponente child : children) {
            child.insertar();
        }
    }

    @Override
    public void seleccionar() throws SQLException {
        for (IMCComponente child : children) {
            child.seleccionar();
        }
    }

    @Override
    public void eliminar() throws SQLException {
        for (IMCComponente child : children) {
            child.eliminar();
        }
    }
 
}
