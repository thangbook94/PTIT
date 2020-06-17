/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Apply.Interpreter;

public class ConvertFromUSD implements Expression {

    private String expression;

    public ConvertFromUSD(String expression) {
        this.expression = expression;
    }

    @Override
    public int interpret(InterpreterEngineContext context) {
        return context.convertFromUSD(expression);
    }
}
