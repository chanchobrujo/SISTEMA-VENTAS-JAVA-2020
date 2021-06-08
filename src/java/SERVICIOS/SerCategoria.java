/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVICIOS;

import LOGICA.*;
/**
 *
 * @author USUARIO
 */
public interface SerCategoria {
    public Categoria buscarCategoria(String cod);
    public String grabarCategoria(String cat,String es);
    public String actualizarCategoria(String cod, String cat,String es);
}
