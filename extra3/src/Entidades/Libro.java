/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author rebek
 */
public class Libro {
    private String titulo;
    private String autor;
    private Integer nroEjemplares;
    private Integer prestados;

    public Libro() {
    }

    public Libro(String titulo, String autor, Integer nroEjemplares, Integer prestados) {
        this.titulo = titulo;
        this.autor = autor;
        this.nroEjemplares = nroEjemplares;
        this.prestados = prestados;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Integer getNroEjemplares() {
        return nroEjemplares;
    }

    public void setNroEjemplares(Integer nroEjemplares) {
        this.nroEjemplares = nroEjemplares;
    }

    public Integer getPrestados() {
        return prestados;
    }

    public void setPrestados(Integer prestados) {
        this.prestados = prestados;
    }

    @Override
    public String toString() {
        return "Libro{" + "titulo=" + titulo + ", autor=" + autor + ", nroEjemplares=" + nroEjemplares + ", prestados=" + prestados + '}';
    }
    
    
}
