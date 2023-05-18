/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Listas_Pilas_Colas;


/**
 *
 * @author maged
 */
public class PilaCarrito {
    
    public NodoPila cima;
    
    public void pushPilaCarrito(NodoPila proPila){
        
        if (cima==null) {
            cima=proPila;
        } else {
            proPila.setAbajo(cima);
            cima=proPila;
        }
        
    }
    
    public void popPilaCarrito(){
        
        NodoPila aux=null;
        while (cima!=null) {
            aux=cima;
            cima=aux.getAbajo();
        }
        
    }
    
    public String toString() {
        NodoPila aux = cima;
        String s="";
        while(aux!=null){
            s+=aux + "\n";
            aux=aux.getAbajo();
        }
        return s;
    }
    
}
