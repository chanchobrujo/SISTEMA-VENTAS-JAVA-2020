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
public interface SerRol {
    public Roles buscarRoles(String cod);
    public String grabarRoles(String rol,String es);
    public String actualizarRoles(String cod, String rol,String es);
}
