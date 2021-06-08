/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import LOGICA.Categoria;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public interface DaoCategoria { //DaoCategoria
    
    public String grabar(Categoria e);
    public String actualizar(Categoria e);
    public List listar1();
    public List listar2();
    public Categoria buscar(String cod); 
}
