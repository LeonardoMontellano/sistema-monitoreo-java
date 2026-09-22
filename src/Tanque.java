public class Tanque {
    private String id;
    private double capacidadMaxima;
    private double nivelActual;
    private String estado;

    public Tanque(String id, double capacidadMaxima) {
        this.id = id;
        this.capacidadMaxima = capacidadMaxima;
        this.nivelActual = 0.0;
        this.estado = "DETENIDO";
    }

    public double getNivelActual() {
        return this.nivelActual;
    }

    public double getCapacidadMaxima() {
        return this.capacidadMaxima;
    }
}