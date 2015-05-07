<%@ include file="./header.jsp" %>


<h1>Department Management</h1>
<h3>${add_success}</h3>
<a href="<%=request.getContextPath()%>/department/add" class="button">Add New</a>

<table>
    <tr>
        <th>ID</th>
        <th>Department Code</th>
        <th>Department Name</th>
        <th>Description</th>
        <th>Employees</th>
        <th>Action</th>

        <c:forEach items="${departments_list}" var="department">  
        <tr>  
            <td><c:out value="${department.id}"/></td>  
            <td><c:out value="${department.depCode}"/></td>  
            <td><c:out value="${department.depName}"/></td>  
            <td><c:out value="${department.description}"/></td>
            <td><a href="<%=request.getContextPath()%>/employee?departmentId=${department.id}">${fn:length(department.employees)}</a></td>  
            <td align="center"><a href="<%=request.getContextPath()%>/department/edit?id=${department.id}">Edit</a> | <a href="<%=request.getContextPath()%>/department/delete?id=${department.id}">Delete</a></td>  
        </tr>  
    </c:forEach> 
</tr>

</table>

<%@ include file="./footer.jsp" %>