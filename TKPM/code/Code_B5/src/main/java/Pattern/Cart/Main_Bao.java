/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pattern.Cart;

public class Main_Bao {

    public static void main(String[] args) {
        Account account = new Account("Bao", "12345678");
        Customer customer = new Customer(account);

        CartStateContext stateContext = new CartStateContext();
        stateContext.setState(new NonEmptyCart());

        ConcreteCartSubject cartSubject = new ConcreteCartSubject();
        cartSubject.Attach(new Logger());
        cartSubject.SetState(stateContext);

        stateContext.setState(new EmptyCart());
        cartSubject.SetState(stateContext);
    }

}
