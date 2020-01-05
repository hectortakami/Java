
import java.util.Arrays;


public class Prueba {
    
    public static <T extends Comparable> void insertionSort(T[] arr, int n) {

        if (n == 0) {
            return;
        } else {
            for (int i = 1; i < arr.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (arr[i].compareTo(arr[j]) < 0) {
                        T temp = arr[j];
                        arr[j] = arr[i];
                        arr[i] = temp;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
    
   private static int max;

    public static <T extends Comparable> int max(T[] arr, int first, int last) {
        
        if((first+1)<last){
            int midPoint = (first+last)/2;
            max(arr, first, midPoint);
            max(arr, midPoint, last);
        }else{
            if(((arr[first].toString()).compareTo(arr[last].toString())>0) && (Integer.parseInt(arr[first].toString())>max)){
                max = Integer.parseInt(arr[first].toString());
            }
            if((arr[last].toString()).compareTo(arr[first].toString())>0 && (Integer.parseInt(arr[last].toString())>max)){
                max = Integer.parseInt(arr[last].toString());
            }
            
        } 
        return max;
    }
   
    
   
    
    
    

    public static void main(String[] args) {

        Integer[] arr = {25, 7, 19, 48, 12, 56, 30, 21, 28};
        String[] arr2 = {"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune"};
        Double[] arr3 = {5.3,69.9675,5.65,45.22,89.1,72.36,25.8,75.0,14.9,86.0,120.8,0.150,9.37};
        
        System.out.println("Maximum MergeSort Generics: \n");
        
        T <Integer> arrGen = new T<>();
        arrGen.setT(arr);
        System.out.println("Max value on Array: " + max(arrGen.getT(), 0, ((arrGen.getT()).length)-1));
        System.out.println("\n");
                
        System.out.println("Insertion Sort Generics:\n");
        
        System.out.println("-> Integer:");                
        T <Integer> arrG = new T<>();
        arrG.setT(arr);
        insertionSort(arrG.getT(), arrG.getT().length);
        System.out.println("\n");
        
        System.out.println("-> String:");
        T <String> arr2G = new T<>();
        arr2G.setT(arr2);
        insertionSort(arr2G.getT(), arr2G.getT().length);
        System.out.println("\n");
                
        System.out.println("-> Double:");
        T <Double> arr3G = new T<>();
        arr3G.setT(arr3);
        insertionSort(arr3G.getT(), arr3G.getT().length);
        System.out.println("\n");
        

        
    }

}
