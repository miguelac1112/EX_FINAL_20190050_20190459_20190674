<%@ page import="com.example.examen.Beans.Cartelera" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%ArrayList<Cartelera> carteleras = (ArrayList<Cartelera>) request.getAttribute("cartelera");%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Cartelera</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Font Awesome icons (free version)-->
        <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
        <!-- Google fonts-->
        <link href="https://fonts.googleapis.com/css?family=Montserrat:500,700" rel="stylesheet" type="text/css" />
        <link href="https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700" rel="stylesheet" type="text/css" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="css/styles.css" rel="stylesheet" />
    </head>
    <body id="page-top">
        <nav class="navbar navbar-expand-lg navbar-dark fixed-top bg-dark" id="mainNav">
            <div class="container">
                <div class="collapse navbar-collapse " id="navbarResponsive">
                    <ul class="navbar-nav ms-auto py-4 py-lg-0">
                        <div class="collapse navbar-collapse" id="navbarNavDarkDropdown">
                            <ul class="navbar-nav">
                                <li class="">
                                    <a >
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </ul>
                </div>

            </div>
        </nav>
        <!-- Navegacion-->
        <section class="page-section bg-light" id="portfolio">
            <div class="container">
                </br>
                <div class="d-flex my-3">
                    <h2 class="section-heading text-uppercase">Lista de Funciones</h2>
                    <a class="btn btn-danger" style="margin-left: 30%;" href="<%=request.getContextPath()%>/LogServlet?finish=yes">Cerrar Sesión</a>
                </div>
                </br>
                <table class="table">
                    <thead>
                        <tr>
                            <th>Cadena</th>
                            <th>Cine</th>
                            <th>Película</th>
                            <th>Horario</th>
                        </tr>
                    </thead>
                    <tbody>
                    <%int i = 1;%>
                    <%for(Cartelera cartelera : carteleras){%>
                    <tr>
                        <th scope="row"><%=i%></th>
                        <td class="text-sm-center"><%=cartelera.getCine().getNombre()%></td>
                        <td class="text-sm-center" ><%=cartelera.getPelicula().getNombre()%>
                            <%=cartelera.getTresD() == 1 ? "/3D" : ""%>
                            <%=cartelera.getDoblada() == 1 ? "/Doblada" : ""%>
                            <%=cartelera.getSubtitulada() == 1 ? "/Subtitulada" : ""%></td>
                        <td class="text-sm-center"><%=cartelera.getHorario()%></td>
                    </tr>
                    <%
                            i=i+1;
                        }%>
                    </tbody>
                </table>
            </div>
        </section>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script>
        <!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
        <!-- * *                               SB Forms JS                               * *-->
        <!-- * * Activate your form at https://startbootstrap.com/solution/contact-forms * *-->
        <!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
        <script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
    </body>
</html>
