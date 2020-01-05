
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author A01377647
 */
public class NewClass<T>{
    
   
    
    public static String generatePalindrome(int nChars){
        String s = "abcdefghijklmnopqrstuvwxyz123456789";
        char[] arr = s.toCharArray();
        LinkedList<Character> list;
        list = new LinkedList<>();        
        Random r = new Random();
        
        String str = "";
        for (int i = 0; i < nChars; i++) {
           int n = r.nextInt(s.length());
           list.add(arr[n]);
           str += list.get(i);
        }
        
        ListIterator rev = list.listIterator(list.size());
        while (rev.hasPrevious()){
            str += rev.previous();
        }       
        
        
        return "- generatePalindrome Method: " +  str;
    }
    
    public static <T> void insertList(LinkedList<T> aList, LinkedList<T> bList, int pos){
        String temp = aList.toString(); 
        ListIterator<T> aIter = aList.listIterator(pos);
        ListIterator<T> bIter = bList.listIterator();
        
        
        while (bIter.hasNext()){
            aList.add(bIter.next());
        }
        
        System.out.println("- InsertList Method: " + temp + " + " + bList.toString() + " = " + aList.toString() );
        
    }
    
    public static void main(String[] args) {
        
        
        System.out.println(generatePalindrome(5));
        
        Random r = new Random();
        
        LinkedList<String> listA, listB;
        listA = new LinkedList<>(); 
        listB = new LinkedList<>(); 
        
        listA.add("Mercury");
        listA.add("Venus");
        listA.add("Earth");
        listA.add("Mars");
        listA.add("Jupiter");
        
        System.out.println(listA.toString());
        
        listB.add("Saturn");
        listB.add("Uranus");
        listB.add("Neptune");
        
        insertList(listA, listB, listA.size()-1);
        
        
        
        
        
       
        
    }
}
