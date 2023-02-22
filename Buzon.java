import java.util.LinkedList;
import java.util.List;

public class Buzon{
    private int tamano;
    private List<Producto> productos = new LinkedList<Producto>();

    public Buzon(int _tamano){
        this.tamano = _tamano;
    }

    public synchronized void agregarProducto(Producto _producto){
        while (this.productos.size() == this.tamano) {
            try {
                wait();
            } catch (Exception e) {
                }
            }
            this.productos.add(_producto);  
            System.out.println("El tamaño del buzon escrito: " + hasProducto());
            notifyAll();
        }
    public synchronized int hasProducto(){
        return this.productos.size();
    }

    public synchronized Producto sacarProducto(){
        while (this.productos.size() == 0) {
            try {
                wait();
            } catch (Exception e) {
                }
            }     
            Producto message = this.productos.remove(productos.size() - 1);
            notifyAll();
            return  message;
        }
        
    }

    