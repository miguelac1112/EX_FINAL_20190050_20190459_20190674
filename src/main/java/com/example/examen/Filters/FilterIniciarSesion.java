package com.example.examen.Filters;

import com.example.examen.Beans.Empleado;
import com.example.examen.Daos.EmpleadoDao;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "FilterIniciarSesion")
public class FilterIniciarSesion implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        EmpleadoDao empleadoDao = new EmpleadoDao();
        Empleado empleado = (Empleado) req.getSession().getAttribute("usuarioSesion");
        String logout = req.getParameter("finish");
        if (empleado==null || empleado.getIdEmpleado()==0 || logout.equals("yes")) {
            chain.doFilter(request, response);
        } else {
            if(empleadoDao.obtenerRol(empleado.getDni()).equals("vendedor")){
                resp.sendRedirect(req.getContextPath()+"/VendedorServlet");
            }else if(empleadoDao.obtenerRol(empleado.getDni()).equals("gestor")){
                resp.sendRedirect(req.getContextPath()+"/GestorServlet");
            }else{
                resp.sendRedirect(req.getContextPath()+"/AdminServlet");
            }

        }
    }
}
