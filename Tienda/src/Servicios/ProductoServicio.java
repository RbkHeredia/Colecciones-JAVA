/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author rebek
 */
public class ProductoServicio {
    HashMap<String, Double> productos = new HashMap();
    Scanner read = new Scanner(System.in);
    
    private void newProduct(){
        boolean exit = false;
        String name;
        Double price;
        System.out.println("Agregar producto");
        while(!exit){
            System.out.println("Ingresa el nombre del producto");
            name = read.nextLine();
            System.out.println("Ingresa el precio del producto");
            price = read.nextDouble();
            read.nextLine();
            productos.put(name, price);
            System.out.println("Desea agregar otro producto? Ingrese 'no' para salir");
            if(read.nextLine().equals("no")){
                exit = true;
            }
        }
    }
    
    private void mostrarProductos(){
        for (Map.Entry<String, Double> entry : productos.entrySet()) {
            String key = entry.getKey();
            Double value = entry.getValue();
            System.out.println("Producto: "+key);
            System.out.println("Precio: "+ value);
            System.out.println("------------------------");
        }
    }
    
    private boolean modificarProducto(String prod){
        for (String product : productos.keySet()) {
            Double newPrice;
            if(product.equals(prod)){
                System.out.println("Ingrese el nuevo precio");
                newPrice = read.nextDouble();
                read.nextLine();                
                productos.replace(prod, newPrice);
                return true;
            }
        }
        return false;
    }
    
    private boolean eliminarProducto(String prod){
        if(productos.remove(prod)!= null){
            return true;
        } 
        return false;
    }
    
    public void menu(){
        System.out.println("1. Nuevo producto");
        System.out.println("2. Ver productos");
        System.out.println("3. Modificar producto");
        System.out.println("4. Eliminar producto");
        System.out.println("0. Salir");
    }
    
    public void iniciarPrograma(){
        int option;
        do{
            menu();
            option = read.nextInt();
            read.nextLine();
            switch(option){
                case 1:
                    newProduct();
                    break;
                case 2:
                    mostrarProductos();
                    break;
                case 3:
                    System.out.println("Ingrese el nombre del producto que desea modificar");
                    boolean set = modificarProducto(read.nextLine());
                    if (set){
                        System.out.println("Producto modificado");
                    } else System.out.println("El producto no se encuentra en la lista");
                    break;
                case 4:
                    System.out.println("Ingrese el nombre del producto a borrar");
                    boolean del = eliminarProducto(read.nextLine());
                    if(del){
                        System.out.println("Producto eliminado");
                    } else System.out.println("No existe el producto");
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Respuesta incorrecta");
                    break;
            }
        } while (option !=0);
        System.out.println("Fin del programa");
    }
}
