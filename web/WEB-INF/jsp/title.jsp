<%@ include file="./header.jsp" %>


<h1>Titles Management</h1>
<h3>${add_success}</h3>
<a href="<%=request.getContextPath()%>/title/add" class="button">Add New</a>

<table>
    <tr>
        <th>ID</th>
        <th>Title Code</th>
        <th>Title Name</th>
        <th>Description</th>
        <th>Employees</th>
        <th>Action</th>

        <c:forEach items="${titles_list}" var="title">  
        <tr>  
            <td><c:out value="${title.id}"/></td>  
            <td><c:out value="${title.titleCode}"/></td>  
            <td><c:out value="${title.titleName}"/></td>            
            <td><c:out value="${title.description}"/></td>  
            <td><a href="<%=request.getContextPath()%>/employee?titleId=${title.id}">${fn:length(title.employees)}</a></td>  
            <td align="center"><a href="<%=request.getContextPath()%>/title/edit?id=${title.id}">Edit</a> | <a href="<%=request.getContextPath()%>/title/delete?id=${title.id}">Delete</a></td>  
        </tr>  
    </c:forEach> 
</tr>

</table>

<%@ include file="./footer.jsp" %>