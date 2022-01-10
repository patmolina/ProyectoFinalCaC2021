<%-- 
    Document   : login
    Created on : Jan 8, 2022, 6:25:30 PM
    Author     : pato
--%>

<%@include file="./partials/header.jsp" %>
    <main  class="container d-flex flex-column align-items-center gap-2 justify-content-center" >
         <h1 class="text-center mb-3">Online banking</h1>
            <h2 class="text-center mb-5">Ingresá a tu cuenta:</h2>
        <div id="login-main" class=" d-flex justify-content-center align-items-center">
            <section class="left-hand">
                <img src="/img/login.jpg"/>
            </section>
            <form method="POST" action="/user/login" class="bg-light p-5 rounded">
                <div class="mb-3">
                  <label for="user" class="form-label">Usuario</label>
                  <input type="text" class="form-control" id="user" name="user" >
                  <div class="form-text">Sus datos nunca serán compartidos con terceros</div>
                </div>
                <div class="mb-3">
                  <label for="password" class="form-label">Contraseña</label>
                  <input type="password" class="form-control" name="password" id="password">
                </div>
                <div class="mb-3 form-check">
                  <input type="checkbox" class="form-check-input" id="exampleCheck1">
                  <label class="form-check-label" for="exampleCheck1">Recordar mi usuario</label>
                </div>
                <div class="row align-items-center justify-content-between">
                    <div class="col-auto">
                        <button type="submit" class="btn btn-dark">Ingresar</button>
                    </div>
                    <div class="col-auto">
                        <a href="/view/register" class="link-primary">No tengo cuenta</a>
                    </div>
                </div>
            </form>
        </div>
    </main>
<%@include file="./partials/footer.html" %>
