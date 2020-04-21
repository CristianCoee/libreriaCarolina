/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularios;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import libreriacarolina.Conexion;

/**
 *
 * @author Gabbo09
 */
public class frmProducto extends javax.swing.JInternalFrame {

    Connection conn;

    public frmProducto() {
        Conexion BD = new Conexion();
        conn = BD.conexion();

        initComponents();

        try {

            DefaultTableModel modelo = new DefaultTableModel();
            JProductos.setModel(modelo);

            PreparedStatement ps = null;
            ResultSet rs = null;

            String sql = "SELECT * FROM Productos";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();

            modelo.addColumn("id_producto");
            modelo.addColumn("id_categoria");
            modelo.addColumn("producto");
            modelo.addColumn("precio_compra");
            modelo.addColumn("precio_venta");
            modelo.addColumn("exitencia");
            modelo.addColumn("num_lote");

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
        txtcodproducto.setText("");
        txtcodcategoria.setText("");
        txtnomproducto.setText("");
        txtpreciocompra.setText("");
        txtprecioventa.setText("");
        txtstock.setText("");
        txtnumlote.setText("");
    }

    public void keyTyped(KeyEvent ke) {
        char c = ke.getKeyChar();
        if (Character.isDigit(c)) {
            getToolkit().beep();
            ke.consume();
            lblmsj.setText("Ingresar solo letras");
        }
    }

    public void keyTypedNum(KeyEvent ke) {
        char c = ke.getKeyChar();
        if (Character.isLetter(c)) {
            getToolkit().beep();
            ke.consume();
            lblmsj3.setText("Ingresa Solo Numeros");

        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblcodproducto = new javax.swing.JLabel();
        lblcodcategoria = new javax.swing.JLabel();
        lblmsj = new javax.swing.JLabel();
        lblmsj4 = new javax.swing.JLabel();
        lblnumlote = new javax.swing.JLabel();
        txtcodproducto = new javax.swing.JTextField();
        txtnomproducto = new javax.swing.JTextField();
        txtpreciocompra = new javax.swing.JTextField();
        txtprecioventa = new javax.swing.JTextField();
        txtcodcategoria = new javax.swing.JTextField();
        txtnumlote = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        txtNuevoEmpleado1 = new javax.swing.JLabel();
        txtstock = new javax.swing.JTextField();
        lblstock = new javax.swing.JLabel();
        lblFechNacimiento = new javax.swing.JLabel();
        lblFechNacimiento2 = new javax.swing.JLabel();
        lblFechNacimiento3 = new javax.swing.JLabel();
        lblnomproducto1 = new javax.swing.JLabel();
        lblprecioventa1 = new javax.swing.JLabel();
        lblmsj3 = new javax.swing.JLabel();
        lblpreciocompra1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblbuscarproducto = new javax.swing.JLabel();
        txtbuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        JProductos = new javax.swing.JTable();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        txtNuevoEmpleado = new javax.swing.JLabel();

        setTitle("Producto");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblcodproducto.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblcodproducto.setText("Codigo Producto:");
        jPanel1.add(lblcodproducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        lblcodcategoria.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblcodcategoria.setText("Codigo Categoria:");
        jPanel1.add(lblcodcategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        lblmsj.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jPanel1.add(lblmsj, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 200, -1, -1));

        lblmsj4.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jPanel1.add(lblmsj4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 290, -1, -1));

        lblnumlote.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblnumlote.setText("Numero de Lote:");
        jPanel1.add(lblnumlote, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, -1, -1));

        txtcodproducto.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jPanel1.add(txtcodproducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 250, -1));

        txtnomproducto.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtnomproducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnomproductoActionPerformed(evt);
            }
        });
        txtnomproducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnomproductoKeyTyped(evt);
            }
        });
        jPanel1.add(txtnomproducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, 240, -1));

        txtpreciocompra.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtpreciocompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpreciocompraActionPerformed(evt);
            }
        });
        txtpreciocompra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtpreciocompraKeyTyped(evt);
            }
        });
        jPanel1.add(txtpreciocompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 220, 120, -1));

        txtprecioventa.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtprecioventa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtprecioventaActionPerformed(evt);
            }
        });
        jPanel1.add(txtprecioventa, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 270, 130, -1));

        txtcodcategoria.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtcodcategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcodcategoriaActionPerformed(evt);
            }
        });
        jPanel1.add(txtcodcategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 240, -1));

        txtnumlote.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel1.add(txtnumlote, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 360, 120, -1));

        btnCancelar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cancel_stop_exit_1583.png"))); // NOI18N
        btnCancelar.setText("CANCELAR");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 400, -1, -1));

        btnGuardar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/_active__save.png"))); // NOI18N
        btnGuardar.setText("GUARDAR");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, 172, 73));

        txtNuevoEmpleado1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtNuevoEmpleado1.setText("Registro de Producto");
        jPanel1.add(txtNuevoEmpleado1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, -1, -1));

        txtstock.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel1.add(txtstock, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 320, 140, -1));

        lblstock.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblstock.setText("Stock:");
        jPanel1.add(lblstock, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, -1, -1));

        lblFechNacimiento.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblFechNacimiento.setText("N°");
        jPanel1.add(lblFechNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 360, 20, -1));

        lblFechNacimiento2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblFechNacimiento2.setText("$");
        jPanel1.add(lblFechNacimiento2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 270, 10, -1));

        lblFechNacimiento3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblFechNacimiento3.setText("$");
        jPanel1.add(lblFechNacimiento3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, 10, -1));

        lblnomproducto1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblnomproducto1.setText("Nombre Producto:");
        jPanel1.add(lblnomproducto1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        lblprecioventa1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblprecioventa1.setText("Precio de Venta:");
        jPanel1.add(lblprecioventa1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, -1, -1));

        lblmsj3.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jPanel1.add(lblmsj3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 250, -1, -1));

        lblpreciocompra1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblpreciocompra1.setText("Precio de Compra:");
        jPanel1.add(lblpreciocompra1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 51)));
        jPanel2.setForeground(new java.awt.Color(255, 255, 51));

        lblbuscarproducto.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblbuscarproducto.setText("Codigo Producto: ");

        btnBuscar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscar.png"))); // NOI18N
        btnBuscar.setText("BUSCAR");

        JProductos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 51)));
        JProductos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        JProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "CODIGOPRODUCTO", "CODIGOCATEGORIA", "NOMBREPRODUCTO", "PRECIOCOMPRA", "PRECIOVENTA", "EXISTENCIA", "NUMEROLOTE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, true, true, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
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
        txtNuevoEmpleado.setText("Buscar Producto");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(202, 202, 202)
                .addComponent(lblbuscarproducto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(186, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(btnModificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEliminar)
                        .addGap(42, 42, 42))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(txtNuevoEmpleado)
                        .addGap(427, 427, 427))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(txtNuevoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE))
                .addGap(96, 96, 96))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        String codproducto, codcategoria, nomproducto, precio_compra, precio_venta, stock, num_lote;
        String sql = "";
        codproducto = this.txtcodproducto.getText();
        codcategoria = this.txtcodcategoria.getText();
        nomproducto = this.txtnomproducto.getText();
        precio_compra = this.txtpreciocompra.getText();
        precio_venta = this.txtprecioventa.getText();
        stock = this.txtstock.getText();
        num_lote = this.txtnumlote.getText();
        //Consulta para ingresar los datos en la base de datos...
        sql = "INSERT INTO Productos (id_producto, id_categoria, producto, precio_compra, precio_venta, existencia, num_lote) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            Conexion BD = new Conexion();
            conn = BD.conexion();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, codproducto);
            pst.setString(2, codcategoria);
            pst.setString(3, nomproducto);
            pst.setString(4, precio_compra);
            pst.setString(5, precio_venta);
            pst.setString(6, stock);
            pst.setString(7, num_lote);
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

    private void txtcodcategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcodcategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcodcategoriaActionPerformed

    private void JProductosComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_JProductosComponentAdded

        // TODO add your handling code here:
    }//GEN-LAST:event_JProductosComponentAdded

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        Limpiar();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed

        int Fila = JProductos.getSelectedRow();
        PreparedStatement ps = null;
        try {
            Conexion BD = new Conexion();
            conn = BD.conexion();
            ps = conn.prepareStatement("UPDATE Productos SET producto=?, id_categoria=?, precio_compra=?, precio_venta=?, existencia=?, num_lote=? WHERE id_producto=?");

            ps.setString(2, txtcodcategoria.getText());
            ps.setString(3, txtnomproducto.getText());
            ps.setString(4, txtpreciocompra.getText());
            ps.setString(5, txtprecioventa.getText());
            ps.setString(6, txtstock.getText());
            ps.setString(7, txtnumlote.getText());
            ps.setString(1, txtcodproducto.getText());

            ps.execute();

            JOptionPane.showMessageDialog(null, "PRODUCTO MODIFICADO CON EXITO...");
            JProductos.setValueAt(txtcodproducto.getText(), Fila, 0);
            JProductos.setValueAt(txtcodcategoria.getText(), Fila, 1);
            JProductos.setValueAt(txtnomproducto.getText(), Fila, 2);
            JProductos.setValueAt(txtpreciocompra.getText(), Fila, 3);
            JProductos.setValueAt(txtprecioventa.getText(), Fila, 4);
            JProductos.setValueAt(txtstock.getText(), Fila, 5);
            JProductos.setValueAt(txtnumlote.getText(), Fila, 6);

            Limpiar();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL MODIFICAR PRODUCTO...");
            System.out.println(ex);
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void JProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JProductosMouseClicked
        txtcodproducto.setEditable(false);
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Conexion BD = new Conexion();
            conn = BD.conexion();

            int Fila = JProductos.getSelectedRow();
            String codigo = JProductos.getValueAt(Fila, 0).toString();

            ps = conn.prepareStatement("SELECT id_producto, id_categoria, producto, precio_compra, precio_venta, existencia, num_lote FROM Productos  WHERE id_producto=?");
            ps.setString(1, codigo);
            rs = ps.executeQuery();

            while (rs.next()) {
                txtcodproducto.setText(rs.getString("id_producto"));
                txtcodcategoria.setText(rs.getString("id_categoria"));
                txtnomproducto.setText(rs.getString("producto"));
                txtpreciocompra.setText(rs.getString("precio_compra"));
                txtprecioventa.setText(rs.getString("precio_venta"));
                txtstock.setText(rs.getString("existencia"));
                txtnumlote.setText(rs.getString("num_lote"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }//GEN-LAST:event_JProductosMouseClicked

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

            modelo.removeRow(Fila);
            JOptionPane.showMessageDialog(null, "PRODUCTO ELIMINADO...");
            Limpiar();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR NO SE PUEDE ELIMINAR PRODUCTO...");
            System.out.println(ex.toString());
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtpreciocompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpreciocompraActionPerformed
 
    }//GEN-LAST:event_txtpreciocompraActionPerformed

    private void txtprecioventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtprecioventaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtprecioventaActionPerformed

    private void txtnomproductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnomproductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnomproductoActionPerformed

    private void txtnomproductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnomproductoKeyTyped
        keyTyped(evt);
    }//GEN-LAST:event_txtnomproductoKeyTyped

    private void txtpreciocompraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpreciocompraKeyTyped
        
    }//GEN-LAST:event_txtpreciocompraKeyTyped


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
    private javax.swing.JLabel lblFechNacimiento;
    private javax.swing.JLabel lblFechNacimiento2;
    private javax.swing.JLabel lblFechNacimiento3;
    private javax.swing.JLabel lblbuscarproducto;
    private javax.swing.JLabel lblcodcategoria;
    private javax.swing.JLabel lblcodproducto;
    private javax.swing.JLabel lblmsj;
    private javax.swing.JLabel lblmsj3;
    private javax.swing.JLabel lblmsj4;
    private javax.swing.JLabel lblnomproducto1;
    private javax.swing.JLabel lblnumlote;
    private javax.swing.JLabel lblpreciocompra1;
    private javax.swing.JLabel lblprecioventa1;
    private javax.swing.JLabel lblstock;
    private javax.swing.JLabel txtNuevoEmpleado;
    private javax.swing.JLabel txtNuevoEmpleado1;
    private javax.swing.JTextField txtbuscar;
    private javax.swing.JTextField txtcodcategoria;
    private javax.swing.JTextField txtcodproducto;
    private javax.swing.JTextField txtnomproducto;
    private javax.swing.JTextField txtnumlote;
    private javax.swing.JTextField txtpreciocompra;
    private javax.swing.JTextField txtprecioventa;
    private javax.swing.JTextField txtstock;
    // End of variables declaration//GEN-END:variables
}
