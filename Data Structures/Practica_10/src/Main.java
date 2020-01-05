
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

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

    public static <T> T get(Stack<T> stk, int n) {
        if (n > stk.size()) {
            throw new IllegalArgumentException();
        }
        T obj = null;
        for (int i = 0; i < n; i++) {
            obj = stk.pop();
        }
        return obj;
    }

    public static <T> void nToTop(Stack<T> stk, int n) {
        if (n > stk.size()) {
            throw new IllegalArgumentException();
        }

        T obj = null;
        ArrayList<T> aList = new ArrayList<>();
        for (int i = stk.size(); i > 0; i--) {
            if (i == n) {
                obj = stk.pop();
            } else {
                aList.add(stk.pop());
            }
        }
        while (!aList.isEmpty()) {
            stk.push(aList.get(aList.size() - 1));
            aList.remove(aList.size() - 1);
        }
        stk.push(obj);
        System.out.println(stk.toString() + "<-- Top");
    }

    public static <T> int queueSize(Queue<T> q) {
        return q.size();
    }

    public static <T> String toString(LinkedQueue<T> q) {
        String str = "[";
        LinkedQueue<T> lQ = new LinkedQueue<>();
        T t = q.pop();
        while (!q.isEmpty()) {
            lQ.push(t);
            str += t + ", ";
            t = q.pop();
        }
        str += t + "]";

        while (!lQ.isEmpty()) {
            q.push(lQ.pop());
        }

        return str;
    }

    public static int getSmallestFactor(int num) {
        int n = 2;
        while (n < num) {
            if (num % n == 0) {
                return n;
            }
            n++;
        }
        return n;
    }

    public static String primeNumbers(int num) {
        String str = "";
        int c = 2;
        while (c < num) {
            if (num % c == 0) {
                str += c + " ";
            }
            c++;
        }
        if (str == "") {
            str += num;
        }
        return str;
    }

    public static void main(String[] args) {
        Stack<String> stk1 = new Stack<>();
        stk1.push("Luke");
        stk1.push("I");
        stk1.push("am");
        stk1.push("your");
        stk1.push("Father");
        System.out.println("-Get Method(5): " + get(stk1, 5));

        System.out.println("****************************************************");

        Stack<String> stk2 = new Stack<>();
        stk2.push("Block A");
        stk2.push("Block B");
        stk2.push("Block C");
        stk2.push("Block D");
        stk2.push("Block E");
        System.out.println("-nToTop Method: ");
        System.out.println(" Input the index in stack to change to top between 1 and " + stk2.size() + " / (Display '0' to end)");

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        while (n != 0) {
            while (n > stk2.size()) {
                System.out.println("Input a valid number between 1 and 5");
                n = sc.nextInt();
            }
            nToTop(stk2, n);
            System.out.println(" \nInput the index in stack to change to top between 1 and " + stk2.size() + " / (Display '0' to end)\n");
            n = sc.nextInt();
        }
        System.out.println("****************************************************");
        System.out.println("-getSmallestFactor Method(15): " + getSmallestFactor(15));
        System.out.println("-getSmallestFactor Method(7): " + getSmallestFactor(7));
        System.out.println("Input a number to obtain it prime numbers: / (Display '0' to end)");
        n = sc.nextInt();
        while (n != 0) {
            System.out.println("Number =" + n);
            System.out.println("Prime factors: " + primeNumbers(n) +"\n");
            System.out.println("Input a number to obtain it prime numbers: / (Display '0' to end)");
            n = sc.nextInt();
        }
        sc.close();

        System.out.println("****************************************************");

        Integer[] intArr = {6, 9, 13, 5, 11, 0, 7, 3, 19, 4, 16};
        System.out.println("-queueSize Method: ");

        LinkedQueue<Integer> qA, qB, aux;
        qA = new LinkedQueue<>();
        qB = new LinkedQueue<>();
        aux = new LinkedQueue<>();
        for (int i = 0; i < intArr.length; i++) {
            qA.push(intArr[i]);
        }

        System.out.println("Size of qA is " + qA.size());

        int c = 0;
        while (c <= qA.size() / 2) {
            aux.push(qA.pop());
            c++;
        }
        aux.push(qA.pop());
        while (!qA.isEmpty()) {
            qB.push(qA.pop());
        }
        while (!aux.isEmpty()) {
            qA.push(aux.pop());
        }

        System.out.println("Elements in qA: " + toString(qA));
        System.out.println("Elements in qB: " + toString(qB));

    }

}
