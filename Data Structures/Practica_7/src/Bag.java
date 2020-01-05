
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hector
 */
public class Bag<T> implements Collection<T> {
    
    protected T[] bagArr;
    protected int bagSize;
    private static Random rnd = new Random();

    public Bag(int capacity) {
        bagArr = (T[])new Object [capacity];
        bagSize = 0;
        
    }
    
    

    @Override
    public int size() {
        return bagSize;
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < bagSize-1; i++) {
            if(bagArr[i].equals(o)){
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
        Object[] arr = new Object[bagSize];
        for (int i = 0; i < bagSize; i++) {
            arr[i] = (Object)bagArr[i];            
        }
        return arr;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public T grab(){
        if(bagSize==0){
            return null;
        }else{
            return bagArr[rnd.nextInt(bagSize)];
        }
    }

    @Override
    public boolean add(T e) {
        
        if(bagSize>=bagArr.length){
            return false;
        }else{
           bagArr[bagSize]  = e;           
           bagSize++;
           return true;
        }
    }
    
    private void remove (int i){            
        for (int j = 0; j < bagSize-1; j++) {
            if(j>=i){
                bagArr[j] = bagArr[j+1];
            }
          
        }
        bagSize--;
    }

    @Override
    public boolean remove(Object o) {
        
        for (int i = 0; i < bagSize; i++) {
            if (bagArr[i].equals(o)){                
                remove(i);
                return true;
            }            
        }
        return false;
    }

    @Override
    public String toString() {
        Object[] arr = toArray();
        return Arrays.toString(arr);
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
