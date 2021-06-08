/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVICIOS;

import DAO.*;
import LOGICA.*;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public class SerProductoIMP implements SerProducto{
    private DaoProducto daop = new DaoProductosIMP();
    private DaoCategoria daoc = new DaoCategoriaIMP();
    
    @Override
    public Productos buscarProductos(String cod) {
        return daop.buscar(cod);
    }

    @Override
    public String grabarProductos(String nom, String des, double precio, String catid, int stock, String foto, String Est) {
        Productos obj = new Productos(nom, des, precio, daoc.buscar(catid), stock,foto,  Est);
        return daop.grabar(obj);
    }

    @Override
    public String actualizarProductos(String id, String nom, String des, double precio, String catid, int stock, String foto, String Est) { 
        Productos obj = new Productos(nom, des, precio, daoc.buscar(catid), stock,foto, Est);
        obj.setId(id);
        return daop.actualizar(obj);
        
    }

    @Override
    public List listarProductos() {
        return daop.ListarSer();
    }

    @Override
    public int cantidadProductos(String catid) {
        return daop.Cantidad(catid);
    }
    
}
