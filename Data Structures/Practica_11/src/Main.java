
import java.util.ArrayList;
import java.util.Random;
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
public class Main {

    public static int treeSize(TNode<?> root) {
        int hVal, hRight, hLeft = 0;
        if (root == null) {
            hVal = -1;
        } else {
            hLeft = treeSize(root.left);
            hRight = treeSize(root.right);
            hVal = 1 + (hLeft > hRight ? hLeft : hRight);
        }
        return hVal;
    }

    public static int countOneChild(TNode<?> root) {
        int counter = 0;
        if (root == null) {
            return -1;
        } else {
            TNode<?> currLeft = root.left;
            TNode<?> currRight = root.right;
            while (currRight != null || currLeft != null) {
                if (currLeft != null && currRight == null) {
                    counter++;
                    currLeft = currLeft.left;
                } else if (currLeft == null && currRight != null) {
                    counter++;
                    currRight = currRight.right;
                } else {
                    currLeft = currLeft.left;
                    currRight = currRight.right;
                }
            }
        }
        return counter;
    }
    
    public static <T> String rlnDisplay(TNode<T> t) {
        String s = "";
        if (t != null) {
            s += rlnDisplay(t.right);
            s += rlnDisplay(t.left);
            s += t.nodeValue + " ";            
        }
        return s;
    }
    
    public static <T> String inorderDisplay(STree.STNode<T> t){
        String s = "";
        if (t != null) {
            s += inorderDisplay(t.left); 
            s += t.nodeValue + " "; 
            s += inorderDisplay(t.right); 
        }
        return s;
    }
    
    public static <T> String preorderDisplay(STree.STNode<T> t){
        String s = "";
        if (t != null) {
            s += t.nodeValue + " "; 
            s += inorderDisplay(t.left);             
            s += inorderDisplay(t.right); 
        }
        return s;
    }
    
    public static <T> String postorderDisplay(STree.STNode<T> t){
        String s = "";
        if (t != null) {
            s += inorderDisplay(t.left); 
            s += inorderDisplay(t.right); 
            s += t.nodeValue + " "; 
        }
        return s;
    }

    public static void main(String[] args) {
        //nodeValue, Left, Right
        System.out.println("A) Binary Trees:");
        TNode<Integer> a, b, c, d, e, f, g, h, i;
        e = new TNode<>(1, null, null);
        d = new TNode<>(2, e, null);
        c = new TNode<>(3, null, null);
        b = new TNode<>(4, d, null);
        a = new TNode<>(5, b, c);
        
        i = new TNode<>(6, null, null);
        h = new TNode<>(7, null, i);
        g = new TNode<>(8, null, null);
        f = new TNode<>(9, i, h);

        System.out.println("* TreeSize Method: " + treeSize(a));
        System.out.println("* TreeSize Method: " + treeSize(f));
        System.out.println("********************************");
        System.out.println("* CountOneChild Method: " + countOneChild(a));
        System.out.println("* CountOneChild Method: " + countOneChild(f));
        System.out.println("********************************");
        System.out.println("* RLN Display Method: " + rlnDisplay(a));
        System.out.println("* RLN Display Method: " + rlnDisplay(f));
        
        System.out.println("\n********************************");
        System.out.println("********************************");

        
        
        System.out.println("\nB) Binary Tree Search:");
        STree<Character> charTree = new STree<>();
        Character[] arr = {'S','J','K','L','X','F','E','Z'};
        for (int j = 0; j < arr.length; j++) {
            charTree.add(arr[j]);
        }
        System.out.println("* DisplayTree Method: ");
        System.out.println(charTree.displayTree(3));
        
        System.out.println("\n* BinaryTree From Array: ");
        System.out.println("Input a number:");
        Scanner sc = new Scanner(System.in);
        Random rnd = new Random();
        int n = sc.nextInt();
        sc.close();
        
        ArrayList<Integer> aList = new ArrayList<>(n);
        for (int j = 0; j < n; j++) {
            int number = rnd.nextInt(100);
            aList.add(number);
        }   
        STree<Integer> intTree = new STree<>();
        for (int j = 0; j < aList.size(); j++) {
            intTree.add(aList.get(j));
        }
        System.out.println("-Preorder Display (NLR): " + preorderDisplay(intTree.getRoot()));
        System.out.println("-Inorder Display (LNR): " + inorderDisplay(intTree.getRoot()));
        System.out.println("-Postorder Display (LRN): " + postorderDisplay(intTree.getRoot()));
        System.out.println(intTree.displayTree(3));
        
        

    }

}
