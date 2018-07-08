/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Excepciones.ElementoNoEncontradoException;
import Excepciones.RepeticionException;
import Modelo.Cliente;
import Vista.VistaEdicionCliente;
import Vista.VistaControlAccionesEntidades;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author 1047470
 */
public class ControlEdicionCliente {
    
    
    private Cliente cliente;
    private VistaEdicionCliente vista;
    private VistaControlAccionesEntidades vistaMadre;
    private int indice;
    
    public ControlEdicionCliente( VistaControlAccionesEntidades vistaRaiz){
        this.cliente= null;
        this.vista= new VistaEdicionCliente();
        this.vistaMadre= vistaRaiz;
         this.indice=-1;
        vistaMadre.setVisible(false);
        vista.ocultarCampos();
        vista.ocultarErrorRepeticion();
        vista.agregarListenerBotonAceptarError(new CancelarProcesoEdicionCliente());
        vista.agregarListenerBotonAceptarMejorCaso(new MensajeAccionCompletadaEdicionCliente());
        vista.agregarListenerBotonBuscar(new ProcesoBusquedaEnEdicionCliente());
        vista.agregarListenerBotonGuardar(new ProcesoGuardarEdicionCliente());
    }
    
    
    
    private class  ProcesoGuardarEdicionCliente implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent evento) {
            try{
                ManejoArchivo  lectura= new ManejoArchivo("Clientes.txt");
                lectura.verificarNoRepeticion(vista.obtenerRazon());
                cliente.establecerRazonSocial(vista.obtenerRazon());
                cliente.establecerDireccion(vista.obtenerDireccion());
                cliente.establecerTelefono(vista.obtenerTelefono());
                lectura.establecerLineaArchivo(indice, cliente.toString());
                vista.mostrarMensajeGuardado();
            }catch(RepeticionException excep){
                vista.mostrarErrorRepeticion();
            }
            
        }

    }
    
    
    private class  ProcesoBusquedaEnEdicionCliente implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent evento) {
            try{
                vista.inhabilitarCajaRFC();
                vista.deshabilitarBotonBuscar();
                ManejoArchivo archivo=new ManejoArchivo("Clientes.txt");
                indice=archivo.busquedaDatosEnArchivo(vista.obtenerRFC());
                String cadena=archivo.obtenerLineaArchivo(indice);
                cliente= new Cliente(cadena);
                vista.establecerRazon(cliente.obtenerRazonSocial());
                vista.establecerDireccion(cliente.obtenerDireccion());
                vista.establecerTelefono(cliente.obtenerTelefono());
                vista.mostrarCampos();
            }catch(ElementoNoEncontradoException excep){
                vista.mostrarMensajeError();
            }
            
        }

    }
    
    
    
     private class  MensajeAccionCompletadaEdicionCliente implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent evento) {
            vistaMadre.dispose();
            vista.dispose();
        }

    }
    
    private class  CancelarProcesoEdicionCliente implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent evento) {
            vistaMadre.setVisible(true);
            vista.dispose();
        }

    }
    
    
}
