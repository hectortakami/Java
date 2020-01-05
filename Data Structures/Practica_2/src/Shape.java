/*
Autor: Hector Takami 
Clase Shape
 */
public class Shape {
    private String color;
    private boolean filled;

    public Shape() {
        color = "red";
        filled = true;
    }
    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }
    
    public void isFilled(boolean filled){
        
    }

    @Override
    public String toString() {
        String s ="";
        if (filled==true){
            s += "A Shape with color " + color + " and filled" ;
        }else{
            s += "A Shape with color " + color + " and Not filled" ;
        }
        return s;
    }
    
    
    
    
}
