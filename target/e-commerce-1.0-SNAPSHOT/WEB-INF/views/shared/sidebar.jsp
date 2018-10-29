<h3 class="my-4">Online Shopping</h3>   
<div class="list-group">
    <c:forEach items="${categories}" var="cat" >
        <a id="${cat.name}" href='${root}/list/${cat.id}' class='list-group-item'> ${cat.name} </a>
    </c:forEach>


</div>