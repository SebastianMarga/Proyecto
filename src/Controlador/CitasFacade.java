package Controlador;

import Modelo.Citas;
import java.sql.SQLException;

public class CitasFacade {

    private Citas citas;

    public CitasFacade() throws SQLException {
        // Se puede inicializar sin pasar parámetros o con un objeto de tipo Citas ya construido
        citas = new Citas.CitasBuilder(0)  // Inicializa con ID ficticio o real
            .Usuario(0)  // Usuario ficticio (o pasas el id de usuario correcto)
            .Medico(0)   // Medico ficticio (o pasas el id de medico correcto)
            .Clinica(0)  // Clínica ficticia (o pasas el id de clinica correcto)
            .Fecha_cita("2024-11-20")  // Ejemplo de fecha
            .motivo("Revisión general")  // Ejemplo de motivo
            .estado("Confirmada")  // Estado inicial
            .construir();
    }

    // Método para insertar una cita
    public void crearCita(int id_usuario, int id_medico, int id_clinica, String fecha_cita, String motivo, String estado) throws SQLException {
        citas.setId_usuario(id_usuario);
        citas.setId_medico(id_medico);
        citas.setId_clinica(id_clinica);
        citas.setFecha_Cita(fecha_cita);
        citas.setMotivocita(motivo);
        citas.setEstado_cita(estado);
        citas.insertar();
    }

    // Método para obtener todas las citas (esto sería el equivalente a un 'seleccionar' de múltiples citas)
    public void obtenerCitas() throws SQLException {
        citas.seleccionar();
    }

    // Método para eliminar una cita
    public void eliminarCita(int id_cita) throws SQLException {
        citas.setId_cita(id_cita);
        citas.eliminar();
    }

    // Método para obtener una cita por ID
    public Citas obtenerCitaPorId(int id_cita) throws SQLException {
        citas.setId_cita(id_cita);
        // En lugar de realizar solo un select, deberíamos implementar un método para obtener una cita específica
        // utilizando el ID de la cita.
        // El método 'seleccionar' podría modificarse para devolver un solo objeto Citas basado en el ID.
        citas.seleccionar();  // Este método debería ajustarse para filtrar por ID si es necesario
        return citas;
    }

    // Método para clonar una cita (en caso de que se necesite)
    public Citas clonarCita() {
        return (Citas) citas.clonar();
    }
}
