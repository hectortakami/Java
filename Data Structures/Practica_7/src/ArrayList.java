
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
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
public class ArrayList<T> implements List<T>{
    
    private int listSize;
    private T[] listArr;

    public ArrayList() {
        listArr = (T[]) new Object[10];
        listSize = 0;        
    }
    
    public void ensureCapacity(int minCapacity){
        if(minCapacity>listArr.length){
            T[] oldList = listArr;
            listArr = (T[]) new Object[minCapacity];
            for (int i = 0; i < listSize; i++) {
                listArr[i] = oldList[i];                
            }
            oldList = null;
        }
    }
    
    private void rangeCheck(int index, String msg, int upperBound){
        if (index < 0 || index >= upperBound + 1) {
            throw new IndexOutOfBoundsException("\n" + msg + ": index " + index + " out of bounds. Should be in the range 0 to "+ upperBound);
        }
    }
  
    public Object clone() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

    @Override
    public String toString() {
        return Arrays.toString(toArray());
    }
    
    private String maxLengthString(){
        String maxString = listArr[0].toString();
        for (int i = 1; i < listSize; i++) {
            String tgt = listArr[i].toString();
            if(tgt.length()>maxString.length()){
                maxString = tgt;
            }
        }
        return "[" + maxString + "] Length(" + maxString.length() + ")";       
    } 
    
    private String maxLexString(){
       String maxLex = listArr[0].toString();
        for (int i = 1; i < listSize; i++) {
           String tgt = listArr[i].toString();
           if(tgt.length() >= maxLex.length() && tgt.compareTo(maxLex) <= 0){
               maxLex = tgt;
           }
        }
        return "[" + maxLex.toString() + "]";
    }     
    
    public void addString(){
        System.out.println("*");
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        if (!str.equalsIgnoreCase("done")){
            add((T)str);
            addString();
        }else{
            System.out.println("-------------------------------------------------------------");
            System.out.println(toString());
            System.out.println("- MaxLength String: " + maxLengthString()); 
            System.out.println("- MaxLexicographic String: " + maxLexString());
        }        
    }
    

    @Override
    public int size() {
        return listSize;
    }

    @Override
    public boolean isEmpty() {
        if (listSize <= 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < listArr.length; i++) {
            if (listArr[i].equals(o)){
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
        for (int i = 0; i < arr.length; i++) {
            arr[i] = listArr[i];            
        }
        return arr;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean add(T e) {
        add(listSize, e);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        int i = 0, j;
        boolean retValue = true;
        if ((i = indexOf(o)) != -1) {
            remove(i);
        } else {
            retValue = false;
        }
        return retValue;
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
        rangeCheck(index, "ArrayList get()", listSize - 1);
        return listArr[index];
    }

    @Override
    public T set(int index, T element) {
        rangeCheck(index, "ArrayList set()", listSize - 1);
        T previousValue = listArr[index];
        listArr[index] = element;
        return previousValue;
    }

    @Override
    public void add(int index, T element) {
        rangeCheck(index, "ArrayList add()", listSize);
        if (listSize == listArr.length) {
            ensureCapacity(2 * listArr.length);
        }
        for (int j = listSize - 1; j >= index; j--) {
            listArr[j + 1] = listArr[j];
        }
        listArr[index] = element;
        listSize++;
    }

    @Override
    public T remove(int index) {
        rangeCheck(index, "ArrayList remove()",listSize - 1);
        T returnElement = listArr[index];
        for (int j = index; j < listSize - 1; j++) {
            listArr[j] = listArr[j + 1];
        }
        listArr[listSize - 1] = null;
        listSize--;
        return returnElement;
    }

    @Override
    public int indexOf(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
