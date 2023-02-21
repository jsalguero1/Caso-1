import java.util.ArrayList;

public class Buzon{
    private int tamano;
    private ArrayList<Producto> productos = new ArrayList<>();

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
            notify();     
        }

    public synchronized Producto sacarProducto(){
        while (this.productos.size() == 0) {
            try {
                wait();
            } catch (Exception e) {
                }
            }     
            Producto message = this.productos.remove(productos.size() - 1);
            notify();
            return  message;
        }
    }