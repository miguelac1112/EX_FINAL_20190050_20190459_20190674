package com.example.examen.Servlets;

import com.example.examen.Beans.Cartelera;
import com.example.examen.Beans.Empleado;
import com.example.examen.Daos.CarteleraDao;
import com.mysql.cj.Session;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "VendedorServlet", value = "/VendedorServlet")
public class VendedorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CarteleraDao carteleraDao = new CarteleraDao();
        Empleado empleado = (Empleado) request.getSession().getAttribute("usuarioSesion");
                ArrayList<Cartelera> carteleras = carteleraDao.listar(empleado.getDni());

                request.setAttribute("listaCarteleras", carteleras);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("CarteleraVendedor.jsp");
                requestDispatcher.forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
