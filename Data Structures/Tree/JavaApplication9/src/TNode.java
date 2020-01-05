/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author A01377647
 */
public class TNode<T> {
    public TNode<T> left;
    public TNode<T> right;
    public T nodeValue; 

    public TNode(T item) {
        this.nodeValue = item;
        left = right = null;
    }

    public TNode(T nodeValue, TNode<T> left, TNode<T> right) {
        this.left = left;
        this.right = right;
        this.nodeValue = nodeValue;
    }
    
    
    
    
    
}
