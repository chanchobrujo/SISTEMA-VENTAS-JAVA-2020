package SERVICIOS;

import DAO.*;
import LOGICA.*;

public class SerCategoriaIMP implements SerCategoria{
    private DaoCategoria Daocat=new DaoCategoriaIMP();

    @Override
    public Categoria buscarCategoria(String cod) {
        return Daocat.buscar(cod);
    }

    @Override
    public String grabarCategoria(String cat, String es) {
        Categoria obj = new Categoria(cat, es);
        return Daocat.grabar(obj);
    }

    @Override
    public String actualizarCategoria(String cod, String cat, String es) {
        Categoria obj = new Categoria(cat, es);
        obj.setId(cod);
        return Daocat.actualizar(obj);
    }
    
}
