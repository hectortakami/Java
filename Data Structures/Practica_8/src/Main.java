
import java.util.Arrays;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hector
 */
public class Main {
    public static void main(String[] args) {
       
        Random rnd = new Random();
        Node<Integer> front = null;
        Node<Integer> newNode ;
        for (int i = 0; i < 20; i++) {
            newNode = new Node<Integer>(rnd.nextInt(5));
            newNode.next = front;
            front = newNode;
        }            
             
        
        System.out.println("* LinkedList(Simple): " + toString(front));
        System.out.println("- Size Method: (" + size(front) + ") elements in List");
        swapFirstLast(front);
        System.out.println("- CountValue Method " + "(" + front.nodeValue + ")" + ": " + countValue(front, front.nodeValue));
        copy(front);
        insertOrder(front, rnd.nextInt(5));
        
        System.out.println("********************************************************************************************");
        
        int[] arr =  {6, 5, 1, 9, 8, -19, 1, 25, 13, 3};        
        
        DNode<Integer> header = new DNode<>();
        DNode<Integer> curr1 = header.next;
        for (int i = 0; i < arr.length; i++) {
            DNode<Integer> nDD = new DNode<>(arr[i]);
            curr1.next = nDD;
            nDD.next = header;
            nDD.prev = curr1;
            curr1 = curr1.next;
        }        
        System.out.println(toString(header));
        
        System.out.println("- RemoveMax Method: MAX(" + removeMax(header) + ") -> " + toString(header));
        removeRange(header.next.next.next, curr1.prev.prev);
        
        System.out.println("********************************************************************************************");
        
        int[] arr2 =  {2, 5, 5, 6, 7, 7, 7, 8, 9, 11, 13, 13, 13, 15, 15};
        
        DNode<Integer> h2 = new DNode<>();
        DNode<Integer> curr = h2.next;
        for (int i = 0; i < arr2.length; i++) {
            DNode<Integer> nDD = new DNode<>(arr2[i]);
            curr.next = nDD;
            nDD.next = h2;                   
            nDD.prev = curr;
            curr = curr.next;
        }
        
        System.out.println(toString(h2));
        removeOrderedDup(h2);
        
        System.out.println("********************************************************************************************");
        
        int[] arr3 =  {3, 5, 9, 15, 55, 22, 35, 47, 18, 9};
        
        DNode<Integer> h3 = new DNode<>();
        DNode<Integer> curr3 = h3.next;
        for (int i = 0; i < arr3.length; i++) {
            DNode<Integer> nDD3 = new DNode<>(arr3[i]);
            curr3.next = nDD3;
            nDD3.next = h3;                   
            nDD3.prev = curr3;
            h3.prev = nDD3;
            curr3 = curr3.next;
        }
        
        System.out.println(toString(h3));
        reverseList(h3);
    }
    
    public static <T> void reverseList(DNode<T> header){
        DNode<T> first = header.next;
        DNode<T> last = first;
        DNode<T> c = first;
        while (c != header){
            last = c;
            c = c.next;
        }                
        DNode<T> curr = header.prev;  
        DNode<T> temp;
        while (curr.nodeValue != last.next.nodeValue){
            temp = curr.next;
            curr.next = curr.prev;
            curr.prev = temp;
            curr = curr.prev;            
        }
        temp = curr.next;
        curr.next = curr.prev;
        curr.prev = temp;

        System.out.println("- ReverseList Method: " + toString(header));
        
    }
    
    public static <T> void removeOrderedDup(DNode<T> header){
        DNode<T> curr = header.next;
        while (curr.next != header){
            if (curr.nodeValue.equals(curr.next.nodeValue)){
                DNode<T> currNext = curr.next;
                DNode<T> currPrev = curr.prev;
                currPrev.next = currNext;
                currNext.prev = currPrev;
            }
            curr = curr.next;
        }
        System.out.println("- RemoveOrderedUp Method: -> " + toString(header));    
    }
     
