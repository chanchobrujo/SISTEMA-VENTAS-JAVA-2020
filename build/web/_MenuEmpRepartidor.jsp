<%-- 
    Document   : _MenuEmpRepartidor
    Created on : 09/12/2020, 10:30:36 PM
    Author     : USUARIO
--%>

<%@page import="SERVICIOS.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <% SerVenta SerVenta = new SerVentaIMP(); %>
        <link rel="stylesheet" href="https://bootswatch.com/4/lux/bootstrap.min.css" />
        <script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <nav class="navbar navbar-danger bg-danger">
            <a class="navbar-brand" >
                <h1 style="color: white;" class="display-4">Entregas.</h1>
            </a>
	</nav>
        <div class="card-body table-responsive-lg" >
            <% for (int i = 1; i < SerVenta.listarVentaEmpRep().size(); i++) { %>
                <% Object[] fila = (Object[])SerVenta.listarVentaEmpRep().get(i); %>
                <div class="p-3">
                    <p>
                        <a class="btn btn-danger" data-toggle="collapse" href="#collapseExample<%=i%>" role="button" aria-expanded="false" aria-controls="collapseExample">
                            <%= fila[1].toString()+" "+ fila[2].toString()+"\n"+fila[3].toString()+" "+fila[4].toString()+" "+fila[7].toString() %> 
                        </a>
                    </p>
                    <div class="collapse" id="collapseExample<%=i%>">
                        <div class="card card-body">
                            <form action="ControlVenta" method="post">
                                <input type="hidden" name="idvn" value="<%= fila[0].toString() %> " />
                                <input type="hidden" name="nme" value="<%= fila[1].toString()+" "+ fila[2].toString() %>" />
                                <input type="hidden" name="la" value="<%= fila[5].toString() %> " />
                                <input type="hidden" name="lo" value="<%= fila[6].toString() %> " />
                                
                                <button type="submit" class="btn btn-danger" name="acc" value="vervnt">
                                    Ver detalle
                                </button>
                            </form>
                        </div>
                    </div>
                </div>
            <% } %>
        </div>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>   
    </body>
</html>
