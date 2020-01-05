/*
Autor: Hector Manuel Takami Flores A01377647
Clase Circulo
*/
public class Circle {
    
    private double radius;
    private String color;

    public Circle() {
        radius = 1.0;
        color = "red";
    }

    public Circle(double r, String c) {
        this.radius = r;
        this.color = c;
    }

    public Circle(double radius) {
        this.radius = radius;
    }    
    
    
    public double getRadius() {
        return radius;
    }

    public String getColor() {
        return color;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Circle: radius=" + radius + ", color=" + color;
    }
    
    public double getArea(){
        double area = 3.14169*(radius*radius);
        return area;
    } 
    
    
    
    
    
    
}
