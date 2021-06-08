package org.apache.jsp.WEB_002dINF;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import LOGICA.*;
import DAO.*;
import MODELOS.*;
import SERVICIOS.*;

public final class _005fMenuPrincipal_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css\" integrity=\"sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2\" crossorigin=\"anonymous\"/>\n");
      out.write("        <script type=\"text/javascript\" src=\"https://code.jquery.com/jquery-1.12.4.min.js\"></script>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
 DaoCategoria DaoCategoria = new DaoCategoriaIMP(); 
      out.write("\n");
      out.write("        ");
 SerProducto SerProducto = new SerProductoIMP(); 
      out.write("\n");
      out.write("        ");
 List Listacategoria = DaoCategoria.listar2(); 
      out.write("\n");
      out.write("        ");
 List Listaproducto = SerProducto.listarProductos(); 
      out.write("\n");
      out.write("        <nav class=\"navbar navbar-expand-lg navbar-light bg-primary\">\n");
      out.write("            <a class=\"navbar-brand\" href=\"#\" ><h1>Menú</h1></a>\n");
      out.write("            <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n");
      out.write("                <span class=\"navbar-toggler-icon\"></span>\n");
      out.write("            </button>\n");
      out.write("            <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\n");
      out.write("                <ul class=\"navbar-nav mr-auto\">\n");
      out.write("                    <div class=\"dropdown\">\n");
      out.write("                        \n");
      out.write("                        <button style=\"border: none;\" class=\"btn\" type=\"button\" id=\"dropdownMenuButton\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\n");
      out.write("                            <h3>XFUR</h3>\n");
      out.write("                        </button>\n");
      out.write("                        <div class=\"dropdown-menu\" > \n");
      out.write("                            <a class=\"dropdown-item\" href=\"\">\n");
      out.write("                                XFUR \n");
      out.write("                            </a>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </ul>\n");
      out.write("                <div class=\"dropdown\">\n");
      out.write("                    <button type=\"button\" class=\"login btn btn-light\"data-toggle=\"modal\" data-target=\"#ModalLogin\">\n");
      out.write("                        <h4>Iniciar sesion</h4>\n");
      out.write("                    </button>\n");
      out.write("                    <button type=\"button\" class=\"login btn btn-primary\"data-toggle=\"modal\" data-target=\"#Registrarse\">\n");
      out.write("                        <h4>Registrarse!</h4>\n");
      out.write("                    </button>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </nav>\n");
      out.write("        <div style=\"height: 550px; width: 100%;overflow: auto;\">\n");
      out.write("            <div style=\"margin: 65px;\">\n");
      out.write("                    ");
 for (int i = 0; i < Listacategoria.size(); i++) { 
      out.write("\n");
      out.write("                        ");
 Categoria categoria = (Categoria)Listacategoria.get(i); 
      out.write("\n");
      out.write("                        <div class=\"card border-primary mb-3\" style=\"padding: 10px;\">\n");
      out.write("                            <h1 class=\"display-5\">");
      out.print( categoria.getCategoria() );
      out.write("<span class=\"badge badge-light\">");
      out.print( SerProducto.cantidadProductos(categoria.getId()) );
      out.write("</span></h1>\n");
      out.write("                            <div class=\"card-body\">\n");
      out.write("                                <ul class=\"list-group list-group-horizontal-sm\" style=\"overflow: scroll;\">\n");
      out.write("                                    ");
 for (int j = 1; j < Listaproducto.size(); j++) { 
      out.write(" \n");
      out.write("                                        ");
 Object[] productos = (Object[]) Listaproducto.get(j); 
      out.write("\n");
      out.write("                                            ");
 if(productos[4].equals(categoria.getId())){ 
      out.write("\n");
      out.write("                                                <li class=\"list-group-item\">\n");
      out.write("                                                    <div class=\"card\" >  \n");
      out.write("                                                        <div class=\"card-body\">\n");
      out.write("                                                            <table>\n");
      out.write("                                                                <tr>\n");
      out.write("                                                                    <td>\n");
      out.write("                                                                        <center>\n");
      out.write("                                                                            <image src='");
      out.print( productos[6] );
      out.write("' height='250' width='250'>\n");
      out.write("                                                                        </center>\n");
      out.write("                                                                    </td>\n");
      out.write("                                                                </tr>\n");
      out.write("                                                                <tr>\n");
      out.write("                                                                    <td><h5 class=\"card-title\">");
      out.print( productos[1] );
      out.write("</h5></td>\n");
      out.write("                                                                </tr>\n");
      out.write("                                                                <tr>\n");
      out.write("                                                                    <td><h6 class=\"card-subtitle mb-2 text-mutedbtn-block\">");
      out.print( productos[2] );
      out.write("</h6></td>\n");
      out.write("                                                                </tr>\n");
      out.write("                                                                <tr>\n");
      out.write("                                                                    <td><h6 class=\"card-subtitle mb-2 text-muted\">");
      out.print( productos[3]+" Soles." );
      out.write("</h6></td>\n");
      out.write("                                                                </tr>\n");
      out.write("                                                                <tr>\n");
      out.write("                                                                    <td colspan=\"2\">\n");
      out.write("                                                                        <button type=\"button\" class=\"login btn btn-danger\" data-toggle=\"modal\" data-target=\"#ModalLogin\">\n");
      out.write("                                                                            Agregar\n");
      out.write("                                                                        </button>\n");
      out.write("                                                                    </td>\n");
      out.write("                                                                </tr>\n");
      out.write("                                                            </table>\n");
      out.write("                                                        </div>\n");
      out.write("                                                    </div>\n");
      out.write("                                                </li>\n");
      out.write("                                            ");
}
      out.write("\n");
      out.write("                                    ");
 } 
      out.write("\n");
      out.write("                                </ul>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                     ");
 } 
      out.write("\n");
      out.write("                </div>\n");
      out.write("        </div> \n");
      out.write("        \n");
      out.write("        <!--Mpdales-->   \n");
      out.write("            <div class=\"modal fade\" id=\"ModalLogin\" tabindex=\"-1\" aria-labelledby=\"ModalLogin\" aria-hidden=\"true\" >\n");
      out.write("                <div class=\"modal-dialog\">\n");
      out.write("                    <div class=\"modal-content\">\n");
      out.write("                        <div class=\"modal-header\">\n");
      out.write("                            <h3 class=\"modal-title\">Inicio de sesión</h3>\n");
      out.write("                            <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\n");
      out.write("                                <span aria-hidden=\"true\">&times;</span>\n");
      out.write("                            </button>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"modal-body\">\n");
      out.write("                            <form action=\"_ControlLogin\" method=\"post\">\n");
      out.write("                                <div class=\"form-group\">\n");
      out.write("                                    <h4>Usuario</h4><input type=\"text\" name=\"Usuario\" class=\"form-control\" required>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"form-group\">\n");
      out.write("                                    <h4>Contraseña</h4><input type=\"password\" name=\"Contrasena\" class=\"form-control\" autocomplete=\"off\" required>\n");
      out.write("                                </div>\n");
      out.write("                                <button type=\"submit\" class=\"btn btn-block btn-primary\" name=\"acc\" value=\"Ingresar\" class=\"btn\">\n");
      out.write("                                    Ingresar\n");
      out.write("                                </button>\n");
      out.write("                            </form> \n");
      out.write("                        </div>           \n");
      out.write("                        <div class=\"modal-footer\">\n");
      out.write("                            <p>\n");
      out.write("                                <button class=\"btn\" type=\"button\" data-toggle=\"collapse\" data-target=\"#collapseExample\" aria-expanded=\"false\" aria-controls=\"collapseExample\">\n");
      out.write("                                    ¿Olvidó su usuario o contraseña?\n");
      out.write("                                </button>\n");
      out.write("                            </p>\n");
      out.write("                            <div class=\"collapse\" id=\"collapseExample\">\n");
      out.write("                                <div class=\"card card-body\">\n");
      out.write("                                    <form action=\"_ControlLogin\" method=\"post\">\n");
      out.write("                                        <div class=\"alert alert-light\" role=\"alert\">\n");
      out.write("                                            Recuerde que debe colocar el correo electrónico con el que se registró, donde se le enviará su contraseña.  \n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"form-group col-md-12\">\n");
      out.write("                                            <input type=\"email\" class=\"form-control\" name=\"correo\" placeholder=\"email@gmail.com\" required>\n");
      out.write("                                        </div>\n");
      out.write("                                        <button class=\"btn btn-danger btn-block\" name=\"acc\" value=\"Recuperar contrasena\" type=\"submit\" data-toggle=\"collapse\" data-target=\"#collapseExample\" aria-expanded=\"false\" aria-controls=\"collapseExample\">\n");
      out.write("                                            Restablecer contraseña\n");
      out.write("                                        </button>\n");
      out.write("                                    </form>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            \n");
      out.write("            <div class=\"modal fade\" id=\"Registrarse\" tabindex=\"-1\" aria-labelledby=\"ModalLogin\" aria-hidden=\"true\" >\n");
      out.write("                <div class=\"modal-dialog\">\n");
      out.write("                    <div class=\"modal-content\">\n");
      out.write("                        <div class=\"modal-body\">\n");
      out.write("                            <form action=\"_ControlLogin\" method=\"post\">\n");
      out.write("                                <div class=\"form-row\">\n");
      out.write("                                    <div class=\"form-group col-md-6\">\n");
      out.write("                                        <input type=\"text\" class=\"form-control\" name=\"Nombre\" placeholder=\"Nombre\" required>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"form-group col-md-6\">\n");
      out.write("                                        <input type=\"text\" class=\"form-control\" name=\"Apellido\" placeholder=\"Apellido\" required>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"form-row\">\n");
      out.write("                                    <div class=\"form-group col-md-12\">\n");
      out.write("                                        <input type=\"text\" class=\"form-control\" minlength=\"7\" maxlength=\"15\" name=\"Usuario\" id=\"Usuario\" placeholder=\"Usuario\" required>\n");
      out.write("                                        <div class=\"alert\" role=\"alert\">\n");
      out.write("                                            Su nombre de usuario debe tener entre 7 y 15 caracteres.\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"form-row\">\n");
      out.write("                                    <div class=\"form-group col-md-12\">\n");
      out.write("                                        <input type=\"text\" class=\"form-control\" minlength=\"13\" maxlength=\"13\"  name=\"numero\" placeholder=\"+51 9xxyyyzzz\" required>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"form-row\">\n");
      out.write("                                    <div class=\"form-group col-md-12\">\n");
      out.write("                                        <input type=\"email\" class=\"form-control\" name=\"correo\" placeholder=\"email@gmail.com\" required>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"form-row\">\n");
      out.write("                                    <div class=\"form-group col-md-6\">\n");
      out.write("                                        <button type=\"button\" class=\"btn btn-secondary\" data-dismiss=\"modal\">Close</button>\n");
      out.write("                                        <button type=\"submit\" name=\"acc\" id=\"Crearcliente\" value=\"Crear cliente\" class=\"btn btn-primary\">Registrarse</button>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"form-row\">\n");
      out.write("                                    <div class=\"form-group col-md-12\">\n");
      out.write("                                        <div class=\"alert alert-danger\" role=\"alert\">\n");
      out.write("                                            Se le enviará una contraseña a su correo.\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </form>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        <!--Mpdales-->\n");
      out.write("        <script>\n");
      out.write("            \n");
      out.write("        </script>\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.5.1.slim.min.js\" integrity=\"sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js\" integrity=\"sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js\" integrity=\"sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s\" crossorigin=\"anonymous\"></script> \n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
