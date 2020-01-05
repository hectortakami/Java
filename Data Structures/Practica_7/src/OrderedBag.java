/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hector
 */
public class OrderedBag<T extends Comparable<? super T>> extends Bag<T>{
    
    public OrderedBag(int capacity) {
        super(capacity);
        super.bagArr = (T[]) new Comparable[capacity];
        super.bagSize = 0;
    }
    
    @Override
    public boolean add (T item) {
        
        if(bagSize>=bagArr.length){
            return false;
        }else{
           super.add(item);
            for (int i = 0; i < bagSize; i++) {
                for (int j = i+1; j < bagSize; j++) {
                    if (bagArr[j].compareTo(bagArr[i])< 0){
                        T temp = bagArr[i];
                        bagArr[i] = bagArr[j];
                        bagArr[j] = temp;
                    }
                }
            }
        }
        return true;

    }
    
    public T getFirst(){
        return bagArr[0];
    }
    
    public T getLast(){
        return bagArr[bagSize-1];   
    }
    
    
}
