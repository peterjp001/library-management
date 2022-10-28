<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
  <% 
  
  if(session.getAttribute("username") == null && session.getAttribute("niveau") == null ) {
		response.sendRedirect("/biblio/");
	} 
  
  %>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <div class="container-fluid px-3">
     <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <a class="navbar-brand" href="#"><img class="" src="assets/img/logo-UNEPH.png" alt="" width="40" height="40"> UNEPH</a>
   
    <div class="collapse navbar-collapse justify-content-center" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="/biblio/accueil">Accueil</a>
        </li>
        <li class="nav-item">
          <a class="nav-link " aria-current="page" href="/biblio/adherent">Adherents</a>
        </li>
        <li class="nav-item">
          <a class="nav-link " aria-current="page" href="/biblio/livre">Livres</a>
        </li> 
        <li class="nav-item dropdown">
	        <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">Service Prêt / Reservation</a>
	        <div class="dropdown-menu">
	            <a class="dropdown-item" href="/biblio/listpret">Liste Prêt  </a>
	            <a class="dropdown-item" href="/biblio/listreservation">Liste  Reservation</a>
	            <a class="dropdown-item" href="/biblio/preterlivre">Faire Un Prêt / Reservation</a> 
	        </div>
	    </li>  
    
        <%  if(session.getAttribute("niveau").equals("admin") ) { %>
         <li class="nav-item">
          <a class="nav-link " aria-current="page" href="/biblio/user">Utilisateurs</a>
        </li> 
        <%} %>  
      </ul>
    </div>
     <div class="d-flex align-items-end">
          <a class="nav-link dropdown-toggle text-light" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            <span class=""><c:out value="${username}" /></span>
            <svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-person-circle" viewBox="0 0 16 16">
		        <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"/>
		        <path fill-rule="evenodd" d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z"/>
		     </svg>
          </a>
          <ul class="dropdown-menu  dropdown-menu-end shadow" aria-labelledby="navbarDropdown">
            <li><a class="dropdown-item" href="#">Mon Compte</a></li> 
            <li><hr class="dropdown-divider"></li>
            <li><a class="dropdown-item" href="/biblio/logout/">Deconnection</a></li>
          </ul>
     </div>
  </div>
</nav>