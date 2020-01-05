
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hector
 */
public class Recursividad {
    
    public static String numToNames(int n){
        char[] nArray = (""+n).toCharArray();
       
        String[] nString = {"zero ","one ","two ","three ","four ","five ","six ","seven ","eight ","nine "};
        if (nArray.length==1){
            return nString[n];
        }else {          
            return numToNames(n/10) + numToNames(n%10);
        }           
    }
    
    public static boolean isPal(String str, int startIndex, int endIndex){
        
        String[] s = str.split("");
        
        if (startIndex>=endIndex-1){
            return true;
        } 
        else if (!s[startIndex].equals(s[endIndex-1])){
            return false;
        } 
        else {
            return isPal(str, startIndex+=1, endIndex-=1);
        }
    }

    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        System.out.println("Escribe un entero positivo: ");
        int numero = x.nextInt();
        System.out.println(numToNames(numero));

        System.out.println("\n****************************************************\n");
        
        System.out.println("Palindromo: " + isPal("amanaplanacanalpanama", 0, 21));
        System.out.println("Palindromo: " + isPal("gohangasalamiimalasagnahog", 0, 26));
        System.out.println("Palindromo: " + isPal("abcdecba", 0, 8));
        
        System.out.println("\n****************************************************\n");
        
        Scanner p = new Scanner(System.in);
        System.out.println("\nEscribe 5 palabras para probar si son palíndromos: \n*Primera:");
        String str = p.nextLine();
        System.out.println(isPal(str.toLowerCase(), 0, str.length()));
        System.out.println("\n*Segunda: ");
        String str2 = p.nextLine();
        System.out.println(isPal(str2.toLowerCase(), 0, str2.length()));
        System.out.println("\n*Tercera: ");
        String str3 = p.nextLine();
        System.out.println(isPal(str3.toLowerCase(), 0, str3.length()));
        System.out.println("\n*Cuarta: ");
        String str4 = p.nextLine();
        System.out.println(isPal(str4.toLowerCase(), 0, str4.length()));
        System.out.println("\n*Quinta: ");
        String str5 = p.nextLine();
        System.out.println(isPal(str5.toLowerCase(), 0, str5.length()));
        
    }
    
}
