/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Modelo.Usuario;
import Vista.VistaBajaCliente;
import Vista.VistaControlAccionesEntidades;

/**
 *
 * @author andrea
 */
public class ControlClientes {
    //private Cliente cliente;
    private VistaControlAccionesEntidades vista;
    
    public ControlClientes(Usuario usuario){
      //  this.cliente= new Cliente(rfc, "","","");
        this.vista= new VistaControlAccionesEntidades();
        vista.tituloCabecera("Clientes");
        boolean alta =usuario.obtenerRol().obtenerModuloClientes().obtenerPermisoAlta();
        boolean baja =usuario.obtenerRol().obtenerModuloClientes().obtenerPermisoBaja();
        boolean edicion =usuario.obtenerRol().obtenerModuloClientes().obtenerPermisoEdicion();
        boolean consulta =usuario.obtenerRol().obtenerModuloClientes().obtenerPermisoConsulta();
        vista.establecerHabilitacionBotones(alta, baja, edicion, consulta);
        vista.agregarListenerBotonAlta(new opcionAltaCliente());
        if(baja){
            vista.agregarListenerBotonBaja(new OpcionBajaCliente());
        }
        vista.agregarListenerBotonConsulta(new opcionConsultaCliente());
        if(edicion){
            vista.agregarListenerBotonEdicion(new opcionEdicionCliente());
        }
        vista.agregarListenerBotonMenu(new opcionMenu());
    
    }

      
    
    
    //---------------------
    
    
    private class  opcionAltaCliente implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent evento) {
            try{
                vista.setVisible(false);
                ControlAltaCliente vistaHija= new ControlAltaCliente(NUMERO_CLIENTE,vista);
                
            }catch(Exception excep){
            }
            
        }
    }

    private class  OpcionBajaCliente implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent evento) {
            try{
                
            }catch(Exception excep){
            }
            
        }
        
        
    }

        
     private class  opcionEdicionCliente implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent evento) {
            try{
                vista.setVisible(false);
                ControlEdicionCliente vistaHija= new ControlAltaCliente(NUMERO_CLIENTE,vista);
                
            }catch(Exception excep){
            }
            
        }

    }

     private class  opcionConsultaCliente implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent evento) {
            try{
                vista.setVisible(false);
                ControlAltaCliente vistaHija= new ControlAltaCliente(NUMERO_CLIENTE,vista);
                
            }catch(Exception excep){
            }
            
        }

    }
    
    private class  opcionMenu implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent evento) {
            vista.dispose();
            
        }

    }
    
    
}
