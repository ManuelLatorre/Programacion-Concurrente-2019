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
public class PingPong extends Thread{
    public PingPong(){
        
    }
    public void run(){
        System.out.println(""+Thread.currentThread().getName());
    }
}
class testPingPong{
    public static void main(String[] args) {
        PingPong t1= new PingPong();
        PingPong pang= new PingPong();
        PingPong pung= new PingPong();
        t1.setName("t1");
        pang.setName("pang");
        pung.setName("pung");
        
        t1.start();
        pang.start();
        pung.start();
         for (int i = 0; i < 10; i++) {
            System.out.println(i);
            try{
                Thread.sleep(2000);
            }catch(InterruptedException e){
            }
        }
    }

}


