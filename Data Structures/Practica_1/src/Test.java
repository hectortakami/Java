
import java.util.Calendar;
import javax.swing.JOptionPane;

/*
Autor: Hector Manuel Takami Flores A01377647
Clase Circulo
*/
public class Test {
    
    public static void main(String[] args) {

        Circle c1 = new Circle();

        System.out.println("The circle has radius of "
                + c1.getRadius() + " and area of " + c1.getArea());

        Circle c2 = new Circle(2.0);
        System.out.println("The circle has radius of "
                + c2.getRadius() + " and area of " + c2.getArea());
        
        Circle c3 = new Circle(1.2);
        System.out.println(c3.toString());
        System.out.println(c3); 
        
        System.out.println("*************************************************");
        
        Fecha f1 = new Fecha(24,4,1997);
        System.out.println(f1.toString());
        System.out.println(f1.calcularEdad() + " años");
        
        System.out.println("*************************************************");
        
        String fechaNac = JOptionPane.showInputDialog("Introduce tu fecha de nacimiento \n dd/mm/aaaa");
        String[] datos = fechaNac.split("/");
        int d = Integer.parseInt(datos[0]);
        int m = Integer.parseInt(datos[1]);
        int a = Integer.parseInt(datos[2]);
        Fecha f2 = new Fecha(d,m,a);
        String nombre = JOptionPane.showInputDialog("Introduce tu nombre");
        
        FrecuenciaCardiaca fC = new FrecuenciaCardiaca(nombre, f2);
        
        System.out.println("Nombre: " + fC.getNombre());
        System.out.println("Fecha de Nacimiento: " + fC.getFechaNacimiento());
        System.out.println("Edad: " + (Calendar.getInstance().get(Calendar.YEAR) - a));
        System.out.println("Frecuencia cardiaca maxima: " + fC.maximaFrecuenciaCardiaca());
        System.out.println("Rango de frecuencia cardiaca recomendada: " +  fC.maximaFrecuenciaCardiaca()*.5 + "-" + fC.maximaFrecuenciaCardiaca()*.85);
        
        

    }
    
}
