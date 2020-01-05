
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
Autor: hector manuel Takami Flores
A01377647
 */
public class ArrayList<T> implements List<T>, Cloneable {
    
    private T[] array;
    private int listSize;

    public ArrayList() {
        
        array = (T[]) new Object[10];
        listSize = 0;
        
    }
    
    public Object clone() {
        ArrayList<T> copy = null;

        try {
            copy = (ArrayList<T>) super.clone();
            copy.array = (T[]) new Object[listSize];

            for (int i = 0; i < listSize; i++) {
                copy.array[i] = array[i];

            }
            
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(ArrayList.class.getName()).log(Level.SEVERE, null, ex);
        }
        return copy;

    }

    @Override
    public String toString() {
        Object[] objArr = toArray();
        return Arrays.toString(objArr);
    }
    
    
    
    public void ensureCapacity(int minCapacity){
        
        int currentCapacity = array.length;
        if(minCapacity > currentCapacity){
            T[] oldListArray = array;
            array = (T[]) new Object[minCapacity];
            for (int i = 0; i < listSize; i++) {
                array[i] = oldListArray[i];                
            }
            oldListArray = null;
        }
    }
    
    private void rangeCheck(int index, String msg, int upperBound){
        if(index < 0 || index >= upperBound+1){
            throw new IndexOutOfBoundsException("\n" + msg + " index: " + index + " is out of bounds " + upperBound);
        }
    }    
    
    @Override
    public int size() {
        return listSize;
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < listSize; i++) {
            if(array[i].equals(o)){
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
        Object[] arr = new Object[listSize];
        for (int i = 0; i < listSize; i++) {
            arr[i] = (Object)array[i];            
        }
        return arr;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean add(T e) {
        add(listSize, (T)e);
        return true;
    }


    @Override
    public boolean remove(Object item) {
        int i = 0 ;
        boolean returnValue = true;
        if((i = indexOf(item)) != -1){ //Si regresa -1 es que no encontro el indice del elemento con IndexOf
            remove(i);
        }else{
            returnValue = false;
        }
        return returnValue;
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
    public boolean addAll(int index, Collection<? extends T> c) {
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

    @Override
    public T get(int index) {
        rangeCheck(index, "ArrayList.get()", listSize-1);
        return array[index];
    }

    @Override
    public T set(int index, T element) {
        rangeCheck(index, "ArrayList.set()", listSize-1);
        T previousValue = array[index];
        array[index] = element;
        return previousValue;
    }

    @Override
    public void add(int index, T element) {
        rangeCheck(index, "ArrayList.add()", listSize);
        if(listSize == array.length){
            ensureCapacity(2*array.length);
        }
        for (int j = listSize-1; j >= index; j--) {
            array[j+1] = array[j];
            
        }
        array[index] = element;
        listSize++;
    }

    @Override
    public T remove(int index) {
        rangeCheck(index, "ArrayList.remove()", listSize - 1);
        T returnValue = array[index];

        for (int i = index; i < listSize - 1; i++) {
            array[i] = array[i + 1];

        }

        array[listSize - 1] = null;
        listSize--;
        return returnValue;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < listSize; i++) {
            if(array[i].equals(o)){
                return i;
            }            
        }
        return -1;  
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ListIterator<T> listIterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
