/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connection.JDBCConnection;
import model.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SA Nice
 */
public class ProductDAO {
    public boolean addProduct(Product product){
        Connection con = JDBCConnection.getConnection();
        String query = "INSERT INTO [GlaZerr].[dbo].[Product](name, size, type_product_id, price, link_image, color, quantity, description) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps;
        try {
            ps = (PreparedStatement) con.prepareStatement(query);
            ps.setString(1, product.getName());
            ps.setString(2, product.getSize());
            ps.setInt(3, product.getTypeProductId());
            ps.setFloat(4, product.getPrice());
            ps.setString(5, product.getLinkImage());
            ps.setString(6, product.getColor());
            ps.setInt(7, product.getQuantity());
            ps.setString(8, product.getDescription());
            ps.executeUpdate();
            con.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public List<Product> getProductByType(int type_product_id){
        Connection con = JDBCConnection.getConnection();
        String query = "SELECT * FROM [GlaZerr].[dbo].[Product] WHERE type_product_id = " + type_product_id;
        PreparedStatement ps;
        try {
            ps = (PreparedStatement) con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            List<Product> listProduct = new ArrayList<>();
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String size = rs.getString("size");
                float price = rs.getFloat("price");
                String color = rs.getString("color");
                int quantity = rs.getInt("quantity");
                String link_image = rs.getString("link_image");
                String description = rs.getString("description");
                Product product = new Product(id, name, size, type_product_id, price, link_image, color, quantity, description);
                listProduct.add(product);
            }
            con.close();
            return listProduct;
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Product getProductByID(int id){
        Connection con = JDBCConnection.getConnection();
        String query = "SELECT * FROM [GlaZerr].[dbo].[Product] WHERE id = '" + id + "'";
        PreparedStatement ps;
        try {
            ps = (PreparedStatement) con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String name = rs.getString("name");
                String size = rs.getString("size");
                int type_product_id = rs.getInt("type_product_id");
                float price = rs.getFloat("price");
                String color = rs.getString("color");
                int quantity = rs.getInt("quantity");
                String link_image = rs.getString("link_image");
                String description = rs.getString("description");
                Product product = new Product(id, name, size, type_product_id, price, link_image, color, quantity, description);
                con.close();
                return product;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public boolean editProduct(int id, String name, int type_product_id, float price, String color, int quantity, String description, String link_image, String size){
        Connection con = JDBCConnection.getConnection();
        String query = "UPDATE [GlaZerr].[dbo].[Product] SET name = ?, type_product_id = ?, price = ?, color = ?, quantity = ?, description = ?, link_image = ?, size = ? WHERE id = ?";
        PreparedStatement ps;
        try {
            ps = (PreparedStatement) con.prepareStatement(query);
            ps.setString(1, name);
            ps.setInt(2, type_product_id);
            ps.setFloat(3, price);
            ps.setString(4, color);
            ps.setInt(5, quantity);
            ps.setString(6, description);
            ps.setString(7, link_image);
            ps.setString(8, size);
            ps.setInt(9, id);
            ps.executeUpdate();
            con.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public List<Product> searchProduct(String text_search){
        Connection con = JDBCConnection.getConnection();
        String query = "SELECT * FROM [GlaZerr].[dbo].[Product] WHERE UPPER(name) LIKE '%" + text_search.toUpperCase() + "%'";
        PreparedStatement ps;
        try {
            ps = (PreparedStatement) con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            List<Product> listProduct = new ArrayList<>();
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String size = rs.getString("size");
                float price = rs.getFloat("price");
                int type_product_id = rs.getInt("type_product_id");
                String color = rs.getString("color");
                int quantity = rs.getInt("quantity");
                String link_image = rs.getString("link_image");
                String description = rs.getString("description");
                Product product = new Product(id, name, size, type_product_id, price, link_image, color, quantity, description);
                listProduct.add(product);
            }
            con.close();
            return listProduct;
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void deleteProductByID(int product_id){
        Connection con = JDBCConnection.getConnection();
        String query = "DELETE FROM [GlaZerr].[dbo].[Product] WHERE id = ?";
        PreparedStatement ps;
        try {
            ps = (PreparedStatement) con.prepareStatement(query);
            ps.setInt(1, product_id);
            ps.executeUpdate();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args) {
        
    }
}
