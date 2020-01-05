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
    
        
    public static int editDistance(String a, String b){
        
        
        if(a.length() == 0){
            return b.length();
        }else if(b.length() == 0){
            return a.length();
        } else{
            
            if(a.charAt(0) == b.charAt(0)){
                return 0 + editDistance(a.substring(1), b.substring(1));
            }else{
                return 1 + editDistance(a.substring(1), b.substring(1));
            }
            
        }

    }
    
    
    public static void main(String[] args) {
        
        System.out.println("No.Cambios: " + editDistance("kitten", "sitting"));
        
    }
    
}
