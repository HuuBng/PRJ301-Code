<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="vi_VN" />


    <table class="table table-stripe">
        <tr>
            <td>Id</td>
            <td style="text-align: right">Date</td>
            <td style="text-align: right">Account ID</td>
            <td style="text-align: right">Current Status</td>
            <td style="text-align: right">New Status</td>
            <td style="text-align: right">Operation</td>
        </tr>
        <c:forEach var="order" items="${list}">
          
            <tr>
            <form action="<c:url value="/order/update_handler.do"/>" method="get">
                <td>
                    ${order.id}
                    <input type="hidden" value="${order.id}" name="id">
                </td>

                <td style="text-align: right">
                    <fmt:formatDate value="${order.date}" pattern="dd-MM-yyyy"/>
                </td>
                <td style="text-align: right">
                    ${order.accountId}
                </td>
                <td style="text-align: right">
                    ${order.status}
                    
                </td>
                
                <td style="text-align: right">
                    <select name="status" required>
                        <option value="New">New</option>
                        <option value="Shipping">Shipping</option>
                        <option value="Paid">Paid</option>
                        
                    </select>

                </td>
                <td style="text-align: right">
                    <button type="submit" name="op" value="update">Update</button>

                </td>
                </form>
            </tr>
        </c:forEach>




