package com.example.examen.Servlets;

import com.example.examen.Beans.Empleado;
import com.example.examen.Daos.EmpleadoDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;


@WebServlet(name = "LogServlet",urlPatterns = {"/LogServlet",""})
public class LogServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher;
        String logout = request.getParameter("finish");
        if(logout == null){
            requestDispatcher = request.getRequestDispatcher("Login.jsp");
            requestDispatcher.forward(request,response);

        }else{
            if(logout.equals("yes")){

                HttpSession session = request.getSession();
                session.invalidate();
                response.sendRedirect(request.getContextPath() + "/LogServlet");

            }else{

                requestDispatcher = request.getRequestDispatcher("Login.jsp");
                requestDispatcher.forward(request,response);

            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EmpleadoDao empleadoDao = new EmpleadoDao();

        String dni = request.getParameter("dni");
        Empleado empleado = empleadoDao.buscarEmpleado(dni);
        int contrUsuario = Integer.parseInt(request.getParameter("pass"));
        int contr = empleadoDao.obtenerpasword(dni);
        HttpSession session = request.getSession();


        if(empleado !=null && contr==contrUsuario){

            session.setAttribute("usuarioSesion",empleado);
            session.setAttribute("rol",empleadoDao.obtenerRol(dni));
            if(empleadoDao.obtenerRol(dni).equals("vendedor")){
                response.sendRedirect(request.getContextPath()+"/VendedorServlet");
            }else if(empleadoDao.obtenerRol(dni).equals("gestor")){
                response.sendRedirect(request.getContextPath()+"/GestorServlet");
            }else{
                response.sendRedirect(request.getContextPath()+"/AdminServlet");
            }
        }else{

            session.setAttribute("indicador","error");
            response.sendRedirect(request.getContextPath()+"/LogServlet");
        }
    }
}
