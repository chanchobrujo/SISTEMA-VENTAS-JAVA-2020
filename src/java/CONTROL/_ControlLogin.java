/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROL;

import GESTOR.Encriptar;
import MODELOS.*; //MODELOS
import SERVICIOS.*;
import LOGICA.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author USUARIO
 */
@WebServlet(name = "_ControlLogin", urlPatterns = {"/_ControlLogin"})
public class _ControlLogin extends HttpServlet {
    private ModeloEmpleado modEmp;
    private SerUsuario SerUsuario;
    private ModeloVenta ModeloVenta;
    private ModeloCliente ModeloCliente;
    private SerVenta SerVenta;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ac = request.getParameter("acc");
        if (ac.equals("Ingresar")) {
            modEmp = new ModeloEmpleado();
            SerUsuario = new SerUsuarioIMP();
            request.getSession().setAttribute("sesEmp", modEmp);
            String Usuario = request.getParameter("Usuario"); 
            String Contrasena = request.getParameter("Contrasena");
            if (SerUsuario.validarempleado(Usuario, Contrasena)!=null) {
                Usuarios obj = SerUsuario.validarempleado(Usuario, Contrasena);
                modEmp.setId(obj.getId());
                modEmp.setNom(obj.getNombres());
                modEmp.setAp(obj.getApellidos());
                modEmp.setUs(obj.getUsuario());
                modEmp.setNumero(obj.getNumero());
                modEmp.setCorreo(obj.getCorreo());
                modEmp.setCont(obj.getContra());
                modEmp.setRol(obj.getRol().getRol());
                modEmp.setFoto(obj.getFoto());
                modEmp.setMsg("");
                
                if (obj.getRol().getId().equals("DCS")) {
                    SerVenta = new SerVentaIMP();
                    ModeloVenta = new ModeloVenta(SerVenta.nuevaVenta(modEmp.getId(), 5));
                    request.getSession().setAttribute("SesVenta", ModeloVenta);
                    ModeloVenta.setProductos(SerVenta.ListarProductos());
                    response.sendRedirect("_MenuCliente.jsp");
                }
                if (obj.getRol().getId().equals("FGV")) {
                    SerVenta = new SerVentaIMP();
                    ModeloVenta = new ModeloVenta(SerVenta.nuevaVenta(modEmp.getId(), 5));
                    request.getSession().setAttribute("SesVenta", ModeloVenta);
                    ModeloCliente = new ModeloCliente();
                    request.getSession().setAttribute("sescli", ModeloCliente);
                    ModeloVenta.setProductos(SerVenta.ListarProductos());
                    response.sendRedirect("_MenuEmpVenta.jsp");
                }
                if (obj.getRol().getId().equals("XDF")) {
                    modEmp = new ModeloEmpleado();
                    request.getSession().setAttribute("Sescliente", ModeloCliente);
                    request.getSession().setAttribute("SesVerificar", modEmp);
                    response.sendRedirect("_MenuAdministrador.jsp");
                }
                if (obj.getRol().getId().equals("3B0")) {
                    
                    response.sendRedirect("_MenuEmpRepartidor.jsp");
                }
            }else{
                response.sendRedirect("_MenuPrincipal.jsp");
            }
        }
        if (ac.equals("Crear cliente")) {
            try {
                SerUsuario = new SerUsuarioIMP();
                String Nombre = request.getParameter("Nombre");
                String Apellido = request.getParameter("Apellido");
                String Usuario = request.getParameter("Usuario"); 
                String numero = request.getParameter("numero"); 
                String correo = request.getParameter("correo"); 
                
                SerUsuario.grabarCliente(Nombre, Apellido, numero, correo, Usuario,"Sin foto.", "0");
                response.sendRedirect("http://www.gmail.com/");
            } catch (Exception e) {
                
            }
        }
        if (ac.equals("Recuperar contrasena")) {
            SerUsuario = new SerUsuarioIMP();
            String correo = request.getParameter("correo"); 
            SerUsuario.recuperarContraseña(correo);
            response.sendRedirect("http://www.gmail.com/");
        }
        if (ac.equals("Cambiar contrasena")) {
            SerUsuario = new SerUsuarioIMP();
            String id = request.getParameter("id"); 
            String actualcontra = Encriptar.enSHA1(request.getParameter("actualcontra")); 
            String confcontra = request.getParameter("confcontra"); 
            if (actualcontra.equals(SerUsuario.buscarUsuario(id).getContra())) {
                SerUsuario.actualizarUsuarioDatosPersonales(id, SerUsuario.buscarUsuario(id).getNumero(), SerUsuario.buscarUsuario(id).getCorreo(), SerUsuario.buscarUsuario(id).getFoto(), confcontra);
            }
            if (SerUsuario.buscarUsuario(id).getRol().getId().equals("DCS")) response.sendRedirect("_MenuCliente.jsp");
            if (SerUsuario.buscarUsuario(id).getRol().getId().equals("XDF")) response.sendRedirect("_MenuAdministrador.jsp");
        }
        //
        if (ac.equals("Cerrar sesion")) {
            request.getSession().invalidate();
            response.sendRedirect("_MenuPrincipal.jsp");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
