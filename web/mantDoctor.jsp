<%-- 
    Document   : Inicio
    Created on : May 23, 2020, 10:58:26 AM
    Author     : Enzo Quartino Zamora <github.com/enzocr || email: enzoquartino@gmail.com>
--%>

<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="java.util.Locale"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="negocio.bo.DoctorBo"%>
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
                    if (isNaN(document.getElementById("txtCedula"))) {
                        document.getElementById("txtCedula").classList.add('input-error');
                        alert("Favor solo ingresar números en la cédula");
                        return false;
                    } else {
                        document.getElementById("oculto").value = "REGISTRAR";
                        return true;
                    }

                } else {
                    alert("Por favor llenar espacios marcados");
                    return false;
                }
            }
            function modificar(cedula) {
                if (validarDatos()) {
                    alert("Doctor modificado");
                    document.getElementById("oculto").value = "MODIFICAR";
                    document.getElementById("seleccionado").value = cedula;
                    return true;
                } else {
                    alert("Por favor llenar espacios marcados");
                    return false;
                }
            }

            function getById(cedula) {
                if (document.getElementById("txtCedula").value !== "") {
                    if (isNaN(document.getElementById("txtCedula"))) {
                        document.getElementById("txtCedula").classList.add('input-error');
                        alert("Favor solo ingresar números en la cédula");
                        return false;
                    } else {
                        document.getElementById("txtCedula").classList.remove('input-error');
                        document.getElementById("oculto").value = "GETBYID";
                        document.getElementById("seleccionado").value = cedula;
                        return true;
                    }
                } else {
                    alert("Agregar cédula a buscar");
                    document.getElementById("txtCedula").classList.add('input-error');
                    return false;
                }
            }
            function getByName(name) {
                if (document.getElementById("txtNombre").value !== "") {
                    document.getElementById("txtNombre").classList.remove('input-error');
                    document.getElementById("oculto").value = "GETBYNAME";
                    document.getElementById("seleccionado").value = name;
                    return true;
                } else {
                    document.getElementById("txtNombre").classList.add('input-error');
                    alert("Agregar nombre(s) a buscar");
                    return false;
                }
            }
            function limpiar() {
                document.getElementById("oculto").value = "LIMPIAR";
                return true;
            }
            function eliminar(cedula) {
                document.getElementById("oculto").value = "ELIMINAR";
                document.getElementById("eliminado").value = cedula;
                alert("Doctor eliminado");
            }
            function seleccionar(cedula) {
                document.getElementById("oculto").value = "SELECCIONAR";
                document.getElementById("seleccionado").value = cedula;
            }

        </script>

    </head>
    <body>
        <% if (session.getAttribute("nombreUsuario") != null) {

                if (request.getAttribute("cedula") == null) {
                    request.setAttribute("cedula", "");
                }
                if (request.getAttribute("nombre") == null) {
                    request.setAttribute("nombre", "");
                }
                if (request.getAttribute("apellidos") == null) {
                    request.setAttribute("apellidos", "");
                }
                if (request.getAttribute("especialidad") == null) {
                    request.setAttribute("especialidad", "");
                }

                if (request.getAttribute("direccion") == null) {
                    request.setAttribute("direccion", "");
                }

                if (request.getAttribute("salario") == null) {
                    request.setAttribute("salario", "");
                }
                if (request.getAttribute("telefono") == null) {
                    request.setAttribute("telefono", "");
                }


        %>

        <div style="text-align: right; margin-right: 30px;">
            Hola <%= session.getAttribute("nombreUsuario")%>
            <br/>
            <%= DateTimeFormatter.ofPattern("MM-dd-yyyy", Locale.ENGLISH).format(LocalDateTime.now())%> 
        </div>

        <h1>Mantenimiento de Doctores</h1>
        <form  method="get" action="ServletMantDoctor">
            <table border="1">
                <tr>
                    <td>Cédula</td>
                    <td>
                        <% if (request.getAttribute("cedula") != "") {%>
                        <input type="text" id="txtCedula" name="cedula" readonly="true" value="<%=request.getAttribute("cedula")%>"/>
                        <% } else {%>
                        <input type="text" id="txtCedula" name="cedula" value="<%=request.getAttribute("cedula")%>"/>
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
                    <td>Apellidos</td>
                    <td>
                        <input type="text" id="txtApellidos" name="apellidos" value="<%=request.getAttribute("apellidos")%>"/>
                    </td>
                </tr>
                <tr>
                <tr>
                    <td>Especialidad</td>
                    <td>
                        <input type="text" id="txtEspecialidad" name="especialidad" value="<%=request.getAttribute("especialidad")%>"/>
                    </td>
                </tr>
                <tr>
                    <td>Salario</td>
                    <td>
                        <input type="number" step="0.01" id="txtSalario" name="salario" value="<%=request.getAttribute("salario")%>"/>
                    </td>
                </tr>
                <tr>
                    <td>Direccion</td>
                    <td>
                        <input type="text" id="txtDireccion" name="direccion" value="<%=request.getAttribute("direccion")%>"/>
                    </td>
                </tr>
                <tr>
                    <td>Teléfono</td>
                    <td>
                        <input type="number" id="telefono" name="telefono" value="<%=request.getAttribute("telefono")%>"/>
                    </td>
                </tr>
            </table>
            <br/>
            <input type="submit" value="Registrar" onclick="return registrar();"/>
            <input type="submit" value="Modificar" onclick="return modificar();"/>
            <input type="submit" value="Consultar por cédula" onclick="return getById();"/>
            <input type="submit" value="Consultar por nombre" onclick="return getByName();"/>
            <input type="submit" value="Limpiar" onclick=" return limpiar();"/>
            <input type ="hidden" id="oculto" name="accion"/>
            <input type ="hidden" id="seleccionado" name="seleccionado"/>
            <input type ="hidden" id="eliminado" name="eliminado"/>

            <hr/>

            <table border="1">
                <tr>
                    <th>Cédula</th>
                    <th>Nombre</th>
                    <th>Apellidos</th>
                    <th>Especialidad</th>
                    <th>Salario</th>
                    <th>Direccion</th>
                    <th>Teléfono</th>
                    <th>Seleccionar</th>
                    <th>Eliminar</th>
                </tr>

                <%! List<Doctor> list = new ArrayList<>(); %>
                <%! DoctorBo docBo = new DoctorBo();%>
                <%
                    this.list = docBo.getAll();
                    for (int i = 0; i < list.size(); i++) {
                        Doctor doc = list.get(i);
                        out.println("<tr>");

                        out.println("<td>");
                        out.println(doc.getCedula());
                        out.println("</td>");
                        out.println("<td>");
                        out.println(doc.getNombre());
                        out.println("</td>");
                        out.println("<td>");
                        out.println(doc.getApellido());
                        out.println("</td>");
                        out.println("<td>");
                        out.println(doc.getEspecialidad());
                        out.println("</td>");
                        out.println("<td>");
                        out.println(doc.getSalario());
                        out.println("</td>");
                        out.println("<td>");
                        out.println(doc.getDireccion());
                        out.println("</td>");
                        out.println("<td>");
                        out.println(doc.getTelefono());
                        out.println("</td>");

                %>
                <td>
                    <input type="image" src="img/select.png"
                           width="25px" onclick="return seleccionar(<%= doc.getCedula()%>)" />
                </td>
                <td>
                    <input type="image" src="img/delete.png"
                           width="25px" onclick="return eliminar(<%= doc.getCedula()%>)" />
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
