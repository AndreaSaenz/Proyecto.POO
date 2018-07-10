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
import Vista.VistaAltaVentas;
import Vista.VistaControlAccionesEntidades;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 1047470
 */
public class ControlAltaVenta {
    
    
    
    
    private Venta venta;
    private VistaAltaVentas vista;
    private VistaControlAccionesEntidades vistaMadre;
    
    public ControlAltaVenta(int id, VistaControlAccionesEntidades vistaRaiz){
        this.venta= new Venta(id);
        this.vista= new VistaAltaVentas(venta.obtenerProductos());
        this.vistaMadre= vistaRaiz;
        
        vista.establecerIdVenta(id);
        GregorianCalendar fecha= new GregorianCalendar();
        vista.establecerFecha(fecha);
        venta.establecerFecha(vista.obtenerFecha());
        vista.activarCajaAgregarProducto();
        
        vista.agregarListenerBotonAceptarErrorCliente(new DarAltaCliente());
        vista.agregarListenerBotonAceptarMejorCaso(new MensajeAccionCompletadaAltaVenta());
        vista.agregarListenerBotonAceptarErrorProducto(new ProductoNoEncontrado());
        vista.agregarListenerBotonCancelar(new CancelarProcesoEdicionVenta());
        vista.agregarListenerBotonEliminarProducto(new EliminarProducto());
        vista.agregarListenerBotonAceptar(new ProcesoGuardarAltaVenta());
        vista.agregarListenerBotonAgregarProducto(new AgregarProducto());
        vista.agregarListenerBotonCancelarAltaCliente(new CancelarAltaCliente());
         vista.setVisible(true);
    }
    
    
    

    private class  ProcesoGuardarAltaVenta implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent evento) {
            try{
                vista.ocultarMensajes();
                GregorianCalendar fecha= new GregorianCalendar();
                vista.establecerFecha(fecha);     
                ManejoArchivo clientes=new ManejoArchivo("Clientes.txt");
                int claveCliente=clientes.busquedaDatosEnArchivo(vista.obtenerRFC());
                String temporal=clientes.obtenerLineaArchivo(claveCliente);
                venta.establecerCliente(new Cliente(temporal));
                venta.establecerFecha(vista.obtenerFecha());    
                vista.establecerRFC(venta.obtenerCliente().obtenerRfc());
                vista.establecerRazonSocial(venta.obtenerCliente().obtenerRazonSocial());
                vista.establecerDireccion(venta.obtenerCliente().obtenerDireccion());
                vista.establecerTelefono(venta.obtenerCliente().obtenerTelefono());
                ManejoArchivo  lectura= new ManejoArchivo("Ventas.txt");
                lectura.LeerArchivo();
                lectura.agregarLineaArchivo(venta.toString());
                int contadorVentas=new ManejoArchivo("").obtenerContadoresEntidades(2);
                contadorVentas+=1;
                new ManejoArchivo("").modificarContadoresEntidades(2, "Ventas:"+contadorVentas);
                vista.mostrarMensajeGuardado();
            }catch (ElementoNoEncontradoException ex) {
                vista.mostrarMensajeErrorCliente();
            }
            
        }

    }
    
    
   
    
    private class  DarAltaCliente implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent evento) {
            vista.ocultarMensajes();
            ManejoArchivo lectura2=new ManejoArchivo("");
            int indices=lectura2.obtenerContadoresEntidades(0);
            indices += 1;
            ControlAltaCliente alta= new ControlAltaCliente(indices,null);
            vista.ocultarMensajeErrorCliente();
            vista.establecerRFC("C-"+indices);
            
        }

    }
    
    private class CancelarAltaCliente implements ActionListener{
        @Override
        public void actionPerformed (ActionEvent evento){
            vista.ocultarMensajes();
        
        }
    }
    
    private class  ProductoNoEncontrado implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent evento) {
            vista.ocultarMensajeErrorProducto();
            vista.activarBotonAgregarProducto();
            vista.activarCajaAgregarProducto();
            vista.activarBotonEliminarProducto();
            
         }

    }
    
    private class  EliminarProducto implements ActionListener{

        @Override
       
        public void actionPerformed(ActionEvent evento) {
            try{
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
               
            }catch(ArrayIndexOutOfBoundsException excep5){
                vista.mostrarMensajeErrorProducto();
            } catch (ElementoNoEncontradoException ex) {
                vista.mostrarMensajeErrorProducto();;
            }finally{
                vista.activarBotonEliminarProducto();
            }
        }

    }
    
    private class  MensajeAccionCompletadaAltaVenta implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent evento) {
            
            vista.resetCampos();
            vista.ocultarMensajes();
            vista.resetearTablaProductos();
            int contadorVentas=new ManejoArchivo("").obtenerContadoresEntidades(2);
            vista.establecerIdVenta(contadorVentas+1);
            venta.establecerId(contadorVentas+1);
            GregorianCalendar fecha= new GregorianCalendar();
            vista.establecerFecha(fecha);
            venta.establecerFecha(vista.obtenerFecha());
            
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
                
                ManejoArchivo archivo=new ManejoArchivo("Productos.txt");
                int indiceProducto=archivo.busquedaDatosEnArchivo(vista.obtenerClaveProductoAgregado());
                //archivo.disminuirCantidadProducto(indiceProducto);
                String cadena=archivo.obtenerLineaArchivo(indiceProducto);
                Producto producto= new Producto(cadena);
                vista.agregarProductoTabla(producto);
                archivo.disminuirCantidadProducto(indiceProducto);
                venta.establecerSubtotal();
                venta.establecerIva();
                venta.establecerTotal();
                vista.establecerSubtotal(Double.toString(venta.obtenerSubtotal()));
                vista.establecerIVA(Double.toString(venta.obtenerIva()));
                vista.establecerTotal(Double.toString(venta.obtenerTotal()));
                vista.resetCajaAgregarProducto();
            }catch(ElementoNoEncontradoException excep4){
                vista.mostrarMensajeErrorProducto();
            }finally{
                vista.activarBotonAgregarProducto();
                vista.activarCajaAgregarProducto();
            }
        }

    }    
    
    
    
}
