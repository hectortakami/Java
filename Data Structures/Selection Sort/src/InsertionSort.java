
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author A01377647
 */
public class InsertionSort {
    
public void insertionSort(int[] arr) { 
    
    
    for (int i = 0; i < arr.length; i++) {
        int pointer1 = i;
        int contentP1 = arr[i];
        for (int j = i+1; j < arr.length; j++) {
            int pointer2 = j;
            while(arr[pointer2]<arr[pointer1]){
                arr[i] = arr[j];
                arr[j] = contentP1;  
            }
            
            
        }
            
        }
    System.out.println(Arrays.toString(arr));
    }

}
    

