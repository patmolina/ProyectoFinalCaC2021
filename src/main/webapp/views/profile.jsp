<%-- 
    Document   : user
    Created on : Jan 2, 2022, 10:26:49 PM
    Author     : pato
--%>

<%@include file="./partials/header.jsp" %>
        <% 
            isLogged = (boolean) session.getAttribute("isLogin");
            if (!isLogged) {
               response.sendRedirect("/");
            }
        %>
        
        
        <h1 class="m-5" >Bienvenido a tu perfil</h1>
        
                    
       
<%@include file="./partials/footer.html" %>
