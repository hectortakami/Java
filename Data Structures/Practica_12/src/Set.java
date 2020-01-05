/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Collection;
import java.util.Iterator;

/**
 *
 * @author Daniel Alillo
 */
public interface Set<T> extends Collection<T>
{
    /**
     * Returns the number of elements in this set.
     *
     * @return the number of elements in this set.
     */
    int size();

    /**
     * Returns <tt>true</tt> if this set contains no elements.
     *
     * @return <tt>true</tt> if this set contains no elements.
     */
    boolean isEmpty();

    /**
     * Returns <tt>true</tt> if this set contains the specified element.
     *
     * @param item element whose presence in this set is to be tested.
     * @return <tt>true</tt> if this set contains the specified element.
     */
    boolean contains(Object item);

	/**
	 * Returns an iterator over the elements in this set.
	 *
	 * @return an <tt>Iterator</tt> positioned at an element in the set..
	 */
   Iterator<T> iterator();

    /**
     * Returns an array containing all of the elements in this set.
     *
     * @return an array containing all of the elements in this set.
     */
    Object[] toArray();

    // Modification Operations

    /**
     * Adds the specified element to this set if it is not already present.
     * If this set already contains the specified element, the call leaves
     * this set unchanged and returns <tt>false</tt>.
     * @param item element to be added to this set.
     * @return <tt>true</tt> if this set did not already contain the specified
     *         element.
     */
    boolean add(T item);


    /**
     * Removes the specified element from this set if it is present. Returns
     * <tt>true</tt> if the set contained the specified element.
     *
     * @param item object to be removed from this set, if present.
     * @return true if the set contained the specified element.
     */
    boolean remove(Object item);


    /**
     * Removes all of the elements from this set. This set will be empty after
     * this call returns.
     */
    void clear();
}
