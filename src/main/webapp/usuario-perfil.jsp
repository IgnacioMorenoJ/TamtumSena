<%@include file="header.jsp" %>
  <div class="flex-fill flex-grow-1 ms-3">
  
  <h1>Perfil de Usuario</h1>
  
  <form method="post" action="UsuarioController?accion=edit">
  	<input type="text" class="form-control" name="id" id="id" placeholder="Id Usuario" value="${us.id}"/>
  	
  	<div class="form-group">
  	<label for="descripcion">Tipo Documento</label>
  	<select class="form-select" aria-label="Default select example" name="tipodoc" disabled>
	  <option selected>Seleccione su Tipo de Documento</option>
	  <option value="C�dula de Ciudadan�a" <c:if test="${us.tipoDocUsuario=='C�dula de Ciudadan�a'}"> selected </c:if> >C�dula de Ciudadan�a</option>
	  <option value="Tarjeta de Identidad" <c:if test="${us.tipoDocUsuario=='Tarjeta de Identidad'}"> selected </c:if>>Tarjeta de Identidad</option>
	  <option value="C�dula de Extranjeria" <c:if test="${us.tipoDocUsuario=='C�dula de Extranjeria'}"> selected </c:if>>C�dula de Extranjeria</option>
	</select>
	</div>
  	<div class="form-group">
  		<label for="nodoc">No. Documento</label>
  		<input type="text" class="form-control" name="nodoc" id="nodoc" placeholder="Ingrese el No. de Documento" value="${us.noDocUsuario}" readonly/>
  	</div>
  	
  	<div class="form-group">
  		<label for="nombre">Nombre</label>
  		<input type="text" class="form-control" name="nombre" id="nombre" placeholder="Ingrese el Nombre" value="${us.nombre}"/>
  	</div>
  	
  	<div class="form-group">
  		<label for="apellido">Apellido</label>
  		<input type="text" class="form-control" name="apellido" id="apellido" placeholder="Ingrese el Apellido" value="${us.apellidos}"/>
  	</div>
  	
  	<div class="form-group">
  		<label for="direccion">Direcci�n</label>
  		<input type="text" class="form-control" name="direccion" id="direccion" placeholder="Ingrese la Direcci�n" value="${us.direccion}"/>
  	</div>
  	
  	<div class="form-group">
  		<label for="telefono">Tel�fono</label>
  		<input type="text" class="form-control" name="telefono" id="telefono" placeholder="Ingrese el Tel�fono" value="${us.telefono}"/>
  	</div>
  	
  	<div class="form-group">
  		<label for="correo">Correo Electr�nico</label>
  		<input type="email" class="form-control" name="correo" id="correo" placeholder="Ingrese el Correo" value="${us.correo}"/>
  	</div>
  	
 	 
                               

<div>
<button type="submit" class="btn btn-primary">Actualizar Perfil</button>
</div>
  
  </form>
  </div> 
</div>


<%@include file="footer.jsp" %>