public class Producto{
    private int id;
    private Color color;
    private String mensaje;

    public Producto(int ids , Color color){
        this.id = ids;
        this.color = color;
        this.mensaje = "";
    }

    public int getId(){
        return this.id;
    }

    public Color getColor(){
        return this.color;
    }

    public String getMensaje(){
        return this.mensaje;
    }

    public void setMensaje(String string) {
        this.mensaje = string;
    }

}