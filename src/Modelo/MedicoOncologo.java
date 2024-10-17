/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package abstractFactory;

/**
 *
 * @author SANDRO
 */
public class MedicoOncologo implements Medico {
    @Override
    public void atender() {
        System.out.println("El Dr. Raul Torres esta atendiendo en Oncologia.");
    }
}
