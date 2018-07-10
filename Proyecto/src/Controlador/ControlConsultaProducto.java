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
        vista.agregarListenerBotonListo(new CerrarAccionCompletadaConsultaProducto());
        vista.agregarListenerBotonAceptarError(new CerrarAccionCompletadaConsultaProducto());
        vista.setVisible(true);
    }
    
    
    
    private class  ProcesoConsultaProducto implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent evento) {
            try{
                vista.ocultarMensajeGuardado();
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
    
    private class  CerrarAccionCompletadaConsultaProducto implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent evento) {
            vista.cerrarMensajeGuardado();
            vistaMadre.setVisible(true);
            vista.dispose();
        }

    }
    
       
    
    
    
}
