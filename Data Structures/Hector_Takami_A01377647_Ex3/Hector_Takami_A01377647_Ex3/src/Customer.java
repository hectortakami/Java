/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hector
 */
public class Customer<T> implements Comparable<T>{
    private int ID;
    private String name;
    private int discount;

    public Customer(int ID, String name, int discount) {
        this.ID = ID;
        this.name = name;
        this.discount = discount;
    }
    
    public int getID(){
        return ID;
    }

    public String getName() {
        return name;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return name + "(" + ID + ")";
    }
    
    
    public boolean equals(Customer c){
        if (this.ID==c.ID&&this.name.equals(c.name)){
            return true;
        }
        return false;
    }

    @Override
    public int compareTo(T o) {
        Customer c2 = (Customer)o;
        if (this.ID>c2.ID){
            return 1;
        }else if (this.ID==c2.ID){
            return 0;
        }else{
            return -1;
        }
    }
    
  
    
    
    
    
}
