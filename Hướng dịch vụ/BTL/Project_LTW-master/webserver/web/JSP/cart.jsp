<%-- 
    Document   : cart
    Created on : 06-12-2019, 23:11:13
    Author     : Phan Thanh
--%>

<%@page import="model.User"%>
<%@page import="java.util.List"%>
<%@page import="model.Product"%>
<%@page import="dto.CartDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cart</title>
        <link href="CSS/cart.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <!--Header-->
        <jsp:include page="header.jsp"></jsp:include>
        </br></br>
        
        <!--Content-->
        <% CartDTO cartDTO = (CartDTO) session.getAttribute("cartDTO"); %>
        <% User user = (User) session.getAttribute("user"); %>
        <div class="content">
            <div class="bag">
                <div class="title">YOUR BAG</div></br>
                <div class="list-product">
                    <%
                        if(cartDTO != null && cartDTO.getList().size() != 0){
                            List<Product> listProduct = cartDTO.getList();
                            for(Product product : listProduct){
                                %>
                                    <div class="product">
                                        <div class="product-img">
                                            <img src="<%= product.getLinkImage() %>"
                                                 width="100%" height="100%" />
                                        </div>
                                        <div class="product-info">
                                            <div class="cancel">
                                                <form style="width: 100%; height: 100%;" action="cart" method="post">
                                                    <input type="hidden" name="product_id" value="<%= product.getId() %>"/>
                                                    <button style="padding: 0px; width: 100%; height: 100%;" type="submit" name="submit" value="remove_product">
                                                        <svg style="width: 100%; height: 100%;">
                                                            <svg id="cross-small" viewBox="0 0 14 24">
                                                                <g fill="none" stroke="currentColor" stroke-miterlimit="10" stroke-width="2">
                                                                    <path d="M13 6l-6 6 6 6M1 6l6 6-6 6"></path>
                                                                </g>
                                                            </svg>
                                                        </svg>
                                                    </button>
                                                </form>
                                            </div>
                                            <div style="text-transform: uppercase; font-weight: bold" class="product-text" id="Name"><%= product.getName() %></div></br>
                                            <div class="product-text">Size: <%= product.getSize() %></div></br>
                                            <div class="product-text">Price: <%= product.getPrice() %>$</div><br>
                                            <div class="product-text">Cost: <%= product.getPrice() * product.getQuantity() %>$</div>
                                            <br>
                                            <div class="amount-item-select">
                                                <div class="amount-select-element">
                                                    <form style="width: 100%;" action="cart" method="post">
                                                        <input type="hidden"  name="product_id" value="<%= product.getId() %>"/>
                                                        <button class="button-amount-select" type="submit" name="submit" value="substract_product">
                                                            <img style="width: 34px; height: 34px;" src="Icons/substract.png" alt="substract product" title="Substract product"/>
                                                        </button>
                                                    </form>
                                                </div>
                                                <div class="amount-select-element">
                                                    <div class="text-amount-select"><%= product.getQuantity() %></div>
                                                </div>
                                                <div class="amount-select-element">
                                                    <form style="width: 100%;" action="cart" method="post">
                                                        <input type="hidden"  name="product_id" value="<%= product.getId() %>"/>
                                                        <button class="button-amount-select" type="submit" name="submit" value="increase_product">
                                                            <img style="width: 34px; height: 34px;" src="Icons/increase.png" alt="increase product" title="Increase product"/>
                                                        </button>
                                                    </form>
                                                </div>
                                            </div>
                                        </div>
                                    </div></br>
                                <%
                            }
                        }
                        else{
                            %>
                            <h3>No Product</h3>
                            <%
                        }
                    %>
                </div>
            </div>
            <div class="order">
                <div class="title">ORDER SUMARY</div></br>
                <div class="order-sumary">
                    <div class="total item"><%= cartDTO != null ? cartDTO.getList().size() : 0 %> ITEMS</div></br>
                    <div class="total">DELIVERY: FREE</div></br>
                    <div class="total">SALES TAX</div></br>
                    <div class="total cost"><b>TOTAL: <%= cartDTO != null ? cartDTO.getTotalMoney() : 0 %>$</b></div>
                </div></br>
                <%
                    if(cartDTO != null && cartDTO.getList().size() != 0){
                        %>
                            <form action="<%= (user != null) ? "checkout" : "login" %>">
                                <button type="submit" class="checkout">CHECKOUT</button>
                            </form>
                        <%
                    }
                %>
            </div>
        </div>
        <br>
        <!--Footer-->
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
