<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="indicador" scope="session" type="java.lang.String" class="java.lang.String"/>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!-- CSS only -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
        <!-- Importando estilos personalizados -->
        <link rel="stylesheet" type="text/css" href="css/estilos_d.css">
        <title>Iniciar Sesión</title>
    </head>
    <body>
        <div class="form-login" style="margin-top: 4%;">
            <div class="login-container" style="margin-top: -1%;">
                <div class="login-header">
                    <h3 style="font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;color: rgb(100, 19, 176);">T3L3 C4MP30N FUTS4L S.A.C 2019</h3>
                    <h2 style="margin-top: 1%;font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;color: rgb(16, 16, 115);">Iniciar Sesión</h2>
                </div>
                <form method="POST" action="">
                    </br>
                    <div class="mb-3" style="margin-top: 2%;">
                        <label for="exampleInputEmail1" class="form-label">DNI:</label>
                        <input type="number" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="dni" required>
                    </div>
                    </br>
                    <div class="mb-3">
                        <label for="exampleInputPassword1" class="form-label">Contraseña:</label>
                        <input type="password" class="form-control" id="exampleInputPassword1" name="pass" required>
                    </div>

                    <div class="btn-container">
                        <button type="submit" class="btn btn-ingresar" >Ingresar</button>
                    </div>
                </form>
                <%if (session.getAttribute("indicador").equals("error")){%>
                </br>
                <div class="text-danger nb-2">
                    Error en usuario o contraseña!!!
                </div>
                <%session.removeAttribute("indicador");%>
                <%}%>
            </div>
        </div>
        </br>
        </br>
    </body>
</html>