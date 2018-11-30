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

    public void setCalificacion(double nota) {
        this.calificacion = nota;
    }
    
    public void mostrarNota(){
        toString();
    }

    public Prueba getPrueba() {
        return prueba;
    }
    
    @Override
    public String toString() {
        return "Prueba: " + prueba
                + "Nota: " + calificacion;
    }
}
