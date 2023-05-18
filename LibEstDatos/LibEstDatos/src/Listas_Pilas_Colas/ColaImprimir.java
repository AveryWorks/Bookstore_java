/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Listas_Pilas_Colas;

/**
 *
 * @author maged
 */
public class ColaImprimir {
    public NodoCola CabezaCola;
    public NodoCola UltimoCola;
    
    public void encola(NodoCola ClnCola){
        
        if (CabezaCola==null) {
            CabezaCola=ClnCola;
            UltimoCola=ClnCola;
        } else {
            UltimoCola.setAtras(ClnCola);
            UltimoCola=ClnCola;
        }
    }
    public NodoCola ClnAtiende(){
        
        NodoCola aux=CabezaCola;
        if (CabezaCola!=null) {
            CabezaCola=CabezaCola.getAtras();
            aux.setAtras(null);
        }
        return aux;
    }
    public String toString(){
        String s="";
        NodoCola aux=CabezaCola;
        while(aux!=null){
            s+=aux+"\n";
            aux=aux.getAtras();
        }
        return s;
    }
}
