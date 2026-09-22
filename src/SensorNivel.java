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
}