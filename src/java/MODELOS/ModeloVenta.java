/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELOS;

import SERVICIOS.*;
import LOGICA.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public class ModeloVenta {
    private Venta Venta;
    private List listProductos;
    private List listVentaPorusuario;

    public List getListVentaPorusuario(String idu) {
        SerVenta SerVenta = new SerVentaIMP();
        return SerVenta.ventasPorUsuario(idu);
    }
    
    public ModeloVenta(Venta Venta) {
        this.Venta = Venta;
    }

    public List getProductos() {
        return listProductos;
    }

    public void setProductos(List listProductos) {
        this.listProductos = listProductos;
    }
    
    public List getCes() throws Exception{
        List lis = new ArrayList();
        for (int i = 0; i < Venta.getCesta().size(); i++) {
            Detalle linea = (Detalle)Venta.getCesta().get(i);
            Object[]filas = new Object[6];
            filas[0]=linea.getProd().getId();
            filas[1]=linea.getProd().getNombre();
            filas[2]=linea.getProd().getDescri();
            filas[3]=linea.getProd().getPrecio();
            filas[4]=linea.getCantidad();
            filas[5]=linea.getImpor();
            lis.add(filas);
        }
        return lis;
    }
    
    public double getSub(){
        return Venta.getsubtotal();
    }
    
    public double getdes(){
        return Venta.getdes();
    }
    
    public double gettotal(){
        return Venta.getTotal();
    }
}
