public class Main {
    public static void main(String[] args) {
        System.out.println("Sistema de monitoreo");
        Tanque t1 = new Tanque("T-001", 50);
        SensorNivel s1 = new SensorNivel("S-001", t1);
        System.out.println(t1.obtenerInformacion());
        t1.llenar(30);
        s1.leerNivel();
        System.out.println(s1.obtenerReporte());
        System.out.println(t1.obtenerInformacion());
        t1.vaciar(10);
        s1.leerNivel();
        System.out.println(s1.obtenerReporte());
        System.out.println(t1.obtenerInformacion());
        t1.llenar(50);
        s1.leerNivel();
        System.out.println(s1.obtenerReporte());
        System.out.println(t1.obtenerInformacion());
        t1.vaciar(70);
        s1.leerNivel();
        System.out.println(s1.obtenerReporte());
        System.out.println(t1.obtenerInformacion());
    }
}
