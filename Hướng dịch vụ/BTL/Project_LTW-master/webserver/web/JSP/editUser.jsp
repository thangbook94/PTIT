<%-- 
    Document   : editCustomer
    Created on : 06-12-2019, 16:26:28
    Author     : Phan Thanh
--%>

<%@page import="model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="CSS/headerPromotion.css" rel="stylesheet" type="text/css"/>
        <link href="CSS/register.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <!--Header-->
        <jsp:include page="header.jsp"></jsp:include>

        <!--Content-->
        <% User user = (User) session.getAttribute("user"); %>
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
        <div class="body-register-page">
            <div class="register-part-1">
                <div class="register-part-1-contain">
                    <div class="logo-register">
                        <h2>EDIT CUSTOMER</h2>
                    </div>
                    <form class="form-register" action="userServlet" method="post"> 
                        <div>
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
                        <h5>USERNAME</h5>
                        <div class="form-register-input">
                            <input style="margin: 0px; padding: 7.5px 25px" placeholder="USERNAME" name="user_name" disabled type="text" value="<%= user.getUsername()%>"></input>
                        </div>
                        
                        <h5>YOUR NAME</h5>
                        <div class="form-register-input">
                            <input placeholder="NAME" name="name" required type="text" value="<%= user.getName()%>"></input>       
                        </div>
                        <div class="form-register-input">
                            <input placeholder="LAST NAME" name="last_name" required type="text" value="<%= user.getLastName() %>"></input>
                        </div>
                        <h5>ADDRESS</h5>
                        <div class="form-register-input">
                            <input placeholder="ADDRESS" name="address" required type="text" value="<%= user.getAddress() %>"></input>       
                        </div>
                        <h5>EMAIL</h5>
                        <div class="form-register-input">
                            <input placeholder="EMAIL" name="email" required type="text" value="<%= user.getEmail() %>" ></input>       
                        </div>
                        <button class="register-now" type="submit" name="submit" value="edit_user" aria-label="Register">
                            <div>
                                <span>ACCEPT</span>
                            </div>
                            <svg style="padding:12px;width:25px;height:25px;color:white;" xmlns="http://www.w3.org/2000/svg" aria-hidden="true" focusable="false" data-prefix="fas" data-icon="long-arrow-alt-right" class="svg-inline--fa fa-long-arrow-alt-right fa-w-14" role="img" viewBox="0 0 448 512"><path fill="currentColor" d="M313.941 216H12c-6.627 0-12 5.373-12 12v56c0 6.627 5.373 12 12 12h301.941v46.059c0 21.382 25.851 32.09 40.971 16.971l86.059-86.059c9.373-9.373 9.373-24.569 0-33.941l-86.059-86.059c-15.119-15.119-40.971-4.411-40.971 16.971V216z"></path></svg>
                        </button>
                    </form>
                </div>
            </div>
            <div class="register-part-2">
                <div class="register-part-2-contain">
                    <div class="logo-register">
                        <h2>REGISTER AND JOIN THE GLAZERR CREATORS CLUB</h2> 
                    </div>
                    <div>
                        <p>Create an account with Glazerr :</p>
                        <ul>
                            <li class="benefit-register">
                                <svg style="width: 20px;height: 20px;margin-right: 10px;"xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"><path d="M0 0h24v24H0z" fill="none"/><path d="M9 16.17L4.83 12l-1.42 1.41L9 19 21 7l-1.41-1.41z"/></svg>
                                Earn easy points for exclusive rewards
                            </li>
                            <li class="benefit-register">
                                <svg style="width: 20px;height: 20px;margin-right: 10px;"xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"><path d="M0 0h24v24H0z" fill="none"/><path d="M9 16.17L4.83 12l-1.42 1.41L9 19 21 7l-1.41-1.41z"/></svg>                                
                                Access the best special offers and promotions
                            </li>
                            <li class="benefit-register">
                                <svg style="width: 20px;height: 20px;margin-right: 10px;"xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"><path d="M0 0h24v24H0z" fill="none"/><path d="M9 16.17L4.83 12l-1.42 1.41L9 19 21 7l-1.41-1.41z"/></svg>
                                Receive invites to exclusive events
                            </li>
                            <li class="benefit-register">
                                <svg style="width: 20px;height: 20px;margin-right: 10px;"xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"><path d="M0 0h24v24H0z" fill="none"/><path d="M9 16.17L4.83 12l-1.42 1.41L9 19 21 7l-1.41-1.41z"/></svg>
                                Get access to limited edition products
                            </li>
                            <li class="benefit-register">  
                                <svg style="width: 20px;height: 20px;margin-right: 10px;"xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"><path d="M0 0h24v24H0z" fill="none"/><path d="M9 16.17L4.83 12l-1.42 1.41L9 19 21 7l-1.41-1.41z"/></svg>                                
                                Level up for a Runtastic Premium subscription
                            </li>
                            <li class="benefit-register"> 
                                <svg style="width: 20px;height: 20px;margin-right: 10px;"xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"><path d="M0 0h24v24H0z" fill="none"/><path d="M9 16.17L4.83 12l-1.42 1.41L9 19 21 7l-1.41-1.41z"/></svg>                                
                                Faster checkout with your saved address and payment details
                            </li>
                            <li class="benefit-register">
                                <svg style="width: 20px;height: 20px;margin-right: 10px;"xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"><path d="M0 0h24v24H0z" fill="none"/><path d="M9 16.17L4.83 12l-1.42 1.41L9 19 21 7l-1.41-1.41z"/></svg>                                
                                Access your complete order history
                            </li>
                            <li class="benefit-register">
                                <svg style="width: 20px;height: 20px;margin-right: 10px;"xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"><path d="M0 0h24v24H0z" fill="none"/><path d="M9 16.17L4.83 12l-1.42 1.41L9 19 21 7l-1.41-1.41z"/></svg>                                
                                Track your order delivery
                            </li>
                        </ul>
                        <div>Want to learn more about the Creators Club? </div>
                        <a class="information-register">Read more about free membership</a>
                    </div>
                </div>
            </div>
        </div>

        <!--Footer-->
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
