/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Excepciones.ElementoNoEncontradoException;

import Vista.VistaBajaVenta;
import Vista.VistaControlAccionesEntidades;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author 1047470
 */
public class ControlBajaVenta {
    
     private VistaBajaVenta vista;
    private VistaControlAccionesEntidades vistaMadre;
    
    public ControlBajaVenta(VistaControlAccionesEntidades vistaRaiz){
        this.vista = new VistaBajaVenta();
        this.vistaMadre= vistaRaiz;
        vistaMadre.setVisible(false);
        vista.agregarListenerBotonAceptar(new ProcesoBajaVenta());
        vista.agregarListenerBotonAceptarError(new CerrarBajaVenta());
        vista.agregarListenerBotonAceptarMejorCaso(new CerrarBajaVenta());
        vista.setVisible(true);
    }

    
    private class ProcesoBajaVenta implements ActionListener{
        
        
        @Override
        public void actionPerformed(ActionEvent evento) {
            try{
                vista.ocultarMensajeError();
                vista.ocultarMensajeError();
                ManejoArchivo archivo=new ManejoArchivo("Ventas.txt");
                int indice=archivo.busquedaDatosEnArchivo(vista.obtenerId());
                archivo.eliminarDatosEnArchivo(indice);
                vista.mostrarMensajeEliminado();
            }catch(ElementoNoEncontradoException excep){
                vista.mostrarMensajeError();
            }
                
        }
    }  
        
        
    private class CerrarBajaVenta implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent evento) {
            vista.cerrarMensajes();
            vistaMadre.setVisible(true);
            vista.dispose();
        }
    }
        
        
        
}
