/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import entities.Alumno;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author rebek
 */
public class AlumnoService {
    Alumno al;
    ArrayList<Alumno> alumnos = new ArrayList();
    Scanner read = new Scanner(System.in);
    
    public Alumno crearAlumno(){
        al  = new Alumno();
        System.out.println("Ingrese el nombre del alumno");
        al.setNombre(read.nextLine());
        ArrayList<Integer> notas = new ArrayList();
        for (int i = 0; i < 3; i++) {
            System.out.println("Ingrese una nota");
            notas.add(read.nextInt());
        }
        read.nextLine();
        al.setNotas(notas);
        alumnos.add(al);
        return al;
    }
    
    public double promedio(ArrayList<Integer> notas){
        double prom = 0;
        for (Integer nota : notas) {
            prom+=nota;
        }
        return prom/3;
    }
    
    public void notaFinal(){
        System.out.println("Calcular promedio");
        System.out.println("Ingrese el nombre del alumno que desea calcular");
        String nombre = read.nextLine();
        for (Alumno alumn : alumnos) {
            if(alumn.getNombre().equals(nombre)){
                double prom = promedio(alumn.getNotas());
                System.out.println("El promedio de las notas es: "+ prom);
                
            }
        }
    }
    
    public void iniciarPrograma(){
        String exit;
        do{
            crearAlumno();
            System.out.println("Desea agregar otro alumno? Presione 0 para salir");
            exit = read.nextLine();
        }while(!exit.equals("0"));
        notaFinal();
    }
}
