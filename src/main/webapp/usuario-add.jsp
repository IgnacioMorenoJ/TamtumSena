<%@include file="header.jsp" %>
<div class="flex-fill flex-grow-1 ms-3">

    <h1>Registro de Usuarios</h1>

    <form method="post" action="UsuarioController?accion=add">
<!-- 
        <div class="form-group">
            </ <label for="descripcion">Tipo Documento</label>
            <select class="form-select" aria-label="Default select example" name="tipodoc">
                <option selected>Seleccione su Tipo de Documento</option>
                <option value="C�dula de Ciudadan�a">C�dula de Ciudadan�a</option>
                <option value="Tarjeta de Identidad">Tarjeta de Identidad</option>
                <option value="C�dula de Extranjeria">C�dula de Extranjeria</option>
            </select> 
        </div>
        <div class="form-group">
            <label for="documento">No. Documento</label>
            <input type="text" class="form-control" name="documento" id="nodoc" placeholder="Ingrese el No. de Documento"/>
        </div> 
-->
        <div class="form-group">
            <label for="nombre">Nombre</label>
            <input type="text" class="form-control" name="nombre" id="nombre" placeholder="Ingrese el Nombre"/>
        </div>

        <div class="form-group">
            <label for="apellido">Apellido</label>
            <input type="text" class="form-control" name="apellido" id="apellido" placeholder="Ingrese el Apellido"/>
        </div>
        <div class="form-group">
            <label for="documento">No. Documento</label>
            <input type="text" class="form-control" name="documento" id="nodoc" placeholder="Ingrese el No. de Documento"/>
        </div> 
        <div class="form-group">
            <label for="correo">Correo Electr�nico</label>
            <input type="email" class="form-control" name="correo" id="correo" placeholder="Ingrese el Correo"/>
        </div>

        <div class="form-group">
            <label for="fecha de nacimiento">Fecha de Nacimiento</label>
            <input type="text" class="form-control" name="fecha de nacimiento" id="direccion" placeholder="Ingrese su fecha de nacimiento"/>
        </div>

        <div class="form-group">
            <label for="telefono">Tel�fono</label>
            <input type="text" class="form-control" name="telefono" id="telefono" placeholder="Ingrese el Tel�fono"/>
        </div>

        
        <div class="form-group">
            <label for="password">Password</label>
            <input type="password" class="form-control" name="clave" id="password" placeholder="Ingrese su contrase�a"/>
        </div>


        </select>

</div>


<!-- <div class="form-check">
    <input class="form-check-input" type="checkbox" name="chkEstado" id="chkEstado" checked>
    <label class="form-check-label" for="flexCheckChecked">
        Activo
    </label>
</div>-->

<div>
    <button type="submit" class="btn btn-primary">Guardar</button>
</div>

</form>
</div> 
</div>


<%@include file="footer.jsp" %>