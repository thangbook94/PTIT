<%-- 
    Document   : login
    Created on : 20-11-2019, 21:11:14
    Author     : Phan Thanh
--%>
<%@page import="model.Product"%>
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
        <% Product product = (Product) session.getAttribute("product_select"); %>
        <div class="content">
            <div class="box">
                <form action="productServlet" method="post">
                    <div class="title">EDIT PRODUCT</div></br></br>
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
                            <input name="name_product" class="input-add-product" required type="text" placeholder="NAME" value="<%= product.getName() %>"/>
                        </div>
                        <div class="row-item">
                            <div class="input-title">PRODUCT SIZE</div></br>
                            <select name="size" class="select-size">
                                <option value="XS" <%= product.getSize().equals("XS") ? "selected" : "" %> >XS</option>
                                <option value="S" <%= product.getSize().equals("S") ? "selected" : "" %>>S</option>
                                <option value="M" <%= product.getSize().equals("M") ? "selected" : "" %>>M</option>
                                <option value="L" <%= product.getSize().equals("L") ? "selected" : "" %>>L</option>
                                <option value="XL" <%= product.getSize().equals("XL") ? "selected" : "" %>>XL</option>
                            </select>
                        </div>
                    </div></br></br>

                    <div class="row">
                        <div class="row-item">
                            <div class="input-title">PRODUCT PRICE</div></br>
                            <input name="price" class="input-add-product" required type="number" placeholder="PRICE" value="<%= product.getPrice() %>" />
                        </div>
                        <div class="row-item">
                            <div class="input-title">PRODUCT TYPE</div></br>
                            <select name="type_product_id" class="select-type">
                                <option value="1" <%= product.getTypeProductId() == 1 ? "selected" : "" %> >MEN</option>
                                <option value="2" <%= product.getTypeProductId() == 2 ? "selected" : "" %> >WOMEN</option>
                                <option value="3" <%= product.getTypeProductId() == 3 ? "selected" : "" %> >KIDS</option>
                            </select>
                        </div>
                    </div></br></br>

                    <div class="row">
                        <div class="row-item">
                            <div class="input-title">QUANTITY</div></br>
                            <input name="quantity" class="input-add-product" required type="number" placeholder="QUANTITY" value="<%= product.getQuantity() %>"/>
                        </div>
                        <div class="row-item">
                            <div class="input-title">PRODUCT COLOR</div></br>
                            <select name="color" class="select-type">
                                <option value="black" <%= product.getColor().equals("black") ? "selected" : "" %> >BLACK</option>
                                <option value="white" <%= product.getColor().equals("white") ? "selected" : "" %> >WHITE</option>
                                <option value="red" <%= product.getColor().equals("red") ? "selected" : "" %> >RED</option>
                                <option value="pink" <%= product.getColor().equals("pink") ? "selected" : "" %> >PINK</option>
                                <option value="green" <%= product.getColor().equals("green") ? "selected" : "" %> >GREEN</option>
                                <option value="blue" <%= product.getColor().equals("blue") ? "selected" : "" %> >BLUE</option>
                                <option value="grey" <%= product.getColor().equals("grey") ? "selected" : "" %> >GREY</option>
                            </select>
                        </div>
                    </div></br></br>

                    <div class="row">
                        <div class="row-item">
                            <div class="input-title">LINK IMAGE</div></br>
                            <input name="link_image" class="input-add-product" required type="url" placeholder="LINK IMAGE" value="<%= product.getLinkImage() %>"/>
                        </div>
                        <div class="row-item">
                            <div class="input-title">DESCRIPTION</div></br>
                            <input name="description" class="input-add-product" required type="text" placeholder="DESCRIPTION" value="<%= product.getDescription() %>"/>
                        </div>
                    </div></br></br>
                    <div class="btn">
                        <button formmethod="post" type="submit" name="submit" value="editProduct" class="add-product">EDIT</button>
                    </div></br></br>
                </form>
            </div>  
        </div>
        
        <!--Footer-->
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
