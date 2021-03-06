<%@ page import="com.example.examen.Beans.Empleado" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%ArrayList<Empleado> listaSinJefe = (ArrayList<Empleado>) request.getAttribute("listaSinJefe");%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Empleados sin Jefe</title>
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
        <section class="page-section bg-light" id="portfolio">
            <div class="container">
                </br>
                <div class="d-flex my-3">
                    <h2 class="section-heading text-uppercase">Empleados sin Jefe</h2>
                    <a href="<%=request.getContextPath()%>/AdminServlet" class="btn btn-secondary btn-xl ms-auto">Regresar</a>
                </div>
                </br>
                </br>
                <table class="table">
                    <thead>
                        <tr>
                            <th>Nombre</th>
                            <th>Apellido</th>
                            <th>DNI</th>
                            <th>Salario</th>
                            <th>Fecha de Contrato</th>

                        </tr>
                    </thead>
                    <tbody>
                        <%for(Empleado empleado:listaSinJefe){%>
                        <tr>
                            <td>
                                <%=empleado.getNombre()%>
                            </td>
                            <td>
                                <%=empleado.getApellido()%>
                            </td>
                            <td>
                                <%=empleado.getDni()%>
                            </td>
                            <td>
                                <%=empleado.getSalario()%>
                            </td>
                            <td>
                                <%=empleado.getFechaContrato()%>
                            </td>

                        </tr>
                        <%}%>
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
