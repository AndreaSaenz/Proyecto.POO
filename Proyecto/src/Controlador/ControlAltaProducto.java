/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;



import Excepciones.RepeticionException;
import Modelo.Producto;

import Vista.VistaAltaProducto;
import Vista.VistaControlAccionesEntidades;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * @author 1047470
 */
public class ControlAltaProducto {
    
    
    
    
    
    private Producto producto;
    private VistaAltaProducto vista;
    private VistaControlAccionesEntidades vistaMadre;
    
    public ControlAltaProducto(int clave, VistaControlAccionesEntidades vistaRaiz){
        this.producto= new Producto(clave,"",0,0);
        this.vista= new VistaAltaProducto();
        this.vistaMadre= vistaRaiz;
        vista.ocultarErrorRepeticion();
        vistaMadre.setVisible(false);
        vista.establecerClave(clave);
        vista.setVisible(true);
        vista.agregarListenerBotonRegistrar(new ProcesoAltaProducto());
        vista.agregarListenerBotonAceptarMejorCaso(new CerrarProcesoAltaProducto());
        vista.agregarListenerBotonCancelar(new CerrarProcesoAltaProducto());
        vista.setVisible(true);
    }
    
    
    
    private class  ProcesoAltaProducto implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent evento) {
            try{
                ManejoArchivo  lectura= new ManejoArchivo("Productos.txt");
                lectura.verificarNoRepeticion(vista.obtenerDescripcion());
                producto.establecerDescripcion(vista.obtenerDescripcion());
                producto.establecerPrecioUnitario(Double.valueOf(vista.obtenerPrecio()));
                producto.establecerCantidad(Integer.valueOf(vista.obtenerCantidad()));
                lectura.agregarLineaArchivo(producto.toString());
                ManejoArchivo cont= new ManejoArchivo("");
                int[] contadoresSinModificar= cont.obtenerContadoresEntidades();
                contadoresSinModificar[1]+=1;
                cont.modificarContadoresEntidades(contadoresSinModificar);
                vista.mostrarMensajeGuardado();
            }catch(RepeticionException excep){
                vista.mostrarErrorRepeticion();
            }
            
        }

    }
    
   
    private class  CerrarProcesoAltaProducto implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent evento) {
            vistaMadre.setVisible(true);
            vista.cerrarMensajeGuardado();
            vista.dispose();
        }

    }
    
    
    
    
    
    
}
