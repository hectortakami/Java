/*
Autor: Hector Manuel Takami Flores
A01377647
 */
public class Search {
    
    public static String lastIndexOf(int[] arr, int fromIndex, int target){
        String index = "";
        for (int i = fromIndex; i < arr.length; i++) {
            if (arr[i] == target){
                index += i + " ";
            }
        }
        if(index.equals("")){
            index = "-1";
        }
        return index;
    }
    
    public static int seqSearch(int[] arr, int first, int last, int target){
        int flag = 0;
        for (int i = first; i < last; i++) {
            if (target==arr[i]){
                flag = 1;
            }
        }
        if(flag == 1){
            return 0;
        }else{
            return -1;
        }
    }
    
    public static boolean isUnique(int[] arr, int target){
        if(seqSearch(arr, 0, arr.length, target) != -1){
            int counter = 0;
            for (int i = 0; i < arr.length; i++) {
                 if(arr[i] == target){
                     counter++;
                 }                
            }
            if(counter == 1){
               return true; 
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
    
    public static int numUnique(int[] arr){
        int countUnique = 0;
        for (int i = 0; i < arr.length; i++) {
            if(isUnique(arr, arr[i]) == true){
               countUnique++;
            }
        }
        return countUnique;
    }
    
       
    
    public static void main(String[] args) {
        
        int[] list = {2, 5, 3, 5, 4, 7, 5, 1, 8, 9};
                
        System.out.println(lastIndexOf(list, 0, 5));
        System.out.println(lastIndexOf(list, 5, 4));
        System.out.println(lastIndexOf(list, 6, 1));
        
        System.out.println("****************************************************");
        
        System.out.println(seqSearch(list, 0, 10, 9));
        System.out.println(seqSearch(list, 0, 9, 9));
        System.out.println(seqSearch(list, 5, 6, 7));
        
        System.out.println("****************************************************");
        
        System.out.println(isUnique(list, 4));
        System.out.println(isUnique(list, 5));
        
        System.out.println("****************************************************");
        
        int[] intVals = {3, 1, 5, 1, 9, 5, 7, 2, 3, 8, 4};
        System.out.println(numUnique(intVals));
    }
}