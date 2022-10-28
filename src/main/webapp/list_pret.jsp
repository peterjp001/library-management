<%@ include file="Layout/Header.jsp"  %>
<%@ include file="Layout/Navbar.jsp"  %>
	 <main class="mt-2">
    <div class="container-fluid py-2">
        <div class="row d-flex justify-content-center ">
           <div class="col-md-12 fw-bold text-light bg-dark">
               <h3>Liste Des Prets</h3> 
           </div>
           
           <div class="col-sm-12 pt-2">
           		<c:if test="${not empty message}"> 
				   <div class="alert alert-${type} text-center alert-dismissible fade show" role="alert">
					  <strong>Operation Reusie!</strong> <c:out value="${message }" />
					  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
					</div>
				</c:if>
           </div>
           
        </div>
        
        
        <div class="row pt-3">
          <div class="col-12 ">
            
            <div class="card">
           <div class="card-header"><a href="/biblio/export?rapport=listPret" target="_blank" class="btn btn-sm btn-primary">Export Rapport Pret</a> </div>
              <div class="card-body"> 
                <table id="example" class="table" style="width:100%">
                  <thead> 
                      <tr> 
                          <th>Adherent</th>
                          <th>TelePhone</th> 
                          <th>Adresse</th>
                          <th>Titre Livre</th>
                          <th>Auteur</th>
                          <th>D.Pret</th>
                          <th>D.Retour</th>
                          <th>Delai</th> 
                          <th>Option</th>
                      </tr>
                  </thead> 
                  <tbody>
                   	  <c:forEach  var="pretData" items="${listPret}"> 
                      <tr> 
                          <td><c:out value="${pretData.nom } ${pretData.prenom }" /></td>
                          <td><c:out value="${pretData.telephone }"></c:out></td> 
                          <td><c:out value="${pretData.adresse }"></c:out></td>
                          <td><c:out value="${pretData.titre }"></c:out></td>
                          <td><c:out value="${pretData.auteur }"></c:out></td>
                          <td><c:out value="${pretData.date_pret }"></c:out></td>
                          <td><c:out value="${pretData.date_retour }"></c:out></td>
                          <td> 
	                          <c:choose>
								  <c:when test="${pretData.delai > 0}">
								    <span class="badge bg-success"><c:out value="${pretData.delai} jour(s)"/> </span>
								  </c:when>
								  <c:when test="${pretData.delai <=0}">
								    <span class="badge bg-danger">Delai ecoulé</span>
								  </c:when>
							  </c:choose> 
                          </td> 
                          
                          <td>
                          	<form method="post">
                          	<input type="hidden" name = "idPret" value="${ pretData.idPret}"> 
                          	<input type="hidden" name = "idLivre" value="${ pretData.idLivre}"> 
                          	<input type="hidden" name = "quantite" value="${ pretData.quantite}"> 
                          		<button class="btn btn-primary btn-sm">Retourner</button>
                          	</form>
                          </td>
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