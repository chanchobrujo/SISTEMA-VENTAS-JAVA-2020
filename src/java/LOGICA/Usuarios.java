/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LOGICA;

import GESTOR.EnviarCorreo;
import java.util.UUID;
import com.google.gson.*;
import java.io.*;
import java.net.*;

/**
 *
 * @author USUARIO
 */
public class Usuarios {
    private String id,dni,nombres,apellidos,numero,correo,usuario,contra;
    private Roles rol;
    private String foto,estado;
    
    public Usuarios() {
    }

    public Usuarios(String id,String usuario,String correo,String numero) {
        this.id = id;
        this.usuario = usuario;
        this.correo = correo;
        this.numero = numero;
        this.contra = ""+UUID.randomUUID().toString().toUpperCase().subSequence(0,25);
        EnviarCorreo.reestablecerContrasena(correo, "Bienvenido(a)! "+this.usuario,this.contra);
    }
    
    public Usuarios(String dni) {
        this.id = ""+UUID.randomUUID().toString().toUpperCase().subSequence(0,4);
        this.dni = dni;
        try {
            String url = "https://api.reniec.cloud/dni/"+dni;
            URL u = new URL(url);
            URLConnection re = u.openConnection();
            re.connect();
            JsonParser jp = new JsonParser();
            JsonElement root = jp.parse(new InputStreamReader((InputStream)re.getContent()));
            JsonObject jo = root.getAsJsonObject();
            this.nombres = jo.get("nombres").getAsString();
            this.apellidos = jo.get("apellido_paterno").getAsString()+" "+jo.get("apellido_materno").getAsString();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Usuarios(String dni,String numero, String correo, String usuario, Roles rol, String estado) {
        this.id = ""+UUID.randomUUID().toString().toUpperCase().subSequence(0,4);
        this.dni = dni;
        try {
            String url = "https://api.reniec.cloud/dni/"+dni;
            URL u = new URL(url);
            URLConnection re = u.openConnection();
            re.connect();
            JsonParser jp = new JsonParser();
            JsonElement root = jp.parse(new InputStreamReader((InputStream)re.getContent()));
            JsonObject jo = root.getAsJsonObject();
            this.nombres = jo.get("nombres").getAsString();
            this.apellidos = jo.get("apellido_paterno").getAsString()+" "+jo.get("apellido_materno").getAsString();
            this.numero = numero;
            this.correo = correo;
            this.usuario = usuario;
            this.contra = ""+UUID.randomUUID().toString().toUpperCase().subSequence(0,25);
            EnviarCorreo.generarContrasena(correo, "Bienvenido(a)! "+this.usuario,this.contra);
            this.rol = rol;
            this.estado = estado;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }

    public Usuarios(String nombres, String apellidos, String numero, String correo, String usuario, Roles rol,String foto, String estado) {
        this.id = ""+UUID.randomUUID().toString().toUpperCase().subSequence(0,4);
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.numero = numero;
        this.correo = correo;
        this.usuario = usuario;
        this.contra = ""+UUID.randomUUID().toString().toUpperCase().subSequence(0,25);
        EnviarCorreo.generarContrasena(correo, "Bienvenido(a)! "+this.usuario+".", this.contra);
        this.rol = rol;
        this.foto = foto;
        this.estado = estado;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
    
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public Roles getRol() {
        return rol;
    }

    public void setRol(Roles rol) {
        this.rol = rol;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
