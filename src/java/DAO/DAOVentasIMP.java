/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import GESTOR.*;
import LOGICA.*;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public class DAOVentasIMP implements DAOVentas{
    private DaoProducto daoProducto = new DaoProductosIMP();
    @Override
    public String grabarVentasParaUsuarioCliente(Venta Venta) {
        return Operación.ejecutar("INSERT INTO venta VALUES ('"+Venta.getNum()+"',null,'"+Venta.getUsuario().getId()+"','"+Venta.getdes()+"','"+Venta.getFecha()+"','"+Venta.getHora()+"','"+Venta.getTotal()+"','"+Venta.getLa()+"','"+Venta.getLo()+"','"+Venta.getEstado()+"')");
    }

    @Override
    public String grabarVentasParaUsuarioEmpl(Venta Venta) {
        String sql = "";
        if (Venta.getCliente()!=null) {
            sql = "INSERT INTO venta VALUES ('"+Venta.getNum()+"','"+Venta.getCliente().getDni()+"','"+Venta.getUsuario().getId()+"',0,'"+Venta.getFecha()+"','"+Venta.getHora()+"',"+Venta.getTotal()+",null,null,'Hecho')";
        }else{
            sql = "INSERT INTO venta VALUES ('"+Venta.getNum()+"',null,'"+Venta.getUsuario().getId()+"',0,'"+Venta.getFecha()+"','"+Venta.getHora()+"',"+Venta.getTotal()+",null,null,'Hecho')";
        }
        
        return Operación.ejecutar(sql);
    }

    @Override
    public String grabarDetalle(Venta Venta, List Detalle) {
        try {
            for (int i = 0; i < Detalle.size(); i++) {
                Object[] fila = (Object[])Detalle.get(i);
                Operación.ejecutar("INSERT INTO detalle(VENTAID,PRODUCTOID,CANTIDAD) VALUES ('"+Venta.getNum()+"','"+fila[0].toString()+"',"+Integer.parseInt(fila[4].toString())+")");
                if (daoProducto.buscar(fila[0].toString()).getStock() >= Integer.parseInt(fila[4].toString())) {
                    Operación.ejecutar("UPDATE producto set STOCK=STOCK-"+Integer.parseInt(fila[4].toString())+" WHERE producto.ID='"+fila[0].toString()+"' ");
                }
                Operación.ejecutar("UPDATE producto SET ESTADO='1' WHERE producto.STOCK=0");
            }
            return "";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public List listarVentaPorusuario(String idusuario) {
        List lista = Operación.listar("SELECT venta.ID as 'CODIGO',venta.FECHA as 'FECHA',venta.HORA as 'HORA',venta.TOTAL as 'TOTAL',venta.ESTADO as 'ESTADO' FROM venta inner join detalle on venta.ID=detalle.VENTAID WHERE venta.USUARIOID ='"+idusuario+"' GROUP BY venta.ID");
        if(lista != null){
            return lista; 
        }
        return null; 
    }

    @Override
    public List listarVentaEmpRep() {
        String sql = "SELECT venta.ID, USUARIO.NOMBRES,USUARIO.APELLIDOS,venta.FECHA,venta.HORA,venta.LA,venta.lo,venta.ESTADO FROM venta INNER JOIN USUARIO on USUARIO.ID = venta.USUARIOID where venta.ESTADO='Porenviar' GROUP by venta.ID";
        List lista = Operación.listar(sql);
        if(lista != null){
            return lista; 
        }
        return null;
    }

    @Override
    public List listardetalle(String id) {
        String sql = "SELECT producto.NOMBRE, producto.DESCRIPCION, detalle.CANTIDAD FROM venta inner join detalle on venta.id=detalle.VENTAID inner join producto on producto.id=detalle.PRODUCTOID where venta.id='"+id+"'";
        List lista = Operación.listar(sql);
        if(lista != null){
            return lista; 
        }
        return null;
    }

    @Override
    public void entregar(String id) {
        Operación.ejecutar("UPDATE venta set ESTADO='Entregado' WHERE venta.ID='"+id+"'");
    }
    
}

//UPDATE producto set STOCK=STOCK-7 WHERE producto.ID='3A4EA3' 
//SELECT producto.STOCK from producto WHERE producto.ID='3A4EA3'
//IF(expression ,expr_true, expr_false); 
