<%-- 
    Document   : product
    Created on : Oct 4, 2018, 1:56:21 PM
    Author     : Muhammed Alsaied
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
`
<div class="container">
    <div class="row">
        <div class="col-lg-3">
            <%@include file="shared/sidebar.jsp" %>
        </div>

        <div class="row col-lg-9">

            <div class="col-xs-12 col-sm-4">
                <img class="img img-responsive img-thumbnail " src="${root}/${assets}/images/${product.imageURL}" alt="${product.name}" />

            </div>
            <div class="col-xs-12 col-sm-8">
                <h2>${product.name}</h2>
                <hr>
                <p>${product.description}</p>
                <hr>
                <h5>${product.price}</h5>
                <hr>
                <div class="row mt-3"></div>
                <c:choose >
                    <c:when test="${product.quantity <1}">
                        <a class=" btn btn-success disabled" href="javascript:void(0)"><s>Add to cart
                                <span class="fa fa-shopping-cart"></span></s></a>
                        <span class="text-danger">Sorry! This product is out of stook!</span>
                    </c:when>
                    <c:otherwise>
                        <a class="btn btn-success" href="javascript:void(0)"><span class="fa fa-shopping-cart"></span> Add to cart</a>
                    </c:otherwise>
                </c:choose>
            </div>

        </div>
    </div>

</div>
