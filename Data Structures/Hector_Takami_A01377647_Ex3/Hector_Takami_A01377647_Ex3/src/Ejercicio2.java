
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.IllegalFormatException;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hector
 */
public class Ejercicio2 {
    
   
    public static ArrayList<Customer> readFile (String filename){
        ArrayList<Customer> arrList = new ArrayList();
        
        try {
            Scanner sc = new Scanner(new FileReader(filename));           
            int n = 1;
            while(sc.hasNextLine()){
                String[] client = sc.nextLine().split(",");
                try{
                   int ID = Integer.parseInt(client[0]);
                   int discount = Integer.parseInt(client[2]);
                   Customer c = new Customer(ID, client[1], discount);   
                   arrList.add(c);
                   n++;     
                  
                }catch (Exception e){
                    e.printStackTrace();  
                    break;
                }
            }
        sc.close();          
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Ejercicio2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return arrList;
    }
    
    public static <T extends Comparable<? super T>> void split(List<T> oList, List<T> maxList, List<T> minList, T target){
        ListIterator<T> iter = oList.listIterator();
        while (iter.hasNext()){
            T item = iter.next();
            if (item.compareTo(target)>0){
                maxList.add(item);
            }else if (item.compareTo(target)<0){
                minList.add(item);
            }
        } 
    }
    
    public static <T> String listToString (List<T> clist, int index, String str){
        if (clist.isEmpty()){
            return null;
        }
        ListIterator iter = clist.listIterator(index);
        if (iter.hasNext()){
            String line = (iter.next()).toString();
            str+= line + " " + listToString(clist, index+1, str);
        }else{
            
        }
        return str;
    }

    
    public void main(){
        System.out.println("*Excercise #2:");
        List<Customer> clients = new ArrayList<>();
        clients = readFile("src/Customers.txt");
        
        System.out.println("a) CompareTo Implementation (by CustomerID):");
        System.out.println("   -" + clients.get(2).toString() + " compareTo " + clients.get(5).toString() + ": " + clients.get(2).compareTo(clients.get(5)) );
        System.out.println("   -" + clients.get(3).toString() + " compareTo " + clients.get(7).toString() + ": " + clients.get(3).compareTo(clients.get(7)) );
        System.out.println("   -" + clients.get(8).toString() + " compareTo " + clients.get(8).toString() + ": " + clients.get(8).compareTo(clients.get(8)) );
        
        System.out.println("b) Equals Method (by CustomerID and CustomerName):");
        System.out.println("   -" + clients.get(4).toString() + " equals " + clients.get(6) + ":" + clients.get(4).equals(clients.get(6)));
        System.out.println("   -" + clients.get(9).toString() + " equals " + clients.get(9) + ":" + clients.get(9).equals(clients.get(9)));
        
        List<Customer> maxList = new ArrayList<>();
        List<Customer> minList = new ArrayList<>();        
        System.out.println("c) Split Method:\n   Item:" + clients.get(0));
        split(clients, maxList, minList, clients.get(0));
        System.out.println("   -MaxList: " + listToString(maxList, 0, ""));
        System.out.println("   -MinList: " + listToString(minList, 0, ""));
        
        System.out.println("d) ListToString Method:\n   " + listToString(clients, 0, ""));
        
        System.out.println("e) Implementation");
        
        
        
        
        
       
    }
    
}
