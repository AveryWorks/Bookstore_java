/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Listas_Pilas_Colas;

import Clases.Empleado;

/**
 *
 * @author maged
 */
public class NodoEmpleado {
    private Empleado DatoEmpleado;
    private NodoEmpleado nextEmpleado;

    public NodoEmpleado(Empleado DatoEmpleado) {
        this.DatoEmpleado = DatoEmpleado;
    }

    public Empleado getDatoEmpleado() {
        return DatoEmpleado;
    }

    public void setDatoEmpleado(Empleado DatoEmpleado) {
        this.DatoEmpleado = DatoEmpleado;
    }

    public NodoEmpleado getNextEmpleado() {
        return nextEmpleado;
    }

    public void setNextEmpleado(NodoEmpleado next) {
        this.nextEmpleado = next;
    }
    
    @Override
    public String toString(){
        return DatoEmpleado.toString();
    }
}
