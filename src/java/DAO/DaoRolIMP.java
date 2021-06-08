/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import GESTOR.Operación;
import LOGICA.Roles;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public class DaoRolIMP implements DaoRol{

    @Override
    public String grabar(Roles obj) {
        return Operación.ejecutar("INSERT INTO rol VALUES ('"+obj.getId()+"','"+obj.getRol()+"','"+obj.getEstado()+"')");
    }


    @Override
    public Roles buscar(String cod) {
        Object[]fila = Operación.buscar("SELECT * FROM rol WHERE rol.ID='"+cod+"'");
        if (fila!=null) {
                Roles obj = new Roles();
                obj.setId(fila[0].toString());
                obj.setRol(fila[1].toString());
                obj.setEstado(fila[2].toString());
                return obj;
        }
        return null; 
    }


    @Override
    public String actualizar(Roles obj) {
        return Operación.ejecutar("UPDATE rol SET ROL='"+obj.getRol()+"',ESTADO="+obj.getEstado()+" WHERE rol.ID='"+obj.getId()+"'");
    }
    
    @Override
    public List listar1() {
        List lis = new ArrayList();
        List lista = Operación.listar("SELECT * FROM rol");
        if(lista != null){
            for (int i = 1; i < lista.size(); i++) {
                Object[] fila = (Object[])lista.get(i);
                Roles obj = new Roles();
                obj.setId(fila[0].toString());
                obj.setRol(fila[1].toString());
                obj.setEstado(fila[2].toString());
                lis.add(obj);
            }
            return lis; 
        }
        return null; 
    }
    
    @Override
    public List listar2() {
        List lis = new ArrayList();
        List lista = Operación.listar("SELECT * FROM rol WHERE rol.ESTADO = '0' ");
        if(lista != null){
            for (int i = 1; i < lista.size(); i++) {
                Object[] fila = (Object[])lista.get(i);
                Roles obj = new Roles();
                obj.setId(fila[0].toString());
                obj.setRol(fila[1].toString());
                obj.setEstado(fila[2].toString());
                lis.add(obj);
            }
            return lis; 
        }
        return null; 
    }
}
