<%-- 
    Document   : Op_Ventas
    Created on : 05/11/2020, 12:23:58 PM
    Author     : USUARIO
--%>

<%@page import="java.util.List"%>
<%@page import="LOGICA.*" %>
<%@page import="DAO.*" %>
<%@page import="MODELOS.*" %>
<%@page import="SERVICIOS.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://bootswatch.com/4/united/bootstrap.min.css" />
        <script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <% DaoCategoria DaoCategoria = new DaoCategoriaIMP(); %>
        <% List Listacategoria = DaoCategoria.listar2(); %>
        <% ModeloEmpleado modEmp = (ModeloEmpleado)session.getAttribute("sesEmp"); %>
        <% ModeloVenta ModeloVenta = (ModeloVenta)session.getAttribute("SesVenta"); %>
        <% List Listaproducto = ModeloVenta.getProductos(); %>
        <% List listVentaPorusuario = ModeloVenta.getListVentaPorusuario(modEmp.getId()); %>
        <nav class="navbar navbar-expand-lg navbar-primary bg-primary">
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse " id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <a style="color: white; " ><div class="display-1">Mini Market "SR"</div></a>
                    
                </ul>
                <form action="ControlVenta" method="post">
                    <input type="hidden" name="id" value="<%= modEmp.getId() %>" />
                    <button type="button" class="btn navbar-brand" id="btnto1" style="color: white; ">
                        <svg width="4em" height="4em" viewBox="0 0 16 16" class="bi bi-cart4" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                            <path fill-rule="evenodd" d="M0 2.5A.5.5 0 0 1 .5 2H2a.5.5 0 0 1 .485.379L2.89 4H14.5a.5.5 0 0 1 .485.621l-1.5 6A.5.5 0 0 1 13 11H4a.5.5 0 0 1-.485-.379L1.61 3H.5a.5.5 0 0 1-.5-.5zM3.14 5l.5 2H5V5H3.14zM6 5v2h2V5H6zm3 0v2h2V5H9zm3 0v2h1.36l.5-2H12zm1.11 3H12v2h.61l.5-2zM11 8H9v2h2V8zM8 8H6v2h2V8zM5 8H3.89l.5 2H5V8zm0 5a1 1 0 1 0 0 2 1 1 0 0 0 0-2zm-2 1a2 2 0 1 1 4 0 2 2 0 0 1-4 0zm9-1a1 1 0 1 0 0 2 1 1 0 0 0 0-2zm-2 1a2 2 0 1 1 4 0 2 2 0 0 1-4 0z"/>
                        </svg>
                    </button>
                    <button type="submit" class="btn navbar-brand" id="btnNuevo"  name="acc" value="Nueva venta" style="color: white; ">
                        <svg width="4em" height="4em" viewBox="0 0 16 16" class="bi bi-plus-circle" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                            <path fill-rule="evenodd" d="M8 15A7 7 0 1 0 8 1a7 7 0 0 0 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/>
                            <path fill-rule="evenodd" d="M8 4a.5.5 0 0 1 .5.5v3h3a.5.5 0 0 1 0 1h-3v3a.5.5 0 0 1-1 0v-3h-3a.5.5 0 0 1 0-1h3v-3A.5.5 0 0 1 8 4z"/>
                        </svg>
                    </button>
                    <button type="button" class="btn navbar-brand" data-toggle="modal" data-target="#verMisCompras" style="color: white; ">
                        <svg width="4em" height="4em" viewBox="0 0 16 16" class="bi bi-bag-check" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                            <path fill-rule="evenodd" d="M8 1a2.5 2.5 0 0 0-2.5 2.5V4h5v-.5A2.5 2.5 0 0 0 8 1zm3.5 3v-.5a3.5 3.5 0 1 0-7 0V4H1v10a2 2 0 0 0 2 2h10a2 2 0 0 0 2-2V4h-3.5zM2 5v9a1 1 0 0 0 1 1h10a1 1 0 0 0 1-1V5H2z"/>
                            <path fill-rule="evenodd" d="M10.854 8.146a.5.5 0 0 1 0 .708l-3 3a.5.5 0 0 1-.708 0l-1.5-1.5a.5.5 0 0 1 .708-.708L7.5 10.793l2.646-2.647a.5.5 0 0 1 .708 0z"/>
                        </svg>
                    </button>
                </form>
                <form method="post" action="_ControlLogin" class="ml-5">
                    <button type="submit" class="btn navbar-brand" name="acc" value="Cerrar sesion" style="color: white; ">
                        <svg width="4em" height="4em" viewBox="0 0 16 16" class="bi bi-arrow-bar-left" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                            <path fill-rule="evenodd" d="M12.5 15a.5.5 0 0 1-.5-.5v-13a.5.5 0 0 1 1 0v13a.5.5 0 0 1-.5.5zM10 8a.5.5 0 0 1-.5.5H3.707l2.147 2.146a.5.5 0 0 1-.708.708l-3-3a.5.5 0 0 1 0-.708l3-3a.5.5 0 1 1 .708.708L3.707 7.5H9.5a.5.5 0 0 1 .5.5z"/>
                        </svg>
                    </button>
                </form>
             </div>                                                   
        </nav>
        <div class="m-5" style="position:absolute;">                    
            <% for (int i = 0; i < Listacategoria.size(); i++) {
                Categoria categoria = (Categoria)Listacategoria.get(i);
                out.println(""
                        + "<div class='card p-3 mb-3 ' >"
                            + "<h1 class='display-3 ' >"+categoria.getCategoria()+"</h1>"
                            + "<div class='card-body'  style='width: 1425px;'>"
                                + "<ul class='list-group list-group-horizontal-sm' style='overflow-x: auto;'>");
                                    for (int j = 1; j < Listaproducto.size(); j++) {
                                        Object[] productos = (Object[]) Listaproducto.get(j);
                                        if(productos[4].equals(categoria.getId())){
                                            out.println(""
                                                    + "<li class='list-group-item'>"
                                                        + "<div class='card'  style='width: 18rem;'>"
                                                        + "<image src='"+productos[6]+"' width='200' class='card-img-top'>"
                                                            + "<form action='ControlVenta' post='post'>"
                                                                + "<div class='card-body'>"
                                                                    + "<input type='hidden' name='idusu' value='"+modEmp.getId()+"' >" 
                                                                    + "<input type='hidden' name='id' value='"+productos[0]+"' >" 
                                                                    + "<h3 class='card-title'> "+productos[1]+" "+productos[2]+" </h3>" 
                                                                    + "<h4>Precio: "+productos[3]+" Soles."+"</h4>"     
                                                                    + "<input required type='number' name='cantidad' min='1' max='"+productos[5]+"' >" 
                                                                    + "<button type='submit' class='btn' name='acc' value='Agregar'>"
                                                                        + "<svg width='3em' height='3em' viewBox='0 0 16 16' class='bi bi-plus-circle' fill='currentColor' xmlns='http://www.w3.org/2000/svg'><path fill-rule='evenodd' d='M8 15A7 7 0 1 0 8 1a7 7 0 0 0 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z' /><path fill-rule='evenodd' d='M8 4a.5.5 0 0 1 .5.5v3h3a.5.5 0 0 1 0 1h-3v3a.5.5 0 0 1-1 0v-3h-3a.5.5 0 0 1 0-1h3v-3A.5.5 0 0 1 8 4z' /></svg>"
                                                                    + "</button>"
                                                                            
                                                                + "</div>"
                                                            + "</form>"
                                                        + "</div>"
                                                    + "</li>");
                                        }
                                    }
                out.println(""                
                                + "</ul>"
                            + "</div>"
                        + "</div>");
            } %> 
        </div>

        <!--Toats-->
            <div class="toast shadow-lg p-3 mb-5 bg-white rounded" style="position: relative;background: white;" id="toast1" role="alert" aria-live="assertive" aria-atomic="true" data-autohide="false">
                <div class="toast-header">
                    <h1>Mi carrito!!!</h1>
                    <button type="button" class="ml-2 mb-1 close" data-dismiss="toast" aria-label="Close">
                        <h1><span aria-hidden="true">&times;</span></h1>
                    </button>
                </div>
                <div class="toast-body">
                    <ul class="list-group list-group-horizontal">
                        <li class="list-group-item">
                            <h5>Sub total: <%= Float.parseFloat(ModeloVenta.getSub()+"") %></h5>
                        </li>
                        <li class="list-group-item">
                            <h5>Descuento: <%= Float.parseFloat(ModeloVenta.getdes()+"")%></h5> 
                        </li>
                    </ul>
                    <hr>
                    <div style="height: 275px;overflow: auto;">
                        <ul class='list-group '>
                        <% for (int i = 0; i < ModeloVenta.getCes().size(); i++) {
                            Object[]filas=(Object[])ModeloVenta.getCes().get(i);
                            out.println(
                                    ""
                                        + "<li class='list-group-item'>"
                                            + "<form action='ControlVenta' method='post'>");
                                out.println("<input type='hidden' name='idusu' value='"+modEmp.getId()+"' />");
                                out.println("<div class='card' ><input type='hidden' name='_id' value='"+filas[0]+"'>");
                                out.println("<center><h2 class='card-title'>"+filas[1]+" "+filas[2]+"</h2></center><hr>");
                                out.println("<div class='card-body'><table  Cellpadding ='8'>"
                                        + "<tr><td><h3>Precio:</h3></td><td><h3>"+filas[3] + "</h3></td></tr>"
                                        + "<tr><td><h3>Cantidad:</h3></td><td><h3>"+filas[4] + "</h3></td></tr>"
                                        + "<tr><td><h3>Importe:</h3></td><td><h3>"+ Float.parseFloat(filas[5].toString()) + "</h3></td></tr>"
                                        + "</table></div>");
                                out.println("<button type='submit' name='acc' value='Quitar' class='btn'>"+ "<image src='Iconos/quitar.png' />"+"</button>"
                                        + "</div></form></li>"
                                    + "");   
                        
                        } %>
                        </ul>
                    </div>
                    <hr>
                    <ul class="list-group list-group-horizontal">
                        <li class="list-group-item">
                            <h5>Total: <%= Float.parseFloat(ModeloVenta.gettotal()+"") %></h5> <br>
                        </li>
                        <li class="list-group-item">
                            <% if (ModeloVenta.getCes().size()>0){ %>
                                <form method="post" action="ControlVenta">
                                    <button type="button" id="btnCompra" data-toggle="modal" data-target="#modalCompra" class="btn btn-danger">
                                        <h4>Confirmar compra</h4>
                                    </button>
                                </form>
                            <% }else{ %>
                                <h3>Su carrito esta vacio )':</h3>
                            <% } %>
                            
                        </li>
                    </ul>
                    
                </div>
            </div>
        <!--Toats-->
        <!--Modal-->
            <div class="modal fade" id="verMisCompras" tabindex="-1" aria-labelledby="verMisComprasLabel" aria-hidden="true">
                <div class="modal-dialog modal-xl">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h3>Mis compras</h3>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th>#</th>
                                        <th>ID</th>
                                        <th>FECHA Y HORA</th>
                                        <th>TOTAL</th>
                                        <th>ESTADO</th>
                                        <th></th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <% for (int i = 1; i < listVentaPorusuario.size(); i++) { %>
                                        <% Object[] fila = (Object[])listVentaPorusuario.get(i);%>
                                        <tr>
                                            <td><%= i %></td>
                                            <td><%= fila[0] %></td>
                                            <td><%= fila[1]+" "+fila[2] %></td>
                                            <td><%= Float.parseFloat(fila[3].toString()) %></td>
                                            <td><%= fila[4] %></td>
                                            <td>
                                                <button class="btn">
                                                    <svg width="3em" height="3em" viewBox="0 0 16 16" class="bi bi-eye" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                                        <path fill-rule="evenodd" d="M16 8s-3-5.5-8-5.5S0 8 0 8s3 5.5 8 5.5S16 8 16 8zM1.173 8a13.134 13.134 0 0 0 1.66 2.043C4.12 11.332 5.88 12.5 8 12.5c2.12 0 3.879-1.168 5.168-2.457A13.134 13.134 0 0 0 14.828 8a13.133 13.133 0 0 0-1.66-2.043C11.879 4.668 10.119 3.5 8 3.5c-2.12 0-3.879 1.168-5.168 2.457A13.133 13.133 0 0 0 1.172 8z"/>
                                                        <path fill-rule="evenodd" d="M8 5.5a2.5 2.5 0 1 0 0 5 2.5 2.5 0 0 0 0-5zM4.5 8a3.5 3.5 0 1 1 7 0 3.5 3.5 0 0 1-7 0z"/>
                                                    </svg>
                                                </button>
                                            </td>
                                        </tr>
                                    <% } %>
                                </tbody>
                            </table>
                            
                        </div>
                    </div>
                </div>
            </div>
            <div class="modal fade" id="modalCompra" tabindex="-1" aria-labelledby="modalCompraLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h2 id="exampleModalLabel">Confirmar compra!</h2>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <form class='mt-2' method='post' action='ControlVenta'>
                                <input type="hidden" name="id" value="<%= modEmp.getId() %>" />
                                <input type="hidden" id="la" name="la" readonly required/>
                                <input type="hidden" id="lo" name="lo" readonly required/>
                                <button class="btn btn-primary" type="button" data-toggle="collapse" data-target="#collapseExample" aria-expanded="false" aria-controls="collapseExample">
                                    <h4>Verificar su ubicación</h4>
                                </button>
                                <div class="collapse m-2" id="collapseExample" style="height: 300px;overflow-y: scroll;">
                                    <div id="mapa"></div>
                                    <button type="submit" name="acc" value="Confirmar compra" class="btn btn-danger m-3">
                                        <h4>Confirmar compra</h4>
                                    </button>
                                    <div class="alert alert-warning m-3" role="alert">
                                        <h3>Recuerde que se le enviará su pedido a la ubicacion indicada. Se le recomienda usar un navegador sin proxys.</h3>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>     
        <!--Modal-->
        <script>
            
            $("#btnto1").on('click', function(){
                $("#toast1").toast('show');
            });
        </script>
        <script src="assets/js/misFunciones.js" />
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>   
  </body>
</html>
