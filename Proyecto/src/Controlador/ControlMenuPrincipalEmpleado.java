/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Usuario;
import Vista.VistaLogin;
import Vista.VistaMenuPrincipalEmpleado;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author 1047470
 */
public class ControlMenuPrincipalEmpleado {
    
    private VistaMenuPrincipalEmpleado vista;
    private Usuario usuario;
    private VistaLogin vistaLogin;
    
    
    public ControlMenuPrincipalEmpleado(Usuario usuario, VistaLogin vistaLogin){
        this.usuario= usuario;
        this.vista= new VistaMenuPrincipalEmpleado();
        this.vistaLogin=vistaLogin;
        vista.agregarListenerBotonClientes(new opcionClientes());
        vista.agregarListenerBotonProductos(new opcionProductos());
        vista.agregarListenerBotonVentas(new opcionVentas());
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
    
       
    private class  opcionCerrarSesion implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent evento) {
            vistaLogin.setVisible(true);
            vista.dispose();
        }
    }

}
