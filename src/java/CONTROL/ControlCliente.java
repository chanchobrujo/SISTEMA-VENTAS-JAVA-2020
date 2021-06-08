/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROL;


import LOGICA.Clientes;
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
@WebServlet(name = "ControlCliente", urlPatterns = {"/ControlCliente"})
public class ControlCliente extends HttpServlet {
    private SerCliente serclie;
    private ModeloCliente ModeloCliente;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ac = request.getParameter("acc");
        if (ac.equals("buscar")) {
            try {
                serclie = new SerClienteIMP();
                ModeloCliente = new ModeloCliente();
                request.getSession().setAttribute("sescli", ModeloCliente);
                String dni = request.getParameter("dni");
                int cont = 0;
                for (int i = 0; i < dni.length(); i++) {
                    if(!Character.isDigit(dni.charAt(i))){
                        cont++;
                    }else{
                        
                    }
                }
                if (cont==0) {
                    if (serclie.buscarClientes(dni)!=null) {
                        ModeloCliente.setDni(serclie.buscarClientes(dni).getDni());
                        ModeloCliente.setNombre(serclie.buscarClientes(dni).getNombres());
                        ModeloCliente.setApellido(serclie.buscarClientes(dni).getApellido());
                    }
                }
            } catch (Exception e) {}
        }
        response.sendRedirect("_MenuEmpVenta.jsp");
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
