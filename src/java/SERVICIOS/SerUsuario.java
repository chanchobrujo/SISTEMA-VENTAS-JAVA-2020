/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVICIOS;

import LOGICA.*;

/**
 *
 * @author USUARIO
 */
public interface SerUsuario {
    public String grabarUsuario(String dni, String numero, String correo, String usuario, String idrol, String estado);
    public String grabarCliente(String nombre,String apellido,String numero, String correo, String usuario, String foto, String estado);
    public String actualizarUsuarioDatosPersonales(String id, String numero, String correo,String foto, String contra);
    public String actualizarUsuarioFoto(String id, String foto);
    public String actualizarUsuarioDatosEmpresariales(String id, String idrol, String estado);
    public String recuperarContraseña(String correo);
    public Usuarios validarempleado(String usuario,String contrasena);
    public Usuarios buscarUsuario(String id);
    public Usuarios buscarUsuarioPorcorreo(String correo);
}
