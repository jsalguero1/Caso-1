import java.util.ArrayList;

public class Buzon{
    private int tamano;
    private ArrayList<Producto> productos = new ArrayList<>();

    public Buzon(){
    }

    public void setSize(int _size){
        this.tamano = _size;
    }

    public void recibirProducto(Producto _producto){
        if(productos.size() < tamano){
            productos.add(_producto);
        }
        else{
            
        }
    }

    public void entregarMensaje(){
        if(productos.size() > 0){

        }
    }
}