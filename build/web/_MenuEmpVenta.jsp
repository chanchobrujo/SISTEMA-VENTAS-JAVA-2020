<%-- 
    Document   : _MenuEmpVenta
    Created on : 09/12/2020, 10:27:43 PM
    Author     : USUARIO
--%>
<%@page import="java.util.List"%>
<%@page import="MODELOS.*" %>
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
        <% ModeloVenta ModeloVenta = (ModeloVenta)session.getAttribute("SesVenta"); %>
        <% ModeloEmpleado modEmp = (ModeloEmpleado)session.getAttribute("sesEmp"); %>
        <% ModeloCliente ModeloCliente = (ModeloCliente)session.getAttribute("sescli"); %>
        <% List Listaproducto = ModeloVenta.getProductos(); %>
        <header style="background: #8181F7;color: white;">
            <div class="display-1 m-2 p-2">
                ÁREA DE VENTAS
            </div>
        </header>
        <div class="d-flex">
            <div class="card col-sm-4 m-2 shadow p-3 mb-5 bg-white rounded">
                <div class="card-header display-4">
                    Productos a llevar
                </div>
                <div class="card-body" style="height: 120px;">
                    <form method="post" action="ControlCliente">
                        <table cellpadding="10">
                            <tr>
                                <td><h3>Buscar cliente:</h3></td>
                                <td><input type="text" size="6" placeholder="DNI" name="dni" minlength="8" maxlength="8" value="<%= ModeloCliente.getDni()%>" /></td>
                                <td>
                                    <button type="submit" name="acc" value="buscar">
                                        Buscar
                                    </button>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="3"><h5><%= ModeloCliente.getNombre()+" "+ModeloCliente.getApellido() %></h5></td>
                            </tr>
                        </table>
                    </form>
                </div>
                <hr>
                <div class="card-body" style="height: 150px;overflow-y: auto;">
                    <table cellpadding="3" class="table">
                        <thead>
                            <tr>
                                <th></th>
                                <th>PRODUCTO</th>
                                <th>PRECIO</th>
                                <th>CANTIDAD</th>
                                <th>IMPORTE</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <% for (int i = 0; i < ModeloVenta.getCes().size(); i++) { %>
                                <% Object[]filas=(Object[])ModeloVenta.getCes().get(i); %>
                                <tr>
                                    <form method="post" action="ControlVenta">
                                        <input type="hidden" name="idusu" value="<%= modEmp.getId() %>" />
                                        <td><input type="hidden" name="id" value="<%= filas[0] %>" /></td>
                                        <td><%= filas[1]+" "+filas[2] %></td>
                                        <td><%= filas[3] %></td>
                                        <td><%= filas[4] %></td>
                                        <td><%= Float.parseFloat(filas[5].toString()) %></td>
                                        <td>
                                            <button type="submit" name="acc" value="Quitar">
                                                Quitar
                                            </button>
                                        </td>
                                    </form>
                                </tr>
                            <% } %>
                        </tbody>
                    </table>
                </div>
                <hr>
                <div class="card-body" style="height: 50px;">
                    <table>
                        <tr>
                            <td>TOTAL:</td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td><input type="text" style="border: none;" size="10" value="<%= Float.parseFloat(ModeloVenta.gettotal()+"") %>"  /></td>
                            <% if(ModeloVenta.getCes().size()!=0){ %>
                                <td>
                                    <form method="post" action="ControlVenta">
                                        <input type="hidden" name="id" value="<%= modEmp.getId() %>" />
                                        <input type="hidden" name="dni" value="<%= ModeloCliente.getDni() %>" />
                                        <button type="submit" name="acc" value="Confirmar compra">
                                            Confirmar venta
                                        </button>
                                    </form>
                                </td>
                            <% }else{ %>
                                <td>Vacio.</td>
                            <% } %>
                        </tr>
                    </table>
                </div>
                <div class="card-footer">
                    
                </div>
            </div>
            <div class="card col-sm-7 m-2 shadow p-3 mb-5 bg-white rounded">
                <div class="card-header display-4">
                    Productos. 
                </div>
                <hr>
                <form action="ControlVenta" method="post">
                    <input type="hidden" name="id" value="<%= modEmp.getId() %>" />
                    <button type="submit" id="btnNuevo"  name="acc" value="Nueva venta" >
                        Nueva venta
                    </button>
                </form>
                <hr>
                <div class="card-body" style="height: 100px;overflow-y: auto;">
                    <table cellpadding="10" class="table">
                        <thead>
                            <tr>
                                <th></th>
                                <th><h3>PRODUCTO</h3></th>
                                <th><h3>PRECIO</h3></th>
                                <th><h3>FOTO</h3></th>
                                <th><h3>CANTIDAD</h3></th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <% for (int i = 1; i < Listaproducto.size(); i++) { %>
                                <% Object[]fila = (Object[])Listaproducto.get(i); %>
                                <form method="post" action="ControlVenta">
                                    <input type="hidden" name="idusu" value="<%= modEmp.getId() %>" />
                                    <tr>
                                        <td><input type="hidden" name="id" value="<%= fila[0] %>" required readonly /></td>
                                        <td><%= fila[1]+" "+fila[2] %></td>
                                        <td><%= fila[3] %></td>
                                        <td><img src="<%= fila[6] %>" width="50" /></td>
                                        <td><input type="number" name="cantidad" required style="width: 60px;" min="1" max="<%= fila[5] %>" /></td>
                                        <td>
                                            <button type="submit" name="acc" value="Agregar">
                                                Agregar
                                            </button>
                                        </td>
                                    </tr>
                                </form>
                            <% } %>
                        </tbody>
                    </table>
                </div>
                <hr>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>   
    </body>
</html>