    public static <T> void removeRange(DNode<T> first, DNode<T> last){
        DNode<T> curr = first;
        while (curr.next != last){
            DNode<T> prev = curr.prev;
            DNode<T> next = curr.next;
            prev.next = next;
            next.prev = prev;
            
            curr = curr.next;
        }
        System.out.println("- RemoveRange Method: " + toString(curr));
        
    }
    
     public static <T extends Comparable<? super T>> T removeMax(DNode<T> header){
        DNode<T> curr = header.next;
        DNode<T> maxNode = null;
        DNode<T> prevNode = null;
        T max = curr.nodeValue;
        DNode<T> prevValue = header;
        while(curr.next != header){
            if (curr.nodeValue.compareTo(max) > 0){
                max = curr.nodeValue;
                maxNode = curr;
                prevNode = prevValue;
                
            }
            curr = curr.next;
            prevValue = prevValue.next;
        }
        if (curr.nodeValue.compareTo(max) > 0){
                max = curr.nodeValue;
                maxNode = curr;
            }
        (maxNode.next).prev = prevNode;
        prevNode.next = maxNode.next;            
        return max;      
    }
     
    public static <T> String toString(DNode<T> header) {
        if (header.next == header)
            return "null";
        DNode<T> curr = header.next;
        String str = "[";        
        while (curr.next != header){
            if (curr.nodeValue == null){
                curr =curr.next;
            }
            str += curr.nodeValue + ", ";
            curr = curr.next;
        }
        str += curr.nodeValue + "]";
        
        return "* LinkedList(Doble): " + str;
        
       
    }    
   
    public static <T> String toString(Node<T> front) {
        if (front == null) {
            return "null";
        }
        Node<T> curr = front;
        String str = "[" + curr.nodeValue;
        while (curr.next != null) {
            curr = curr.next;
            str += ", " + curr.nodeValue;
        }
        str += "]";
        return str;
    }
    
    public static <T extends Comparable<? super T>> Node<T> insertOrder(Node<T> front, T item){
        Node<T> newNode = new Node<>(item);
        Node<T> prevNode = front;
        front = newNode;
        newNode.next = prevNode;
        Node<T> curr = front;
        
        while (curr != null){
           Node<T> temp = curr.next;
           while(temp != null){
               if (temp.nodeValue.compareTo(curr.nodeValue) < 0){
                   T t = curr.nodeValue;
                   curr.nodeValue = temp.nodeValue;
                   temp.nodeValue = t;
               }
               temp = temp.next;
           }
           curr = curr.next;
        }
        
        System.out.println("- InsertOredered Method (" + item + "): " + toString(front));        
        return front;
        
        
    
    }
    
    public static <T> Node<T> copy(Node<T> front){
        Node<T> newFront = front;        
        while(front.next != null ){
            Node<T> curr = new Node<>();
            curr = front;
            curr = front.next;
            front = front.next;
        }
        System.out.println("- Copy Method: " + toString(newFront));        
        return newFront;        
    }
    
    public static <T> int countValue(Node<T> front, Object item){
        Node<T> curr = front;
        int c = 0;
        if ((front.nodeValue).equals(item)){
            c++;
        }
        while (curr.next != null){ 
            if ((curr.nodeValue).equals(item)){
            c++;
            }
            curr = curr.next;
        }
        if ((curr.nodeValue).equals(item)){
            c++;
        }        
        return c;
    }
    
    public static <T> void swapFirstLast(Node<T> front){
        
        Node<T> first = front;
        Node<T> prevLast = first;
        Node<T> last = front.next;
        
        //Get the Last Node
        while(last.next != null){
            prevLast = last;
            last = last.next;
        }        
        //Exchange Node values between the First and Last
        
        T temp = last.nodeValue;
        T temp2 = front.nodeValue;
        front.nodeValue = temp;
        last.nodeValue = temp2;
        
        System.out.println("- SwapFirstLast Method: " + toString(front));
    }
    
    public static <T> int size(Node<T> front){
        
        if (front.next == null){
            return 0;
        }else{
            Node<T> curr = front;
            int c = 1;
            while (curr.next != null){
                c++;
                curr = curr.next;
            }
            return c;
        }
    }
    
}
