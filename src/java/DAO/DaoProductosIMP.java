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

/**
 *
 * @author USUARIO
 */
public class DaoProductosIMP implements DaoProducto{

    @Override
    public String grabar(Productos e) {
        return Operación.ejecutar("INSERT INTO producto VALUES ('"+e.getId()+"','"+e.getNombre()+"','"+e.getDescri()+"',"+e.getPrecio()+",'"+e.getCategoria().getId()+"',"+e.getStock()+",'"+e.getFoto()+"','"+e.getEstado()+"')");
    }

    @Override
    public String actualizar(Productos e) {
        return Operación.ejecutar("UPDATE producto SET NOMBRE='"+e.getNombre()+"',DESCRIPCION='"+e.getDescri()+"',PRECIO="+e.getPrecio()+",CATEGORIA='"+e.getCategoria().getId()+"',STOCK="+e.getStock()+", ESTADO='"+e.getEstado()+"',FOTO='"+e.getFoto()+"' WHERE producto.ID='"+e.getId()+"'");
    }

    @Override
    public List listar1() {
        List lis = new ArrayList();
        List lista = Operación.listar("SELECT * FROM producto");
        if(lista != null){
            for (int i = 1; i < lista.size(); i++) {
                Object[] fila = (Object[])lista.get(i);
                Productos obj = new Productos();
                DaoCategoria daoc = new DaoCategoriaIMP();
                obj.setId(fila[0].toString());
                obj.setNombre(fila[1].toString());
                obj.setDescri(fila[2].toString());
                obj.setPrecio(Double.parseDouble(fila[3].toString()));
                obj.setCategoria(daoc.buscar(fila[4].toString()));
                obj.setStock(Integer.parseInt(fila[5].toString()));
                obj.setFoto(fila[6].toString());
                obj.setEstado(fila[7].toString());
                lis.add(obj);
            }
            return lis; 
        }
        return null; 
    }

    @Override
    public List listar2() {
        List lis = new ArrayList();
        List lista = Operación.listar("SELECT * FROM producto WHERE producto.ESTADO='0'");
        if(lista != null){
            for (int i = 1; i < lista.size(); i++) {
                Object[] fila = (Object[])lista.get(i);
                Productos obj = new Productos();
                DaoCategoria daoc = new DaoCategoriaIMP();
                obj.setId(fila[0].toString());
                obj.setNombre(fila[1].toString());
                obj.setDescri(fila[2].toString());
                obj.setPrecio(Double.parseDouble(fila[3].toString()));
                obj.setCategoria(daoc.buscar(fila[4].toString()));
                obj.setStock(Integer.parseInt(fila[5].toString()));
                obj.setFoto(fila[6].toString());
                obj.setEstado(fila[7].toString());
                lis.add(obj);
            }
            return lis; 
        }
        return null; 
    }

    @Override
    public Productos buscar(String cod) {
        Object[]fila = Operación.buscar("SELECT * FROM producto where id='"+cod+"'");
        if (fila!=null) {
                Productos obj = new Productos();
                DaoCategoria dao= new DaoCategoriaIMP();
                obj.setId(fila[0].toString());
                obj.setNombre(fila[1].toString());
                obj.setDescri(fila[2].toString());
                obj.setPrecio(Double.parseDouble(fila[3].toString()));
                obj.setCategoria(dao.buscar(fila[4].toString()));
                obj.setStock(Integer.parseInt(fila[5].toString()));
                obj.setFoto(fila[6].toString());
                obj.setEstado(fila[7].toString());
                return obj;
        }
        return null; 
    }

    @Override
    public List listar3(String cat) {
        List lis = new ArrayList();
        List lista = Operación.listar("SELECT * FROM producto WHERE producto.CATEGORIA='" +cat+ "'");
        if(lista != null){
            for (int i = 1; i < lista.size(); i++) {
                Object[] fila = (Object[])lista.get(i);
                Productos obj = new Productos();
                DaoCategoria daoc = new DaoCategoriaIMP();
                obj.setId(fila[0].toString());
                obj.setNombre(fila[1].toString());
                obj.setDescri(fila[2].toString());
                obj.setPrecio(Double.parseDouble(fila[3].toString()));
                obj.setCategoria(daoc.buscar(fila[4].toString()));
                obj.setStock(Integer.parseInt(fila[5].toString()));
                obj.setFoto(fila[6].toString());
                obj.setEstado(fila[7].toString());
                lis.add(obj);
            }
            return lis; 
        }
        return null; 
    }

    @Override
    public int Cantidad(String cat) {
        List lis = new ArrayList();
        List lista = Operación.listar("SELECT * FROM producto WHERE producto.CATEGORIA='" +cat+ "' and  producto.ESTADO='0'");
        if(lista != null){
            for (int i = 1; i < lista.size(); i++) {
                Object[] fila = (Object[])lista.get(i);
                Productos obj = new Productos();
                DaoCategoria daoc = new DaoCategoriaIMP();
                obj.setId(fila[0].toString());
                obj.setNombre(fila[1].toString());
                obj.setDescri(fila[2].toString());
                obj.setPrecio(Double.parseDouble(fila[3].toString()));
                obj.setCategoria(daoc.buscar(fila[4].toString()));
                obj.setStock(Integer.parseInt(fila[5].toString()));
                obj.setFoto(fila[6].toString());
                obj.setEstado(fila[7].toString());
                lis.add(obj);
            }
            return lis.size(); 
        }
        return 0; 
    }

    @Override
    public List ListarSer() {
        String sql = "SELECT * FROM producto WHERE producto.ESTADO='0'";
        List lista = Operación.listar(sql);
        if(lista != null){
            return lista; 
        }
        return null; 
    }
    
}
