public class Final extends Thread {

    private Color color;
    private Buzon buzonEnt;
    private int contador = 0;
    private int cantidad = 0;

    Final(Color _color, Buzon _buzonEnt, int _contador) {
        this.color = _color;
        this.buzonEnt = _buzonEnt;
        this.contador = _contador;
    }
    
    @Override
    public void run() {
       
        while (true) {
            Producto producto = this.buzonEnt.sacarProducto(this.color);
            System.out.println("El proceso " + color + " ha sacado el producto: " + producto.getId() + ", con mensaje: " + producto.getMensaje());
            this.contador++;          
            if (this.contador == this.cantidad) {
                break;
            }
        }
    }
}
