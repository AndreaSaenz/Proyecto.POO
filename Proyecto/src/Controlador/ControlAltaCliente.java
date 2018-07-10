/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Excepciones.RepeticionException;
import Excepciones.VistaAnteriorInexistenteException;
import Modelo.Cliente;
import Vista.VistaAltaCliente;
import Vista.VistaControlAccionesEntidades;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        vista.ocultarErrorRepeticion();
        if(vistaMadre!= null){
         vistaMadre.setVisible(false);
        }
        vista.establecerRFC(rfc);
        vista.agregarListenerBotonRegistrar(new ProcesoAltaCliente());
        vista.agregarListenerBotonAceptarMejorCaso(new CerrarProcesoAltaCliente());
        vista.agregarListenerBotonCancelar(new CerrarProcesoAltaCliente());
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
    
 
    private class  CerrarProcesoAltaCliente implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent evento){ 
            try{
                existenciaVistaAnterior();
                vistaMadre.setVisible(true);
            }catch(VistaAnteriorInexistenteException excep2){
                    System.out.println("Vista Madre inexistente"); 
            }finally{
                vista.cerrarMensajeGuardado();
                 vista.dispose();
            }
            
            
        }

    }
    
    
    public void existenciaVistaAnterior() throws VistaAnteriorInexistenteException{
        if(vistaMadre==null){
            throw new VistaAnteriorInexistenteException("No hay vista anterior a esta");
        }
    }
    
    
}
