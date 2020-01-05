/*
Autor: Hector Takami
A01377647
 */

public class ConvertirBase {
    
    public static String dec2Bin(int n){
        String s = "";
        if(n==0){
           return s; 
        }else{
           return dec2Bin(n/2) + String.valueOf(n%2);
        }
       
    }
    
    public static String dec2Oct(int n){
        String s = "";
        if(n==0){
           return s; 
        }else{
           return dec2Bin(n/8) + String.valueOf(n%8);
        }
       
    }
    
    public static String dec2Hex(int n){
        String s = "0123456789ABCDEF";
        if(n==0){
           return s; 
        }else{
           return dec2Bin(n/16) + s.charAt(n%16);
        }
       
    }
    
}
