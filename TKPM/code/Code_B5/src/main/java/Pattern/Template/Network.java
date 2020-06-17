/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pattern.Template;

public abstract class Network {
    String userName;
    String password;

    Network() {
    }

    public boolean post(String message) {
        if (logIn(this.userName, this.password)) {
            boolean result = sendData(message.getBytes());
            logOut();
            return result;
        }
        return false;
    }

    abstract boolean logIn(String userName, String password);

    abstract boolean sendData(byte[] data);

    abstract void logOut();
}
