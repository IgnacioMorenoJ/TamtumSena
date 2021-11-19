<%@include file="header.jsp" %>
  <div class="flex-fill flex-grow-1 ms-3">
  
  <h1>Editar  Roles</h1>
  
  <form method="post" action="RolesController?accion=edit">
  	
  	<input type="text" class="form-control" name="id" value="${user.id}"/>
  	<div class="form-group">
  	<label for="descripcion">Tipo Documento</label>
  	<select class="form-select" aria-label="Default select example" name="tipodoc">
	  <option selected>Seleccione su Tipo de Documento</option>
	  <option value="C�dula de Ciudadan�a" <c:if test="${user.tipoDocUsuario == 'C�dula de Ciudadan�a'}">
                                   selected
                             </c:if> >C�dula de Ciudadan�a</option>
	  <option value="Tarjeta de Identidad" <c:if test="${user.tipoDocUsuario == 'Tarjeta de Identidad'}">
                                   selected
                             </c:if>>Tarjeta de Identidad</option>
	  <option value="C�dula de Extranjeria" <c:if test="${user.tipoDocUsuario == 'C�dula de Extranjeria'}">
                                   selected
                             </c:if>>C�dula de Extranjeria</option>
	</select>
	</div>
  	<div class="form-group">
  		<label for="nodoc">No. Documento</label>
  		<input type="text" class="form-control" name="nodoc" id="nodoc" placeholder="Ingrese el No. de Documento" value="${user.noDocUsuario}"/>
  	</div>
  	
  	<div class="form-group">
  		<label for="nombre">Nombre</label>
  		<input type="text" class="form-control" name="nombre" id="nombre" placeholder="Ingrese el Nombre" value="${user.nombreUsuario}"/>
  	</div>
  	
  	<div class="form-group">
  		<label for="apellido">Apellido</label>
  		<input type="text" class="form-control" name="apellido" id="apellido" placeholder="Ingrese el Apellido" value="${user.apellidoUsuario}"/>
  	</div>
  	
  	<div class="form-group">
  		<label for="direccion">Direcci�n</label>
  		<input type="text" class="form-control" name="direccion" id="direccion" placeholder="Ingrese la Direcci�n" value="${user.direccionUsuario}"/>
  	</div>
  	
  	<div class="form-group">
  		<label for="telefono">Tel�fono</label>
  		<input type="text" class="form-control" name="telefono" id="telefono" placeholder="Ingrese el Tel�fono" value="${user.telefonoUsuario}"/>
  	</div>
  	
  	<div class="form-group">
  		<label for="correo">Correo Electr�nico</label>
  		<input type="email" class="form-control" name="correo" id="correo" placeholder="Ingrese el Correo" value="${user.correoUsuario}"/>
  	</div>
  	
  	<div class="form-group">
  		<label for="password">Password</label>
  		<input type="password" class="form-control" name="password" id="password" placeholder="Ingrese el Password" value="${user.passwordUsuario}"/>
  	</div>
  	
  	 <div class="form-group">
  	  <label>Rol de Usuario</label>
           <div class="form-group">
                
                <select class="form-select"  name="rolusu" autofocus=""  required="">
                 	<c:forEach items="${roles}" var="rol">
                            <option value="${rol.idRol}" 
                             <c:if test="${rol.idRol == user.rolUs.idRol}">
                                   selected
                             </c:if>        
                             >${rol.descripcionRol}</option>
                    </c:forEach>
                                            
                </select>
            </div>                                  
                                
<div>
<button type="submit" class="btn btn-primary">Guardar</button>
</div>
  
  </form>
  </div> 
</div>


<%@include file="footer.jsp" %>