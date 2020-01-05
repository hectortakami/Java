/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmosordenamiento;

import java.util.Arrays;

/**
 *
 * @author Hector
 */
public class AlgoritmosOrdenamiento {

    public static void sort(int[] arr){
        
        //Busqueda de indice principal
        for (int i = 0; i < arr.length; i++) {
            int minIndex= i;
            //Busqueda de target
            for (int j = i+1; j < arr.length; j++) {
                if(arr[j]<arr[i]){
                    minIndex = j;
                }
            }
            //Intercambio de contenido en el arreglo
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
        System.out.println(Arrays.toString(arr));      
    }
    
    
    
    public static void main(String[] args) {
        int [] arr = {6,2,3,8,0,9};
        sort(arr);
    }
    
}
