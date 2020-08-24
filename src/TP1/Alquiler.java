/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP1;

import java.util.Date;

/**
 *
 * @author Manuel
 */
public class Alquiler {
    private String datosCliente;
    private Date fechaInicial;
    private Date fechaFinal;
    private int posAmarre;
    private Barco barco;
    private int valorFijo;

    public Alquiler(Date fechaIni, Date fechaFin, int posiAmarre, Barco unBarco, String datosClient) {
    fechaInicial= fechaIni;
    fechaFinal= fechaFin;
    datosCliente= datosClient;
    posAmarre= posiAmarre;
    barco= unBarco;
    valorFijo= 200;
    
    }
    
    
     public double calcularValorAlquiler() {
        double moduloNormal, diasAlquiler, valorAlquiler, moduloTotal;
        diasAlquiler= ((fechaFinal.getTime()-fechaInicial.getTime())/86400000);
        moduloNormal=10*barco.getEslora();
        
        moduloTotal= barco.calcularModuloEspecial(moduloNormal);
        valorAlquiler= diasAlquiler*moduloTotal+valorFijo; 
      return valorAlquiler;  
    }
    
     public void registrarAlquiler(int unNroAmarre,Barco unBarco,String unCliente,int cantDias){
         posAmarre= unNroAmarre;
         barco= unBarco;
         datosCliente= unCliente;
         
     }
}
