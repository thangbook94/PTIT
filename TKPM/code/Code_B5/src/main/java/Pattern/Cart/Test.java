/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pattern.Cart;

/**
 * @author HNC
 */
public class Test {
    public static void main(String[] args) {
        CartStateContext cartStateContext = new CartStateContext();
        System.out.println(cartStateContext.hashCode());
        CartStateContext cartStateContext2 = new CartStateContext();
        System.out.println(cartStateContext2.equals(cartStateContext));

//        cartStateContext.setState(new EmptyCart());
    }
}
