/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author vsmv0
 */
public class Medico implements Operaciones{
    private String id_medico;
    private String nombre;
    private String apellido;
    private String id_especialidad;
    private String email;
    private String telefono;
    private String consultorio;
    Services instancia=Services.getInstance();

    public Medico(MedicoBuilder builder) throws SQLException{
        this.id_medico = builder.id_medico;
        this.nombre = builder.nombre;
        this.apellido = builder.apellido;
        this.id_especialidad = builder.id_especialidad;
        this.email = builder.email;
        this.telefono = builder.telefono;
        this.consultorio = builder.consultorio;
    }

    public String getId_medico() {
        return id_medico;
    }

    public void setId_medico(String id_medico) {
        this.id_medico = id_medico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getId_especialidad() {
        return id_especialidad;
    }

    public void setId_especialidad(String id_especialidad) {
        this.id_especialidad = id_especialidad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getConsultorio() {
        return consultorio;
    }

    public void setConsultorio(String consultorio) {
        this.consultorio = consultorio;
    }
    //Patron Builder
    public static class MedicoBuilder{
        private String id_medico;
        private String nombre;
        private String apellido;
        private String id_especialidad;
        private String email;
        private String telefono;
        private String consultorio;
        
        public MedicoBuilder(String id_medico){
            this.id_medico=id_medico;
        }
        public MedicoBuilder nombre(String nombre){
            this.nombre=nombre;
            return this;
        }
        public MedicoBuilder apellido(String apellido){
            this.apellido=apellido;
            return this;
        }
        public MedicoBuilder especialidad(String id_especialidad){
            this.id_especialidad=id_especialidad;
            return this;
        }
        public MedicoBuilder email(String email){
            this.email=email;
            return this;
        }
        public MedicoBuilder telefono(String telefono){
            this.telefono=telefono;
            return this;
        }
        public MedicoBuilder consultorio(String consultorio){
            this.consultorio=consultorio;
            return this;
        }
        public Medico construir() throws SQLException{
            return new Medico(this);
        }
    }

    @Override
    public Operaciones clonar() {
         try {
            return (Medico) super.clone(); // Clonación superficial
        } catch (CloneNotSupportedException e) {
            // Esto nunca debería ocurrir, ya que estamos implementando Cloneable
            throw new RuntimeException("Error al clonar el objeto Medico", e);
        }
    }

    @Override
    public void insertar() throws SQLException {
        Connection conexion = instancia.getConnection();
        String query = "{call sp_InsertarMedico(?, ?, ?, ?, ?, ?, ?)}";
        
        try {
            CallableStatement stmt = conexion.prepareCall(query);
            // Establecer los parámetros del procedimiento
        stmt.setString(1, id_medico);
        stmt.setString(2, nombre);
        stmt.setString(3, apellido);
        stmt.setString(4, id_especialidad);
        stmt.setString(5, email);
        stmt.setString(6, telefono);
        stmt.setString(7, consultorio);
        
        stmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void seleccionar() throws SQLException {
        Connection conexion = instancia.getConnection();
        String sql = "{call sp_ConsultarMedicos}";
        try{
            CallableStatement stmt =conexion.prepareCall(sql);
            
            // Asignar parámetro de entrada (ID del usuario a seleccionar)
        stmt.setString(1, id_medico);

        // Ejecutar el procedimiento
         ResultSet rs = stmt.executeQuery();

        // Procesar los resultados
        while (rs.next()) {
            String nombre = rs.getString("NOMBRE");
            String apellido = rs.getString("APELLIDO");
            String id_especialidad = rs.getString("ID_ESPECIALIDAD");
            String email = rs.getString("EMAIL");
            String telefono = rs.getString("TELEFONO");
            String consultorio = rs.getString("CONSULTORIO");

            System.out.println("Nombre: " + nombre);
            System.out.println("Apellido: " + apellido);
            System.out.println("Id_Especialidad: "+id_especialidad);
            System.out.println("Email: "+email);
            System.out.println("Telefono: " + telefono);
            System.out.println("Consultorio: "+consultorio);}
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar() throws SQLException {
         Connection conexion = instancia.getConnection();
        String sql = "{call sp_EliminarMedico(?)}";
        try{
        CallableStatement stmt = conexion.prepareCall(sql);
        // Asignar parámetro de entrada (ID del usuario a eliminar)
        stmt.setString(1, id_medico);

        // Ejecutar el procedimiento
        stmt.execute();
        JOptionPane.showMessageDialog(null, "Medico eliminado correctamente");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
}
