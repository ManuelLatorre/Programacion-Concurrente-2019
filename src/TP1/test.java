/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Manuel
 */
public class test {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
        Date fecha1= new Date();
        Date fecha2= dateFormat.parse("2019-08-13");
        
        Yate yate= new Yate("abc",10,2018,300,10);
        String datos= "macri";
        Alquiler alquiler= new Alquiler(fecha1, fecha2, 1, yate, datos);
        System.out.println(alquiler.calcularValorAlquiler());
        
        Date fecha3= dateFormat.parse("1998-08-13");
        Date fecha4= dateFormat.parse("2005-08-13");
        Date fecha5= dateFormat.parse("2011-08-13");
        Date fecha6= dateFormat.parse("2009-08-13");
        
        Empleado empleado1= new Empleado("fulano", 40960119, "callefalsa123", fecha1, "masculino", "fai1931",fecha2, 10000);
        Empleado empleado2= new Empleado("fulano", 40960119, "callefalsa123", fecha1, "masculino", "fai1931",fecha3, 10000); 
        Empleado empleado3= new Empleado("fulano", 40960119, "callefalsa123", fecha1, "masculino", "fai1931",fecha4, 10000); 
        Empleado empleado4= new Empleado("fulano", 40960119, "callefalsa123", fecha1, "masculino", "fai1931",fecha5, 10000); 
        Empleado empleado5= new Empleado("fulano", 40960119, "callefalsa123", fecha1, "masculino", "fai1931",fecha6, 10000); 
        ArrayList<Empleado> empleados= new ArrayList<Empleado>();
        empleados.add(empleado1);
        empleados.add(empleado2);
        empleados.add(empleado3);
        empleados.add(empleado4);
        empleados.add(empleado5);
        ArrayList<Empleado> listaEmpleadosExp=empleado1.empleadosExperienciaDiezAños(empleados);
        System.out.println(listaEmpleadosExp);
        System.out.println(empleado1.getDatosPersona());
        
        
    }
}
