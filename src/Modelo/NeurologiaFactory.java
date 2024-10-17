/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package abstractFactory;

/**
 *
 * @author SANDRO
 */
public class NeurologiaFactory implements EspecialidadFactory {
    @Override
    public Medico crearMedico() {
        return new MedicoNeurologo();
    }
    
    @Override
    public Herramienta crearHerramienta() {
        return new HerramientaNeurologica();
    }
}
