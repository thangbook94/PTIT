/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ApplyToProject.Ex2.Strategy;

public class FreeShipping implements ShippingStrategy {

    @Override
    public int calculatorFee(int distance) {
        System.out.println("Shipping strategy is slowest");
        return 0;
    }
}