/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROL;

import SERVICIOS.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author USUARIO
 */
@WebServlet(name = "ControlProducto", urlPatterns = {"/ControlProducto"})
public class ControlProducto extends HttpServlet {
    private SerProducto serC;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ac = request.getParameter("acc");
        if (ac.equals("Registrar")) {
            try {
                serC = new SerProductoIMP();
                String Nombre = request.getParameter("Nombre");
                String des = request.getParameter("des");
                double precio = Double.parseDouble(request.getParameter("precio"));
                String Categoria = request.getParameter("Categoria");
                int Stock = Integer.parseInt(request.getParameter("Stock"));
                String est = request.getParameter("Estado");
                String estado="";
                if (est.equals("Activo")) estado= "0";
                if (est.equals("Inactivo")) estado= "1";
                String bse64 = request.getParameter("base64Producto");
                serC.grabarProductos(Nombre, des, precio, Categoria, Stock,bse64, estado);
            }catch (Exception e) {
            }
        }
        if (ac.equals("Actualizar")) {
            try {
                serC = new SerProductoIMP();
                String ID = request.getParameter("ID");
                String Nombre = request.getParameter("Nombre");
                String des = request.getParameter("des");
                double precio = Double.parseDouble(request.getParameter("precio"));
                String Categoria = request.getParameter("Categoria");
                int Stock = Integer.parseInt(request.getParameter("Stock"));
                String est = request.getParameter("Estado");
                String estado="";
                if (est.equals("Activo")) estado= "0";
                if (est.equals("Inactivo")) estado= "1";
                String bse64 = request.getParameter("base64Producto");
                if (bse64.equals("")) serC.actualizarProductos(ID,Nombre, des, precio, Categoria, Stock,serC.buscarProductos(ID).getFoto(), estado);
                if (!(bse64.equals(""))) serC.actualizarProductos(ID,Nombre, des, precio, Categoria, Stock,bse64, estado);
                
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
