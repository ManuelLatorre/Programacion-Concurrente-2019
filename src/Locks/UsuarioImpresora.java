/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Locks;

/**
 *
 * @author Manuel
 */
public class UsuarioImpresora implements Runnable {

    private String nombre;
    SalaImpresion sala;
    private char tipoImp;

    public UsuarioImpresora(String n, SalaImpresion sala, char tipo) {
        this.nombre = n;
        this.sala = sala;
        this.tipoImp = tipo;
    }
    
    public void setTipoImp(char tipo){ //cuando imprime un tipo C esto se modifica al tipo de la impresora que realiza la impresion
        this.tipoImp=tipo;
    }
    
    public void run() {

        if (tipoImp == 'A') { 
            sala.imprimirA();
            System.out.println("REALIZANDO IMPRESION TIPO A");
            try{
                Thread.sleep(5000);
            }catch(InterruptedException e){
            }
            sala.terminaImprimirA();
            
        }
        if (tipoImp == 'B') {
            sala.imprimirB();
            System.out.println("REALIZANDO IMPRESION TIPO B");
            try{
                Thread.sleep(5000);
            }catch(InterruptedException e){
            }
            sala.terminaImprimirB();
        }
        if (tipoImp == 'C') {
            sala.imprimirC(this);
            System.out.println("REALIZANDO IMPRESION TIPO C");
            try{
                Thread.sleep(5000);
            }catch(InterruptedException e){
            }
            sala.terminaImprimirC(tipoImp);//a estas alturas dejo de ser tipo C a ser del tipo de la impresora que realiza la impresion
            this.tipoImp='C';//lo modifico a su valor inicial
        }
        System.out.println("El usuario: " + this.nombre +"De tipo: "+this.tipoImp+ " Realizo su impresion");
    }

}
