/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica_9;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 *
 * @author Hector
 */
public class Practica_9 {

    public static <T> void replace(LinkedList<T> aList, T findItem, T replItem){
        ListIterator<T> iter = aList.listIterator();
        while (iter.hasNext()){
            if (iter.next().equals(findItem)){
                aList.set(iter.nextIndex()-1, replItem);
            }
        }
        
        System.out.println("- Replace Method: (" + findItem + ") --> (" + replItem + ") " + aList.toString());
    }
    
    public static <T extends Comparable<? super T>> void sortListD(LinkedList<T> list){
        ListIterator iter = list.listIterator(list.size());
        Object[] arr = list.toArray();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
               if ((arr[j].toString()).compareTo(arr[i].toString()) > 0){
                   Object temp = arr[i];
                   arr[i] = arr[j];
                   arr[j] = temp;
               }    
            }
        }
        int i = list.size()-1;
        while(iter.hasPrevious()){
            list.set(iter.previousIndex(), (T)arr[i]);
            i--;
            iter.previous();
        }
        
        System.out.println("- SortList Descendent: " + list.toString());
              
    }
    
    public static <T extends Comparable<? super T>> void sortListA(LinkedList<T> list){
        ListIterator iter = list.listIterator();
        Object[] arr = list.toArray();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
               if ((arr[j].toString()).compareTo(arr[i].toString()) < 0){
                   Object temp = arr[i];
                   arr[i] = arr[j];
                   arr[j] = temp;
               }    
            }
        }
        int i = 0;
        while (iter.hasNext()){
            int index = iter.nextIndex();
            list.set(index, (T)arr[i]);
            i++;
            iter.next();
        }
        System.out.println("- SortList Ascendent: " + list.toString());
        
        
    }


    public static void main(String[] args) {
     
        LinkedList<String> list1 = new LinkedList();
        String[] str = {"half", "before", "half", "before", "eight"};
        
        for (int i = 0; i < str.length; i++) {
            list1.add(str[i]);            
        }        
        System.out.println("LinkedList: " + list1.toString());
        replace(list1, "before", "past");
        
        System.out.println("*********************************************************************");
        
        LinkedList<Integer> list2 = new LinkedList();
        Integer[] arr = {-15, 5, 35, -19, -12, 17, -4};
        
        for (int i = 0; i < arr.length; i++) {
            list2.add(arr[i]);            
        }        
        System.out.println("LinkedList: " + list2.toString());
        ListIterator iter = list2.listIterator();
        while (iter.hasNext()){
            int n = (Integer)iter.next();
            if (n<0){
                list2.set(iter.nextIndex()-1, n*-1);
            }
        }
        System.out.println("LinkedList: " + list2.toString());
        
        System.out.println("*********************************************************************");
        
        LinkedList<String> list3 = new LinkedList();
        String[] str2 = {"Tom","Ann","Phil","Bill","Andy","David","Heather","Bryce","Richard"};
        for (int i = 0; i < str2.length; i++) {
            list3.add(str2[i]);            
        }
        System.out.println("LinkedList: " + list3.toString());
        sortListA(list3);
        sortListD(list3);



    }
}

