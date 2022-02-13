<%-- 
    Document   : modifyUser
    Created on : Jan 11, 2022, 6:34:34 PM
    Author     : pato
--%>

<%@page import="model.User"%>
<%@include file="./partials/header.jsp" %>
<%
            isLogged = (boolean) session.getAttribute("isLogin");
            if (!isLogged) {
               response.sendRedirect("/login");
            }
            
            
            User userMod = (User) session.getAttribute("userLogged");
            
        %>

<main class="container d-flex justify-content-center align-items-center gap-5" >
        <section class="left-hand">
            <img src="/img/usermodify.jpeg" />
        
            <p> Solo pueden modificarse los campos habilitados. Posici�nese sobre el campo que precise modificar y escriba el nuevo valor.</p>    
        </section>
        <form class="row g-3" method="POST" action="/user/updateUser" enctype="application/x-www-form-urlencoded">
            <div class="col-md-6">
              <label for="id" class="form-label">User Id: </label>
              <input type="text" class="form-control" id="id" name="id" value="<%out.println(userMod.getUserID());%>" disabled>
            </div>
            <div class="col-md-6">
              <label for="name" class="form-label">Nombre: </label>
              <input type="text" class="form-control" id="name" name="name" value="<%out.println(userMod.getName());%>" disabled>
            </div>
            <div class="col-md-6">
              <label for="lastname" class="form-label">Apellido</label>
              <input type="text" class="form-control" id="lastname" name="lastname" value="<%out.println(userMod.getLastName());%>" disabled>
            </div>
            <div class="col-md-6">
              <label for="city" class="form-label">Ciudad</label>
              <input type="text" class="form-control" id="city" name="city" value="<%out.println(userMod.getCity());%>" required>
            </div>
            <div class="col-md-6">
              <label for="country" class="form-label">Pais</label>
              <input type="text" class="form-control" id="country" name="country" value="<%out.println(userMod.getCountry());%>" required>
            </div>
            <div class="col-md-8">
              <label for="email" class="form-label">e-mail</label>
              <div class="input-group has-validation">
                  <input type="email" class="form-control" id="email" name="email" value="<%out.println(userMod.getEmail());%>" aria-describedby="inputGroupPrepend" required>
              </div>
            </div>
            <div class="col-md-8">
              <label for="username" class="form-label">Usuario</label>
          <div class="input-group has-validation">
            <input type="text" class="form-control" id="username" name="username" value="<%out.println(userMod.getUsername());%>" disabled>
          </div>
        </div>
        <div class="col-md-6">
          <label for="password" class="form-label">Contrase�a</label>
          <input type="password" class="form-control" id="password" name="password" value="<%out.println(userMod.getPassword());%>" required>
        </div>
        <div class="col-md-6">
          <label for="repassword" class="form-label">Repita Contrase�a</label>
          <input type="password" class="form-control" id="repassword" name="repassword" value="<%out.println(userMod.getPassword());%>" required>
        </div>
        <div class="col-12">
          <button class="btn btn-primary" type="submit">Actualizar datos</button>
        </div>
       </form>
        
          <% session.setAttribute("ID", userMod.getUserID());%>
</main>
<%@include file="./partials/footer.html" %>
