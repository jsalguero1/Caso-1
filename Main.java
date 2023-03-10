import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        System.out.println("Empieza el proceso");

        System.out.print("Por favor ingresa el numero de procesos que quieres crear: ");
        int Threads;
        Scanner sc = new Scanner(System.in);
        Threads = Integer.parseInt(sc.nextLine());

        System.out.print("Por favor ingresa el numero de productos que quieres que tenga cada proceso: ");
        int productos;
        productos = Integer.parseInt(sc.nextLine());

        System.out.print("Por favor ingresa el tamaño de cada buzón: ");
        int tamBuzon;
        tamBuzon = Integer.parseInt(sc.nextLine());
        sc.close();

        Buzon Etapa1 = new Buzon(tamBuzon);
        Buzon Etapa2 = new Buzon(tamBuzon);
        Buzon Etapa3 = new Buzon(tamBuzon);
        Buzon Etapa4 = new Buzon(tamBuzon*3);

        ArrayList <Buzon> buzones = new ArrayList<Buzon>();
        buzones.add(Etapa1);
        buzones.add(Etapa2);
        buzones.add(Etapa3);
        buzones.add(Etapa4);

        Proceso [] procesos = new Proceso[1000];

        for (int i = 0; i < 3; i++) {
            procesos[i*100] = new Proceso(i*100, Color.NARANJA ,buzones.get(i) ,buzones.get(i+1),productos );
            procesos[i*100].start();
            for (int j = 1; j < Threads; j++) {
                procesos[i*100+j] = new Proceso((i*100)+j, Color.AZUL ,buzones.get(i) ,buzones.get(i+1),productos );
                procesos[i*100+j].start();
            }
        }
        Final fin = new Final(Color.ROJO ,buzones.get(3), productos*Threads);
        try {
            fin.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        fin.start();
    }
}
