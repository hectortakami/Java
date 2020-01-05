/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author A01377647
 */
public class Trees {
    public static <T> String inOrder(TNode<T> t) {
        String s = "";
        if (t != null) {
            s += inOrder(t.left); // descend left
            s += t.nodeValue + " "; // display the node
            s += inOrder(t.right); // descend right
        }
        return s;
    }
    
    public static <T> String preOrder(TNode<T> t) {
        String s = "";
        if (t != null) {
            s += t.nodeValue + " "; // display the node
            s += preOrder(t.left); // descend left           
            s += preOrder(t.right); // descend right
        }
        return s;
    }
    
    public static <T> String postOrder(TNode<T> t) {
        String s = "";
        if (t != null) {
            s += postOrder(t.left); // descend left           
            s += postOrder(t.right); // descend right
            s += t.nodeValue + " "; // display the node
        }
        return s;
    }
    
    public static void main(String[] args) {
        
        TNode<String> A,B,C,D,E,F,G,H,I;
        I = new TNode<String>("I",null,null);
        H = new TNode<String>("H",null,null);
        G = new TNode<String>("G",null,null);
        F = new TNode<String>("F",null,null);
        E = new TNode<String>("E",H,I);
        D = new TNode<String>("D",null,G);
        C = new TNode<String>("C",E,F);
        B = new TNode<String>("B",D,null);
        A = new TNode<String>("A",B,C);
       
        System.out.println("PreOrder: " + preOrder(A));
        System.out.println("InOrder: " + inOrder(A));
        System.out.println("PostOrder: " + postOrder(A));
    }
    
}
