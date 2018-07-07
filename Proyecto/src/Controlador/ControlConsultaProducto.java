/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Excepciones.ElementoNoEncontradoException;
import Modelo.Producto;
import Vista.VistaConsultaProducto;

import Vista.VistaControlAccionesEntidades;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author 1047470
 */
public class ControlConsultaProducto {
    
    
      
    private VistaConsultaProducto vista;
    private VistaControlAccionesEntidades vistaMadre;
    
    public ControlConsultaProducto(VistaControlAccionesEntidades vistaRaiz){
        this.vista= new VistaConsultaProducto();
        this.vistaMadre= vistaRaiz;
        vistaMadre.setVisible(false);
        vista.ocultarCampos();
        vista.agregarListenerBotonBuscar(new ProcesoConsultaProducto());
        vista.agregarListenerBotonListo(new MensajeAccionCompletadaConsultaProducto());
        vista.agregarListenerBotonAceptarError(new CancelarProcesoConsultaProducto());
    }
    
    
    
    private class  ProcesoConsultaProducto implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent evento) {
            try{
                vista.inhabilitarCajaClave();
                vista.deshabilitarBotonBuscar();
                ManejoArchivo archivo=new ManejoArchivo("Productos.txt");
                int indice=archivo.busquedaDatosEnArchivo(vista.obtenerClave());
                String cadena=archivo.obtenerLineaArchivo(indice);
                Producto producto= new Producto(cadena);
                vista.establecerDescripcion(producto.obtenerDescripcion());
                vista.establecerCantidad(Integer.toString(producto.obtenerCantidad()));
                vista.establecerPrecioUnitario(Double.toString(producto.obtenerPrecioUnitario()));
                vista.mostrarCampos();
            }catch(ElementoNoEncontradoException excep){
                vista.mostrarMensajeGuardado();
            }
            
        }

    }
    
    private class  MensajeAccionCompletadaConsultaProducto implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent evento) {
            vistaMadre.dispose();
            vista.dispose();
        }

    }
    
    private class  CancelarProcesoConsultaProducto implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent evento) {
            vistaMadre.setVisible(true);
            vista.dispose();
        }

    }
    
    
    
    
}
