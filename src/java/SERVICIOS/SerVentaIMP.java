/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVICIOS;

import LOGICA.*;
import DAO.*;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public class SerVentaIMP implements SerVenta{
    private DAOVentas DAOVentas;
    private SerProducto SerProducto; 
    private SerCliente SerCliente;
    private SerUsuario SerUsuario;
    
    private Venta Venta = new Venta();

    public SerVentaIMP() {
        DAOVentas = new DAOVentasIMP();
        SerProducto = new SerProductoIMP(); 
        SerCliente = new SerClienteIMP();
        SerUsuario = new SerUsuarioIMP();
    }
    
    
    
    @Override
    public Venta nuevaVenta(String codUsuario, double pordes) {
        Venta = new Venta();
        Venta.setUsuario(SerUsuario.buscarUsuario(codUsuario));
        Venta.setpordes(pordes);
        return Venta;
    }

    @Override
    public void quitarLinea(String codProd) {
        Venta.quitar(codProd);
    }

    @Override
    public void agregarLinea(String codProd,int cantidad) {
        Venta.agregar(SerProducto.buscarProductos(codProd), cantidad);
    }

    @Override
    public List ListarProductos() {
        return SerProducto.listarProductos();
    }

    @Override
    public String grabarVentasParaUsuarioCliente(String codUsuario, String la, String lo,List detalle) {
        try {
            Venta.setUsuario(SerUsuario.buscarUsuario(codUsuario));
            Venta.setLa(la);
            Venta.setLo(lo);
            Venta.setEstado("PorEnviar");
            
            return DAOVentas.grabarVentasParaUsuarioCliente(Venta)+" "+DAOVentas.grabarDetalle(Venta, detalle);
        } catch (Exception e) {
            return e.getMessage();
        }
        
    }

    @Override
    public List ventasPorUsuario(String usuario) {
        
        return DAOVentas.listarVentaPorusuario(usuario);
        
    }

    @Override
    public void vaciarCarrito() {
        Venta.vaciarCarrito();
    }

    @Override
    public String grabarVentasParaUsuarioEmpl(String codUsuario, String dni, List detalle) {
        try {
            if (!(dni.equals("-"))) {
                SerCliente.grabarClientes(dni);
                Venta.setCliente(SerCliente.buscarClientes(dni));
                Venta.setUsuario(SerUsuario.buscarUsuario(codUsuario));
                return DAOVentas.grabarVentasParaUsuarioEmpl(Venta)+" "+DAOVentas.grabarDetalle(Venta, detalle);
            }else{
                Venta.setCliente(null);
                Venta.setUsuario(SerUsuario.buscarUsuario(codUsuario));
                return DAOVentas.grabarVentasParaUsuarioEmpl(Venta)+" "+DAOVentas.grabarDetalle(Venta, detalle);
            }
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public List listarVentaEmpRep() {
        if (DAOVentas.listarVentaEmpRep()!=null) {
            return DAOVentas.listarVentaEmpRep();
        }
        return null;
    }

    @Override
    public List listarDetEmpRep(String id) {
        if (DAOVentas.listardetalle(id)!=null) {
            return DAOVentas.listardetalle(id);
        }
        return null;
    }

    @Override
    public void entregar(String id) {
        DAOVentas.entregar(id);
    }
    
}
