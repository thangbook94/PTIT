<%-- 
    Document   : Home_Page
    Created on : Nov 17, 2019, 4:15:25 PM
    Author     : minhm
--%>

<%@page import="model.User"%>
<%@page import="java.util.List"%>
<%@page import="model.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>GLAZERR</title>
        <link href="CSS/jquery-ui.css" rel="stylesheet" type="text/css"/>
        <link href="CSS/common.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <!--header-->
        <jsp:include page="header.jsp" />
        
        <!--Content-->
        <% List<Product> listProduct = (List<Product>) session.getAttribute("listProduct"); %>
        <% User user = (User) session.getAttribute("user"); %>
        <div class="content">
            <div class="container breadcrumb">
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
                <div class="breadcrumb-button-current"><%= session.getAttribute("typeView") %></div>
            </div>
            <div class="container content-title">
                <h1 class="content-title-text"><%= session.getAttribute("typeView") %></h1>
                <h4 class="content-title-product">(<%= listProduct.size() %> Products)</h4>
            </div>
            
            <!-- Content products -->
            <br>
            <%
                if(session.getAttribute("typeView").equals("Search")){
                    %>
                    <div>Result for "<%= session.getAttribute("message") %>" :</div>
                    <%
                     session.setAttribute("message", null);
                }
            %>
            <br>
            <div class="content-products">
                <%
                    if(listProduct != null && listProduct.size() != 0){
                        for(Product product : listProduct){  
                            String name_product = product.getName();
                            String link_image = product.getLinkImage();
                            float price = product.getPrice();
                            String size = product.getSize();
                            %>
                            <div class="container-product-all">
                                <form style="width: 100%" action="detailProduct" method="get">
                                    <button class="button-container-product" type="submit" name="product_id" value="<%= product.getId() %>">
                                        <div class="container-product">
                                            <div class="product-detail">
                                                <div class="container-image">

                                                    <img src="<%= link_image %>" alt="<%= name_product %>" title="<%= name_product %>" width="100%"/>
                                                    <div class="product-imformation">
                                                        <div class="product-name-text"><%= name_product %></div>
                                                        <div style="width: 100%">
                                                            <div style="width: 40%">
                                                                <div class="product-price"><%= price %> $</div>
                                                                <div class="amont-color">Size: <%= size %></div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </button>
                                </form>
                                <%
                                    if(user != null){
                                        if(user.getTypeUserId() == 1){
                                            %>
                                                <div class="container-button">
                                                    <form class="button-product" action="editProduct">
                                                        <input type="hidden"  name="product_id" value="<%= product.getId() %>"/>
                                                        <button type="submit"> 
                                                            <img style="width: 24px; height: 24px" src="Icons/edit.png" alt="edit product" title="edit product"/>
                                                        </button>
                                                    </form>
                                                    <div class="button-product">
                                                        <button class="button-delete" type="submit" value="<%= product.getId() %>"> 
                                                            <img style="width: 24px; height: 24px" src="Icons/delete.png" alt="edit product" title="edit product"/>
                                                        </button>
                                                    </div>
                                                </div>
                                            <%
                                        }
                                    }
                                %>
                            </div>
                            <%
                        }
                    }
                    else{
                        %>
                        <h2>No Product</h2>
                        <%
                    }
                %>
            </div>
            <div class="pagination">
                <div class="pagination-element">
                    <div id="button-page-previos" class="button-page">Previos</div>
                </div>
                <div class="pagination-element select-page">
                    <div class="text-pagination">Page:</div>
                    <div class="container-select">
                        <div class="page-number">
                            <div class="box-select">
                                <div class="number">1</div>
                                <svg class="select-down-icon">
                                    <svg id="dropdown" viewBox="0 0 16 24">
                                        <path fill="none" stroke="currentColor" stroke-miterlimit="10" stroke-width="2" d="M1.5 9L8 15.5 14.5 9"></path>
                                    </svg>
                                </svg>
                            </div>
                        </div>
                        
                    </div>
                    <div class="text-pagination">of 10</div>
                </div>
                <div class="pagination-element">
                    <div id="button-page-next" class="button-page">Next</div>
                </div>
            </div>
        </div>
        <!--Footer-->
        <jsp:include page="footer.jsp" />
        
        <div class="dialog" id="dialog">
            <h3 style="color: red">Delete product selected ?</h3>
            <div class="container-button-dialog">
                <div class="item-dialog" id="button-exit">
                    Exit
                </div>
                <form class="item-dialog" action="productServlet" method="post">
                    <input id="inputProductID" type="hidden" name="product_id"/>
                    <button id="comfirmDelete" type="submit" name="submit" value="deleteProduct">
                        Confirm
                    </button>
                </form>
            </div>
        </div>
        
        
        <script src="JS/jquery-1.12.4.js" type="text/javascript"></script>
        <script src="JS/jquery-ui.js" type="text/javascript"></script>
        <script>
            $( function (){
                $("#dialog").dialog({
                    width: 250,
                    height: 175,
                    title: "Comfirm delete product ?",
                    autoOpen: false,
                    fluid: true,
                    resizable: false,
                    modal: true
                });
                
                $( ".button-delete" ).on( "click", function() {
                    $("#inputProductID").val($(this).val());
                    $( "#dialog" ).dialog( "open" );
                });
                
                $("#button-exit").on("click", function (){
                    $("#dialog").dialog("close");
                });
            }); 
        </script>
    </body>
</html>
