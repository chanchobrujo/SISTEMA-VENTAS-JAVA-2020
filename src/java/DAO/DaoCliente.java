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
public interface DaoCliente {
    public String grabar(Clientes e);
    public Clientes buscar(String cod); 
}
