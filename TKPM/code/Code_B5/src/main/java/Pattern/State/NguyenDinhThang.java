package Pattern.State;


public class NguyenDinhThang {
    public static void main(String[] args) {
        AlertStateContext stateContext = new AlertStateContext();
        stateContext.alert();
        stateContext.alert();
        stateContext.setState(new Silent());
        stateContext.alert();
        stateContext.setState(new Sound());
        stateContext.alert();
    }
    //https://www.geeksforgeeks.org/state-design-pattern
}
