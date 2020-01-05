
import java.util.Random;
import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
   public static void delaySec(){
       try {
           Thread.sleep(1000);
       } catch (InterruptedException ex) {
       }
   }
    
    public static void main(String[] args) {
        int i = 1;
        int j = 1;
        int capacity = 15;
        Random r = new Random();
        BQueue<Person> bq = new BQueue<>(capacity); 
        int personInLine = 0;
        
        while(true){            
            //Push with 20% of accuracy a person to the BQueue each 5 sec
            if (i>5){
                int n = r.nextInt(10);
                if (n==0||n==1 ){ //20% probability to add a Person                                        
                    //Dont push another person until the Queue has enough space for it
                    if((bq.size()+1)<=capacity){
                        personInLine++;
                        Person newPerson = new Person(personInLine);                        
                        bq.push(newPerson);   
                        System.out.println(newPerson.toString() + " has entered to the line");
                    }        
                }                
                i = 1;
            }            
            //Pop a person from the BQueue each 20 sec
            if (j==20){
                if (bq.isEmpty()==false){
                   System.out.println( bq.pop() + " abandoned the line");
                }               
                j=0;
            }
            i++;
            j++;
            delaySec();
        }      
    }
}
