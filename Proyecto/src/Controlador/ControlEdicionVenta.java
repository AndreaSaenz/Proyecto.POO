/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import Excepciones.ElementoNoEncontradoException;
import Excepciones.RepeticionException;
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
        this.venta= null;
        this.vista= new VistaEdicionVentas();
        this.vistaMadre= vistaRaiz;
        this.indice=-1;
        vistaMadre.setVisible(false);
        vista.ocultarCampos(); 
        vista.agregarListenerBotonAceptarErrorCliente(new DarAltaCliente());
        vista.agregarListenerBotonAceptarMejorCaso(new MensajeAccionCompletadaEdicionVenta());
        vista.agregarListenerBotonBuscar(new ProcesoBusquedaEnEdicionVenta());
        vista.agregarListenerBotonAceptarErrorProducto(new ProductoNoEncontrado());
        vista.agregarListenerBotonAceptarErrorVenta(new CancelarProcesoEdicionVenta());
        vista.agregarListenerBotonEliminarProducto(new EliminarProducto());
        vista.agregarListenerBotonGuardar(new ProcesoGuardarEdicionVenta());
        vista.agregarListenerBotonAgregarProducto(new AgregarProducto());
    }
    
    
    
    private class  ProcesoGuardarEdicionVenta implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent evento) {
            try{
                ManejoArchivo  lectura= new ManejoArchivo("Ventas.txt");
                ManejoArchivo clientes=new ManejoArchivo("Clientes.txt");
                int claveCliente=clientes.busquedaDatosEnArchivo(vista.obtenerRFC());
                venta.establecerCliente(new Cliente(clientes.obtenerLineaArchivo(indice)));
                lectura.establecerLineaArchivo(indice, venta.toString());
                vista.mostrarMensajeGuardado();
            }catch(RepeticionException excep){
                vista.mostrarMensajeErrorCliente();
            }
            
        }

    }
    
    
    private class  ProcesoBusquedaEnEdicionVenta implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent evento) {
            try{
                vista.deshabilitarCajaId();
                vista.deshabilitarBotonBuscar();
                ManejoArchivo archivo=new ManejoArchivo("Ventas.txt");
                indice=archivo.busquedaDatosEnArchivo(vista.obtenerId());
                String cadena=archivo.obtenerLineaArchivo(indice);
                venta= new Venta(cadena);
                vista.establecerRFC(venta.obtenerCliente().obtenerRfc());
                vista.establecerRazonSocial(venta.obtenerCliente().obtenerRazonSocial());
                vista.establecerDireccion(venta.obtenerCliente().obtenerDireccion());
                vista.establecerTelefono(venta.obtenerCliente().obtenerTelefono());
                vista.establecerFecha(venta.obtenerFecha());
                vista.establecerSubtotal(Double.toString(venta.obtenerSubtotal()));
                vista.establecerIVA(Double.toString(venta.obtenerIva()));
                vista.establecerTotal(Double.toString(venta.obtenerTotal()));
                //mostrar tabla
                vista.mostrarCampos();
            }catch(ElementoNoEncontradoException excep){
                vista.mostrarMensajeErrorVenta();
            }
            
        }

    }
    
    private class  DarAltaCliente implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent evento) {
            ManejoArchivo lectura2=new ManejoArchivo("");
            int[] indices=lectura2.obtenerContadoresEntidades();
            ControlAltaCliente alta= new ControlAltaCliente(indices[0]);            
        }

    }
    
    
    
    private class  ProductoNoEncontrado implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent evento) {
            vista.ocultarMensajeErrorProducto();
            vista.activarBotonAgregarProducto();
            vista.activarCajaAgregarProducto();
            vista.activarBotonEliminarProducto();
            vista.activarCajaEliminarProducto();
         }

    }
    
    private class  EliminarProducto implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent evento) {
            try{
                vista.desactivarBotonElminarProducto();
                vista.desactivarCajaElminarProducto();
                venta.eliminarProducto(vista.obtenerClaveProductoEliminado());
                ManejoArchivo archivo=new ManejoArchivo("Productos.txt");
                
                archivo.aumentarCantidadProducto(vista.obtenerClaveProductoEliminado());
                venta.establecerSubtotal();
                venta.obtenerIva();
                venta.obtenerTotal();
                 //actualizar tabla
                vista.establecerSubtotal(Double.toString(venta.obtenerSubtotal()));
                vista.establecerIVA(Double.toString(venta.obtenerIva()));
                vista.establecerTotal(Double.toString(venta.obtenerTotal()));
               
            }catch(ElementoNoEncontradoException excep5){
                vista.mostrarMensajeErrorProducto();
            }finally{
                vista.activarBotonEliminarProducto();
                vista.activarCajaEliminarProducto();
            }
        }

    }
    
    private class  MensajeAccionCompletadaEdicionVenta implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent evento) {
            vistaMadre.dispose();
            vista.dispose();
        }

    }
    
    private class  CancelarProcesoEdicionVenta implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent evento) {
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
