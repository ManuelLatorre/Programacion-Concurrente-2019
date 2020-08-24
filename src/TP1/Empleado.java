/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP1;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Manuel
 */
public class Empleado extends Persona{
    private int salario;
    private String legajo;
    private Date fechaIngreso;
    
    
    public Empleado(String unNombre, int unDNI, String unaDireccion, Date unaFechaNacimiento, String tipoSexo, String unLegajo,Date unaFechaIngreso, int unSalario) {
        super(unNombre, unDNI, unaDireccion, unaFechaNacimiento, tipoSexo);
        fechaIngreso=unaFechaIngreso;
        legajo=unLegajo;
        salario=unSalario;
    }
    
    public ArrayList <Empleado> empleadosExperienciaDiezAños(ArrayList<Empleado>empleados){
        Date fechaHoy=new Date();
        ArrayList<Empleado>empleadosExp=new ArrayList<Empleado>();
        double añosDif;
        for (int i = 0; i < empleados.size(); i++) {
            añosDif=(((fechaHoy.getTime()- empleados.get(i).getFechaIngreso().getTime())/86400000)/364);
            if(añosDif>=10){
                empleadosExp.add(empleados.get(i));
            }
        }
        return empleadosExp; 
    }
    
    public Date getFechaIngreso(){
        return this.fechaIngreso;
    }
    
    public String getDatosPersona(){
      String datos;
      datos=super.getDatosPersona();
      datos= datos+this.fechaIngreso+" Legajo: "+this.legajo+" Salario: "+this.salario;
      return datos;
    }
}
