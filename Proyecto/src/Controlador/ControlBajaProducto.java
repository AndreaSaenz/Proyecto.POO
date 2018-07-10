/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Excepciones.ElementoNoEncontradoException;

import Vista.VistaBajaProducto;
import Vista.VistaControlAccionesEntidades;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author 1047470
 */
public class ControlBajaProducto {
    
    
    private VistaBajaProducto vista;
    private VistaControlAccionesEntidades vistaMadre;
    
    public ControlBajaProducto(VistaControlAccionesEntidades vistaRaiz){
        this.vista = new VistaBajaProducto();
        this.vistaMadre= vistaRaiz;
        vistaMadre.setVisible(false);
        vista.agregarListenerBotonAceptar(new ProcesoBajaProducto());
        vista.agregarListenerBotonAceptarError(new CerrarBajaProducto());
        vista.agregarListenerBotonAceptarMejorCaso(new CerrarBajaProducto());
        vista.setVisible(true);
    }

    
    private class ProcesoBajaProducto implements ActionListener{
        
        
        @Override
        public void actionPerformed(ActionEvent evento) {
            try{
                
                ManejoArchivo archivo=new ManejoArchivo("Productos.txt");
                int indice=archivo.busquedaDatosEnArchivo(vista.obtenerClave());
                archivo.eliminarDatosEnArchivo(indice);
                vista.mostrarMensajeEliminado();
            }catch(ElementoNoEncontradoException excep){
                vista.mostrarMensajeError();
            }
                
        }
    }  
        
        
    private class CerrarBajaProducto implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent evento) {
            vista.ocultarMensajeEliminado();
            vista.ocultarMensajeError();
            vistaMadre.setVisible(true);
            vista.dispose();
        }
    }
        
        

     
}
