<%@ include file="./header.jsp" %>


<h1>Employees Management</h1>
<h3>${add_success}</h3>
<a href="<%=request.getContextPath()%>/employee/add" class="button">Add New</a>

<table>
    <tr>
        <th>ID</th>
        <th>Employee Name</th>
        <th>Employee Address</th>
        <th>Action</th>

        <c:forEach items="${employees_list}" var="employee">  
        <tr>  
            <td><c:out value="${employee.id}"/></td>  
            <td><c:out value="${employee.empName}"/></td>  
            <td><c:out value="${employee.address}"/></td>          
            <td align="center"><a href="<%=request.getContextPath()%>/employee/edit?id=${employee.id}">Edit</a> | <a href="<%=request.getContextPath()%>/employee/delete?id=${employee.id}">Delete</a></td>  
        </tr>  
    </c:forEach> 
</tr>

</table>

<%@ include file="./footer.jsp" %>