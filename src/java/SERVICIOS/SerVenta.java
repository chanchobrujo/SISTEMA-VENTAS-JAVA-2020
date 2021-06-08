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
public interface SerVenta {
    public Venta nuevaVenta(String codUsuario, double pordes);
    public void quitarLinea(String codProd);
    public void agregarLinea(String codProd,int cantidad);
    public void vaciarCarrito();
    public List ListarProductos();
    public String grabarVentasParaUsuarioCliente(String codUsuario, String la,String lo,List detalle);
    public String grabarVentasParaUsuarioEmpl(String codUsuario,String dni,List detalle);
    public List ventasPorUsuario(String usuario);
    public List listarVentaEmpRep();
    public List listarDetEmpRep(String id);
    public void entregar(String id);
}
