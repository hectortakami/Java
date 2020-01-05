/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author A01377647
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

    public DNode(T nodeValue) {
        this.nodeValue = nodeValue;
        next = this;
        prev = this;
    }

   
    public static <T> String toString(DNode<T> header ) {
        if (header.next == header){
            return null;
        }
        DNode<T> curr = header.next;
        String str = "[" + curr.nodeValue;
        while (curr.next != header){
            curr = curr.next;
            str += "," + curr.nodeValue;
        }
        str += "]";
        return str;
    }
    
    public static <T> DNode<T> addBefore(DNode<T> curr, T item) {
        DNode<T> newNode, prevNode;
        newNode = new DNode<T>(item);
        prevNode = curr.prev;
        newNode.prev = prevNode;
        newNode.next = curr;
        prevNode.next = newNode;
        curr.prev = newNode;
        return newNode;
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
