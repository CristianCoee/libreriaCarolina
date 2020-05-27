/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import libreriacarolina.Conexion;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author Jesús
 */
public class frmPedido extends javax.swing.JInternalFrame {
    Connection conn ;
    DefaultTableModel model;
    int id_provee, id_tipoPago, id_producto;
    
    /**
     * Creates new form frmPedido
     */
    public frmPedido() {
        initComponents();
        AutoCompleteDecorator.decorate(cmbProducto);
        try {
              Class.forName("org.gjt.mm.mysql.Driver") ;
              conn = DriverManager.getConnection("jdbc:mysql://localhost/libreria","root","") ;
              //System.out.println("Conexion en PEDIDO");
        }
        catch(Exception e) {
        }
        cbxTpago();
        cbxProvee();
        cbxProducto();
    }
    
    public void cbxTpago(){
        String sql="SELECT tipoPago FROM tipopago";// WHERE tipoPago <> 'Seleccione cargo'" ;
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            Object Datos[]= new Object[1]; 
            while (rs.next()){
                for (int i=0;i<1;i++){
                    Datos[i]=(rs.getObject(i+1));
                    this.cmbTpago.addItem(String.valueOf(Datos[i]));    
                }
            }
            } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error: "+e.toString(), " ¡¡ ERROR !!", JOptionPane.ERROR_MESSAGE);     
        }
    }
    
    public void cbxProvee(){
        String sql="SELECT proveedor FROM proveedores";// WHERE proveedor <> 'Seleccione cargo'";
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            Object Datos[]= new Object[1];
            while (rs.next()){
                for (int i=0;i<1;i++){
                    Datos[i]=(rs.getObject(i+1));
                    this.cmbProve.addItem(String.valueOf(Datos[i]));  
                }
            }
            } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error: "+e.toString(), " ¡¡ ERROR !!", JOptionPane.ERROR_MESSAGE);     
        }
    }
    
        public void cbxProducto(){
        String sql="SELECT producto FROM productos";// WHERE proveedor <> 'Seleccione cargo'";
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            Object Datos[]= new Object[1];
            while (rs.next()){
                for (int i=0;i<1;i++){
                    Datos[i]=(rs.getObject(i+1));
                    this.cmbProducto.addItem(String.valueOf(Datos[i]));  
                }
            }
            } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error: "+e.toString(), " ¡¡ ERROR !!", JOptionPane.ERROR_MESSAGE);     
        }
    }
    
    public void idTpago(){
        String sql = "";    
        try {
            sql = "SELECT id_tipoPago FROM tipoPago WHERE tipoPago ='"+cmbTpago.getSelectedItem()+"'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next()) {
                id_tipoPago = rs.getInt("id_tipoPago");
            } else {
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error", "¡¡ ERROR !!", JOptionPane.ERROR_MESSAGE);
            }
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error: "+e.toString(), " ¡¡ ERROR !!", JOptionPane.ERROR_MESSAGE);
        }  
    }
    
    public void idProvee(){
        String sql = "";    
        try {
            sql = "SELECT id_proveedor FROM proveedores WHERE proveedor ='"+cmbProve.getSelectedItem()+"'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql) ;
             if(rs.next()) {
                 id_provee = rs.getInt("id_proveedor");
            } else {
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error", "¡¡ ERROR !!", JOptionPane.ERROR_MESSAGE);
            }
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error: "+e.toString(), " ¡¡ ERROR !!", JOptionPane.ERROR_MESSAGE);
        }  
    }
    
    public void idProducto(){
        String sql = "";    
        try {
            sql = "SELECT id_producto FROM productos WHERE producto ='"+cmbProducto.getSelectedItem()+"'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next()) {
                id_producto = rs.getInt("id_producto");
            } else {
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error", "¡¡ ERROR !!", JOptionPane.ERROR_MESSAGE);
            }
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error: "+e.toString(), " ¡¡ ERROR !!", JOptionPane.ERROR_MESSAGE);
        }  
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
        lblExist = new javax.swing.JLabel();
        txtExist = new javax.swing.JTextField();
        btnExist = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblExist = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        lblCodigo = new javax.swing.JLabel();
        lblCant = new javax.swing.JLabel();
        txtCant = new javax.swing.JTextField();
        lblDate = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        lblProve = new javax.swing.JLabel();
        cmbProve = new javax.swing.JComboBox<>();
        btnPedido = new javax.swing.JButton();
        lblCod = new javax.swing.JLabel();
        txtCod = new javax.swing.JTextField();
        lblTpago = new javax.swing.JLabel();
        cmbTpago = new javax.swing.JComboBox<>();
        txtYear = new javax.swing.JTextField();
        txtDia = new javax.swing.JTextField();
        txtMes = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmbProducto = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPedido = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jComboBox2 = new javax.swing.JComboBox<>();

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        lblExist.setText("Mostrar las existencias de productos menores a: ");

        btnExist.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/_active__search.png"))); // NOI18N
        btnExist.setText("Verificar");
        btnExist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExistActionPerformed(evt);
            }
        });

        tblExist.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Nombre", "Existencias", "Precio de Compra", "Precio de Venta", "Num. LOTE"
            }
        ));
        jScrollPane1.setViewportView(tblExist);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 597, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(80, Short.MAX_VALUE)
                .addComponent(lblExist)
                .addGap(18, 18, 18)
                .addComponent(txtExist, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(btnExist)
                .addGap(63, 63, 63))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExist)
                    .addComponent(txtExist)
                    .addComponent(lblExist))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        lblCodigo.setText("Nombre: ");

        lblCant.setText("Cantidad: ");

        lblDate.setText("Fecha:");

        jLabel6.setText("Precio x U: ");

        lblProve.setText("Proveedor: ");

        btnPedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/_active__save.png"))); // NOI18N
        btnPedido.setText("Registrar pedido");
        btnPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPedidoActionPerformed(evt);
            }
        });

        lblCod.setText("Num. Pedido: ");

        lblTpago.setText("Seleccione el tipo de pago: ");

        jLabel1.setText("/");

        jLabel2.setText("/");

        cmbProducto.setEditable(true);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblDate)
                            .addComponent(lblCod)
                            .addComponent(lblTpago)
                            .addComponent(lblCodigo)
                            .addComponent(lblCant)
                            .addComponent(jLabel6)
                            .addComponent(lblProve))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPrecio)
                            .addComponent(txtCod)
                            .addComponent(txtCant)
                            .addComponent(cmbProve, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbTpago, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addComponent(txtDia, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMes, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtYear, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(cmbProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnPedido)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTpago)
                    .addComponent(cmbTpago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCod)
                    .addComponent(txtCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigo)
                    .addComponent(cmbProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCant)
                    .addComponent(txtCant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProve)
                    .addComponent(cmbProve, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDate)
                    .addComponent(txtYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPedido)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        tblPedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Num. Pedido", "Nombre", "Cantidad", "Precio", "Tipo de pago", "Proveedor", "Fecha de pedido"
            }
        ));
        jScrollPane2.setViewportView(tblPedido);

        jPanel3.setBackground(new java.awt.Color(200, 200, 200));

        jButton6.setText("jButton6");

        jButton5.setText("jButton5");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton6)
                    .addComponent(jButton5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton5)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton3.setText("jButton3");

        jButton4.setText("jButton4");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(214, 214, 214)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton3)
                                .addGap(18, 18, 18)
                                .addComponent(jButton4)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 681, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton3)
                                    .addComponent(jButton4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExistActionPerformed
        // TODO add your handling code here:
        String data = txtExist.getText();
        String sql ="";    
        try {
            sql="SELECT id_producto, producto, existencia, precio_venta, precio_compra, num_lote FROM productos WHERE existencia <= '"+data+"'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql) ;
            model = (DefaultTableModel) this.tblExist.getModel();
            model.setRowCount(0);
            Object Datos[]= new Object[6];
                while (rs.next()){
                    for (int i=0;i<6;i++) Datos[i]=rs.getObject(i+1);
                        model.addRow(Datos);
                }
                this.tblExist.setModel(model);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error: "+e.toString(), " ¡¡ ERROR !!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnExistActionPerformed

    private void btnPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPedidoActionPerformed
        // TODO add your handling code here:
        String codpedido, codproducto, cantidad, precio, tipoPago, proveedor, date, dia, mes, year;
        String sqlCP, sqlP = "";
        double total = 0;
        codpedido = this.txtCod.getText();
        cantidad = this.txtCant.getText();
        precio = this.txtPrecio.getText();
        dia = this.txtDia.getText();
        mes = this.txtMes.getText();
        year = this.txtYear.getText();
        idTpago();
        idProvee();
        idProducto();
        tipoPago = Integer.toString(id_tipoPago);
        proveedor = Integer.toString(id_provee);
        codproducto = Integer.toString(id_producto);
        date = year+"-"+mes+"-"+dia;
        double subtotal = 0;
        subtotal = Integer.parseInt(cantidad) * Double.parseDouble(precio); 
        //System.out.println(date);
        //System.out.println(tipoPago);
        //System.out.println(proveedor);
        //System.out.println(codproducto);
        //System.out.println(subtotal);
        try {
            sqlCP = "INSERT INTO compras (cantidad, fecha_compra, id_compra, id_producto, id_tipoPago, precio_uni) VALUES (?, ?, ?, ?, ?, ?)";
            Conexion BD = new Conexion();
            conn = BD.conexion();
            PreparedStatement pst = conn.prepareStatement(sqlCP);
            pst.setString(1, cantidad);
            pst.setString(2, date);
            pst.setString(3, codpedido);
            pst.setString(4, codproducto);
            pst.setString(5, tipoPago);
            pst.setString(6, precio);
            int registro = pst.executeUpdate();
            if (registro > 0) {
                /*if (total==0){
                    total += subtotal;
                } else {
                    total=0;
                }*/  
                try {
                    sqlP = "INSERT INTO compra_proveedor (id_compra, id_proveedor, total) VALUES (?, ?, ?)";
                    //Conexion BD = new Conexion();
                    conn = BD.conexion();
                    PreparedStatement pst2 = conn.prepareStatement(sqlP);
                    pst2.setString(1, codpedido);
                    pst2.setString(2, proveedor);
                    pst2.setString(3, String.valueOf(subtotal));
                    int registro2 = pst2.executeUpdate();
                    if (registro2 > 0) {
                        JOptionPane.showMessageDialog(null, "El pedido ha sido registrado", " Sistema Libreria Carolina", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Ha ocurrido un error: "+ex.toString(), " ¡¡ ERROR !!", JOptionPane.ERROR_MESSAGE);
                    Logger.getLogger(frmProducto.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("El pedido ha sido registrado");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error: "+ex.toString(), " ¡¡ ERROR !!", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(frmProducto.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }//GEN-LAST:event_btnPedidoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExist;
    private javax.swing.JButton btnPedido;
    private javax.swing.JComboBox<String> cmbProducto;
    private javax.swing.JComboBox<String> cmbProve;
    private javax.swing.JComboBox<String> cmbTpago;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblCant;
    private javax.swing.JLabel lblCod;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblExist;
    private javax.swing.JLabel lblProve;
    private javax.swing.JLabel lblTpago;
    private javax.swing.JTable tblExist;
    private javax.swing.JTable tblPedido;
    private javax.swing.JTextField txtCant;
    private javax.swing.JTextField txtCod;
    private javax.swing.JTextField txtDia;
    private javax.swing.JTextField txtExist;
    private javax.swing.JTextField txtMes;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtYear;
    // End of variables declaration//GEN-END:variables
}
