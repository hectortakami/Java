
import java.util.Iterator;

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
    
    public static <T> Set<T> union(Set<T> setA, Set<T> setB) {
        Set<T> setUnion;
        // allocate concrete collection object for setUnion
        if (setA instanceof OrderedSet) {
            setUnion = new TreeSet<T>();
        } else {
            return null;
        }
        // use iterator to add elements from setA
        Iterator<T> iterA = setA.iterator();
        while (iterA.hasNext()) {
            setUnion.add(iterA.next());
        }
        // use iterator to add non-duplicate
        // elements from setB
        Iterator<T> iterB = setB.iterator();
        while (iterB.hasNext()) {
            setUnion.add(iterB.next());
        }
        return setUnion;
    }
    
    public static <T> Set<T> intersection(Set<T> setA, Set<T> setB) {
        Set<T> setIntersection;
        if (setA instanceof OrderedSet) {
            setIntersection = new TreeSet<T>();
        } else {
            return null;
        }
        T item;
        Iterator<T> iterA = setA.iterator();
        
        while (iterA.hasNext()) {
            item = iterA.next();
            if (setB.contains(item)) {
                setIntersection.add(item);
            }
        }
        return setIntersection;
    }
    
    public static <T> Set<T> difference(Set<T> setA, Set<T> setB) {
        Set<T> setDifference;
        if (setA instanceof OrderedSet) {
            setDifference = new TreeSet<T>();
        } else {
            return null;
        }
        T item;
        Iterator<T> iterA = setA.iterator();
        
        while (iterA.hasNext()) {
            item = iterA.next();
            if (!setB.contains(item)) {
                setDifference.add(item);
            }
        }
        return setDifference;
    }
    
    public static <T> boolean subSet(Set<T> setA, Set<T> setB) {
        return intersection(setA, setB).size() == setA.size();
    }

}
