/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Apply.ChainOfResponsibility;

public class ConsoleLogger extends Logger {

    public ConsoleLogger(LogLevel logLevel) {
        super(logLevel);
    }

    @Override
    protected void writeMessage(String msg) {
        System.out.println("Console logger: " + msg);
    }
}
