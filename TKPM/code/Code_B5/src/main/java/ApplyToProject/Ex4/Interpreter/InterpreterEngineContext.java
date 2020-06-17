package ApplyToProject.Ex4.Interpreter;

public class InterpreterEngineContext {

    public int convertFromUSD(String input) {
        int re = 0;
        int number = Integer.parseInt(input.substring(0, input.length() - 3));
        re = number * 22000;
        return re;
    }

    public int convertFromVND(String input) {
        int re = 0;
        int number = Integer.parseInt(input.substring(0, input.length() - 3));
        re = number * 1000;
        return re;
    }
}
