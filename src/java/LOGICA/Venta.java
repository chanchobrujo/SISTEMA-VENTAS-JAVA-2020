/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LOGICA;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author USUARIO
 */
public class Venta {
    private String num;
    private Clientes cliente;
    private Usuarios usuario;
    private double pordes;
    private String fecha;
    private String hora;
    private double total;
    private String la;
    private String lo;
    private String estado;
    private List cesta; 
    
    public Venta() {
        this.num = "NUM"+UUID.randomUUID().toString().toUpperCase().subSequence(0, 12);
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd"); 
        String fechaComoCadena = formato.format(new Date());

        Calendar   calendario = Calendar.getInstance();

        this.hora =calendario.get(Calendar.HOUR_OF_DAY)+":"+calendario.get(Calendar.MINUTE)+":"+calendario.get(Calendar.SECOND);
        this.fecha = fechaComoCadena;
        
        cesta = new ArrayList();
    }

    public String getLa() {
        return la;
    }

    public void setLa(String la) {
        this.la = la;
    }

    public String getLo() {
        return lo;
    }

    public void setLo(String lo) {
        this.lo = lo;
    }
    
    public void agregar(Productos prod,int cant){
        if (cant>0) {
            int index = -1;
            for (int i = 0; i < cesta.size(); i++) {
                Detalle lin = (Detalle) cesta.get(i);
                if (lin.getProd().getId().equals(prod.getId())) {
                    lin.setCantidad(cant+lin.getCantidad());
                    index=0;
                }
            }
            if(index==-1){
                Detalle lin = new Detalle(this.num,prod, cant);
                cesta.add(lin);
            }
            
        }
    }
    
    public void vaciarCarrito(){
        cesta.clear();
    }
    
    public void quitar(String cod){
        for (int i = 0; i < cesta.size(); i++) {
            Detalle lin = (Detalle) cesta.get(i);
            if (lin.getProd().getId().equals(cod)) {
                cesta.remove(i);
            }
        }
    }  
    
    public double getsubtotal(){
        double total=0;
        for (int i = 0; i < cesta.size(); i++) {
            Detalle lin = (Detalle) cesta.get(i);
            total=total+lin.getImpor();
        }
        return total;
    }
    
    public double getdes(){
        return this.getsubtotal()*this.getpordes();
    }
    
    public List getCesta() {
        return cesta;
    } 

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public double getpordes() {
        return pordes;
    }

    public void setpordes(double pordes) {
        this.pordes =  pordes/100;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public double getTotal() {
        return this.getsubtotal()-this.getdes();
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }
    
}
