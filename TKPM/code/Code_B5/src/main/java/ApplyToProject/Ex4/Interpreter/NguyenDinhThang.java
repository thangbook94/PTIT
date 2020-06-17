/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ApplyToProject.Ex4.Interpreter;

public class NguyenDinhThang {

    public static void main(String args[]) {
        System.out.println("200USD = " + interpret("200USD") + " đồng");
        System.out.println("100000VND = " + interpret("100000VND") + " đồng");
    }

    private static int interpret(String input) {
        Expression exp = null;
        if (input.contains("USD")) {
            exp = new ConvertFromUSD(input);
        } else if (input.contains("VND")) {
            exp = new ConvertFromVND(input);
        } else {
            throw new UnsupportedOperationException();
        }
        return exp.interpret(new InterpreterEngineContext());
    }
}
