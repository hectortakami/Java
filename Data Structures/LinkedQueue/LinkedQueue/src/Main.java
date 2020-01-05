
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
public class Main {

    private static void distribute(int[] arr, LinkedQueue[] digitQueue, int power) {
        int i;
        for (i = 0; i < arr.length; i++) {
            digitQueue[(arr[i] / power) % 10].push(arr[i]);
        }
    }

    private static void collect(LinkedQueue[] digitQueue, int[] arr) {
        int i = 0, digit;
        for (digit = 0; digit < 10; digit++) {
            while (!digitQueue[digit].isEmpty()) {
                arr[i] = (int) digitQueue[digit].pop();
                i++;
            }
        }
    }

    public static void radixSort(int[] arr, int d) {
        int i;
        int power = 1;
        LinkedQueue[] digitQueue = new LinkedQueue[10];
        for (i = 0; i < digitQueue.length; i++) {
            digitQueue[i] = new LinkedQueue();
        }
        for (i = 0; i < d; i++) {
            distribute(arr, digitQueue, power);
            collect(digitQueue, arr);
            power *= 10;
        }
        
    }
    
    public static void main(String[] args) {
        LinkedQueue<Integer> queue = new LinkedQueue<>();
        System.out.println("Queue Trial:");
        queue.push(4);
        queue.push(8);
        queue.push(12);
        queue.push(15);        
        int n = queue.size();
        for (int i = 0; i < n; i++) {
            System.out.println("-Pop: " + queue.pop());            
        }
        
        System.out.println("****************************************************");
        
        int[] arr = {385,522,2,79,0,931,64,128};
        radixSort(arr, 3);
        System.out.println("RadixSort Method: " + Arrays.toString(arr));

        
        
    }
}
