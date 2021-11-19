<%@include file="header.jsp" %>

<div class="flex-fill flex-grow-1 ms-3 overflow-hidden">

<h1>Roles</h1>
  <a type="button" class="btn btn-success" href="RolesController?accion=abrirForm">
  <i class="bi bi-plus-circle"></i> 
  Agregar Rol
  </a>
<div class="table-responsive">
 <table class="table table-hover table-bordered">
 
       <tr>
            <th>Id</th>
            <th>Descripcion</th>
           
       </tr>
       
       <c:forEach var="r" items="${roler}">         
        
        <tr>
        <td>${r.getId()}</td>
        <td>${r.getDescripcion()}</td>
            
       	    
        <tr>
        
</c:forEach>    
    
       
</table>
</div>

</div> 
</div>

<%@include file="footer.jsp" %>