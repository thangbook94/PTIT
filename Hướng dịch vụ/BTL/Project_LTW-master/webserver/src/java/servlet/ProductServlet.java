/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import DAO.ProductDAO;
import model.Product;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author SA Nice
 */
public class ProductServlet extends HttpServlet{

    public static ProductDAO productDAO = new ProductDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String typeSubmit = req.getParameter("submit");
        if(typeSubmit.equals("addProduct")){
            String name = req.getParameter("name_product");
            String size = req.getParameter("size");
            float price = Float.parseFloat(req.getParameter("price"));
            int type_product_id = Integer.parseInt(req.getParameter("type_product_id"));
            int quantity = Integer.parseInt(req.getParameter("quantity"));
            String color = req.getParameter("color");
            String link_image = req.getParameter("link_image");
            String description = req.getParameter("description");
            HttpSession session = req.getSession();
            Product product = new Product(name, size, type_product_id, price, link_image, color, quantity, description);
            if(productDAO.addProduct(product)){
                session.setAttribute("message", "Add product success!");
                resp.sendRedirect("addProduct");
            }
            else{
                session.setAttribute("error", "Add product false!");
                resp.sendRedirect("addProduct");
            }
        }
        else if(typeSubmit.equals("editProduct")){
            HttpSession session = req.getSession();
            int product_id = ((Product)session.getAttribute("product_select")).getId();
            String name = req.getParameter("name_product");
            String size = req.getParameter("size");
            float price = Float.parseFloat(req.getParameter("price"));
            int type_product_id = Integer.parseInt(req.getParameter("type_product_id"));
            int quantity = Integer.parseInt(req.getParameter("quantity"));
            String color = req.getParameter("color");
            String link_image = req.getParameter("link_image");
            String description = req.getParameter("description");
            if(productDAO.editProduct(product_id, name, type_product_id, price, color, quantity, description, link_image, size)){
                session.setAttribute("message", "Edit product success!");
                resp.sendRedirect("editProduct?product_id=" + product_id);
            }
            else{
                session.setAttribute("error", "Edit product false!");
                resp.sendRedirect("editProduct");
            }
        }
        else if(typeSubmit.equals("men")){
            loadPageProduct("Men", req, resp);
        }
        else if(typeSubmit.equals("women")){
            loadPageProduct("Women", req, resp);
        }
        else if(typeSubmit.equals("kids")){
            loadPageProduct("Kids", req, resp);
        }
        else if(typeSubmit.equals("searchProduct")){
            String text_search = req.getParameter("text_search").trim();
            loadPageProductSearch(text_search, req, resp);
        }
        else if(typeSubmit.equals("deleteProduct")){
            int product_id = Integer.parseInt(req.getParameter("product_id"));
            HttpSession session = req.getSession();
            String typeView = (String) session.getAttribute("typeView");
            productDAO.deleteProductByID(product_id);
            if(typeView.equals("Men") || typeView.equals("Women") || typeView.equals("Kids")){
                loadPageProduct(typeView, req, resp);
            }
            else{
                String text_search = (String) session.getAttribute("text_search");
                loadPageProductSearch(text_search, req, resp);
            }
        }
    }
    
    public static void loadPageProduct(String typeView, HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException{
        int typeProduct;
        if(typeView.equals("Men")){
            typeProduct = 1;
        }
        else if(typeView.equals("Women")){
            typeProduct = 2;
        }
        else{
            typeProduct = 3;
        }
        List<Product> listProduct = productDAO.getProductByType(typeProduct);
        HttpSession session = req.getSession();
        session.setAttribute("typeView", typeView);
        session.setAttribute("listProduct", listProduct);
        resp.sendRedirect(typeView.toLowerCase());
    }
    
    public static void loadPageProductSearch(String text_search, HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException{
        List<Product> listProduct = productDAO.searchProduct(text_search);
        HttpSession session = req.getSession();
        session.setAttribute("typeView", "Search");
        session.setAttribute("text_search", text_search);
        session.setAttribute("listProduct", listProduct);
        session.setAttribute("message", text_search);
        resp.sendRedirect("search");
    }
}
