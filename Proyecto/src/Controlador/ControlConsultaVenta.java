/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Excepciones.ElementoNoEncontradoException;
import Modelo.Producto;
import Modelo.Venta;
import Vista.VistaConsultaVenta;

import Vista.VistaControlAccionesEntidades;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * @author 1047470
 */
public class ControlConsultaVenta {
    private Venta ventaTabla;
    private VistaConsultaVenta vista;
    private VistaControlAccionesEntidades vistaMadre;
    
    public ControlConsultaVenta(VistaControlAccionesEntidades vistaRaiz){
        this.ventaTabla=new Venta(0);
        this.vista= new VistaConsultaVenta(ventaTabla.obtenerProductos());
        this.vistaMadre= vistaRaiz;
        vistaMadre.setVisible(false);
        vista.ocultarCampos();
        vista.agregarListenerBotonBuscar(new ProcesoConsultaVenta());
        vista.agregarListenerBotonListo(new CancelarProcesoConsultaVenta());
        vista.agregarListenerBotonAceptarError(new CancelarProcesoConsultaVenta());
        vista.agregarListenerBotonCancelar(new CancelarProcesoConsultaVenta());
        vista.setVisible(true);
    }
    
    
    
    private class  ProcesoConsultaVenta implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent evento) {
            try{
                vista.ocultarMensajeError();
                vista.inhabilitarCajaId();
                vista.deshabilitarBotonBuscar();
                ManejoArchivo archivo=new ManejoArchivo("Ventas.txt");
                int indice=archivo.busquedaDatosEnArchivo(vista.obtenerIdVenta());
                String cadena=archivo.obtenerLineaArchivo(indice);
                Venta venta= new Venta(cadena);
                
                vista.establecerRFC(venta.obtenerCliente().obtenerRfc());
                vista.establecerRazonSocial(venta.obtenerCliente().obtenerRazonSocial());
                vista.establecerDireccion(venta.obtenerCliente().obtenerDireccion());
                vista.establecerTelefono(venta.obtenerCliente().obtenerTelefono());
                vista.establecerFecha(venta.obtenerFecha());
                vista.establecerSubtotal(Double.toString(venta.obtenerSubtotal()));
                vista.establecerIVA(Double.toString(venta.obtenerIva()));
                vista.establecerTotal(Double.toString(venta.obtenerTotal()));
                for(int i=0; i<venta.obtenerProductos().size(); i++){
                    ventaTabla.agregarProducto(venta.obtenerProductos().get(i));
                }
                vista.mostrarCampos();
            }catch(ElementoNoEncontradoException excep){
                vista.mostrarMensajeError();
            }
            
        }

    }
    

    
    private class  CancelarProcesoConsultaVenta implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent evento) {
            vistaMadre.setVisible(true);
            vista.cerrarMensajeError();
            vista.dispose();
        }

    }
    
    
    
}
