public class Main {
    public static void main(String[] args) {
        System.out.println("Sistema de monitoreo");
        Tanque t1 = new Tanque("T-001", 50);
        System.out.println(t1.obtenerInformacion());
        t1.llenar(30);
        System.out.println(t1.obtenerInformacion());
        t1.vaciar(10);
        System.out.println(t1.obtenerInformacion());
        t1.llenar(50);
        System.out.println(t1.obtenerInformacion());
        t1.vaciar(70);
        System.out.println(t1.obtenerInformacion());
    }
}
