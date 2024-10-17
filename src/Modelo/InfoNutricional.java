/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.SQLException;

/**
 *
 * @author vsmv0
 */
public class InfoNutricional implements Operaciones{
    private String id_info;
    private String idusuario;
    private String fecha;
    private double calorias;
    private double proteinas;
    private double carbohidratos;
    private double grasas;

    public InfoNutricional(InfoNutricionalBuilder builder) {
        this.id_info = builder.id_info;
        this.idusuario = builder.idusuario;
        this.fecha = builder.fecha;
        this.calorias = builder.calorias;
        this.proteinas = builder.proteinas;
        this.carbohidratos = builder.carbohidratos;
        this.grasas = builder.grasas;
    }

    public String getId_info() {
        return id_info;
    }

    public void setId_info(String id_info) {
        this.id_info = id_info;
    }

    public String getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(String idusuario) {
        this.idusuario = idusuario;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getCalorias() {
        return calorias;
    }

    public void setCalorias(double calorias) {
        this.calorias = calorias;
    }

    public double getProteinas() {
        return proteinas;
    }

    public void setProteinas(double proteinas) {
        this.proteinas = proteinas;
    }

    public double getCarbohidratos() {
        return carbohidratos;
    }

    public void setCarbohidratos(double carbohidratos) {
        this.carbohidratos = carbohidratos;
    }

    public double getGrasas() {
        return grasas;
    }

    public void setGrasas(double grasas) {
        this.grasas = grasas;
    }
    //patron Builder
    public static class InfoNutricionalBuilder{
        private String id_info;
        private String idusuario;
        private String fecha;
        private double calorias;
        private double proteinas;
        private double carbohidratos;
        private double grasas;
        public InfoNutricionalBuilder(String id_info){
            this.id_info=id_info;
        }
        public InfoNutricionalBuilder usuario(String idusuario){
            this.idusuario=idusuario;
            return this;
        }
        public InfoNutricionalBuilder fecha(String fecha){
            this.fecha=fecha;
            return this;
        }
        public InfoNutricionalBuilder calorias(double calorias){
            this.calorias=calorias;
            return this;
        }
        public InfoNutricionalBuilder proteinas(double proteinas){
            this.proteinas=proteinas;
            return this;
        }
        public InfoNutricionalBuilder carbohidratos(double carbohidratos){
            this.carbohidratos=carbohidratos;
            return this;
        }
        public InfoNutricionalBuilder grasas(double grasas){
            this.grasas=grasas;
            return this;
        }
        public InfoNutricional construir(){
            return new InfoNutricional(this);
        }
        
    }
    @Override
    public Operaciones clonar() {
        try {
            return (InfoNutricional) super.clone(); // Clonación superficial
        } catch (CloneNotSupportedException e) {
            // Esto nunca debería ocurrir, ya que estamos implementando Cloneable
            throw new RuntimeException("Error al clonar el objeto Info Nutricional", e);
        }
    }

    @Override
    public void insertar() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void seleccionar() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminar() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
