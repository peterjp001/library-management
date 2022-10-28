<%@ include file="Layout/Header.jsp"  %>
<%@ include file="Layout/Navbar.jsp"  %>
	 <main class="mt-2">
    <div class="container p-2">
        <div class="row   ">
           <div class="col-md-12 fw-bold d-flex justify-content-between  rounded  text-light bg-dark">
               <h3>Utilisateur: <c:out value="${userData.username }" /> </h3>  
           </div>
           <div class="col-sm-12 pt-2 ">
           		<c:if test="${not empty message}"> 
				   <div class="alert alert-${type} text-center  alert-dismissible fade show" role="alert">
					  <strong></strong> <c:out value="${message }" />
					  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
					</div>
				</c:if>
           </div>
        </div> 
        <div class="row pt-3  d-flex justify-content-center">
          <div class="col-6 ">
            <div class="card">
            <div class="card-header d-flex justify-content-between">
				<h3>Info Connection <c:out value="${userData.username}" /></h3>
            </div>
              <div class="card-body"> 
                <form method="post" action="/biblio/editUser"> 
                <input type = "hidden" name="option" value="changeInfo" /> 
		         <div class="row">
		        	<div class="col-sm-12">
		        		<div class="mb-3"> 
						  <input type="text" class="form-control" name="username" value="${userData.username}"> 
						</div>
		        	</div>
		        	<div class="col-ms-12">
		        		<label for="" class="form-label">Niveau</label>
					    <select class="form-select" name="niveau" id=""> 
					        <option value="standard" ${userData.niveau == 'standard' ? 'selected' : '' }>Standard</option>
					        <option value="admin" ${userData.niveau == 'admin' ? 'selected' : '' }>Administrateur</option> 
					    </select>
		        	</div>
		        </div>
		        <input type = "hidden" name="id" value="${userData.id }" />
		        
			      <div class="modal-footer"> 
			        <button type="submit" class="btn btn-primary">Modifier</button>
			      </div>
		     </form>
              </div>
            </div>
          </div>
           <div class="col-6 ">
            <div class="card">
            <div class="card-header d-flex justify-content-between">
				<h3>Mot de passe</h3>
            </div>
              <div class="card-body"> 
                  <form method="post" action="/biblio/editUser"> 
                  <input type = "hidden" name="option" value="changePassword" /> 
		         <div class="row">
		        	 
		        	<div class="col-sm-12">
		        		<div class="mb-3"> 
						  <input type="password" class="form-control" name="password" id="" aria-describedby="emailHelpId" placeholder="Nouveau Mot De Passe"> 
						</div>
		        	</div>
		        	<div class="col-sm-12">
		        		<div class="mb-3"> 
						  <input type="password" class="form-control" name="cpassword" id="" aria-describedby="emailHelpId" placeholder="Mot De Passe confirmation"> 
						</div>
		        	</div> 
		        </div>
		        <input type = "hidden" name="id" value="${userData.id }" />
		        
			      <div class="modal-footer"> 
			        <button type="submit" class="btn btn-primary">Modifier</button>
			      </div>
		     </form>
              </div>
            </div>
          </div>
        </div>
    </div>
</main>
<%@ include file="Layout/Footer.jsp"  %>