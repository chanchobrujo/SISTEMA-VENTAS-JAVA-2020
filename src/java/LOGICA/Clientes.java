/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LOGICA;
import com.google.gson.*;
import java.io.*;
import java.net.*;

public class Clientes {
    private String dni,nombres,apellido;

    public Clientes() {}

    public Clientes(String dni) {
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
            this.apellido = jo.get("apellido_paterno").getAsString()+" "+jo.get("apellido_materno").getAsString();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
}
