package Aplicacion;

public class Nota {
    
    private Prueba prueba;
    private double calificacion;

    public Nota(Prueba prueba, double calificacion) {
        this.prueba = prueba;
        this.calificacion = calificacion;
    }

    public void setPrueba(Prueba prueba) {
        this.prueba = prueba;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }
    
    public void mostrarNota(){
        toString();
    }

    @Override
    public String toString() {
        return "Nota{" + "prueba=" + prueba + ", calificacion=" + calificacion + '}';
    }
}
