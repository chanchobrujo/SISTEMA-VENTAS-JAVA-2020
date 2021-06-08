/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import GESTOR.Operación;
import LOGICA.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public class DaoUsuarioIMP implements DaoUsuario{

    @Override
    public String grabar(Usuarios e) {
        return Operación.ejecutar("INSERT INTO usuario VALUES ('"+e.getId()+"','"+e.getDni()+"','"+e.getNombres()+"','"+e.getApellidos()+"','"+e.getNumero()+"','"+e.getCorreo()+"','"+e.getUsuario()+"',sha1('"+e.getContra()+"'),'"+e.getRol().getId()+"','"+e.getFoto()+"','"+e.getEstado()+"')");
    }

    @Override
    public String actualizarDatosPersonales(Usuarios e) {
        return Operación.ejecutar("UPDATE usuario SET FOTO='"+e.getFoto()+"',NUMERO='"+e.getNumero()+"',CORREO='"+e.getCorreo()+"',CONTRASENA=sha1('"+e.getContra()+"') WHERE usuario.ID='"+e.getId()+"'");
    }

    @Override
    public String actualizarDatosEmpresariales(Usuarios e) {
        return Operación.ejecutar("UPDATE usuario SET ROLID='"+e.getRol().getId()+"',ESTADO='"+e.getEstado()+"' WHERE USUARIO.ID='"+e.getId()+"'");
    }

    @Override
    public List listarTodos() {
        List lis = new ArrayList();
        List lista = Operación.listar("SELECT * FROM usuario");
        if(lista != null){
            for (int i = 1; i < lista.size(); i++) {
                Object[] fila = (Object[])lista.get(i);
                Usuarios obj = new Usuarios();
                DaoRol dao = new DaoRolIMP();
                obj.setId(fila[0].toString());
                obj.setDni(fila[1].toString());
                obj.setNombres(fila[2].toString());
                obj.setApellidos(fila[3].toString());
                obj.setNumero(fila[4].toString());
                obj.setCorreo(fila[5].toString());
                obj.setUsuario(fila[6].toString());
                obj.setContra(fila[7].toString());
                obj.setRol(dao.buscar(fila[8].toString()));
                obj.setFoto(fila[9].toString());
                obj.setEstado(fila[10].toString());
                lis.add(obj);
            }
            return lis; 
        }
        return null; 
    }

    @Override
    public List listarActivos() {
        List lis = new ArrayList();
        List lista = Operación.listar("SELECT * FROM usuario where usuario.estado='0'");
        if(lista != null){
            for (int i = 1; i < lista.size(); i++) {
                Object[] fila = (Object[])lista.get(i);
                Usuarios obj = new Usuarios();
                DaoRol dao = new DaoRolIMP();
                obj.setId(fila[0].toString());
                obj.setDni(fila[1].toString());
                obj.setNombres(fila[2].toString());
                obj.setApellidos(fila[3].toString());
                obj.setNumero(fila[4].toString());
                obj.setCorreo(fila[5].toString());
                obj.setUsuario(fila[6].toString());
                obj.setContra(fila[7].toString());
                obj.setRol(dao.buscar(fila[8].toString()));
                obj.setFoto(fila[9].toString());
                obj.setEstado(fila[10].toString());
                lis.add(obj);
            }
            return lis; 
        }
        return null; 
    }

    @Override
    public Usuarios buscar(String cod) {
        Object[]fila = Operación.buscar("SELECT * FROM usuario WHERE usuario.ID='"+cod+"'");
        if (fila!=null) {
            Usuarios obj = new Usuarios();
            DaoRol dao = new DaoRolIMP();
            obj.setId(fila[0].toString());
            obj.setDni(fila[1].toString());
            obj.setNombres(fila[2].toString());
            obj.setApellidos(fila[3].toString());
            obj.setNumero(fila[4].toString());
            obj.setCorreo(fila[5].toString());
            obj.setUsuario(fila[6].toString());
            obj.setContra(fila[7].toString());
            obj.setRol(dao.buscar(fila[8].toString()));
            obj.setFoto(fila[9].toString());
            obj.setEstado(fila[10].toString());
            return obj;
        }
        return null; 
    }

    @Override
    public Usuarios buscarPorCorreo(String correo) {
        Object[]fila = Operación.buscar("SELECT * FROM usuario WHERE usuario.CORREO='"+correo+"'");
        if (fila!=null) {
            Usuarios obj = new Usuarios();
            DaoRol dao = new DaoRolIMP();
            obj.setId(fila[0].toString());
            obj.setDni(fila[1].toString());
            obj.setNombres(fila[2].toString());
            obj.setApellidos(fila[3].toString());
            obj.setNumero(fila[4].toString());
            obj.setCorreo(fila[5].toString());
            obj.setUsuario(fila[6].toString());
            obj.setContra(fila[7].toString());
            obj.setRol(dao.buscar(fila[8].toString()));
            obj.setFoto(fila[9].toString());
            obj.setEstado(fila[10].toString());
            return obj;
        }
        return null; 
    }

    @Override
    public String actualizarFoto(Usuarios e) {
        return Operación.ejecutar("UPDATE usuario SET FOTO='"+e.getFoto()+"' WHERE usuario.ID='"+e.getId()+"'");
    }
}
