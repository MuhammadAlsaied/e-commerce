<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="onlineshopping.dto.Category"%>
<div class="container">

   <div class="row">
        <div class="col-lg-3">
            <%@include file="shared/sidebar.jsp" %>
        </div>
        <!-- /.col-lg-3 -->

        <div class="col-lg-9">

            <div id="products" class="row">

                <c:forEach items="${products}" var="product">

                    <div class="col-lg-4 col-md-6 mb-4">
                        <div class="card h-100">
                            <a href="${root}/view/${product.id}"><img  class="card-img-top" src="${root}/${assets}/images/${product.imageURL}" alt="${product.name}"></a>
                            <div class="card-body">
                                <h4 class="card-title">
                                    <a href="${root}/view/${product.id}">${product.name}</a>
                                </h4>
                                <p class="card-text">${product.description}</p>

                            </div>
                            <div class="card-footer">
                                <h5>${product.price}</h5>

                            </div>
                        </div>
                    </div>



                </c:forEach>

            </div>

        </div>
        <!-- /.col-lg-9 -->

    </div>

</div>