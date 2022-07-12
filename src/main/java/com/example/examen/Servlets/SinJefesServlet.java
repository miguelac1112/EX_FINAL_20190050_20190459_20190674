package com.example.examen.Servlets;

import com.example.examen.Beans.Cartelera;
import com.example.examen.Beans.Empleado;
import com.example.examen.Daos.CarteleraDao;
import com.example.examen.Daos.ReporteDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "SinJefesServlet", value = "/SinJefesServlet")
public class SinJefesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ReporteDao reporteDao = new ReporteDao();

        ArrayList<Empleado> empleados = reporteDao.listasinjefe();

        request.setAttribute("listaSinJefe", empleados);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("EmpleadosSinJefe.jsp");
        requestDispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
