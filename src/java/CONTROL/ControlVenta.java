/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROL;

import SERVICIOS.*;
import MODELOS.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author USUARIO
 */
@WebServlet(name = "ControlVenta", urlPatterns = {"/ControlVenta"})
public class ControlVenta extends HttpServlet {
    private ModeloCliente ModeloCliente;
    private ModeloVenta ModeloVenta;
    private SerVenta SerVenta;
    private SerUsuario SerUsuario;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ac = request.getParameter("acc"); 
        if (ac.equals("Nueva venta")) { 
            try {
                String idUsuario = request.getParameter("id");
                SerUsuario = new SerUsuarioIMP();
                SerVenta = new SerVentaIMP();
                if (SerUsuario.buscarUsuario(idUsuario).getRol().getId().equals("DCS")) {
                    ModeloVenta = new ModeloVenta(SerVenta.nuevaVenta(SerUsuario.buscarUsuario(idUsuario).getId(), 2));
                    response.sendRedirect("_MenuCliente.jsp");
                }
                if (SerUsuario.buscarUsuario(idUsuario).getRol().getId().equals("FGV")) {
                    ModeloVenta = new ModeloVenta(SerVenta.nuevaVenta(SerUsuario.buscarUsuario(idUsuario).getId(), 0));
                    response.sendRedirect("_MenuEmpVenta.jsp");
                }
                
                request.getSession().setAttribute("SesVenta", ModeloVenta);
                ModeloVenta.setProductos(SerVenta.ListarProductos());
                
            } catch (Exception e) {
            }
        }
        if (ac.equals("Confirmar compra")) { 
            try {
                String idUsuario = request.getParameter("id");
                
                SerUsuario = new SerUsuarioIMP();
                if (SerUsuario.buscarUsuario(idUsuario).getRol().getId().equals("DCS")) {
                    String la = request.getParameter("la");
                    String lo = request.getParameter("lo");
                    SerVenta.grabarVentasParaUsuarioCliente(idUsuario, la, lo,ModeloVenta.getCes());
                    SerVenta.vaciarCarrito();
                    response.sendRedirect("_MenuCliente.jsp");
                }
                if (SerUsuario.buscarUsuario(idUsuario).getRol().getId().equals("FGV")) {
                    String dni = request.getParameter("dni");
                    if (dni.equals("")) {
                        SerVenta.grabarVentasParaUsuarioEmpl(idUsuario, "-", ModeloVenta.getCes());
                    }else{
                        SerVenta.grabarVentasParaUsuarioEmpl(idUsuario,dni, ModeloVenta.getCes());
                    }
                    SerVenta.vaciarCarrito();
                    ModeloCliente = new ModeloCliente();
                    request.getSession().setAttribute("sescli", ModeloCliente);
                    response.sendRedirect("_MenuEmpVenta.jsp");
                }
                
            } catch (Exception e) {
                
            }
        }
        if (ac.equals("Agregar")) {
            try{
                String idusu = request.getParameter("idusu");
                SerUsuario = new SerUsuarioIMP();
                
                String cod = request.getParameter("id");
                int cantidad = Integer.parseInt(request.getParameter("cantidad"));
                SerVenta.agregarLinea(cod, cantidad);
                if (SerUsuario.buscarUsuario(idusu).getRol().getId().equals("DCS")) response.sendRedirect("_MenuCliente.jsp");
                if (SerUsuario.buscarUsuario(idusu).getRol().getId().equals("FGV")) response.sendRedirect("_MenuEmpVenta.jsp");
            }catch(Exception e){
            }
        }
        if (ac.equals("Quitar")) {
            try{
                String idusu = request.getParameter("idusu");
                SerUsuario = new SerUsuarioIMP();
                
                String cod = request.getParameter("id");
                SerVenta.quitarLinea(cod);
                if (SerUsuario.buscarUsuario(idusu).getRol().getId().equals("DCS")) response.sendRedirect("_MenuCliente.jsp");
                if (SerUsuario.buscarUsuario(idusu).getRol().getId().equals("FGV")) response.sendRedirect("_MenuEmpVenta.jsp");
            }catch(Exception e){
            }
        }
        if (ac.equals("entregar")) {
            String idntv = request.getParameter("idntv");
            SerVenta = new SerVentaIMP();
            SerVenta.entregar(idntv);
            response.sendRedirect("_MenuEmpRepartidor.jsp");
        }
        if (ac.equals("vervnt")) {
            String idvn = request.getParameter("idvn");
            String la = request.getParameter("la");
            String lo = request.getParameter("lo");
            SerVenta = new SerVentaIMP();
            String nme  = request.getParameter("nme");
            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("   <link rel=\"stylesheet\" href=\"https://bootswatch.com/4/lux/bootstrap.min.css\" />");   
                out.println("   <script type=\"text/javascript\" src=\"https://code.jquery.com/jquery-1.12.4.min.js\"></script>");   
                out.println("   <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">");   
                out.println("   <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">"); 
                out.println("<title>Servlet NewServlet</title>");            
                out.println("</head>");
                out.println("   <body>");
                out.println("       <nav class=\"navbar navbar-danger bg-danger\">");
                out.println("           <a class=\"navbar-brand\" >");
                out.println("               <h2 style=\"color: white;\" class=\"display-5\">Productos a entregar.</h2>");
                out.println("           </a>");
                out.println("       </nav>"); //
                out.println("       <div class='card border'>");
                out.println("           <div class='card-header'>");
                out.println("               CLIENTE: "+nme);
                out.println("               <input type = 'hidden' id='la' value='"+la+"'/>");
                out.println("               <input type = 'hidden' id='lo'  value='"+lo+"'/>");
                out.println("               <div id='mapa'></div>");
                
                out.println("           </div>");
                out.println("           <div class='card-body table-responsive-lg' style=\"max-height: 250px; overflow-y: auto;overflow-x: auto;\">");
                out.println("               <table class='table'>");
                out.println("                   <thead class='thead-dark'>");
                out.println("                       <tr>");
                out.println("                           <th >");
                out.println("                               #");
                out.println("                           </th >");
                out.println("                           <th >");
                out.println("                               PRODUCTO");
                out.println("                           </th >");
                out.println("                           <th >");
                out.println("                               CANTIDAD");
                out.println("                           </th >");
                out.println("                       </tr>");
                out.println("                   </thead>");
                for (int i = 0; i < SerVenta.listarDetEmpRep(idvn).size(); i++) {
                    Object[] filas = (Object[])SerVenta.listarDetEmpRep(idvn).get(i);
                    out.println("                   <tr>");
                    out.println("                       <td>");
                    out.println(i);
                    out.println("                       </td>");
                    out.println("                       <td>");
                    out.println(filas[0].toString()+" "+filas[1].toString());
                    out.println("                       </td>");
                    out.println("                       <td>");
                    out.println(filas[2].toString());
                    out.println("                       </td>");
                    out.println("                   </tr>");
                }
                out.println("               </table>");
                out.println("           </div>");
                out.println("           <div class='card-footer '>");
                out.println("               <div class='m-3'>");
                out.println("                   <form method='post' action=''>");
                out.println("                       <input type='hidden' name='idntv' value='"+idvn+"' />");
                out.println("                       <table>");
                out.println("                           <tr>");
                out.println("                               <td>");
                out.println("                                   <button type='submit' class='btn btn-danger' name='acc' value='entregar'>entregar</button>");
                out.println("                               </td>");
                out.println("                               <td>");
                out.println("                                   <a href='_MenuEmpRepartidor.jsp' class='btn btn-danger'>Regresar</a>");
                out.println("                               </td>");
                out.println("                           </tr>");
                out.println("                       </table>");
                out.println("                   </form>");
                out.println("               </div>");
                out.println("               <hr>");
                out.println("           </div>");
                out.println("       </div>");
                out.println("       <script src='assets/js/misFunciones.js' />");
                out.println("        <script src=\"https://code.jquery.com/jquery-3.5.1.slim.min.js\" integrity=\"sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj\" crossorigin=\"anonymous\"></script>");
                out.println("        <script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js\" integrity=\"sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN\" crossorigin=\"anonymous\"></script>");
                out.println("        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js\" integrity=\"sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s\" crossorigin=\"anonymous\"></script>");
                out.println("   </body>");
                out.println("</html>");
            }
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
