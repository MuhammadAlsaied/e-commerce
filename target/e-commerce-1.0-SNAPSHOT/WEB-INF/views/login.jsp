<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="onlineshopping.dto.Category"%>
<div class="container">
    <!-- /.col-lg-3 -->

    <div class="row">
        <div class="col-lg-3">
            <%@include file="shared/sidebar.jsp" %>
        </div>

        <div class="col-lg-6">
            <c:if test="${not empty message}"> 
                <div class="alert alert-danger">
                    <h5>${message}</h5>
                </div>
            </c:if>
            <form method="post" action="${root}/login">
                <div class=" form-group row ">
                    <label for="username" class="col-md-2 col-form-label">Email</label>
                    <div class="col-md-10">
                        <input type="email" name="username" id="username" placeholder="Enter your Email" class="form-control" />
                    </div>
                </div>
                <div class=" form-group row ">
                    <label for="password" class="col-md-2 col-form-label">Password</label>
                    <div class="col-md-10">
                        <input type="password" name="password" id="password" placeholder="Enter your password" class="form-control" />
                    </div>
                </div>
                <input type="submit" value="Sign in" class="btn btn-primary offset-md-2" />
            </form>
        </div>
    </div>
</div>