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
public class Roles {
    private String id;
    private String rol;
    private String estado;

    public Roles() {
        this.id = ""+UUID.randomUUID().toString().toUpperCase().subSequence(0,3);
    }

    public Roles(String rol, String estado) {
        this.id = ""+UUID.randomUUID().toString().toUpperCase().subSequence(0,3);
        this.rol = rol;
        this.estado = estado;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
