/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Apply.ChainOfResponsibility;

public class EmailLogger extends Logger {

    public EmailLogger(LogLevel logLevel) {
        super(logLevel);
    }

    @Override
    protected void writeMessage(String msg) {
        System.out.println("Email logger: " + msg);
    }
}