<%-- 
    Document   : Inicio
    Created on : May 23, 2020, 10:58:26 AM
    Author     : Enzo Quartino Zamora <github.com/enzocr || email: enzoquartino@gmail.com>
--%>

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
        <script type="text/javascript">
            function validarDatos() {
                // document.getElementById("oculto").value = valor;
                return true;
            }
            function registrar() {
                if (validarDatos()) {
                    document.getElementById("oculto").value = "REGISTRAR";
                    return true;
                } else {
                    return false;
                }
            }
            function modificar(cedula) {
                if (validarDatos()) {
                    document.getElementById("oculto").value = "MODIFICAR";
                    document.getElementById("seleccionado").value = cedula;
                    return true;
                } else {
                    return false;
                }
            }

            function getById(cedula) {
                if (validarDatos()) {
                    document.getElementById("oculto").value = "GETBYID";
                    document.getElementById("seleccionado").value = cedula;
                    return true;
                } else {
                    return false;
                }
            }
            function getByName(name) {
                if (validarDatos()) {
                    document.getElementById("oculto").value = "GETBYNAME";
                    document.getElementById("seleccionado").value = name;
                    return true;
                } else {
                    return false;
                }
            }
            function limpiar() {
                document.getElementById("oculto").value = "LIMPIAR";
            }
            function eliminar(cedula) {
                document.getElementById("oculto").value = "ELIMINAR";
                document.getElementById("eliminado").value = cedula;
            }
            function seleccionar(cedula) {
                document.getElementById("oculto").value = "SELECCIONAR";
                document.getElementById("seleccionado").value = cedula;
            }

        </script>

    </head>
    <body>
        <% if (session.getAttribute("nombreUsuario") != null) {%>
        <div style="text-align: right; margin-right: 30px;">
            Hola <%= session.getAttribute("nombreUsuario")%>
            <br/>
            <%= new Date()%>
        </div>

        <h1>Mantenimiento de Doctores</h1>
        <form  method="get" action="ServletMantDoctor">
            <table border="1">
                <tr>
                    <td>Cédula</td>
                    <td>
                        <input type="text" id="txtCedula" name="cedula" value="<%=request.getAttribute("cedula")%>"/>
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
