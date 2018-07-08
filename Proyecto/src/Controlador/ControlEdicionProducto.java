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
        vista.agregarListenerBotonAceptarMejorCaso(new MensajeAccionCompletadaEdicionProducto());
        vista.agregarListenerBotonBuscar(new ProcesoBusquedaEnEdicionProducto());
        vista.agregarListenerBotonGuardar(new ProcesoGuardarEdicionProducto());
    }
    
    
    
    private class  ProcesoGuardarEdicionProducto implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent evento) {
            try{
                ManejoArchivo  lectura= new ManejoArchivo("Productos.txt");
                lectura.verificarNoRepeticion(vista.obtenerDescripcion());
                producto.establecerDescripcion(vista.obtenerDescripcion());
                producto.establecerCantidad(Integer.valueOf(vista.obtenerCantidad()));
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
                vista.deshabilitarCajaClave();
                vista.deshabilitarBotonBuscar();
                ManejoArchivo archivo=new ManejoArchivo("Productos.txt");
                indice=archivo.busquedaDatosEnArchivo(vista.obtenerClave());
                String cadena=archivo.obtenerLineaArchivo(indice);
                producto= new Producto(cadena);
                vista.establecerDescripcion(producto.obtenerClave());
                vista.establecerCantidad(Integer.toString(producto.obtenerCantidad()));
                vista.establecerPrecioUnitario(Double.toString(producto.obtenerPrecioUnitario()));
                vista.mostrarCampos();
            }catch(ElementoNoEncontradoException excep){
                vista.mostrarMensajeError();
            }
            
        }

    }
    
    
    
     private class  MensajeAccionCompletadaEdicionProducto implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent evento) {
            vistaMadre.dispose();
            vista.dispose();
        }

    }
    
    private class  CancelarProcesoEdicionProducto implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent evento) {
            vistaMadre.setVisible(true);
            vista.dispose();
        }

    }
    
}
