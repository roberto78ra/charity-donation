<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<title>Donation add page</title>

<form:form method="post" modelAttribute="donation">
    <h3 align="center">Add donation to database:</h3>
    <table align="center">
        <tr>
            <td>Quantity:</td>
            <td><form:input path="quantity"/></td>            <
        </tr>
        <tr>
            <td>Street:</td>
            <td><form:input path="street"/></td>
        </tr>
        <tr>
            <td>City:</td>
            <td><form:input path="city"/></td>
        </tr>
        <tr>
            <td>Zip Code: </td>
            <td><form:input path="zipCode"/></td>
        </tr>
        <tr>
            <td>Pickup Date:</td>
            <td><form:input path="pickUpDate" type = "date" name = "pickupdate"/></td>
        </tr>
        <tr>
            <td>Pickup Time:</td>
            <td><form:input path="pickUpTime" type ="time" name = "pickuptime" /></td>
        </tr>
        <tr>
            <td>Comment:</td>
            <td><form:textarea cols="6" rows="3" path="pickUpComment"/></td>
        </tr>
    </table>
</form:form>
