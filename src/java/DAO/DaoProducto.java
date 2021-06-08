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
public interface DaoProducto {
    public String grabar(Productos e);
    public String actualizar(Productos e);
    public List listar1();
    public List listar2();
    public List listar3(String cat);
    public List ListarSer();
    
    public int Cantidad(String cat);
    public Productos buscar(String cod); 
}
