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
public class ListaProductos {

    public NodoProducto Cabeza;
    public NodoProducto temp;

    public void insertarProducto(Producto prd) {

        if (Cabeza == null) {
            Cabeza = new NodoProducto(prd);
        } else if (prd.getIdProducto() < Cabeza.getDatoProducto().getIdProducto()) {
            NodoProducto aux = new NodoProducto(prd);
            aux.setNextProducto(Cabeza);
            Cabeza = aux;
        } else if (Cabeza.getNextProducto() == null) {
            Cabeza.setNextProducto(new NodoProducto(prd));

        } else {

            NodoProducto aux = Cabeza;
            while (aux.getNextProducto() != null
                    && aux.getNextProducto().getDatoProducto().getIdProducto() < prd.getIdProducto()) {

                aux = aux.getNextProducto();
            }
            temp = new NodoProducto(prd);
            temp.setNextProducto(aux.getNextProducto());
            aux.setNextProducto(temp);
        }

    }

    public int contarProducto() {
        int total = 0;
        NodoProducto aux = Cabeza;
        while (aux.getNextProducto() != null) {

            total++;
        }
        return total;
    }

    public Producto obtenerProducto(int buscador) {
        NodoProducto aux2 = Cabeza;
        while (aux2.getDatoProducto().getIdProducto() < buscador) {
            aux2=aux2.getNextProducto();
        }

        return aux2.getDatoProducto();
    }

    public String toString() {
        NodoProducto aux = Cabeza;
        String s = " ";
        while (aux != null) {
            s += aux + "\n ";
            aux = aux.getNextProducto();
        }

        return s;
    }
}
