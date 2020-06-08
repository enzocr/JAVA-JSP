/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import negocio.bo.HerramientaMedicaBo;
import negocio.clases.HerramientaMedica;

/**
 *
 * @author Enzo Quartino Zamora
 * <github.com/enzocr || email: enzoquartino@gmail.com>
 */
public class ServletMantHerramientaMedica extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Mantenimiento de Herramientas Médicas</title>");
            out.println("</head>");
            out.println("<body>");

            HerramientaMedicaBo herrBo = new HerramientaMedicaBo();
            HerramientaMedica obj;
            String accion = request.getParameter("accion");

            switch (accion) {
                case "REGISTRAR":
                    obj = new HerramientaMedica(
                            Integer.parseInt(request.getParameter("codigo")),
                            request.getParameter("descripcion"),
                            Integer.parseInt(request.getParameter("cantTotal")),
                            Integer.parseInt(request.getParameter("cantPrestada"))
                    );

                    switch (herrBo.insert(obj)) {
                        case 0:
                            out.print("<h1>Agregado</h>");
                            break;
                        case 1:
                            out.print("<h1>No se pudo conectar a la BD </h>");
                            break;
                        case 2:
                            out.print("<h1>Profesor con cédula indicada ya existe</h>");
                            break;
                        case 3:
                            out.print("<h1>Ocurrió un error inesperado</h>");
                            break;
                    }
                    break;
                case "SELECCIONAR":
                    obj = herrBo.getByCode(Integer.parseInt(request.getParameter("seleccionado")));
                    request.setAttribute("codigo", obj.getCodigo());
                    request.setAttribute("descripcion", obj.getDescripcion());
                    request.setAttribute("cantTotal", obj.getCantTotal());
                    request.setAttribute("cantPrestada", obj.getCantidadPrestado());
                    request.getRequestDispatcher("mantHerramientaMedica.jsp").forward(request, response);
                    break;
                case "ELIMINAR":
                    obj = herrBo.getByCode(Integer.parseInt(request.getParameter("eliminado")));

                    switch (herrBo.delete(obj)) {
                        case 0:
                            out.print("<h1>NO eliminado</h>");
                            break;
                        case 1:
                            out.print("<h1>ELIMINADO</h>");
                            break;
                        case 2:
                            out.print("<h1>NO hubo conexion con base de datos</h>");
                            break;
                        case 3:
                            out.print("<h1>Error inesperado</h>");
                            break;
                        case 4:
                            out.print("<h1>Tiene registros asociados</h>");
                            break;
                    }
                    break;
                case "LIMPIAR":
                    response.sendRedirect("mantHerramientaMedica.jsp");
                    break;
                case "MODIFICAR":
                    obj = new HerramientaMedica(
                            Integer.parseInt(request.getParameter("codigo")),
                            request.getParameter("descripcion"),
                            Integer.parseInt(request.getParameter("cantTotal")),
                            Integer.parseInt(request.getParameter("cantPrestada"))
                    );

                    switch (herrBo.update(obj)) {
                        case 0:
                            out.print("<h1>Modificado</h>");
                            break;
                        case 1:
                            out.print("<h1>No se pudo conectar a la BD</h>");
                            break;
                        case 2:
                            out.println("<h1>No se permite duplicacion de informacion</h>");
                            break;
                        case 3:
                            out.println("<h1>Error inesperado</h>");
                            break;
                    }
                    break;

                case "GETBYCODE":
                    String codigo = request.getParameter("codigo");
                    response.sendRedirect("mantHerramientaMedica.jsp?getbycode=" + codigo);
                    break;
                case "GETBYDESC":
                    String descripcion = request.getParameter("descripcion");
                    response.sendRedirect("mantHerramientaMedica.jsp?getbydesc=" + descripcion);
                    break;
            }

            out.println("<br/>");
            out.println("<a href=\"mantHerramientaMedica.jsp\">Volver</a>");
            out.println("</body>");
            out.println("</html>");

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
