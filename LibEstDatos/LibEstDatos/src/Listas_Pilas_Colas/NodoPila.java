/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Listas_Pilas_Colas;

import Clases.Producto;

/**
 *
 * @author XENIA
 */
public class NodoPila {

    private Producto PilaProducto;
    private NodoPila abajo;

    public NodoPila(Producto PilaProducto) {
        this.PilaProducto = PilaProducto;
    }

    public String toString() {
        return PilaProducto.toString();
    }

    public Producto getPilaProducto() {
        return PilaProducto;
    }

    public void setPilaProducto(Producto PilaProducto) {
        this.PilaProducto = PilaProducto;
    }

    public NodoPila getAbajo() {
        return abajo;
    }

    public void setAbajo(NodoPila abajo) {
        this.abajo = abajo;
    }
}
