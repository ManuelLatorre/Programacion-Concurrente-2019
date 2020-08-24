/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP3;

/**
 *
 * @author Manuel
 */
public class CajeraThread implements Runnable{
    private String nombre;
    private ClienteP6 cliente;
    private long initialTime;
    
    public CajeraThread(String unNombre,ClienteP6 unCliente,long unInitialTime){
        this.nombre=unNombre;
        this.cliente=unCliente;
        this.initialTime= unInitialTime;
    }
    public void run(){
        System.out.println("La cajera "+this.nombre+" COMIENZA A PROCESAR LA COMPRA DEL CLIENTE "+ cliente.getNombre()+ " EN EL TIEMPO "+ (System.currentTimeMillis()-this.initialTime)/1000+ " seg");
        
        for (int i = 0; i < cliente.getCarroCompra().length; i++) {
            this.esperarXsegundos(cliente.getCarroCompra()[i]);
            System.out.println("Procesado el producto "+(i+1)+" --> Tiempo: "+(System.currentTimeMillis()-this.initialTime)/1000+" seg");
        }
        System.out.println("LA CAJERA "+ this.nombre+" HA TERMINADO DE PROCESAR "+cliente.getNombre()+ " EN EL TIEMPO "+(System.currentTimeMillis()-this.initialTime)/1000+" seg");
    }
    
    public void esperarXsegundos(int cantidadProducto){
        try{
            Thread.sleep(1000*cantidadProducto);
        }catch(InterruptedException e){
        }
    }
}
