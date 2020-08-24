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
public class Tecnico extends Empleado{
    private Date fechaObtencionTitulo;
    private String titulo;
    
    public Tecnico(String unNombre, int unDNI, String unaDireccion, Date unaFechaNacimiento, String tipoSexo, String unLegajo, Date unaFechaIngreso, int unSalario,Date unaFechaObtencionTitulo,String unTitulo) {
        super(unNombre, unDNI, unaDireccion, unaFechaNacimiento, tipoSexo, unLegajo, unaFechaIngreso, unSalario);
        fechaObtencionTitulo= unaFechaObtencionTitulo;
        titulo= unTitulo;
    }
    public String getDatosPersona(){
      String datos;
      datos=super.getDatosPersona();
      datos= datos+this.titulo;
      return datos;
    }
    
}
