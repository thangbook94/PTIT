<%-- 
    Document   : checkout
    Created on : 09-12-2019, 15:15:44
    Author     : Phan Thanh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="CSS/checkout.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <!--Header-->
        <jsp:include page="header.jsp"></jsp:include>
            <!--Content-->
            <div style="position: relative">
                <div class="background">
                </div>
                <div class="content">
                    <div class="checkout">
                        CHECKOUT SUCCESS!
                    </div>
                    <div class="icon-checkout">
                        <img src="Icons/checked.png" width="100%" height="100%"/>
                    </div></br></br>

                    <div class="continue-shopping">
                        <a href="home" style="font-size: 20px;font-weight: bold;color: green">Continue Shopping</a>
                    </div></br>
                </div>
            </div>

        <!--Footer-->
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
