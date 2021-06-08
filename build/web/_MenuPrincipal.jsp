<%-- 
    Document   : _MenuPrincipal
    Created on : 14/11/2020, 09:43:22 PM
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
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous"/>
        <script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% DaoCategoria DaoCategoria = new DaoCategoriaIMP(); %>
        <% SerProducto SerProducto = new SerProductoIMP(); %>
        <% List Listacategoria = DaoCategoria.listar2(); %>
        <% List Listaproducto = SerProducto.listarProductos(); %>
        <nav class="navbar navbar-expand-lg navbar-light">
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <div class="display-3">Carrito de compras VIRTUAL!</div>
                </ul>
                <div class="dropdown">
                    <button type="button" class="login btn btn-light"data-toggle="modal" data-target="#ModalLogin">
                        <h4>Iniciar sesion</h4>
                    </button>
                    <button type="button" class="login btn btn-primary"data-toggle="modal" data-target="#Registrarse">
                        <h4>Registrarse!</h4>
                    </button>
                </div>     
             </div>                                                   
        </nav>
        <div style="margin: 65px;">
            <% for (int i = 0; i < Listacategoria.size(); i++) { %>
                <% Categoria categoria = (Categoria)Listacategoria.get(i); %>
                <div class="card border-primary mb-3" style="padding: 10px;">
                    <h1 class="display-5"><%= categoria.getCategoria() %><span class="badge badge-light"><%= SerProducto.cantidadProductos(categoria.getId()) %></span></h1>
                    <div class="card-body">
                        <ul class="list-group list-group-horizontal-sm" style="overflow: scroll;">
                            <% for (int j = 1; j < Listaproducto.size(); j++) { %> 
                                <% Object[] productos = (Object[]) Listaproducto.get(j); %>
                                    <% if(productos[4].equals(categoria.getId())){ %>
                                        <li class="list-group-item">
                                            <div class="card" >  
                                                <div class="card-body">
                                                    <table>
                                                        <tr>
                                                            <td>
                                                                <center>
                                                                    <image src=' <%= productos[6] %> ' height='250' width='250'>
                                                                </center>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td><h5 class="card-title"><%= productos[1] %></h5></td>
                                                        </tr>
                                                        <tr>
                                                            <td><h6 class="card-subtitle mb-2 text-mutedbtn-block"><%= productos[2] %></h6></td>
                                                        </tr>
                                                        <tr>
                                                            <td><h6 class="card-subtitle mb-2 text-muted"><%= productos[3]+" Soles." %></h6></td>
                                                        </tr>
                                                        <tr>
                                                            <td colspan="2">
                                                                <button type="button" class="login btn btn-danger" data-toggle="modal" data-target="#ModalLogin">
                                                                    Agregar
                                                                </button>
                                                            </td>
                                                        </tr>
                                                    </table>
                                                </div>
                                            </div>
                                        </li>
                                    <%}%>
                            <% } %>
                        </ul>
                    </div>
                </div>
             <% } %>
        </div>
        
        <!--Mpdales-->   
            <div class="modal fade" id="ModalLogin" tabindex="-1" aria-labelledby="ModalLogin" aria-hidden="true" >
                <div class="modal-dialog modal-sm">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h3 class="modal-title">Inicio de sesión</h3>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <form action="_ControlLogin" method="post" >
                                <table class="table">
                                    <tr>
                                        <td>
                                            <input type="text" style="height: 30px;font-size: 15px;" name="Usuario" class=" btn-block" placeholder="Usuario" required>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <input type="password" style="height: 30px;font-size: 15px;" name="Contrasena" class=" btn-block" placeholder="Contraseña" required>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <button type="submit" class="btn btn-outline-primary btn-block"  name="acc" value="Ingresar" >
                                                <h4>INGRESAR</h4>
                                            </button>
                                        </td>
                                    </tr>
                                </table>
                            </form> 
                        </div>           
                        <div class="modal-footer">
                            <p>
                                <button class="btn" type="button" data-toggle="collapse" data-target="#collapseExample" aria-expanded="false" aria-controls="collapseExample">
                                    ¿Olvidó su usuario o contraseña?
                                </button>
                            </p>
                            <div class="collapse" id="collapseExample">
                                <div class="card card-body">
                                    <form action="_ControlLogin" method="post">
                                        <div class="alert alert-light" role="alert">
                                            Recuerde que debe colocar el correo electrónico con el que se registró, donde se le enviará su contraseña.  
                                        </div>
                                        <div class="form-group col-md-12">
                                            <input type="email" class="form-control" name="correo" placeholder="email@gmail.com" required>
                                        </div>
                                        <button class="btn btn-danger btn-block" name="acc" value="Recuperar contrasena" type="submit" data-toggle="collapse" data-target="#collapseExample" aria-expanded="false" aria-controls="collapseExample">
                                            Restablecer contraseña
                                        </button>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            
            <div class="modal fade" id="Registrarse" tabindex="-1" aria-labelledby="ModalLogin" aria-hidden="true" >
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-body">
                            <form action="_ControlLogin" method="post">
                                <div class="form-row">
                                    <div class="form-group col-md-6">
                                        <input type="text" class="form-control" name="Nombre" placeholder="Nombre" required>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <input type="text" class="form-control" name="Apellido" placeholder="Apellido" required>
                                    </div>
                                </div>
                                <div class="form-row">
                                    <div class="form-group col-md-12">
                                        <input type="text" class="form-control" minlength="7" maxlength="15" name="Usuario" id="Usuario" placeholder="Usuario" required>
                                        <div class="alert" role="alert">
                                            Su nombre de usuario debe tener entre 7 y 15 caracteres.
                                        </div>
                                    </div>
                                </div>
                                <div class="form-row">
                                    <div class="form-group col-md-12">
                                        <input type="text" class="form-control" minlength="13" maxlength="13"  name="numero" placeholder="+51 9xxyyyzzz" required>
                                    </div>
                                </div>
                                <div class="form-row">
                                    <div class="form-group col-md-12">
                                        <input type="email" class="form-control" name="correo" placeholder="email@gmail.com" required>
                                    </div>
                                </div>
                                <div class="form-row">
                                    <div class="form-group col-md-6">
                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                        <button type="submit" name="acc" id="Crearcliente" value="Crear cliente" class="btn btn-primary">Registrarse</button>
                                    </div>
                                </div>
                                <div class="form-row">
                                    <div class="form-group col-md-12">
                                        <div class="alert alert-danger" role="alert">
                                            Se le enviará una contraseña a su correo.
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        <!--Mpdales-->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script> 
    </body>
</html>
