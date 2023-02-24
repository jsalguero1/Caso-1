import java.util.ArrayList;

public class Buzon{
    private int tamano;
    private ArrayList<Producto> productos = new ArrayList<>();

    public Buzon(int _tamano){
        this.tamano = _tamano;
    }

    public synchronized void agregarProducto(Producto _producto){
        if (this.productos.size() == this.tamano) {
            try {
                wait();
            } catch (Exception e) {
                }
        }else{
            this.productos.add(_producto);  
            notifyAll();
        }
        }


    public synchronized int hasProducto(){
        return this.productos.size();
    }

    public synchronized Producto sacarProducto(){
        Producto message = null;
        while (this.productos.size() == 0) {
            try {
                wait();
            } catch (Exception e) {
            }}
            int i = 1;
            if (productos.size() == 0){
                return null;
            }
            while(productos.get(productos.size()-i).getColor() != Color.AZUL){
                i++;
                if ( productos.size()-i == 0){
                    return null;
                }
            }
            message = this.productos.remove(productos.size()-i);
            notifyAll();
            return  message;
    }

    public synchronized Producto sacaProductoNaranja(){
        Producto message = null;
        int i = 1;
        if (productos.size() == 0){
            return null;
        }
        while(productos.get(productos.size()-i).getColor() != Color.NARANJA){
            i++;
            if ( productos.size()-i == 0){
                return null;
            }
        }
        message = this.productos.remove(productos.size()-i);
        notifyAll();
        return  message;
    }
}

    