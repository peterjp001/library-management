<%@ include file="Layout/Header.jsp"  %>
<%@ include file="Layout/Navbar.jsp"  %>
	 <main class="mt-2">
    <div class="container p-2">
        <div class="row shadow ">
           <div class="col-md-12 fw-bold d-flex justify-content-between  rounded  text-light bg-dark">
               <h3>Livres</h3> 
           </div>
        </div>
        
        <div class="row row-cols-1 row-cols-sm-2 pt-3  row-cols-lg-3  mb-3">
          <div class="col" >
            <a href="#" class="text-decoration-none">
            <div class="card shadow">
              <div class="card-body text-dark">
                <div class="row">
                  <div class="col-sm-12"><h5>Livres</h5></div>
                  <div class="col-sm-12 d-flex justify-content-between text-center">
                    <h5><c:out value="${fn:length(listLivre) }"></c:out></h5><i class="bi bi-people"></i>
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
                  <div class="col-sm-12"><h5>Categories</h5></div>
                  <div class="col-sm-12 d-flex justify-content-between text-center">
                    <h5><c:out value="${nbrCat }"/></h5><i class="bi bi-person-badge-fill"></i>
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
                  <div class="col-sm-12"><h5>Auteurs</h5></div>
                  <div class="col-sm-12 d-flex justify-content-between text-center">
                    <h5><c:out value="${nbrAuteur }"/></h5><i class="bi bi-book"></i>
                  </div>
                </div>
              </div>
            </div>
            </a>
          </div>     
            
        </div>
        <div class="row pt-3">
        <div class="col-sm-12 pt-2">
           		<c:if test="${not empty message}"> 
				   <div class="alert alert-${type} text-center alert-dismissible fade show" role="alert">
					  <strong></strong> <c:out value="${message }" />
					  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
					</div>
				</c:if>
           </div>
          <div class="col-12 ">
            
            <div class="card">
            <div class="card-header ">
            
            	<!-- Button trigger modal -->
				<button type="button" class="btn btn-primary btn-sm" data-bs-toggle="modal" data-bs-target="#modelId">
				  Ajouter Livre
				</button>
				<a href="/biblio/export?rapport=listLivre" target="_blank" class="btn btn-sm btn-primary">Export Rapport Livre</a> 
				 
				<!-- Modal -->
				<div class="modal fade" id="modelId" tabindex="-1" role="dialog" aria-labelledby="modelTitleId" aria-hidden="true">
				  <div class="modal-dialog modal-lg" role="document">
				    <div class="modal-content ">
				      <div class="modal-header ">
				        <h5 class="modal-title">Ajouter Un Livre</h5>
				          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
				      </div>
				      <form method="post" action="">
				      <div class="modal-body">
				        <div class="row">
				        	<div class="col-sm-6">
				        		<div class="mb-3"> 
								  <input type="text" class="form-control" name="titre" id="" aria-describedby="emailHelpId" placeholder="Titre"> 
								</div>
				        	</div>
				        	<div class="col-sm-6">
				        		<div class="mb-3"> 
								  <input type="text" class="form-control" name="auteur" id="" aria-describedby="emailHelpId" placeholder="Auteur"> 
								</div>
				        	</div>
				        </div> 
				         <div class="row">
				        	<div class="col-sm-6">
				        		<div class="mb-3"> 
				        		<label>Date Parution</label>
								  <input type="date" class="form-control" name="date_parution" id="" aria-describedby="emailHelpId"  > 
								</div>
				        	</div>
				        	<div class="col-sm-6">
				        		<div class="mb-3"> 
								  <input type="text" class="form-control" name="categorie" id="" aria-describedby="emailHelpId" placeholder="Categorie"> 
								</div>
				        	</div>
				        </div> 
				         <div class="row">
				        	<div class="col-sm-6">
				        		<div class="mb-3"> 
								  <input type="number" class="form-control" name="quantite" id="" aria-describedby="emailHelpId" placeholder="quantite"> 
								</div>
				        	</div>
				        	<div class="col-sm-6">
				        		<div class="mb-3"> 
								  <input type="text" class="form-control" name="etat" id="" aria-describedby="emailHelpId" placeholder="Etat"> 
								</div>
				        	</div>
				        </div> 
				         <div class="row">
				        	 
				        	<div class="col-sm-12">
				        		<div class="mb-3"> 
								  <textarea class="form-control" name="resume" id="" rows="3" placeholder="Resume du livre"></textarea>
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
                          <th>#Numero</th>
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
                          <td><c:out value="${livre.id }"></c:out></td>
                          <td><c:out value="${livre.titre }"></c:out></td>
                          <td><c:out value="${livre.auteur }"></c:out></td>
                          <td><c:out value="${livre.date_parution }"></c:out></td>
                          <td><c:out value="${livre.categorie }"></c:out></td>
                          <td><c:out value="${livre.quantite }"></c:out></td>
                          <td><c:out value="${livre.etat }"></c:out></td>
                          <td>
                          	<a href="editLivre?id=${livre.id}" class="btn btn-sm btn-primary">Plus d'info</a>
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