public class Producto{
    private int id;
    private Color color;
    private String mensaje;

    public Producto(int _id, String _mensaje, Color _color){
        this.id = _id;
        this.mensaje = _mensaje;
        this.color = _color;
    }

    public int getId() {
        return id;
    }

    public String getMensaje() {
        return mensaje;
    }

    public Color getColor() {
        return color;
    }

    public void setMensaje(String _marca){
        this.mensaje.concat(" " + _marca);
    }

}