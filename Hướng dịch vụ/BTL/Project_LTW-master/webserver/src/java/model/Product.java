/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author SA Nice
 */
public class Product {
    private int id;
    private String name;
    private String size;
    private int typeProductId;
    private float price;
    private String linkImage;
    private String color;
    private int quantity;
    private String description;

    public Product() {
    }

    public Product(String name, String size, int typeProductId, float price, String linkImage, String color, int quantity, String description) {
        this.name = name;
        this.size = size;
        this.typeProductId = typeProductId;
        this.price = price;
        this.linkImage = linkImage;
        this.color = color;
        this.quantity = quantity;
        this.description = description;
    }

    public Product(int id, String name, String size, int typeProductId, float price, String linkImage, String color, int quantity, String description) {
        this.id = id;
        this.name = name;
        this.size = size;
        this.typeProductId = typeProductId;
        this.price = price;
        this.linkImage = linkImage;
        this.color = color;
        this.quantity = quantity;
        this.description = description;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getTypeProductId() {
        return typeProductId;
    }

    public void setTypeProductId(int typeProductId) {
        this.typeProductId = typeProductId;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getLinkImage() {
        return linkImage;
    }

    public void setLinkImage(String linkImage) {
        this.linkImage = linkImage;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", name=" + name + ", size=" + size + ", type_product_id=" + typeProductId + ", price=" + price + ", link_image=" + linkImage + ", color=" + color + ", quantity=" + quantity + ", description=" + description + '}';
    }
    
}
