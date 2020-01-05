
import java.util.Calendar;

/*
Autor:
Clase Frecuencia Cardiaca
 */
public class FrecuenciaCardiaca {
    
    private String nombre;
    private Fecha fechaNacimiento;

    public FrecuenciaCardiaca(String nombre, Fecha fechaNacimiento) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
    }
    
    public double maximaFrecuenciaCardiaca(){
        int añoActual = Calendar.getInstance().get(Calendar.YEAR);
        int anio = fechaNacimiento.getAnio();
        int edad = añoActual - anio;
        return 220 - edad;        
        
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFechaNacimiento(Fecha fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public Fecha getFechaNacimiento() {
        return fechaNacimiento;
    }
    
    
    
}
