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
public class Ref {
    private User user;
    private Cart cart;

    public Ref(User user) {
        this.user = user;
        this.cart = new Cart();
    }
}
