import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Empieza el proceso");

        System.out.print("Por favor ingresa el numero de procesos que quieres crear: ");
        int procesos;
        Scanner sc = new Scanner(System.in);
        procesos = Integer.parseInt(sc.nextLine());

        System.out.print("Por favor ingresa el numero de productos que quieres que tenga cada proceso: ");
        int productos;
        productos = Integer.parseInt(sc.nextLine());

        System.out.print("Por favor ingresa el tamaño de cada buzón: ");
        int tamBuzon;
        tamBuzon = Integer.parseInt(sc.nextLine());
        Buzon B1 = new Buzon();
        B1.setSize(tamBuzon);
        Buzon B2 = new Buzon();
        B2.setSize(tamBuzon);
        Buzon B3 = new Buzon();
        
        for (int i = 0; i < procesos; i++) {
            if (i == procesos-1){
                Proceso proceso = new Proceso(i, Color.NARANJA);
                proceso.setBuzonSalida(B1);
                proceso.crearProducto(productos);
                proceso.printProductos();
                proceso.start();
            } else{
                Proceso proceso = new Proceso(i, Color.AZUL);
                proceso.setBuzonSalida(B1);
                proceso.crearProducto(productos);
                proceso.printProductos();
                proceso.start();
            }
        }

        for (int i = procesos; i < procesos*2; i++) {
            if (i == procesos*2-1){
                Proceso proceso = new Proceso(i, Color.NARANJA);
                proceso.setBuzonSalida(B2);
                proceso.setBuzonEntrada(B1);
                proceso.crearProducto(productos);
                proceso.printProductos();
                proceso.start();
            } else{
                Proceso proceso = new Proceso(i, Color.AZUL);
                proceso.setBuzonSalida(B2);
                proceso.setBuzonEntrada(B1);
                proceso.crearProducto(productos);
                proceso.printProductos();
                proceso.start();
            }
        }

        for (int i = procesos*2; i < procesos*3; i++) {
            if (i == procesos*3-1){
                Proceso proceso = new Proceso(i, Color.NARANJA);
                proceso.setBuzonSalida(B3);
                proceso.setBuzonEntrada(B2);
                proceso.crearProducto(productos);
                proceso.printProductos();
                proceso.start();
            } else{
                Proceso proceso = new Proceso(i, Color.AZUL);
                proceso.setBuzonSalida(B3);
                proceso.setBuzonEntrada(B2);
                proceso.crearProducto(productos);
                proceso.printProductos();
                proceso.start();
            }
        }
    }
}
