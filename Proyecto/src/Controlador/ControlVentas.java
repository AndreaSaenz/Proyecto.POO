/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Usuario;
import Modelo.Venta;
import Vista.VistaControlAccionesEntidades;

/**
 *
 * @author andrea
 */
public class ControlVentas {
    private VistaControlAccionesEntidades vista;
    
    public ControlVentas(Usuario usuario){
      //  this.cliente= new Cliente(rfc, "","","");
        this.vista= new VistaControlAccionesEntidades();
        vista.tituloCabecera("Ventas");
        boolean alta =usuario.obtenerRol().obtenerModuloVenta().obtenerPermisoAlta();
        boolean baja =usuario.obtenerRol().obtenerModuloVenta().obtenerPermisoBaja();
        boolean edicion =usuario.obtenerRol().obtenerModuloVenta().obtenerPermisoEdicion();
        boolean consulta =usuario.obtenerRol().obtenerModuloVenta().obtenerPermisoConsulta();
        vista.establecerHabilitacionBotones(alta, baja, edicion, consulta);
    }
    
    
    
    
    
    
        }

    
    

}
