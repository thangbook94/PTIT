<%-- 
    Document   : detailProduct
    Created on : Dec 7, 2019, 2:56:01 PM
    Author     : minhm
--%>

<%@page import="model.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="CSS/detailProduct.css" rel="stylesheet" type="text/css"/>
        <link href="CSS/headerPromotion.css" rel="stylesheet" type="text/css"/>
        <link href="CSS/common.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <!--Header-->
        <jsp:include page="header.jsp"></jsp:include>
                <div class="header-promotion">
            <div class="header-promotion-contain">
                <div class="header-promotion-item">
                    30% OFF CYBER MONDAY - USE CODE: CYBER
                </div>
                <div class="header-promotion-item">
                   <svg style="width: 15px;height: 15px;margin-right: 5px;" xmlns="http://www.w3.org/2000/svg" aria-hidden="true" focusable="false" data-prefix="fas" data-icon="shipping-fast" class="svg-inline--fa fa-shipping-fast fa-w-20" role="img" viewBox="0 0 640 512"><path fill="currentColor" d="M624 352h-16V243.9c0-12.7-5.1-24.9-14.1-33.9L494 110.1c-9-9-21.2-14.1-33.9-14.1H416V48c0-26.5-21.5-48-48-48H112C85.5 0 64 21.5 64 48v48H8c-4.4 0-8 3.6-8 8v16c0 4.4 3.6 8 8 8h272c4.4 0 8 3.6 8 8v16c0 4.4-3.6 8-8 8H40c-4.4 0-8 3.6-8 8v16c0 4.4 3.6 8 8 8h208c4.4 0 8 3.6 8 8v16c0 4.4-3.6 8-8 8H8c-4.4 0-8 3.6-8 8v16c0 4.4 3.6 8 8 8h208c4.4 0 8 3.6 8 8v16c0 4.4-3.6 8-8 8H64v128c0 53 43 96 96 96s96-43 96-96h128c0 53 43 96 96 96s96-43 96-96h48c8.8 0 16-7.2 16-16v-32c0-8.8-7.2-16-16-16zM160 464c-26.5 0-48-21.5-48-48s21.5-48 48-48 48 21.5 48 48-21.5 48-48 48zm320 0c-26.5 0-48-21.5-48-48s21.5-48 48-48 48 21.5 48 48-21.5 48-48 48zm80-208H416V144h44.1l99.9 99.9V256z"/></svg> 
                   <div>
                        FREE SHIPPING OVER $49 AND FREE RETURNS
                    </div>
                </div>
                <div class="header-promotion-item">
                  <svg style="width: 15px;height: 15px;margin-right: 5px;" xmlns="http://www.w3.org/2000/svg" aria-hidden="true" focusable="false" data-prefix="far" data-icon="id-card" class="svg-inline--fa fa-id-card fa-w-18" role="img" viewBox="0 0 576 512"><path fill="currentColor" d="M528 32H48C21.5 32 0 53.5 0 80v352c0 26.5 21.5 48 48 48h480c26.5 0 48-21.5 48-48V80c0-26.5-21.5-48-48-48zm0 400H303.2c.9-4.5.8 3.6.8-22.4 0-31.8-30.1-57.6-67.2-57.6-10.8 0-18.7 8-44.8 8-26.9 0-33.4-8-44.8-8-37.1 0-67.2 25.8-67.2 57.6 0 26-.2 17.9.8 22.4H48V144h480v288zm-168-80h112c4.4 0 8-3.6 8-8v-16c0-4.4-3.6-8-8-8H360c-4.4 0-8 3.6-8 8v16c0 4.4 3.6 8 8 8zm0-64h112c4.4 0 8-3.6 8-8v-16c0-4.4-3.6-8-8-8H360c-4.4 0-8 3.6-8 8v16c0 4.4 3.6 8 8 8zm0-64h112c4.4 0 8-3.6 8-8v-16c0-4.4-3.6-8-8-8H360c-4.4 0-8 3.6-8 8v16c0 4.4 3.6 8 8 8zm-168 96c35.3 0 64-28.7 64-64s-28.7-64-64-64-64 28.7-64 64 28.7 64 64 64z"/></svg>  
                  <div>
                      JOIN THE GLAZERR CREATORS CLUB
                  </div>
                </div>
            </div>
        </div>
        <!--Content-->
        <% Product product = (Product) request.getAttribute("product"); %>
        <% session.setAttribute("productCurrent", product); %>
        <div style="margin-left: 110px; margin-bottom: 30px" class="container breadcrumb">
            <div class="breadcrumb-button button-back">
                <svg class="back-icon">
                    <svg id="arrow-back" viewBox="0 0 16 24">
                        <g fill="none" stroke="currentColor" stroke-miterlimit="10" stroke-width="2">
                            <path d="M15 18v-6H2"></path>
                            <path d="M6.5 7l-5 5 5 5"></path>
                        </g>
                    </svg>
                </svg>
                <div class="back-text">BACK</div>
            </div>
            <div class="breadcrumb-button breadcrumb-item-text">Home</div>
            <div class="breadcrumb-break">/</div>
            <div class="breadcrumb-button breadcrumb-item-text">
                <%
                    if(product.getTypeProductId() == 1){
                        out.print("Men");
                    }
                    else if(product.getTypeProductId() == 2){
                        out.print("Women");
                    }
                    else{
                        out.print("Kids");
                    }
                %>
            </div>
            <div class="breadcrumb-break">/</div>
            <div class="breadcrumb-button-current"><%= product.getName() %></div>
        </div>
        <%
            if(session.getAttribute("message") != null){
                %>
                    <h4 style="color: green; margin-left: 137px"><%= session.getAttribute("message") %></h4>
                <%
                session.setAttribute("message", null);
            }
        %>
        <div class="body-page">
            <div class="body-page-part-1">
                <div class="image-contain">
                    <img src="<%= product.getLinkImage() %>" alt=""/>
                </div>
            </div>
            <div class="body-page-part-2">
                <div class="body-page-2-container">
                    <div class="review-items">
                        <svg style="width: 16px;height: 16px;" xmlns="http://www.w3.org/2000/svg" aria-hidden="true" focusable="false" data-prefix="fas" data-icon="star" class="svg-inline--fa fa-star fa-w-18" role="img" viewBox="0 0 576 512"><path fill="currentColor" d="M259.3 17.8L194 150.2 47.9 171.5c-26.2 3.8-36.7 36.1-17.7 54.6l105.7 103-25 145.5c-4.5 26.3 23.2 46 46.4 33.7L288 439.6l130.7 68.7c23.2 12.2 50.9-7.4 46.4-33.7l-25-145.5 105.7-103c19-18.5 8.5-50.8-17.7-54.6L382 150.2 316.7 17.8c-11.7-23.6-45.6-23.9-57.4 0z"/></svg>
                        <svg style="width: 16px;height: 16px;" xmlns="http://www.w3.org/2000/svg" aria-hidden="true" focusable="false" data-prefix="fas" data-icon="star" class="svg-inline--fa fa-star fa-w-18" role="img" viewBox="0 0 576 512"><path fill="currentColor" d="M259.3 17.8L194 150.2 47.9 171.5c-26.2 3.8-36.7 36.1-17.7 54.6l105.7 103-25 145.5c-4.5 26.3 23.2 46 46.4 33.7L288 439.6l130.7 68.7c23.2 12.2 50.9-7.4 46.4-33.7l-25-145.5 105.7-103c19-18.5 8.5-50.8-17.7-54.6L382 150.2 316.7 17.8c-11.7-23.6-45.6-23.9-57.4 0z"/></svg>                    
                        <svg style="width: 16px;height: 16px;" xmlns="http://www.w3.org/2000/svg" aria-hidden="true" focusable="false" data-prefix="fas" data-icon="star" class="svg-inline--fa fa-star fa-w-18" role="img" viewBox="0 0 576 512"><path fill="currentColor" d="M259.3 17.8L194 150.2 47.9 171.5c-26.2 3.8-36.7 36.1-17.7 54.6l105.7 103-25 145.5c-4.5 26.3 23.2 46 46.4 33.7L288 439.6l130.7 68.7c23.2 12.2 50.9-7.4 46.4-33.7l-25-145.5 105.7-103c19-18.5 8.5-50.8-17.7-54.6L382 150.2 316.7 17.8c-11.7-23.6-45.6-23.9-57.4 0z"/></svg>
                        <svg style="width: 16px;height: 16px;" xmlns="http://www.w3.org/2000/svg" aria-hidden="true" focusable="false" data-prefix="fas" data-icon="star" class="svg-inline--fa fa-star fa-w-18" role="img" viewBox="0 0 576 512"><path fill="currentColor" d="M259.3 17.8L194 150.2 47.9 171.5c-26.2 3.8-36.7 36.1-17.7 54.6l105.7 103-25 145.5c-4.5 26.3 23.2 46 46.4 33.7L288 439.6l130.7 68.7c23.2 12.2 50.9-7.4 46.4-33.7l-25-145.5 105.7-103c19-18.5 8.5-50.8-17.7-54.6L382 150.2 316.7 17.8c-11.7-23.6-45.6-23.9-57.4 0z"/></svg>                
                        <svg style="width: 16px;height: 16px;" xmlns="http://www.w3.org/2000/svg" aria-hidden="true" focusable="false" data-prefix="fas" data-icon="star" class="svg-inline--fa fa-star fa-w-18" role="img" viewBox="0 0 576 512"><path fill="currentColor" d="M259.3 17.8L194 150.2 47.9 171.5c-26.2 3.8-36.7 36.1-17.7 54.6l105.7 103-25 145.5c-4.5 26.3 23.2 46 46.4 33.7L288 439.6l130.7 68.7c23.2 12.2 50.9-7.4 46.4-33.7l-25-145.5 105.7-103c19-18.5 8.5-50.8-17.7-54.6L382 150.2 316.7 17.8c-11.7-23.6-45.6-23.9-57.4 0z"/></svg>
                        <span class="read-review">Read all 46 reviews</span>
                    </div>
                    <div class="content-item">
                        <div class="about-item">
                            <%
                                if(product.getTypeProductId() == 1){
                                    out.print("MEN");
                                }
                                else if(product.getTypeProductId() == 2){
                                    out.print("WOMEN");
                                }
                                else{
                                    out.print("KIDS");
                                }
                            %>'S ESSENTIALS
                        </div>
                        <div class="name-of-item"><%= product.getName() %></div>
                        <span class="cost-of-item" style="color: red;">Price: <%= product.getPrice() %>$</span>                       
                    </div>
                    <br>
                    <div>
                        <div class="about-item">Size: <%= product.getSize()%></div>
                        <div class="about-item">Color: <%= product.getColor() %></div> 
                        <div class="about-item">Description: <%= product.getDescription()%></div> 
                        <br>
                        <div>
                            <form action="cart" method="post">
                                <button class="add-to-bag" type="submit" name="submit" value="addToBag">
                                    <div>
                                        <span>ADD TO BAG</span>
                                    </div>
                                    <svg style="padding:12px;width:25px;height:25px;color:white;" xmlns="http://www.w3.org/2000/svg" aria-hidden="true" focusable="false" data-prefix="fas" data-icon="long-arrow-alt-right" class="svg-inline--fa fa-long-arrow-alt-right fa-w-14" role="img" viewBox="0 0 448 512"><path fill="currentColor" d="M313.941 216H12c-6.627 0-12 5.373-12 12v56c0 6.627 5.373 12 12 12h301.941v46.059c0 21.382 25.851 32.09 40.971 16.971l86.059-86.059c9.373-9.373 9.373-24.569 0-33.941l-86.059-86.059c-15.119-15.119-40.971-4.411-40.971 16.971V216z"></path></svg>
                                </button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>            
        </div>
        <!--Footer-->
        <jsp:include page="footer.jsp"></jsp:include>        
    </body>
</html>
