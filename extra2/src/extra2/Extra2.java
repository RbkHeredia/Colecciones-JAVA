/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package extra2;

import Entidades.CantanteFamoso;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author rebek
 * 
 * Crear una clase llamada CantanteFamoso. Esta clase guardará cantantes famosos y
tendrá como atributos el nombre y discoConMasVentas.
Se debe, además, en el main, crear una lista de tipo CantanteFamoso y agregar 5 objetos
de tipo CantanteFamoso a la lista. Luego, se debe mostrar los nombres de cada cantante
y su disco con más ventas por pantalla.
Una vez agregado los 5, en otro bucle, crear un menú que le de la opción al usuario de
agregar un cantante más, mostrar todos los cantantes, eliminar un cantante que el usuario
elija o de salir del programa. Al final se deberá mostrar la lista con todos los cambios
 */
public class Extra2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList <CantanteFamoso> list = new ArrayList();
        CantanteFamoso info;
        Scanner read = new Scanner(System.in);
        String[] cantantes = {"arch enemy", "epica", "tarja", "good charlotte", "greenday"};
        String[] discos = {"war eternal", "omega", "oceanborn", "the chronicles of life and death", "dookie"};
        
        for (int i = 0; i < cantantes.length; i++) {
            info = new CantanteFamoso();
            info.setNombre(cantantes[i]);
            info.setDiscoConMasVentas(discos[i]);
            list.add(info);
        }
        
        for (CantanteFamoso cant : list) {
            System.out.println(cant);
        }
        boolean exit = false;
        int option;
        do{
            System.out.println("1. Agregar cantante");
            System.out.println("2. Mostrar cantantes");
            System.out.println("3. Eliminar un cantante");
            System.out.println("0. Salir");
            option = read.nextInt();
            read.nextLine();
            switch(option){
                case 1:
                    info = new CantanteFamoso();
                    System.out.println("Ingrese el nombre de cantante");
                    info.setNombre(read.nextLine());
                    System.out.println("Ingrese el nombre del disco");
                    info.setDiscoConMasVentas(read.nextLine());
                    list.add(info);
                    System.out.println("Agregado!");
                    break;
                case 2:
                    for (CantanteFamoso cant : list) {
                        System.out.println(cant);
                    }
                    break;
                case 3:
                    boolean deleted = false;
                    System.out.println("Ingrese el nombre del cantante que quiere borrar");
                    String aBorrar = read.nextLine();
                    deleted = list.removeIf(cant->cant.getNombre().equals(aBorrar));
                    if(deleted){
                        System.out.println("Elemento eliminado correctamente");
                    } else System.out.println("No hay un elemento con ese nombre");
            }
        }while(!exit);
    }
    
}
