<%@include file="header.jsp" %>

<div class="flex-fill flex-grow-1 ms-3">

  <h1>Lista de Roles</h1>
  <a type="button" class="btn btn-primary" href="RolesController?accion=abrirForm">
  <i class="bi bi-plus-circle"></i> 
  Agregar Rol
  </a>

 <table class="table table-hover table-bordered">
 
       <tr>
            <th>Id</th>
            <th>Nombre</th>
            <th><center>Estado</center></th>            
            <th colspan="2"><center>Acciones</center></th>
        </tr>
        
<c:forEach var="rol" items="${roler}">         
        
        <tr>
        <td>${rol.getId()}</td>
        <td>${rol.getDescripcion()}</td>
     	 <c:if test="${rol.getEstado() == true}">
           <td><span class="badge bg-success active">Usuario Activo</span></td> 
        
          
         </c:if>
        <c:if test="${rol.getEstado() == false}">
            <td><span class="badge bg-danger active">Usuario Inactivo</span></td> 
        </c:if>
        
        <td>
        <c:if test="${rol.getEstado() == true}">
           <a rol="button" 
           class="btn btn-danger btn-sm" 
           onclick="cambiare(event,${rol.getId()},${rol.getEstado()},'Roles')"> 
        
           
        Inactivar
        </a>
        </c:if>
        <c:if test="${rol.getEstado() == false}">
            <a rol="button" 
            class="btn btn-success btn-sm" 
            onclick="cambiare(event,${rol.getId()},${rol.getEstado()},'Roles')">
        Activar
        </a>
        </c:if> 
        </td>
        
        
        <td>
        <a rol="button" 
        class="btn btn-warning" 
        href="RolesController?accion=verRol&id=${rol.getId()}">
        <i class="bi bi-pencil"></i> 
        </a>

	    <a rol="button" 
	    class="btn btn-danger" 
	    onclick="borrar(event,${rol.getId()},'Rol')">
                
	    <i class="bi bi-trash"></i> 
	    </a>
	    
	    </td>
        <tr> 
        
</c:forEach>    


</table>


</div> 
</div>


<%@include file="footer.jsp" %>