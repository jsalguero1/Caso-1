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

        int naranjas = 0;
        Buzon Etapa1 = new Buzon(tamBuzon);
        Buzon Etapa2 = new Buzon(tamBuzon);
        Buzon Etapa3 = new Buzon(tamBuzon);
        
    }
}
