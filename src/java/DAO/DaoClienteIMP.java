/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import GESTOR.Operación;
import LOGICA.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public class DaoClienteIMP implements DaoCliente{

    @Override
    public String grabar(Clientes e) {
        return Operación.ejecutar("INSERT INTO cliente VALUES ('"+e.getDni()+"','"+e.getNombres()+"','"+e.getApellido()+"')");
    }

    @Override
    public Clientes buscar(String cod) {
        Object[]fila = Operación.buscar("SELECT * FROM cliente where dni='"+cod+"'");
        if (fila!=null) {
            Clientes obj = new Clientes();
            obj.setDni(fila[0].toString());
            obj.setNombres(fila[1].toString());
            obj.setApellido(fila[2].toString());
            return obj;
        }
        return null; 
    }
    
}
