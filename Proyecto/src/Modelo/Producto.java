/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author andrea
 */
public class Producto {
   private String clave;
   private String descripcion;
   private double precioUnitario;
   private int cantidad;

    public Producto(int Clave, String Descripcion, double PrecioUnitario, int Cantidad) {
        this.clave = "P-"+ Clave;
        this.descripcion = Descripcion;
        this.precioUnitario = PrecioUnitario;
        this.cantidad = Cantidad;
    }
    
    public Producto(String Clave, String Descripcion, double PrecioUnitario, int Cantidad) {
        this.clave = Clave;
        this.descripcion = Descripcion;
        this.precioUnitario = PrecioUnitario;
        this.cantidad = Cantidad;
    }
    
    public Producto(String datos){
        String[] cadena;
        cadena= datos.split(",");
        this.clave = cadena[0];
        this.descripcion = cadena[1];
        this.cantidad = Integer.parseInt(cadena[2]);
        this.precioUnitario = Double.valueOf(cadena[3]);
    }

    public String obtenerClave() {
        return clave;
    }

    public String obtenerDescripcion() {
        return descripcion;
    }

    public double obtenerPrecioUnitario() {
        return precioUnitario;
    }

    public int obtenerCantidad() {
        return cantidad;
    }
    
    public void establecerClave(String clave){
        this.clave=clave;
    }
    
    public void establecerDescripcion(String Descripcion) {
        this.descripcion = Descripcion;
    }

    public void establecerPrecioUnitario(double PrecioUnitario) {
        this.precioUnitario = PrecioUnitario;
    }

    public void establecerCantidad(int Cantidad) {
        this.cantidad = Cantidad;
    }
   
    public boolean equals(String otraDescripcion){
        boolean bandera=false;
        if(this.descripcion.equals(otraDescripcion)){
            bandera=true;
        }
        return bandera;
    }
   
    public String toString(){
        return clave+","+descripcion+","+cantidad+","+precioUnitario;
    }
}
