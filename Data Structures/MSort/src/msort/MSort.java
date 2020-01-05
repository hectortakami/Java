/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package msort;

/**
 *
 * @author A01377647
 */
public class MSort {
    
    
    public static void msort(Object[] arr, Object[] tempArr, int first, int last ){
        if(first+1 < last){
            int midpt = (first+last)/2;
            msort(arr, tempArr, first, midpt);
            msort(arr, tempArr, midpt, last);
            if (((Comparable)arr[midpt-1]).compareTo 
            (arr[midpt]) <= 0)
            return;
        int indexA, indexB, indexC;
        indexA = first; indexB = midpt; indexC = first;
        while (indexA < midpt && indexB < last) { 
            if (((Comparable)arr[indexA]).compareTo (arr[indexB]) < 0) { 
                tempArr[indexC] = arr[indexA];
                indexA++;
            }
        }
        else { 
             tempArr[indexC] = arr[indexB]; 
             indexB++; } 
             indexC indexC++;
}


    }

    public static void sort (Object[] arr){
        Object[] tempArr = arr.clone();
        msort(arr, tempArr, 0, arr.length);
        
    }
    
    public static void main(String[] args) {
        int[] arr = {5,6,9,8,4,1};
    }
    
}
