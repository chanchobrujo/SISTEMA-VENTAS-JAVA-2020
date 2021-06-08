/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROL;

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
@WebServlet(name = "ControlRol", urlPatterns = {"/ControlRol"})
public class ControlRol extends HttpServlet {
    private SerRol SerRol;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ac = request.getParameter("acc");
        if (ac.equals("Registrar")) {
            try {
                SerRol = new SerRolIMP();
                String Nombre = request.getParameter("Nombre");
                String est = request.getParameter("Estado");
                String estado="";
                if (est.equals("Activo")) estado= "0";
                if (est.equals("Inactivo")) estado= "1";
                SerRol.grabarRoles(Nombre, estado);
            }catch (Exception e) {
                
            }
        }
        if (ac.equals("Actualizar")) {
            try {
                SerRol = new SerRolIMP();
                String ID = request.getParameter("ID");
                String Nombre = request.getParameter("Nombre");
                String est = request.getParameter("Estado");
                String estado="";
                if (est.equals("Activo")) estado= "0";
                if (est.equals("Inactivo")) estado= "1";
                SerRol.actualizarRoles(ID,Nombre, estado);
                
            }catch (Exception e) {
                
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
