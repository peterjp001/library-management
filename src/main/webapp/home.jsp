<%@ include file="Layout/Header.jsp"  %>
<%@ include file="Layout/Navbar.jsp"  %>
	 <main class="mt-2">
    <div class="container p-2">
        <div class="row shadow ">
            <div class="col-md-12 fw-bold  fs-3 rounded  text-light bg-dark">
                Gestion Bibliotheque  
            </div>
        </div>
        <div class="row row-cols-1 row-cols-sm-2 pt-3  row-cols-lg-4  mb-3">
          <div class="col" >
            <a href="#" class="text-decoration-none">
            <div class="card shadow">
              <div class="card-body text-dark">
                <div class="row">
                  <div class="col-sm-12"><h5>Adherent</h5></div>
                  <div class="col-sm-12 d-flex justify-content-between text-center">
                    <h5><c:out value="${nbrAdherent }" /></h5><i class="bi bi-people"></i>
                  </div>
                </div>
              </div>
            </div>
            </a>
          </div>   
           <div class="col" >
            <a href="#" class="text-decoration-none">
            <div class="card shadow "  >
              <div class="card-body text-dark">
                <div class="row">
                  <div class="col-sm-12"><h5>Auteur</h5></div>
                  <div class="col-sm-12 d-flex justify-content-between text-center">
                    <h5><c:out value="${nbrAuteur }" /></h5><i class="bi bi-person-badge-fill"></i>
                  </div>
                </div>
              </div>
            </div>
            </a>
          </div>   
          <div class="col" >
            <a href="#" class="text-decoration-none">
            <div class="card shadow "  >
              <div class="card-body text-dark">
                <div class="row">
                  <div class="col-sm-12"><h5>Livres</h5></div>
                  <div class="col-sm-12 d-flex justify-content-between text-center">
                    <h5><c:out value="${nbrLivre }"/></h5><i class="bi bi-book"></i>
                  </div>
                </div>
              </div>
            </div>
            </a>
          </div>   
          <div class="col" >
            <a href="#" class="text-decoration-none">
            <div class="card shadow "  >
              <div class="card-body text-dark">
                <div class="row">
                  <div class="col-sm-12"><h5>Categories Livre</h5></div>
                  <div class="col-sm-12 d-flex justify-content-between text-center">
                    <h5><c:out value="${nbrCat }"/></h5><i class="bi bi-people"></i>
                  </div>
                </div>
              </div>
            </div>
            </a>
          </div>   
            
        </div>
        <div class="row">
          <div class="col-12">  
          </div>
        </div>
    </div>
    <div class="container">
    	<div class="row row-cols-1 row-cols-sm-2">
    		<div class="col">
    			<div class="card">
    				<div class="card-header bg-dark text-light">Meilleur Auteur</div>
	    			<div class="card-body">
	    				<table class="table">
						  <thead>
						    <tr> 
						      <th scope="col">Auteur</th>
						      <th scope="col">Nbr Livre</th>
						      <th scope="col">Nbr Livre Preter</th>
						    </tr>
						  </thead>
						  <tbody class="table-group-divider">
						     <c:forEach  var="li" items="${li}"> 
                      <tr> 
                          <td><c:out value="${li.auteur }"></c:out></td>
                          <td><c:out value="${li.nbrLivre }"></c:out></td>
                          <td><c:out value="${li.nbrLivrePreter }"></c:out></td>  
                      </tr>
                      </c:forEach>
						    
						  </tbody>
						</table>
	    			</div>
    			</div>
    		</div>
    		<div class="col">
    			<div class="card">
    				<div class="card-header bg-dark text-light">Meilleur Livre</div>
	    			<div class="card-body">
	    				<table class="table">
						  <thead>
						    <tr> 
						      <th scope="col">Livre</th>
						      <th scope="col">Auteur</th>
						      <th scope="col">Date Parution</th>
						    </tr>
						  </thead>
						  <tbody class="table-group-divider">
						    <c:forEach  var="livre" items="${listLivre}"> 
                      <tr> 
                          <td><c:out value="${livre.titre }"></c:out></td>
                          <td><c:out value="${livre.auteur }"></c:out></td>
                          <td><c:out value="${livre.date_parution }"></c:out></td>  
                      </tr>
                      </c:forEach> 
						  </tbody>
						</table>
	    			</div>
    			</div>
    		</div>
    		<div class="col">
    			<div class="card">
    				<div class="card-header bg-dark text-light">Nbr Livre Par Categorie</div>
	    			<div class="card-body">
	    				<table class="table">
						  <thead>
						    <tr> 
						      <th scope="col">Categorie</th>
						      <th scope="col">Nbr Livre</th> 
						    </tr>
						  </thead>
						  <tbody class="table-group-divider">
						     <c:forEach  var="lbc" items="${lbc}"> 
                      <tr>  
                          <td><c:out value="${lbc.categorie }"></c:out></td>
                          <td><c:out value="${lbc.nbrLivre }"></c:out></td>  
                      </tr>
                      </c:forEach>
						    
						  </tbody>
						</table>
	    			</div>
    			</div>
    		</div>
    	</div>
    </div>
</main>
<%@ include file="Layout/Footer.jsp"  %>