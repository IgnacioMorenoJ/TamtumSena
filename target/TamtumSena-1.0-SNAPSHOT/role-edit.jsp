<%@include file="header.jsp" %>
  <div class="flex-fill flex-grow-1 ms-3">
  
  <h1>Actualizar de Roles</h1>
  
  <form method="post" action="RolesController?accion=editRol">
  	
  	    <label for="id">Id</label>
            <input type="text" class="form-control" name="id" value="${verrol.id}"/>
  	
  	<div class="form-group">
  		<label for="descripcion">Descripción</label>
  		<input type="text" class="form-control" name="descripcion" id="descripcion" placeholder="Ingrese la descripción" value="${verrol.descripcion}"/>
  	</div>
  	
  	<div class="form-check">
  	
  <input class="form-check-input" type="checkbox" name="chkEstado" id="chkEstado" 
  <c:out value="${verrol.estado==false ? 'unchecked':'checked'}" default=""/>>
  <label class="form-check-label" for="flexCheckChecked">
	${verrol.estado==false ? 'Marca la casilla para activar':'Desmarca la casilla para Inactivar'}
  </label>
</div>

<div>
<button type="submit" class="btn btn-primary">Guardar</button>
</div>
  
  </form>
  </div> 
</div>


<%@include file="footer.jsp" %>