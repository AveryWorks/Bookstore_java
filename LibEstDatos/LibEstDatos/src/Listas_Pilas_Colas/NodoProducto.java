/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Listas_Pilas_Colas;

import Clases.Producto;

/**
 *
 * @author paula
 */
public class NodoProducto {
    
    public Producto DatoProducto;
    public NodoProducto nextProducto;

    public NodoProducto(Producto DatoProducto) {
        this.DatoProducto = DatoProducto;
    }

    public Producto getDatoProducto() {
        return DatoProducto;
    }

    public NodoProducto getNextProducto() {
        return nextProducto;
    }

    public void setDatoProducto(Producto DatoProducto) {
        this.DatoProducto = DatoProducto;
    }

    public void setNextProducto(NodoProducto nextProducto) {
        this.nextProducto = nextProducto;
    }

    @Override
    public String toString() {
        return DatoProducto.toString();
    }
    
    
    
}
