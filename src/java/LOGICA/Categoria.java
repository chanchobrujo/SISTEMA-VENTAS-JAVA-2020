/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LOGICA;

import java.util.UUID;

/**
 *
 * @author USUARIO
 */
public class Categoria {
    private String id;
    private String Categoria;
    private String estado;

    public Categoria() {
        this.id = ""+UUID.randomUUID().toString().toUpperCase().subSequence(0,4);
    }

    public Categoria(String Categoria, String estado) {
        this.id = ""+UUID.randomUUID().toString().toUpperCase().subSequence(0,4);
        this.Categoria = Categoria;
        this.estado = estado;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
