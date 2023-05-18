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
public class NodoCliente {
    private Cliente DatoCliente;
    private NodoCliente nextCliente;

    public NodoCliente(Cliente DatoCliente) {
        this.DatoCliente = DatoCliente;
    }

    public Cliente getDatoCliente() {
        return DatoCliente;
    }

    public void setDatoCliente(Cliente DatoCliente) {
        this.DatoCliente = DatoCliente;
    }

    public NodoCliente getNextCliente() {
        return nextCliente;
    }

    public void setNextCliente(NodoCliente nextCliente) {
        this.nextCliente = nextCliente;
    }
    
    @Override
    public String toString(){
        return DatoCliente.toString();
    }
    
}
