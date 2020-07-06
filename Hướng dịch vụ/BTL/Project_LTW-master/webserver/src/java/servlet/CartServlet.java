/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dto.CartDTO;
import model.Product;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author SA Nice
 */
public class CartServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("JSP/cart.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String typeSubmit = req.getParameter("submit");
        if(typeSubmit.equals("addToBag")){
            HttpSession session = req.getSession();
            CartDTO cartDTO = (session.getAttribute("cartDTO") != null) ? (CartDTO) session.getAttribute("cartDTO") : new CartDTO();
            Product product = (Product) session.getAttribute("productCurrent");
            int id = product.getId();
            product.setQuantity(1);
            cartDTO.addProduct(product);
            session.setAttribute("cartDTO", cartDTO);
            session.setAttribute("message", "Add to bag success!");
            resp.sendRedirect("detailProduct?product_id=" + id);
        }
        else if(typeSubmit.equals("remove_product")){
            HttpSession session = req.getSession();
            CartDTO cartDTO = (CartDTO) session.getAttribute("cartDTO");
            int product_id = Integer.parseInt(req.getParameter("product_id"));
            cartDTO.removeProductByID(product_id);
            session.setAttribute("cartDTO", cartDTO);
            resp.sendRedirect("cart");
        }
        else if(typeSubmit.equals("substract_product")){
            HttpSession session = req.getSession();
            CartDTO cartDTO = (CartDTO) session.getAttribute("cartDTO");
            int product_id = Integer.parseInt(req.getParameter("product_id"));
            cartDTO.substractProductByID(product_id);
            session.setAttribute("cartDTO", cartDTO);
            resp.sendRedirect("cart");
        }
        else if(typeSubmit.equals("increase_product")){
            HttpSession session = req.getSession();
            CartDTO cartDTO = (CartDTO) session.getAttribute("cartDTO");
            int product_id = Integer.parseInt(req.getParameter("product_id"));
            cartDTO.increaseProductByID(product_id);
            session.setAttribute("cartDTO", cartDTO);
            resp.sendRedirect("cart");
        }
    }
}
