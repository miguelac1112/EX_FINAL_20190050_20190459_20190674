package com.example.examen.Filters;

import com.example.examen.Beans.Empleado;
import com.example.examen.Daos.EmpleadoDao;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "FilterGestor")
public class FilterGestor implements Filter {
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
        if (empleado != null && empleado.getIdEmpleado()!=0 && empleadoDao.obtenerRol(empleado.getDni()).equals("gestor")) {
            resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
            resp.setHeader("Pragma", "no-cache"); // HTTP 1.0.
            resp.setDateHeader("Expires", 0);
            chain.doFilter(request, response);
        } else {
            resp.sendRedirect(req.getContextPath());
        }
    }
}
