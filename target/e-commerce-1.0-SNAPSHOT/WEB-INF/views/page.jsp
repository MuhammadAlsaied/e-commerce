<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="onlineshopping.dto.Category"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="assets" value="assets" />
<c:set var="root" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Online Shopping - ${title}</title>

        <script>
            window.title = '${title}';
            window.root = '${root}';

        </script>
        <!-- loading javascript files -->
        <script src="${root}/${assets}/js/jquery.min.js"></script>
        <script src="${root}/${assets}/js/bootstrap.bundle.min.js"></script>
        <script src="${root}/${assets}/js/bootbox.min.js"></script>
        <script type="text/javascript" src="https://cdn.datatables.net/v/dt/dt-1.10.18/r-2.2.2/datatables.min.js"></script>
        <script src="${root}/${assets}/js/app.js"></script>

        <!-- loading css fles -->
        <link href="${root}/${assets}/css/bootstrap.css" rel="stylesheet">        
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/dt/dt-1.10.18/r-2.2.2/datatables.min.css"/>
        <link href="${root}/${assets}/css/style.css" rel="stylesheet">

    </head>

    <body>
        <div id="wrapper">

            <div class="row mt-3"></div>

            <!-- Loading Navigation -->
            <%@include file="shared/nav.jsp" %>


            <!-- Loadung Page Content -->
            <div id="content">
                <c:if test="${home == true }">
                    <%@include file="home.jsp"%>
                </c:if> 

                <c:if test="${contact == true }">
                    <%@include file="contact.jsp"%>
                </c:if>     
                <c:if test="${about == true }">
                    <%@include file="about.jsp"%>
                </c:if>
                <c:if test="${listCategory == true or listProducts == true}">
                    <%@include file="listProducts.jsp"%>
                </c:if>
                <c:if test="${error == true}">
                    <%@include file="error.jsp"%>
                </c:if>
                <c:if test="${viewProduct == true}">
                    <%@include file="product.jsp"%>
                </c:if>  
                <c:if test="${manageProduct == true}">
                    <%@include file="manageProduct.jsp"%>
                </c:if>

                <c:if test="${login == true}">
                    <%@include file="login.jsp"%>
                </c:if>
                <c:if test="${viewCart == true}">
                    <%@include file="cart.jsp"%>
                </c:if>


            </div>



            <!--Loading Footer -->
            <%@include file="shared/footer.jsp" %>

        </div>
    </body>

</html>
