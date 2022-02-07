<%-- 
    Document   : userMessagge
    Created on : Jan 9, 2022, 2:13:02 AM
    Author     : pato
--%>

<%@include file="./partials/header.jsp" %>
        <%
            boolean isDeleted = (boolean) session.getAttribute("deleteMssg");
            if (isDeleted)  {
        %>
        
        <h1 class="m-5" >Usuario eliminado con éxito</h1>
        <a class="nav-link" href="/">Volver al inicio</a>
        
        <% 
            } else {
        %>
        
        <h1 class="m-5" >Hubo un error. Inténtelo nuevamente</h1>
        <a class="nav-link" href="/view/profile">Volver a intentarlo</a>
        <% 
            }  
        %>
        
<%@include file="./partials/footer.html" %>
