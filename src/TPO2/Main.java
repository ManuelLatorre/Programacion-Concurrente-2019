/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TPO2;

/**
 *
 * @author Manuel
 */
public class Main {
    public static void main(String[] args) {
        Filosofo []arrayFilosofos= new Filosofo[5];
        Thread []hilos= new Thread[5];
        Tenedor[]tenedores= new Tenedor[5];
        int tenedorIzq;
        for (int i = 0; i < 5; i++) {
            tenedores[i]=new Tenedor(""+i);
        }
        
        
        
        for (int i = 0; i < 5; i++) {
            if(i>=4){
                tenedorIzq=0;
            }else{
                tenedorIzq=i+1;
            }
            arrayFilosofos[i]= new Filosofo(""+i,tenedores[tenedorIzq],tenedores[i]);
            hilos[i]= new Thread(arrayFilosofos[i]);
            hilos[i].setName(""+i);
        }
        for (int i = 0; i < 5; i++) {
            System.out.println("Filosofo: "+arrayFilosofos[i].getNombre()+" Tenedor IZQ: "+arrayFilosofos[i].getTenedorIzq().getNombre()+" Tenedor Der: "+arrayFilosofos[i].getTenedorDer().getNombre());
        }
        
        
        for (int i = 0; i < 5; i++) {
            hilos[i].start();
        }
        
        try{
            for (int i = 0; i < 5; i++) {
                hilos[i].join();
            }
        }catch(InterruptedException e){
        }
        
        
        
    }
}
