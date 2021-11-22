package Controlador;

import Models.Usuario;
import Models.UsuarioDAO;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

@WebServlet(name = "UsuarioController", urlPatterns = {"/UsuarioController"})
public class UsuarioController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    UsuarioDAO ud = new UsuarioDAO();
    Usuario u = new Usuario();

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
            throws ServletException, IOException {
        String accion = request.getParameter("accion");

        //Crear la sesión
        HttpSession session = request.getSession();
        try {
            if (accion != null) {
                switch (accion) {
                    case "abrirLogin":
                        abrirLogin(request, response);
                        break;
                    case "login":
                        u.setCorreo(request.getParameter("correo"));
                        u.setClave(request.getParameter("password"));
                        try {
                            u = ud.validarUsuario(u.getCorreo(), u.getClave());
                            if (u.getApellidos() != null && u.getEstado()== true) {
                                System.out.println("El DAO encontró el usuario y está activo");
                                session.setAttribute("us", u);
                                response.sendRedirect("UsuarioController?accion=listar");
                            } else if (u.getApellidos() != null && u.getEstado() == false) {
                                System.out.println("El DAO encontró el usuario y está inactivo");
                                request.getRequestDispatcher("UsuarioController?accion=abrirLogin&msn=Usuario Inactivo consulte al administrador").forward(request, response);
                            } else {
                                System.out.println("El DAO NO encontró el usuario");
                                request.getRequestDispatcher("UsuarioController?accion=abrirLogin&msn=Datos de acceso incorrecto").forward(request, response);
                            }
                        } catch (Exception e) {
                            System.out.println("Error" + e.getMessage());
                        }
                        break;
                    case "logout":
                        session.removeAttribute("user");
                        session.invalidate();
                        request.getRequestDispatcher("UsuarioController?accion=abrirLogin&msn=Sesión Finalizada").forward(request, response);

                        break;
                    case "abrirchangepass":
                        abrirchangepass(request, response);
                        break;

                    case "changePassword":
                        changePassword(request, response);
                        break;

                    case "verPerfil":
                        verPerfil(request, response);
                        break;
                                                	
                    case "listar":
                        listar(request, response);
                        break;
                    case "abrirForm":
                    	abrirForm(request,response);
                    	break;
                    case "add":
                    	add(request,response);
                    	break;
                    case "eliminar":
                    	eliminar(request,response);
                    	break;
                    case "ver":
                    	ver(request,response);
                    break;
                    case "edit":
                    	edit(request,response);
                    break;
                        

                      /*  try {
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
                                    /* case "eliminar":
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

    private void abrirLogin(HttpServletRequest request, HttpServletResponse response) {

        try {

            request.getRequestDispatcher("login.jsp").forward(request, response);
            System.out.println("Login abierto");
        } catch (Exception e) {
            request.setAttribute("msje", "No se pudo abrir el login" + e.getMessage());
            System.out.println("No se pudo abrir el login" + e.getMessage());
        } finally {

        }
    }

    private void abrirchangepass(HttpServletRequest request, HttpServletResponse response) {

        try {

            request.getRequestDispatcher("changePass.jsp").forward(request, response);
            System.out.println("Cambio Password abierto");
        } catch (Exception e) {
            request.setAttribute("msje", "No se pudo abrir el Cambio Password" + e.getMessage());
            System.out.println("No se pudo abrir el Cambio Password" + e.getMessage());
        } finally {

        }
    }

    private void verPerfil(HttpServletRequest request, HttpServletResponse response) {

        try {

            request.getRequestDispatcher("usuario-perfil.jsp").forward(request, response);
            System.out.println("Perfil abierto");
        } catch (Exception e) {
            request.setAttribute("msje", "No se pudo abrir el perfil" + e.getMessage());
            System.out.println("No se pudo abrir el perfil" + e.getMessage());
        } finally {

        }
    }

    private void listar(HttpServletRequest request, HttpServletResponse response) {

        try {
            List usu = ud.listar();
            request.setAttribute("user", usu);
            request.getRequestDispatcher("Usuario.jsp").forward(request, response);
            System.out.println("Usuarios encontrados");
        } catch (Exception e) {
            request.setAttribute("msje", "No se pudo listar los usuarios" + e.getMessage());
            System.out.println("No se pueden listar los usuarios" + e.getMessage());
        } finally {
            ud = null;
        }
    }

    private void abrirForm(HttpServletRequest request, HttpServletResponse response) {

        try {
            request.getRequestDispatcher("usuario-add.jsp").forward(request, response);
            System.out.println("formulario abierto");
        } catch (Exception e) {
            request.setAttribute("msje", "No se pudo abrir el formulario" + e.getMessage());
            System.out.println("No se pudo abrir el formulario" + e.getMessage());
        } finally {

        }
    }

    private void add(HttpServletRequest request, HttpServletResponse response) {

        System.out.println("entro a la funcion add");
        if (request.getParameter("nombre") != null) {
            u.setNombre(request.getParameter("nombre"));
            u.setApellidos(request.getParameter("apellido"));
            u.setDocumento(request.getParameter("documento"));
            u.setCorreo(request.getParameter("correo"));
            u.setFechaDeNacimiento(request.getParameter("fechanacim"));
            u.setTelefono(request.getParameter("telefono"));
            u.setClave(request.getParameter("clave"));

        }
        /*if (request.getParameter("chkEstado") != null) {
            u.setEstado(true);
        } else {
            u.setEstado(false);
        }*/
        System.out.println(u.getApellidos());
        System.out.println(u.getCorreo());
        try {
            ud.registrar(u);
            //request.getRequestDispatcher("views/Usuario.jsp").forward(request, response);

            System.out.println("Usuario Registrado");
        } catch (Exception e) {
            request.setAttribute("msje", "No se pudo registrar el usuario controller " + e.getMessage());
            System.out.println("No se pudo registrar el usuario controller " + e.getMessage());
        } finally {

        }
    }

    private void eliminar(HttpServletRequest request, HttpServletResponse response) {

        if (request.getParameter("id") != null) {
            u.setId(Integer.parseInt(request.getParameter("id")));
        }
        try {
            ud.eliminar(u.getId());
            //request.getRequestDispatcher("views/edit.jsp").forward(request, response);
            response.sendRedirect("usuarioController?accion=listar");
            System.out.println("Usuario Eliminado");
        } catch (Exception e) {
            request.setAttribute("msje", "No se pudo eliminar el registro" + e.getMessage());
            System.out.println("No se pudo eliminar el registro" + e.getMessage());
        } finally {

        }
    }

    private void ver(HttpServletRequest request, HttpServletResponse response) {

        int id = Integer.parseInt(request.getParameter("id"));

        try {
            this.obtenerRoles(request);
            u = ud.consultaporId(id);
            request.setAttribute("user", u);
            request.getRequestDispatcher("usuario-edit.jsp").forward(request, response);
            System.out.println("Usuario encontrado " + id);

        } catch (Exception e) {
            System.out.println("Usuario No encontrado " + e.getMessage());
        } finally {

        }
    }

    private void edit(HttpServletRequest request, HttpServletResponse response) {

        if (request.getParameter("id") != null && request.getParameter("nombre") != null) {
            u.setId(Integer.parseInt(request.getParameter("id")));
            u.setDocumento(request.getParameter("documento"));
            u.setNombre(request.getParameter("nombre"));
            u.setApellidos(request.getParameter("apellido"));
            u.setCorreo(request.getParameter("correo"));
            u.setTelefono(request.getParameter("telefono"));
            u.setClave(request.getParameter("clave"));

        }
        if (request.getParameter("chkEstado") != null) {
            u.setEstado(true);
        } else {
            u.setEstado(false);
        }
        try {
            ud.actualizar(u);
            response.sendRedirect("UsuarioController?accion=listar");

        } catch (Exception e) {
            System.out.println("Usuario NO actualizado " + e.getMessage());
        }

    }

    private void changeEstado(HttpServletRequest request, HttpServletResponse response) {
        try {
            u.setId(Integer.parseInt(request.getParameter("id")));
            u.setEstado(Boolean.parseBoolean(request.getParameter("es")));

            ud.cambiarEstado(u);
            response.sendRedirect("usuarioController?accion=listar");
        } catch (Exception e) {
            System.out.println("Estado NO actualizado " + e.getMessage());
        }
    }

    private void obtenerRoles(HttpServletRequest request) {
        UsuarioDAO r = new UsuarioDAO();
        List<Usuario> u = null;
        try {
            u = r.listar();
            request.setAttribute("usuarios", u);
        } catch (Exception e) {
            request.setAttribute("msje", "No se pudo cargar los cargos :( " + e.getMessage());
        } finally {

        }
    }

    private void changePassword(HttpServletRequest request, HttpServletResponse response) {
	
	if(request.getParameter("id")!=null &&  request.getParameter("passnew")!=null) {
		u.setId(Integer.parseInt(request.getParameter("id")));
    	u.setClave(request.getParameter("passnew"));
	}
	try {
		ud.changePassword(u);
		response.sendRedirect("UsuarioController?accion=logout");
		
		
	}catch(Exception e) {
		System.out.println("Usuario NO actualizado "+e.getMessage());
	}
	
}

private String saveFile(Part part, File pathUploads) {
	String pathAbsolute = "";
	
	try {
		
		Path path = Paths.get(part.getSubmittedFileName());
		String fileName = path.getFileName().toString();
		System.out.println(fileName);
		InputStream input = part.getInputStream();
		
		if(input != null) {
			File file = new File(pathUploads, fileName);
			pathAbsolute = file.getAbsolutePath();
			Files.copy(input, file.toPath());
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	return pathAbsolute;
}

private boolean isExtension(String fileName, String[] extensions) {
	for(String et : extensions) {
		if(fileName.toLowerCase().endsWith(et)) {
			return true;
		}
	}
	
	return false;
    
}    
}
