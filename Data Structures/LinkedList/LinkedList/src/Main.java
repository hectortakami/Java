
import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author A01377647
 */
public class Main {
    
    public static <T> String toString(Node<T> front) {
        
        if (front == null) {
            return "null";
        }

        Node<T> curr = front;
        // start with the left bracket and
        // value of first node 
        String str = "[" + curr.nodeValue;
        // append all but last node, separating
        // items with a comma polymorphism calls 
        // toString() for the nodeValue type 
        while (curr.next != null) {
            curr = curr.next;
            str += ", " + curr.nodeValue;
        }
        str += "]";
        return str;

    }
    
    public static void main(String[] args) {
        
       /* Node <String> front;
        Node <String> n1 = new Node<>("a");
        Node <String> n2 = new Node<>("b");
        Node <String> n3 = new Node<>("c");
        Node <String> n4 = new Node<>("b");
        Node <String> n5 = new Node<>("a");
        
        //Asignamos referencias
        front = n1;        
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        
         
        System.out.println(toString(front));
        
        
        LinkedList<String> aList = new  LinkedList<String>();
        aList.add("Red");
        aList.add("Blue");
        aList.add("Green");
        
        System.out.println( aList.toString());
        System.out.println("Contains White? " + aList.contains("White"));
        
        aList.add("Black");
        aList.remove("Blue");
        System.out.println(aList.toString());
        
        System.out.println("IsPal?: " + isPalindrome(aList));*/
       
      
        
    }
    
    public static <T> boolean isPalindrome(LinkedList<T> list) {
        while (list.size() > 1) {  
            if (list.getFirst().equals(list.getLast()) == false) {
                return false;
            }
            list.removeFirst();
            list.removeLast();
        }
        return true;
    }
}
