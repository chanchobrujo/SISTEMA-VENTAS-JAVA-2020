/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import LOGICA.Usuarios;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public interface DaoUsuario {
    public String grabar(Usuarios e);
    public String actualizarDatosPersonales(Usuarios e);
    public String actualizarDatosEmpresariales(Usuarios e);
    public String actualizarFoto(Usuarios e);
    public List listarTodos();
    public List listarActivos();
    public Usuarios buscar(String cod); 
    public Usuarios buscarPorCorreo(String correo); 
}
