/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROL;

import LOGICA.Usuarios;
import SERVICIOS.*;
import MODELOS.*;
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
@WebServlet(name = "ControlUsuarios", urlPatterns = {"/ControlUsuarios"})
public class ControlUsuarios extends HttpServlet {
    private SerUsuario SerUsuario;
    private ModeloEmpleado ModeloEmpleado;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ac = request.getParameter("acc");
        if (ac.equals("Registrar")) {
            try {
                String dni = request.getParameter("dni");
                int cantidad = dni.length();
                String Nombres = request.getParameter("Nombres");
                String Apellidos = request.getParameter("Apellidos");
                String correo = request.getParameter("correo");
                String numero = request.getParameter("numero");
                String Usuario = request.getParameter("Usuario");
                String rol = request.getParameter("rol");
                String est = request.getParameter("Estado");
                String estado="";
                if (est.equals("Activo")) estado= "0";
                if (est.equals("Inactivo")) estado= "1";
                if (cantidad==8) { 
                    if (!(Apellidos.equals("null") || Nombres.equals("null"))) {
                        SerUsuario = new SerUsuarioIMP();
                        SerUsuario.grabarUsuario(dni, numero, correo, Usuario, rol, estado);
                        ModeloEmpleado.setDni("");
                        ModeloEmpleado.setNom("");
                        ModeloEmpleado.setAp("");
                    }
                }
            } catch (Exception e) {
                
            }
        }
        if (ac.equals("darDeAlta")) {
            try {
                String id = request.getParameter("codd");
                SerUsuario = new SerUsuarioIMP();
                SerUsuario.actualizarUsuarioDatosEmpresariales(id, SerUsuario.buscarUsuario(id).getRol().getId(), "0");
            } catch (Exception e) {
                
            }
        }
        if (ac.equals("darDeBaja")) {
            try {
                String id = request.getParameter("codd");
                SerUsuario = new SerUsuarioIMP();
                SerUsuario.actualizarUsuarioDatosEmpresariales(id, SerUsuario.buscarUsuario(id).getRol().getId(), "1");
            } catch (Exception e) {
                
            }
        }
        if (ac.equals("Actualizar")) {
            try {
                String id = request.getParameter("id");
                String rol = request.getParameter("rol");
                String est = request.getParameter("Estado");
                String estado="";
                if (est.equals("Activo")) estado= "0";
                if (est.equals("Inactivo")) estado= "1";
                SerUsuario = new SerUsuarioIMP();
                SerUsuario.actualizarUsuarioDatosEmpresariales(id, rol, estado);
                ModeloEmpleado.setDni("");
                ModeloEmpleado.setNom("");
                ModeloEmpleado.setAp("");
            } catch (Exception e) {
            }
        }
        if (ac.equals("Actualizarfoto")) {
            try {
                SerUsuario = new SerUsuarioIMP();
                String id = request.getParameter("id"); 
                String base64Usuario = request.getParameter("base64Usuario"); 
                if (!(base64Usuario==null)) SerUsuario.actualizarUsuarioFoto(id, base64Usuario);
            } catch (Exception e) {
            }
        }
        if (ac.equals("Verificar")) {
            try {
                String dni = request.getParameter("dni");
                int cantidad = dni.length();
                if (cantidad==8) {
                    Usuarios Usuarios = new Usuarios(dni);
                    ModeloEmpleado = new ModeloEmpleado();
                    ModeloEmpleado.setDni(Usuarios.getDni());
                    ModeloEmpleado.setNom(Usuarios.getNombres());
                    ModeloEmpleado.setAp(Usuarios.getApellidos());
                }else{
                    ModeloEmpleado = new ModeloEmpleado();
                    ModeloEmpleado.setDni("");
                    ModeloEmpleado.setNom("");
                    ModeloEmpleado.setAp("");
                }
                request.getSession().setAttribute("SesVerificar", ModeloEmpleado);
            } catch (Exception e) {
                
            }
        }
        response.sendRedirect("_MenuAdministrador.jsp");
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
