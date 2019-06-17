<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<script type="text/javascript" src="resources/js/uso.analyticsAdjustment.js" defer></script>
<jsp:include page="fragments/bodyHeader.jsp"/>
<div class="jumbotron pt-4">
    <div class="container">
        <h3 class="text-center"><spring:message code="AnaliticsAdjustment.title"/></h3>
        <table class="table table-striped" id="datatable">
            <thead>
            <tr>
                <th></th>
                <th>Дата</th>
                <th>Номер</th>
                <th>Статус</th>
                <th>Дата статуса</th>
                <th>Комментарий</th>
            </tr>
            </thead>
        </table>
    </div>
</div>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>
