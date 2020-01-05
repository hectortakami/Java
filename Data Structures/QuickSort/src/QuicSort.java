
import java.util.Arrays;
import sun.security.util.Length;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author A01377647
 */
public class QuicSort {
    
    public static int pivotQS(int SD, int SU){
        int mid = (SD + SU)/2;
        return mid;
    }
    
    public static void qS(int[] arr, int SD, int SU){
       
        if (SD == SU || arr.length <= 2){
            
        }else{
            int mid = pivotQS(SD, SU);
            int pivot = arr[pivotQS(SD, SU)];
            int temp = pivot;
            int temp2 = arr[SD];
            pivot = temp2;
            arr[SD] = temp;
            for (int i = SD+1; i < SU; i++) {
                SD = i;
                if(arr[SD]>arr[mid] && arr[SU]<arr[mid]){
                    int SDc = arr[SD];
                    int SUc = arr[SU];
                    temp = SDc;
                    temp2 = SUc;
                    SDc = temp2;
                    SUc = temp;
                    
                }
                System.out.println(SD + "  " + arr[SD]);
                System.out.println(SU + "  " + arr[SU]);
                SU--;
            }
            

        }
       
    }
    
    public static void main(String[] args) {
        
        int[] arr = {500,600,150,400,650,900,50};
        qS(arr, 0, arr.length-1);
        
        
    }
    
}
