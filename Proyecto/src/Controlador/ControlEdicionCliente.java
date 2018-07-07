/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Cliente;
import Vista.VistaAltaCliente;
import Vista.VistaControlAccionesEntidades;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * @author 1047470
 */
public class ControlEdicionCliente {
    
    
      private Cliente cliente;
    private VistaAltaCliente vista;
    private VistaControlAccionesEntidades vistaMadre;
    
    public ControlAltaCliente(int rfc, VistaControlAccionesEntidades vistaRaiz){
        this.cliente= new Cliente(rfc, "","","");
        this.vista= new VistaAltaCliente();
        this.vistaMadre= vistaRaiz;
        
        vista.establecerRFC(rfc);
        vista.agregarListenerBotonRegistrar(new ProcesoAltaCliente());
        vista.agregarListenerBotonAceptarMejorCaso(new MensajeAccionCompletadaAltaCliente());
        vista.agregarListenerBotonCancelar(new CancelarProcesoAltaCliente());
    }
    
    
    
    private class  ProcesoAltaCliente implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent evento) {
            try{
                ManejoArchivo  lectura= new ManejoArchivo("Clientes.txt");
                lectura.verificarNoRepeticion(vista.obtenerRazon());
                cliente.establecerRazonSocial(vista.obtenerRazon());
                cliente.establecerDireccion(vista.obtenerDireccion());
                cliente.establecerTelefono(vista.obtenerTel());
                ArrayList<String> cadena= new ArrayList<String>();
                cadena.add(cliente.toString());
                lectura.EscrituraArchivo(cadena, true);
                //aumentar contador clientes en archivo
                vista.mostrarMensajeGuardado();
            }catch(Exception excep){
                vista.mostrarErrorRepeticion();
            }
            
        }

    }
    
    private class  MensajeAccionCompletadaAltaCliente implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent evento) {
            vistaMadre.dispose();
            vista.dispose();
        }

    }
    
    private class  CancelarProcesoAltaCliente implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent evento) {
            vistaMadre.setVisible(true);
            vista.dispose();
        }

    }
    
    
    
    
}
