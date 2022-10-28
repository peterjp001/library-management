<%@ include file="Layout/Header.jsp"  %>
<%@ include file="Layout/Navbar.jsp"  %>
	 <main class="mt-2">
    <div class="container p-2">
        <div class="row  ">
           <div class="col-md-12 fw-bold d-flex justify-content-between  rounded  text-light bg-dark">
               <h3>Pret / Reservation</h3> 
           </div>
           
           <div class="col-sm-12 pt-2">
           		<c:if test="${not empty message}"> 
				   <div class="alert alert-${type} text-center alert-dismissible fade show" role="alert">
					  <strong></strong> <c:out value="${message }" />
					  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
					</div>
				</c:if>
           </div>
           
        </div>
        
        
        
        <div class="row pt-3">
          <div class="col-12 ">
            <c:if test="${not empty message}">
		   <div class="alert bg-${type} text-center text-light mt-2"><c:out value="${message }" /></div>
		</c:if>
            <div class="card">
            <div class="card-header d-flex justify-content-between">
            	
				<h3>Liste des Livres</h3>
				
            </div>
              <div class="card-body"> 
                <table id="example" class="table table-striped table-bordered nowrap" style="width:100%">
                  <thead>
                      <tr> 
                          <th>Titre</th>
                          <th>Auteur</th>
                          <th>Date Parution</th>
                          <th>Categorie</th>
                          <th>Quantite</th>
                          <th>Etat</th>
                          <th>Option</th> 
                      </tr>
                  </thead> 
                  <tbody>
                   	  <c:forEach  var="livre" items="${listLivre}"> 
                      <tr> 
                          <td><c:out value="${livre.titre }"></c:out></td>
                          <td><c:out value="${livre.auteur }"></c:out></td>
                          <td><c:out value="${livre.date_parution }"></c:out></td>
                          <td><c:out value="${livre.categorie }"></c:out></td>
                          <td><c:out value="${livre.quantite }"></c:out></td>
                          <td><c:out value="${livre.etat }"></c:out></td>
                          <td>
                          <c:choose>
							  <c:when test="${livre.quantite >= 10}">
							     <a href="pret?id=${livre.id}" class="btn btn-sm btn-primary">Preter</a>
							  </c:when>
							  <c:when test="${livre.quantite > 0 && livre.quantite < 10}">
							    <span class="badge bg-warning">Consulter sur place</span>
							  </c:when>
							  <c:when test="${livre.quantite < 1 }">
							    <a href="reserver?id=${livre.id}" class="btn btn-sm btn-success">Reserver</a>
							  </c:when>
						  </c:choose>
	                         
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