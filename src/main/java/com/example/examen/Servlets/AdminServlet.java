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
        String action = request.getParameter("action") == null ? "listar" : request.getParameter("action");
        ReporteDao reporteDao = new ReporteDao();
        HttpSession session= request.getSession();
        RequestDispatcher view;
        switch (action){
            case "listar":
                session.setAttribute("sinjefe", reporteDao.obtenernumeroSinjefe());
                view = request.getRequestDispatcher("Reportes.jsp");
                view.forward(request,response);
                break;
        }



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
