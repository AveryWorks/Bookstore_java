/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author paula
 */
public class Producto {
    
    private int idProducto;
    private String nombreProducto;
    private String tipoProducto;
    private String descripcionProducto;
    private int precioProducto;

    public Producto(int idProducto, String nombreProducto, String tipoProducto, String descripcionProducto, int precioProducto) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.tipoProducto = tipoProducto;
        this.descripcionProducto = descripcionProducto;
        this.precioProducto = precioProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public void setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public void setPrecioProducto(int precioProducto) {
        this.precioProducto = precioProducto;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public String getTipoProducto() {
        return tipoProducto;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public int getPrecioProducto() {
        return precioProducto;
    }

    @Override
    public String toString() {
        return "Producto "+descripcionProducto+" "+tipoProducto+" "+nombreProducto+". Precio: "+precioProducto;
    }
    
    
}
