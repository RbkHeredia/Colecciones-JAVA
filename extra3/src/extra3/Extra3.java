/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package extra3;

import Entidades.Libro;
import Servicios.LibroServicio;
import java.util.HashSet;
import java.util.Scanner;

/**
 *
 * @author rebek
 * 
 * Implemente un programa para una Librería haciendo uso de un HashSet para evitar datos
repetidos. Para ello, se debe crear una clase llamada Libro que guarde la información de
cada uno de los libros de una Biblioteca. La clase Libro debe guardar
el título del libro, autor, número de ejemplares y número de ejemplares prestados.
También se creará en el main un HashSet de tipo Libro que guardará todos los libros
creados.
En el main tendremos un bucle que crea un objeto Libro pidiéndole al usuario todos sus
datos y seteandolos en el Libro. Despues, ese Libro se guarda en el conjunto y se le
pregunta al usuario si quiere crear otro Libro o no.
La clase Libro contendrá además los siguientes métodos:
Constructor por defecto.
Constructor con parámetros.
Métodos Setters/getters
Método prestamo(): El usuario ingresa el titulo del libro que quiere prestar y se lo busca
en el conjunto. Si está en el conjunto, se llama con ese objeto Libro al método. El
método se incrementa de a uno, como un carrito de compras, el atributo ejemplares
prestados, del libro que ingresó el usuario. Esto sucederá cada vez que se realice un
préstamo del libro. No se podrán prestar libros de los que no queden ejemplares
disponibles para prestar. Devuelve true si se ha podido realizar la operación y false en
caso contrario.
Método devolucion(): El usuario ingresa el titulo del libro que quiere devolver y se lo
busca en el conjunto. Si está en el conjunto, se llama con ese objeto al método. El
método decrementa de a uno, como un carrito de compras, el atributo ejemplares
prestados, del libro seleccionado por el usuario. Esto sucederá cada vez que se
produzca la devolución de un libro. No se podrán devolver libros donde que no tengan
ejemplares prestados. Devuelve true si se ha podido realizar la operación y false en
caso contrario.
Método toString para mostrar los datos de los libros.
 */
public class Extra3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        HashSet<Libro> biblioteca = new HashSet();
        LibroServicio ls = new LibroServicio();
        boolean exit = false;
        int option;
        do{
            System.out.println("1. Nuevo libro");
            System.out.println("2. Prestamo");
            System.out.println("3. Devolucion");
            System.out.println("4. Listar libros");
            System.out.println("5. Salir");
            option = read.nextInt();
            read.nextLine();
            switch(option){
                case 1: 
                    System.out.println("---------Nuevo libro---------");
                    biblioteca.add(ls.nuevoLibro());
                    break;
                case 2:
                    System.out.println("----------Prestamo----------");
                    System.out.println("Ingrese el libro a prestar");
                    String aPrestar = read.nextLine();
                    boolean ok = false;
                    for (Libro libro : biblioteca) {
                        if(libro.getTitulo().equals(aPrestar)){
                            ls.prestamo(libro);
                            ok = true;
                        }
                    }
                    if (!ok){
                        System.out.println("El libro no existe");
                    }
                    break;
                case 3:
                    System.out.println("------------Devolucion-----------");
                    System.out.println("Ingrese el libro a devolver");
                    String aDevolver = read.nextLine();
                    boolean dev = false;
                    for (Libro libro : biblioteca) {
                        if(libro.getTitulo().equals(aDevolver)){
                            ls.devolucion(libro);
                            dev = true;
                        }
                    }
                    if(!dev){
                        System.out.println("El libro no existe");
                    }
                    break;
                case 4:
                    for (Libro libro : biblioteca) {
                        System.out.println(libro);
                    }
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Opcion incorrecta");
                    break;
            }
        }while (!exit);
    }
    
}
