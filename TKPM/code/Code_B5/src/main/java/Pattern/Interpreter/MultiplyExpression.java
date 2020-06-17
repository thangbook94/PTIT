/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pattern.Interpreter;

public class MultiplyExpression implements Expression {
    private String expression;

    public MultiplyExpression(String expression) {
        this.expression = expression;
    }

    @Override
    public int interpret(InterpreterEngineContext context) {
        return context.multiply(expression);
    }
}
