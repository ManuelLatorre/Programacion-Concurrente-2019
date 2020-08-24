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
public class Cajera extends Thread{
    private String nombre;
    public void procesarCompra(ClienteP6 cliente, long timeStamp){
        System.out.println("La cajera "+this.nombre+" COMIENZA A PROCESAR LA COMPRA DEL CLIENTE "+ cliente.getNombre()+ " EN EL TIEMPO "+ (System.currentTimeMillis()-timeStamp)/1000+ " seg");
        
        for (int i = 0; i < cliente.getCarroCompra().length; i++) {
            this.esperarXsegundos(cliente.getCarroCompra()[i]);
            System.out.println("Procesado el producto "+(i+1)+" --> Tiempo: "+(System.currentTimeMillis()-timeStamp)/1000+" seg");
        }
        System.out.println("LA CAJERA "+ this.nombre+" HA TERMINADO DE PROCESAR "+cliente.getNombre()+ " EN EL TIEMPO "+(System.currentTimeMillis()-timeStamp)/1000+" seg");
    }
    
    public Cajera(String unNombre){
        this.nombre=unNombre;
    }
    
    public void esperarXsegundos(int cantidadProducto){
        try{
            Thread.sleep(1000*cantidadProducto);
        }catch(InterruptedException e){
        }
    }
}

