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
    
    public void ControlLogin(){
        this.usuario=null;
        this.loginGeneral= new VistaLogin();
        this.loginAdmin=null;
        this.intentos=0;
        loginGeneral.agregarListenerBotonIniciarSesión(new SesionEmpleado());
        loginGeneral.agregarListenerBotonSesionAdmin(new CambiarTipoSesion());
        loginGeneral.ocultarErrorBloqueo();
        loginGeneral.ocultarErrorContrasenaIncorrects();
        loginGeneral.ocultarErrorUsuario();
        loginAdmin.agregarListenerBotonIniciarSesión(new SesionAdmin());
        loginAdmin.ocultarErrorBloqueo();
        loginAdmin.ocultarErrorContrasenaIncorrects();
    }
    
        
    private class  SesionEmpleado implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent evento) {
            try{
                
                ManejoArchivo lectura= new ManejoArchivo("Usuarios.txt");
                lectura.compararContrasenaString(lectura.obtenerLineaArchivo(lectura.busquedaDatosEnArchivo(loginGeneral.obtenerUsuario())), loginGeneral.obtenerContrasena());
                usuario= new Usuario("Empleado", loginGeneral.obtenerUsuario(), loginGeneral.obtenerContrasena());
                loginGeneral.resetearCampos();
                ControlMenuPrincipalEmpleado vista=new ControlMenuPrincipalEmpleado(usuario, loginGeneral);
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
            loginGeneral.dispose();
            loginAdmin = new VistaLoginAdmin();
        }

    }
    
    private class  SesionAdmin implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent evento) {
            try{
            ManejoArchivo lectura=new ManejoArchivo("");
            lectura.LeerArchivo();
            lectura.compararContrasenaString(lectura.obtenerLineaArchivo(0), loginAdmin.obtenerContrasena());
            usuario= new Usuario("Administrador", "Administrador", loginAdmin.obtenerContrasena());
            loginAdmin.resetearCampos();
            ControlMenuPrincipalAdmin vista=new ControlMenuPrincipalAdmin(usuario, loginAdmin);
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
    
}
