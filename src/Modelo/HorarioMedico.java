/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author vsmv0
 */
public class HorarioMedico implements Operaciones{
    private String id_horario;
    private String idmedico;
    private String dia;
    private String horainicio;
    private String horafin;
    Services instancia=Services.getInstance();

    public HorarioMedico(String id_horario, String idmedico, String dia, String horainicio, String horafin) throws SQLException{
        this.id_horario = id_horario;
        this.idmedico = idmedico;
        this.dia = dia;
        this.horainicio = horainicio;
        this.horafin = horafin;
    }

    public String getId_horario() {
        return id_horario;
    }

    public void setId_horario(String id_horario) {
        this.id_horario = id_horario;
    }

    public String getIdmedico() {
        return idmedico;
    }

    public void setIdmedico(String idmedico) {
        this.idmedico = idmedico;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHorainicio() {
        return horainicio;
    }

    public void setHorainicio(String horainicio) {
        this.horainicio = horainicio;
    }

    public String getHorafin() {
        return horafin;
    }

    public void setHorafin(String horafin) {
        this.horafin = horafin;
    }

    @Override
    public Operaciones clonar() {
        try {
            return (HorarioMedico) super.clone(); // Clonación superficial
        } catch (CloneNotSupportedException e) {
            // Esto nunca debería ocurrir, ya que estamos implementando Cloneable
            throw new RuntimeException("Error al clonar el objeto Horario Medico", e);
        }
    }

    @Override
    public void insertar() throws SQLException {
        Connection conexion = instancia.getConnection();
        String query = "{call sp_InsertarHorarioMedico(?, ?, ?)}";
        
        try {
            CallableStatement stmt = conexion.prepareCall(query);
            // Establecer los parámetros del procedimiento
        stmt.setString(1, id_horario);
        stmt.setString(2, idmedico);
        stmt.setString(3, dia);
        stmt.setString(4, horainicio);
        stmt.setString(5, horafin);
        
        stmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void seleccionar() throws SQLException {
        Connection conexion = instancia.getConnection();
        String sql = "{call sp_ConsultarHorariosMedicos}";
        try{
            CallableStatement stmt =conexion.prepareCall(sql);
            
            // Asignar parámetro de entrada (ID del usuario a seleccionar)
        stmt.setString(1, id_horario);

        // Ejecutar el procedimiento
         ResultSet rs = stmt.executeQuery();

        // Procesar los resultados
        while (rs.next()) {
            String idmedico = rs.getString("ID_MEDICO");
            String dia = rs.getString("DIA_SEMANA");
            String horarioinicio = rs.getString("HORA_INICIO");
            String horariofin =rs.getString("HORA_FIN");

            System.out.println("ID Usuario: " + idmedico);
            System.out.println("Tipo de servicio: " + dia);
            System.out.println("Hora de inicio: "+horarioinicio);
            System.out.println("Hora de fin: "+horariofin);}
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar() throws SQLException {
        Connection conexion = instancia.getConnection();
        String sql = "{call sp_EliminarHorarioMedico(?)}";
        try{
        CallableStatement stmt = conexion.prepareCall(sql);
        // Asignar parámetro de entrada (ID del usuario a eliminar)
        stmt.setString(1, id_horario);

        // Ejecutar el procedimiento
        stmt.execute();
        JOptionPane.showMessageDialog(null, "Horario Medico eliminado correctamente");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
