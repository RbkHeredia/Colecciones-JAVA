/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package extra1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author rebek
 * 
 * Diseñar un programa que lea una serie de valores numéricos enteros 
 * desde el teclado y los guarde en un ArrayList de tipo Integer. 
 * La lectura de números termina cuando se introduzca el valor -99. 
 * Este valor no se guarda en el ArrayList. A continuación, el programa 
 * mostrará por pantalla el número de valores que se han leído, su suma y su 
 * media (promedio).
 */
public class Extra1 {

    /**
     * @param args the command line arguments
     * 
     */
    public static void main(String[] args) {
        ArrayList<Integer> numeros = new ArrayList();
        Scanner read = new Scanner(System.in);
        Integer num;
        do{
            System.out.println("Ingrese un numero, para salir ingrese -99");
            num = read.nextInt();
            if(num != -99){
                numeros.add(num);
            } 
        }while (num != -99);
        
        int cant = numeros.size();
        System.out.println("En la lista hay "+ cant+"  numeros");
        int total = 0;
        for (Integer numero : numeros) {
            total += numero;
        }
        System.out.println("El promedio de los numeros es: "+ total/cant);
    }
    
}
