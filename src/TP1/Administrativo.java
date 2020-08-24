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
public class Administrativo extends Empleado{
    private String categoria;
    public Administrativo(String unNombre, int unDNI, String unaDireccion, Date unaFechaNacimiento, String tipoSexo, String unLegajo, Date unaFechaIngreso, int unSalario,String unaCategoria) {
        super(unNombre, unDNI, unaDireccion, unaFechaNacimiento, tipoSexo, unLegajo, unaFechaIngreso, unSalario);
        categoria=unaCategoria;
    }
    
    public String getDatosPersona(){
      String datos;
      datos=super.getDatosPersona();
      datos= datos+this.categoria;
      return datos;
    }
    
}
