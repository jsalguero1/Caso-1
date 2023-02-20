import java.lang.Thread;
public class Proceso extends Thread{

    private int id;
    private Color color;
    private Buzon buzonEnt, buzonSal;
    private int contador = 0;

    public Proceso(int _id, Color _color, Buzon _buzonEnt, Buzon _buzonSal){
        this.id = _id;
        this.color = _color;
        this.buzonEnt = _buzonEnt;
        this.buzonSal = _buzonSal;
    }

   @Override
   public void run() {
       
   }


}