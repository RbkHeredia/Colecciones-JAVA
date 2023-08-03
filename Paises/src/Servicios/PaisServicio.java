/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Entidades.Pais;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author rebek
 */
public class PaisServicio {
    Scanner read = new Scanner(System.in);
    HashSet<Pais> paises = new HashSet<>();
    Pais pais;
    
    private void nuevoPais(){
        System.out.println("Nuevo pais");
        boolean exit = false;
        while(!exit){
            pais = new Pais();
            System.out.println("Ingrese el nombre del pais");
            pais.setPais(read.nextLine());
            paises.add(pais);
            System.out.println("Desea agregar otro pais? Ingrese 'no' para salir");
            if(read.nextLine().equals("no")){
                exit = true;
            }
        }
    }
    
    private void mostrarPaises(){
        System.out.println("Lista de paises");
        for (Pais pais : paises) {
            System.out.println("[ "+ pais.getPais() +" ]");
        }
        System.out.println("--------------------------------------------");
    }
    
    private void alfab(){
        ArrayList<Pais> list = new ArrayList(paises);
        list.sort(Comparator.comparing(Pais::getPais));
        for (Pais pais : list) {
            System.out.println("[ " + pais.getPais() + " ]");
        }
    }
    
    private void eliminarPais(String palabra){
        Iterator<Pais> it = paises.iterator();
        int counter = 0;
        while(it.hasNext()){
            if(it.next().getPais().equals(palabra)){
                counter++;
                it.remove();
            }
        }
        if(counter == 0){
            System.out.println("El elemento no existe");
        }
        mostrarPaises();
    }
    
    public void iniciarPrograma(){
        String palAEliminar;
        nuevoPais();
        mostrarPaises();
        alfab();
        System.out.println("Ingrese la palabra que desea eliminar");
        palAEliminar = read.nextLine();
        eliminarPais(palAEliminar);
    }
}
