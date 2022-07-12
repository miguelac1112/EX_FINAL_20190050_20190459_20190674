package com.example.examen.Servlets;

import com.example.examen.Beans.Cartelera;
import com.example.examen.Beans.Empleado;
import com.example.examen.Daos.CarteleraDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "GestorServlet", value = "/GestorServlet")
public class GestorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("a") == null ? "listar" : request.getParameter("a");
        CarteleraDao carteleraDao = new CarteleraDao();
        Empleado empleado = (Empleado) request.getSession().getAttribute("usuarioSesion");
        switch (action){
            case "listar" ->{
                ArrayList<Cartelera> carteleras = carteleraDao.listarGestor();
                request.setAttribute("cartelera", carteleras);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("Cartelera.jsp");
                requestDispatcher.forward(request,response);
            }
            case "borrar" ->{
                String id = request.getParameter("id");
                carteleraDao.eliminarCartelera(Integer.parseInt(id));
                response.sendRedirect(request.getContextPath() + "/GestorServlet");
            }
            case "editar" -> {

            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
