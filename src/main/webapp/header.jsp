<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es-ES">
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
<link rel="stylesheet" href="./css/estilos.css">
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>

<title>TAMTUM</title>
</head>
<body>
<div class="container-fluid">
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">TAMTUM</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavDropdown">
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="#">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Features</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Pricing</a>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Dropdown link
          </a>
          <ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
            <li><a class="dropdown-item" href="#">Action</a></li>
            <li><a class="dropdown-item" href="#">Another action</a></li>
            <li><a class="dropdown-item" href="#">Something else here</a></li>
          </ul>
        </li>
      </ul>
    </div>
  </div>
</nav>

<div class="d-flex flex-row min-vh-100">
 <div class="d-flex flex-column p-2 text-white bg-dark" style="width: 280px;">
    
     <div class="mb-3 d-flex align-items-center">
      <img src="views/img/logo.jpg" width="260">
    </div>
    
      <a href="#" class="d-flex align-items-center text-white text-decoration-none">
        <img src="views/img/golden.jpg" alt="" width="40" height="40" class="rounded-circle me-2">
        <strong>Bienvenido, usuario</strong>
      </a>
  
    <hr>
    <ul class="nav nav-pills flex-column mb-auto">
      <li class="nav-item">
        <a href="RolController?accion=listarRoles" class="nav-link active" aria-current="page">
         <i class="bi bi-shield-fill-check"></i>
          Roles
        </a>
      </li>
      <li>
        <a href="#" class="nav-link text-white">
          <i class="bi bi-people-fill"></i>
          Usuarios
        </a>
      </li>
      <li>
        <a href="#" class="nav-link text-white">
          <i class="bi bi-bookmark"></i>
          Proyectos
        </a>
      </li>
      <li>
        <a href="#" class="nav-link text-white">
          <i class="bi bi-grid"></i>
          Temas de Interes
        </a>
      </li>
      <li>
        <a href="#" class="nav-link text-white">
          <i class="bi bi-cart3"></i>
          Incentivos
        </a>
      </li>
    </ul>
    <hr>
    
  </div>