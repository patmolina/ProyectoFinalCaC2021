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
               response.sendRedirect("/");
            }
            
            User user = (User) session.getAttribute("user");
            
        %>

<main class="container d-flex justify-content-center align-items-center gap-5" >
        <section class="left-hand">
            <img src="/img/usermodify.jpeg" />
        
            <p> Solo pueden modificarse los campos habilitados.</p>    
        </section>
        <form class="row g-3" method="POST" action="/user/modifyUser" enctype="application/x-www-form-urlencoded">
            <div class="col-md-6">
              <label for="name" class="form-label">Nombre: </label>
              <input type="text" class="form-control" id="name" name="name" value="<%out.println(user.getName());%>" disabled>
            </div>
            <div class="col-md-6">
              <label for="lastname" class="form-label">Apellido</label>
              <input type="text" class="form-control" id="lastname" name="lastname" value="<%out.println(user.getLastName());%>" disabled>
            </div>
            <div class="col-md-6">
              <label for="city" class="form-label">Ciudad</label>
              <input type="text" class="form-control" id="city" name="city" value="<%out.println(user.getCity());%>" required>
            </div>
            <div class="col-md-6">
              <label for="country" class="form-label">Pais</label>
              <input type="text" class="form-control" id="country" name="country" value="<%out.println(user.getCountry());%>" required>
            </div>
            <div class="col-md-8">
              <label for="username" class="form-label">e-mail</label>
              <div class="input-group has-validation">
                  <input type="email" class="form-control" id="email" name="email" value="<%out.println(user.getEmail());%>" aria-describedby="inputGroupPrepend" required>
              </div>
            </div>
            <div class="col-md-8">
              <label for="username" class="form-label">Usuario</label>
          <div class="input-group has-validation">
            <input type="text" class="form-control" id="username" name="username" value="<%out.println(user.getUsername());%>" disabled>
          </div>
        </div>
        <div class="col-md-6">
          <label for="password" class="form-label">Contraseña</label>
          <input type="password" class="form-control" id="password" name="password" value="<%out.println(user.getPassword());%>" required>
        </div>
        <div class="col-md-6">
          <label for="repassword" class="form-label">Repita Contraseña</label>
          <input type="password" class="form-control" id="repassword" name="repassword" value="<%out.println(user.getPassword());%>" required>
        </div>
        <div class="col-12">
          <button class="btn btn-primary" type="submit">Actualizar datos</button>
        </div>
       </form>
</main>
<%@include file="./partials/footer.html" %>
