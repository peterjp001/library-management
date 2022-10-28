<%@ include file="Layout/Header.jsp"  %>
<%@ include file="Layout/Navbar.jsp"  %>
	 <main class="mt-2">
    <div class="container p-2">
        <div class="row ">
           <div class="col-md-12 fw-bold d-flex justify-content-between  rounded  text-light bg-dark">
               <h3>Utilisateurs</h3> <span>Nombre: <c:out value="${fn:length(listUser) }"></c:out></span>
           </div>
           <div class="col-sm-12 pt-2  ">
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
				<button type="button" class="btn btn-primary btn-sm" data-bs-toggle="modal" data-bs-target="#modelId">
				  Ajouter Utilisateur
				</button>
				
				<h3>Liste des Utilisateurs</h3>
				
				<!-- Modal -->
				<div class="modal fade" id="modelId" tabindex="-1" role="dialog" aria-labelledby="modelTitleId" aria-hidden="true">
				  <div class="modal-dialog" role="document">
				    <div class="modal-content ">
				      <div class="modal-header ">
				        <h5 class="modal-title">Ajouter Un Utilisateur</h5>
				          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
				      </div>
				      <form method="post" action="/biblio/user">
				      <div class="modal-body">
				   
				         <div class="row">
				        	<div class="col-sm-12">
				        		<div class="mb-3"> 
								  <input type="text" class="form-control" name="username" id="" aria-describedby="emailHelpId" placeholder="Nom Utilisateur"> 
								</div>
				        	</div>
				        	<div class="col-sm-12">
				        		<div class="mb-3"> 
								  <input type="password" class="form-control" name="password" id="" aria-describedby="emailHelpId" placeholder="Mot De Passe"> 
								</div>
				        	</div>
				        </div>
				         <div class="row">
				        	<div class="col-sm-12">
				        		<div class="mb-3"> 
								  <input type="password" class="form-control" name="cpassword" id="" aria-describedby="emailHelpId" placeholder="Mot De Passe Confirmation"> 
								</div>
				        	</div>
				        	<div class="col-ms-12">
				        		<label for="" class="form-label">Niveau</label>
							    <select class="form-select" name="niveau" id=""> 
							        <option value="standard">Standard</option>
							        <option value="admin">Administrateur</option> 
							    </select>
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
                      <tr class="text-center">
                          <th>#ID</th>
                          <th>Username</th>
                          <th>Niveau</th>
                          <th>Option</th> 
                      </tr>
                  </thead>
                  <tbody>
                  <c:forEach  var="user" items="${listUser}"> 
                      <tr class="text-center">
                          <td><c:out value="${user.id }"></c:out></td>
                          <td><c:out value="${user.username }"></c:out></td>
                          <td><c:out value="${user.niveau }"></c:out></td>
                          <td class="d-flex w-100 justify-content-center ">
                          	<form method="get" action="/biblio/editUser" class="me-2">
                          		<input type="hidden" name="id" value="${user.id }">
                          		<button  class="btn btn-sm btn-primary">Modifier</button>
                          	</form>
                          	<form method="post" action="/biblio/deleteUser" class="me-2">
                          	<input type="hidden" name="id" value="${user.id }">
                          		<button  class="btn btn-sm btn-danger">Supprimer</button>
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