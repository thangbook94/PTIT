/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Apply.ChainOfResponsibility;

public abstract class Logger {

    protected LogLevel logLevel;

    protected Logger nextlogger;

    public Logger(LogLevel logLevel) {
        this.logLevel = logLevel;
    }

    public Logger setNext(Logger nextlogger) {
        this.nextlogger = nextlogger;
        return nextlogger;
    }

    public void log(LogLevel severity, String msg) {
        if (logLevel.getLevel() <= severity.getLevel()) {
            writeMessage(msg);
        }
        if (nextlogger != null) {
            nextlogger.log(severity, msg);
        }
    }

    protected abstract void writeMessage(String msg);
}
