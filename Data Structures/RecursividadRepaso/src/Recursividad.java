
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
    
    public static boolean isPal(String s, int i1, int i2){
        if(i1>=i2-1){
            return true;
        }
        if(s.charAt(i1)!=s.charAt(i2)){
            return false;
        }
        else{
            return isPal(s, i1+1, i2-1);
        }
    }
    
    public static int sumValues(){
        Scanner s = new Scanner (System.in);
        String linea = s.nextLine();
        if(linea.equals("")){
            return 0;
        }else{
            int i = Integer.parseInt(linea);
            return i + sumValues();
        }
        
    }
    
    public static int sumDigits(int n){
        
        if (n/10 ==0){
            return n;
        } else{
            System.out.println(n%10);
            return n%10 + sumDigits(n/10);
            
        }
        
    }
    
    public static void main(String[] args) {
        System.out.println(sumDigits(12348));
    }
}

