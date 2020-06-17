/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pattern.ChainOfResponsibility;

public class FileLogger extends Logger {

    public FileLogger(LogLevel logLevel) {
        super(logLevel);
    }

    @Override
    protected void writeMessage(String msg) {
        System.out.println("File logger: " + msg);
    }
}
