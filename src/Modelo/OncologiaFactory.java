/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package abstractFactory;

/**
 *
 * @author SANDRO
 */
public class OncologiaFactory implements EspecialidadFactory {
    @Override
    public Medico crearMedico() {
        return new MedicoOncologo();
    }
    
    @Override
    public Herramienta crearHerramienta() {
        return new HerramientaOncologica();
    }
}
