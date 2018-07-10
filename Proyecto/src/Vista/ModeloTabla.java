/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.Producto;
import java.util.ArrayList;
import java.util.List;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author 1047470
 */
public class ModeloTabla implements TableModel {
     List<Producto> productos;
    List<TableModelListener> suscriptors;
    
    int CONTADOR_COLUMNAS = 3;
    
    String CLAVE = "Clave",
            DESCRIPCION = "Producto",
            PRECIO = "Precio";
          
    
    
    final int CLAVE_C = 0,
            DESCRIPCION_C = 1,
            PRECIO_C = 2;
       

    public ModeloTabla(ArrayList<Producto> productos) {
        
        this.productos = productos;
        this.suscriptors = new ArrayList<>();
    }
    
    
    


    @Override
    public int getRowCount() {
    return productos.size();    }

    @Override
    public int getColumnCount() {
        return CONTADOR_COLUMNAS;
    }    

    @Override
    public String getColumnName(int i) {
        switch(i){
            case CLAVE_C:
                return CLAVE;
            case DESCRIPCION_C:
                return DESCRIPCION;
            case PRECIO_C:
                return PRECIO;
            default:
                return "";
        }    
    }

    @Override
    public Class<?> getColumnClass(int i) {
        switch(i){
            case CLAVE_C:
                return String.class;
            case DESCRIPCION_C:
                return String.class;
            case PRECIO_C:
                return Double.class;
            default:
                return String.class;
        }
    }

    @Override
    public boolean isCellEditable(int i, int i1) {
        return false;
    }

    @Override
    public Object getValueAt(int fila, int columna) {
         Producto producto = productos.get(fila);
            switch(columna){
            case CLAVE_C:
                return producto.obtenerClave();
            case DESCRIPCION_C:
                return producto.obtenerDescripcion();
            case PRECIO_C:
                return producto.obtenerPrecioUnitario();
            default:
                return "";
        }
    }

    @Override
    public void setValueAt(Object o, int fila, int columna) {
        Producto producto = (Producto) productos.get(fila);
        switch(columna){
            case CLAVE_C:
                producto.establecerClave((String) o);
                break;
            case DESCRIPCION_C:
                producto.establecerDescripcion((String) o);
                break;
            case PRECIO_C:
                producto.establecerPrecioUnitario(((Double) o));
                break;
            default:
                break;
        }
        TableModelEvent evt = new TableModelEvent(this, fila, fila, columna);
        notificarSuscriptores(evt);

    }

    @Override
    public void addTableModelListener(TableModelListener tl) {
        this.suscriptors.add(tl);


    }

    @Override
    public void removeTableModelListener(TableModelListener tl) {
         this.suscriptors.remove(tl);
         
    }
    
    private void notificarSuscriptores (TableModelEvent evt)
    {
        for (TableModelListener suscriptor : suscriptors) {
            suscriptor.tableChanged(evt);
        }
    }
    
    public Producto eliminarFila(int fila){
        Producto product = (Producto) productos.get(fila);
        System.out.println(product);
        productos.remove(product);
        TableModelEvent evt = new TableModelEvent(this, fila, fila, 
        TableModelEvent.ALL_COLUMNS, TableModelEvent.DELETE);
        notificarSuscriptores(evt);
        return product;
    }
    
    public void agregarFila (Producto producto) { 
    // Añade la persona al modelo 
        productos.add (producto); 

    // Avisa a los suscriptores creando un TableModelEvent... 
        TableModelEvent evt=new TableModelEvent (this, this.getRowCount()+1, this.getRowCount()+1, 
        TableModelEvent.ALL_COLUMNS, TableModelEvent.INSERT); 

    // ... y avisando a los suscriptores
    
        notificarSuscriptores(evt);
        //return producto;
    }
    
    public void resetearTabla () { 
    // Añade la persona al modelo 
        productos.removeAll(productos);

    // Avisa a los suscriptores creando un TableModelEvent... 
        TableModelEvent evt=new TableModelEvent (this, this.getRowCount()+1, this.getRowCount()+1, 
        TableModelEvent.ALL_COLUMNS, TableModelEvent.INSERT); 

    // ... y avisando a los suscriptores
    
        notificarSuscriptores(evt);
        //return producto;
    }   
}
