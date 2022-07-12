<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.examen.Beans.Cine" %>
<%@ page import="com.example.examen.Beans.Pelicula" %>
<%@ page import="java.util.Objects" %>
<jsp:useBean type="java.util.ArrayList<com.example.examen.Beans.Cine>" scope="request" id="listaCines"/>
<jsp:useBean type="java.util.ArrayList<com.example.examen.Beans.Pelicula>" scope="request" id="listaPeliculas"/>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Crear Función</title>
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
        <!-- Cuerpo-->
        <section class="page-section bg-light" id="portfolio">
            <div class="container">
                </br>
                <h2 class="section-heading text-uppercase">Crear Función</h2>

                <form class="row g-3 needs-validation" method="POST" action="<%=request.getContextPath()%>/CrearFuncionServlet?a=guardar">
                    <!--Columna 1-->
                    <div class="col-md-6">
                        <div class="form-group">
                            <!-- Name input-->
                            <label for="funcion" class="form-label">Nombre de la Película *</label>
                            <select class="form-select" name="funcion" id="funcion" required>
                                <option disabled>Seleccione película</option>
                                <% for(Pelicula listaPeliculas1 : listaPeliculas){ %>
                                <option value="<%=listaPeliculas1.getIdPelicula()%>"><%=listaPeliculas1.getNombre()%></option>
                                <% } %>
                            </select>
                        </div>
                        </br>
                        <div class="form-group">
                            <label for="cine" class="form-label">Cine *</label>
                            <select class="form-select" name="cine" id="cine" required>
                                <option disabled>Seleccione cine</option>
                                <% for(Cine listaCine : listaCines){ %>
                                <option value="<%=listaCine.getIdCine()%>"><%=listaCine.getNombre()%></option>
                                <% } %>
                            </select>
                        </div>
                        </br>
                        <div class="form-group">
                            <label for="tresd" class="form-label">3D *</label>
                            <select class="form-select" name="tresd" id="tresd" required>
                                <option value="1">Sí</option>
                                <option value="0">No</option>
                            </select>
                        </div>
                        </br>
                        </br>
                        <div class="row align-items-stretch mb-5">
                            <div class="col-md-2">
                                <a href="<%=request.getContextPath()%>/GestorServlet" class="btn btn-secondary btn-xl">Regresar</a>
                            </div>
                            <div class="col-md-2">
                            </div>
                            <div class="col-md-2">
                                <button type="submit" class="btn btn-primary btn-xl" >
                                    Crear
                                </button>
                            </div>
                            <div class="col-md-1">
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="idioma" class="form-label">idioma *</label>
                            <select class="form-select" name="idioma" id="idioma" required>
                                <option value="0">Subtitulada</option>
                                <option value="1">Doblada</option>
                            </select>
                        </div>
                        </br>
                        <div class="form-group">
                            <label for="tiempo_inicio" class="form-label">Horario *</label>
                            <input type="text" class="form-control" placeholder="Ingrese los horarios" name="tiempo_inicio" id="tiempo_inicio" required>
                        </div>
                        </br>
                    </div>
                </form>
            </div>

        </section>



        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script>
        <!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
        <!-- * *                               SB Forms JS                               * *-->
        <!-- * * Activate your form at https://startbootstrap.com/solution/contact-forms * *-->
        <!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
        <script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>

        <script>
            var forms = document.querySelectorAll('.needs-validation');

            Array.prototype.slice.call(forms).forEach(function (form) {
                form.addEventListener('submit', function (event) {
                    if (!form.checkValidity()) {
                        event.preventDefault();
                        event.stopPropagation();
                    }

                    form.classList.add('was-validated');
                }, false);
            });

        </script>

    </body>
</html>