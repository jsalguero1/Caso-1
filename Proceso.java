import java.lang.Thread;
import java.util.Random;
public class Proceso extends Thread{

    private int id;
    private Color color;
    private Buzon buzonEnt, buzonSal;
    private int contador = 0;
    private int cantidad = 0;

    public Proceso(int _id, Color _color, Buzon _buzonEnt, Buzon _buzonSal, int _cantidad){
        this.id = _id;
        this.color = _color;
        this.buzonEnt = _buzonEnt;
        this.buzonSal = _buzonSal;
        this.cantidad = _cantidad;
        this.cantidad = _cantidad;
    }

   @Override
   public void run() {
        while (true) {
        if (this.id < 100) {
            Producto producto = new Producto(this.id+contador, this.color);
            ChangeMessage(producto);
            this.buzonSal.agregarProducto(producto);
        }else {
            Producto producto = null;
            while (producto == null) {
                if (this.color == color.NARANJA){
                    producto = this.buzonEnt.sacaProductoNaranja();
                    this.yield();
                }
                else{
                    producto = this.buzonEnt.sacarProducto();
                }
            }
            ChangeMessage(producto);
            this.buzonSal.agregarProducto(producto);}

        if (this.contador == this.cantidad) {
            break;
        }
        this.contador++;
       }
   }

   public synchronized void ChangeMessage (Producto mensaje){
        Random random = new Random();
        int i = random.nextInt(500);
        try {
            this.sleep(i);
        } catch (Exception e) {
            // TODO: handle exception
        }
        mensaje.setMensaje(mensaje.getMensaje() + ", Proc." + this.id+" Sleep:"+i); 
   }

   public long getId(){
       return this.id;
   }

  



}