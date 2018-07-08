/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Usuario;
import Vista.VistaControlAccionesEntidades;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author andrea
 */
public class ControlProductos {
   private VistaControlAccionesEntidades vista;
   private Usuario usuario;
    
    public ControlProductos(Usuario usuario){
       this.usuario= usuario;
       this.vista= new VistaControlAccionesEntidades();
        vista.tituloCabecera("Productos");
        boolean alta =usuario.obtenerRol().obtenerModuloProductos().obtenerPermisoAlta();
        boolean baja =usuario.obtenerRol().obtenerModuloProductos().obtenerPermisoBaja();
        boolean edicion =usuario.obtenerRol().obtenerModuloProductos().obtenerPermisoEdicion();
        boolean consulta =usuario.obtenerRol().obtenerModuloProductos().obtenerPermisoConsulta();
        vista.establecerHabilitacionBotones(alta, baja, edicion, consulta);
        vista.agregarListenerBotonConsulta(new opcionConsultaProducto());
        vista.agregarListenerBotonMenu(new opcionMenu());
        if( alta && baja && edicion){
            vista.agregarListenerBotonAlta(new opcionAltaProducto());
            vista.agregarListenerBotonBaja(new OpcionBajaProducto());
            vista.agregarListenerBotonEdicion(new opcionEdicionProducto());
        }
    }
    
    
    private class  opcionAltaProducto implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent evento) {
            vista.setVisible(false);
            ControlAltaCliente vistaHija= new ControlAltaCliente((new ManejoArchivo("").obtenerContadoresEntidades(1))+1,vista);
                
            
            
        }
    }

    private class  OpcionBajaProducto implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent evento) {
            vista.setVisible(false);
            ControlBajaCliente vistaHija= new ControlBajaCliente(vista);
            
        }
        
        
    }

        
     private class  opcionEdicionProducto implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent evento) {
            try{
                vista.setVisible(false);
                ControlEdicionProducto vistaHija= new ControlEdicionProducto(vista);
                
            }catch(Exception excep){
            }
            
        }

    }

     private class  opcionConsultaProducto implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent evento) {
            vista.setVisible(false);
            ControlConsultaProducto vistaHija= new ControlConsultaProducto(vista);
           
            
        }

    }
   
    private class  opcionMenu implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent evento) {
            if(usuario.obtenerRol().obtenerModuloUsuario().obtenerPermisoAlta()){
              ControlMenuPrincipalAdmin  vistaMadre=new ControlMenuPrincipalAdmin(usuario);
            }else{
                ControlMenuPrincipalEmpleado vistaMadre=new ControlMenuPrincipalEmpleado();
            }
            vista.dispose();
            
        }

    }
    
    
    
    
    
}
