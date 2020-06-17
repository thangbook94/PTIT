/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pattern.Interpreter;

public class NguyenDinhThang {

    public static void main(String args[]) {
        System.out.println("1 cộng 1 = " + interpret("1 cộng 1"));
        System.out.println("4 trừ 1 = " + interpret("4 trừ 1"));
        System.out.println("4 nhân 6 = " + interpret("4 nhân 6"));
    }

    private static int interpret(String input) {
        Expression exp = null;
        if (input.contains("cộng")) {
            exp = new AddExpression(input);
        } else if (input.contains("trừ")) {
            exp = new SubtractExpression(input);
        } else if (input.contains("nhân")) {
            exp = new MultiplyExpression(input);
        } else {
            throw new UnsupportedOperationException();
        }
        return exp.interpret(new InterpreterEngineContext());
    }
}
