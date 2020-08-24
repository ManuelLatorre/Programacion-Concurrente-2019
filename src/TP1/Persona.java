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
public class Persona {
    private String nombre;
    private int DNI;
    private String direccion;
    private Date fechaNacimiento;
    private String sexo;
    
    public Persona(String unNombre, int unDNI,String unaDireccion,Date unaFechaNacimiento,String tipoSexo){
        nombre=unNombre;
        DNI=unDNI;
        direccion= unaDireccion;
        fechaNacimiento= unaFechaNacimiento;
        sexo=tipoSexo;
    }
    
    public String getDatosPersona(){
       String datos= "Nombre: "+this.nombre+" DNI: "+this.DNI+" direccion: "+this.direccion+" fechaNacimiento: "+this.fechaNacimiento+" sexo "+this.sexo+" ";
       return datos;
    }
}
