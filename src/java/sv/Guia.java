/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package sv;

import java.util.HashMap;
import java.util.Map;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Saul
 */
@WebService(serviceName = "Guia")
public class Guia {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "Login")
    public boolean Login(@WebParam(name = "Usuario") String Usuario, @WebParam(name = "Contrasena") String Contrasena) {
        String resulta=""; 
        boolean encuentra=false;
        boolean resultado=false;  
        Map <String, String> map = new HashMap ();
        map.put("Admin", "1234");
        map.put("Saul", "2108");
        map.put("Prueba", "0000");
 
           if(Usuario==null || Contrasena==null){
               resultado=false;
           }else{
             for(Map.Entry<String, String> clave:map.entrySet()){
             String val = clave.getKey();
            
               if(Usuario.equalsIgnoreCase(val)){
                    resulta = clave.getValue();
                    if(resulta.equalsIgnoreCase(Contrasena)){
                    resultado=true; 
                    encuentra=true;
                    break;
                    } else{
                       resultado = false;  
                    }
                    }
                  }
               }

        if(encuentra==false) {
            resultado = false; 
            }
        return resultado;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "Operaciones")
    public Double Operaciones(@WebParam(name = "num1") double num1, @WebParam(name = "operacion") String operacion, @WebParam(name = "num2") double num2) {
      double respuesta;
      switch (operacion) {
        case "suma":
            respuesta=num1+num2;
            break;
        case "resta":
            respuesta=num1-num2;
            break;
        case "multiplicacion":
            respuesta=num1*num2;
            break;
        default:
            respuesta=num1/num2;
        } 
        return respuesta;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "Calculos")
    public String Calculos(@WebParam(name = "lado1") double lado1, @WebParam(name = "caso") String caso, @WebParam(name = "lado2") double lado2) {
        String respuesta;
        // Switch statement over above string
      switch (caso) {
        // Case 1
        case "hipotenusa":
            //Hipotenusa
            String res= String.valueOf(Math.hypot(lado1, lado2));
            System.out.println(res);
            respuesta="La hipotenusa es: "+res;
            // break keyword terminates the
            // code execution here itself
            break;
 
        // Case 2
        case "area":
            //Area
            double total=(lado1*lado2)/2;
            System.out.println("Area "+total);
            respuesta="La area es: "+total;
            break;
 
        // Case 3
        case "angulo":
            //Angulo
            double ang=180-(lado1+lado2);
            // Print statement corresponding case
            System.out.println("El angulo es "+ang);
            respuesta="El angulo es: "+ang;
            break;
        // Case 4
        // Default case
        default:
            respuesta="No puedo realizar ese calculo";
        }
       
        return respuesta;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "ProcesarPago")
    public Double ProcesarPago(@WebParam(name = "total") double total, @WebParam(name = "retiro") double retiro) {
        if(retiro<=total){
        return total-retiro;
        } else {
        return -1.0;}
    }
}
