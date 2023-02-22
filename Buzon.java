import java.util.ArrayList;

public class Buzon{
    private int tamano= 0;
    private ArrayList<Producto> productos = new ArrayList<>();

    /**
     * Constructor
     */
    public Buzon(){
    }

    /**
     * Da tamño al buzon
     * @param _size tamaño del buzon
     */
    public void setSize(int _size){
        this.tamano = _size;
    }

    /**
     * Recibe un producto
     * @param _producto producto a recbir
     * @param _thread thread que esta dejando producto en el buzón
     * @throws InterruptedException
     */
    public synchronized void recibirProducto(Producto _producto, Proceso _thread){
        if (this.productos.size() == tamano){
            if(_thread.getColor() == Color.AZUL){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else if (_thread.getColor() == Color.NARANJA){
                Thread.yield();
            }
        }
        else{
            this.productos.add(_producto);
            notifyAll();
        }
    }

    /**
     * Entrega un producto
     * @param _thread thread que recibe el producto en el buzon
     */
    public void entregarMensaje(Proceso _thread){

    }
}