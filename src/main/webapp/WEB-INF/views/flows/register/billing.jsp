<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="../shared/header.jsp" %>   

<div id="content">
    <div id="container" >
        <div class="row">
            <div class="offset-md-1 col-md-10 offset-lg-2 col-lg-8">
                <div class="card">
                    <div class="card-header bg-info text-white">
                        <h4 class="card-title">Billing Address</h4>
                    </div>
                    <div class="card-body">

                        <form:form modelAttribute="billing" method="post"  >
                            <div class=" form-group row ">
                                <label for="country" class="col-md-2 col-form-label">Country</label>
                                <div class="col-md-10">
                                    <form:input type="text" path="country" id="country" placeholder="Enter country" class="form-control" />
                                    <form:errors path="country" cssClass="text-danger" element="em" />
                                </div>
                            </div>                          
                            <div class=" form-group row ">
                                <label for="state" class="col-md-2 col-form-label">State</label>
                                <div class="col-md-10">
                                    <form:input type="text" path="state" id="state" placeholder="Enter state" class="form-control" />
                                    <form:errors path="state" cssClass="text-danger" element="em" />
                                </div>
                            </div>                          
                            <div class=" form-group row ">
                                <label for="city" class="col-md-2 col-form-label">City</label>
                                <div class="col-md-10">
                                    <form:input type="text" path="city" id="city" placeholder="Enter city" class="form-control" />
                                    <form:errors path="city" cssClass="text-danger" element="em" />
                                </div>
                            </div>                          
                            <div class=" form-group row ">
                                <label for="street" class="col-md-2 col-form-label">Street</label>
                                <div class="col-md-10">
                                    <form:input type="text" path="street" id="street" placeholder="Enter street" class="form-control" />
                                    <form:errors path="street" cssClass="text-danger" element="em" />
                                </div>
                            </div>
                            <div class=" form-group row ">
                                <label for="postalCode" class="col-md-2 col-form-label">Postal code</label>
                                <div class="col-md-10">
                                    <form:input type="text" path="postalCode" id="postalCode" placeholder="Enter postal code" class="form-control" />
                                    <form:errors path="postalCode" cssClass="text-danger" element="em" />
                                </div>
                            </div>                                                   

                            <form:hidden path="id" />

                            <div class="offset-md-2 col-md-8">   
                                <Button name="_eventId_signup"  type="submit" class="btn btn-primary">
                                    <span class="fa fa-arrow-left"></span> Back
                                </button>
                                <button name="_eventId_confirm"  type="submit" class="btn btn-primary">
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
