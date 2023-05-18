/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author maged
 */
public class Empleado {

    private int idEmpleado;
    private String nombreEmpleado;
    private String depaEmpleado;
    private String correoEmpleado;

    public Empleado() {
    }

    public Empleado(int idEmpleado, String nombreEmpleado, String depaEmpleado, String correoEmpleado) {
        this.idEmpleado = idEmpleado;
        this.nombreEmpleado = nombreEmpleado;
        this.depaEmpleado = depaEmpleado;
        this.correoEmpleado = correoEmpleado;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getDepaEmpleado() {
        return depaEmpleado;
    }

    public void setDepaEmpleado(String depaEmpleado) {
        this.depaEmpleado = depaEmpleado;
    }

    public String getCorreoEmpleado() {
        return correoEmpleado;
    }

    public void setCorreoEmpleado(String correoEmpleado) {
        this.correoEmpleado = correoEmpleado;
    }

    @Override
    public String toString() {
        return "Empleado{" + "idEmpleado=" + idEmpleado + ", nombreEmpleado=" + nombreEmpleado + ", depaEmpleado=" + depaEmpleado + ", correoEmpleado=" + correoEmpleado + '}';
    }
    
    
    
}
