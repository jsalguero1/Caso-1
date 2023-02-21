import java.lang.Thread;
import java.util.ArrayList;
public class Proceso extends Thread{

    private int id;
    private Color color;
    private Buzon buzonEnt, buzonSal;
    private int contador = 0;
    private ArrayList<Producto> productos = new ArrayList<>();

    public Proceso(int _id, Color _color){
        this.id = _id;
        this.color = _color;
    }

   @Override
   public void run() {
    System.out.println("***********************************************");
    System.out.println("Proceso: " + this.id + " color: " + this.color);
    System.out.println("***********************************************");
   }

   public void setBuzonSalida(Buzon _salida){
    this.buzonSal = _salida;
   }

   public void setBuzonEntrada(Buzon _entrada){
    this.buzonEnt = _entrada;
   }

   public void crearProducto(int _cantidad){
        for (int i = 0; i < _cantidad; i++) {
            String mensaje = "Producto del proceso :" + this.id + " color: " + this.color;
            Producto producto = new Producto(i,mensaje, this.color);
            productos.add(producto);
        }
   }  
   
   public void printProductos(){
    for (int i = 0; i < productos.size(); i++) {
        System.out.println("=============================================");
        System.out.println(productos.get(i).getMensaje());
        System.out.println("=============================================");
    }
   }


}