/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Listas_Pilas_Colas;

/**
 *
 * @author maged
 */
public class NodoCola {
    
    private String DatoCola;
    private NodoCola atras;

    public NodoCola(String DatoCola) {
        this.DatoCola = DatoCola;
    }

    public String getDatoCola() {
        return DatoCola;
    }

    public void setDatoCola(String DatoCola) {
        this.DatoCola = DatoCola;
    }

    public NodoCola getAtras() {
        return atras;
    }

    public void setAtras(NodoCola atras) {
        this.atras = atras;
    }
    
    public String toString(){
        return DatoCola;
    }
    
}
