/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Excepciones.IncompatibilidadContrasenaException;
import Excepciones.RepeticionException;
import Modelo.Usuario;
import Vista.VistaAltaEmpleado;
import Vista.VistaControlAccionesEmpleados;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * @author 1047470
 */
public class ControlAltaEmpleado {
    
    private Usuario empleado;
    private VistaAltaEmpleado vista;
    private VistaControlAccionesEmpleados vistaMadre;
    
    public ControlAltaEmpleado(VistaControlAccionesEmpleados vistaRaiz){
        this.empleado= new Usuario("Empleado","","");
        this.vista= new VistaAltaEmpleado();
        this.vistaMadre= vistaRaiz;    
        vistaMadre.setVisible(false);
        vista.ocultarErrorConstrasena();
        vista.ocultarErrorRepeticion();
        vista.agregarListenerBotonRegistrar(new ProcesoAltaEmpleado());
        vista.agregarListenerBotonAceptarMejorCaso(new CerrarProcesoAltaEmpleado());
        vista.agregarListenerBotonCancelar(new CerrarProcesoAltaEmpleado());
        vista.setVisible(true);
    }
    
    
    
    private class  ProcesoAltaEmpleado implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent evento) {
            try{
                ManejoArchivo  lectura= new ManejoArchivo("Usuarios.txt");
                lectura.verificarNoRepeticion(vista.obtenerNombreUsuario());
                empleado.establecerNombre(vista.obtenerNombreUsuario());
                vista.compararContrasenas();
                empleado.establecerContrasena(vista.obtenerContrasena1());
                lectura.agregarLineaArchivo(empleado.toString());
                vista.mostrarMensajeGuardado();
            }catch(RepeticionException excep){
                vista.mostrarErrorRepeticion();
            }catch(IncompatibilidadContrasenaException excep2){
                vista.mostrarErrorConstrasena();
            }
            
        }

    }
    
   
    
    private class  CerrarProcesoAltaEmpleado implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent evento) {
            vistaMadre.setVisible(true);
            vista.cerrarMensajeGuardado();
            vista.dispose();
        }

    }
    
    
    
    
    
    
}
