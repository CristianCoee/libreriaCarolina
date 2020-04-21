/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularios;

import java.awt.event.KeyEvent;
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

/**
 *
 * @author linke
 */
public class frmEmpleado extends javax.swing.JInternalFrame {
Connection conn ;
DefaultTableModel model;
    /**
     * Creates new form frmEmpleado
     */
    public frmEmpleado() {
        initComponents();
     
        try
        {
              Class.forName("org.gjt.mm.mysql.Driver") ;
              conn = DriverManager.getConnection("jdbc:mysql://localhost/libreria","root","") ;
              System.out.println("CONEXION EXITOSA");
        }
        catch(Exception e) {}
           llenarCargo();
           consultar("");
           jPasswordField1.setText("");
           Comprobar.setVisible(false);
           btnGuardar.setEnabled(false);
           btnCancelar1.setEnabled(false);
           
           btnModificar.setVisible(false);
           btnEliminar.setEnabled(false);
           lblID_usuario.setVisible(false);
            txtApellido.setFocusable(true);
           
    }
  public void llenarCargo(){
        
        String consulta="select distinct cargo from cargos where cargo <> 'Seleccione cargo'" ;
        
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(consulta);
            Object Datos[]= new Object[1];
            
            while (rs.next()){
                for (int i=0;i<1;i++){
                    Datos[i]=(rs.getObject(i+1));
                    this.jComboBox1.addItem(String.valueOf(Datos[i]));
                    
                }
            }
            } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Ha ocurrido un error: "+e.toString(),
                "Error", JOptionPane.ERROR_MESSAGE);     
        }
      
    }
    private void consultar(String valor){
     String query = "";
     if(valor.equals("")){
         query="select DISTINCT id_empleado, nombres, apellidos, fecha_nac, direccion, correo,telefono, cargos.cargo, roles.usuario from empleados inner join cargos on empleados.id_cargo = cargos.id_cargo left JOIN roles on empleados.id_rol = roles.id_rol" ;
     }
     else{
         query="select DISTINCT id_empleado, nombres, apellidos, fecha_nac, direccion, correo,telefono, cargos.cargo, roles.usuario from empleados "
                 + "inner join cargos on empleados.id_cargo = cargos.id_cargo "
                 + "left JOIN roles on empleados.id_rol = roles.id_rol "
                 + "where nombres LIKE '%"+valor+"%' "
                 + "OR apellidos LIKE '%"+valor+"%'"
                 + "OR id_empleado LIKE '%"+valor+"%'"
                 + "OR roles.usuario LIKE '%"+valor+"%'"; 
     }
     
 try {
          Statement stmt = conn.createStatement();
          ResultSet rs = stmt.executeQuery(query) ;
          model = (DefaultTableModel) this.jTable1.getModel();
          model.setRowCount(0);
          Object Datos[]= new Object[9];
          
          while (rs.next())
           {
              for (int i=0;i<9;i++) Datos[i]=rs.getObject(i+1);
              model.addRow(Datos);
           }
           this.jTable1.setModel(model);
          
        }
        catch(Exception e) 
        {
            JOptionPane.showMessageDialog(null,"HA OCURRIDO UN ERROR: "+e.toString(),
                "Error", JOptionPane.ERROR_MESSAGE);          
        }

 }
    public void usuario (){
        String query="";
        query="SELECT count(id_rol) FROM roles";
        try { 
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(query) ;
         Object Datos[]= new Object[1];
         while (rs.next())
           { 
         for (int i=0;i<1;i++){  Datos[i]=rs.getObject(i+1);
         this.lblID_usuario.setVisible(true);
         this.lblID_usuario.setText(""+Datos[i]);
         System.out.print(Datos);
           } }
          }
        catch(Exception e) 
        {
            JOptionPane.showMessageDialog(null,"HA OCURRIDO UN ERROR: "+e.toString(),
                "Error", JOptionPane.ERROR_MESSAGE);          
        }
    }
    public void usuario1 (){
       
        
        
        try { 
            int fila = this.jTable1.getSelectedRow();
            if (fila>=0){
                this.txtID.setText(this.jTable1.getValueAt(fila, 0).toString());
                String query ="SELECT id_rol FROM empleados where id_empleado ="+this.jTable1.getValueAt(fila, 0).toString();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(query) ;
         Object Datos[]= new Object[1];
         while (rs.next())
           { 
         for (int i=0;i<1;i++){  Datos[i]=rs.getObject(i+1);
         this.lblID_usuario.setVisible(true);
         this.lblID_usuario.setText(""+Datos[i]);
         System.out.print(Datos);
           } }
          }
       }
        catch(Exception e) 
        {
            JOptionPane.showMessageDialog(null,"HA OCURRIDO UN ERROR: "+e.toString(),
                "Error", JOptionPane.ERROR_MESSAGE);          
        }
    }
   public void buscar (String buscar){
       String query = "";
        query="select DISTINCT id_empleado, nombres, apellidos, fecha_nac, direccion, correo,telefono, cargos.cargo, roles.usuario from empleados "
                + "inner join cargos on empleados.id_cargo = cargos.id_cargo "
                + "left JOIN roles on empleados.id_rol = roles.id_rol where id_empleado like '%"+txtBuscar+"%' or  nombres like '%"+txtBuscar+"%' "
                + "or apellidos like '%"+txtBuscar+"%' or usuario like '%"+txtBuscar+"%' " ;
        try {
          Statement stmt = conn.createStatement();
          ResultSet rs = stmt.executeQuery(query) ;
          model = (DefaultTableModel) this.jTable1.getModel();
          model.setRowCount(0);
          Object Datos[]= new Object[9];
          
          while (rs.next())
           {
              for (int i=0;i<9;i++) Datos[i]=rs.getObject(i+1);
              model.addRow(Datos);
           }
           this.jTable1.setModel(model);
          
        }
        catch(Exception e) 
        {
            JOptionPane.showMessageDialog(null,"HA OCURRIDO UN ERROR: "+e.toString(),
                "Error", JOptionPane.ERROR_MESSAGE);          
        }
   }
   public void seleccionar (){
       int fila = this.jTable1.getSelectedRow();
       if (fila>=0){
           this.txtID.setText(this.jTable1.getValueAt(fila, 0).toString());
            this.txtNombres.setText(this.jTable1.getValueAt(fila, 1).toString());
            this.txtApellido.setText(this.jTable1.getValueAt(fila, 2).toString());
            this.jTextField1.setText(this.jTable1.getValueAt(fila, 3).toString());
            this.txtDireccion.setText(this.jTable1.getValueAt(fila, 4).toString());
            this.txtCorreo.setText(this.jTable1.getValueAt(fila, 5).toString());
            this.txtTelefono.setText(this.jTable1.getValueAt(fila, 6).toString());
            this.jComboBox1.setSelectedItem(this.jTable1.getValueAt(fila, 7).toString());
            this.txtUsuario.setText(this.jTable1.getValueAt(fila, 8).toString());
            usuario1();
            btnEliminar.setEnabled(true);
            btnModificar.setVisible(true);
           
             btnCancelar1.setVisible(true);
             btnCancelar1.setEnabled(true); 
            
       }else {
           JOptionPane.showMessageDialog(null, "Seleccione fila");
       }
   }
   public void modificar (){
       try {
        //  String query = "UPDATE empleados SET apellidos = '"+this.txtApellido.getText()+"' , nombres = '"+this.txtNombres.getText()+"' , correo = '"+this.txtCorreo.getText()+
        //          "', direccion = '"+this.txtDireccion.getText()+"' , fecha_nac = '"+this.jTextField1.getText()+"' , telefono = '"+this.txtTelefono.getText()+"' where id_empleado = '" +this.txtID.getText()+"'";
         
        String query = "UPDATE empleados SET apellidos = ? , nombres = ? , correo = ? , direccion = ? , fecha_nac = ? , telefono = ?, id_cargo = ?, id_rol =? "
               
                + "where id_empleado = ?";
        
          PreparedStatement pst = conn.prepareStatement(query);
          pst.setString (9,  this.txtID.getText().trim());
            pst.setString(2, this.txtNombres.getText().trim());
            pst.setString(1, this.txtApellido.getText().trim());
            pst.setString(6, this.txtTelefono.getText().trim());
            pst.setString(4, this.txtDireccion.getText().trim());
            pst.setString(3, this.txtCorreo.getText().trim());
            pst.setString(5, this.jTextField1.getText().trim());
            
            pst.setString(7, ""+this.jComboBox1.getSelectedIndex());
            pst.setString(8, ""+this.lblID_usuario.getText().trim());
           
            pst.executeUpdate();
         
       }
       catch (Exception e){
      JOptionPane.showMessageDialog(null,"Ha ocurrido un error: "+e.toString(),
                "Error", JOptionPane.ERROR_MESSAGE); 
   }
       this.consultar ("");
   }
   public void Cancelar (){
         this.btnGuardar.setEnabled(false);
         this.btnCancelar1.setEnabled(false);
         this.Comprobar.setVisible(false);
         this.btnEliminar.setEnabled(true);
         this.txtApellido.setText("");
         this.txtNombres.setText("");
         this.txtID.setText("");
         this.txtTelefono.setText("");
         this.txtDireccion.setText("");
         this.txtCorreo.setText("");
         this.txtUsuario.setText("");
         this.jTextField1.setText("");
   }
   public void Limpiar (){
       this.txtApellido.setText("");
       this.txtNombres.setText("");
       this.txtID.setText("");
       this.txtCorreo.setText("");
       this.txtDireccion.setText("");
       this.txtTelefono.setText("");
       this.jPasswordField1.setText("");
       this.jComboBox1.setSelectedIndex(0);
       this.jTextField1.setText("");
       this.txtUsuario.setText("");
       this.lblID_usuario.setText(" ");
       this.lblID_usuario.setVisible(false);
       this.btnCancelar1.setEnabled(false);
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
        txtNuevoEmpleado = new javax.swing.JLabel();
        lblApellidos = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblID = new javax.swing.JLabel();
        lblCorreo = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        lblFechNacimiento = new javax.swing.JLabel();
        lblCargo = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        txtID = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtNombres = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        btnGuardar = new javax.swing.JButton();
        txtUsuario = new javax.swing.JTextField();
        lblContraseña = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        lblDireccion = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        lblID_usuario = new javax.swing.JLabel();
        btnModificar = new javax.swing.JButton();
        btnCancelar1 = new javax.swing.JButton();
        Comprobar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        lblBuscarpor = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnEliminar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNuevoEmpleado.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtNuevoEmpleado.setText("Nuevo empleado");
        jPanel1.add(txtNuevoEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(119, 29, -1, -1));

        lblApellidos.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblApellidos.setText("Apellidos:");
        jPanel1.add(lblApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 76, -1, -1));

        lblNombre.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblNombre.setText("Nombres:");
        jPanel1.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        lblID.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblID.setText("DUI:");
        jPanel1.add(lblID, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        lblCorreo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblCorreo.setText("Correo:");
        jPanel1.add(lblCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        lblTelefono.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblTelefono.setText("Telefono:");
        jPanel1.add(lblTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));

        lblFechNacimiento.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblFechNacimiento.setText("Fecha nacimiento:");
        jPanel1.add(lblFechNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, -1));

        lblCargo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblCargo.setText("Cargo:");
        jPanel1.add(lblCargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, -1, -1));

        lblUsuario.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblUsuario.setText("Usuario:");
        jPanel1.add(lblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, -1, -1));

        txtApellido.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtApellidoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtApellidoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidoKeyTyped(evt);
            }
        });
        jPanel1.add(txtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 350, -1));

        txtID.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtIDKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIDKeyTyped(evt);
            }
        });
        jPanel1.add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 350, -1));

        txtCorreo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoActionPerformed(evt);
            }
        });
        txtCorreo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCorreoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCorreoKeyTyped(evt);
            }
        });
        jPanel1.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 350, -1));

        txtTelefono.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });
        jPanel1.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 350, -1));

        txtNombres.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtNombres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNombresKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombresKeyTyped(evt);
            }
        });
        jPanel1.add(txtNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 350, -1));

        jTextField1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
        });
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, 350, -1));

        jComboBox1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONE CARGO" }));
        jComboBox1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboBox1KeyPressed(evt);
            }
        });
        jPanel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 280, 350, -1));

        btnGuardar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/_active__save.png"))); // NOI18N
        btnGuardar.setText("GUARDAR");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        btnGuardar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnGuardarKeyPressed(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 470, 172, 73));

        txtUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtUsuarioKeyReleased(evt);
            }
        });
        jPanel1.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 310, 350, -1));

        lblContraseña.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblContraseña.setText("Contraseña:");
        jPanel1.add(lblContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, -1, -1));

        jPasswordField1.setText("jPasswordField1");
        jPasswordField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPasswordField1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jPasswordField1KeyReleased(evt);
            }
        });
        jPanel1.add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 340, 350, -1));

        lblDireccion.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblDireccion.setText("Dirección:");
        jPanel1.add(lblDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));

        txtDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDireccionKeyPressed(evt);
            }
        });
        jPanel1.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, 350, -1));

        lblID_usuario.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblID_usuario.setText("jLabel1");
        jPanel1.add(lblID_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 310, -1, -1));

        btnModificar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/modificar.png"))); // NOI18N
        btnModificar.setText("MODIFICAR");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel1.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 470, 170, 70));

        btnCancelar1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnCancelar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cancel_stop_exit_1583.png"))); // NOI18N
        btnCancelar1.setText("CANCELAR");
        btnCancelar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelar1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 470, -1, -1));

        Comprobar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/userpassword_deusuari_787.png"))); // NOI18N
        Comprobar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComprobarActionPerformed(evt);
            }
        });
        jPanel1.add(Comprobar, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 310, -1, -1));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 51)));
        jPanel2.setForeground(new java.awt.Color(255, 255, 51));

        lblBuscarpor.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblBuscarpor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/search_106707.png"))); // NOI18N
        lblBuscarpor.setText("BUSCAR:");

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        jTable1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 51)));
        jTable1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOMBRE", "APELLIDO", "FECHA DE NACIMIENTO", "DIRECCIÓN", "E-MAIL", "TELEFONO", "CARGO", "ROL"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        btnEliminar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/trash_full_recycle_delete_delete_9751.png"))); // NOI18N
        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("LISTA DE EMPLEADOS");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(401, 401, 401)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(lblBuscarpor)
                        .addGap(41, 41, 41)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 260, Short.MAX_VALUE)
                        .addComponent(btnEliminar)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 80, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBuscarpor)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 566, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 643, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        
        try
        {
            
             String query1= "insert into empleados (id_empleado, nombres, apellidos, telefono, direccion, correo, fecha_nac, id_cargo, id_rol) "
                    + "values (?,?,?,?,?,?,?,?,?)";

            PreparedStatement pst = conn.prepareStatement(query1);

            pst.setString(1, this.txtID.getText().trim());
            pst.setString(2, this.txtNombres.getText().trim());
            pst.setString(3, this.txtApellido.getText().trim());
            pst.setString(4, this.txtTelefono.getText().trim());
            pst.setString(5, this.txtDireccion.getText().trim());
            pst.setString(6, this.txtCorreo.getText().trim());
            pst.setString(7, this.jTextField1.getText().trim());
            pst.setString(8, ""+this.jComboBox1.getSelectedIndex());
            pst.setString(9, this.lblID_usuario.getText().trim());
             pst.executeUpdate();
           
           
          
            //limpiar controles visuales
            this.txtUsuario.setText("");
            this.jPasswordField1.setText("");
            
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"HA OCURRIDO UN ERROR: "+e.toString(),
                "Error", JOptionPane.ERROR_MESSAGE);
        }
        this.consultar ("");
        Limpiar ();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int fila = jTable1.getSelectedRow();
        if (fila>=0){
            String dato="";
            dato=jTable1.getValueAt(fila, 0).toString();
            try
            {
                String query = "DELETE FROM empleados WHERE id_empleado='"+dato+"'";

                PreparedStatement pst = conn.prepareStatement(query);
                // execute the preparedstatement
                pst.executeUpdate();

                // actualizar la tabla
                this.consultar("");
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,"HA OCURRIDO UN ERROR: "+e.toString(),
                    "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        else{
            JOptionPane.showMessageDialog(null,"Seleccione fila.",
                "Acción", JOptionPane.WARNING_MESSAGE);
        }
        Limpiar ();
        this.btnModificar.setVisible(false);
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        consultar(txtBuscar.getText());
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        seleccionar ();
    }//GEN-LAST:event_jTable1MouseClicked

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        modificar ();
        this.btnModificar.setVisible(false);
        Limpiar ();
    }//GEN-LAST:event_btnModificarActionPerformed

    private void ComprobarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComprobarActionPerformed
         try
        {
            
           String query = "insert into roles (usuario, clave)"
            + " values (?, ?)";
            
            PreparedStatement pstt = conn.prepareStatement(query);
             
            pstt.setString(1, this.txtUsuario.getText().trim());
            pstt.setString(2, this.jPasswordField1.getText().trim());
             
             pstt.executeUpdate();
            
             usuario ();
          
             }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"HA OCURRIDO UN ERROR: "+e.toString(),
                "Error", JOptionPane.ERROR_MESSAGE);
        }
         this.btnGuardar.setEnabled(true);
         this.Comprobar.setVisible(false);
    }//GEN-LAST:event_ComprobarActionPerformed

    private void txtApellidoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
             txtNombres.requestFocus();
        }
    }//GEN-LAST:event_txtApellidoKeyPressed

    private void txtNombresKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombresKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
             this.txtID.requestFocus();
        }
    }//GEN-LAST:event_txtNombresKeyPressed

    private void txtIDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIDKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
             this.txtCorreo.requestFocus();
        }
    }//GEN-LAST:event_txtIDKeyPressed

    private void txtCorreoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCorreoKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
             this.txtTelefono.requestFocus();
        }
    }//GEN-LAST:event_txtCorreoKeyPressed

    private void txtTelefonoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyPressed
       if(evt.getKeyCode()==KeyEvent.VK_ENTER){
             this.txtDireccion.requestFocus();
        }
    }//GEN-LAST:event_txtTelefonoKeyPressed

    private void txtDireccionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccionKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
             this.jTextField1.requestFocus();
        }
    }//GEN-LAST:event_txtDireccionKeyPressed

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
      if(evt.getKeyCode()==KeyEvent.VK_ENTER){
             this.jComboBox1.requestFocus();
        }
    }//GEN-LAST:event_jTextField1KeyPressed

    private void jComboBox1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox1KeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
             this.txtUsuario.requestFocus();
        }
    }//GEN-LAST:event_jComboBox1KeyPressed

    private void jPasswordField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordField1KeyReleased
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
             this.jPasswordField1.requestFocus();
        }
        if (this.txtUsuario.getText().equals(" ") && this.jPasswordField1.getText().equals(" ")){
                 }else {
   this.Comprobar.setVisible(false);
            this.Comprobar.setVisible(true);
        }
    }//GEN-LAST:event_jPasswordField1KeyReleased

    private void jPasswordField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordField1KeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
             this.btnGuardar.requestFocus();
        }
    }//GEN-LAST:event_jPasswordField1KeyPressed

    private void btnGuardarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnGuardarKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            btnGuardar.doClick();
        }
    }//GEN-LAST:event_btnGuardarKeyPressed

    private void txtIDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIDKeyTyped
       char c= evt.getKeyChar();
       if (c<'0' || c>'9') evt.consume();
    }//GEN-LAST:event_txtIDKeyTyped

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
       char c= evt.getKeyChar();
       if (c<='0' || c>='9') evt.consume();
    }//GEN-LAST:event_txtTelefonoKeyTyped

    private void txtApellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoKeyTyped
       char tecla = evt.getKeyChar();
        if ((tecla < 'a' || tecla > 'z') && (tecla < 'A' || tecla > 'Z')&& (tecla!=' ') && (tecla!='ñ')&& (tecla!='Ñ')) evt.consume();
    }//GEN-LAST:event_txtApellidoKeyTyped

    private void txtApellidoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoKeyReleased
