
public class Node<T> {

    // delete the first occurrence of the target in the 
    // linked list referenced by front; returns the 
    // value of front
    public static <T> Node<T> remove(Node<T> front, T target) {
    // curr moves through list, trailed by prev 
        Node<T> curr = front, prev = null;
    // becomes true if we locate target 
        boolean foundItem = false;
    // scan until locate item or come to end of list 
        while (curr != null && !foundItem) {
    // check for a match; if found, check // whether deletion occurs at the front // or at an intermediate position // in the list; set boolean foundItem true 
            if (target.equals(curr.nodeValue)) {
    // remove the first Node 
                if (prev == null) {
                    front = front.next;
                } // erase intermediate Node 
                else{
                    prev.next = curr.next;
                }
                foundItem = true;
            } else {
                // advance curr and prev 
                prev = curr;
                curr = curr.next;
            }
        }
        // return current value of front which is 
        // updated when the deletion occurs at the 
        // first element in the list 
        return front;
    }
    
    // data held by the node 
    public T nodeValue; 
        // next node in the list
    public Node<T> next;
    
    // default constructor with no initial value 
    public Node() {
        nodeValue = null;
         next = null;
    }
    
    // initialize nodeValue to item and set next to null 
    public Node(T item) { 
        nodeValue = item; 
        next = null; 
    }

}   