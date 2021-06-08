/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import LOGICA.*;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public interface DaoRol {
    public String grabar(Roles e);
    public String actualizar(Roles e);
    public List listar1();
    public List listar2();
    public Roles buscar(String cod); 
}
