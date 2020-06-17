/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ApplyToProject.Ex4.Interpreter;

public class ConvertFromVND implements Expression {
    private String input;

    public ConvertFromVND(String input) {
        this.input = input;
    }

    @Override
    public int interpret(InterpreterEngineContext context) {
        return context.convertFromVND(input);
    }
}
