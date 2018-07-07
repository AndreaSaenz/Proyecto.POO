/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Excepciones.ElementoNoEncontradoException;
import Modelo.Cliente;
import Vista.VistaConsultaCliente;
import Vista.VistaControlAccionesEntidades;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author 1047470
 */
public class ControlConsultaCliente {
    
    
    
    private VistaConsultaCliente vista;
    private VistaControlAccionesEntidades vistaMadre;
    
    public ControlConsultaCliente( VistaControlAccionesEntidades vistaRaiz){
        this.vista= new VistaConsultaCliente();
        this.vistaMadre= vistaRaiz;
        vistaMadre.setVisible(false);
        vista.ocultarCampos();
        vista.agregarListenerBotonBuscar(new ProcesoConsultaCliente());
        vista.agregarListenerBotonListo(new MensajeAccionCompletadaConsultaCliente());
        vista.agregarListenerBotonAceptarError(new CancelarProcesoConsultaCliente());
    }
    
    
    
    private class  ProcesoConsultaCliente implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent evento) {
            try{
                vista.inhabilitarCajaRFC();
                vista.deshabilitarBotonBuscar();
                ManejoArchivo archivo=new ManejoArchivo("Clientes.txt");
                int indice=archivo.busquedaDatosEnArchivo(vista.obtenerRFC());
                String cadena=archivo.obtenerLineaArchivo(indice);
                Cliente cliente= new Cliente(cadena);
                vista.establecerRazon(cliente.obtenerRazonSocial());
                vista.establecerDireccion(cliente.obtenerDireccion());
                vista.establecerTelefono(cliente.obtenerTelefono());
                vista.mostrarCampos();
            }catch(ElementoNoEncontradoException excep){
                vista.mostrarMensajeGuardado();
            }
            
        }

    }
    
    private class  MensajeAccionCompletadaConsultaCliente implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent evento) {
            vistaMadre.dispose();
            vista.dispose();
        }

    }
    
    private class  CancelarProcesoConsultaCliente implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent evento) {
            vistaMadre.setVisible(true);
            vista.dispose();
        }

    }
    
    
}
