/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Excepciones.RepeticionException;
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
public class ControlAltaCliente {
    private Cliente cliente;
    private VistaAltaCliente vista;
    private VistaControlAccionesEntidades vistaMadre;
    
    public ControlAltaCliente(int rfc, VistaControlAccionesEntidades vistaRaiz){
        this.cliente= new Cliente(rfc, "","","");
        this.vista= new VistaAltaCliente();
        this.vistaMadre= vistaRaiz;
        
        vistaMadre.setVisible(false);
        vista.establecerRFC(rfc);
        vista.agregarListenerBotonRegistrar(new ProcesoAltaCliente());
        vista.agregarListenerBotonAceptarMejorCaso(new MensajeAccionCompletadaAltaCliente());
        vista.agregarListenerBotonCancelar(new CancelarProcesoAltaCliente());
        vista.setVisible(true);
    }
    
  /*  public ControlAltaCliente(int rfc){
        this.cliente= new Cliente(rfc, "","","");
        this.vista= new VistaAltaCliente();
        this.vistaMadre= null;
        
        vista.establecerRFC(rfc);
        vista.agregarListenerBotonRegistrar(new ProcesoAltaCliente());
        vista.agregarListenerBotonAceptarMejorCaso(new MensajeAccionCompletadaAltaCliente());
        vista.agregarListenerBotonCancelar(new CancelarProcesoAltaCliente());
    }*/
    
    private class  ProcesoAltaCliente implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent evento) {
            try{
               
                ManejoArchivo  lectura= new ManejoArchivo("Clientes.txt");
                lectura.verificarNoRepeticion(vista.obtenerRazon());
                cliente.establecerRazonSocial(vista.obtenerRazon());
                cliente.establecerDireccion(vista.obtenerDireccion());
                cliente.establecerTelefono(vista.obtenerTel());
                lectura.agregarLineaArchivo(cliente.toString());
                ManejoArchivo cont= new ManejoArchivo("");
                int[] contadoresSinModificar= cont.obtenerContadoresEntidades();
                contadoresSinModificar[0]+=1;
                cont.modificarContadoresEntidades(contadoresSinModificar);
                vista.mostrarMensajeGuardado();
            }catch(RepeticionException excep){
                vista.mostrarErrorRepeticion();
            }
            
        }

    }
    
    private class  MensajeAccionCompletadaAltaCliente implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent evento) {
            try{
                vistaMadre.dispose();
            }catch(Exception excep3){
                System.out.println("Vista Madre inexistente");
            }finally{
                vista.dispose();
            }
        }

    }
    
    private class  CancelarProcesoAltaCliente implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent evento){ 
            try{
                vistaMadre.setVisible(true);
            }catch(Exception excep2){
                    System.out.println("Vista Madre inexistente"); 
            }finally{
                 vista.dispose();
            }
            
            
        }

    }
    
    
}
