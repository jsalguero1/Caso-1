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
            notifyAll();
        }
    public synchronized int hasProducto(){
        return this.productos.size();
    }

    public synchronized Producto sacarProducto(Color color){
        while (this.productos.size() == 0) {
            try {
                wait();
            } catch (Exception e) {
                }
            }     
            int i =0;
            while(productos.get(i).getColor() == color ||color == Color.ROJO) {
                i++;
                if (i==productos.size()){
                    i=0;
                    try {
                        wait();
                    } catch (Exception e) {
                        }
                }
            }
            Producto message = this.productos.remove(productos.size() - i);
            notifyAll();
            return  message;
        }
    }

    