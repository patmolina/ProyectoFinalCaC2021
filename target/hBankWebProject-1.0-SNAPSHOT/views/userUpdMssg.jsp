<%-- 
    Document   : userUpdMssg
    Created on : Feb 7, 2022, 7:49:33 PM
    Author     : pato
--%>

<%@include file="./partials/header.jsp" %>
        <%
            boolean isUpdated = (boolean) session.getAttribute("updateMssg");
            if (isUpdated)  {
        %>
        
        <h1 class="m-5" >Perfil actualizado con éxito</h1>
        <a class="nav-link" href="/user/profile">Volver al Perfil</a>
        
        <% 
            } else {
        %>
        
        <h1 class="m-5" >Hubo un error. Inténtelo nuevamente</h1>
        <a class="nav-link" href="/user/profile">Volver a intentarlo</a>
        <% 
            }  
        %>
        
<%@include file="./partials/footer.html" %>