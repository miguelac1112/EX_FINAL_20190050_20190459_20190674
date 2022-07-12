package com.example.examen.Servlets;

import com.example.examen.Daos.ReporteDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AdminServlet", value = "/AdminServlet")
public class AdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ReporteDao reporteDao = new ReporteDao();
        RequestDispatcher view;
                request.setAttribute("sinjefe", reporteDao.obtenernumeroSinjefe());
                request.setAttribute("tresd",reporteDao.obtenernumero3d());
                request.setAttribute("salario",reporteDao.obtenerempleadosSalario());
                request.setAttribute("cines",reporteDao.obtenerCadena());
                view = request.getRequestDispatcher("Reportes.jsp");
                view.forward(request,response);



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
