/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pattern.ChainOfResponsibility;

public enum LogLevel {
    NONE(0), INFO(1), DEBUG(2), WARNING(4), ERROR(8), FATAL(16), ALL(32);

    private int level;

    private LogLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }
}
