<%-- 
    Document   : login
    Created on : 20-11-2019, 21:11:14
    Author     : Phan Thanh
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="CSS/addProduct.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <!--Header-->
        <jsp:include page="header.jsp"></jsp:include>

        <!--Content-->
        <div class="content">
            <div class="box">
                <form action="productServlet" method="post">
                    <div class="title">ADD PRODUCT</div></br></br>
                    <div class="row">
                        <div class="row-item"  style="width: 100%">
                            <div style="color: red">
                                <% 
                                    if(session.getAttribute("error") != null){
                                        out.print(session.getAttribute("error"));
                                        session.setAttribute("error", null);
                                    }
                                %>
                            </div>
                            <div style="color: green">
                                <% 
                                    if(session.getAttribute("message") != null){
                                        out.print(session.getAttribute("message"));
                                        session.setAttribute("message", null);
                                    }
                                %>
                            </div>
                        </div>
                    </div>
                        <br>
                    <div class="row">
                        <div class="row-item">
                            <div class="input-title">PRODUCT NAME</div></br>
                            <input name="name_product" class="input-add-product" required type="text" placeholder="NAME"/>
                        </div>
                        <div class="row-item">
                            <div class="input-title">PRODUCT SIZE</div></br>
                            <select name="size" class="select-size">
                                <option value="XS" selected >XS</option>
                                <option value="S">S</option>
                                <option value="M">M</option>
                                <option value="L">L</option>
                                <option value="XL">XL</option>
                            </select>
                        </div>
                    </div></br></br>

                    <div class="row">
                        <div class="row-item">
                            <div class="input-title">PRODUCT PRICE</div></br>
                            <input name="price" class="input-add-product" required type="number" placeholder="PRICE"/>
                        </div>
                        <div class="row-item">
                            <div class="input-title">PRODUCT TYPE</div></br>
                            <select name="type_product_id" class="select-type">
                                <option value="1" selected >MEN</option>
                                <option value="2">WOMEN</option>
                                <option value="3">KIDS</option>
                            </select>
                        </div>
                    </div></br></br>

                    <div class="row">
                        <div class="row-item">
                            <div class="input-title">QUANTITY</div></br>
                            <input name="quantity" class="input-add-product" required type="number" placeholder="QUANTITY"/>
                        </div>
                        <div class="row-item">
                            <div class="input-title">PRODUCT COLOR</div></br>
                            <select name="color" class="select-type">
                                <option value="black" selected >BLACK</option>
                                <option value="white">WHITE</option>
                                <option value="red">RED</option>
                                <option value="pink">PINK</option>
                                <option value="green">GREEN</option>
                                <option value="blue">BLUE</option>
                                <option value="grey">GREY</option>
                            </select>
                        </div>
                    </div></br></br>

                    <div class="row">
                        <div class="row-item">
                            <div class="input-title">LINK IMAGE</div></br>
                            <input name="link_image" class="input-add-product" required type="url" placeholder="LINK IMAGE"/>
                        </div>
                        <div class="row-item">
                            <div class="input-title">DESCRIPTION</div></br>
                            <input name="description" class="input-add-product" required type="text" placeholder="DESCRIPTION"/>
                        </div>
                    </div></br></br>
                    <div class="btn">
                        <button formmethod="post" type="submit" name="submit" value="addProduct" class="add-product">ADD</button>
                    </div></br></br>
                </form>
            </div>  
        </div>
        
        <!--Footer-->
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
