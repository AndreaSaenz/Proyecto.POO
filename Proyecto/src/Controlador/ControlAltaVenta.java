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
public class ControlAltaVenta {
    
    
    
    
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
                vistaMadre.setVisible(false);
                ManejoArchivo  lectura= new ManejoArchivo("Productos.txt");
                lectura.verificarNoRepeticion(vista.obtenerDescripcion());
                producto.establecerDescripcion(vista.obtenerDescripcion());
                producto.establecerPrecioUnitario(Double.valueOf(vista.obtenerPrecio()));
                producto.establecerCantidad(Integer.valueOf(vista.obtenerCantidad()));
                ArrayList<String> cadena= new ArrayList<String>();
                cadena.add(producto.toString());
                lectura.EscrituraArchivo(cadena, true);
                ManejoArchivo cont= new ManejoArchivo("");
                int[] contadoresSinModificar= cont.obtenerContadoresEntidades();
                contadoresSinModificar[1]+=1;
                cont.modificarContadoresEntidades(contadoresSinModificar);
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
