/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVICIOS;

import LOGICA.*;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public interface SerProducto { //
    public Productos buscarProductos(String cod);
    public String grabarProductos(String nom,String des,double precio,String catid,int stock, String foto,String Est);
    public String actualizarProductos(String id,String nom,String des,double precio,String catid,int stock, String foto,String Est);
    public List listarProductos();
    public int cantidadProductos(String catid);
}
