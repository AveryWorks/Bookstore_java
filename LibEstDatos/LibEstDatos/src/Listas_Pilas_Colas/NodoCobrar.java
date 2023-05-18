/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Listas_Pilas_Colas;


import Clases.Cobrar;

/**
 *
 * @author XENIA
 */
public class NodoCobrar {
    private Cobrar DatoCobrar;
    private NodoCobrar nextCobrar;

    public NodoCobrar(Cobrar DatoCobrar) {
        this.DatoCobrar = DatoCobrar;
    }

    public Cobrar getDatoCobrar() {
        return DatoCobrar;
    }

    public void setDatoCobrar(Cobrar DatoCobrar) {
        this.DatoCobrar = DatoCobrar;
    }

    public NodoCobrar getNextCobrar() {
        return nextCobrar;
    }

    public void setNextCobrar(NodoCobrar nextCobrar) {
        this.nextCobrar = nextCobrar;
    }

    @Override
    public String toString() {
        return DatoCobrar.toString();
    }
    
    
}
