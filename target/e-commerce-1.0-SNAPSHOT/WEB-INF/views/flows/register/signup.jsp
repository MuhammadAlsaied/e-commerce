<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="../shared/header.jsp" %>   

<div id="content">
    <div id="container" >
        <div class="row">
            <div class="offset-md-1 col-md-10 offset-lg-2 col-lg-8">
                <div class="card">
                    <div class="card-header bg-info text-white">
                        <h4 class="card-title">Signup</h4>
                    </div>
                    <div class="card-body">

                        <form:form modelAttribute="user"  method="post"  >
                            <div class=" form-group row ">
                                <label for="username" class="col-md-2 col-form-label">Username</label>
                                <div class="col-md-10">
                                    <form:input type="text" path="username" id="username" placeholder="Enter username" class="form-control" />
                                    <form:errors path="username" cssClass="text-danger" element="em" />
                                </div>
                            </div>                          
                            <div class=" form-group row ">
                                <label for="password" class="col-md-2 col-form-label">Password</label>
                                <div class="col-md-10">
                                    <form:input type="password" path="password" id="password" placeholder="Enter your password" class="form-control" />
                                    <form:errors path="password" cssClass="text-danger" element="em" />
                                </div>
                            </div> 
                            <div class=" form-group row ">
                                <label for="confirm-password" class="col-md-2 col-form-label">Confirm password</label>
                                <div class="col-md-10">
                                    <form:input type="password" path="confirmPassword" id="confirm-password" placeholder="Rewrite your password" class="form-control" />
                                    <form:errors path="confirmPassword" cssClass="text-danger" element="em" />
                                </div>
                            </div> 

                            <div class="form-group row ">
                                <label for="email" class="col-md-2 col-form-label">E-mail</label>
                                <div class="col-md-10">
                                    <form:input type="email" path="email"  id="email" placeholder="Enter your email address" class="form-control" />
                                    <form:errors path="email" cssClass="text-danger" element="em" />
                                </div>
                            </div>  

                            <div class="form-group row ">
                                <label for="number" class="col-md-2 col-form-label">Phone number</label>
                                <div class="col-md-10">
                                    <form:input type="text" path="number" id="number" placeholder="Enter your phone number" class="form-control" />
                                    <form:errors path="number" cssClass="text-danger" element="em" />

                                </div>
                            </div>  

                            <form:hidden path="id" />
                            <form:hidden path="enabled" />
                            <form:hidden path="role" />


                            <div class="offset-md-2 col-md-8">   
                                <button name="_eventId_billing"  type="submit" class="btn btn-primary">
                                    Next <span class="fa fa-arrow-right"></span>
                                </button>
                            </div>



                        </form:form>

                    </div>
                </div>

            </div>

        </div>
    </div>
</div>


<!--Loading Footer -->
<%@include file="../../shared/footer.jsp" %>

</div>
</body>

</html>
