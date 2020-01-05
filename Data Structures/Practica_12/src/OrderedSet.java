/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Daniel Alillo
 */
public interface OrderedSet<T> extends Set<T>
{
    /**
     * Returns the first (minimum) element currently in this ordered set.
     *
     * @return the first (minimum) element currently in this ordered set.
     * @throws    NoSuchElementException ordered set is empty.
     */
	public T first();

    /**
     * Returns the last (maximum) element currently in this ordered set.
     *
     * @return the last (maximum) element currently in this ordered set.
     * @throws    NoSuchElementException ordered set is empty.
     */
	public T last();
}

