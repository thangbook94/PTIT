/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pattern.State;

class Sound implements MobileAlertState {
    @Override
    public void alert(AlertStateContext ctx) {
        System.out.println("Sound...");
    }

}
