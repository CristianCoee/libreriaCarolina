/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularios;

/**
 *
 * @author Gabbo09
 */
public class frmProducto extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmProducto
     */
    public frmProducto() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblcodproducto = new javax.swing.JLabel();
        txtcodproducto = new javax.swing.JTextField();
        lblcodcategoria = new javax.swing.JLabel();
        txtstock = new javax.swing.JTextField();
        lblnomproducto = new javax.swing.JLabel();
        txtnomproducto = new javax.swing.JTextField();
        lblprecioventa = new javax.swing.JLabel();
        txtpreciocompra = new javax.swing.JTextField();
        lblcodproducto2 = new javax.swing.JLabel();
        lblpreciocompra = new javax.swing.JLabel();
        txtcodcategoria1 = new javax.swing.JTextField();
        lblcodproducto3 = new javax.swing.JLabel();
        lblstock = new javax.swing.JLabel();
        txtprecioventa1 = new javax.swing.JTextField();
        lblstock1 = new javax.swing.JLabel();
        txtstock1 = new javax.swing.JTextField();
        lblcodproducto4 = new javax.swing.JLabel();
        lblcodproducto5 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("REGISTRO DEL PRODUCTO");

        lblcodproducto.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblcodproducto.setText("Codigo Producto:");

        lblcodcategoria.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblcodcategoria.setText("Codigo Categoria:");

        lblnomproducto.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblnomproducto.setText("Nombre Producto:");

        lblprecioventa.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblprecioventa.setText("Precio Venta:");

        txtpreciocompra.setText("0.00");
        txtpreciocompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpreciocompraActionPerformed(evt);
            }
        });

        lblcodproducto2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblcodproducto2.setText("$");

        lblpreciocompra.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblpreciocompra.setText("Precio Compra:");

        lblcodproducto3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblcodproducto3.setText("$");

        lblstock.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblstock.setText("Stock:");

        txtprecioventa1.setText("0.00");

        lblstock1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblstock1.setText("Numero Lote:");

        lblcodproducto4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblcodproducto4.setText("N°");

        lblcodproducto5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblcodproducto5.setText("N°");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblcodproducto)
                    .addComponent(lblpreciocompra))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblcodproducto2, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtpreciocompra, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtcodproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblcodcategoria)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblnomproducto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtnomproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblprecioventa)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(lblcodproducto5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtstock1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblcodproducto3, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtprecioventa1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(107, 107, 107)
                                .addComponent(lblstock)
                                .addGap(8, 8, 8)
                                .addComponent(lblcodproducto4)
                                .addGap(11, 11, 11)
                                .addComponent(txtstock, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(87, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(402, 402, 402)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(378, 378, 378)
                        .addComponent(lblstock1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(477, Short.MAX_VALUE)
                    .addComponent(txtcodcategoria1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(383, 383, 383)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblcodproducto)
                    .addComponent(txtcodproducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblcodcategoria)
                    .addComponent(lblnomproducto)
                    .addComponent(txtnomproducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblprecioventa)
                            .addComponent(txtstock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblcodproducto3)
                            .addComponent(lblstock)
                            .addComponent(txtprecioventa1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblcodproducto4)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblcodproducto2)
                            .addComponent(txtpreciocompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblpreciocompra))))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblstock1)
                    .addComponent(txtstock1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblcodproducto5))
                .addContainerGap(132, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(59, 59, 59)
                    .addComponent(txtcodcategoria1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(251, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(298, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtpreciocompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpreciocompraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpreciocompraActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblcodcategoria;
    private javax.swing.JLabel lblcodproducto;
    private javax.swing.JLabel lblcodproducto2;
    private javax.swing.JLabel lblcodproducto3;
    private javax.swing.JLabel lblcodproducto4;
    private javax.swing.JLabel lblcodproducto5;
    private javax.swing.JLabel lblnomproducto;
    private javax.swing.JLabel lblpreciocompra;
    private javax.swing.JLabel lblprecioventa;
    private javax.swing.JLabel lblstock;
    private javax.swing.JLabel lblstock1;
    private javax.swing.JTextField txtcodcategoria1;
    private javax.swing.JTextField txtcodproducto;
    private javax.swing.JTextField txtnomproducto;
    private javax.swing.JTextField txtpreciocompra;
    private javax.swing.JTextField txtprecioventa1;
    private javax.swing.JTextField txtstock;
    private javax.swing.JTextField txtstock1;
    // End of variables declaration//GEN-END:variables
}