<%@ include file="Layout/Header.jsp"  %>
<%@ include file="Layout/Navbar.jsp"  %>
	 <main class="mt-2">
    <div class="container p-2">
        <div class="row  ">
            <div class="col-md-12 fw-bold  fs-3 rounded  text-light bg-dark">
                Pret
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
        <div class="container p-2"> 
   			<div class="row">
   				<div class="col-sm-6">
   					<div class="card">
		   		<div class="card-header">Informations du Livre</div>
		   		   <div class="card-body"> 
						      <div class="modal-body">
						      		<input type="hidden">
							           <div class="row g-3 mb-3">
									  <div class="col">
									  <label>Titre</label><br>
									    <input type="text" class="form-control"  disabled value="${livreData.titre}"   >
									  </div>
									  <div class="col">
									  <label>Auteur</label><br>
									    <input type="text" class="form-control" disabled value="${livreData.auteur}"   >
									  </div>
								  </div> 
								  <div class="row g-3 mb-3">
									  <div class="col">
									  <label>Categorie</label><br>
									      <input type="text" class="form-control" disabled value="${livreData.categorie}"  >
									  </div>
									  <div class="col">
									  <label>Etat</label><br>
									    <input type="text" class="form-control" disabled value="${livreData.etat}"  >
									  </div>
								  </div> 
								  <div class="row g-3 mb-3">
									  <div class="col">
									  <label>Date Parution</label><br>
									    <input type="date" class="form-control" disabled  value="${livreData.date_parution}">
									  </div>
									  <div class="col">
									  <label>Quantite</label><br>
									    <input type="number" class="form-control" disabled value="${livreData.quantite}">
									  </div>
								  </div>
								   <div class="row g-3 mb-3">
									  <div class="col"> 
									  <label>Resume</label><br>
									    <textarea  style="height: 200px" disabled class="form-control" ><c:out value="${livreData.resume}"></c:out></textarea>
									  </div> 
								  </div>  
						      </div> 
		   			</div>
		   		</div>
		   		
   				</div>
   				<div class="col-sm-6">
   					<div class="card">
		   		<div class="card-header">Informations de l'adherent</div>
		   		   <div class="card-body">
		   				<form   method="POST">
						      <div class="modal-body">
					      		 <div class="mb-3">
					      		 <input type="hidden" name = "idLivre" value="${livreData.id}">
					      		 <input type="hidden" name = "quantite" value="${livreData.quantite}">
								    <input type="text" class="form-control" placeholder="Nom" name="nom"  >
								  </div>
								  <div class="mb-3">
								    <input type="text" class="form-control" placeholder="Prenom"   name="prenom">
								  </div>
								  <div class="mb-3">
									    <input type="text" class="form-control" placeholder="Telephone"   name="telephone">
									  </div> 
								<div class="mb-3">
								<label>Date Pret</label><br>
								    <input type="date" class="form-control" name="date_pret">
								  </div> 
								  <div class="mb-3">
								  <label>Date Retour</label><br>
								    <input type="date" class="form-control" name="date_retour">
								  </div> 
						      </div> 
						      <div class="modal-footer"> 
						        <button type="submit" class="btn btn-primary">Save</button>
						      </div>
						      </form>	
		   			</div>
		   		</div>
		   		
   				</div>
   			</div>
   				 
   		</div>
    </div>
</main>
<%@ include file="Layout/Footer.jsp"  %>