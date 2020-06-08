package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import negocio.bo.HerramientaMedicaBo;
import negocio.clases.HerramientaMedica;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.Locale;
import java.text.SimpleDateFormat;
import negocio.bo.DoctorBo;
import negocio.clases.Doctor;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public final class mantHerramientaMedica_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

 List<HerramientaMedica> list = new ArrayList<>(); 
 HerramientaMedicaBo herrBo = new HerramientaMedicaBo();
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
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <style>\n");
      out.write("            .input-error {\n");
      out.write("                border: 0.125em solid #c0392b !important;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("\n");
      out.write("        </style>\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            function validarDatos() {\n");
      out.write("                let aInputs = document.querySelectorAll('input[type=\"text\"]');\n");
      out.write("                let aNumbers = document.querySelectorAll('input[type=\"number\"]');\n");
      out.write("                let bError = true;\n");
      out.write("\n");
      out.write("                for (let i = 0; i < aInputs.length; i++) {\n");
      out.write("                    if (aInputs[i].value === '') {\n");
      out.write("                        bError = false;\n");
      out.write("                        aInputs[i].classList.add('input-error');\n");
      out.write("                    } else {\n");
      out.write("                        aInputs[i].classList.remove('input-error');\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("                for (let i = 0; i < aNumbers.length; i++) {\n");
      out.write("                    if (aNumbers[i].value === '') {\n");
      out.write("                        bError = false;\n");
      out.write("                        aNumbers[i].classList.add('input-error');\n");
      out.write("                    } else {\n");
      out.write("                        aNumbers[i].classList.remove('input-error');\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("                return bError;\n");
      out.write("            }\n");
      out.write("            function registrar() {\n");
      out.write("                if (validarDatos()) {\n");
      out.write("                    let cantTotal = document.getElementById(\"nmbCantTotal\").value;\n");
      out.write("                    let cantPrestada = document.getElementById(\"nmbCantPrestada\").value;\n");
      out.write("\n");
      out.write("                    if (cantTotal < cantPrestada) {\n");
      out.write("                        document.getElementById(\"nmbCantTotal\").classList.add('input-error');\n");
      out.write("                        document.getElementById(\"nmbCantPrestada\").classList.add('input-error');\n");
      out.write("                        alert(\"La cantidad total de herramientas no puede ser menor que la cantidad prestada\")\n");
      out.write("                        return false;\n");
      out.write("                    } else {\n");
      out.write("                        document.getElementById(\"nmbCantTotal\").classList.remove('input-error');\n");
      out.write("                        document.getElementById(\"nmbCantPrestada\").classList.remove('input-error');\n");
      out.write("                        document.getElementById(\"oculto\").value = \"REGISTRAR\";\n");
      out.write("                        document.getElementById(\"seleccionado\").value = codigo;\n");
      out.write("                        return true;\n");
      out.write("                    }\n");
      out.write("                } else {\n");
      out.write("                    alert(\"Por favor llenar espacios marcados\");\n");
      out.write("                    return false;\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("            function modificar(codigo) {\n");
      out.write("                if (validarDatos()) {\n");
      out.write("\n");
      out.write("                    let cantTotal = document.getElementById(\"nmbCantTotal\").value;\n");
      out.write("                    let cantPrestada = document.getElementById(\"nmbCantPrestada\").value;\n");
      out.write("\n");
      out.write("                    if (cantTotal < cantPrestada) {\n");
      out.write("                        document.getElementById(\"nmbCantTotal\").classList.add('input-error');\n");
      out.write("                        document.getElementById(\"nmbCantPrestada\").classList.add('input-error');\n");
      out.write("                        alert(\"La cantidad total de herramientas no puede ser menor que la cantidad prestada\");\n");
      out.write("                        return false;\n");
      out.write("                    } else {\n");
      out.write("                        document.getElementById(\"nmbCantTotal\").classList.remove('input-error');\n");
      out.write("                        document.getElementById(\"nmbCantPrestada\").classList.remove('input-error');\n");
      out.write("                        document.getElementById(\"oculto\").value = \"MODIFICAR\";\n");
      out.write("                        document.getElementById(\"seleccionado\").value = codigo;\n");
      out.write("                        return true;\n");
      out.write("                    }\n");
      out.write("\n");
      out.write("                } else {\n");
      out.write("                    alert(\"Por favor llenar espacios marcados\");\n");
      out.write("                    return false;\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            function getByCode(codigo) {\n");
      out.write("                if (document.getElementById(\"txtCodigo\").value !== \"\") {\n");
      out.write("\n");
      out.write("                    document.getElementById(\"txtCodigo\").classList.remove('input-error');\n");
      out.write("                    document.getElementById(\"oculto\").value = \"GETBYCODE\";\n");
      out.write("                    document.getElementById(\"seleccionado\").value = codigo;\n");
      out.write("                    return true;\n");
      out.write("                } else {\n");
      out.write("                    alert(\"Agregar código a buscar\");\n");
      out.write("                    document.getElementById(\"txtCodigo\").classList.add('input-error');\n");
      out.write("                    return false;\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("            function getByDesc(descripcion) {\n");
      out.write("                if (document.getElementById(\"txtDescripcion\").value !== \"\") {\n");
      out.write("                    document.getElementById(\"txtDescripcion\").classList.remove('input-error');\n");
      out.write("                    document.getElementById(\"oculto\").value = \"GETBYDESC\";\n");
      out.write("                    document.getElementById(\"seleccionado\").value = descripcion;\n");
      out.write("                    return true;\n");
      out.write("\n");
      out.write("                } else {\n");
      out.write("                    alert(\"Agregar descripcion(s) a buscar\");\n");
      out.write("                    document.getElementById(\"txtDescripcion\").classList.add('input-error');\n");
      out.write("                    return false;\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("            function limpiar() {\n");
      out.write("                document.getElementById(\"oculto\").value = \"LIMPIAR\";\n");
      out.write("                return true;\n");
      out.write("            }\n");
      out.write("            function eliminar(codigo) {\n");
      out.write("                document.getElementById(\"oculto\").value = \"ELIMINAR\";\n");
      out.write("                document.getElementById(\"eliminado\").value = codigo;\n");
      out.write("                alert(\"Herramienta médica eliminada\");\n");
      out.write("            }\n");
      out.write("            function seleccionar(codigo) {\n");
      out.write("                document.getElementById(\"oculto\").value = \"SELECCIONAR\";\n");
      out.write("                document.getElementById(\"seleccionado\").value = codigo;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("        </script>\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
 if (session.getAttribute("nombreUsuario") != null) {

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
        
      out.write("\n");
      out.write("\n");
      out.write("        <div style=\"text-align: right; margin-right: 30px;\">\n");
      out.write("            Hola ");
      out.print( session.getAttribute("nombreUsuario"));
      out.write("\n");
      out.write("            <br/>\n");
      out.write("            ");
      out.print( DateTimeFormatter.ofPattern("MM-dd-yyyy", Locale.ENGLISH).format(LocalDateTime.now()));
      out.write(" \n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <h1>Mantenimiento de Herramientas Médicas</h1>\n");
      out.write("        <form  method=\"get\" action=\"ServletMantHerramientaMedica\">\n");
      out.write("            <table border=\"1\">\n");
      out.write("                <tr>\n");
      out.write("                    <td>Código</td>\n");
      out.write("                    <td>\n");
      out.write("                        ");
 if (request.getAttribute("codigo") != "") {
      out.write("\n");
      out.write("                        <input type=\"number\" min=\"0\" id=\"txtCodigo\" name=\"codigo\" readonly=\"true\" value=\"");
      out.print(request.getAttribute("codigo"));
      out.write("\"/>\n");
      out.write("                        ");
 } else {
      out.write("\n");
      out.write("                        <input type=\"number\"  min=\"0\" id=\"txtCodigo\" name=\"codigo\" value=\"");
      out.print(request.getAttribute("codigo"));
      out.write("\"/>\n");
      out.write("                        ");
}
      out.write("\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Descripción</td>\n");
      out.write("                    <td>\n");
      out.write("                        <input type=\"text\"  id=\"txtDescripcion\" name=\"descripcion\" value=\"");
      out.print(request.getAttribute("descripcion"));
      out.write("\"/>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <td>Cantidad total</td>\n");
      out.write("                    <td>\n");
      out.write("                        <input type=\"number\"  min=\"0\" id=\"nmbCantTotal\" name=\"cantTotal\" value=\"");
      out.print(request.getAttribute("cantTotal"));
      out.write("\"/>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <td>Cantidad prestada</td>\n");
      out.write("                    <td>\n");
      out.write("                        <input type=\"number\" min=\"0\" id=\"nmbCantPrestada\" name=\"cantPrestada\" value=\"");
      out.print(request.getAttribute("cantPrestada"));
      out.write("\"/>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("\n");
      out.write("\n");
      out.write("            </table>\n");
      out.write("            <br/>\n");
      out.write("            <input type=\"submit\" value=\"Registrar\" onclick=\"return registrar();\"/>\n");
      out.write("            <input type=\"submit\" value=\"Modificar\" onclick=\"return modificar();\"/>\n");
      out.write("            <input type=\"submit\" value=\"Consultar por código\" onclick=\"return getByCode();\"/>\n");
      out.write("            <input type=\"submit\" value=\"Consultar por descripción\" onclick=\"return getByDesc();\"/>\n");
      out.write("            <input type=\"submit\" value=\"Limpiar\" onclick=\" return limpiar();\"/>\n");
      out.write("            <input type =\"hidden\" id=\"oculto\" name=\"accion\"/>\n");
      out.write("            <input type =\"hidden\" id=\"seleccionado\" name=\"seleccionado\"/>\n");
      out.write("            <input type =\"hidden\" id=\"eliminado\" name=\"eliminado\"/>\n");
      out.write("\n");
      out.write("            <hr/>\n");
      out.write("\n");
      out.write("            <table border=\"1\">\n");
      out.write("                <tr>\n");
      out.write("                    <th>Código</th>\n");
      out.write("                    <th>Descripción</th>\n");
      out.write("                    <th>Cantidad total</th>\n");
      out.write("                    <th>Cantidad prestada</th>\n");
      out.write("                    <th>Seleccionar</th>\n");
      out.write("                    <th>Eliminar</th>\n");
      out.write("                </tr>\n");
      out.write("\n");
      out.write("                ");
      out.write("\n");
      out.write("                ");
      out.write("\n");
      out.write("                ");

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

                
      out.write("\n");
      out.write("                <td>\n");
      out.write("                    <input type=\"image\" src=\"img/select.png\"\n");
      out.write("                           width=\"25px\" onclick=\"return seleccionar(");
      out.print( h.getCodigo());
      out.write(")\" />\n");
      out.write("                </td>\n");
      out.write("                <td>\n");
      out.write("                    <input type=\"image\" src=\"img/delete.png\"\n");
      out.write("                           width=\"25px\" onclick=\"return eliminar(");
      out.print( h.getCodigo());
      out.write(")\" />\n");
      out.write("                </td>\n");
      out.write("                ");
  out.println("</tr>");
                    }
                
      out.write("\n");
      out.write("            </table>\n");
      out.write("        </form>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        ");
 } else { 
      out.write("\n");
      out.write("        <p>Sesion invalida, vuelva a logearse</p>\n");
      out.write("        <a href =\"logIn.html\"> Ir al LogIn</a>\n");
      out.write("\n");
      out.write("        ");
 }
      out.write("\n");
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
