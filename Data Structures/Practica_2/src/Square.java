/*
Autor: Hector Takami 
Clase Square
 */
public class Square extends Rectangle{

    public Square() {
    }
    
    public Square(double side){
        super(side,side);
    }

    public Square(double width, double length, String color, boolean filled) {
        super(width, length, color, filled);
    }
    
    public double getSide(){
        return super.getWidth();
    }
    
    public void setSide(double side){
        super.setWidth(side);
    }
    
    @Override
    public void setWidth(double side){
        super.setWidth(side);
        super.setLength(side);
        
    }
    
    @Override
    public void setLength(double side){
        super.setLength(side);
        super.setWidth(side);
    }

    @Override
    public String toString() {
        return "A Square with side= " + super.getWidth() + " which is a subclass of Rectangle";
    }
    
    
    
    
    
    
}
