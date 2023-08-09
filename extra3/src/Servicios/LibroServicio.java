/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Entidades.Libro;
import java.util.HashSet;
import java.util.Scanner;

/**
 *
 * @author rebek
 */
public class LibroServicio {
    Scanner read = new Scanner(System.in);
    public Libro nuevoLibro(){
        Libro book = new Libro();
        System.out.println("Nombre del libro");
        book.setTitulo(read.nextLine());
        System.out.println("Autor del libro");
        book.setAutor(read.nextLine());
        System.out.println("Cantidad de ejemplares");
        book.setNroEjemplares(read.nextInt());
        read.nextLine();
        System.out.println("Cantidad de libros prestados");
        book.setPrestados(read.nextInt());
        read.nextLine();
        return book;
    }
    
    public void prestamo(Libro l1){
        if(l1.getNroEjemplares()>l1.getPrestados()){
            l1.setPrestados(l1.getPrestados()+1);
            System.out.println("Cargado correctamente");
        } else System.out.println("No hay libros para prestar");
    }
    
    public void devolucion(Libro l1){
        if(l1.getPrestados()>0){
            l1.setPrestados(l1.getPrestados()-1);
            System.out.println("Devuelto correctamente");
        } else System.out.println("No hay libros para devolver");
    }
    
    
}
