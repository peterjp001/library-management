<%@ include file="Layout/Header.jsp"  %>
<%@ include file="Layout/Navbar.jsp"  %>
	 <main class="mt-2">
    <div class="container p-2">
        <div class="row   ">
           <div class="col-md-12 py-3 fw-bold d-flex justify-content-between  rounded  text-light bg-dark">
               <h3>Adherent: <c:out value="${adherentData.nom }" /> <c:out value="${adherentData.prenom}" /> </h3>
                
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
	        <form  method="post" action="">
	        	<div class="row">
	        	<div class="col-sm-6">
	        		<div class="mb-3"> 
	        			<label>Nom</label>
					  <input type="text" class="form-control" name="nom" id=""  value="${adherentData.nom }"> 
					</div>
	        	</div>
	        	<div class="col-sm-6">
	        		<div class="mb-3"> 
	        			<label>Prenom</label>
					  <input type="text" class="form-control" name="prenom" id=""  value="${adherentData.prenom }"> 
					</div>
	        	</div>
	        </div>
	         <div class="row">
	        	<div class="col-sm-6">
	        		<div class="mb-3">
	        			<label>CIN / NIF</label> 
					  <input type="text" class="form-control" name="cin_nif" id=""  value="${adherentData.cin_nif }"> 
					</div>
	        	</div>
	        	<div class="col-sm-6">
	        		<div class="mb-3"> 
	        			<label>Date Naissance</label>
					  <input type="date" class="form-control" name="date_naissance" id=""  value="${adherentData.date_naissance }"> 
					</div>
	        	</div>
	        </div>
	         <div class="row">
	        	<div class="col-sm-6">
	        		<div class="mb-3"> 
	        			<label>Adresse</label>
					  <input type="text" class="form-control" name="adresse" id=""  value="${adherentData.adresse }"> 
					</div>
	        	</div>
	        	<div class="col-sm-6">
	        		<div class="mb-3"> 
	        		<label>Telephone</label>
					  <input type="text" class="form-control" name="telephone" id=""  value="${adherentData.telephone }"> 
					</div>
	        	</div>
	        </div>
	         <div class="row">
	        	<div class="col-sm-6">
	        		<div class="mb-3"> 
	        		<label>Email</label>
					  <input type="text" class="form-control" name="email" id=""  value="${adherentData.email }"> 
					</div>
	        	</div>
	        	<div class="col-sm-6">
	        		<div class="mb-3"> 
	        		<label>Profession</label>
					  <input type="text" class="form-control" name="profession" id=""  value="${adherentData.profession }"> 
					</div>
	        	</div>
	        </div>
	         <div class="row">
	        	<div class="col-sm-6">
	        		<div class="mb-3">
	        		<label>Statut</label> 
					  <input type="text" class="form-control" name="statut" id=""  value="${adherentData.statut}"> 
					</div>
	        	</div>
	        	<div class="col-sm-6">
	        	<label>Sexe</label><br>
	        		 <div class="btn-group" role="group" aria-label="Basic checkbox toggle button group">
					    <input type="radio" ${adherentData.sexe == 'masculin' ? 'checked' : '' }  class="btn-check" name="sexe" value="masculin" id="btncheck1" autocomplete="off">
					    <label class="btn btn-outline-primary" for="btncheck1">Masculin</label>
					  
					    <input type="radio" ${adherentData.sexe == 'feminin' ? 'checked' : '' } class="btn-check" name="sexe" value="feminin"  id="btncheck2" autocomplete="off">
					    <label class="btn btn-outline-info" for="btncheck2">Feminin</label>
					  </div>
	        	</div>
	        </div>
	        <div class="row ">
	        	<div class="col-sm-12 ">
	        		<button class="btn btn-primary" type="submit">Modifier</button>
	        	</div>
	        </div>
	        </form>

	    </div>
    </div>
</main>
<%@ include file="Layout/Footer.jsp"  %>