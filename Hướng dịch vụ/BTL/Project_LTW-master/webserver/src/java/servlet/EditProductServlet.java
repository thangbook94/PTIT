/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import DAO.ProductDAO;
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
public class EditProductServlet extends HttpServlet{
    
    ProductDAO productDAO = new ProductDAO();
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        int product_id = Integer.parseInt(req.getParameter("product_id"));
        Product product = productDAO.getProductByID(product_id);
        session.setAttribute("product_select", product);
        req.getRequestDispatcher("JSP/editProduct.jsp").forward(req, resp);
    }
    
}
