package LOGICA;

import java.util.UUID;

public class Productos {
    private String id;
    private String nombre;
    private String descri;
    private double precio;
    private Categoria Categoria;
    private int stock;
    private String foto;
    private String estado;

    public Productos() {
        this.id = ""+UUID.randomUUID().toString().toUpperCase().subSequence(0,6);
    }

    public Productos(String nombre, String descri, double precio, Categoria Categoria, int stock, String foto, String estado) {
        this.id = ""+UUID.randomUUID().toString().toUpperCase().subSequence(0,6);
        this.nombre = nombre;
        this.descri = descri;
        this.precio = precio;
        this.Categoria = Categoria;
        this.stock = stock;
        this.foto = foto;
        this.estado = estado;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescri() {
        return descri;
    }

    public void setDescri(String descri) {
        this.descri = descri;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Categoria getCategoria() {
        return Categoria;
    }

    public void setCategoria(Categoria Categoria) {
        this.Categoria = Categoria;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
