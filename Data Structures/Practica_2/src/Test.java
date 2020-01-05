/*
Autor: Hector Takami 
Clase Prueba
 */ 

public class Test {
    public static void main(String[] args) {
        
        Shape s = new Shape("green", true);
        Shape n = new Shape("blue", false);
        System.out.println(s.toString());
        System.out.println(s.getColor());
        System.out.println(n.toString());
        n.setColor("yellow");
        System.out.println(n.toString());
        
        System.out.println("********************************************************");
        
        Circle c = new Circle(23.5, "red", false);
        System.out.println(c.toString());
        Circle v = new Circle(15.6);
        System.out.println("Area: " + v.getArea());
        System.out.println("Perimeter: " + v.getPerimeter());
        System.out.println("Radius: " + v.getRadius());
        
        System.out.println("********************************************************");

        Rectangle r = new Rectangle(65.86, 36.52, "gray", true);
        Rectangle e = new Rectangle(98, 14.6, "white", false);
        System.out.println(r.toString());
        r.setLength(36.59);
        System.out.println(e.toString());
        System.out.println("Area: " + e.getArea());
        System.out.println("Perimeter: " + e.getPerimeter());

        System.out.println("********************************************************");

        Square f = new Square(36);
        Square j = new Square(63);
        System.out.println(f.toString());
        System.out.println(j.toString());
        f.setSide(60);
        System.out.println(f.toString());
        System.out.println("Side: " + j.getSide());
        System.out.println("Area: " + j.getArea());
        System.out.println("Perimeter: " + j.getPerimeter());

        System.out.println("********************************************************");

        Movable m1 = new MovablePoint(5, 6, 10, 12); // upcast
        System.out.println(m1);
        m1.moveLeft();
        System.out.println(m1);

        Movable m2 = new MovableCircle(2, 1, 2, 20, 6); // upcast
        System.out.println(m2);
        m2.moveRight();
        System.out.println(m2);
        m2.moveUp();
        System.out.println(m2);
        
        Movable m3 = new MovableRectangle(10, 15, 15, 20, 6, 7); // upcast
        System.out.println(m3);
        m3.moveRight();
        System.out.println(m3);
        m3.moveUp();
        System.out.println(m3);
        m3.moveDown();
        System.out.println(m3);
        
        


    }
}
