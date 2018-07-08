/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Usuario;
import Vista.VistaControlAccionesEntidades;
import Vista.VistaLogin;
import Vista.VistaLoginAdmin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author andrea
 */
public class ControlVentas {
    private VistaControlAccionesEntidades vista;
    private Usuario usuario;

    
    public ControlVentas(Usuario usuario){
       this.usuario= usuario;
        this.vista= new VistaControlAccionesEntidades();
        vista.tituloCabecera("Ventas");
        boolean alta =usuario.obtenerRol().obtenerModuloVenta().obtenerPermisoAlta();
        boolean baja =usuario.obtenerRol().obtenerModuloVenta().obtenerPermisoBaja();
        boolean edicion =usuario.obtenerRol().obtenerModuloVenta().obtenerPermisoEdicion();
        boolean consulta =usuario.obtenerRol().obtenerModuloVenta().obtenerPermisoConsulta();
        vista.establecerHabilitacionBotones(alta, baja, edicion, consulta);
        vista.agregarListenerBotonAlta(new opcionAltaVenta());
        vista.agregarListenerBotonConsulta(new opcionConsultaVenta());
        vista.agregarListenerBotonMenu(new opcionMenu());
        if( baja && edicion){
            vista.agregarListenerBotonBaja(new OpcionBajaVenta());
            vista.agregarListenerBotonEdicion(new opcionEdicionVenta());
        }
        vista.setVisible(true);
    }
    
         //---------------------
    
    
    private class  opcionAltaVenta implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent evento) {
            vista.setVisible(false);
            ControlAltaVenta vistaHija= new ControlAltaVenta((new ManejoArchivo("").obtenerContadoresEntidades(2))+1,vista);
                
            
            
        }
    }

    private class  OpcionBajaVenta implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent evento) {
            vista.setVisible(false);
            ControlBajaVenta vistaHija= new ControlBajaVenta(vista);
            
        }
        
        
    }

        
     private class  opcionEdicionVenta implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent evento) {

            vista.setVisible(false);
            ControlEdicionVenta vistaHija= new ControlEdicionVenta(vista);
            
            
        }

    }

     private class  opcionConsultaVenta implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent evento) {
            vista.setVisible(false);
            ControlConsultaVenta vistaHija= new ControlConsultaVenta(vista);
           
            
        }

    }
   
    private class  opcionMenu implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent evento) {
            if(usuario.obtenerRol().obtenerModuloUsuario().obtenerPermisoAlta()){
              ControlMenuPrincipalAdmin  vistaMadre = new ControlMenuPrincipalAdmin(usuario, new VistaLoginAdmin());
            }else{
                ControlMenuPrincipalEmpleado vistaMadre=new ControlMenuPrincipalEmpleado(usuario, new VistaLogin());
            }
            vista.dispose();
            
        }

    
    
    
    
        }

    
    

}
