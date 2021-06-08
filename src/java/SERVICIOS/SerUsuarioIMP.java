package SERVICIOS;

import LOGICA.*;
import DAO.*;
import java.util.List;
import GESTOR.*;

public class SerUsuarioIMP implements SerUsuario{
    private DaoUsuario DaoUsuario;
    private DaoRol DaoRol;
    
    public SerUsuarioIMP() {
        DaoUsuario=new DaoUsuarioIMP(); 
        DaoRol=new DaoRolIMP(); 
    }
    
    @Override
    public Usuarios buscarUsuario(String cod) {
        return DaoUsuario.buscar(cod);
    }

    @Override
    public String grabarUsuario(String dni, String numero, String correo, String usuario, String idrol, String estado) {
        if (DaoUsuario.buscarPorCorreo(correo)==null) {
            Usuarios Usuario = new Usuarios(dni, numero, correo, usuario, DaoRol.buscar(idrol), estado);
            return DaoUsuario.grabar(Usuario);
        }else return "Este correo ya está registrado con una cuenta.";
    }

    @Override
    public String grabarCliente(String nombre, String apellido, String numero, String correo, String usuario, String foto, String estado) {        
        if (DaoUsuario.buscarPorCorreo(correo)==null) {
            Usuarios cliente = new Usuarios(nombre, apellido, numero, correo, usuario, DaoRol.buscar("DCS") ,foto, estado);
            return DaoUsuario.grabar(cliente);
        }else return "Este correo ya está registrado con una cuenta.";
    }

    @Override
    public String actualizarUsuarioDatosPersonales(String id, String numero, String correo,String foto, String contra) {
        Usuarios Usuario = new Usuarios();
        Usuario.setId(id);
        Usuario.setNumero(numero);
        Usuario.setCorreo(correo);
        Usuario.setFoto(foto);
        Usuario.setContra(contra);
        return DaoUsuario.actualizarDatosPersonales(Usuario);
    }

    @Override
    public Usuarios validarempleado(String usuario, String contrasena) {
        List lista = DaoUsuario.listarActivos();
        if (lista!=null) {
            for (int i = 0; i < lista.size(); i++) {
                Usuarios Usuarios = (Usuarios) lista.get(i);
                if (Usuarios.getUsuario().equals(usuario) && Usuarios.getContra().equals(Encriptar.enSHA1(contrasena)) ) {
                    return Usuarios;
                }
            }
        }
        return null;
    }

    @Override
    public String actualizarUsuarioDatosEmpresariales(String id, String idrol, String estado) {
        Usuarios Usuario = new Usuarios();
        Usuario.setId(id);
        Usuario.setRol(DaoRol.buscar(idrol));
        Usuario.setEstado(estado);
        return DaoUsuario.actualizarDatosEmpresariales(Usuario);
    }

    @Override
    public Usuarios buscarUsuarioPorcorreo(String correo) {
        return DaoUsuario.buscarPorCorreo(correo);
    }

    @Override
    public String recuperarContraseña(String correo) {
        Usuarios Usuario=DaoUsuario.buscarPorCorreo(correo);
        if (Usuario!=null) {
            Usuarios Usuario2 = new Usuarios(Usuario.getId(), Usuario.getUsuario(), Usuario.getCorreo(), Usuario.getNumero());
            Usuario2.setFoto(Usuario.getFoto());
            DaoUsuario.actualizarDatosPersonales(Usuario2);
        }
        return null;
    }

    @Override
    public String actualizarUsuarioFoto(String id, String foto) {
        Usuarios Usuario=DaoUsuario.buscar(id);
        Usuario.setFoto(foto);
        if (Usuario!=null) {
            DaoUsuario.actualizarFoto(Usuario);
        }
        return null;
    }
}
