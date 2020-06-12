<%-- 
    Document   : Inicio
    Created on : May 23, 2020, 10:58:26 AM
    Author     : Enzo Quartino Zamora <github.com/enzocr || email: enzoquartino@gmail.com>
--%>

<%@page import="negocio.bo.HerramientaMedicaBo"%>
<%@page import="negocio.clases.HerramientaMedica"%>
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
                    let cantTotal = document.getElementById("nmbCantTotal").value;
                    let cantPrestada = document.getElementById("nmbCantPrestada").value;

                    if (cantTotal < cantPrestada) {
                        document.getElementById("nmbCantTotal").classList.add('input-error');
                        document.getElementById("nmbCantPrestada").classList.add('input-error');
                        alert("La cantidad total de herramientas no puede ser menor que la cantidad prestada")
                        return false;
                    } else {
                        document.getElementById("nmbCantTotal").classList.remove('input-error');
                        document.getElementById("nmbCantPrestada").classList.remove('input-error');
                        document.getElementById("oculto").value = "REGISTRAR";
                        document.getElementById("seleccionado").value = codigo;
                        return true;
                    }
                } else {
                    alert("Por favor llenar espacios marcados");
                    return false;
                }
            }
            function modificar(codigo) {
                if (validarDatos()) {

                    let cantTotal = document.getElementById("nmbCantTotal").value;
                    let cantPrestada = document.getElementById("nmbCantPrestada").value;

                    if (cantTotal < cantPrestada) {
                        document.getElementById("nmbCantTotal").classList.add('input-error');
                        document.getElementById("nmbCantPrestada").classList.add('input-error');
                        alert("La cantidad total de herramientas no puede ser menor que la cantidad prestada");
                        return false;
                    } else {
                        document.getElementById("nmbCantTotal").classList.remove('input-error');
                        document.getElementById("nmbCantPrestada").classList.remove('input-error');
                        document.getElementById("oculto").value = "MODIFICAR";
                        document.getElementById("seleccionado").value = codigo;
                        return true;
                    }

                } else {
                    alert("Por favor llenar espacios marcados");
                    return false;
                }
            }

            function getByCode(codigo) {
                if (document.getElementById("txtCodigo").value !== "") {

                    document.getElementById("txtCodigo").classList.remove('input-error');
                    document.getElementById("oculto").value = "GETBYCODE";
                    document.getElementById("seleccionado").value = codigo;
                    return true;
                } else {
                    alert("Agregar código a buscar");
                    document.getElementById("txtCodigo").classList.add('input-error');
                    return false;
                }
            }
            function getByDesc(descripcion) {
                if (document.getElementById("txtDescripcion").value !== "") {
                    document.getElementById("txtDescripcion").classList.remove('input-error');
                    document.getElementById("oculto").value = "GETBYDESC";
                    document.getElementById("seleccionado").value = descripcion;
                    return true;

                } else {
                    alert("Agregar descripcion(s) a buscar");
                    document.getElementById("txtDescripcion").classList.add('input-error');
                    return false;
                }
            }
            function limpiar() {
                document.getElementById("oculto").value = "LIMPIAR";
                return true;
            }
            function eliminar(codigo) {
                document.getElementById("oculto").value = "ELIMINAR";
                document.getElementById("eliminado").value = codigo;
                alert("Herramienta médica eliminada");
            }
            function seleccionar(codigo) {
                document.getElementById("oculto").value = "SELECCIONAR";
                document.getElementById("seleccionado").value = codigo;
            }

        </script>

    </head>
    <body>
        <% if (session.getAttribute("nombreUsuario") != null) {

                if (request.getAttribute("codigo") == null) {
                    request.setAttribute("codigo", "");
                }
                if (request.getAttribute("descripcion") == null) {
                    request.setAttribute("descripcion", "");
                }
                if (request.getAttribute("cantTotal") == null) {
                    request.setAttribute("cantTotal", "");
                }
                if (request.getAttribute("cantPrestada") == null) {
                    request.setAttribute("cantPrestada", "");
                }
        %>

        <div style="text-align: right; margin-right: 30px;">
            Hola <%= session.getAttribute("nombreUsuario")%>
            <br/>
            <%= DateTimeFormatter.ofPattern("MM-dd-yyyy", Locale.ENGLISH).format(LocalDateTime.now())%> 
            <a href="inicio.jsp"><input type="submit" value="Volver a menu"></a>
        </div>

        <h1>Mantenimiento de Herramientas Médicas</h1>
        <form  method="get" action="ServletMantHerramientaMedica">
            <table border="1">
                <tr>
                    <td>Código</td>
                    <td>
                        <% if (request.getAttribute("codigo") != "") {%>
                        <input type="number" min="0" id="txtCodigo" name="codigo" readonly="true" value="<%=request.getAttribute("codigo")%>"/>
                        <% } else {%>
                        <input type="number"  min="0" id="txtCodigo" name="codigo" value="<%=request.getAttribute("codigo")%>"/>
                        <%}%>
                    </td>
                </tr>
                <tr>
                    <td>Descripción</td>
                    <td>
                        <input type="text"  id="txtDescripcion" name="descripcion" value="<%=request.getAttribute("descripcion")%>"/>
                    </td>
                </tr>

                <tr>
                    <td>Cantidad total</td>
                    <td>
                        <input type="number"  min="0" id="nmbCantTotal" name="cantTotal" value="<%=request.getAttribute("cantTotal")%>"/>
                    </td>
                </tr>

                <tr>
                    <td>Cantidad prestada</td>
                    <td>
                        <input type="number" min="0" id="nmbCantPrestada" name="cantPrestada" value="<%=request.getAttribute("cantPrestada")%>"/>
                    </td>
                </tr>


            </table>
            <br/>
            <input type="submit" value="Registrar" onclick="return registrar();"/>
            <input type="submit" value="Modificar" onclick="return modificar();"/>
            <input type="submit" value="Consultar por código" onclick="return getByCode();"/>
            <input type="submit" value="Consultar por descripción" onclick="return getByDesc();"/>
            <input type="submit" value="Limpiar" onclick=" return limpiar();"/>
            <input type ="hidden" id="oculto" name="accion"/>
            <input type ="hidden" id="seleccionado" name="seleccionado"/>
            <input type ="hidden" id="eliminado" name="eliminado"/>

            <hr/>

            <table border="1">
                <tr>
                    <th>Código</th>
                    <th>Descripción</th>
                    <th>Cantidad total</th>
                    <th>Cantidad prestada</th>
                    <th>Seleccionar</th>
                    <th>Eliminar</th>
                </tr>

                <%! List<HerramientaMedica> list = new ArrayList<>(); %>
                <%! HerramientaMedicaBo herrBo = new HerramientaMedicaBo();%>
                <%
                    if (request.getParameter("getbycode") != null) {
                        int codigo = Integer.parseInt(request.getParameter("getbycode"));
                        HerramientaMedica obj = this.herrBo.getByCode(codigo);
                        this.list = new ArrayList<>();
                        if (obj == null) {
                            out.print("<h4>No hay resultados</h4>");
                        } else {
                            list.add(obj);
                        }

                    } else if (request.getParameter("getbydesc") != null) {
                        this.list = this.herrBo.getByDesc(request.getParameter("getbydesc"));
                        if (list == null) {
                            out.print("<h4>No hay resultados</h4>");
                        }
                    } else {
                        this.list = herrBo.getAll();
                    }

                    for (int i = 0; i < list.size(); i++) {
                        HerramientaMedica h = list.get(i);
                        out.println("<tr>");

                        out.println("<td>");
                        out.println(h.getCodigo());
                        out.println("</td>");
                        out.println("<td>");
                        out.println(h.getDescripcion());
                        out.println("</td>");
                        out.println("<td>");
                        out.println(h.getCantTotal());
                        out.println("</td>");
                        out.println("<td>");
                        out.println(h.getCantidadPrestado());
                        out.println("</td>");

                %>
                <td>
                    <input type="image" src="img/select.png"
                           width="25px" onclick="return seleccionar(<%= h.getCodigo()%>)" />
                </td>
                <td>
                    <input type="image" src="img/delete.png"
                           width="25px" onclick="return eliminar(<%= h.getCodigo()%>)" />
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
