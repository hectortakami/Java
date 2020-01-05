/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author A01377647
 */
public class Main {
    
    public static void main(String[] args) {
        Integer[] iArr = {12,45,67,31,97,31,9,0,21};
        STree<Integer> sT1 = new STree<>();
        for (int i = 0; i < iArr.length; i++) {
            sT1.add(iArr[i]);
        }
    }
}
