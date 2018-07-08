/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Usuario;
import Vista.VistaLoginAdmin;
import Vista.VistaMenuPrincipalAdmin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author andrea
 */
public class ControlMenuPrincipalAdmin {
    
    
    private VistaMenuPrincipalAdmin vista;
    private Usuario usuario;
    
    
    public ControlMenuPrincipalAdmin(Usuario usuario){
        this.usuario= usuario;
        this.vista= new VistaMenuPrincipalAdmin();
        
        vista.agregarListenerBotonClientes(new opcionClientes());
        vista.agregarListenerBotonProductos(new opcionProductos());
        vista.agregarListenerBotonVentas(new opcionVentas());
        vista.agregarListenerBotonEmpleado(new opcionEmpleados());
        vista.agregarListenerBotonCerrarSesion(new opcionCerrarSesion());
    }
    
    
    
    private class  opcionClientes implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent evento) {
            ControlClientes vistaHija= new ControlClientes(usuario);
            vista.dispose();
        }
    }
    
    private class  opcionProductos implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent evento) {
             ControlProductos vistaHija= new ControlProductos(usuario);
            vista.dispose();
        }

    }
    
    private class  opcionVentas implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent evento) {
             ControlVentas vistaHija= new ControlVentas(usuario);
            vista.dispose();
        }

    }
    
    private class  opcionEmpleados implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent evento) {
            ControlUsuarios vistaHija= new ControlUsuarios(usuario);
            vista.dispose();
        }
    }
    
    private class  opcionCerrarSesion implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent evento) {
            
        }
    }
    
    
    
}
