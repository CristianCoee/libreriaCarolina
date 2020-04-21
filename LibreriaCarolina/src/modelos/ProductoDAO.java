/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import libreriacarolina.Conexion;

/**
 *
 * @author Jose
 */
public class ProductoDAO {
    int r;
    PreparedStatement ps;
    ResultSet rs;
    Connection conn;
    Conexion acceso =new Conexion();
    Producto pro = new Producto();
    
    
    
    
    public Producto listarID(int id){
        
        Producto p =new Producto();
        String sql= "select * from producto where id_producto=?";
        try {
            conn=acceso.conexion();
            ps=conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs=ps.executeQuery();
            while (rs.next()){
                
            p.setId_producto(rs.getInt(1));
            p.setId_categoria(rs.getInt(2));
            p.setProducto(rs.getString(3));
            p.setPrecio_compra(rs.getDouble(4));
            p.setPrecio_venta(rs.getDouble(5));
            p.setNum_lote(rs.getInt(6));
            }
        
        }catch (Exception e){
        }  
        return p;
             
    
    
    }
    
    
    
    
   
    
}
