/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pattern.Mediator;

public interface ChatMediator {

    public void sendMessage(String msg, User user);

    void addUser(User user);

    void removeUser(String name);
}
