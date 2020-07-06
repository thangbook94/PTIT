/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;

/**
 *
 * @author SA Nice
 */
public class Cart {
    private List<Product> list;

    public Cart() {
    }
    
    private void addProduct(Product product){
        list.add(product);
    }
    
    private void removeProduct(int index){
        list.remove(index);
    }
}
