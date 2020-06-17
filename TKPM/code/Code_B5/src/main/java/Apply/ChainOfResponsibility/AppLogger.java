/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Apply.ChainOfResponsibility;

public class AppLogger {

    public static Logger getLogger() {
        Logger consoleLogger = new ConsoleLogger(LogLevel.DEBUG);
        Logger telNumLogger = consoleLogger.setNext(new TelNumberLooger(LogLevel.WARNING));
        Logger fileLogger = telNumLogger.setNext(new FileLogger(LogLevel.ERROR));
        fileLogger.setNext(new EmailLogger(LogLevel.FATAL));
        return consoleLogger;
    }
}
