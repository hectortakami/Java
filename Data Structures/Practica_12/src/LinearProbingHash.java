
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hector
 */
public class LinearProbingHash<T> implements Collection<T>
{
    private int tam;  
    private T[] linearArray;
    private int[] keys;

    public LinearProbingHash() {
        tam = 10;
        linearArray = (T[]) new Object[tam];
        keys = new int[tam];
    }
    
    public LinearProbingHash(int size) {
        tam = size;
        linearArray = (T[]) new Object[tam];
        keys = new int[tam];

    }    
    
    @Override
    public int size() {
        return keys.length;
    }

    @Override
    public boolean isEmpty() {
        for (int i = 0; i < keys.length; i++) {
            if (keys[i]!= 0){
                return false;
            }            
        }
        return true;
    }
    

    @Override
    public boolean contains(Object o) {
        if (isEmpty()){
            throw new NullPointerException("LinearProbing.contains()");
        }
        int sKey = 0;
        try{
            sKey = Integer.parseInt(o.toString());
        }catch(NumberFormatException e){
            System.out.println(e);
        }
        
        for (int i = 0; i < keys.length; i++) {
            if (sKey == keys[i]){
                return true;
            }
            
        }
        return false;  
    
    }

    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object[] toArray() {
        return linearArray;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean add(T e) {
        int key = 0;
        boolean flag = false;
        try{
            key = Integer.parseInt(e.toString())%tam;
        }catch(NumberFormatException f){
            System.out.println(f);
        }
        
        if (contains(key) == false){
            linearArray[key] = e;
        }else{            
            for (int i = key+1; i < keys.length; i++) {
                if (keys[i] == 0){
                    keys[i] = key;
                    linearArray[i] = e;
                    flag = true;
                    return flag;
                }else{
                  
                }                
            }
            if (flag == false){
               for (int i = 0; i < key; i++) {
                if (keys[i] == 0){
                    keys[i] = key;
                    linearArray[i] = e;
                    flag = true;
                    return flag;
                }else{
                    
                    }    
                }
            }                    
        }
        return flag;

    }

    @Override
    public boolean remove(Object o) {
        int rKey = 0;
        if (!contains(o)){
            return false;
        }
        try{
           rKey = Integer.parseInt(o.toString());
        }catch(NumberFormatException e){
            System.out.println(e);
        }
        
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] == rKey){
                keys[i] = 0;
                linearArray[i] = null;
                return true;
            }            
        }
        return false;       
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear() {
        linearArray = null;
        keys = null;
    }

    @Override
    public String toString() {
        String str = "[";
        for (int i = 0; i < keys.length-1; i++) {
            str += keys[i] + "=" + linearArray[i] + ", " ;          
        }
        str += keys[tam-1] + "=" + linearArray[tam-1] + "]" ;    
        return str;
    }
    
    

}
