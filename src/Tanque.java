import java.awt.desktop.SystemSleepEvent;

public class Tanque {
    private final String id;
    private final double capacidadMaxima;
    private double nivelActual;
    private String estado;
    public Tanque(String id, double capacidadMaxima){
        this.id = id;
        this.capacidadMaxima = capacidadMaxima;
        this.nivelActual = 0;
        this.estado = "detener";
    }
    public String getId() {
        return this.id;
    }
    public double getCapacidadMaxima() {
        return this.capacidadMaxima;
    }
    public double getNivelActual() {
        return this.nivelActual;
    }
    public String getEstado() {
        return this.estado;
    }
    private void setEstado(String estado) {
        this.estado=estado;
    }
    public void llenar(double cantidad){
        if (this.nivelActual+cantidad<=this.capacidadMaxima){
            this.nivelActual+=cantidad;
            System.out.println(this.id+" llenando "+cantidad+"L");
            this.setEstado("llenando");
            return;
        }
        else{
            System.out.println("El llenado excedería la capacidad maxima del tanque.");
            return;
        }
    }
    public void vaciar (double cantidad){
        if (this.nivelActual-cantidad>=0){
            this.nivelActual-=cantidad;
            System.out.println(this.id+" vaciando "+cantidad+"L");
            this.setEstado("vaciando");
            return;
        }
        else{
            System.out.println("No hay suficiente producto.");
            return;
        }
    }
    public void detener(){
        this.setEstado("detener");
    }
    public double calcularPorcentaje(){
        return (this.nivelActual/this.capacidadMaxima)*100;
    }
    public String obtenerInformacion(){
        return ("ID: " + this.id + ", Capacidad Maxima: " + this.capacidadMaxima + "L, Nivel Actual: " + this.nivelActual + "L (" + this.calcularPorcentaje() + "%). Estado: " + this.estado);
    }
}
