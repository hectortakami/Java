
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
public class Bag <T> implements Collection <T> {
    
    private T[] bagArr;
    private int bagSize;
    
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
        if(bagSize<=0){
            return true;
        }
        return false;
        }

    @Override
    public boolean contains(Object item) {
        for (int i = 0; i < bagSize; i++) {
            if(bagArr[i].equals(item)){
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
            arr[i] = (Object) bagArr[i];
        }
        return arr;
        
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    //Añade un valor al arreglo de nuestra coleccion
    public boolean add (T item){
        if (bagSize >= bagArr.length){
            return false;
        }else{
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
    
    //Remueve un elemento del arreglo recorriendo el anterior
    private void remove (int i){
       for (int j = 0; j < bagSize-1; j++) {
           bagArr[j] = bagArr[j+1];           
       }
       bagSize--;
   }
    
    //Determina el indice donde se eliminara un item
    @Override
    public boolean remove(Object item) {
        for (int i = 0; i < bagSize; i++) {
            if(bagArr[i].equals(item)){
                remove(i);
                return true;
            }
            
        }
        return false;
    }
    
    //Selecciona un elemento aleatorio en nuestro arreglo si es que tiene valores
    public T grab(){
        if(bagSize==0){
            return null;
        }else{
            return bagArr[rnd.nextInt(bagSize)];
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
