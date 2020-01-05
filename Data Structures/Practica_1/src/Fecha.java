
import java.util.Calendar;

/*
Autor: Hector Manuel Takami Flores
CLase Fecha
 */
public class Fecha {
    
    private int dia;
    private int mes;
    private int anio;

    public Fecha(int dia, int mes, int anio) {
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }

    @Override
    public String toString() {
        return dia + "/" + mes + "/" + anio;
    }
    
    public int calcularEdad(){
        int añoActual = Calendar.getInstance().get(Calendar.YEAR);                
        anio = añoActual - anio;
        return anio;
        
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAnio() {
        return anio;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }
    
    
    
    
    
}
