/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Excepciones.ElementoNoEncontradoException;
import Excepciones.RepeticionException;

import Modelo.Producto;
import Vista.VistaControlAccionesEntidades;

import Vista.VistaEdicionProducto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 *
 * @author 1047470
 */
public class ControlEdicionProducto {
    
    
    private Producto producto;
    private VistaEdicionProducto vista;
    private VistaControlAccionesEntidades vistaMadre;
    private int indice;
    
    public ControlEdicionProducto( VistaControlAccionesEntidades vistaRaiz){
        this.producto= null;
        this.vista= new VistaEdicionProducto();
        this.vistaMadre= vistaRaiz;
        this.indice=-1;
        vistaMadre.setVisible(false);
        vista.ocultarCampos(); 
        vista.ocultarErrorRepeticion();
        vista.agregarListenerBotonAceptarError(new CancelarProcesoEdicionProducto());
        vista.agregarListenerBotonAceptarMejorCaso(new CancelarProcesoEdicionProducto());
        vista.agregarListenerBotonBuscar(new ProcesoBusquedaEnEdicionProducto());
        vista.agregarListenerBotonGuardar(new ProcesoGuardarEdicionProducto());
          vista.setVisible(true);
    }
    
    
    
    private class  ProcesoGuardarEdicionProducto implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent evento) {
            try{
                ManejoArchivo  lectura= new ManejoArchivo("Productos.txt");
                lectura.verificarNoRepeticion(vista.obtenerDescripcion(), producto.obtenerClave());
                producto.establecerDescripcion(vista.obtenerDescripcion());
                int i=Integer.parseInt(vista.obtenerCantidad().trim());
                producto.establecerCantidad(i);
                producto.establecerPrecioUnitario(Double.valueOf(vista.obtenerPrecioUnitario()));
                lectura.establecerLineaArchivo(indice, producto.toString());
                vista.mostrarMensajeGuardado();
           }catch(RepeticionException excep){
                vista.mostrarErrorRepeticion();
                
            }
            
        }

    }
    
    
    private class  ProcesoBusquedaEnEdicionProducto implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent evento) {
            try{
                vista.ocultarErrorRepeticion();
                vista.ocultarMensajeError();
                vista.ocultarMensajeGuardado();
                vista.deshabilitarCajaClave();
                vista.deshabilitarBotonBuscar();
                ManejoArchivo archivo=new ManejoArchivo("Productos.txt");
                indice=archivo.busquedaDatosEnArchivo(vista.obtenerClave());
                String cadena=archivo.obtenerLineaArchivo(indice);
                producto= new Producto(cadena);
                vista.establecerDescripcion(producto.obtenerDescripcion());
                vista.establecerCantidad(Integer.toString(producto.obtenerCantidad()));
                vista.establecerPrecioUnitario(Double.toString(producto.obtenerPrecioUnitario()));
                vista.mostrarCampos();
            }catch(ElementoNoEncontradoException excep){
                vista.mostrarMensajeError();
            }
            
        }

    }
    
    
    
   
    private class  CancelarProcesoEdicionProducto implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent evento) {
            vista.cerrarMensajes();
            vistaMadre.setVisible(true);
            vista.dispose();
        }

    }
    
}