//        this.btnGuardar.setEnabled(true);
        this.btnCancelar1.setEnabled(true);
        
    }//GEN-LAST:event_txtApellidoKeyReleased

    private void txtUsuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioKeyReleased
        if (this.txtUsuario.getText().equals(" ") && this.jPasswordField1.getText().equals(" ")){
                 }else {
   this.Comprobar.setVisible(false);
            this.Comprobar.setVisible(true);
        }
    }//GEN-LAST:event_txtUsuarioKeyReleased

    private void btnCancelar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelar1ActionPerformed
        Cancelar ();
       
    }//GEN-LAST:event_btnCancelar1ActionPerformed

    private void txtNombresKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombresKeyTyped
       char tecla = evt.getKeyChar();
        if ((tecla < 'a' || tecla > 'z') && (tecla < 'A' || tecla > 'Z')&& (tecla!=' ') && (tecla!='ñ')&& (tecla!='Ñ')) evt.consume();
    }//GEN-LAST:event_txtNombresKeyTyped

    private void txtCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreoActionPerformed

    private void txtCorreoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCorreoKeyTyped
        char tecla = evt.getKeyChar();
        if ((tecla < 'a' || tecla > 'z') && (tecla < 'A' || tecla > 'Z') && (tecla <= '0' || tecla >= '9') && (tecla!=' ') && (tecla!='ñ')&& (tecla!='Ñ') && (tecla!='@')&& (tecla!='.')&& (tecla!='-')&& (tecla!='_')) evt.consume();
    }//GEN-LAST:event_txtCorreoKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Comprobar;
    private javax.swing.JButton btnCancelar1;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblApellidos;
    private javax.swing.JLabel lblBuscarpor;
    private javax.swing.JLabel lblCargo;
    private javax.swing.JLabel lblContraseña;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblFechNacimiento;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblID_usuario;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JLabel txtNuevoEmpleado;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
