/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Listas_Pilas_Colas;

import Clases.Cliente;

/**
 *
 * @author maged
 */
public class ListaClientes {

    public NodoCliente Cabeza;
    public NodoCliente temp;

    public void insertarCliente(Cliente cln) {

        if (Cabeza == null) {
            Cabeza = new NodoCliente(cln);
        } else if (cln.getIdCliente() < Cabeza.getDatoCliente().getIdCliente()) {
            NodoCliente aux = new NodoCliente(cln);
            aux.setNextCliente(Cabeza);
            Cabeza = aux;
        } else if (Cabeza.getNextCliente() == null) {
            Cabeza.setNextCliente(new NodoCliente(cln));

        } else {

            NodoCliente aux = Cabeza;
            while (aux.getNextCliente() != null
                    && aux.getNextCliente().getDatoCliente().getIdCliente() < cln.getIdCliente()) {

                aux = aux.getNextCliente();
            }
            temp = new NodoCliente(cln);
            temp.setNextCliente(aux.getNextCliente());
            aux.setNextCliente(temp);
        }

    }


    public NodoCliente ObtenerCliente(int id) {

        NodoCliente aux = Cabeza;

        if (existe(id) == true) {
            while (aux != null) {

                aux = aux.getNextCliente();

            }
        }

        return aux;
    }

    public boolean existe(int id) {
        boolean esta = false;

        NodoCliente aux = Cabeza;
        while (aux != null) {

            if (aux.getDatoCliente().getIdCliente() == id) {

                esta = true;

            }

            aux = aux.getNextCliente();

        }

        return esta;
    }

    public String toString() {
        NodoCliente aux = Cabeza;
        String s = " ";
        while (aux != null) {
            s += aux + "\n ";
            aux = aux.getNextCliente();
        }

        return s;
    }

}
