public class Final extends Thread {

    private Color color;
    private Buzon buzonEnt;
    private int contador = 0;
    private int cantidad = 0;

    public Final(Color _color, Buzon _buzonEnt, int _contador) {
        this.color = _color;
        this.buzonEnt = _buzonEnt;
        this.cantidad = _contador;
    }
    
    @Override
    public void run() {
       
        while (true) {
            Producto producto = this.buzonEnt.sacarProducto();
            System.out.println("El proceso " + color + " ha sacado el producto: " + producto.getColor() + ", con mensaje: " + producto.getMensaje());
            this.contador++;          
            if (this.contador == this.cantidad) {
                break;
            }
        }
    }
}
