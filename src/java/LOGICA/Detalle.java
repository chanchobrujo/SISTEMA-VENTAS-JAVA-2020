package LOGICA;

public class Detalle {
    private String num;
    private Productos prod;
    private int cantidad;

    public Detalle(String num, Productos prod, int cantidad) {
        this.num = num;
        this.prod = prod;
        this.cantidad = cantidad;
    }
     
    public double getImpor(){
        return prod.getPrecio()*cantidad;
    }    

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public Productos getProd() {
        return prod;
    }

    public void setProd(Productos prod) {
        this.prod = prod;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
}
