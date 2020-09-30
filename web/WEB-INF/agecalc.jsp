<%-- 
    Document   : agecalc
    Created on : 29-Sep-2020, 12:48:34 AM
    Author     : StormCloud
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Age Calculator</title>
    </head>
    <body>
        <h1>Age Calculator</h1>
        <form action="calcage" method="POST">
            <div>
                <c:choose>
                    <%-- I absolutely hate this, I hate IE, I hate that it has no reasonable date input, and I hate that I can't detect IE11 the same as the rest.--%>
                    <c:when test='<%= (request.getHeader("user-agent").indexOf("MSIE") > -1 ||request.getHeader("user-agent").indexOf("Trident/7") > -1 )%>' >
                        
                        <label>birth date (year/month/day):</label>
                        <input type="number" name="byear" min="1900" max="9999" value="${byear}"/>/
                        <input type="number" name="bmonth" min="1" max="12" value="${bmonth}"/>/
                        <input type="number" name="bday" min="1" max="31" value="${bday}"/>
                        <input type="hidden" name="IE" value="true"/>
                        
                    </c:when>
                    <c:otherwise>
                        <label>birth date:</label><input type="date" name="bdate" value="${bdate}"/>
                        <input type="hidden" name="IE" value="false"/>
                    </c:otherwise>
                </c:choose>
            </div>
            <c:if test="${invalid==true}">
                <p>Invalid date.</p>
            </c:if>
            
            <input type="submit" value="Calculate age"/>
        </form>
        <div>
            
            <p>
                You are: ${age}
            </p>
            
            <a href="calc">go to math calculator.</a>
            
        </div>
    </body>
</html>
