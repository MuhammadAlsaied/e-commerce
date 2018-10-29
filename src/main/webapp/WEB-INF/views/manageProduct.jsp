<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="container">
    <c:if test="${not empty message}" >
        <div class="row">
            <div class="col-xs-12 offset-md-2 col-md-8">
                <div class="alert alert-success alert-dismissible">${message}</div>
            </div>
        </div>
    </c:if>

    <div class="row">
        <div class="offset-md-2 col-md-8">
            <div class="card">
                <div class="card-header bg-info text-white">
                    <h4 class="card-title">Manage product</h4>
                </div>
                <div class="card-body">

                    <form:form modelAttribute="product" action="${root}/admin-panel/product"
                               method="post"  enctype="multipart/form-data" >
                        <div class=" form-group row ">
                            <label for="name" class="col-md-2 col-form-label">Name</label>
                            <div class="col-md-10">
                                <form:input type="text" path="name" id="name" placeholder="Enter product name" class="form-control" />
                                <form:errors path="name" cssClass="text-danger" element="em" />
                            </div>
                        </div> 
                        <div class="form-group row ">
                            <label for="category" class="col-md-2 col-form-label">Category</label>
                            <div class="col-md-10">
                                <form:select type="text" path="categoryId" id="categoryId" class="form-control"
                                             items="${categories}" itemLabel="name" itemValue="id"
                                             />

                            </div>
                        </div>  
                        <div class="form-group row ">
                            <label for="brand" class="col-md-2 col-form-label">Brand</label>
                            <div class="col-md-10">
                                <form:input type="text" path="brand"  id="brand" placeholder="Enter product brand" class="form-control" />
                                <form:errors path="brand" cssClass="text-danger" element="em" />
                            </div>
                        </div>  
                        <div class="form-group row ">
                            <label for="description" class="col-md-2 col-form-label">Description</label>
                            <div class="col-md-10">
                                <form:textarea id="description" path="description" rows="4" placeholder="Enter product description" class="form-control" />
                                <form:errors path="description" cssClass="text-danger" element="em" />
                            </div>
                        </div>  
                        <div class="form-group row ">
                            <label for="price" class="col-md-2 col-form-label">Price</label>
                            <div class="col-md-10">
                                <form:input type="number" path="price" id="price" placeholder="Enter product price" class="form-control" />
                                <form:errors path="price" cssClass="text-danger" element="em" />
                            </div> 

                        </div> 
                        <div class="form-group row ">
                            <label for="quantity" class="col-md-2 col-form-label">Quantity</label>
                            <div class="col-md-10">
                                <form:input type="number" path="quantity" id="quantity" placeholder="Enter product quantity" class="form-control" />
                            </div>


                        </div>  
                        <div class="form-group row ">
                            <label for="image" class="col-md-2 col-form-label">Product image</label>
                            <div class="col-md-10">
                                <form:input type="file" path="image" id="image" class="form-control" />
                                <form:errors path="image" cssClass="text-danger" element="em" />
                            </div> 

                        </div> 
                        <form:hidden path="id" />
                        <form:hidden path="active" />
                        <form:hidden path="views" />
                        <form:hidden path="purchases" />
                        <form:hidden path="imageURL" />
                        <div class="text-right">
                            <button type="button" class="btn btn-warning btn-sm" data-toggle="modal" data-target="#myCategoryModal">Add New Category</button>
                        </div>

                        <div class="offset-md-2 col-md-8">   
                            <input  type="submit" class="btn btn-success" value="Submit"  />
                        </div>



                    </form:form>

                </div>
            </div>


        </div>

    </div>

    <div class="row">


        <div class='offset-xl-2 col-xs-8'>

            <h1>Available Products</h1>
            <hr/>
            <table id="productsTable" class="table table-condensed table-bordered">

                <thead>					
                    <tr>					
                        <th>Id</th>
                        <th>&#160;</th>
                        <th>Name</th>
                        <th>Brand</th>
                        <th>Qty. Avail</th>
                        <th>Unit Price</th>
                        <th>Activate</th>				
                        <th>Edit</th>
                    </tr>					
                </thead>

                <tfoot>
                    <tr>					
                        <th>Id</th>
                        <th>&#160;</th>
                        <th>Name</th>
                        <th>Brand</th>
                        <th>Qty. Avail</th>
                        <th>price</th>
                        <th>Activate</th>				
                        <th>Edit</th>
                    </tr>									
                </tfoot>


            </table>


        </div>


    </div>
</div>
<!-- Modal -->
<div class="modal fade" id="myCategoryModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Add a new category</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form method="post" action="${root}/admin-panel/category/add">
                    <div class="form-group">
                        <label for="cat-name" class="col-form-label">Name</label>
                        <input required="required" type="text" placeholder="write name" class="form-control" name="cat-name">
                    </div>
                    <div class="form-group">
                        <label for="cat_description" class="col-form-label">Description</label>
                        <textarea class="form-control" placeholder="write description" name="cat-description"></textarea>
                    </div>
                    <input type="submit" value="add" class="btn btn-primary" />
                </form>
            </div>
            <div class="modal-footer">
            </div>
        </div>
    </div>
</div>