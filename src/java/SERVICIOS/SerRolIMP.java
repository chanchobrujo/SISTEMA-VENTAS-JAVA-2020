/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVICIOS;

import LOGICA.*;
import DAO.*;

/**
 *
 * @author USUARIO
 */
public class SerRolIMP implements SerRol{
    private DaoRol DaoRol=new DaoRolIMP();
    
    @Override
    public Roles buscarRoles(String cod) {
        return DaoRol.buscar(cod);
    }

    @Override
    public String grabarRoles(String rol, String es) {
        Roles e = new Roles(rol, es);
        return DaoRol.grabar(e);
    }

    @Override
    public String actualizarRoles(String cod, String rol, String es) {
        Roles e = new Roles(rol, es);
        e.setId(cod);
        return DaoRol.actualizar(e);
    }
    
    
}
