/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ApplyToProject.Ex2.Strategy;

public class NguyenDinhThang2a {

    public static void main(String[] args) {
        Shipping shipping = new Shipping();
        shipping.setStartDate("1232131");
        shipping.setTotalAmount("200");
        shipping.setStrategy(new ExpressShipping());
        ShippingService shippingService = new ShippingService(shipping);
        System.out.println("Fee ship is: " + shippingService.calFee(200));

    }
}
