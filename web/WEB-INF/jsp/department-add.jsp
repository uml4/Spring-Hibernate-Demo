<%@ include file="./header.jsp" %>


<h1>Add New Department</h1>

<div align="center">
    
    <table border="0" width="90%">
        <form:form action="add" modelAttribute="departmentForm" method="POST" >
            <form:hidden path="id" />
            <tr>
                <td align="left" width="20%">Department Code: </td>
                <td align="left" width="40%"><form:input path="depCode" size="30"/></td>
                <td align="left"><form:errors path="depCode" cssClass="error"/></td>
            </tr>
            <tr>
                <td>Department Name: </td>
                <td><form:input path="depName" size="30"/></td>
                <td><form:errors path="depName" cssClass="error"/></td>
            </tr>
           <tr>
                <td>Description: </td>
                <td><form:input path="description" size="30"/></td>
                <td><form:errors path="description" cssClass="error"/></td>
            </tr>

                    <tr>
                        <td><a href="<%=request.getContextPath()%>/department" class="button">Back</a></td>
                        <td align="center"><input type="submit" value="submit"/></td>
                        <td></td>
                    </tr>
                    </form:form>
                </table>
            </div>









<%@ include file="./footer.jsp" %>