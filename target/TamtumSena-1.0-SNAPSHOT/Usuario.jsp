<%@include file="header.jsp" %>

<div class="flex-fill flex-grow-1 ms-3 overflow-hidden">

<h1>Lista de Usuarios</h1>
  <a type="button" class="btn btn-success" href="UsuarioController?accion=abrirForm">
  <i class="bi bi-plus-circle"></i> 
  Agregar Usuario
  </a>
<div class="table-responsive">
 <table class="table table-hover table-bordered">
 
       <tr>
            <th>Id</th>
            <th>Nombre</th>
            <th>Apellido</th>
            <th>Dirección</th>
            <th>Teléfono</th>
            <th>Correo</th>
            <th>Rol Usuario </th>
            <th><center>Estado</center></th>            
            <th colspan="2"><center>Acciones</center></th>
       </tr>
        

<c:forEach var="u" items="${user}">         
        
        <tr>
        <td>${u.getId()}</td>
        <td>${u.getNombre()}</td>
        <td>${u.getApellidos()}</td>
        <td>${u.getDocumento()}</td>
        <td>${u.getTelefono()}</td>
        <td>${u.getCorreo()}</td>
        <td>${u.getFechaDeNacimiento()}</td>
        <td>${u.getEstado()}</td>
        
     	 <c:if test="${u.getEstado() == true}">
           <td><span class="badge bg-success active">Usuario Activo</span></td> 
        </c:if>
        <c:if test="${u.getEstado() == false}">
            <td><span class="badge bg-danger active">Usuario Inactivo</span></td> 
        </c:if>
        
        <td>
        <c:if test="${u.getEstado() == true}">
           <a rol="button" 
           class="btn btn-danger btn-sm" 
           onclick="cambiare(event,${u.getId()},${u.getEstado()},'Usuario')"> 
        Inactivar
        </a>
        </c:if>
        <c:if test="${u.getEstado() == false}">
            <a rol="button" 
            class="btn btn-success btn-sm" 
            onclick="cambiare(event,${u.getId()},${u.getEstado()},'Usuario')">
        Activar
        </a>
        </c:if> 
        </td>
        
        
        <td>
        <a usuario="button" 
        class="btn btn-warning" 
        href="UsuarioController?accion=ver&id=${u.getId()}">
        <i class="bi bi-pencil"></i> 
        </a>

	    <a usuario="button" 
	    class="btn btn-danger" 
	    onclick="borrar(event,${u.getId()},'Usuario')">
	    <i class="bi bi-trash"></i> 
	    </a>
	    
	    </td>
        <tr>
        
</c:forEach>    


</table>
</div>

</div> 
</div>

<%@include file="footer.jsp" %>