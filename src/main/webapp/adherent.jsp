<%@ include file="Layout/Header.jsp"  %>
<%@ include file="Layout/Navbar.jsp"  %>
	 <main class="mt-2">
    <div class="container p-2">
        <div class="row  ">
           <div class="col-md-12 fw-bold d-flex justify-content-between  rounded  text-light bg-dark">
               <h3>Adherent</h3> <span>Nombre: <c:out value="${fn:length(listAdherent) }"></c:out></span>
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
            <div class="card">
            <div class="card-header d-flex justify-content-between">
            	<!-- Button trigger modal -->
				<div>
					<button type="button" class="btn btn-primary btn-sm" data-bs-toggle="modal" data-bs-target="#modelId">
					  Ajouter Adherent
					</button>
					<a href="/biblio/export?rapport=listAdherent" target="_blank" class="btn btn-sm btn-primary">Export Rapport Adherent</a> 
				</div>
				
				<h3>Liste des adherents</h3>
				
				<!-- Modal -->
				<div class="modal fade" id="modelId" tabindex="-1" role="dialog" aria-labelledby="modelTitleId" aria-hidden="true">
				  <div class="modal-dialog modal-lg" role="document">
				    <div class="modal-content ">
				      <div class="modal-header ">
				        <h5 class="modal-title">Ajouter Un Adherent</h5>
				          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
				      </div>
				      <form method="post" action="/biblio/adherent">
				      <div class="modal-body">
				        <div class="row">
				        	<div class="col-sm-6">
				        		<div class="mb-3"> 
								  <input type="text" class="form-control" name="nom" id=""  placeholder="Nom"> 
								</div>
				        	</div>
				        	<div class="col-sm-6">
				        		<div class="mb-3"> 
								  <input type="text" class="form-control" name="prenom" id=""  placeholder="Prenom"> 
								</div>
				        	</div>
				        </div>
				         <div class="row">
				        	<div class="col-sm-6">
				        		<div class="mb-3"> 
								  <input type="text" class="form-control" name="cin_nif" id=""  placeholder="NIF / CIN"> 
								</div>
				        	</div>
				        	<div class="col-sm-6">
				        		<div class="mb-3"> 
								  <input type="date" class="form-control" name="date_naissance" id=""  placeholder="Date Naissance"> 
								</div>
				        	</div>
				        </div>
				         <div class="row">
				        	<div class="col-sm-6">
				        		<div class="mb-3"> 
								  <input type="text" class="form-control" name="adresse" id=""  placeholder="Adresse"> 
								</div>
				        	</div>
				        	<div class="col-sm-6">
				        		<div class="mb-3"> 
								  <input type="text" class="form-control" name="telephone" id=""  placeholder="Telephone"> 
								</div>
				        	</div>
				        </div>
				         <div class="row">
				        	<div class="col-sm-6">
				        		<div class="mb-3"> 
								  <input type="text" class="form-control" name="email" id=""  placeholder="Email"> 
								</div>
				        	</div>
				        	<div class="col-sm-6">
				        		<div class="mb-3"> 
								  <input type="text" class="form-control" name="profession" id=""  placeholder="Profession"> 
								</div>
				        	</div>
				        </div>
				         <div class="row">
				        	<div class="col-sm-6">
				        		<div class="mb-3"> 
								  <input type="text" class="form-control" name="statut" id=""  placeholder="Statut"> 
								</div>
				        	</div>
				        	<div class="col-sm-6">
				        		 <div class="btn-group" role="group" aria-label="Basic checkbox toggle button group">
								    <input type="radio"  class="btn-check" name="sexe" value="masculin" id="btncheck1" autocomplete="off">
								    <label class="btn btn-outline-primary" for="btncheck1">Masculin</label>
								  
								    <input type="radio" class="btn-check" name="sexe" value="feminin"  id="btncheck2" autocomplete="off">
								    <label class="btn btn-outline-info" for="btncheck2">Feminin</label>
								  </div>
				        	</div>
				        </div>

				      </div>
				      <div class="modal-footer">
				        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
				        <button type="submit" class="btn btn-primary">Save</button>
				      </div>
				      </form>
				    </div>
				  </div>
				</div>
            </div>
              <div class="card-body"> 
                <table id="example" class="table table-striped table-bordered nowrap" style="width:100%">
                  <thead>
                      <tr>
                          <th>#ID</th>
                          <th>NOM</th>
                          <th>Prenom</th>
                          <th>SEXE</th>
                          <th>EMAIL</th>
                          <th>ADRESSE</th>
                          <th>OCCUPATION</th>
                          <th>STATUT</th>
                          <th>OPTION</th>
                      </tr>
                  </thead>
                  <tbody>
                  <c:forEach  var="adherent" items="${listAdherent}"> 
                      <tr>
                          <td><c:out value="${adherent.id}"></c:out></td>
                          <td><c:out value="${adherent.nom}"></c:out></td>
                          <td><c:out value="${adherent.prenom}"></c:out></td>
                          <td><c:out value="${adherent.sexe}"></c:out></td>
                          <td><c:out value="${adherent.email}"></c:out></td>
                          <td><c:out value="${adherent.adresse}"></c:out></td>
                          <td><c:out value="${adherent.profession}"></c:out></td>
                          <td><c:out value="${adherent.statut}"></c:out></td>
                          <td>
                          		<form method="get" action="/biblio/editAdherent">
                          		<input type="hidden" name="id" value="${adherent.id }" />
                          			<button type="submit" class="btn btn-sm btn-primary">Plus d'info</button>
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