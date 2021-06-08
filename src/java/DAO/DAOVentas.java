/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import LOGICA.*;
import java.util.List;
//
/**
 *
 * @author USUARIO
 */
public interface DAOVentas {
    public String grabarVentasParaUsuarioCliente(Venta Venta);
    public String grabarVentasParaUsuarioEmpl(Venta Venta);
    public String grabarDetalle(Venta Venta, List Detalle);
    public List listarVentaPorusuario(String idusuario);
    public List listarVentaEmpRep();
    public List listardetalle(String id);
    public void entregar(String id);
}
