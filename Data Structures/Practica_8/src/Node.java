/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hector
 */
public class Node<T> {
    
    public T nodeValue;
    public Node<T> next;
    
    public Node(){
        nodeValue = null;
        next = null;
    }
    
    public Node(T nodeValue){
        this.nodeValue = nodeValue;
        next = null;
    }
  
    
    
    
    
}
