/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

2.Continuando el ejercicio anterior, después de mostrar los perros, al usuario se le pedirá
un perro y se recorrerá la lista con un Iterator, se buscará el perro en la lista. Si el perro
está en la lista, se eliminará el perro que ingresó el usuario y se mostrará la lista
ordenada. Si el perro no se encuentra en la lista, se le informará al usuario y se mostrará
la lista ordenada.
 */
package services;

import entities.raza;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author rebek
 */
public class razaServices {
    private Scanner read = new Scanner(System.in);
    private ArrayList<String> razas;
   
    
    public razaServices() {
        this.razas = new ArrayList();
    }
    
    public raza crearRaza(){
        System.out.println("Introducir la raza que desea agregar");
        String input = read.nextLine();
        razas.add(input);
        return new raza(input);
    }
    
    public void mostrarTodo(){
        for (String el : razas) {
            System.out.println("Raza: "+el);
        }
    }
    
    public void eliminarRaza(String aEliminar){
        Iterator<String> it = razas.iterator();
        int counter = 0;
        while(it.hasNext()){
            if(it.next().equals(aEliminar)){
                it.remove();
                counter++;
            }
        }
        if(counter==0){
            System.out.println("El elemento no se encuentra en la lista");
        }
    }
    
    public void comenzarPrograma(){
        boolean exit = false;
        do{
            crearRaza();
            System.out.println("Si quiere salir ingrese 0, de lo contrario ingrese cualquier letra");
            if("0".equals(read.nextLine())){
                exit=true;
            }
        }while(!exit);
        mostrarTodo();
        System.out.println("Ingrese una raza a eliminar");
        String paraEliminar = read.nextLine();
        eliminarRaza(paraEliminar);
        Collections.sort(razas);
        mostrarTodo();
        
    }
}
