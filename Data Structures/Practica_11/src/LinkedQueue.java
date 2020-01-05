
import java.util.LinkedList;
import java.util.NoSuchElementException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author A01377647
 */
public class LinkedQueue<T> implements Queue<T>{
    
    private LinkedList<T> qList = null;

    public LinkedQueue() {
        qList = new LinkedList<>();
    }
    

    @Override
    public void push(T item) {
        qList.add(item);    
    }

    @Override
    public T pop() {
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        return qList.removeFirst();   
    }

    @Override
    public T peek() {
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        return qList.getFirst();        
    }

    @Override
    public boolean isEmpty() {
        return qList.isEmpty();
    }

    @Override
    public int size() {
        return qList.size();
    }
    
    
}
