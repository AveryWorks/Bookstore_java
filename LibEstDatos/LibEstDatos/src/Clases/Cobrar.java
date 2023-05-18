/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author XENIA
 */
public class Cobrar {
    private int idProducto;
    private int cantidadProducto;
    private int precioProducto; 
    private int precio; 

    public Cobrar(int idProducto, int precioProducto, String tipoProducto, int precio) {
        this.idProducto = idProducto;
        this.precioProducto= precioProducto;
        this.precio = precio;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }
    
    public int getprecioProducto() {
        return precioProducto;
    }

    public int getPrecio() {
        return precio;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }
    public void setprecioProducto(int precioProducto) {
        this.precioProducto = precioProducto;
    }

    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Cobrar{" + "idProducto=" + idProducto + ", cantidadProducto=" + cantidadProducto + ", precioProducto=" + precioProducto + ", precio=" + precio + '}';
    }

    
    
    
}
