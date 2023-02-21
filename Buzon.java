import java.util.ArrayList;

public class Buzon{
    private int tamano;
    private ArrayList<Producto> productos = new ArrayList<>();

    public Buzon(){
    }

    public void setSize(int _size){
        this.tamano = _size;
    }
}