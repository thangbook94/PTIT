<%-- 
    Document   : Login
    Created on : Dec 3, 2019, 4:49:53 PM
    Author     : minhm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="CSS/headerPromotion.css" rel="stylesheet" type="text/css"/>
        <link href="CSS/bodyLoginPage.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <!--Header-->
        <jsp:include page="header.jsp"></jsp:include>   
        
        <!--Content-->
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
        <div class="body-login-page">
            <div class="login-part-1">
                <div class="login-part-1-contain">
                    <div class="logo-login">
                        <h2>LOGIN</h2>
                    </div>
                    <form action="userServlet" method="post" class="form-login">
                        <div class="forgot-password-login-contain">
                            <a class="forgot-password-login" target="_blank">Forgot Your Password?</a>                            
                        </div>
                        <div style="color: green">
                            <%
                                if(session.getAttribute("message") != null){
                                    out.print(session.getAttribute("message"));
                                    session.setAttribute("message", null);
                                } 
                            %>
                        </div>
                        <br>
                        <div class="form-login-input">
                            <input placeholder="USERNAME" name="user_name" required type="text"></input>       
                        </div>
                        <div class="form-login-input">
                            <input placeholder="PASSWORD" name="password" required type="password"></input>       
                        </div>  
                        <div style="color: red">
                            <% 
                                if(session.getAttribute("error") != null){
                                    out.print(session.getAttribute("error"));
                                    session.setAttribute("error", null);
                                } 
                            %>
                        </div>
                        <br>
                        <div class="term-condition-login">
                            <span>
                                <span>By clicking 'Log In' you agree to our website</span>
                                <span>
                                    <a target="_blank">Terms & Conditions</a>
                                </span>
                                <span>, </span>
                                <span>
                                    <a target="_blank">Privacy Policy</a>                                
                                </span>
                                <span>. </span>
                                <span>and Creators Club </span>
                                <span>
                                    <a target="_blank">Terms & Conditions</a>                                 
                                </span>
                            </span>               
                        </div>
                        <button class="login-now" type="submit" name="submit" value="login" aria-label="Login">
                            <div>
                                <span>LOGIN</span>
                            </div>
                            <svg style="padding:12px;width:25px;height:25px;color:white;" xmlns="http://www.w3.org/2000/svg" aria-hidden="true" focusable="false" data-prefix="fas" data-icon="long-arrow-alt-right" class="svg-inline--fa fa-long-arrow-alt-right fa-w-14" role="img" viewBox="0 0 448 512"><path fill="currentColor" d="M313.941 216H12c-6.627 0-12 5.373-12 12v56c0 6.627 5.373 12 12 12h301.941v46.059c0 21.382 25.851 32.09 40.971 16.971l86.059-86.059c9.373-9.373 9.373-24.569 0-33.941l-86.059-86.059c-15.119-15.119-40.971-4.411-40.971 16.971V216z"></path></svg>
                        </button>
                    </form>
                    <div>
                        <div>OR</div>
                        <div class="type-of-span">
                            <a class="link-login" href="http://facebook.com">
                                <button class="login-by-anotherapp">
                                    <span>FACEBOOK</span>
                                    <svg style="width: 20px;height: 50px;margin-right: 20px;margin-top: -2px;margin-left: 20px;" xmlns="http://www.w3.org/2000/svg" aria-hidden="true" focusable="false" data-prefix="fab" data-icon="facebook" class="svg-inline--fa fa-facebook fa-w-16" role="img" viewBox="0 0 512 512"><path fill="currentColor" d="M504 256C504 119 393 8 256 8S8 119 8 256c0 123.78 90.69 226.38 209.25 245V327.69h-63V256h63v-54.64c0-62.15 37-96.48 93.67-96.48 27.14 0 55.52 4.84 55.52 4.84v61h-31.28c-30.8 0-40.41 19.12-40.41 38.73V256h68.78l-11 71.69h-57.78V501C413.31 482.38 504 379.78 504 256z"/></svg>
                                </button>
                             </a>
                            <a class="link-login" href="http://gmail.com">
                                <button class="login-by-anotherapp">
                                    <span>GOOGLE</span>
                                    <svg style="width: 20px;height: 50px;margin-right: 20px;margin-top: -2px;margin-left: 20px;" xmlns="http://www.w3.org/2000/svg" aria-hidden="true" focusable="false" data-prefix="fab" data-icon="google" class="svg-inline--fa fa-google fa-w-16" role="img" viewBox="0 0 488 512"><path fill="currentColor" d="M488 261.8C488 403.3 391.1 504 248 504 110.8 504 0 393.2 0 256S110.8 8 248 8c66.8 0 123 24.5 166.3 64.9l-67.5 64.9C258.5 52.6 94.3 116.6 94.3 256c0 86.5 69.1 156.6 153.7 156.6 98.2 0 135-70.4 140.8-106.9H248v-85.3h236.1c2.3 12.7 3.9 24.9 3.9 41.4z"/></svg>
                                </button>   
                            </a>
                            <a class="link-login" href="http://yahoo.com">
                                <button class="login-by-anotherapp">
                                    <span>YAHOO</span>
                                    <svg style="width: 20px;height: 50px;margin-right: 20px;margin-top: -2px;margin-left: 20px;" xmlns="http://www.w3.org/2000/svg" aria-hidden="true" focusable="false" data-prefix="fab" data-icon="yahoo" class="svg-inline--fa fa-yahoo fa-w-14" role="img" viewBox="0 0 448 512"><path fill="currentColor" d="M252 292l4 220c-12.7-2.2-23.5-3.9-32.3-3.9-8.4 0-19.2 1.7-32.3 3.9l4-220C140.4 197.2 85 95.2 21.4 0c11.9 3.1 23 3.9 33.2 3.9 9 0 20.4-.8 34.1-3.9 40.9 72.2 82.1 138.7 135 225.5C261 163.9 314.8 81.4 358.6 0c11.1 2.9 22 3.9 32.9 3.9 11.5 0 23.2-1 35-3.9C392.1 47.9 294.9 216.9 252 292z"/></svg>
                                </button>                  
                            </a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="register-part-2">
                <div class="register-part-2-contain">
                    <div class="logo-login">
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
                        <a href="http://localhost:8080/webserver/aboutMemberShip" target="_blank" class="information-register">Read more about free membership</a>
                        <div>
                            <button onclick="redirectRegisterPage()" class="register-now-body" type="button">
                                    <div>
                                       <span class="click-register-now">REGISTER NOW</span>
                                    </div>
                                    <svg style="padding:12px;width:25px;height:25px" xmlns="http://www.w3.org/2000/svg" aria-hidden="true" focusable="false" data-prefix="fas" data-icon="long-arrow-alt-right" class="svg-inline--fa fa-long-arrow-alt-right fa-w-14" role="img" viewBox="0 0 448 512"><path fill="currentColor" d="M313.941 216H12c-6.627 0-12 5.373-12 12v56c0 6.627 5.373 12 12 12h301.941v46.059c0 21.382 25.851 32.09 40.971 16.971l86.059-86.059c9.373-9.373 9.373-24.569 0-33.941l-86.059-86.059c-15.119-15.119-40.971-4.411-40.971 16.971V216z"></path></svg>
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--Footer-->
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
    
    <script src="JS/login/loginPage.js" type="text/javascript"></script>
</html>
