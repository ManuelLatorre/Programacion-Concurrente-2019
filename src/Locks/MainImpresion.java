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
public class MainImpresion {
    public static void main(String[] args) {
        UsuarioImpresora []usuarios= new UsuarioImpresora[10];
        
        Thread[]usuariosThread= new Thread[10];
       
        SalaImpresion sala= new SalaImpresion(2,2); //indico cantidad de impresoras tipoA y tipoB
        
        for (int i = 0; i < 3; i++) { //creo los usuarios indicando la var compartida y el tipo de impresion que quieren
            usuarios[i]=new UsuarioImpresora("Usuario"+i,sala,'A');
        }
        for (int i = 3; i < 6; i++) {
            usuarios[i]=new UsuarioImpresora("Usuario"+i,sala,'B');
        }
        for (int i = 6; i < 10; i++) {
            usuarios[i]=new UsuarioImpresora("Usuario"+i,sala,'C');
        }
        
        for (int i = 0; i < 10; i++) {
            usuariosThread[i] = new Thread(usuarios[i]);
        }
        
        for (int i = 0; i < 10; i++) {
            usuariosThread[i].start();
        }
    }
}
