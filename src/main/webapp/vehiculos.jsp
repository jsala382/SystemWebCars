<%@page contentType="UTF-8"  import="java.util.*, org.jsalaza.apiservlet.webappheaders.modelo.*"%>
<%
        List<Car> car=(List<Car>)request.getAttribute("car");

%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Formulario de Registro</title>
</head>


<body>
<div>
    <form action="/SystemWebCars/vehiculos" method="post">
        <h2> Formulario de vehiculo</h2>

        <div>
            <label>Marca</label>
            <div>
                <select name="marca">
                    <option value="">--------seleccionar----------</option>
                    <option value="Mitsubishi">Mitsubichi</option>
                    <option value="Mazda">Mazda</option>
                    <option value="Subaru">Subaru</option>
                    <option value="Toyota" }>Toyota</option>
                    <option value="Chevrolet">Chevrolet</option>
                    <option value="BMW" }>BMW</option>
                    <option value="Wolkswagen">Wolkswagen</option>
                </select>
            </div>

        </div>


        <div class>
            <label for="placa">Placa</label>
            <div><input type="text" name="placa" id="placa">
            </div>
        </div>


        <div class>
            <label for="NoMatricula">No.Matricula</label>
            <div><input type="text" name="noMatricula" id="No.Matricula">
            </div>
        </div>

        <div class>
            <label>Color</label>
            <div>Rojo<input type="checkbox" name="color" value="Rojo">
            </div>
            <div>Verde<input type="checkbox" name="color" value="Verder">
            </div>
            <div>Amarillo<input type="checkbox" name="color" value="Amarillo">
            </div>
            <div>Azul<input type="checkbox" name="color" value="Azul">
            </div>
        </div>


        <div>
            <div>
                <input type="submit" value="Guardar" class="btn btn-primary">
            </div>
        </div>
    </form>

</div>
</body>
</html>