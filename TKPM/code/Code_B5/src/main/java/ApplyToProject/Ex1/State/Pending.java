/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ApplyToProject.Ex1.State;

class Pending implements ItemShippingState {
    @Override
    public void alert(AlertStateContext ctx) {
        System.out.println("Shipping is pending...");
    }

}