/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Monitores;



/**
 *
 * @author Manuel
 */
public class Ejercicio1 {
    public static void main(String[] args) {
        String[]nombresEmpleados={"Pablo","Luis","Andrea","Pedro","Paula"};
        Saludo hola=new Saludo();
        Personal[]elPersonal=new Personal[6];
        elPersonal[0]=new Personal(hola,"jefe",5);//creo jefe
        for (int i = 1; i < 6; i++) {
            elPersonal[i]=new Personal(hola,nombresEmpleados[i-1]);//creo empleados
        }
        
        
        Thread[]elPersonalThread= new Thread[6];
        for (int i = 0; i < 6; i++) {
            elPersonalThread[i]= new Thread(elPersonal[i]);
        }
        for (int i = 0; i < 6; i++) {
            elPersonalThread[i].start();
        }
    }
}
