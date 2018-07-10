/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import Excepciones.ElementoNoEncontradoException;
import Modelo.Cliente;
import Modelo.Producto;

import Modelo.Venta;
import Vista.VistaControlAccionesEntidades;
import Vista.VistaEdicionVentas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author 1047470
 */
public class ControlEdicionVenta {
    
    
    
    private Venta venta;
    private VistaEdicionVentas vista;
    private VistaControlAccionesEntidades vistaMadre;
    private int indice;
    
    public ControlEdicionVenta( VistaControlAccionesEntidades vistaRaiz){
        this.venta=new Venta(0);
        this.vista= new VistaEdicionVentas(venta.obtenerProductos());
        this.vistaMadre= vistaRaiz;
        this.indice=-1;
        vistaMadre.setVisible(false);
        vista.activarCajaAgregarProducto();
        vista.activarBotonEliminarProducto();
        vista.activarBotonAgregarProducto();
        vista.ocultarCampos(); 
        vista.agregarListenerBotonAceptarErrorCliente(new DarAltaCliente());
        vista.agregarListenerBotonAceptarMejorCaso(new CancelarProcesoEdicionVenta());
        vista.agregarListenerBotonBuscar(new ProcesoBusquedaEnEdicionVenta());
        vista.agregarListenerBotonAceptarErrorProducto(new ProductoNoEncontrado());
        vista.agregarListenerBotonAceptarErrorVenta(new CancelarProcesoEdicionVenta());
        vista.agregarListenerBotonEliminarProducto(new EliminarProducto());
        vista.agregarListenerBotonGuardar(new ProcesoGuardarEdicionVenta());
        vista.agregarListenerBotonAgregarProducto(new AgregarProducto());
        vista.agregarListenerBotonCancelar(new CancelarProcesoEdicionVenta());
        vista.agregarListenerBotonCancelarPrincipal(new CancelarProcesoEdicionVenta());
        vista.setVisible(true);
    }
    
    
    
    private class  ProcesoGuardarEdicionVenta implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent evento) {
            try{
                vista.ocultarMensajes();
                ManejoArchivo clientes=new ManejoArchivo("Clientes.txt");
                int claveCliente=clientes.busquedaDatosEnArchivo(vista.obtenerRFC());
                String temporal=clientes.obtenerLineaArchivo(indice);
                venta.establecerCliente(new Cliente(temporal));
                ManejoArchivo  lectura= new ManejoArchivo("Ventas.txt");
                lectura.establecerLineaArchivo(indice, venta.toString());
                vista.mostrarMensajeGuardado();
            }catch(ElementoNoEncontradoException excep){
                vista.mostrarMensajeErrorCliente();
            } 
        }

    }
    
    
    private class  ProcesoBusquedaEnEdicionVenta implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent evento) {
            try{
               vista.ocultarMensajes();
                vista.deshabilitarCajaId();
                vista.deshabilitarBotonBuscar();
                ManejoArchivo archivo=new ManejoArchivo("Ventas.txt");
                indice=archivo.busquedaDatosEnArchivo(vista.obtenerId());
                String cadena=archivo.obtenerLineaArchivo(indice);
                Venta otraVenta= new Venta(cadena);
                venta.establecerId(otraVenta.obtenerId());
                venta.establecerFecha(venta.obtenerFecha());
                
                vista.establecerRFC(otraVenta.obtenerCliente().obtenerRfc());
                vista.establecerRazonSocial(otraVenta.obtenerCliente().obtenerRazonSocial());
                vista.establecerDireccion(otraVenta.obtenerCliente().obtenerDireccion());
                vista.establecerTelefono(otraVenta.obtenerCliente().obtenerTelefono());
                vista.establecerFecha(otraVenta.obtenerFecha());
                vista.establecerSubtotal(Double.toString(otraVenta.obtenerSubtotal()));
                vista.establecerIVA(Double.toString(otraVenta.obtenerIva()));
                vista.establecerTotal(Double.toString(otraVenta.obtenerTotal()));
                for(int i=0; i<otraVenta.obtenerProductos().size(); i++){
                    venta.agregarProducto(otraVenta.obtenerProductos().get(i));
                }
                venta.establecerSubtotal();
                venta.establecerIva();
                venta.establecerTotal();
                vista.mostrarCampos();
            }catch(ElementoNoEncontradoException excep){
                vista.mostrarMensajeErrorVenta();
            }
            
        }

    }
    
    private class  DarAltaCliente implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent evento) {
           // vista.setVisible(false);
            vista.ocultarMensajes();
            ManejoArchivo lectura2=new ManejoArchivo("");
            int indices=lectura2.obtenerContadoresEntidades(0);
            indices +=1;
            ControlAltaCliente alta= new ControlAltaCliente(indices, null);
            vista.establecerRFC("C-"+indice);
        }

    }
    
    
    
    private class  ProductoNoEncontrado implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent evento) {
            vista.ocultarMensajes();
            vista.activarBotonAgregarProducto();
            vista.activarCajaAgregarProducto();
            vista.activarBotonEliminarProducto();
           
        }

    }
    
    private class  EliminarProducto implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent evento) {
            try{
                vista.ocultarMensajes();
                vista.desactivarBotonElminarProducto();
               
                
                ManejoArchivo archivo=new ManejoArchivo("Productos.txt");
                
                archivo.aumentarCantidadProducto(vista.eliminarProductoTabla().obtenerClave());
                venta.establecerSubtotal();
                venta.establecerIva();
                venta.establecerTotal();
                 //actualizar tabla
                vista.establecerSubtotal(Double.toString(venta.obtenerSubtotal()));
                vista.establecerIVA(Double.toString(venta.obtenerIva()));
                vista.establecerTotal(Double.toString(venta.obtenerTotal()));
               
            }catch(ElementoNoEncontradoException excep5){
                vista.mostrarMensajeErrorProducto();
            }finally{
                vista.activarBotonEliminarProducto();
                
            }
        }

    }
    
   
    
    private class  CancelarProcesoEdicionVenta implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent evento) {
            vista.cerrarMensajes();
            vistaMadre.setVisible(true);
            vista.dispose();
        }

    }
    
    private class  AgregarProducto implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent evento) {
            try{
                vista.desactivarCajaAgregarProducto();
                vista.desactivarBotonAgregarProducto();
                vista.ocultarMensajes();
                ManejoArchivo archivo=new ManejoArchivo("Productos.txt");
                int indiceProducto=archivo.busquedaDatosEnArchivo(vista.obtenerClaveProductoAgregado());
                String cadena=archivo.obtenerLineaArchivo(indiceProducto);
                Producto producto= new Producto(cadena);
                venta.agregarProducto(producto);
                archivo.disminuirCantidadProducto(indiceProducto);
                venta.establecerSubtotal();
                venta.obtenerIva();
                venta.obtenerTotal();
                 //actualizar tabla
                vista.establecerSubtotal(Double.toString(venta.obtenerSubtotal()));
                vista.establecerIVA(Double.toString(venta.obtenerIva()));
                vista.establecerTotal(Double.toString(venta.obtenerTotal()));
               
            }catch(ElementoNoEncontradoException excep4){
                vista.mostrarMensajeErrorProducto();
            }finally{
                vista.activarBotonAgregarProducto();
                vista.activarCajaAgregarProducto();
            }
        }

    }
    
}
