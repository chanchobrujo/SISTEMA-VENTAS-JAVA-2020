/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import GESTOR.*;
import LOGICA.*;
import java.util.ArrayList;
import java.util.List;
//
/** 
 *
 * @author USUARIO
 */
public class DaoCategoriaIMP implements DaoCategoria{

    @Override
    public String grabar(Categoria e) {
        return Operación.ejecutar("INSERT INTO categoria(ID,CATEGORIA,ESTADO) VALUES ('"+e.getId()+"','"+e.getCategoria()+"','"+e.getEstado()+"')");
    }

    @Override
    public String actualizar(Categoria e) {
        return Operación.ejecutar("UPDATE categoria SET CATEGORIA='"+e.getCategoria()+"',ESTADO='"+e.getEstado()+"' WHERE categoria.ID='"+e.getId()+"'");
    }

    @Override
    public List listar1() {
        List lis = new ArrayList();
        List lista = Operación.listar("SELECT * FROM categoria");
        if(lista != null){
            for (int i = 1; i < lista.size(); i++) {
                Object[] fila = (Object[])lista.get(i);
                Categoria obj = new Categoria();
                obj.setId(fila[0].toString());
                obj.setCategoria(fila[1].toString());
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
        List lista = Operación.listar("SELECT * FROM categoria WHERE categoria.ESTADO='0'");
        if(lista != null){
            for (int i = 1; i < lista.size(); i++) {
                Object[] fila = (Object[])lista.get(i);
                Categoria obj = new Categoria();
                obj.setId(fila[0].toString());
                obj.setCategoria(fila[1].toString());
                obj.setEstado(fila[2].toString());
                lis.add(obj);
            }
            return lis; 
        }
        return null; 
    }

    @Override
    public Categoria buscar(String cod) {
        Object[]fila = Operación.buscar("SELECT * FROM categoria where id='"+cod+"'");
        if (fila!=null) {
            Categoria obj = new Categoria();
            obj.setId(fila[0].toString());
            obj.setCategoria(fila[1].toString());
            obj.setEstado(fila[2].toString());
            return obj;
        }
        return null; 
    }
    
}
