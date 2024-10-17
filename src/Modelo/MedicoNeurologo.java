/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package abstractFactory;

/**
 *
 * @author SANDRO
 */
public class MedicoNeurologo implements Medico {
    @Override
    public void atender() {
        System.out.println("El Dr. Andres Perez esta atendiendo en Neurologia.");
    }
}
