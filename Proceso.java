import java.lang.Thread;
public class Proceso extends Thread{

    private int id;
    private Color color;
    private Buzon buzonEnt, buzonSal;
    private int contador = 0;
    private int cantidad = 0;
    private int procesos = 0;

    public Proceso(int _id, Color _color, Buzon _buzonEnt, Buzon _buzonSal, int _cantidad, int _procesos){
        this.id = _id;
        this.color = _color;
        this.buzonEnt = _buzonEnt;
        this.buzonSal = _buzonSal;
        this.cantidad = _cantidad;
        this.procesos = _cantidad;
    }

   @Override
   public void run() {
       while (true) {
        if (this.id < 14+this.procesos) {
            Producto producto = new Producto(this.id, this.color);
            ChangeMessage(producto);
            this.buzonEnt.agregarProducto(producto);
        }else {
            Producto producto = this.buzonEnt.sacarProducto();
            ChangeMessage(producto);
            this.buzonSal.agregarProducto(producto);
            System.out.println("El proceso " + id + " ha sacado el producto " + producto.getId() + " con mensaje " + producto.getMensaje());
        }
            this.contador++;
            if (this.contador == 10) {
               break;
           }
       }
   }

   public void ChangeMessage (Producto mensaje){
         mensaje.setMensaje(mensaje.getMensaje() + " " + this.id); 
   }



}