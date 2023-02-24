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

    public synchronized Producto sacarProducto(Color color){
        Producto message = null;
        if (this.productos.size() == 0) {
            try {
                wait();
            } catch (Exception e) {
            }
        }else{
            int i =0;
            while(productos.get(i).getColor() == color ||color == Color.ROJO) {
                if (i == productos.size()-1){
                    try {
                        wait();
                    } 
                    catch (Exception e) {
                    }
                    finally{
                        notifyAll();
                    }
                }else{
                    message = this.productos.remove(i);
                    notifyAll();
                }
            }
        }
        return  message;
    }
}

    