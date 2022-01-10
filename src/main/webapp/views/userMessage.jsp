<%-- 
    Document   : userMessagge
    Created on : Jan 9, 2022, 2:13:02 AM
    Author     : pato
--%>

<%@include file="./partials/header.jsp" %>
        <% 
            boolean isCreated = (boolean) session.getAttribute("createMessage");
            if (isCreated) {
               
        %>
        
        <h1 class="m-5" >Usuario creado con éxito</h1>
        <a class="nav-link" href="/view/login">Ingresar a tu cuenta</a>
        
        <% 
            } else {
        %>
        
        <h1 class="m-5" >Hubo un error. Inténtelo nuevamente</h1>
        <a class="nav-link" href="/view/register">Volver a intentarlo</a>

        <%  
            }
        %>
       
<%@include file="./partials/footer.html" %>
