<%-- 
    Document   : Home_Page
    Created on : Nov 17, 2019, 4:15:25 PM
    Author     : minhm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>GLAZERR</title>
        <link href="CSS/homePage.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <!--Header-->
        <jsp:include page="header.jsp"></jsp:include>
        <!--Content-->
        <div class="body-page">
            <div class="body-page-part1">
                <div class="video-content">
                    <video loop autoplay muted playsinline>
                        <source src="Videos/Video_page_1.mp4" type="video/mp4">
                        Your browser does not support the <code>video</code> tag.
                    </video>
                </div>
                <div class="poster-content">
                    <h1>BLACK FRIDAY - UP TO 50% OFF</h1>
                    <div class="poster-content-introduce">Save big on gifts for everyone on your list. Ends 11/30.</div>
                    <div class="poster-content-signup">
                        <a href="http://localhost:8080/webserver/register" target="_blank" id="sign_up" onclick="SignUp()">
                            <span class="sign-up-now">SIGN UP NOW</span>
                            <svg style="padding:12px;width:25px;height:25px"xmlns="http://www.w3.org/2000/svg" aria-hidden="true" focusable="false" data-prefix="fas" data-icon="long-arrow-alt-right" class="svg-inline--fa fa-long-arrow-alt-right fa-w-14" role="img" viewBox="0 0 448 512"><path fill="currentColor" d="M313.941 216H12c-6.627 0-12 5.373-12 12v56c0 6.627 5.373 12 12 12h301.941v46.059c0 21.382 25.851 32.09 40.971 16.971l86.059-86.059c9.373-9.373 9.373-24.569 0-33.941l-86.059-86.059c-15.119-15.119-40.971-4.411-40.971 16.971V216z"/></svg>
                        </a>
                    </div>
                </div>
            </div>
            <div class="body-page-part2">
                <div class="body-page-part2-contain">
                    <div class="type-discount">
                        <img src="Images/homePage/sneak_discount.jpg" alt=""/>
                        <div class="type-discount-content">
                            <span style="padding:2px">SHOP NOW</span>
                        </div>
                    </div>
                    
                    <div class="type-discount">
                        <img src="Images/homePage/gift_discount.jpg" alt=""/>
                        <div class="type-discount-content">
                            <span style="padding:2px">SHOP NOW</span>
                        </div>
                    </div>
                    
                    <div class="type-discount">
                        <img src="Images/homePage/gift_discount.jpg" alt=""/>
                        <div class="type-discount-content">
                            <span style="padding:2px">SHOP NOW</span>
                        </div>
                    </div>    

                    <div class="type-discount">
                        <img src="Images/homePage/gift_discount.jpg" alt=""/>
                        <div class="type-discount-content">
                            <span style="padding:2px">SHOP NOW</span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="body-page-part3">
                <div class="body-page-part3-contain">
                    <div class="body-page-part3-chapter">
                        <img src="Images/homePage/deal_for_kids.jpg" alt=""/>
                        <div class="chapter-content">
                            <div class="chapter-content-start">
                                <h2>DEALS FOR KIDS</h2>
                            </div>
                            <div>
                                <span>Up to 50% off</span>   
                            </div>
                            <div class="shopping-now">
                                <button onClick="buyForWomen" title="shopping-now" type="button">
                                    <span class="click-shopping-now">SHOP NOW</span>
                                    <svg style="padding:12px;width:25px;height:25px" xmlns="http://www.w3.org/2000/svg" aria-hidden="true" focusable="false" data-prefix="fas" data-icon="long-arrow-alt-right" class="svg-inline--fa fa-long-arrow-alt-right fa-w-14" role="img" viewBox="0 0 448 512"><path fill="currentColor" d="M313.941 216H12c-6.627 0-12 5.373-12 12v56c0 6.627 5.373 12 12 12h301.941v46.059c0 21.382 25.851 32.09 40.971 16.971l86.059-86.059c9.373-9.373 9.373-24.569 0-33.941l-86.059-86.059c-15.119-15.119-40.971-4.411-40.971 16.971V216z"></path></svg>
                                </button>
                            </div>
                        </div>
                    </div>
                    <div class="body-page-part3-chapter">
                        <img src="Images/homePage/gift_for_all.jpg" alt=""/>
                        <div class="chapter-content">
                            <div class="chapter-content-start">
                                <h2>GIFTS FOR ALL</h2>
                            </div>
                            <div>
                                <span>Find the ideal gift in preparation for the upcoming gifting season.</span>   
                            </div>
                            <div class="shopping-now">
                                <button onClick="buyForMen" title="shopping-now" type="button">
                                    <span class="click-shopping-now">SHOP NOW</span>
                                    <svg style="padding:12px;width:25px;height:25px" xmlns="http://www.w3.org/2000/svg" aria-hidden="true" focusable="false" data-prefix="fas" data-icon="long-arrow-alt-right" class="svg-inline--fa fa-long-arrow-alt-right fa-w-14" role="img" viewBox="0 0 448 512"><path fill="currentColor" d="M313.941 216H12c-6.627 0-12 5.373-12 12v56c0 6.627 5.373 12 12 12h301.941v46.059c0 21.382 25.851 32.09 40.971 16.971l86.059-86.059c9.373-9.373 9.373-24.569 0-33.941l-86.059-86.059c-15.119-15.119-40.971-4.411-40.971 16.971V216z"></path></svg>
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="body-page-part4">
                <div class="body-page-part4-contain">
                    <h4>WHAT'S TRENDING</h4>
                    <div class="shoe-trending-contain">
                        <div class="shoe-trending">
                            <div class="shoe-trending-exclusive">Exclusive</div>
                            <div class="shoe-trending-like">
                                <svg style="width: 18px;height: 20px;margin-right: 15px;margin-top: 10px" xmlns="http://www.w3.org/2000/svg" aria-hidden="true" focusable="false" data-prefix="far" data-icon="heart" class="svg-inline--fa fa-heart fa-w-16" role="img" viewBox="0 0 512 512"><path fill="currentColor" d="M458.4 64.3C400.6 15.7 311.3 23 256 79.3 200.7 23 111.4 15.6 53.6 64.3-21.6 127.6-10.6 230.8 43 285.5l175.4 178.7c10 10.2 23.4 15.9 37.6 15.9 14.3 0 27.6-5.6 37.6-15.8L469 285.6c53.5-54.7 64.7-157.9-10.6-221.3zm-23.6 187.5L259.4 430.5c-2.4 2.4-4.4 2.4-6.8 0L77.2 251.8c-36.5-37.2-43.9-107.6 7.3-150.7 38.9-32.7 98.9-27.8 136.5 10.5l35 35.7 35-35.7c37.8-38.5 97.8-43.2 136.5-10.6 51.1 43.1 43.5 113.9 7.3 150.8z"/></svg>
                            </div>
                            <div class="shoe-trending-image">
                                <img src="Images/homePage/shoe-trending-1.jpg" alt=""/>
                            </div>
                            <div class="shoe-trending-content">
                                <div class="typeof-shoe-trending">Originals</div>
                                <div class="costof-shoe-trending">
                                    <div>NMD_R1 SHOES</div>
                                    <div>$ 130</div>
                                </div>                               
                            </div>
                        </div>
                        <div class="shoe-trending">
                            <div class="shoe-trending-image">
                                <div class="shoe-trending-like">
                                    <svg style="width: 18px;height: 20px;margin-right: 15px;margin-top: 10px" xmlns="http://www.w3.org/2000/svg" aria-hidden="true" focusable="false" data-prefix="far" data-icon="heart" class="svg-inline--fa fa-heart fa-w-16" role="img" viewBox="0 0 512 512"><path fill="currentColor" d="M458.4 64.3C400.6 15.7 311.3 23 256 79.3 200.7 23 111.4 15.6 53.6 64.3-21.6 127.6-10.6 230.8 43 285.5l175.4 178.7c10 10.2 23.4 15.9 37.6 15.9 14.3 0 27.6-5.6 37.6-15.8L469 285.6c53.5-54.7 64.7-157.9-10.6-221.3zm-23.6 187.5L259.4 430.5c-2.4 2.4-4.4 2.4-6.8 0L77.2 251.8c-36.5-37.2-43.9-107.6 7.3-150.7 38.9-32.7 98.9-27.8 136.5 10.5l35 35.7 35-35.7c37.8-38.5 97.8-43.2 136.5-10.6 51.1 43.1 43.5 113.9 7.3 150.8z"/></svg>
                                </div>
                                <img src="Images/homePage/shoe-trending-2.jpg" alt=""/>
                                 <div class="shoe-trending-content">
                                    <div class="typeof-shoe-trending">Originals</div>
                                    <div class="costof-shoe-trending">
                                        <div>NMD_R1 SHOES</div>
                                        <div>$ 130</div>                                        
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="shoe-trending">
                            <div class="shoe-trending-exclusive">Exclusive</div>
                            <div class="shoe-trending-like">
                                <svg style="width: 18px;height: 20px;margin-right: 15px;margin-top: 10px;" xmlns="http://www.w3.org/2000/svg" aria-hidden="true" focusable="false" data-prefix="far" data-icon="heart" class="svg-inline--fa fa-heart fa-w-16" role="img" viewBox="0 0 512 512"><path fill="currentColor" d="M458.4 64.3C400.6 15.7 311.3 23 256 79.3 200.7 23 111.4 15.6 53.6 64.3-21.6 127.6-10.6 230.8 43 285.5l175.4 178.7c10 10.2 23.4 15.9 37.6 15.9 14.3 0 27.6-5.6 37.6-15.8L469 285.6c53.5-54.7 64.7-157.9-10.6-221.3zm-23.6 187.5L259.4 430.5c-2.4 2.4-4.4 2.4-6.8 0L77.2 251.8c-36.5-37.2-43.9-107.6 7.3-150.7 38.9-32.7 98.9-27.8 136.5 10.5l35 35.7 35-35.7c37.8-38.5 97.8-43.2 136.5-10.6 51.1 43.1 43.5 113.9 7.3 150.8z"/></svg>
                            </div>                            
                            <div class="shoe-trending-image">
                                <img src="Images/homePage/shoe-trending-3.jpg" alt=""/>
                            </div>
                            <div class="shoe-trending-content">
                                <div class="typeof-shoe-trending">Originals</div>   
                                <div class="costof-shoe-trending">
                                    <div>NMD_R1 SHOES</div>
                                    <div>$ 130</div>
                                </div>
                            </div>
                        </div>
                        <div class="shoe-trending">
                            <div class="shoe-trending-like">
                                <svg style="width: 18px;height: 20px;margin-right: 15px;margin-top: 10px;" xmlns="http://www.w3.org/2000/svg" aria-hidden="true" focusable="false" data-prefix="far" data-icon="heart" class="svg-inline--fa fa-heart fa-w-16" role="img" viewBox="0 0 512 512"><path fill="currentColor" d="M458.4 64.3C400.6 15.7 311.3 23 256 79.3 200.7 23 111.4 15.6 53.6 64.3-21.6 127.6-10.6 230.8 43 285.5l175.4 178.7c10 10.2 23.4 15.9 37.6 15.9 14.3 0 27.6-5.6 37.6-15.8L469 285.6c53.5-54.7 64.7-157.9-10.6-221.3zm-23.6 187.5L259.4 430.5c-2.4 2.4-4.4 2.4-6.8 0L77.2 251.8c-36.5-37.2-43.9-107.6 7.3-150.7 38.9-32.7 98.9-27.8 136.5 10.5l35 35.7 35-35.7c37.8-38.5 97.8-43.2 136.5-10.6 51.1 43.1 43.5 113.9 7.3 150.8z"/></svg>
                            </div>                             
                            <div class="shoe-trending-image">
                                <img src="Images/homePage/shoe-trending-5.jpg" alt=""/>
                            </div>
                            <div class="shoe-trending-content">
                                <div class="typeof-shoe-trending">Originals</div>                                
                                <div class="costof-shoe-trending">
                                    <div>NMD_R1 SHOES</div>
                                    <div>$ 130</div>
                                </div>                            
                            </div>
                        </div>
                    </div>
                    <div class="pagination-contain">
                        <div class="pagination-item-1"></div>
                        <div class="pagination-item"></div>
                        <div class="pagination-item"></div>
                        <div class="pagination-item"></div>                        
                    </div>
                </div>
            </div>
            <div class="body-page-part-5">
                <div class="body-page-part-5-container">
                    <article class="body-page-part-5-article1">
                        <h2>STORIES, STYLE, AND SPORTING GOODS AT GLAZERR, SINCE 1949</h2>
                        <p>Through sports, we have the power to change lives. Sports keep us fit. They keep us mindful. They bring us together. Athletes inspire us. They help us to get up and get moving. And sporting goods featuring the latest technologies help us beat our personal best. Glazerr is home to the runner, the basketball player, the soccer kid, the fitness enthusiast, the yogi. And even the weekend hiker looking to escape the city. The 3-Stripes are everywhere and anywhere. In sports. In music. On life’s stages. Before the whistle blows, during the race, and at the finish line. We’re here to support creators. To improve their game. To live their lives. And to change the world.</p>
                    </article>
                    <article class="body-page-part-5-article2">
                        <h2>WORKOUT CLOTHES, FOR ANY SPORT</h2>
                        <p>Glazerr designs for athletes of all kinds. Creators who love to change the game. People who challenge conventions, break the rules, and define new ones. Then break them all over again. We design sports apparel that gets you moving, winning, and living life to the fullest. We create bras and tights for female athletes who play just as hard as the men. We design, innovate and iterate. We test new technologies in action. On the field, the track, the court, and in the pool. We’re inspired by retro workout clothes, creating new streetwear essentials. From NMD to our Firebird tracksuits. From Stan Smith to Superstar. Classic sports models are brought back to life on the streets and the stages around the world.</p>
                    </article>
                </div>
            </div>
        </div>
        <!--Footer-->
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
    <script src="JS/login/loginPage.js" type="text/javascript"></script>
</html>
