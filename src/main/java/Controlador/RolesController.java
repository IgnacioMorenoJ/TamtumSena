package Controlador;

import Models.Roles;
import Models.RolesDAO;
import Models.Usuario;
import Models.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "RolesController", urlPatterns = {"/RolesController"})
public class RolesController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    

    RolesDAO rd = new RolesDAO();
    Roles r = new Roles();
   
    /**
     * @see HttpServlet#HttpServlet() public UsuarioController() { super(); //
     * TODO Auto-generated constructor stub }
     *
     * /**
     *
     */
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
           throws ServletException, IOException { String accion = request.getParameter("accion");
        try {
            if (accion != null) {
                switch (accion) {

                    case "listar":
                        listar(request, response);
                        break;
                      case "abrirForm":
                        abrirForm(request, response);
                        break;
                    case "add":
                        add(request, response);
                        break;
                    /*case "eliminar":
                      Eliminar(request, response);
                        break;
                    case "ver":
                    	ver(request,response);
                    	break;
                    case "edit":
                    	edit(request,response);
                    	break;
                    case "changeEstado":
                    	changeEstado(request,response);
                    	break;*/

                    default:
                        response.sendRedirect("login.jsp");
                }
            } else {
                response.sendRedirect("login.jsp");
            }
        } catch (Exception e) {
            try {
                request.getRequestDispatcher("/mensaje.jsp").forward(request, response);

            } catch (Exception ex) {
                System.out.println("Error" + e.getMessage());
            }
        }

    }

   
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           
        processRequest(request, response);
       
    
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        processRequest(request, response);
    }

    private void listar(HttpServletRequest request, HttpServletResponse response) {
System.out.println("Prueba Rolcon");
        try {
            List role = rd.listarRol();
            request.setAttribute("roler", role);
            request.getRequestDispatcher("Roles.jsp").forward(request, response);
            System.out.println("Roles encontrados");
            
        } catch (Exception e) {
            request.setAttribute("msje", "No se pudo listar los roles" + e.getMessage());
            System.out.println("No se pueden listar los roles Controller" + e.getMessage());
        } finally {
            rd = null;
        }
    }

    private void abrirForm(HttpServletRequest request, HttpServletResponse response) {

        try {
            request.getRequestDispatcher("role-add.jsp").forward(request, response);
            System.out.println("formulario abierto");
        } catch (Exception e) {
            request.setAttribute("msje", "No se pudo abrir el formulario" + e.getMessage());
            System.out.println("No se pudo abrir el formulario" + e.getMessage());
        } finally {

        }
    }

    private void add(HttpServletRequest request, HttpServletResponse response) {

        if (request.getParameter("id") != null) {
            r.setDescripcion(request.getParameter("descripcion"));
           

        }
        /*if (request.getParameter("chkEstado") != null) {
            u.setEstado(true);
        } else {
            u.setEstado(false);
        }*/
        try {
            rd.registrar(r);
            //request.getRequestDispatcher("views/Usuario.jsp").forward(request, response);
            response.sendRedirect("RolesController?accion=listar");
            System.out.println("Rol Registrado");
        } catch (Exception e) {
            request.setAttribute("msje", "No se pudo registrar el rol " + e.getMessage());
            System.out.println("No se pudo registrar el rol " + e.getMessage());
        } finally {

        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {

        if (request.getParameter("id") != null) {
            r.setId(Integer.parseInt(request.getParameter("id")));
        }
        try {
            rd.eliminar(r.getId());
            //request.getRequestDispatcher("views/edit.jsp").forward(request, response);
            response.sendRedirect("RolesController?accion=listar");
            System.out.println("Rol Eliminado");
        } catch (Exception e) {
            request.setAttribute("msje", "No se pudo eliminar el registro" + e.getMessage());
            System.out.println("No se pudo eliminar el registro" + e.getMessage());
        } finally {

        }
    }

    private void edit(HttpServletRequest request, HttpServletResponse response) {

        if (request.getParameter("id") != null ) {
            r.setDescripcion(request.getParameter("descripcion"));
              
        try {
            rd.actualizar(r);
            response.sendRedirect("RolesController?accion=listar");

        } catch (Exception e) {
            System.out.println("Rol NO actualizado " + e.getMessage());
        }

    }
       
    }

}