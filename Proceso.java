import java.lang.Thread;
import java.util.ArrayList;
public class Proceso extends Thread{

    private int id;
    private Color color;
    private Buzon buzonEnt, buzonSal;
    private ArrayList<Producto> productos = new ArrayList<>();

    public Proceso(int _id, Color _color){
        this.id = _id;
        this.color = _color;
    }

   public void setBuzonSalida(Buzon _salida){
    this.buzonSal = _salida;
   }

   public void setBuzonEntrada(Buzon _entrada){
    this.buzonEnt = _entrada;
   }

   public Color getColor() {
       return color;
   }

   public int getIdProceso() {
       return id;
   }

   public ArrayList<Producto> getProductos() {
       return productos;
   }

   public void agregarProducto(Producto _producto){
    this.productos.add(_producto);
   }

   @Override
   public void run() {
    System.out.println("THREAD: " + this.id + " color: " + this.color + " creado");
    if(this.id < Main.procesos){
        crearProducto(Main.productos);
    }
    
    if(this.color != Color.ROJO){

        int i = 0;
        while(this.productos.size() > 1){
            Producto producto = productos.get(i);
            buzonSal.recibirProducto(producto, this);
        }
    }      

   }

   /**
    * Crea un producto
    * @param _cantidad cantidad de productos a ser creados
    */
   public void crearProducto(int _cantidad){
        for (int i = 0; i < _cantidad; i++) {
            String mensaje = "Color: " + getColor() + " Thread original: " + getIdProceso() + " marcas: ";
            Producto producto = new Producto(i,mensaje, this.color);
            productos.add(producto);
        }
   }  
}