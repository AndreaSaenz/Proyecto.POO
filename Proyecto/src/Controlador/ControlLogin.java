/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Excepciones.ElementoNoEncontradoException;
import Excepciones.IncompatibilidadContrasenaException;
import Excepciones.LimiteIntentosException;
import Modelo.Usuario;
import Vista.VistaLogin; 
import Vista.VistaLoginAdmin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 *
 * @author 1047470
 */
public class ControlLogin {
    private Usuario usuario;
    private VistaLogin loginGeneral;
    private VistaLoginAdmin loginAdmin;
    private int intentos;

    ControlLogin(Usuario usuario, VistaLogin vistaLogin) {
        this.usuario=usuario;
        this.loginGeneral= vistaLogin;
        this.loginAdmin=new VistaLoginAdmin();
        this.intentos=0;
       
        loginGeneral.agregarListenerBotonIniciarSesión(new SesionEmpleado());
        loginGeneral.agregarListenerBotonSesionAdmin(new CambiarTipoSesion());
        loginGeneral.ocultarErrorBloqueo();
        loginGeneral.ocultarErrorContrasenaIncorrects();
        loginGeneral.ocultarErrorUsuario();
        loginAdmin.agregarListenerBotonIniciarSesión(new SesionAdmin());
        loginAdmin.agregarListenerBotonSesionEmpleado(new CambiarAGeneral());
        loginAdmin.ocultarErrorBloqueo();
        loginAdmin.ocultarErrorContrasenaIncorrects();
        loginGeneral.setVisible(true);
        loginAdmin.setVisible(false);

    }

   /* public void ControlLogin(Usuario usuario, VistaLogin vistaLogin){
        this.usuario=usuario;
        this.loginGeneral= vistaLogin;
        this.loginAdmin=new VistaLoginAdmin();
        this.intentos=0;
       
        loginGeneral.agregarListenerBotonIniciarSesión(new SesionEmpleado());
        loginGeneral.agregarListenerBotonSesionAdmin(new CambiarTipoSesion());
        loginGeneral.ocultarErrorBloqueo();
        loginGeneral.ocultarErrorContrasenaIncorrects();
        loginGeneral.ocultarErrorUsuario();
        loginAdmin.agregarListenerBotonIniciarSesión(new SesionAdmin());
        loginAdmin.ocultarErrorBloqueo();
        loginAdmin.ocultarErrorContrasenaIncorrects();
        loginGeneral.setVisible(true);
        loginAdmin.setVisible(false);
        //loginGeneral.setVisible(true);s
    }*/

    ControlLogin() {
         this.usuario=new Usuario("","","");
        this.loginGeneral= new VistaLogin();
        this.loginAdmin=new VistaLoginAdmin();
        this.intentos=0;
       
        loginGeneral.agregarListenerBotonIniciarSesión(new SesionEmpleado());
        loginGeneral.agregarListenerBotonSesionAdmin(new CambiarTipoSesion());
        loginGeneral.ocultarErrorBloqueo();
        loginGeneral.ocultarErrorContrasenaIncorrects();
        loginGeneral.ocultarErrorUsuario();
        loginAdmin.agregarListenerBotonIniciarSesión(new SesionAdmin());
        loginAdmin.ocultarErrorBloqueo();
        loginAdmin.ocultarErrorContrasenaIncorrects();
        loginGeneral.setVisible(true);
        loginAdmin.setVisible(false);
    }
    
    
    /*public void ControlLogin(){
        this.usuario=new Usuario("","","");
        this.loginGeneral= new VistaLogin();
        this.loginAdmin=new VistaLoginAdmin();
        this.intentos=0;
       
        loginGeneral.agregarListenerBotonIniciarSesión(new SesionEmpleado());
        loginGeneral.agregarListenerBotonSesionAdmin(new CambiarTipoSesion());
        loginGeneral.ocultarErrorBloqueo();
        loginGeneral.ocultarErrorContrasenaIncorrects();
        loginGeneral.ocultarErrorUsuario();
        loginAdmin.agregarListenerBotonIniciarSesión(new SesionAdmin());
        loginAdmin.ocultarErrorBloqueo();
        loginAdmin.ocultarErrorContrasenaIncorrects();
        loginGeneral.setVisible(true);
        loginAdmin.setVisible(false);
        //loginGeneral.setVisible(true);
    }
    */
        
