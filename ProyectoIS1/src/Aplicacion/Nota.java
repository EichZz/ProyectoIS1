package Aplicacion;

public class Nota {
    
    private Prueba prueba;
    private double calificacion;
    
    public void addNota(Nota n){
        
    }

    public void setPrueba(Prueba prueba) {
        this.prueba = prueba;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    @Override
    public String toString() {
        return "Nota{" + "prueba=" + prueba + ", calificacion=" + calificacion + '}';
    }
}
