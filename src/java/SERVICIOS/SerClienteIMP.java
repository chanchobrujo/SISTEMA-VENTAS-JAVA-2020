/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVICIOS;

import DAO.*;
import LOGICA.*;

/**
 *
 * @author USUARIO
 */
public class SerClienteIMP implements SerCliente{
    private DaoCliente daocli = new DaoClienteIMP();
    
    @Override
    public Clientes buscarClientes(String dni) {
        Clientes clientes = new Clientes(dni);
        return clientes;
    }

    @Override
    public String grabarClientes(String dni) {
        Clientes obj = new Clientes(dni);
        return daocli.grabar(obj);
    }
    
}
