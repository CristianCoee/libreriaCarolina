/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularios;

import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import libreriacarolina.Conexion;

/**
 *
 * @author Gabbo09
 */
public class frmProveedor extends javax.swing.JInternalFrame {

    Connection conn;

    public frmProveedor() {
        Connection conn;
        Conexion BD = new Conexion();
        conn = BD.conexion();
        initComponents();

        try {

            DefaultTableModel modelo = new DefaultTableModel();
            JProductos.setModel(modelo);

            PreparedStatement ps = null;
            ResultSet rs = null;

            String sql = "SELECT * FROM Proveedores";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();

            modelo.addColumn("id_proveedor");
            modelo.addColumn("proveedor");
            modelo.addColumn("telefono");
            modelo.addColumn("correo");
            modelo.addColumn("direccion");

            while (rs.next()) {
                Object[] filas = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
                    filas[i] = rs.getObject(i + 1);
                }
                modelo.addRow(filas);
            }

        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }

    }

    void Limpiar() {
        txtcodproveedor.setText("");
        txtnomproveedor.setText("");
        txttlelefono.setText("");
        txtcorreo.setText("");
        txtdireccion.setText("");

    }
    
     public void keyTypedNum(KeyEvent ke) {
        char c = ke.getKeyChar();
        if (Character.isLetter(c)) {
            getToolkit().beep();
            ke.consume();
            lblmsj.setText("Ingresa Solo Numeros");

        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblcodproducto = new javax.swing.JLabel();
        lblcodcategoria = new javax.swing.JLabel();
        lblmsj = new javax.swing.JLabel();
        lblpreciocompra = new javax.swing.JLabel();
        lblprecioventa = new javax.swing.JLabel();
        txtcodproveedor = new javax.swing.JTextField();
        txttlelefono = new javax.swing.JTextField();
        txtcorreo = new javax.swing.JTextField();
        txtdireccion = new javax.swing.JTextField();
        txtnomproveedor = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        lblproveedor = new javax.swing.JLabel();
        lblnomproducto1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblbuscarproducto = new javax.swing.JLabel();
        txtbuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        JProductos = new javax.swing.JTable();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        txtNuevoEmpleado = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 204));
        setTitle("Proveedor");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblcodproducto.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblcodproducto.setText("Codigo Proveedor:");
        jPanel1.add(lblcodproducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        lblcodcategoria.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblcodcategoria.setText("Nombre Proveedor:");
        jPanel1.add(lblcodcategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        lblmsj.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jPanel1.add(lblmsj, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, -1, -1));

        lblpreciocompra.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblpreciocompra.setText("Correo:");
        jPanel1.add(lblpreciocompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, -1, -1));

        lblprecioventa.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblprecioventa.setText("Direccion:");
        jPanel1.add(lblprecioventa, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, -1, -1));

        txtcodproveedor.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jPanel1.add(txtcodproveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 220, -1));

        txttlelefono.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txttlelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txttlelefonoKeyTyped(evt);
            }
        });
        jPanel1.add(txttlelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, 200, -1));

        txtcorreo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel1.add(txtcorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 270, 280, -1));

        txtdireccion.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel1.add(txtdireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 320, 250, -1));

        txtnomproveedor.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtnomproveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnomproveedorActionPerformed(evt);
            }
        });
        jPanel1.add(txtnomproveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 220, -1));

        btnCancelar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cancel_stop_exit_1583.png"))); // NOI18N
        btnCancelar.setText("CANCELAR");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 380, 180, -1));

        btnGuardar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/_active__save.png"))); // NOI18N
        btnGuardar.setText("GUARDAR");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 172, 73));

        lblproveedor.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblproveedor.setText("Registro de Proveedor");
        jPanel1.add(lblproveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, -1, -1));

        lblnomproducto1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblnomproducto1.setText("Telefono:");
        jPanel1.add(lblnomproducto1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setForeground(new java.awt.Color(255, 255, 51));

        lblbuscarproducto.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblbuscarproducto.setText("Codigo Proveedor: ");

        btnBuscar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscar.png"))); // NOI18N
        btnBuscar.setText("BUSCAR");

        JProductos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 51)));
        JProductos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        JProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "CODIGOPROVEEDOR", "NOMBREPROVEEDOR", "TELEFONO", "CORREO", "DIRECCION"
            }
        ));
        JProductos.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                JProductosComponentAdded(evt);
            }
        });
        JProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JProductosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JProductos);

        btnModificar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/modificar.png"))); // NOI18N
        btnModificar.setText("MODIFICAR");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/trash_full_recycle_delete_delete_9751.png"))); // NOI18N
        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        txtNuevoEmpleado.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtNuevoEmpleado.setText("Buscar Proveedor");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 103, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(btnModificar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnEliminar)
                                .addGap(42, 42, 42))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(lblbuscarproducto)
                                .addGap(18, 18, 18)
                                .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(301, 301, 301))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(txtNuevoEmpleado)
                                .addGap(457, 457, 457))))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(txtNuevoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblbuscarproducto)
                    .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtnomproveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnomproveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnomproveedorActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        Limpiar();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        String codproducto, codproveedor, nomproveedor, telefono, correo, direccion;
        String sql = "";
        codproveedor = this.txtcodproveedor.getText();
        nomproveedor = this.txtnomproveedor.getText();
        telefono = this.txttlelefono.getText();
        correo = this.txtcorreo.getText();
        direccion = this.txtdireccion.getText();

        //Consulta para ingresar los datos en la base de datos...
        sql = "INSERT INTO Proveedores (id_proveedor, proveedor, telefono, correo, direccion) VALUES (?, ?, ?, ?, ?)";
        try {
            Conexion BD = new Conexion();
            conn = BD.conexion();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, codproveedor);
            pst.setString(2, nomproveedor);
            pst.setString(3, telefono);
            pst.setString(4, correo);
            pst.setString(5, direccion);

            int registro = pst.executeUpdate();
            //Si el registro se guarda correctamente executeUpdate aumenta a uno confirmando al usuario que si se guardaron los datos...
            if (registro > 0) {
                JOptionPane.showMessageDialog(null, "REGISTRO INGRESADO CON EXITO...");

                // Metodo para limpiar los campos despues de ser guardados...
                Limpiar();

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR!...");
            Logger.getLogger(frmProducto.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void JProductosComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_JProductosComponentAdded

        // TODO add your handling code here:
    }//GEN-LAST:event_JProductosComponentAdded

    private void JProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JProductosMouseClicked
        txtcodproveedor.setEditable(false);
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Conexion BD = new Conexion();
            conn = BD.conexion();

            int Fila = JProductos.getSelectedRow();
            String codigo = JProductos.getValueAt(Fila, 0).toString();

            ps = conn.prepareStatement("SELECT id_proveedor, proveedor, telefono, correo, direccion  FROM Proveedores  WHERE id_proveedores=?");
            ps.setString(1, codigo);
            rs = ps.executeQuery();

            while (rs.next()) {
                txtcodproveedor.setText(rs.getString("id_proveedor"));
                txtnomproveedor.setText(rs.getString("proveedor"));
                txttlelefono.setText(rs.getString("telefono"));
                txtcorreo.setText(rs.getString("correo"));
                txtdireccion.setText(rs.getString("direccion"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }//GEN-LAST:event_JProductosMouseClicked

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed

        int Fila = JProductos.getSelectedRow();
        PreparedStatement ps = null;
        try {
            Conexion BD = new Conexion();
            conn = BD.conexion();
            ps = conn.prepareStatement("UPDATE Proveedores SET proveedor=?, telefono=?, correo=?, direccion=?  WHERE id_proveedor=?");

            ps.setString(2, txtnomproveedor.getText());
            ps.setString(3, txttlelefono.getText());
            ps.setString(4, txtcorreo.getText());
            ps.setString(5, txtdireccion.getText());
            ps.setString(1, txtcodproveedor.getText());

            ps.execute();

            JOptionPane.showMessageDialog(null, "REGISTRO MODIFICADO CON EXITO...");
            JProductos.setValueAt(txtcodproveedor.getText(), Fila, 0);
            JProductos.setValueAt(txtnomproveedor.getText(), Fila, 1);
            JProductos.setValueAt(txttlelefono.getText(), Fila, 2);
            JProductos.setValueAt(txtcorreo.getText(), Fila, 3);
            JProductos.setValueAt(txtdireccion.getText(), Fila, 4);

            Limpiar();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL MODIFICAR REGISTRO...");
            System.out.println(ex);
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        PreparedStatement ps = null;
        DefaultTableModel modelo = new DefaultTableModel();

        try {

            Conexion BD = new Conexion();
            conn = BD.conexion();

            int Fila = JProductos.getSelectedRow();
            String codigo = JProductos.getValueAt(Fila, 0).toString();

            ps = conn.prepareStatement("DELETE FROM Productos WHERE id_producto=?");
            ps.setString(1, codigo);
            ps.execute();
            if (Fila > 0) {
                modelo.removeRow(Fila);
                JOptionPane.showMessageDialog(null, "PRODUCTO ELIMINADO...");
                Limpiar();
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR NO SE PUEDE ELIMINAR PRODUCTO...");
            System.out.println(ex.toString());
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txttlelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttlelefonoKeyTyped
        keyTypedNum(evt);
    }//GEN-LAST:event_txttlelefonoKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JProductos;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblbuscarproducto;
    private javax.swing.JLabel lblcodcategoria;
    private javax.swing.JLabel lblcodproducto;
    private javax.swing.JLabel lblmsj;
    private javax.swing.JLabel lblnomproducto1;
    private javax.swing.JLabel lblpreciocompra;
    private javax.swing.JLabel lblprecioventa;
    private javax.swing.JLabel lblproveedor;
    private javax.swing.JLabel txtNuevoEmpleado;
    private javax.swing.JTextField txtbuscar;
    private javax.swing.JTextField txtcodproveedor;
    private javax.swing.JTextField txtcorreo;
    private javax.swing.JTextField txtdireccion;
    private javax.swing.JTextField txtnomproveedor;
    private javax.swing.JTextField txttlelefono;
    // End of variables declaration//GEN-END:variables
}
