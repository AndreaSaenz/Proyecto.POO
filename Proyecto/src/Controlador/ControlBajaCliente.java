/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Excepciones.ElementoNoEncontradoException;
import Vista.VistaBajaCliente;
import Vista.VistaControlAccionesEntidades;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author 1047470
 */
public class ControlBajaCliente {
    
    private VistaBajaCliente vista;
    private VistaControlAccionesEntidades vistaMadre;
    
    public ControlBajaCliente(VistaControlAccionesEntidades vistaRaiz){
        this.vista = new VistaBajaCliente();
        this.vistaMadre= vistaRaiz;
        vistaMadre.setVisible(false);
        vista.agregarListenerBotonAceptar(new ProcesoBajaCliente());
        vista.agregarListenerBotonAceptarError(new CerrarBajaCliente());
        vista.agregarListenerBotonAceptarMejorCaso(new CerrarBajaCliente());
         vista.setVisible(true);
    }

    
    private class ProcesoBajaCliente implements ActionListener{
        
        
        @Override
        public void actionPerformed(ActionEvent evento) {
            try{
                vista.ocultarMensajeEliminado();
                vista.ocultarMensajeError();
                ManejoArchivo archivo=new ManejoArchivo("Clientes.txt");
                int indice=archivo.busquedaDatosEnArchivo(vista.obtenerRFC());
                archivo.eliminarDatosEnArchivo(indice);
                vista.mostrarMensajeEliminado();
            }catch(ElementoNoEncontradoException excep){
                vista.mostrarMensajeError();
            }
                
        }
    }  
        
        
           
        
    private class CerrarBajaCliente implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent evento) {
                vista.cerrarMensajes();
                vistaMadre.setVisible(true);
                vista.dispose();
            
                
        }
    }
     

    
    
}
