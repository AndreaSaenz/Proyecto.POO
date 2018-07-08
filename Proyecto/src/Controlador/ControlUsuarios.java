/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Usuario;
import Vista.VistaControlAccionesEmpleados;
import Vista.VistaLoginAdmin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author 1047470
 */
public class ControlUsuarios {
   
    private VistaControlAccionesEmpleados vista;
    private Usuario usuario;
    
    public ControlUsuarios(Usuario usuario){
        this.vista= new VistaControlAccionesEmpleados();
        this.usuario=usuario;
        
        vista.agregarListenerBotonAlta(new opcionAltaUsuario());
        vista.agregarListenerBotonMenu(new opcionMenu());
        vista.agregarListenerBotonBaja(new OpcionBajaUsuario());
        vista.setVisible(true);
    }
    
         //---------------------
    
    
    private class  opcionAltaUsuario implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent evento) {
            vista.setVisible(false);
            ControlAltaEmpleado vistaHija= new ControlAltaEmpleado(vista);
                
            
            
        }
    }

    private class  OpcionBajaUsuario implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent evento) {
            vista.setVisible(false);
            ControlBajaEmpleado vistaHija= new ControlBajaEmpleado(vista);
            
        }
        
        
    }

        
    
   
    private class  opcionMenu implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent evento) {
            ControlMenuPrincipalAdmin vistaMadre = new ControlMenuPrincipalAdmin(usuario, new VistaLoginAdmin());
            vista.dispose();
            
        }
    }

    
}
