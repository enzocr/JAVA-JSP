/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import negocio.bo.PacienteBo;
import negocio.clases.Paciente;
import utilities.SwingUtilities;

/**
 *
 * @author Enzo Quartino Zamora
 * <github.com/enzocr || email: enzoquartino@gmail.com>
 */
public class ServletMantPaciente extends HttpServlet {

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
            out.println("<title>Mantenimiento de Doctores</title>");
            out.println("</head>");
            out.println("<body>");

            PacienteBo pacBo = new PacienteBo();
            Paciente obj;
            String accion = request.getParameter("accion");
            String fecha = request.getParameter("fechaNacimiento");
            switch (accion) {
                case "REGISTRAR":
                    obj = new Paciente(
                            Integer.parseInt(request.getParameter("numAsegurado")),
                            request.getParameter("nombre"),
                            request.getParameter("direccion"),
                            SwingUtilities.stringToDate(fecha),
                            request.getParameter("email"),
                            Integer.parseInt(request.getParameter("telefono")),
                            request.getParameter("profesion"));

                    switch (pacBo.insert(obj)) {
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
                    obj = pacBo.getById(Integer.parseInt(request.getParameter("seleccionado")));
                    request.setAttribute("numAsegurado", obj.getNumAsegurado());
                    request.setAttribute("nombre", obj.getNombre());
                    request.setAttribute("direccion", obj.getDireccion());
                    request.setAttribute("fechaNacimiento", obj.getFechaNacimiento());
                    request.setAttribute("email", obj.getEmail());
                    request.setAttribute("telefono", obj.getTelefono());
                    request.setAttribute("profesion", obj.getProfesion());
                    request.getRequestDispatcher("mantPaciente.jsp").forward(request, response);
                    break;
                case "ELIMINAR":
                    obj = pacBo.getById(Integer.parseInt(request.getParameter("eliminado")));

                    switch (pacBo.delete(obj)) {
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
                    response.sendRedirect("mantPaciente.jsp");
                    break;
                case "MODIFICAR":
                    obj = new Paciente(
                            Integer.parseInt(request.getParameter("numAsegurado")),
                            request.getParameter("nombre"),
                            request.getParameter("direccion"),
                            SwingUtilities.stringToDate(fecha),
                            request.getParameter("email"),
                            Integer.parseInt(request.getParameter("telefono")),
                            request.getParameter("profesion"));

                    switch (pacBo.update(obj)) {
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

                case "GETBYID":
                    String numAsegurado = request.getParameter("numAsegurado");
                    response.sendRedirect("mantPaciente.jsp?getbyid=" + numAsegurado);
                    break;
                case "GETBYNAME":
                    String nombre = request.getParameter("nombre");
                    response.sendRedirect("mantPaciente.jsp?getbyname=" + nombre);
                    break;
            }

            out.println("<br/>");
            out.println("<a href=\"mantPaciente.jsp\">Volver</a>");
            out.println("</body>");
            out.println("</html>");
        } catch (ParseException ex) {
            Logger.getLogger(ServletMantPaciente.class.getName()).log(Level.SEVERE, null, ex);
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
