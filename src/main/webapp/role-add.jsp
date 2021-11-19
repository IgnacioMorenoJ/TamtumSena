<%@include file="header.jsp" %>
<div class="flex-fill flex-grow-1 ms-3">

    <h1>Registro de Roles</h1>

    <form method="post" action="RolesController?accion=add">
    <div class="form-group">
            </ <label for="descripcion">Tipo Documento</label>
            <select class="form-select" aria-label="Default select example" name="tipodoc">
                <option selected>Seleccione su Rol</option>
                <option value="Estudiante">Estudiante</option>
                <option value="Universidad">Universidad</option>
                <option value="Empresa">Empresa</option>
                <option value="Administrador">Administrador</option>
            </select> 
        </div>
       

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