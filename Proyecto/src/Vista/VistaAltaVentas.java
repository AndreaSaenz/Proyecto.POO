/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;
/**
 *
 * @author limberth
 */
import Modelo.Producto;
import Modelo.Venta;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class VistaAltaVentas extends javax.swing.JFrame {
    //ControlAltaVenta control;
    
    ArrayList<Producto> productos;
    
    /**
     * Creates new form Ventas
     */
    public VistaAltaVentas(ArrayList<Producto> productos) {
        this.productos = productos;
       
        initComponents();
          this.jTable1.setModel(new ModeloTabla(productos));
        
        
        
    }
    //----------------------
    public void activarCajaAgregarProducto(){
        jTextField4.setEnabled(true);
    }
    
    public void desactivarCajaAgregarProducto(){
        jTextField4.setEnabled(false);
    }
    
    
   // --------------------------
    
    public void activarBotonAgregarProducto(){
        jButton2.setEnabled(true);
    }
    
    public void desactivarBotonAgregarProducto(){
        jButton2.setEnabled(false);
    }
    
    public void activarBotonEliminarProducto(){
        jButton5.setEnabled(true);
    }
    
    
    public void desactivarBotonElminarProducto(){
        jButton5.setEnabled(false);
    }
    
    //---------
     public void agregarListenerBotonAceptar(ActionListener evento){
        jButton1.addActionListener(evento);
    }
     
    public void agregarListenerBotonCancelar(ActionListener evento){
        jButton3.addActionListener(evento);
    }
   
    public void agregarListenerBotonAgregarProducto(ActionListener evento){
        jButton2.addActionListener(evento);
    }
   
    public void agregarListenerBotonEliminarProducto(ActionListener evento){
        jButton5.addActionListener(evento);
    }
   
   
    
     public void agregarListenerBotonAceptarMejorCaso(ActionListener evento){
        jButton4.addActionListener(evento);
    }
    
    public void agregarListenerBotonAceptarErrorCliente(ActionListener evento){
        jButton7.addActionListener(evento);
    }
    
    public void agregarListenerBotonAceptarErrorProducto(ActionListener evento){
        jButton9.addActionListener(evento);
    }
    
    public void agregarListenerBotonCancelarAltaCliente(ActionListener evento){
        jButton8.addActionListener(evento);
    }
   //--------------------------
    public String obtenerClaveProductoAgregado(){
        return jTextField4.getText();
    } 
    
   

    public String obtenerRFC(){
       return jTextField5.getText();
    } 
    
    public String obtenerId(){
       return jTextField9.getText();
    }
    
    public String obtenerFecha(){
        return jFormattedTextField1.getText();
    }
    //-------------------------
    public void establecerIdVenta(int numero){
        String contenido= "V-"+numero; 
        this.jTextField9.setText(contenido);
    }
    
    public void establecerRFC(String rfc){
        this.jTextField5.setText(rfc);
    }
    
    
    public void establecerRazonSocial(String contenido){
        this.jTextField6.setText(contenido);
    } 
    
    public void establecerDireccion(String contenido){
        this.jTextField7.setText(contenido);
    } 
    
    public void establecerTelefono(String contenido){
        this.jTextField8.setText(contenido);
    } 
    
    public void establecerSubtotal(String contenido){
        this.jTextField1.setText(contenido);
    } 
    
    public void establecerIVA(String contenido){
        this.jTextField2.setText(contenido);
    } 
    
    public void establecerTotal(String contenido){
        this.jTextField3.setText(contenido);
    } 
    
    
    
    public void establecerFecha(GregorianCalendar fecha){
        String contenido;
        contenido= fecha.get(Calendar.YEAR)+"/"+(fecha.get(Calendar.MONTH)+1)+"/"+fecha.get(Calendar.DAY_OF_MONTH);
        this.jFormattedTextField1.setText(contenido);
    }
    
    
      public void establecerFechaSinCambios(GregorianCalendar fecha){
        String contenido;
        contenido=fecha.get(Calendar.YEAR)+"/"+fecha.get(Calendar.MONTH)+"/"+fecha.get(Calendar.DAY_OF_MONTH);
        jFormattedTextField1.setText(contenido);
    }
    
    //---------------------
    public void resetCampos(){
        jTextField5.setText("");
    
        jTextField6.setText("");
    
        jTextField7.setText("");
   
        jTextField8.setText("");
    
        jTextField1.setText("");
    
        jTextField2.setText("");
    
        jTextField3.setText("");
        
        jFormattedTextField1.setText("");
    } 
    
    public void resetCajaAgregarProducto(){
        jTextField4.setText("");
    }
    
    
    
    //--------------------
    
    
    public void mostrarMensajeGuardado(){
        jDialog1.setVisible(true);
    }
    
    public void mostrarMensajeErrorCliente(){
        jDialog2.setVisible(true);
    }
    
        
    public void mostrarMensajeErrorProducto(){
        jDialog4.setVisible(true);
    }
    //--------------------
    public void ocultarMensajeGuardado(){
        jDialog1.setVisible(false);
    }
    
    public void ocultarMensajeErrorCliente(){
        jDialog2.setVisible(false);
    }

    public void ocultarMensajeErrorProducto(){
        jDialog4.setVisible(false);
    }
    
     public void ocultarMensajes(){
        jDialog1.setVisible(false);
   
        jDialog2.setVisible(false);
    
        jDialog4.setVisible(false);
    }

    
    
    //-----------------------
    
    public void cerrarMensajeGuardado(){
        jDialog1.dispose();
    }
    
     public void cerrarMensajeErrorCliente(){
        jDialog2.dispose();
    }

      public void cerrarMensajeErrorProducto(){
        jDialog4.dispose();
    }
      
     public void cerrarMensajes(){
        jDialog1.dispose();
        jDialog2.dispose();
        jDialog4.dispose();

     }
    
    //-------------------
    
   //* public void SetTabla(ArrayList<Venta> list){//aqui se agrega el nombre de la clase del modelo que se usará
    //    String Matriz[][]=new String[list.size()][1];
    //for (i=0;<list.size();i++){
        
    //}
   // }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jDialog2 = new javax.swing.JDialog();
        jPanel2 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jDialog4 = new javax.swing.JDialog();
        jPanel4 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        Fondo = new javax.swing.JLabel();

        jDialog1.setMinimumSize(new java.awt.Dimension(300, 200));
        jDialog1.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Venta guardada.");

        jButton4.setText("Aceptar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(jLabel11))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jButton4)))
                .addContainerGap(234, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addComponent(jButton4)
                .addContainerGap(196, Short.MAX_VALUE))
        );

        jDialog1.getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jDialog2.setMinimumSize(new java.awt.Dimension(300, 200));
        jDialog2.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Cliente no encontrado.");

        jButton7.setText("Dar de alta cliente");

        jButton8.setText("Cancelar");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jLabel13))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jButton7))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(jButton8)))
                .addContainerGap(253, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel13)
                .addGap(18, 18, 18)
                .addComponent(jButton7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton8)
                .addContainerGap(162, Short.MAX_VALUE))
        );

        jDialog2.getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jDialog4.setMinimumSize(new java.awt.Dimension(300, 200));
        jDialog4.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("Producto no encontrado.");

        jButton9.setText("Aceptar");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(jButton9))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(jLabel15)))
                .addContainerGap(241, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton9)
                .addContainerGap(196, Short.MAX_VALUE))
        );

        jDialog4.getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 800));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setText("RFC:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Datos del cliente:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 110, -1));

        jLabel6.setText("Razón social: ");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 60, -1, -1));

        jLabel7.setText("Dirección:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, -1, -1));

        jLabel8.setText("Teléfono:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 60, -1, -1));

        jTable1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTable1.setModel(new ModeloTabla(productos));
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 670, 460));

        jButton1.setText("Aceptar");
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 660, -1, -1));

        jLabel3.setText("Subtotal:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 610, -1, -1));

        jLabel2.setText("IVA\n");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 610, -1, -1));

        jLabel4.setText("Total");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 610, -1, -1));

        jTextField1.setEditable(false);
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 610, 160, -1));

        jTextField2.setEditable(false);
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 610, 160, -1));

        jTextField3.setEditable(false);
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 610, 180, -1));

        jButton2.setText("+");
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 213, 40, 40));

        jTextField4.setEnabled(false);
        getContentPane().add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 230, 80, -1));
        getContentPane().add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, 90, -1));

        jTextField6.setEditable(false);
        getContentPane().add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 60, 280, -1));

        jTextField7.setEditable(false);
        getContentPane().add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 100, 380, -1));

        jTextField8.setEditable(false);
        getContentPane().add(jTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 60, 170, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Alta Venta");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 20, -1, -1));

        jLabel10.setText("Id No.");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 30, -1, -1));

        jTextField9.setEditable(false);
        getContentPane().add(jTextField9, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 30, 70, -1));

        jButton3.setText("Cancelar\n");
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 660, -1, -1));

        jButton5.setText("-\n");
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 270, 40, -1));

        jLabel12.setText("Fecha:");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 30, -1, -1));

        jFormattedTextField1.setEditable(false);
        jFormattedTextField1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy/MM/d"))));
        getContentPane().add(jFormattedTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 30, 100, -1));

        jLabel14.setText("Para eliminar un producto:");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 420, 130, 40));

        jLabel16.setText("1. Selecciónelo con el cursor");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 450, -1, 40));

        jLabel17.setText("2. Click en el botón \"-\"");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 490, -1, -1));

        jLabel18.setText("Para agregar un producto:");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 330, 130, 40));

        jLabel19.setText("1. Escriba la clave en la caja");
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 360, -1, 40));

        jLabel20.setText("2. Click en el botón \"+\"");
        getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 400, -1, -1));

        Fondo.setBackground(new java.awt.Color(255, 255, 255));
        Fondo.setAutoscrolls(true);
        Fondo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Fondo.setMaximumSize(new java.awt.Dimension(1400, 1080));
        Fondo.setMinimumSize(new java.awt.Dimension(1400, 1080));
        Fondo.setPreferredSize(new java.awt.Dimension(1400, 1080));
        getContentPane().add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 1400, 750));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    
    public Producto eliminarProductoTabla() throws ArrayIndexOutOfBoundsException{
        ModeloTabla model = (ModeloTabla) this.jTable1.getModel();
        
        Producto producto = model.eliminarFila(jTable1.getSelectedRow());
        System.out.println("pRODUCTO ELIMINADO:");

        System.out.println(producto);
                System.out.println("ARREGLO PRODUCTOS:");

        System.out.println(productos);
        return producto;
    } 
    
    public void agregarProductoTabla(Producto producto){
         ModeloTabla model = (ModeloTabla) this.jTable1.getModel();
        
        model.agregarFila(producto);
    }
    
    public void resetearTablaProductos(){
         ModeloTabla model = (ModeloTabla) this.jTable1.getModel();
        
        model.resetearTabla();
    }
    
            
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VistaAltaVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaAltaVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaAltaVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaAltaVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ArrayList<Producto> productos=new ArrayList<Producto>();
                productos.add(new Producto("p-1", "queso",25.99,5));
                productos.add(new Producto("p-2", "queso",25.99,5));
                productos.add(new Producto("p-3", "queso",25.99,5));
                productos.add(new Producto("p-4", "queso",25.99,5));
                productos.add(new Producto("p-5", "queso",25.99,5));
                System.out.println(productos);
                Venta venta=new Venta(5);
                venta.establecerProductos(productos);
                
                
                Producto productoPeq=new Producto("p-6", "queso",25.99,5);
                productos.add(productoPeq);
                Producto productoGrande=new Producto("p-7", "queso",25.99,5);
                productoPeq=productoGrande;
                productos.add(productoPeq);
                ArrayList<Producto> productosAJ=new ArrayList<Producto>();
                productosAJ.add(new Producto("p-1", "manzana",25.99,5));
                productosAJ.add(new Producto("p-2", "manzana",25.99,5));
                productosAJ.add(new Producto("p-3", "manzana",25.99,5));
                productosAJ.add(new Producto("p-4", "manzana",25.99,5));
                productosAJ.add(new Producto("p-5", "manzana",25.99,5));
                venta.agregarProducto(productosAJ.get(0));
                venta.establecerProductos(productosAJ);
                Venta venta1=new Venta(5);
                venta.establecerProductos(productosAJ);
                venta=venta1;
                VistaAltaVentas vista= new VistaAltaVentas(venta.obtenerProductos());
                vista.setVisible(true);
                vista.mostrarMensajeGuardado();
                vista.mostrarMensajeErrorCliente();
               // productos.establecerProductos(productosAJ.productos);
                //vista.cerrarVentana();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Fondo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JDialog jDialog4;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables


    
}
