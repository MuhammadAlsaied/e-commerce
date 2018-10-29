<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="../shared/header.jsp" %>   

<div id="content">
    <div id="container" >
        <div class="row">
            <div class="col-md-1"></div>
            <div class="col-md-5">
                <div class="card">
                    <div class="card-header bg-info text-white">
                        <h4 class="card-title">Personal information</h4>
                    </div>
                    <div class="card-body">
                        <h5>${registerModel.user.username} </h5>
                        <h5>${registerModel.user.email} </h5>
                        <h5>${registerModel.user.number} </h5>
                    </div>
                    <div class="card-footer">
                        <a href="${flowExecutionUrl}&_eventId_signup" class="btn btn-primary">
                            Edit
                        </a>
                    </div>  
                </div>

            </div>

            <div class="col-md-5">
                <div class="card">
                    <div class="card-header bg-info text-white">
                        <h4 class="card-title">Billing address</h4>
                    </div>
                    <div class="card-body">
                        <h5>${registerModel.address.street}, ${registerModel.address.city} </h5>
                        <h5>${registerModel.address.state}, ${registerModel.address.country}</h5>
                        <h5>${registerModel.address.postalCode} </h5>

                    </div>
                    <div class="card-footer">
                        <a href="${flowExecutionUrl}&_eventId_billing" class="btn btn-primary">
                            Edit
                        </a>
                    </div>
                </div>
            </div>
            <div class="col-md-1"></div>
        </div>
        <div class="row mt-3" ></div>
        <div class="row">
            <div class="text-center offset-5 col-2">
                <a class="btn btn-primary" href="${flowExecutionUrl}&_eventId_submit">
                    Submit
                </a>
            </div>
        </div>
    </div>
</div>


<!--Loading Footer -->
<%@include file="../../shared/footer.jsp" %>

</div>
</body>

</html>
