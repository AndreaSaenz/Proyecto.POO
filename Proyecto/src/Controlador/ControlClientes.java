/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Modelo.Usuario;
import Vista.VistaControlAccionesEntidades;
import Vista.VistaLogin;
import Vista.VistaLoginAdmin;

/**
 *
 * @author andrea
 */
public class ControlClientes {
    //private Cliente cliente;
    private VistaControlAccionesEntidades vista;
    private Usuario usuario;
    
    public ControlClientes(Usuario usuario){
      //  this.cliente= new Cliente(rfc, "","","");
        this.usuario=usuario;
        this.vista= new VistaControlAccionesEntidades();
        vista.tituloCabecera("Clientes");
        boolean alta =usuario.obtenerRol().obtenerModuloClientes().obtenerPermisoAlta();
        boolean baja =usuario.obtenerRol().obtenerModuloClientes().obtenerPermisoBaja();
        boolean edicion =usuario.obtenerRol().obtenerModuloClientes().obtenerPermisoEdicion();
        boolean consulta =usuario.obtenerRol().obtenerModuloClientes().obtenerPermisoConsulta();
        vista.establecerHabilitacionBotones(alta, baja, edicion, consulta);
        vista.agregarListenerBotonAlta(new opcionAltaCliente());
        vista.agregarListenerBotonConsulta(new opcionConsultaCliente());
        vista.agregarListenerBotonMenu(new opcionMenu());
        if( baja && edicion){
            vista.agregarListenerBotonBaja(new OpcionBajaCliente());
            vista.agregarListenerBotonEdicion(new opcionEdicionCliente());
        }
        vista.setVisible(true);
        
    
    }

      
    
    
    //---------------------
    
    
    private class  opcionAltaCliente implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent evento) {
            vista.setVisible(false);
            ControlAltaCliente vistaHija= new ControlAltaCliente((new ManejoArchivo("").obtenerContadoresEntidades(0))+1,vista);
            vista.setVisible(true);
            
            
        }
    }

    private class  OpcionBajaCliente implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent evento) {
            vista.setVisible(false);
            ControlBajaCliente vistaHija= new ControlBajaCliente(vista);
            
        }
        
        
    }

        
     private class  opcionEdicionCliente implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent evento) {
            try{
                vista.setVisible(false);
                ControlEdicionCliente vistaHija= new ControlEdicionCliente(vista);
                
            }catch(Exception excep){
            }
            
        }

    }

     private class  opcionConsultaCliente implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent evento) {
            vista.setVisible(false);
            ControlConsultaCliente vistaHija= new ControlConsultaCliente(vista);
           
            
        }

    }
   
    private class  opcionMenu implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent evento) {
            if(usuario.obtenerRol().obtenerModuloUsuario().obtenerPermisoAlta()){
              ControlMenuPrincipalAdmin  vistaMadre= new ControlMenuPrincipalAdmin(usuario/*, new ControlLogin()/*/);
            }else{
                ControlMenuPrincipalEmpleado vistaMadre=new ControlMenuPrincipalEmpleado(usuario/*, new VistaLogin()*/);
            }
            vista.dispose();
            
        }

    }
    
    
}
