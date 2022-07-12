package com.example.examen.Servlets;

import com.example.examen.Beans.Cartelera;
import com.example.examen.Beans.Cine;
import com.example.examen.Beans.Pelicula;
import com.example.examen.Daos.CarteleraDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "CrearFuncionServlet", value = "/CrearFuncionServlet")
public class CrearFuncionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("a") == null ? "listar" : request.getParameter("a");
        CarteleraDao crearCartelera = new CarteleraDao();

        switch (action) {
            case "listar" -> {
                ArrayList<Pelicula> listaPeliculas = crearCartelera.listaPelicula();
                ArrayList<Cine> listaCines = crearCartelera.listaCines();

                request.setAttribute("listaPeliculas",listaPeliculas);
                request.setAttribute("listaCines",listaCines);

                RequestDispatcher view =request.getRequestDispatcher("CrearFuncion.jsp");
                view.forward(request,response);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String action = request.getParameter("a") == null ? "listar" : request.getParameter("a");
        CarteleraDao carteleraDao = new CarteleraDao();
        HttpSession session = request.getSession();

        switch (action){
            case "guardar" ->{
                String nombreid = request.getParameter("funcion");
                String cineid = request.getParameter("cine");
                String tresd = request.getParameter("tresd");
                String idioma = request.getParameter("idioma");
                String fecha = request.getParameter("tiempo_inicio");
                int subtitulada;
                int doblada;

                if(idioma.equals("0")){
                    subtitulada=1;
                    doblada=0;
                }else{
                    subtitulada=0;
                    doblada=1;
                }
                carteleraDao.anadirCartelera(Integer.parseInt(nombreid),Integer.parseInt(cineid),Integer.parseInt(tresd),doblada,subtitulada,fecha);
                response.sendRedirect(request.getContextPath() + "/Cartelera.jsp");
            }
        }
    }
}
