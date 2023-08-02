/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import entities.Pelicula;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author rebek
 */
public class PeliculaServices {
    Pelicula peli;
    ArrayList <Pelicula> peliculas = new ArrayList();
    Scanner read = new Scanner(System.in);
    
    
    private void crearPelicula(){
        peli = new Pelicula();
        System.out.println("Nueva Pelicula");
        System.out.println("¿Cual es el nombre de la pelicula?");
        peli.setTitulo(read.nextLine());
        System.out.println("¿Quien es el director de la pelicula?");
        peli.setDirector(read.nextLine());
        System.out.println("Que duracion tiene? (ingresar valor en horas)");
        peli.setDuracion(read.nextDouble());
        read.nextLine();
        peliculas.add(peli); 
    }
    
    private void menu(){
        System.out.println("Menu");
        System.out.println("1. Ver todas las peliculas");
        System.out.println("2. Ver las peliculas con una duracion mayor a 1hs");
        System.out.println("3. Ordenar de mayor a menor segun duracion");
        System.out.println("4. Ordenar de manor a mayor segun duracion");
        System.out.println("5. Peliculas ordenadas por titulo");
        System.out.println("6. Peliculas ordenadas por director");
        System.out.println("0. Salir");
    }
    
    private void verPeliculas(){
        for (Pelicula pelicula : peliculas) {
            System.out.println("Titulo: "+pelicula.getTitulo()+ ", director: "+ pelicula.getDirector()+ ", duracion: "+pelicula.getDuracion());
        }
    }
    
    private void pelisLargas(){
        for (Pelicula pelicula : peliculas) {
            if(pelicula.getDuracion()>1){
               System.out.println("Titulo: "+pelicula.getTitulo()+ ", director: "+ pelicula.getDirector()+ ", duracion: "+pelicula.getDuracion());
            }
        }
    }
    
    public void iniciarPrograma(){
        boolean exit = false;
        do{
            System.out.println("Inicio");
            crearPelicula();
            System.out.println("Desea agregar otra pelicula? Ingresa 0 para salir");
            if(read.nextLine().equals("0")){
                exit = true;
            }
        } while (!exit);
        int option;
        do{
            menu();
            option= read.nextInt();
            switch(option){
                case 1:
                    verPeliculas();
                    break;
                case 2:
                    pelisLargas();
                    break;
                case 3:
                    peliculas.sort(Comparator.comparingDouble(Pelicula::getDuracion).reversed());
                    verPeliculas();
                    break;
                case 4: 
                    peliculas.sort(Comparator.comparingDouble(Pelicula::getDuracion));
                    verPeliculas();
                    break;
                case 5:
                    peliculas.sort(Comparator.comparing(Pelicula::getTitulo));
                    verPeliculas();
                    break;
                case 6: 
                    peliculas.sort(Comparator.comparing(Pelicula::getDirector));
                    verPeliculas();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("opcion incorrecta, ingrese una nueva opcion");
                    break;
            }
        } while(option != 0);
        System.out.println("Finalizado");
    }
    
}
