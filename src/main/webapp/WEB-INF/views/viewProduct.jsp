<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ include file="/WEB-INF/views/template/header.jsp"%>


<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Product Detail</h1>
            <p class="lead">Product Details</p>
        </div>

       <div class="container" ng-app="cartApp">
           <div class ="row">
               <div class="col-md-5">
                   <img src="#" alt="image" style="width: 100%; height: 300px" />
               </div>
               <div class="col-md-5">
                   <h3>${product.productName}</h3>
                   <p>${product.productDescription}</p>
                   <p>${product.productManufacturer}</p>
                   <p>${product.productCategory}</p>
                   <p>${product.productCondition}</p>
                   <p>${product.productPrice} EURO</p>
                   <br>
                   <c:set var="role" scope="page" value="${param.role}"/>
                   <c:set var="url" scope="page" value="/productList"/>
                   <c:if test="${role='admin'}">
                       <c:set var="url" scope="page" value="/admin/productInventory"/>

                   </c:if>
                   <p ng-controller="cartCtrl">
                       <a href="<c:url value="${url}"/> " class="btn btn-default">Back</a>
                       <a href="#" class="btn btn-primary" ng-click="addToCart('${product.productId}')">
                           <span class="btn btn-primary"></span> Order</a>
                       <a href="<spring:url value="/cart"/>" class="btn btn-default"> View Cart</a>
                   </p>
               </div>
           </div>


           </div>
           </div>
        <script src="<c:url value="/resource/js/controller.js"/> "></script>
        <%@include file="/WEB-INF/views/template/footer.jsp"%>
