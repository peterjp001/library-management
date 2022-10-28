<%@ include file="Layout/Header.jsp"  %>
  <% 
  
  if(session.getAttribute("username") != null ) {
		response.sendRedirect("/biblio/home.jsp");
	} 
  
  %>
<link rel="stylesheet" href="assets/style.css">
	<div class="login-container">
		<div class="login-body">
			<div  class="text-center">
			
				<main class="form-signin">
				  <form method="post" action="/biblio/auth">
				    <img class="mb-4" src="assets/img/logo-UNEPH.png" alt="" width="100" height="100">
				    <h1 class="h3 mb-3 fw-normal">UNEPH | Gestion Bibliotheque</h1>
					<c:if test="${not empty message}">
					   <div class="alert bg-danger"><c:out value="${message }" /></div>
					</c:if>
				    <div class="form-floating">
				      <input type="text" name="username" class="form-control" id="floatingInput" placeholder="name@example.com">
				      <label for="floatingInput">Nom Utilisateur</label>
				    </div>
				    <div class="form-floating">
				      <input type="password" name="password" class="form-control" id="floatingPassword" placeholder="Password">
				      <label for="floatingPassword">Mot De Passe</label>
				    </div>
				 
				    <button class="w-100 btn btn-lg btn-primary" type="submit">Connection</button>
				    <p class="mt-5 mb-3 text-muted">2022</p>
				  </form>
				</main>
			</div>
		</div>
	</div>
<%@ include file="Layout/Footer.jsp"  %>

<style>

@charset "UTF-8";

.login .row{
	top:40%;
	background-color:red;
}

.login-container,
.login-body {
  height: 100%;
}

.login-body {
  display: flex;
  align-items: center;
  justify-content:center;
  padding-top: 40px;
  padding-bottom: 40px;
  background-color: #f5f5f5;
}

.form-signin {
  width: 100%;
  /*max-width: 330px;*/
  padding: 15px;
  margin: auto;
}

.form-signin .checkbox {
  font-weight: 400;
}

.form-signin .form-floating:focus-within {
  z-index: 2;
}

.form-signin input[type="email"] {
  margin-bottom: -1px;
  border-bottom-right-radius: 0;
  border-bottom-left-radius: 0;
}

.form-signin input[type="password"] {
  margin-bottom: 10px;
  border-top-left-radius: 0;
  border-top-right-radius: 0;
}

</style>