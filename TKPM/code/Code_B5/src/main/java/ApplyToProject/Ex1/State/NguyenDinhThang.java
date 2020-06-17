package ApplyToProject.Ex1.State;


public class NguyenDinhThang {
    public static void main(String[] args) {
        AlertStateContext stateContext = new AlertStateContext();
        stateContext.alert();
        stateContext.setState(new Shipping());
        stateContext.alert();
        stateContext.setState(new Received());
        stateContext.alert();
    }
}
