/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

/**
 *
 * @author limberth
 */
public class VistaAltaCliente extends javax.swing.JFrame {

    /**
     * Creates new form VistaLogin
     */
    public VistaAltaCliente() {
        initComponents();
        this.ocultarErrorRepeticion();
        this.setLocationRelativeTo(null);
    }
    
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage("Imagenes/github-256-black.png");
        return retValue;
    }
 
    //----------------
    public void agregarListenerBotonCancelar(ActionListener evento){
        jButton1.addActionListener(evento);
    }
   
    public void agregarListenerBotonRegistrar(ActionListener evento){
        jButton2.addActionListener(evento);
    }
    
    public void agregarListenerBotonAceptarMejorCaso(ActionListener evento){
        jButton4.addActionListener(evento);
    }
    
   //-----------------
   
    public String obtenerDireccion(){
        return Dir.getText();
    } 
    
     
    public String obtenerRazon(){
        return Razon.getText();
    }
    
    public String obtenerTel(){
        return Tel.getText();
    }
    
    public String obtenerRFC(){
       return RFC.getText();
    }  
    
   
    
    //--------------------
    
   
    
    public void establecerRFC(int numero){
        String contenido= "C-" + numero;
        this.RFC.setText(contenido);
    }
    
    
    //------------------------
    public void ocultarErrorRepeticion(){
        jLabel8.setVisible(false);
        jLabel2.setVisible(false);
    }
     
    public void mostrarErrorRepeticion(){
        jLabel8.setVisible(true);
        jLabel2.setVisible(true);

    }
    
    //---------------
    
    public void mostrarMensajeGuardado(){
        jDialog1.setVisible(true);
    }
    
     public void ocultarMensajeGuardado(){
        jDialog1.setVisible(false);
     }
        
     public void cerrarMensajeGuardado(){
        jDialog1.dispose();
    }
   
    
    
    //-------------
    
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
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        Título = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Razon = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        RFC = new javax.swing.JTextField();
        Dir = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Tel = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        Fondo = new javax.swing.JLabel();

        jDialog1.setAlwaysOnTop(true);
        jDialog1.setMinimumSize(new java.awt.Dimension(300, 200));
        jDialog1.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Cliente guardado.");

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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setForeground(new java.awt.Color(255, 0, 0));
        jLabel8.setText("*");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 210, 20, 20));

        jButton1.setBackground(new java.awt.Color(0, 204, 204));
        jButton1.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jButton1.setText("Cancelar");
        jButton1.setAlignmentY(0.0F);
        jButton1.setBorder(null);
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 440, 90, 20));

        jButton2.setBackground(new java.awt.Color(0, 204, 204));
        jButton2.setText("Registrar");
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 440, -1, 20));

        Título.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Título.setText("Alta Cliente");
        getContentPane().add(Título, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, -1, -1));

        jLabel4.setText("Razón social:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, -1, -1));
        getContentPane().add(Razon, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, 200, -1));

        jLabel5.setText("RFC:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, -1, -1));

        RFC.setEditable(false);
        getContentPane().add(RFC, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 200, -1));
        getContentPane().add(Dir, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 250, 200, -1));

        jLabel6.setText("Dirección:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 250, -1, -1));

        jLabel7.setText("Telefono:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 290, -1, -1));
        getContentPane().add(Tel, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 290, 200, -1));

        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("*Razón social no disponible. Introduzca otra.");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 330, -1, -1));

        Fondo.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(VistaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaAltaCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Dir;
    private javax.swing.JLabel Fondo;
    private javax.swing.JTextField RFC;
    private javax.swing.JTextField Razon;
    private javax.swing.JTextField Tel;
    private javax.swing.JLabel Título;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    
    
    
}