<%@page import="onlineshopping.dto.CartItem"%>
<%@page import="onlineshopping.model.UserModel"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
        <a class="navbar-brand" href="${root}/home">Online Shopping</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav mr-auto">

                <li id="home" class="nav-item">
                    <a class="nav-link" href="${root}/home">Home

                    </a>
                </li>
                <li id="about" class="nav-item">
                    <a class="nav-link" href="${root}/about">About</a>

                </li>
                <li id="list_products" class="nav-item">
                    <a class="nav-link" href="${root}/list/all">View products</a>              
                </li>
                <li id="contact" class="nav-item">
                    <a class="nav-link" href="${root}/contact">Contact</a>             
                </li>

            </ul>
            <
            <ul class="navbar-nav ml-auto">
                <security:authorize access="hasAuthority('admin')">
                    <li id="admin" class="nav-item">
                        <a class="nav-link" href="${root}/admin-panel/">Admin Panel</a>             
                    </li>
                </security:authorize>
                <security:authorize access="isAuthenticated()">
                    <li class="dropdown" > 
                        <a class="btn btn-dark dropdown-toggle" href="javascript:void(0)" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                            ${userModel.username}
                            <span class="caret"></span>
                        </a>
                        <ul class=" dropdown-menu" aria-labelledby="dropdownMenu1">
                            <security:authorize access="hasAuthority('user')">
                            
                                <li class="dropdown-item" id="cart">
                                    <a class="text-muted" href="${root}/cart/show">
                                        <span class="fa fa-shopping-cart"></span>&#160;<span class="badge badge-primary">${fn:length( userModel.cart.cartItems)}</span> - ${price} EGP
                                    </a> 
                                </li>		     
                                <li role="separator" class="divider"></li>	
                                </security:authorize>
                            <li class="dropdown-item" id="logout">
                                <a class="text-muted" href="${root}/logout">Logout</a>
                            </li>                    			    	
                        </ul>		
                    </li>  
                </security:authorize>
                <security:authorize  access="isAnonymous()">
                    <li id="register" class="nav-item">
                        <a class="nav-link" href="${root}/register">Register</a>             
                    </li>    
                    <li id="login" class="nav-item">
                        <a class="nav-link" href="${root}/login">Login</a>             
                    </li>
                </security:authorize>
            </ul>
        </div>

    </div>
</nav>
