/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GESTOR;

import java.sql.*;
import java.util.*;
/**
 *
 * @author USUARIO
 */
public class Operación {
    public static String ejecutar(String sql) {
        String m = "Ejecucion realizada correctamente.";
        try {
            Connection cn = new Conexion().getConexion();
            if (cn!=null) {
                Statement st = cn.createStatement();
                st.executeUpdate(sql);
                cn.close();
            }else{
                m = "No hay conexion.";
            }
        } catch (Exception e) {
            m=e.getMessage();
        }
        return m;
    }
    public static List listar(String sql){
        List lista = new ArrayList();
        try {
            Connection cn = new Conexion().getConexion();
            if (cn!=null) {
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                ResultSetMetaData rm = rs.getMetaData();
                int numCol = rm.getColumnCount();
                String[]titCol = new String[numCol];
                for (int i = 0; i < numCol; i++)titCol[i]=rm.getColumnName(i+1);
                lista.add(titCol);
                while (rs.next()) {                    
                    Object[] fila = new Object[numCol];
                    for (int i = 0; i < numCol; i++)fila[i] = rs.getObject(i+1);
                    lista.add(fila);
                }
                cn.close();
            }else{
                lista = null;
            }
        } catch (Exception e) {
            lista = null;
        }
        return lista;
        
    }
    public static Object[] buscar(String sql){
        Object[] fila = null;
        List lista= listar(sql);
        if(lista!=null){
            if(lista.size()>1){
                fila = (Object[])lista.get(1);
            }
        }
        return fila;
    }
}
