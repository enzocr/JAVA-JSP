<%-- 
    Document   : Inicio
    Created on : May 23, 2020, 10:58:26 AM
    Author     : Enzo Quartino Zamora <github.com/enzocr || email: enzoquartino@gmail.com>
--%>

<%@page import="negocio.clases.Paciente"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="java.util.Locale"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="negocio.bo.PacienteBo"%>
<%@page import="negocio.clases.Doctor"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            .input-error {
                border: 0.125em solid #c0392b !important;
            }


        </style>
        <script type="text/javascript">
            function validarDatos() {
                let aInputs = document.querySelectorAll('input[type="text"]');
                let aNumbers = document.querySelectorAll('input[type="number"]');
                let bError = true;



                for (let i = 0; i < aInputs.length; i++) {
                    if (aInputs[i].value === '') {
                        bError = false;
                        aInputs[i].classList.add('input-error');
                    } else {
                        aInputs[i].classList.remove('input-error');
                    }
                }
                for (let i = 0; i < aNumbers.length; i++) {
                    if (aNumbers[i].value === '') {
                        bError = false;
                        aNumbers[i].classList.add('input-error');
                    } else {
                        aNumbers[i].classList.remove('input-error');
                    }
                }



                return bError;
            }
            function registrar() {
                if (validarDatos()) {
                    if (isNaN(document.getElementById("txtNombre").value)) {
                        document.getElementById("txtNombre").classList.remove('input-error');
                        document.getElementById("oculto").value = "REGISTRAR";
                        document.getElementById("seleccionado").value = numAsegurado;
                        return true;
                    } else {
                        document.getElementById("txtNombre").classList.add('input-error');
                        alert("Favor solo ingresar letras en el nombre");
                        return false;
                    }
                } else {
                    alert("Por favor llenar espacios marcados");
                    return false;
                }
            }
            function modificar(numAsegurado) {
                if (validarDatos()) {
                    document.getElementById("oculto").value = "MODIFICAR";
                    document.getElementById("seleccionado").value = numAsegurado;
                    return true;
                } else {
                    alert("Por favor llenar espacios marcados");
                    return false;
                }
            }

            function getById(numAsegurado) {
                if (document.getElementById("txtNumAsegurado").value !== "") {
                    document.getElementById("txtNumAsegurado").classList.remove('input-error');
                    document.getElementById("oculto").value = "GETBYID";
                    document.getElementById("seleccionado").value = numAsegurado;
                    return true;
                } else {
                    alert("Agregar # asegurado a buscar");
                    document.getElementById("txtNumAsegurado").classList.add('input-error');
                    return false;
                }
            }
            function getByName(name) {
                if (document.getElementById("txtNombre").value !== "") {
                    if (isNaN(document.getElementById("txtNombre").value)) {
                        document.getElementById("txtNombre").classList.remove('input-error');
                        document.getElementById("oculto").value = "GETBYNAME";
                        document.getElementById("seleccionado").value = name;
                        return true;
                    } else {
                        document.getElementById("txtNombre").classList.add('input-error');
                        alert("Favor solo ingresar letras en el nombre");
                        return false;
                    }
                } else {
                    alert("Agregar nombre(s) a buscar");
                    document.getElementById("txtNombre").classList.add('input-error');
                    return false;
                }
            }
            function limpiar() {
                document.getElementById("oculto").value = "LIMPIAR";
                return true;
            }
            function eliminar(numAsegurado) {
                document.getElementById("oculto").value = "ELIMINAR";
                document.getElementById("eliminado").value = numAsegurado;
                alert("Paciente eliminado");
            }
            function seleccionar(numAsegurado) {
                document.getElementById("oculto").value = "SELECCIONAR";
                document.getElementById("seleccionado").value = numAsegurado;
            }

        </script>

    </head>
    <body>
        <% if (session.getAttribute("nombreUsuario") != null) {

                if (request.getAttribute("numAsegurado") == null) {
                    request.setAttribute("numAsegurado", "");
                }
                if (request.getAttribute("nombre") == null) {
                    request.setAttribute("nombre", "");
                }
                if (request.getAttribute("direccion") == null) {
                    request.setAttribute("direccion", "");
                }
                if (request.getAttribute("fechaNacimiento") == null) {
                    request.setAttribute("fechaNacimiento", "");
                }
                if (request.getAttribute("email") == null) {
                    request.setAttribute("email", "");
                }
                if (request.getAttribute("telefono") == null) {
                    request.setAttribute("telefono", "");
                }
                if (request.getAttribute("profesion") == null) {
                    request.setAttribute("profesion", "");
                }
        %>

        <div style="text-align: right; margin-right: 30px;">
            Hola <%= session.getAttribute("nombreUsuario")%>
            <br/>
            <%= DateTimeFormatter.ofPattern("MM-dd-yyyy", Locale.ENGLISH).format(LocalDateTime.now())%> 
        </div>

        <h1>Mantenimiento de Pacientes</h1>
        <form  method="get" action="ServletMantPaciente">
            <table border="1">
                <tr>
                    <td># Asegurado</td>
                    <td>
                        <% if (request.getAttribute("numAsegurado") != "") {%>
                        <input type="number" min="0" id="txtNumAsegurado" name="numAsegurado" readonly="true" value="<%=request.getAttribute("numAsegurado")%>"/>
                        <% } else {%>
                        <input type="number" min="0" id="txtNumAsegurado" name="numAsegurado" value="<%=request.getAttribute("numAsegurado")%>"/>
                        <%}%> 
                    </td>
                </tr>
                <tr>
                    <td>Nombre</td>
                    <td>
                        <input type="text" id="txtNombre" name="nombre" value="<%=request.getAttribute("nombre")%>"/>
                    </td>
                </tr>

                <tr>
                    <td>Dirección</td>
                    <td>
                        <input type="text" id="txtDireccion" name="direccion" value="<%=request.getAttribute("direccion")%>"/>
                    </td>
                </tr>
                <tr>
                <tr>
                    <td>Fecha</td>
                    <td>
                        <% if (request.getAttribute("numAsegurado") != "") {%>
                        <input type="date" id="txtFechaNacimiento" name="fechaNacimiento" readonly="true" value="<%=request.getAttribute("fechaNacimiento")%>"/>
                        <% } else {%>
                        <input type="date" id="txtNumAsegurado" name="numAsegurado" value="1950-01-01"/>
                        <%}%>
                    </td>


                </tr>
                <tr>
                    <td>Correo</td>
                    <td>
                        <input type="text" id="txtEmail" name="email" value="<%=request.getAttribute("email")%>"/>
                    </td>
                </tr>
                <tr>
                    <td>Teléfono</td>
                    <td>
                        <input type="number" min="0" id="txtTelefono" name="telefono" value="<%=request.getAttribute("telefono")%>"/>
                    </td>
                </tr>
                <tr>
                    <td>Profesión</td>
                    <td>
                        <input type="text" id="txtProfesion" name="profesion" value="<%=request.getAttribute("profesion")%>"/>
                    </td>
                </tr>
            </table>
            <br/>
            <input type="submit" value="Registrar" onclick="return registrar();"/>
            <input type="submit" value="Modificar" onclick="return modificar();"/>
            <input type="submit" value="Consultar por # asegurado" onclick="return getById();"/>
            <input type="submit" value="Consultar por nombre" onclick="return getByName();"/>
            <input type="submit" value="Limpiar" onclick=" return limpiar();"/>
            <input type ="hidden" id="oculto" name="accion"/>
            <input type ="hidden" id="seleccionado" name="seleccionado"/>
            <input type ="hidden" id="eliminado" name="eliminado"/>

            <hr/>

            <table border="1">
                <tr>
                    <th># Asegurado</th>
                    <th>Nombre</th>
                    <th>Dirección</th>
                    <th>Fecha nacimiento</th>
                    <th>Edad</th>
                    <th>Correo</th>
                    <th>Teléfono</th>
                    <th>Profesión</th>
                    <th>Seleccionar</th>
                    <th>Eliminar</th>
                </tr>

                <%! List<Paciente> list = new ArrayList<>(); %>
                <%! PacienteBo pacBo = new PacienteBo();%>
                <%
                    if (request.getParameter("getbyid") != null) {
                        int cedula = Integer.parseInt(request.getParameter("getbyid"));
                        Paciente obj = this.pacBo.getById(cedula);
                        this.list = new ArrayList<>();
                        if (obj == null) {
                            out.print("<h4>No hay resultados</h4>");
                        } else {
                            list.add(obj);
                        }
                    } else if (request.getParameter("getbyname") != null) {
                        this.list = this.pacBo.getByName(request.getParameter("getbyname"));
                        if (list == null) {
                            out.print("<h4>No hay resultados</h4>");
                        }
                    } else {
                        this.list = pacBo.getAll();
                    }

                    for (int i = 0; i < list.size(); i++) {
                        Paciente pac = list.get(i);
                        out.println("<tr>");

                        out.println("<td>");
                        out.println(pac.getNumAsegurado());
                        out.println("</td>");
                        out.println("<td>");
                        out.println(pac.getNombre());
                        out.println("</td>");
                        out.println("<td>");
                        out.println(pac.getDireccion());
                        out.println("</td>");
                        out.println("<td>");
                        out.println(pac.getFechaNacimiento());
                        out.println("</td>");
                        out.println("<td>");
                        out.println(pac.getEdad());
                        out.println("</td>");
                        out.println("<td>");
                        out.println(pac.getEmail());
                        out.println("</td>");
                        out.println("<td>");
                        out.println(pac.getTelefono());
                        out.println("</td>");
                        out.println("<td>");
                        out.println(pac.getProfesion());
                        out.println("</td>");

                %>
                <td>
                    <input type="image" src="img/select.png"
                           width="25px" onclick="return seleccionar(<%= pac.getNumAsegurado()%>)" />
                </td>
                <td>
                    <input type="image" src="img/delete.png"
                           width="25px" onclick="return eliminar(<%= pac.getNumAsegurado()%>)" />
                </td>
                <%  out.println("</tr>");
                    }
                %>
            </table>
        </form>




        <% } else { %>
        <p>Sesion invalida, vuelva a logearse</p>
        <a href ="logIn.html"> Ir al LogIn</a>

        <% }%>
    </body>
</html>
