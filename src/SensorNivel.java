public class SensorNivel {
    private String id;
    private Tanque tanqueAsociado;
    private double ultimaLectura;

    public SensorNivel(String id, Tanque tanqueAsociado) {
        this.id = id;
        this.tanqueAsociado = tanqueAsociado;
        this.ultimaLectura = 0.0;
    }

    public String getId() {
        return this.id;
    }

    public double getUltimaLectura() {
        return this.ultimaLectura;
    }

    public double leerNivel() {
        if (this.tanqueAsociado != null) {
            this.ultimaLectura = this.tanqueAsociado.getNivelActual();
        }
        return this.ultimaLectura;
    }

    public boolean esLecturaValida() {
        if (this.tanqueAsociado == null) {
            return false;
        }
        return this.ultimaLectura >= 0.0 && this.ultimaLectura <= this.tanqueAsociado.getCapacidadMaxima();
    }

    public String obtenerReporte() {
        String estadoValidez = esLecturaValida() ? "VÁLIDA" : "INVÁLIDA";
        return "Sensor: " + this.id +
                " | Lectura: " + this.ultimaLectura + " L" +
                " | Validación: " + estadoValidez;
    }
}