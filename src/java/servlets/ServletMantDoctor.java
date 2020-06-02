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
import negocio.bo.DoctorBo;
import negocio.clases.Doctor;

/**
 *
 * @author Enzo Quartino Zamora
 * <github.com/enzocr || email: enzoquartino@gmail.com>
 */
public class ServletMantDoctor extends HttpServlet {

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

            DoctorBo docBo = new DoctorBo();
            Doctor obj;
            String accion = request.getParameter("accion");

            switch (accion) {
                case "REGISTRAR":
                    obj = new Doctor(
                            Integer.parseInt(request.getParameter("cedula")),
                            request.getParameter("nombre"),
                            request.getParameter("apellidos"),
                            request.getParameter("especialidad"),
                            new Double(request.getParameter("salario")),
                            request.getParameter("direccion"),
                            Integer.parseInt(request.getParameter("telefono"))
                    );

                    switch (docBo.insert(obj)) {
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
                    obj = docBo.getById(Integer.parseInt(request.getParameter("seleccionado")));
                    request.setAttribute("cedula", obj.getCedula());
                    request.setAttribute("nombre", obj.getNombre());
                    request.setAttribute("apellidos", obj.getApellido());
                    request.setAttribute("especialidad", obj.getEspecialidad());
                    request.setAttribute("salario", obj.getSalario());
                    request.setAttribute("direccion", obj.getDireccion());
                    request.setAttribute("telefono", obj.getTelefono());
                    request.getRequestDispatcher("mantDoctor.jsp").forward(request, response);
                    break;
                case "ELIMINAR":
                    obj = docBo.getById(Integer.parseInt(request.getParameter("eliminado")));

                    switch (docBo.delete(obj)) {
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
                    request.setAttribute("cedula", "");
                    request.setAttribute("nombre", "");
                    request.setAttribute("apellidos", "");
                    request.setAttribute("especialidad", "");
                    request.setAttribute("salario", "");
                    request.setAttribute("direccion", "");
                    request.setAttribute("telefono", "");
                    request.getRequestDispatcher("mantDoctor.jsp").forward(request, response);
                    break;
                case "MODIFICAR":
                    obj = new Doctor(
                            Integer.parseInt(request.getParameter("cedula")),
                            request.getParameter("nombre"),
                            request.getParameter("apellidos"),
                            request.getParameter("especialidad"),
                            new Double(request.getParameter("salario")),
                            request.getParameter("direccion"),
                            Integer.parseInt(request.getParameter("telefono"))
                    );

                    switch (docBo.update(obj)) {
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
                    docBo.getById(Integer.parseInt(request.getParameter("cedula")));

                    break;
                case "GETBYNAME":
                    docBo.getByName(request.getParameter("nombre"));
                    break;
            }

            out.println("<br/>");
            out.println("<a href=\"mantDoctor.jsp\">Volver</a>");
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
