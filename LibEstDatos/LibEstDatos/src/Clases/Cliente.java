/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author maged
 */
public class Cliente {
    
    private int idCliente;
    private String nombreCliente;
    private String telefonoCliente;
    private String correoCliente;

    public Cliente(int id, String nombre, String telefono, String correo) {
        this.idCliente = id;
        this.nombreCliente = nombre;
        this.telefonoCliente = telefono;
        this.correoCliente = correo;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int id) {
        this.idCliente = id;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombre) {
        this.nombreCliente = nombre;
    }

    public String getTelefonoCliente() {
        return telefonoCliente;
    }

    public void setTelefono(String telefono) {
        this.telefonoCliente = telefono;
    }

    public String getCorreoCliente() {
        return correoCliente;
    }

    public void setCorreoCliente(String correo) {
        this.correoCliente = correo;
    }
    
    @Override
    public String toString() {
        return "Cliente{" + "id=" + idCliente + ", nombre=" + nombreCliente + ", telefono=" + telefonoCliente + ", Correo=" + correoCliente + '}';
    }
    
}
