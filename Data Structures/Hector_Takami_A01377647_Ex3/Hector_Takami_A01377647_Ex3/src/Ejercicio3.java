
import java.util.ArrayList;
import java.util.Arrays;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Hector
 */
public class Ejercicio3 {

    public static <T> void removeAll(AlStack<T> s, T item) {
        AlStack<T> newStack = new AlStack<>();
        while (s.isEmpty() == false) {
            T target = s.peek();
            if (target.equals(item)) {
                s.pop();
            } else {
                newStack.push(s.pop());
            }
        }
        while (newStack.isEmpty() == false) {
            s.push(newStack.pop());
        }

    }

    public static <T> T[] removeDuplicates(T[] arr) {
        ArrayList<T> newArr = new ArrayList<>();
        AlStack<T> stkA = new AlStack<>();
        AlStack<T> stkB = new AlStack<>();
        for (int i = 0; i < arr.length; i++) {
            stkA.push(arr[i]);
        }
        while (stkA.isEmpty() == false) {
            T item = stkA.pop();
            stkB.push(item);
            removeAll(stkA, item);
        }
        while (stkB.isEmpty() == false) {
            newArr.add(stkB.pop());
        }

        return (T[]) newArr.toArray();

    }

    public void main() {

        System.out.println("*Excercise #3:");
        String[] arrCD = {"HandsAllOver;Maroon5;13", "Son Todos Iguales;Pimpinela;15", "Caught in the act;Michael Buble;17",
            "Al modo nuestro;Pimpinela;12", "Las primeras Golondrinas;Pimpinela;13", "LOVE;Jason Mraz;15", "I Wont be home before a long;Maroon5;14",
            "Shoot to thrill;ACDC;14", "X;Ed Sheeran;13", "Black Ice;ACDC;15"};
        System.out.println("Complete CD stack:");
        AlStack<CD> torre = new AlStack<>();
        for (int i = 0; i < arrCD.length; i++) {
            String CD = arrCD[i];
            String[] data = CD.split(";");
            CD cd = new CD(data[0], data[1], Integer.parseInt(data[2]));
            torre.push(cd);
            System.out.println("-" + torre.peek());
        }
        CD cdPimpinela = new CD("Fuego", "Pimpinela", 12);
        System.out.println("a) RemoveAll Method: remove al CDs with 'Pimpinela' as Artist: ");
        removeAll(torre, cdPimpinela);
        while (torre.isEmpty() == false) {
            System.out.println("-" + torre.pop());
        }

        System.out.println("b) CD Class Implementation");

        Integer[] intArr = {1, 4, 13, 5, 8, 5, 5, 8, 13};
        System.out.println("c) RemoveDuplicates Method:");
        System.out.println("* Array: " + Arrays.toString(intArr));
        System.out.println("- NewArray without duplicates: " + Arrays.toString(removeDuplicates(intArr)));
    }
}
