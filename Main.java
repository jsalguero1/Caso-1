import java.util.Scanner;

public class Main {
    static int procesos;
    static int productos;
    static int tamBuzon;
    public static void main(String[] args) {

        System.out.println("Empieza el proceso");

        /**
         * Pide al usuario datos de entrada
         */
        System.out.println("Por favor ingresa el numero de procesos que quieres crear en cada etapa: ");
        System.out.print("-> ");
        Scanner sc = new Scanner(System.in);
        procesos = Integer.parseInt(sc.nextLine());

        System.out.println("Por favor ingresa el numero de productos que quieres que tenga cada proceso: ");
        System.out.print("-> ");
        productos = Integer.parseInt(sc.nextLine());

        System.out.println("Por favor ingresa el tamaño de cada buzón: ");
        System.out.print("-> ");
        tamBuzon = Integer.parseInt(sc.nextLine());
        sc.close();
        
        /**
         * Crea buzones
         */
        Buzon B1 = new Buzon();
        B1.setSize(tamBuzon);
        Buzon B2 = new Buzon();
        B2.setSize(tamBuzon);
        Buzon B3 = new Buzon();
        B3.setSize(productos);
        
        /**
         * Crea etapa 1
         */
        Proceso N1 = new Proceso(0, Color.NARANJA);
        N1.start();
        N1.setBuzonSalida(B1);
        for (int i = 1; i < procesos; i++) {
            Proceso A1 = new Proceso(i, Color.AZUL);
            A1.setBuzonSalida(B1);
            A1.start();
        }

        /**
         * Crea etapa 2
         */
        Proceso N2 = new Proceso(procesos, Color.NARANJA);
        N2.setBuzonSalida(B2);
        N2.start();
        for (int i = procesos+1; i < procesos*2; i++) {
            Proceso A2 = new Proceso(i, Color.AZUL);
            A2.setBuzonSalida(B2);
            A2.start();
        }
        /**
         * Crea etapa 3
         */
        Proceso N3 = new Proceso(procesos*2, Color.NARANJA);
        N3.setBuzonSalida(B3);
        N3.start();
        for (int i = procesos*2+1; i < procesos*3; i++) {
            Proceso A3 = new Proceso(i, Color.AZUL);
            A3.setBuzonSalida(B3);
            A3.start();
        }
        /**
         * crea FINAL
         */
        Proceso proceso = new Proceso(procesos*3, Color.ROJO);
        proceso.setBuzonEntrada(B3);
        proceso.start();
    }
}
