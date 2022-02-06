<%-- 
    Document   : user
    Created on : Jan 2, 2022, 10:26:49 PM
    Author     : pato
--%>

<%@page import="database.UserDAO"%>
<%@page import="model.User"%>
<%@page import="java.util.*"%>



<%@include file="./partials/header.jsp"%>
   <section id="profileimg">
   </section>
   <div class="container"> 
        <%
            
            response.setHeader("Cache-Control", "no-cache, no-store, mustrevalidate");
            isLogged = (boolean) session.getAttribute("isLogin");
            if (!isLogged) {
               response.sendRedirect("/OnlineBankingLogin");
            }
          
            
            User userL = (User) session.getAttribute("userLogged");
           
            if (userL.getGender().equals("female")) {
 
        %>
        
        <h1 class="text-center">Bienvenida
       
        <% } else {
        %>

        <h1 class="text-center">Bienvenido

        <% }
        %>
        
        <%
            out.println(" " + userL.getName() + " " + userL.getLastName());
        %>
        !</h1>
    </div> 
      
    <div class ="container">
        <h2>Mis Datos</h2>
       
        <table class="table table-striped table-hover">
          
          <tbody>
            <tr>
              <td>Nombre</td>
              <td><%out.println(userL.getName());%></td>
              <td></td>
            </tr>
            <tr>  
              <td>Apellido</td>
              <td><%out.println(userL.getLastName());%></td>
              <td></td>
            </tr>
            <tr>  
              <td>Sexo</td>
              <td><%out.println(userL.getGender());%></td>
              <td></td>
            </tr>
            <tr>  
              <td>Ciudad</td>
              <td><%out.println(userL.getCity());%></td>
            </tr>
            <tr> 
              <td>Pais</td>
              <td><%out.println(userL.getCountry());%></td>
              <td></td>
            </tr>
            <tr>  
              <td>e-mail</td>
              <td><%out.println(userL.getEmail());%></td>
              <td></td>
            </tr>
            <tr>  
              <td>Usuario</td>
              <td><%out.println(userL.getUsername());%></td>
              <td></td>
            </tr>
            <tr>  
              <td>Contraseña</td>
              <td>*********</td>
              <td></td>
            </tr>
          </tbody>
        </table>
    </div>            
    <div class="container mx-auto">
        <a class="btn btn-dark" href="/user/updateUser">Modificar datos</a>
        <a class="btn btn-danger" href="/user/delete">Darse de Baja</a>
    </div> 
              
              
<%@include file="./partials/footer.html" %>
"