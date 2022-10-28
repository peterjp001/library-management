<%@ include file="Layout/Header.jsp"  %>
<%@ include file="Layout/Navbar.jsp"  %>
	 <main class="mt-2">
    <div class="container p-2">
        <div class="row   ">
           <div class="col-md-12 fw-bold d-flex justify-content-between  rounded  text-light bg-dark">
               <h3>Livre: <c:out value="${livreData.titre }" /> </h3>  
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
        <div class="modal-body">
	       <form method="post" action="" accept-charset="character_set"> 
	       <input type="hidden" name="id" value="${livreData.id }">
		        <div class="row">
		        	<div class="col-sm-6">
		        		<div class="mb-3"> 
		        		<label>Titre</label>
						  <input type="text" class="form-control" name="titre"  value="${livreData.titre }"> 
						</div>
		        	</div>
		        	<div class="col-sm-6">
		        		<div class="mb-3"> 
		        		<label>Auteur</label>
						  <input type="text" class="form-control" name="auteur" value="${livreData.auteur }"> 
						</div>
		        	</div>
		        </div> 
		         <div class="row">
		        	<div class="col-sm-6">
		        		<div class="mb-3"> 
		        		<label>Date Parution</label>
						  <input type="date" class="form-control" name="date_parution" value="${livreData.date_parution }"   > 
						</div>
		        	</div>
		        	<div class="col-sm-6">
		        		<div class="mb-3"> 
		        		<label>Categorie</label>
						  <input type="text" class="form-control" name="categorie"  value="${livreData.categorie }"> 
						</div>
		        	</div>
		        </div> 
		         <div class="row">
		        	<div class="col-sm-6">
		        		<div class="mb-3">
		        		<label>Quantite</label> 
						  <input type="number" class="form-control" name="quantite"  value="${livreData.quantite }"> 
						</div>
		        	</div>
		        	<div class="col-sm-6">
		        		<div class="mb-3"> 
		        		<label>Etat</label>
						  <input type="text" class="form-control" name="etat"  value="${livreData.etat }"> 
						</div>
		        	</div>
		        </div> 
		         <div class="row">
		        	 
		        	<div class="col-sm-12">
		        		<div class="mb-3"> 
		        		<label>Resume</label>
						  <textarea class="form-control" name="resume" id="" rows="6" placeholder="Resume du livre"><c:out value="${livreData.resume }"/></textarea>
						</div>
		        	</div>
		        </div> 
		 
		      <div class="modal-footer"> 
		        <button type="submit" class="btn btn-primary">Modifier</button>
		      </div>
		    </form>

	    </div>
    </div>
</main>
<%@ include file="Layout/Footer.jsp"  %>