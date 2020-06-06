package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.Locale;
import java.text.SimpleDateFormat;
import negocio.bo.DoctorBo;
import negocio.clases.Doctor;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public final class mantDoctor_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

 List<Doctor> list = new ArrayList<>(); 
 DoctorBo docBo = new DoctorBo();
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
      out.write("\n");
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
      out.write("                    if (isNaN(document.getElementById(\"txtCedula\"))) {\n");
      out.write("                        alert(\"hola\");\n");
      out.write("                    } else {\n");
      out.write("                        document.getElementById(\"oculto\").value = \"REGISTRAR\";\n");
      out.write("                        return true;\n");
      out.write("                    }\n");
      out.write("\n");
      out.write("                } else {\n");
      out.write("                    alert(\"Por favor llenar espacios marcados\");\n");
      out.write("                    return false;\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("            function modificar(cedula) {\n");
      out.write("                if (validarDatos()) {\n");
      out.write("                    alert(\"Doctor modificado\");\n");
      out.write("                    document.getElementById(\"oculto\").value = \"MODIFICAR\";\n");
      out.write("                    document.getElementById(\"seleccionado\").value = cedula;\n");
      out.write("                    return true;\n");
      out.write("                } else {\n");
      out.write("                    alert(\"Por favor llenar espacios marcados\");\n");
      out.write("                    return false;\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            function getById(cedula) {\n");
      out.write("                if (document.getElementById(\"txtCedula\").value !== \"\") {\n");
      out.write("                    document.getElementById(\"txtCedula\").classList.remove('input-error');\n");
      out.write("                    document.getElementById(\"oculto\").value = \"GETBYID\";\n");
      out.write("                    document.getElementById(\"seleccionado\").value = cedula;\n");
      out.write("                    return true;\n");
      out.write("                } else {\n");
      out.write("                    alert(\"Agregar cédula a buscar\");\n");
      out.write("                    document.getElementById(\"txtCedula\").classList.add('input-error');\n");
      out.write("                    return false;\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("            function getByName(name) {\n");
      out.write("                if (document.getElementById(\"txtNombre\").value !== \"\") {\n");
      out.write("                    document.getElementById(\"txtNombre\").classList.remove('input-error');\n");
      out.write("                    document.getElementById(\"oculto\").value = \"GETBYNAME\";\n");
      out.write("                    document.getElementById(\"seleccionado\").value = name;\n");
      out.write("                    return true;\n");
      out.write("                } else {\n");
      out.write("                    document.getElementById(\"txtNombre\").classList.add('input-error');\n");
      out.write("                    alert(\"Agregar nombre(s) a buscar\");\n");
      out.write("                    return false;\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("            function limpiar() {\n");
      out.write("                document.getElementById(\"oculto\").value = \"LIMPIAR\";\n");
      out.write("                return true;\n");
      out.write("            }\n");
      out.write("            function eliminar(cedula) {\n");
      out.write("                document.getElementById(\"oculto\").value = \"ELIMINAR\";\n");
      out.write("                document.getElementById(\"eliminado\").value = cedula;\n");
      out.write("                alert(\"Doctor eliminado\");\n");
      out.write("            }\n");
      out.write("            function seleccionar(cedula) {\n");
      out.write("                document.getElementById(\"oculto\").value = \"SELECCIONAR\";\n");
      out.write("                document.getElementById(\"seleccionado\").value = cedula;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("        </script>\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
 if (session.getAttribute("nombreUsuario") != null) {

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
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <h1>Mantenimiento de Doctores</h1>\n");
      out.write("        <form  method=\"get\" action=\"ServletMantDoctor\">\n");
      out.write("            <table border=\"1\">\n");
      out.write("                <tr>\n");
      out.write("                    <td>Cédula</td>\n");
      out.write("                    <td>\n");
      out.write("                        ");
 if (request.getAttribute("cedula") != "") {
      out.write("\n");
      out.write("                        <input type=\"text\" id=\"txtCedula\" name=\"cedula\" readonly=\"true\" value=\"");
      out.print(request.getAttribute("cedula"));
      out.write("\"/>\n");
      out.write("                        ");
 } else {
      out.write("\n");
      out.write("                        <input type=\"text\" id=\"txtCedula\" name=\"cedula\" value=\"");
      out.print(request.getAttribute("cedula"));
      out.write("\"/>\n");
      out.write("                        ");
}
      out.write("\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Nombre</td>\n");
      out.write("                    <td>\n");
      out.write("                        <input type=\"text\" id=\"txtNombre\" name=\"nombre\" value=\"");
      out.print(request.getAttribute("nombre"));
      out.write("\"/>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Apellidos</td>\n");
      out.write("                    <td>\n");
      out.write("                        <input type=\"text\" id=\"txtApellidos\" name=\"apellidos\" value=\"");
      out.print(request.getAttribute("apellidos"));
      out.write("\"/>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Especialidad</td>\n");
      out.write("                    <td>\n");
      out.write("                        <input type=\"text\" id=\"txtEspecialidad\" name=\"especialidad\" value=\"");
      out.print(request.getAttribute("especialidad"));
      out.write("\"/>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Salario</td>\n");
      out.write("                    <td>\n");
      out.write("                        <input type=\"number\" step=\"0.01\" id=\"txtSalario\" name=\"salario\" value=\"");
      out.print(request.getAttribute("salario"));
      out.write("\"/>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Direccion</td>\n");
      out.write("                    <td>\n");
      out.write("                        <input type=\"text\" id=\"txtDireccion\" name=\"direccion\" value=\"");
      out.print(request.getAttribute("direccion"));
      out.write("\"/>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Teléfono</td>\n");
      out.write("                    <td>\n");
      out.write("                        <input type=\"number\" id=\"telefono\" name=\"telefono\" value=\"");
      out.print(request.getAttribute("telefono"));
      out.write("\"/>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("            </table>\n");
      out.write("            <br/>\n");
      out.write("            <input type=\"submit\" value=\"Registrar\" onclick=\"return registrar();\"/>\n");
      out.write("            <input type=\"submit\" value=\"Modificar\" onclick=\"return modificar();\"/>\n");
      out.write("            <input type=\"submit\" value=\"Consultar por cédula\" onclick=\"return getById();\"/>\n");
      out.write("            <input type=\"submit\" value=\"Consultar por nombre\" onclick=\"return getByName();\"/>\n");
      out.write("            <input type=\"submit\" value=\"Limpiar\" onclick=\" return limpiar();\"/>\n");
      out.write("            <input type =\"hidden\" id=\"oculto\" name=\"accion\"/>\n");
      out.write("            <input type =\"hidden\" id=\"seleccionado\" name=\"seleccionado\"/>\n");
      out.write("            <input type =\"hidden\" id=\"eliminado\" name=\"eliminado\"/>\n");
      out.write("\n");
      out.write("            <hr/>\n");
      out.write("\n");
      out.write("            <table border=\"1\">\n");
      out.write("                <tr>\n");
      out.write("                    <th>Cédula</th>\n");
      out.write("                    <th>Nombre</th>\n");
      out.write("                    <th>Apellidos</th>\n");
      out.write("                    <th>Especialidad</th>\n");
      out.write("                    <th>Salario</th>\n");
      out.write("                    <th>Direccion</th>\n");
      out.write("                    <th>Teléfono</th>\n");
      out.write("                    <th>Seleccionar</th>\n");
      out.write("                    <th>Eliminar</th>\n");
      out.write("                </tr>\n");
      out.write("\n");
      out.write("                ");
      out.write("\n");
      out.write("                ");
      out.write("\n");
      out.write("                ");

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

                
      out.write("\n");
      out.write("                <td>\n");
      out.write("                    <input type=\"image\" src=\"img/select.png\"\n");
      out.write("                           width=\"25px\" onclick=\"return seleccionar(");
      out.print( doc.getCedula());
      out.write(")\" />\n");
      out.write("                </td>\n");
      out.write("                <td>\n");
      out.write("                    <input type=\"image\" src=\"img/delete.png\"\n");
      out.write("                           width=\"25px\" onclick=\"return eliminar(");
      out.print( doc.getCedula());
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
