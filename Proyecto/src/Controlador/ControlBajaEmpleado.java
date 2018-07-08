/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Excepciones.ElementoNoEncontradoException;


import Vista.VistaBajaEmpleado;
import Vista.VistaControlAccionesEmpleados;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author 1047470
 */
public class ControlBajaEmpleado {
     private VistaBajaEmpleado vista;
    private VistaControlAccionesEmpleados vistaMadre;
    
    public ControlBajaEmpleado(VistaControlAccionesEmpleados vistaRaiz){
        this.vista = new VistaBajaEmpleado();
        this.vistaMadre= vistaRaiz;
        vistaMadre.setVisible(false);
        vista.agregarListenerBotonAceptar(new ProcesoBajaEmpleado());
        vista.agregarListenerBotonAceptarError(new MensajeErrorBajaEmpleado());
        vista.agregarListenerBotonAceptarMejorCaso(new MensajeAccionCompletadaBajaEmpleado());
        vista.setVisible(true);
    }

    
    private class ProcesoBajaEmpleado implements ActionListener{
        
        
        @Override
        public void actionPerformed(ActionEvent evento) {
            try{
                
                ManejoArchivo archivo=new ManejoArchivo("Usuarios.txt");
                int indice=archivo.busquedaDatosEnArchivo(vista.obtenerNombre());
                archivo.eliminarDatosEnArchivo(indice);
                vista.mostrarMensajeEliminado();
            }catch(ElementoNoEncontradoException excep){
                vista.mostrarMensajeError();
            }
                
        }
    }  
        
        
    private class MensajeErrorBajaEmpleado implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent evento) {
            vistaMadre.setVisible(true);
            vista.dispose();
        }
    }
        
        
    private class MensajeAccionCompletadaBajaEmpleado implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent evento) {
            vistaMadre.dispose();
            vista.dispose();
          
                
        }
    }
}
