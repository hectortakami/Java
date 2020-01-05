
import java.util.LinkedList;
import java.util.ListIterator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hector
 */
public class Ejercicio1 {      

    public Ejercicio1() {
        System.out.println("*Excercise #1:" );        
        String[] strArr = {"generic", "Java", "if", "array", "LinkedList", "for", "iterator"};
        LinkedList<String> strList = new LinkedList<>();
        
        for (int i = 0; i < strArr.length; i++) {
            strList.add(strArr[i]);            
        }
        System.out.println("*LinkedList: " + strList.toString());
        
        ListIterator<String> iter = strList.listIterator();
        System.out.println("a)Print the elements with >4 characters on a LinkedList");
        while (iter.hasNext()){
            String str = iter.next();
            if (str.length()>4){
                System.out.println("  -" + str);
            }
        }
        System.out.println("b)Change to UpperCase all the elements with <4 characters on a LinkedList");
        ListIterator<String> iter2 = strList.listIterator();
        while (iter2.hasNext()){
            String str = iter2.next();
            if (str.length()<=4){
                str = str.toUpperCase();
                strList.set(iter2.nextIndex()-1, str);
            }
        }
        System.out.println( "  -" + strList.toString());
      
        
        
    }
        
        
}
