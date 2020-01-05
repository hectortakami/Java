
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author A01377647
 */
public class Colecciones {
    
    public static void main(String[] args) {
        Bag<Integer> bolsa = new Bag<Integer>(10);
        
        System.out.println("ADD:");
        bolsa.add(new Integer (1));
        bolsa.add(new Integer (2));
        bolsa.add(new Integer (3));
        bolsa.add(new Integer (4));
        bolsa.add(new Integer (5));
        
        System.out.println(bolsa);
        
        System.out.println("\nREMOVE:");
        
        bolsa.remove(1);
        System.out.println(bolsa);
        
                
        System.out.println("\nSIZE: " + bolsa.size());
        System.out.println("IS EMPTY: " + bolsa.isEmpty());
        System.out.println("CONTAINS 2?: " + bolsa.contains(2));
        
        System.out.println("\nCLEAR:");
        
        bolsa.clear();
        System.out.println(bolsa);
        
        ArrayList<String> a = new ArrayList();
        a.add("Hola");
        a.add("Mundo");
        ArrayList<String> b = (ArrayList<String>)a.clone();
       
        b.add("GGG");
        
        a.toString();
        b.toString();
        
        
        
        
        
    }
    
}
