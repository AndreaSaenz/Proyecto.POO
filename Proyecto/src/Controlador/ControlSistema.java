/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Usuario;
import Vista.VistaLogin;
import Vista.VistaLoginAdmin;

/**
 *
 * @author andreas
 */
public class ControlSistema {
    
public void iniciarPrograma(){
         java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
              ControlLogin controlador= new ControlLogin();

              //ControlLogin controlador= new ControlLogin(new Usuario("Empleado","",""), new VistaLogin());
               //ControlProductos controller= new ControlProductos(new Usuario("Empleado","",""));
               //ControlMenuPrincipalAdmin hey=new ControlMenuPrincipalAdmin(new Usuario("Administrador", "Administrador",""),new VistaLoginAdmin());
               //ControlLogin controladores= new ControlLogin(new Usuario("Empleado","",""), new VistaLogin()); 
              // VistaLogin vista=new VistaLogin();
               //vista.setVisible(true);
               //ControlAltaCliente alta= new ControlAltaCliente(7, null);
            }
        });
     }
    
    
}
