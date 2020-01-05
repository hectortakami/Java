
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
public class Practica6 {
    
    
    public static <T extends Comparable<? super T>> void insertionSort(T[] arr, int first, int last) {
        int i,j,n = arr.length;
        T target;
        for (i = first; i < last; i++) {
            j = i;
            target = arr[i];
            while (j > 0 && target.compareTo(arr[j - 1]) < 0) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = target;
        }
        String arreglo = "The Array starts in: [";
        for (int k = 0; k < 10; k++) {
            arreglo += arr[k] + ",";            
        }arreglo += "...] an ends with [...";
        int c = 0;
        for (int k = arr.length-10; k < arr.length-1; k++) {            
            arreglo += arr[k] + ","; 
        }arreglo += arr[arr.length-1] + "]";
        System.out.println(arreglo);
        
    }
    
    public static <T extends Comparable<? super T>>int pivotIndex(T[] arr, int first, int last){
        int mid, scanUp, scanDown;
        T pivot, temp;
        if (first == last) {
            return last;
        } else if (first == last - 1) {
            return first;
        } else {
            mid = (last + first) / 2;
            pivot = arr[mid];
            arr[mid] = arr[first];
            arr[first] = pivot;
            scanUp = first + 1;
            scanDown = last - 1;
            for (;;) {
                while (scanUp <= scanDown && arr[scanUp].compareTo(pivot) < 0) {
                    scanUp++;
                }
                while (pivot.compareTo(arr[scanDown]) < 0) {
                    scanDown--;
                }
                if (scanUp >= scanDown) {
                    break;
                }
                temp = arr[scanUp];
                arr[scanUp] = arr[scanDown];
                arr[scanDown] = temp;
                scanUp++;
                scanDown--;
            }
            arr[first] = arr[scanDown];
            arr[scanDown] = pivot;
            return scanDown;
        }
    }
    
    private static <T extends Comparable<? super T>> void qsort15(T[] arr, int first, int last) {
        int pivotLoc;
        T temp;
        if (last - first <= 1) {
            return;
        } else if (last - first == 2) {
            if (arr[last - 1].compareTo(arr[first]) < 0) {
                temp = arr[last - 1];
                arr[last - 1] = arr[first];
                arr[first] = temp;
            }
            return;
        } else if (arr.length <=15){
            pivotLoc = pivotIndex(arr, first, last);
            qsort15(arr, first, pivotLoc);
            qsort15(arr, pivotLoc + 1, last);
        } else{
            insertionSort(arr, first, last);
        }
    }
    
    public static Integer[] llenarArrayAleatorio(int desde, int hasta, int tam) {
        Integer[] numeros = new Integer[tam];
        Random rnd = new Random();
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = rnd.nextInt(hasta - desde + 1) + desde;
        }
        return numeros;
    }
   
    
    public static <T extends Comparable<? super T>> String seqSearchGen(T[] arr, T target, int first, int last){
        
        for (int i = first; i < last; i++) {
            if (arr[i].compareTo(target)==0) {
                 return "Secuencial Search: the value " + target + " IS in index [" + i + "]";
            }
        }
        return "Secuencial Search: the value '" + target + "' IS NOT in Array " + "into [" + first + "," + last + "]";
    }
    
    
    public static <T extends Comparable<? super T>> String binSearchGen(T[] arr, T target, int first, int last){
        int mid;
        T midValue;
        while (first < last) {
            mid = (first + last) / 2;
            midValue = arr[mid];
            if (target.compareTo(midValue)==0) 
            {
               return "Binary Search: the value " + target + " IS in index [" + mid + "]";
            } 
            else if (target.compareTo(midValue)<0) {
                last = mid;
            } else {
                first = mid + 1;
            }
        }
        return "Binary Search: the value '" + target + "' IS NOT in Array parameters " ;
    }
    
    public static <T extends Comparable<? super T>> void selectionSortGen(T[] arr){
        
        int smallIndex;
        int pass, j, n = arr.length;
        T temp;
        for (pass = 0; pass < n - 1; pass++) {
            smallIndex = pass;

            for (j = pass + 1; j < n; j++) {
                if (arr[j].compareTo(arr[smallIndex])<0) {
                    smallIndex = j;
                }
            }
            temp = arr[pass];
            arr[pass] = arr[smallIndex];
            arr[smallIndex] = temp;
        }
        System.out.println("Selection Sort: " + Arrays.toString(arr));
        
    }
    
    public static <T extends Comparable<? super T>> void insertionSortGen(T[] arr) {

        int i, j, n = arr.length;
        T target;
        for (i = 1; i < n; i++) {
            j = i;
            target = arr[i];
            while (j > 0 && target.compareTo(arr[j - 1]) < 0) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = target;
        }
        System.out.println("Insertion Sort: " + Arrays.toString(arr));
    }
    
    public static void main(String[] args) {
        Integer[] arr = llenarArrayAleatorio(0, 4999, 1000);
        
        qsort15(arr, 0, arr.length);
        
        System.out.println("*");
        
        System.out.println(seqSearchGen(arr, 25, 0, 500));
        System.out.println(seqSearchGen(arr, 692, 121, 785));
        System.out.println(seqSearchGen(arr, 3485, 0, arr.length));
        
        System.out.println("*");
        
        System.out.println(binSearchGen(arr, 777, 0, arr.length));
        System.out.println(binSearchGen(arr, 4012, 610, arr.length));
        System.out.println(binSearchGen(arr, 200, 10, 490));
        
        System.out.println("*");
        
        selectionSortGen(arr);
        insertionSortGen(arr);
    }
    
}
