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
public interface SerCliente { 
    public Clientes buscarClientes(String dni);
    public String grabarClientes(String dni);
}
