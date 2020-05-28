/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

/**
 *
 * @author Jose
 */
public class Producto {
    int id_producto;
    int id_categoria;
    String producto;
    Double precio_compra;
    Double precio_venta;
    int existencia;
    int num_lote;
    
    public Producto(){
    }

    public Producto(int id_producto, int id_categoria, String producto, Double precio_compra, Double precio_venta, int existencia, int num_lote) {
        this.id_producto = id_producto;
        this.id_categoria = id_categoria;
        this.producto = producto;
        this.precio_compra = precio_compra;
        this.precio_venta = precio_venta;
        this.existencia = existencia;
        this.num_lote = num_lote;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public Double getPrecio_compra() {
        return precio_compra;
    }

    public void setPrecio_compra(Double precio_compra) {
        this.precio_compra = precio_compra;
    }

    public Double getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(Double precio_venta) {
        this.precio_venta = precio_venta;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }

    public int getNum_lote() {
        return num_lote;
    }

    public void setNum_lote(int num_lote) {
        this.num_lote = num_lote;
    }

  
  
    
    
}
