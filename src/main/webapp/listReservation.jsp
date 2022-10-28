<%@ include file="Layout/Header.jsp"  %>
<%@ include file="Layout/Navbar.jsp"  %>
	 <main class="mt-2">
    <div class="container-fluid py-2">
        <div class="row d-flex justify-content-center ">
           <div class="col-md-12 fw-bold text-light bg-dark">
               <h3>Liste Des Reservations</h3> 
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
           <div class="card-header"><a href="/biblio/export?rapport=listReservation" target="_blank" class="btn btn-sm btn-primary">Export Rapport Reservation</a> </div>
              <div class="card-body"> 
                <table id="example" class="table" style="width:100%">
                  <thead> 
                      <tr> 
                          <th>Adherent</th>
                          <th>TelePhone</th> 
                          <th>Adresse</th>
                          <th>Titre Livre</th>
                          <th>Auteur</th> 
                          <th>Quantite</th>  
                          <th>Option</th>
                      </tr>
                  </thead> 
                  <tbody>
                   	  <c:forEach  var="resData" items="${listRes}"> 
                      <tr> 
                          <td><c:out value="${resData.nom } ${resData.prenom }" /></td>
                          <td><c:out value="${resData.telephone }"></c:out></td> 
                          <td><c:out value="${resData.adresse }"></c:out></td>
                          <td><c:out value="${resData.titre }"></c:out></td>
                          <td><c:out value="${resData.auteur }"></c:out></td> 
                        <td><c:out value="${resData.quantite }"></c:out></td> 
                          <td>
                          	 <c:choose>
							  <c:when test="${resData.quantite >=10}">
							     <a href="pret?id=${resData.idLivre}" class="btn btn-sm btn-primary">Preter</a>
							  </c:when>
							  <c:when test="${resData.quantite < 10}">
							    <span class="badge bg-warning">En Attente</span>
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