<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Test</title>
    <style type="text/css">
        <%@include file="PartsFilterCss.css"%>
    </style>
    <script type="text/javascript">
        <%@include file="PartsFilterScripts.js"%>
    </script>
</head>
<body>
<form action="filter?action=buildFilter" method="post">
    <table class="filterTable" width="100%">
        <thead>
        <tr>
            <td width="20%">Filter</td>
            <td width="80%"></td>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td width="20%">PN</td>
            <td width="80%"><input type="text" size="50" name="PN"></td>
        </tr>
        <tr>
            <td width="20%">Part Name</td>
            <td width="80%"><input type="text" size="50" name="PartName"></td>
        </tr>
        <tr>
            <td width="20%">Vendor</td>
            <td width="80%"><input type="text" size="50" name="Vendor"></td>
        </tr>
        <tr>
            <td width="20%">Qty</td>
            <td width="80%"><input type="number" size="10" name="QTY"></td>
        </tr>
        <tr>
            <td width="20%">Shipped</td>
            <td width="80%"><span>after </span><input type="text" size="15"
                                                      name="afterShipped"><span> before </span><input
                    type="text"
                    size="15"
                    name="beforeShipped">
            </td>
        </tr>
        <tr>
            <td width="20%">Received</td>
            <td width="80%"><span>after </span><input type="text" size="15"
                                                      name="afterReceived"><span> before </span><input
                    type="text" size="15" name="beforeReceived"></td>
        </tr>
        </tbody>
    </table>
    <div class="divButton">
        <input class="filterButton" type="submit" size="20" title="Filter" value="Filter" align="middle">
    </div>
</form>
<table class="resultTable" id="resultTable" style="border: solid #A9A9A9; padding-top: 20px" width="100%">
    <thead>
    <tr>
        <td>
            <button type="submit" name="PN" value="PN" class="btn-link" onclick="PNOnClick()">PN</button>
            <input type="hidden" id="PNClicked"
                   name="PNClicked"
                   value="False">

        </td>
        <td>
            <button type="submit" name="Part Name" value="Part Name" class="btn-link" onclick="PartNameOnClick()">Part Name</button>
            <input type="hidden"
                   id="PartNameClicked"
                   value="False">
        </td>
        <td>
            <button type="submit" name="Vendor" value="Vendor" class="btn-link" onclick="VendorOnClick()">Vendor</button>
            <input type="hidden"
                   id="VendorClicked"
                   value="False">
        </td>
        <td>
            <button type="submit" name="Qty" value="Qty" class="btn-link" onclick="QtyOnClick()">Qty</button>
            <input type="hidden"
                   id="QtyClicked"
                   value="False">
        </td>
        <td>
            <button type="submit" name="Shipped" value="Shipped" class="btn-link" onclick="ShippedOnClick()">Shipped</button>
            <input type="hidden"
                   id="ShippedClicked"
                   value="False">
        </td>
        <td>
            <button type="submit" name="Received" value="Received" class="btn-link" onclick="ReceivedOnClick()">Received</button>
            <input type="hidden"
                   id="ReceivedClicked"
                   value="False">
        </td>
    </tr>
    </thead>
    <tbody>
    <jsp:useBean id="parts" scope="request" type="java.util.List" beanName="parts"/>
    <c:forEach items="${parts}" var="part">
        <tr>
            <input type="hidden" name="ID">
            <td><input type="hidden" name="partPN" value="${part.PN}">${part.PN}</td>
            <td><input type="hidden" name="partPartName" value="${part.partName}">${part.partName}</td>
            <td><input type="hidden" name="partVendor" value="${part.vendor}">${part.vendor}</td>
            <td><input type="hidden" name="partQty" value="${part.qty}">${part.qty}</td>
            <td><input type="hidden" name="partShipped" value="${part.strShipped}">${part.strShipped}</td>
            <td><input type="hidden" name="partReceived" value="${part.strReceived}">${part.strReceived}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
