
package Aplicacion;

public class Prueba {
    
    private int id_Prueba;
    private String nombre;
    private String descripcion;
    private Double porcentaje;
    private String tipo_de_prueba;

    public Prueba(int id_Prueba, String nombre, String descripcion, Double porcentaje, String tipo_de_prueba) {
        this.id_Prueba = id_Prueba;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.porcentaje = porcentaje;
        this.tipo_de_prueba = tipo_de_prueba;
    }
    
    public void setId_Prueba(int id_Prueba) {
        this.id_Prueba = id_Prueba;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPorcentaje(Double porcentaje) {
        this.porcentaje = porcentaje;
    }

    public void setTipo_de_prueba(String tipo_de_prueba) {
        this.tipo_de_prueba = tipo_de_prueba;
    }

    @Override
    public String toString() {
        return "Prueba{" + "id_Prueba=" + id_Prueba + ", nombre=" + nombre + ", descripcion=" + descripcion + ", porcentaje=" + porcentaje + ", tipo_de_prueba=" + tipo_de_prueba + '}';
    }
}
