/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hector
 */
public class DNode<T> {

    public T nodeValue; 
    public DNode<T> prev; 
    public DNode<T> next; 

    public DNode() {
        nodeValue = null;
        next = this;
        prev = this;
    }

    public DNode(T item) {
        nodeValue = item;
        next = this;
        prev = this;
    }
    
    public static <T> void remove(DNode<T> curr) {
        if (curr.next == curr) {
            return;
        }
        DNode<T> prevNode = curr.prev, nexNode = curr.next;
        prevNode.next = nexNode;
        nexNode.prev = prevNode;
    }
}
    
     