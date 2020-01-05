
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Random;
import static javafx.scene.input.KeyCode.T;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author A01377647
 */
public class Bag<T> implements Collection<T> {

    private T[] bagArr;
    private int bagSize;

    private static Random rnd = new Random();

    public Bag() {
        bagSize = 0;
    }

    public Bag(int capacity) {
        bagArr = (T[]) new Object[capacity];
        bagSize = 0;
    }

    public void sieve(Integer L) {
        bagArr = (T[]) new Object[L - 1];
        
        for (Integer i = 2; i < L + 1; i++) {
            add((T) i);
        }
        
        //************************************
        
        for (int i = 0; i < bagArr.length; i++) {
            for (int j = i; j < bagArr.length; j++) {
                if ((Integer)bagArr[j] % (Integer)bagArr[i] == 0 && !bagArr[j].equals(bagArr[i])){
                    remove(bagArr[j]);
                    
                }
            }
        }
       
        
    }

      
    
     //Remueve un elemento del arreglo recorriendo el anterior
    private void remove(int e) {
        
        Object[] primos = new Object[bagSize-1];
        for (int i = 0; i < primos.length; i++) {
            if(i<e){
                primos[i] = bagArr[i];
            }else{
                primos[i] = bagArr[i+1];
            }            
        }
        bagArr = (T[])primos;
        bagSize--;             
    }

    //Determina el indice donde se eliminara un item
    @Override
    public boolean remove(Object item) {
        for (int i = 0; i < bagArr.length; i++) {
            if(bagArr[i].equals(item)){
                remove(i);
                return true;
            }
            
        }
        return false;
    }


    @Override
    public boolean contains(Object item) {
        for (int i = 0; i < bagSize; i++) {
            if (bagArr[i].equals(item)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return bagSize;
    }

    @Override
    public boolean isEmpty() {
        if (bagSize <= 0) {
            return true;
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
            arr[i] = (Object) bagArr[i];
        }
        return arr;

    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //Añade un valor al arreglo de nuestra coleccion
    public boolean add(T item) {
        if (bagSize >= bagArr.length) {
            return false;
        } else {
            bagArr[bagSize] = item;
            bagSize++;
            return true;
        }
    }

    @Override
    public void clear() {
        for (int i = 0; i < bagArr.length; i++) {
            remove(bagArr[i]);
        }
    }

   

    //Utiliza el metodo toArrays para regresar un arreglo como String
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

}