    private class  SesionEmpleado implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent evento) {
            try{
                
                ManejoArchivo lectura= new ManejoArchivo("Usuarios.txt");
                lectura.LeerArchivo();
                int indice=(lectura.busquedaDatosEnArchivo(loginGeneral.obtenerUsuario()));
                lectura.compararContrasenaString(lectura.obtenerLineaArchivo(indice), loginGeneral.obtenerContrasena());
                if(indice>0){
                    usuario.establecerRol("Empleado");
                }
                else{
                    usuario.establecerRol("Administrador");
                }
                usuario.establecerNombre(loginGeneral.obtenerUsuario());
                usuario.establecerContrasena(loginGeneral.obtenerContrasena());
                loginGeneral.resetearCampos();
                if(indice>0){
                    ControlMenuPrincipalEmpleado vista=new ControlMenuPrincipalEmpleado(usuario, loginGeneral);
                }
                else{
                    ControlMenuPrincipalAdmin vista=new ControlMenuPrincipalAdmin(usuario, loginAdmin);
                }
            }catch(ElementoNoEncontradoException excep1){
                    loginGeneral.resetearCampos();
                    loginGeneral.mostrarErrorUsuario();
            }catch(IncompatibilidadContrasenaException excep){
                    try{
                        intentos++;
                        comprobarNumeroEquivocaciones();
                        loginGeneral.mostrarErrorContrasenaIncorrects();
                        loginGeneral.limpiarContrasena();
                        loginGeneral.bloquearCajaUsuario();
                    }catch(LimiteIntentosException excep4){
                        loginGeneral.bloquearCajaContrasena();
                    }
                    
             }
            
        }
    }               
            
            
     private void comprobarNumeroEquivocaciones() throws LimiteIntentosException{
         if(intentos==3){
             throw new LimiteIntentosException("Llegó al límite de intentos"); 
         }
     }   

    
    
    private class  CambiarTipoSesion implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent evento) {
            loginGeneral.resetearCampos();
            loginGeneral.setVisible(false);
            loginAdmin.setVisible(true);
        }

    }
    
    
    private class  CambiarAGeneral implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent evento) {
            loginAdmin.limpiarContrasena();
            loginGeneral.setVisible(true);
            loginAdmin.setVisible(false);
        }

    }
    
    private class  SesionAdmin implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent evento) {
            try{
            ManejoArchivo lectura=new ManejoArchivo("Usuarios.txt");
            lectura.LeerArchivo();
            lectura.compararContrasenaString(lectura.obtenerLineaArchivo(0), loginAdmin.obtenerContrasena());
            usuario= new Usuario("Administrador", "Administrador", loginAdmin.obtenerContrasena());
            loginAdmin.limpiarContrasena();
            ControlMenuPrincipalAdmin vista=new ControlMenuPrincipalAdmin(usuario, loginAdmin);
            }catch(IncompatibilidadContrasenaException excep){
                 try{
                    intentos++;
                    comprobarNumeroEquivocaciones();
                    loginAdmin.mostrarErrorContrasenaIncorrects();
                    loginAdmin.limpiarContrasena();
                    
                }catch(LimiteIntentosException excep4){
                    loginGeneral.bloquearCajaContrasena();
                }
                    
            } /*catch (ElementoNoEncontradoException ex) {
                 loginAdmin.bloquearCajaContrasena();
            */
            
        }

    }
    
     
        
    
    
}
