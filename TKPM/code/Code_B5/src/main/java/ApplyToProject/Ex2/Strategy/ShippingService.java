/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ApplyToProject.Ex2.Strategy;


public class ShippingService {
    private Shipping shipping;

    public ShippingService(Shipping shipping) {
        this.shipping = shipping;
    }

    public void setSortStrategy(ShippingStrategy strategy) {
        this.shipping.setStrategy(strategy);
    }

    public int calFee(int distance) {
        return shipping.getStrategy().calculatorFee(distance);
    }

}