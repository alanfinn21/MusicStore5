
<%@ include file="/WEB-INF/views/template/header.jsp"%>


<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Administrator</h1>
            <p class="lead">Administrator page</p>
        </div>

        <c:if test="${pageContext.request.userPrincipal.name != null}">
        <h2>
            Welcome: ${pageContext.request.userPrincipal.name} |
            <a href="<c:url value="/j_spring_security_logout"/>">Logout</a>
        </h2>

        </c:if>

        <h3>
            <a href="<c:url value="/admin/productInventory" />"><span class="btn btn-primary">Add and Remove Products</span></a>
        </h3>

        <%@include file="/WEB-INF/views/template/footer.jsp"%>
