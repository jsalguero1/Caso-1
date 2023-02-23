import java.lang.Thread;
public class Proceso extends Thread{

    private int id;
    private Color color;
    private Buzon buzonEnt, buzonSal;
    private int contador = 0;
    private int cantidad = 0;

    public Proceso(int _id, Color _color, Buzon _buzonEnt, Buzon _buzonSal, int _cantidad, int _procesos){
        this.id = _id;
        this.color = _color;
        this.buzonEnt = _buzonEnt;
        this.buzonSal = _buzonSal;
        this.cantidad = _cantidad;
    }

   @Override
   public void run() {
        while (true) {
        if (this.id < 10) {
            Producto producto = new Producto(this.id+contador, this.color);
            ChangeMessage(producto);
            this.buzonSal.agregarProducto(producto);
        }else {
            Producto producto = this.buzonEnt.sacarProducto(this.color);
            if(producto != null) {
            ChangeMessage(producto);
            this.buzonSal.agregarProducto(producto);
            }
        }
        if (this.contador == this.cantidad) {
            break;
        }
       }
   }

   public synchronized void ChangeMessage (Producto mensaje){
         mensaje.setMensaje(mensaje.getMensaje() + " Proc." + this.id); 
   }

   public long getId(){
       return this.id;
   }



}