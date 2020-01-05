
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hector
 */
public class AlStack<T> implements Stack<T>{

    private ArrayList<T> stackList = null;

    public AlStack() {
        stackList = new ArrayList<>();
    }    
    

    @Override
    public void push(T item) {
        stackList.add(item);
    }

    @Override
    public T pop() {
        if (stackList.isEmpty()){
            throw new NullPointerException("STACK IS NULL");
        }else{
            return stackList.remove(stackList.size()-1);
        }  
    }

    @Override
    public T peek() {
        if (stackList.isEmpty()){
            throw new NullPointerException("STACK IS NULL");
        }else{
            return stackList.get(stackList.size()-1);
        }        
    }

    @Override
    public boolean isEmpty() {
        return stackList.isEmpty();
    }

    @Override
    public int size() {
        return stackList.size();
    }    

    
    
}
