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
public class Filosofo implements Runnable{
    private String nombre;
    private Tenedor tenedorIzq;
    private Tenedor tenedorDer;
    public Filosofo(String unNombre,Tenedor unTenedorIzq, Tenedor unTenedorDer){
        nombre=unNombre;
        tenedorIzq=unTenedorIzq;
        tenedorDer=unTenedorDer;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    public void setNombre(String unNombre){
        nombre=unNombre;
    }
    
    public Tenedor getTenedorIzq(){
        return this.tenedorIzq;
    }
    public Tenedor getTenedorDer(){
        return this.tenedorDer;
    }
    public void run() {
        this.comer();
    }
    
    public void comer(){
        this.tenedorDer.ocupaTenedor();
        this.tenedorIzq.ocupaTenedor();
        this.Comiendo();
        this.tenedorIzq.liberaTenedor();
        this.tenedorDer.liberaTenedor();
    }
    
    public void Comiendo(){
        try{
            System.out.println("Filosofo: "+this.getNombre()+" Esta comiendo con los tenedores: Tenedor IZQ: "+this.getTenedorIzq().getNombre()+" Tenedor Der: "+this.getTenedorDer().getNombre());
            Thread.sleep(5000);
        }catch(InterruptedException e){
        }
    }
}
