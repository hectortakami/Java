
import java.util.Arrays;
import java.util.List;
import static javafx.scene.input.KeyCode.T;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hector
 */


public class Prueba {
    
    
    public static <T> void shuffle(T[] arr){
        T[] newArr = (T[])new Object[arr.length];
        Bag<T> gBag = new Bag(arr.length);  
        
        for (int i = 0; i < arr.length; i++) {
            gBag.add(arr[i]);
        }
        for (int i = 0; i < newArr.length; i++) {
            T gObj = gBag.grab();
            newArr[i] = gObj;
            gBag.remove(gObj);                       
        }
        System.out.println("Shuffle Method: " + Arrays.toString(newArr));
    }
    
    public static <T> void reverseByIndex(ArrayList<T> aList){
        int n = aList.size();
        int c = n;
        for (int i = 0; i < n; i++) {
            T scanDown = aList.get(i);
            T scanUp = aList.get(c-1);
            if(i < c-1){
                aList.set(i, scanUp);
                aList.set(c-1, scanDown);
            }
            c--;   
        }              
    }
    
    public static <T> ArrayList<T> reverseByCopy(ArrayList<T> aList){
        ArrayList<T> arr = new ArrayList<>();
        int c = 0;
        for (int i = aList.size(); i > 0; i--) {
            arr.add(c,aList.get(i-1));
            c++;
        }
        return arr;
    }
    
    public static<T extends Comparable<? super T>> void insertOrder(List<T> aList, T item) {
        aList.add(item);
        for (int i = 0; i < aList.size(); i++) {
            for (int j = i+1; j < aList.size(); j++) {
                if (aList.get(j).compareTo(aList.get(i)) < 0){
                    T temp = aList.get(i);
                    aList.set(i, aList.get(j));
                    aList.set(j, temp);
                }
            }            
        }            
    }
    
    public static void main(String[] args) {
        
        Integer[] iArr = {5,2,3,6,7,9,0};
        String[] sArr = {"Zeus","Poseidon","Ares","Chronos","Era","Athenea"};
        shuffle(iArr);
        shuffle(sArr);
        
        System.out.println("*************************************************************");
        
        OrderedBag<Integer> oB1 = new OrderedBag(5);
        oB1.add(12);
        oB1.add(2);
        oB1.add(1);
        System.out.println("Ordered Bag<Integer>: " + oB1.toString());
        oB1.add(96);
        oB1.add(10);
        System.out.println("Ordered Bag<Integer>: " + oB1.toString());
        System.out.println("- getFirst(): [" + oB1.getFirst() + "]");
        
        OrderedBag<String> oB2 = new OrderedBag(5);
        oB2.add("Mercury");
        oB2.add("Venus");
        oB2.add("Earth");
        System.out.println("Ordered Bag<String>: " + oB2.toString());
        oB2.add("Mars");
        oB2.add("Jupiter");
        System.out.println("Ordered Bag<String>: " + oB2.toString());
        System.out.println("- getLast(): [" + oB2.getLast() + "]");
        
        System.out.println("*************************************************************");
        
        System.out.println("ArrayList<String>");
        System.out.println("Insert a new String, type 'Done' to Finish");
        ArrayList<String> aL1 = new ArrayList<>();
        aL1.addString();
        
        System.out.println("*************************************************************");
        
        ArrayList<Integer> aList = new ArrayList<>();
        Integer[] arr = {9, 12, 6, 24, 16, 8, 3, 19, 11, 4};
        for (int i = 0; i < arr.length; i++) {
            aList.add(arr[i]);
        }        
        System.out.println("ArrayList " + aList.toString());
        System.out.println("ReverseByIndex Method: ");
        reverseByIndex(aList);
        System.out.println(aList.toString());
        
        ArrayList<Integer> bList = aList;        
        System.out.println("ReverseByCopy Method: ");
        bList = reverseByCopy(bList);
        System.out.println(bList.toString()); 
        bList = reverseByCopy(bList);
        System.out.println(bList.toString());
        
        System.out.println("*************************************************************");
        System.out.println("InsertOrder Method: ");
        ArrayList<Integer> cList = new ArrayList<>();
        insertOrder(cList, 12);
        insertOrder(cList, 5);
        System.out.println(cList.toString());
        insertOrder(cList, 6);
        System.out.println(cList.toString());
        insertOrder(cList, 4);
        System.out.println(cList.toString());
        insertOrder(cList, 30);
        System.out.println(cList.toString());
        insertOrder(cList, 16);
        System.out.println(cList.toString());

        System.out.println("InsertOrder Method: ");
        ArrayList<String> dList = new ArrayList<>();
        insertOrder(dList, "Hydrogen");
        insertOrder(dList, "Helius");
        System.out.println(dList.toString());
        insertOrder(dList, "Lithium");
        System.out.println(dList.toString());
        insertOrder(dList, "Berylium");
        System.out.println(dList.toString());
        insertOrder(dList, "Boron");
        System.out.println(dList.toString());
        insertOrder(dList, "Carbon");
        System.out.println(dList.toString());
    }
}
