/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PatronPrototype;

/**
 *
 * @author vsmv0
 */
public abstract class Entidad implements Cloneable,Operaciones{
    
    
   
    @Override
    public abstract void insertar();
    @Override
    public abstract void actualizar();
    @Override
    public abstract void eliminar();
}
