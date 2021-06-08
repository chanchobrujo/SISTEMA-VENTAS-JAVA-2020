<%@page import="java.util.List"%>
<%@page import="MODELOS.*"%>
<%@page import="DAO.*"%>
<%@page import="LOGICA.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>

<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="assets/css/style.css">
    <link href="https://fonts.googleapis.com/css?family=Muli:300,700&display=swap" rel="stylesheet">
    <link href="https://unpkg.com/ionicons@4.5.10-0/dist/css/ionicons.min.css" rel="stylesheet">
    <script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
    <title></title>
</head>

<body>
    <% ModeloEmpleado modEmp = (ModeloEmpleado)session.getAttribute("sesEmp"); %>
    <% DaoCategoria dao = new DaoCategoriaIMP(); %>
    <% DaoProducto daopro = new DaoProductosIMP(); %>
    <% DaoRol DaoRol = new DaoRolIMP(); %>
    <% DaoUsuario DaoUsuario = new DaoUsuarioIMP(); %>
    <% List listaUsuario = DaoUsuario.listarTodos(); %>
    <% List listarol1 = DaoRol.listar1(); %>
    <% List listarol2 = DaoRol.listar2(); %>
    <% List listaproducto = daopro.listar1(); %>
    <% List listacategoria1 = dao.listar1(); %>
    <% List listacategoria2 = dao.listar2(); %>
    <div class="d-flex" id="content-wrapper">

        <!-- Sidebar -->
        <div id="sidebar-container" class="bg-primary">
            <div class="logo">
                <h4 class="text-light font-weight-bold mb-0">Administracion</h4>
            </div>
            <div class="dropdown-divider"></div> 
            <div class="list-group list-group-flush" id="list-tab" role="tablist">
                <a class="d-block text-light p-3 border-0 nav-link active" id="v-pills-home-tab" data-toggle="pill" href="#v-pills-home" role="tab" aria-controls="v-pills-home" aria-selected="true">
                  <i class="icon ion-md-apps lead mr-2"></i>
                    Mantenimientos
                  </a>

                <a class="d-block text-light p-3 border-0 nav-link" id="v-pills-profile-tab" data-toggle="pill" href="#v-pills-profile" role="tab" aria-controls="v-pills-profile" aria-selected="false">
                  <i class="icon ion-md-people lead mr-2"></i>
                    Usuarios
                  </a>
                <a class="d-block text-light p-3 border-0 nav-link" id="v-pills-settings-tab" data-toggle="pill" href="#v-pills-settings" role="tab" aria-controls="v-pills-settings" aria-selected="false">
                  <i class="icon ion-md-person lead mr-2"></i>
                    Perfil
                  </a>
            </div>
        </div>
        <!-- Fin sidebar -->

        <div class="w-100">

         <!-- Navbar -->
         <nav class="navbar navbar-expand-lg navbar-light bg-light border-bottom">
            <div class="container">
    
              <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
              </button>
    
              <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <h1 class="font-weight-bold mb-0">Bienvenido <%= modEmp.getNom()+" "+modEmp.getAp()%></h1>
                <ul class="navbar-nav ml-auto mt-2 mt-lg-0">
                  <li class="nav-item dropdown">
                    <a class="nav-link text-dark dropdown-toggle" href="#" id="navbarDropdown" role="button"
                      data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <img src="<%= modEmp.getFoto() %>" class="img-fluid rounded-circle avatar mr-2"
                      alt="https://generated.photos/" /><%= modEmp.getUs()%>
                    </a>
                    <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdown">
                        <form method="post" action="_ControlLogin">
                            <button type="submit" class="btn" name="acc" value="Cerrar sesion">Cerrar sesion.</button>
                        </form>
                    </div>
                  </li>
                </ul>
              </div>
            </div>
          </nav>
          <!-- Fin Navbar -->

        <!-- Page Content -->
        <div id="content" class="bg-grey w-100">
              <section>
                <div class="tab-content" id="nav-tabContent">
                    <div class="tab-pane fade show active" id="v-pills-home" role="tabpanel" aria-labelledby="v-pills-home-tab">
                        <nav>
                          <div class="nav nav-tabs" id="nav-tab" role="tablist">
                            <a class="nav-link active" id="nav-home-tab" data-toggle="tab" href="#nav-home" role="tab" aria-controls="nav-home" aria-selected="true"><div class="display-5">Categoria</div></a>
                            <a class="nav-link " id="nav-contact-tab" data-toggle="tab" href="#nav-contact" role="tab" aria-controls="nav-contact" aria-selected="false"><div class="display-5">Roles</div></a>
                            <a class="nav-link" id="nav-profile-tab" data-toggle="tab" href="#nav-profile" role="tab" aria-controls="nav-profile" aria-selected="false"><div class="display-5">Producto</div></a>
                          </div>
                        </nav>
                    <div class="tab-content" id="nav-tabContent">
                      <div class="tab-pane fade show active" id="nav-home" role="tabpanel" aria-labelledby="nav-home-tab">
                        <div class="d-flex" >
                            <div class="card col-sm-3">
                                <div class="card-header">
                                    <h2>Mantenimiento de categorias.</h2>
                                </div>
                                <div class="card-body">
                                    <form method="POST" action="ControlCategoria">
                                        <div class="form-group">
                                            <input type="hidden" name="ID" id="idcategoria"/>
                                        </div>
                                        <div class="form-group">
                                            <input type="text" name="Nombre" id="nombrecategoria" required="true" class="btn-block"/>
                                        </div>
                                        <div class="form-group form-check">
                                            <input class="form-check-input custom-control-input" type="radio" name="Estado" value="Activo" id="acestadocategoria" checked>
                                            <label class="form-check-label custom-control-label" for="acestadocategoria">Activo</label>
                                        </div>
                                        <div class="form-group form-check">
                                            <input class="form-check-input custom-control-input" type="radio" name="Estado" value="Inactivo" id="inestadocategoria">
                                            <label class="form-check-label custom-control-label" for="inestadocategoria">Inactivo</label>
                                        </div>
                                        <div class="form-group">
                                            <ul class="list-group list-group">
                                                <li class="list-group-item" style="border: none;">
                                                    <button type="reset" class="btn btn-primary w-100 align-self-center" id="borrar">
                                                      Limpiar
                                                    </button>
                                                </li>
                                                <li class="list-group-item" style="border: none;">
                                                    <button type="submit" class="btn btn-primary w-100 align-self-center" name="acc" value="Registrar" class="btn">
                                                      Registrar
                                                    </button>
                                                </li>
                                                <li class="list-group-item" style="border: none;">
                                                    <button type="submit" class="btn btn-primary w-100 align-self-center" name="acc" value="Actualizar" class="btn">
                                                      Actualizar
                                                    </button>
                                                </li>
                                            </ul>
                                        </div>
                                    </form>
                                </div>
                            </div>
                            <div class="card col-sm-8" style="height:500px; overflow: auto;">
                                <table class="table" style="font-size: 20px;">
                                    <thead> 
                                        <tr>
                                            <th>ID</th>
                                            <th>NOMBRE</th>
                                            <th>ESTADO</th>
                                            <th>OPCION</th>
                                        </tr>
                                    </thead>
                                    <% for (int i = 0; i < listacategoria1.size(); i++) { 
                                        Categoria obj = (Categoria) listacategoria1.get(i);%>
                                        <tr>
                                            <td><div id="_idcategoria"><%= obj.getId()%></div></td>
                                            <td><div id="_nombrecategoria"><%= obj.getCategoria()%></div></td>
                                            <td><div id="_estadocategoria"><%= obj.getEstado()%></div></td>
                                            <td>
                                                <button type="button" class="EditarCategoria btn">
                                                    <image src="Iconos/editar.png" />
                                                </button>
                                            </td>
                                        </tr> 
                                    <% }%>
                                </table>
                            </div>
                        </div>
                      </div>
                      <div class="tab-pane fade" id="nav-profile" role="tabpanel" aria-labelledby="nav-profile-tab">
                        <div class="d-flex" >
                            <div class="card col-sm-3">
                                <div class="card-header">
                                    <h2>Mantenimiento de productos.</h2>
                                </div>
                                <div class="card-body"  style="height: 480px; overflow-y: auto;overflow-x: hidden;">
                                    <form method="POST" action="ControlProducto">
                                        <div class="form-group">
                                            <input type="hidden" name="ID" id="IDProducto"/>
                                        </div>
                                        <div class="form-group">
                                            <input type="text" name="Nombre" id="NombreProducto" required="true" placeholder="Nombre" class="btn-block" maxlength="40"/>
                                        </div>
                                        <div class="form-group">
                                            <input type="text" name="des" id="desProducto" required="true" placeholder="Descripcion" class="btn-block" maxlength="50"/>
                                        </div>
                                        <div class="form-group">
                                            <input type="text" name="precio" id="precioProducto" required="true" placeholder="Precio" class="btn-block"/>
                                        </div>
                                        <div class="form-group">
                                            <select name="Categoria" id="CategoriaProducto" >
                                                <% for (int i = 0; i < listacategoria2.size(); i++) { %>
                                                    <% Categoria obj = (Categoria) listacategoria2.get(i);%>
                                                    <option value='<%= obj.getId()%>'><%= obj.getCategoria() %></option>
                                                <% }%>
                                            </select>
                                        </div>
                                        <div class="form-group">
                                            <input type="number" name="Stock" id="StockProducto" required="true" placeholder="Stock" class="btn-block"/>
                                        </div>
                                        <div class="form-group">
                                            <input type="file" id="Producto" onclick="EncriptarImagenAbase64(this)" accept=".jpg,.jpeg,.png,.gif" >
                                            <img src="" id="imageProducto" width="250" height="250" >
                                            <input type="hidden" name="base64Producto" id="base64Producto" >
                                        </div>
                                        <div class="form-group form-check">
                                            <input class="form-check-input custom-control-input" type="radio" name="Estado" value="Activo" id="acProducto" checked>
                                            <label class="form-check-label custom-control-label" for="acProducto">
                                                Activo
                                            </label>
                                        </div>
                                        <div class="form-group form-check">
                                            <input class="form-check-input custom-control-input" type="radio" name="Estado" value="Inactivo" id="inProducto">
                                            <label class="form-check-label custom-control-label" for="inProducto">
                                                Inactivo
                                            </label>
                                        </div>
                                        <div class="form-group">
                                            <ul class="list-group list-group">
                                                <li class="list-group-item" style="border: none;">
                                                    <button type="reset" class="btn btn-primary w-100 align-self-center" id="borrar">
                                                      Limpiar
                                                    </button>
                                                </li>
                                                <li class="list-group-item" style="border: none;">
                                                    <button type="submit" class="btn btn-primary w-100 align-self-center" name="acc" value="Registrar" class="btn">
                                                      Registrar
                                                    </button>
                                                </li>
                                                <li class="list-group-item" style="border: none;">
                                                    <button type="submit" class="btn btn-primary w-100 align-self-center" name="acc" value="Actualizar" class="btn">
                                                      Actualizar
                                                    </button>
                                                </li>
                                            </ul>
                                        </div>
                                    </form>
                                </div>
                            </div>
                            <div class="card col-sm-8" style=" height: 600px; overflow: auto;border: none;">
                                <table class="table" style="font-size: 15px; ">
                                    <thead >
                                        <tr>
                                            <th>ID</th>
                                            <th>NOMBRE</th>
                                            <th>DESCRIPCION</th>
                                            <th>PRECIO</th>
                                            <th>CATEGORIA</th>
                                            <th>STOCK</th>
                                            <th>FOTO</th>
                                            <th>ESTADO</th>
                                            <th ><center>OPCION</center></th>
                                        </tr>
                                    </thead>
                                    <% for (int i = 0; i < listaproducto.size(); i++) { 
                                        Productos obj = (Productos) listaproducto.get(i); %>
                                            <tr>
                                                <td><div id="_idProducto"><%= obj.getId()%></div></td>
                                                <td><div id="_nomProducto"><%= obj.getNombre()%></div></td>
                                                <td><div id="_desProducto"><%= obj.getDescri()%></div></td>
                                                <td><div id="_preProducto"><%= obj.getPrecio()%></div></td>
                                                <td><div id="_catProducto"><%= obj.getCategoria().getId() %></div></td>
                                                <td><div id="_stProducto"><%= obj.getStock()%></div></td>
                                                <td><div id="_ftProducto"><image src="<%= obj.getFoto()%>" height='100' width='100'></div></td>
                                                <td><div id="_esProducto"><%= obj.getEstado()%></div></td>
                                                <td>
                                                    <button type="button" class="EditarProducto btn">
                                                        <image src="Iconos/editar.png" />
                                                    </button>
                                                </td>
                                            </tr> 
                                   <% } %>
                                </table>  
                            </div>
                        </div>
                      </div>
                      <div class="tab-pane fade" id="nav-contact" role="tabpanel" aria-labelledby="nav-contact-tab">
                          <div class="d-flex border">
                            <div class="card col-sm-3" style="height: 500px; overflow: auto;">
                                
                                <div class="card-header">
                                    <h2>Mantenimiento de roles.</h2>
                                </div>
                                <div class="card-body">
                                    <form method="POST" action="ControlRol">
                                        <div class="form-group">
                                            <input type="hidden" name="ID" id="ID"/>
                                        </div>
                                        <div class="form-group">
                                            <input type="text" name="Nombre" id="Nombre" required="true" class="btn-block"/>
                                        </div>
                                        <div class="form-group form-check">
                                            <input class="form-check-input custom-control-input" type="radio" name="Estado" value="Activo" id="ac" checked>
                                            <label class="form-check-label custom-control-label" for="ac">
                                                Activo
                                            </label>
                                        </div>
                                        <div class="form-group form-check">
                                            <input class="form-check-input custom-control-input" type="radio" name="Estado" value="Inactivo" id="in">
                                            <label class="form-check-label custom-control-label" for="in">
                                                Inactivo
                                            </label>
                                        </div>
                                        <div class="form-group">
                                            <ul class="list-group list-group">
                                                <li class="list-group-item" style="border: none;">
                                                    <button type="reset" class="btn btn-primary w-100 align-self-center" id="borrar">
                                                      Limpiar
                                                    </button>
                                                </li>
                                                <li class="list-group-item" style="border: none;">
                                                    <button type="submit" class="btn btn-primary w-100 align-self-center" name="acc" value="Registrar" class="btn">
                                                      Registrar
                                                    </button>
                                                </li>
                                                <li class="list-group-item" style="border: none;">
                                                    <button type="submit" class="btn btn-primary w-100 align-self-center" name="acc" value="Actualizar" class="btn">
                                                      Actualizar
                                                    </button>
                                                </li>
                                            </ul>
                                        </div>
                                    </form>
                                </div>
                            </div>
                            <div class="card col-sm-8" style="height:500px; overflow: auto;">
                                <table class="table" style="font-size: 20px;">
                                    <thead > 
                                        <tr>
                                            <th>ID</th>
                                            <th>NOMBRE</th>
                                            <th>ESTADO</th>
                                            <th>OPCION</th>
                                        </tr>
                                    </thead>
                                    <% for (int i = 0; i < listarol1.size(); i++) { 
                                            Roles obj = (Roles) listarol1.get(i);
                                        %>
                                            <tr>
                                                <td><div id="_id"><%= obj.getId()%></div></td>
                                                <td><div id="_nom"><%= obj.getRol()%></div></td>
                                                <td><div id="_es"><%= obj.getEstado()%></div></td>
                                                <td>
                                                    <button type="button" class="abrir btn">
                                                        <image src="Iconos/editar.png" />
                                                    </button>
                                                </td>
                                            </tr> 
                                        <% }%>
                                </table>
                            </div>
                        </div>
                      </div>
                    </div>
                  </div>
                    <div class="tab-pane fade" id="v-pills-profile" role="tabpanel" aria-labelledby="v-pills-profile-tab">
                          <% for (int i = 0; i < listarol2.size(); i++) {%>
                              <% Roles Roles = (Roles) listarol2.get(i); %>

                              <div class="card col-12">
                                  <div class="card-header display-4">
                                      <%= Roles.getRol() %>

                                  </div>
                                  <div class="card-body" >
                                      <ul class="list-group list-group-horizontal-sm" style="overflow: auto;">
                                          <% for (int j = 0; j < listaUsuario.size(); j++) {%>
                                              <% Usuarios Usuario = (Usuarios) listaUsuario.get(j); %>
                                              <% if(Usuario.getRol().getRol().equals(Roles.getRol())){ %>
                                                  <form action="ControlUsuarios" method="post">
                                                      <li class="list-group-item">
                                                          <div class="card" >
                                                              <div class="card-header">
                                                                  <h4>Datos de <%= Usuario.getUsuario() %></h4>
                                                              </div>
                                                              <div class="card-body">
                                                                  <center>
                                                                      <img src="<%= Usuario.getFoto() %>" style="border-radius: 50%;" width="200" />
                                                                  </center>
                                                                  <input type="hidden" name="codd" value="<%= Usuario.getId() %>"/>
                                                                  <hr>
                                                                  <h5>Nombres:<%= " "+Usuario.getNombres()%></h5>
                                                                  <h5>Apellidos:<%= " "+Usuario.getApellidos()%></h5>
                                                                  <h5>Correo:<%= " "+Usuario.getCorreo()%></h5>
                                                                  <h5>Numero<%= " "+Usuario.getNumero()%></h5>
                                                              </div>
                                                              <div class="card-footer">

                                                                  <% if (!(Usuario.getRol().getId().equals("XDF"))) {%>
                                                                      <% if(Usuario.getEstado().equals("1")){ %>
                                                                          <button type="submit" name="acc" value="darDeAlta"  class="btn btn-block btn-primary" >Dar de alta</button>
                                                                      <% } %>
                                                                      <% if(Usuario.getEstado().equals("0")){ %>
                                                                          <button type="submit" name="acc" value="darDeBaja" class="btn btn-block" style="background: #660000;color: white;" >Dar de baja</button>
                                                                      <% } %>
                                                                  <% }%>
                                                              </div>
                                                          </div>
                                                      </li>
                                                  </form>
                                              <% } %>

                                          <% }%>
                                      </ul>
                                  </div>
                              </div>
                          <% }%>
                    </div>
                    <div class="tab-pane fade" id="v-pills-settings" role="tabpanel" aria-labelledby="v-pills-settings-tab">
                    <div class="jumbotron jumbotron-fluid">
                      <div class="container">
                        <h1 class="display-4">Datos personales</h1>
                        <hr>
                        <div class="d-flex" >
                            <div class="card col-sm-4">
                                <figure class="figure p-3 ">
                                    <button class="btn "data-toggle="modal" data-target="#Modalfoto">
                                        <img src="<%= modEmp.getFoto() %>" class="figure-img img-fluid rounded" data-toggle="tooltip" data-placement="top" title="Cambiar foto de perfil">
                                    </button>
                                    <hr>
                                </figure>
                            </div>
                            <div class="card col-sm-8">
                                <div class="card-header p-3">
                                    <div class="container">
                                        <h3><%= modEmp.getRol() +":  "+ modEmp.getUs() %></h3>
                                    </div>
                                    <div class="card-body">
                                        <div class="container">
                                            <div class="row">
                                                <div class="col-sm">
                                                    <h4>Nombres y apellidos</h4>
                                                </div>
                                                <div class="col-sm">
                                                    <h4>Numero</h4> 
                                                </div>
                                                <div class="col-sm">
                                                    <h4>Correo</h4>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col-sm">
                                                    <%= modEmp.getNom() + modEmp.getAp() %>
                                                </div>
                                                <div class="col-sm">
                                                    <%= modEmp.getNumero() %>
                                                </div>
                                                <div class="col-sm">
                                                    <%= modEmp.getCorreo() %>
                                                </div>
                                            </div>
                                        </div>
                                        <!--<a href="#" class="btn btn-primary">Go somewhere</a>-->
                                    </div>
                                </div>
                            </div>                         
                        </div>                   
                        <hr>
                        <h1 class="display-5">Cambio de contraseña</h1>
                        <hr>
                        <p class="lead">Se recomienda usar una contraseña segura que no uses en ningún otro sitio.</p>
                        <form action="_ControlLogin" method="post">
                            <input type="hidden" name="id" value='<%= modEmp.getId() %>' >
                            <div class="container">
                                <div class="row">
                                  <div class="col-6 col-sm-3 m-3">Actual:</div>
                                  <div class="col-6 col-sm-3 m-3"><input type="password" minlength="7" maxlength="25" name="actualcontra" id="actualcontra"></div>
                                  <div class="w-100"></div>
                                  <div class="col-6 col-sm-3 m-3">Nueva</div>
                                  <div class="col-6 col-sm-3 m-3"><input type="password" minlength="7" maxlength="25" name="nuevacontra" id="nuevacontra"><span id="mensaje"></span></div>
                                  <div class="w-100"></div>
                                  <div class="col-6 col-sm-3 m-3">
                                      <ul>
                                          <li id="mayus">3 Mayúsculas.</li>
                                          <li id="especial">3 Carácteres especiales.</li>
                                          <li id="numeros">Debe incluir dígitos.</li>
                                          <li id="minus">Debe incluir minúsculas.</li>
                                          <li id="len">Debe incluir 7 carácteres como mínimo.</li>
                                      </ul>
                                  </div>
                                  <div class="w-100"></div>
                                  <div class="col-6 col-sm-3 m-3">Confirmar:</div>
                                  <div class="col-6 col-sm-3 m-3"><input type="password" minlength="7" maxlength="25" name="confcontra" id="confcontra"><span id="mensaje2"></span></div>
                                </div>
                            </div>
                            <button type="submit" class="btn btn-danger btn-block" name="acc" id="Cambiarcontrasena" value="Cambiar contrasena" data-toggle="collapse" data-target="#collapseExample" aria-expanded="false" aria-controls="collapseExample">
                                Cambiar contraseña
                            </button>
                        </form>
                        <hr>    
                      </div>
                    </div>
                  </div>
                </div>        
              </section>
            </div>
        </div>
    </div>
    <!--Modales-->
        <div class="modal fade" id="Modalfoto" tabindex="-1" aria-labelledby="Modalfoto" aria-hidden="true" >
            <form action="ControlUsuarios" method="post">
                <input type="hidden" name="id" value="<%= modEmp.getId() %>" > 
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h4>Actualizar foto.</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <div class="input-group">
                                <div class="custom-file">
                                    <input type="file" onclick="EncriptarImagenAbase64(this)" accept=".jpg,.jpeg,.png,.gif" class="custom-file-input" id="Usuario" aria-describedby="inputGroupFileAddon04">
                                    <label class="custom-file-label" for="Usuario">Choose file</label>
                                </div>
                                <div class="input-group-append">
                                    <button class="btn btn-primary btn-block" type="submit" id="inputGroupFileAddon04" name="acc" value="Actualizarfoto">Confirmar</button>
                                </div>
                            </div>
                            <div class="p-5">
                                <center>
                                    <img src="" id="imageUsuario" width="250" height="250" >
                                    <input type="hidden" name="base64Usuario" id="base64Usuario" >
                                </center>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    <!--Modales-->
    <script>
        //SEGURIDAD CONTRASEÑA
            var mayus =    new RegExp("^(?=.*[A-Z].*[A-Z].*[A-Z])");
            var especial = new RegExp("^(?=.*[!@#$%&/=?¡¿{}/*-+.´~<>_:,;].*[!@#$%&/=?¡¿{}/*-+.´~<>_:,;].*[!@#$%&/=?¡¿{}/*-+.´~<>_:,;])"); 
            var numeros =  new RegExp("^(?=.*[0-9])");
            var minus =    new RegExp("^(?=.*[a-z])");
            var len =      new RegExp("^(?=.{7,})");

            var regEXP = [mayus,especial,numeros,minus,len];
            var elementos = [$("#mayus"),$("#especial"),$("#numeros"),$("#minus"),$("#len")];
            $("#Cambiarcontrasena").prop('disabled', true);
            $("#confcontra").prop('disabled', true);
            $("#nuevacontra").on("keyup", function(){
                var contrasena = $("#nuevacontra").val();
                var check=0;
                for (var i = 0; i < 5; i++) {
                    if (regEXP[i].test(contrasena)) {
                        elementos[i].hide();
                        check++;
                    } else {
                        elementos[i].show();
                    }
                }
                if (check >= 0 && check <=2) {
                    $("#confcontra").prop('disabled', true);
                    $("#mensaje").text("Muy insegura.").css("color","red");
                    $("#Cambiarcontrasena").prop('disabled', true);
                }
                if (check >= 3 && check <=4) {
                    $("#confcontra").prop('disabled', true);
                    $("#mensaje").text("Poco segura.").css("color","orange");
                    $("#Cambiarcontrasena").prop('disabled', true);
                }
                if (check >= 5) {
                    $("#mensaje").text("Muy segura.").css("color","green");
                    $("#confcontra").prop('disabled', false);
                    $("#Cambiarcontrasena").prop('disabled', true);
                }
            });
            $("#confcontra").on("keyup", function(){
                var contrasena1 = $("#nuevacontra").val();
                var contrasena2 = $("#confcontra").val();
                if (contrasena1 == contrasena2){
                    $("#mensaje2").text("Confirmada.").css("color","green");
                    $("#Cambiarcontrasena").prop('disabled', false);
                }else{
                    $("#mensaje2").text("No es la misma contraseña.").css("color","red");
                    $("#Cambiarcontrasena").prop('disabled', true);
                }
            });
        //SEGURIDAD CONTRASEÑA
        //JQUERY CATEGORIA
            $('.EditarCategoria').on('click', function(){

              $(this).parents("tr").find("#_idcategoria").each(function() {
                  valores1 =$(this).html();
                  v1 = $.trim(valores1);
                  $("#idcategoria").val(v1);
              });
              $(this).parents("tr").find("#_nombrecategoria").each(function() {
                  valores1 =$(this).html();
                  v1 = $.trim(valores1);
                  $("#nombrecategoria").val(v1);
              }); 
              $(this).parents("tr").find("#_estadocategoria").each(function() {
                  valores1 =$(this).html();
                  v1 = $.trim(valores1);
                  if (v1 == "0") document.querySelector('#acestadocategoria').checked = true;
                  if (v1 == "1") document.querySelector('#inestadocategoria').checked = true;
              });
            }); 
        //JQUERY CATEGORIA
        //JQUERY PRODUCTO
            $('.EditarProducto').on('click', function(){
              $(this).parents("tr").find("#_idProducto").each(function() {
                  valores1 =$(this).html();
                  v1 = $.trim(valores1);
                  $("#IDProducto").val(v1);
              });
              $(this).parents("tr").find("#_nomProducto").each(function() {
                  valores1 =$(this).html();
                  v1 = $.trim(valores1);
                  $("#NombreProducto").val(v1);
              });
              $(this).parents("tr").find("#_desProducto").each(function() {
                  valores1 =$(this).html();
                  v1 = $.trim(valores1);
                  $("#desProducto").val(v1);
              });
              $(this).parents("tr").find("#_preProducto").each(function() {
                  valores1 =$(this).html();
                  v1 = $.trim(valores1);
                  $("#precioProducto").val(v1);
              }); 
              $(this).parents("tr").find("#_stProducto").each(function() {
                  valores1 =$(this).html();
                  v1 = $.trim(valores1);
                  $("#StockProducto").val(v1);
              }); 
              $(this).parents("tr").find("#_catProducto").each(function() {
                  valores1 =$(this).html();
                  v1 = $.trim(valores1);
                  document.ready = document.getElementById("CategoriaProducto").value = v1;
              });
              $(this).parents("tr").find("#_esProducto").each(function() {
                  valores1 =$(this).html();
                  v1 = $.trim(valores1);
                  if (v1 == "0")  document.querySelector('#acProducto').checked = true;
                  if (v1 == "1") document.querySelector('#inProducto').checked = true;
              });
            }); 
        //JQUERY PRODUCTO
        //JQUERY ROLES
            $('.abrir').on('click', function(){
              $(this).parents("tr").find("#_id").each(function() {
                  valores1 =$(this).html();
                  v1 = $.trim(valores1);
                  $("#ID").val(v1);
              });
              $(this).parents("tr").find("#_nom").each(function() {
                  valores1 =$(this).html();
                  v1 = $.trim(valores1);
                  $("#Nombre").val(v1);
              }); 
              $(this).parents("tr").find("#_es").each(function() {
                  valores1 =$(this).html();
                  v1 = $.trim(valores1);
                  if (v1 == "0") {
                      document.querySelector('#ac').checked = true;
                  }
                  if (v1 == "1") {
                      document.querySelector('#in').checked = true;
                  }
              });
            });
        //JQUERY ROLES
        //BASE64
            function EncriptarImagenAbase64(inputFile){
                var idfile = inputFile.id;    
                function encodeImageFileURL() {
                    fileSelect = document.getElementById(idfile).files;
                    if (fileSelect.length>0) {
                        var fileSelect = fileSelect[0];
                        var fileReader = new FileReader();

                        fileReader.onload = function(FileLoadEvent){
                            var srcData = FileLoadEvent.target.result;
                            document.getElementById("image"+idfile).src=srcData
                            document.getElementById("base64"+idfile).value=srcData
                        }
                        fileReader.readAsDataURL(fileSelect)
                    }
                }
                var fileup = document.getElementById(idfile);
                fileup.addEventListener("change",function(){
                    encodeImageFileURL()
                })
            }
        //BASE64
    </script>  
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>   
  </body>
</html>