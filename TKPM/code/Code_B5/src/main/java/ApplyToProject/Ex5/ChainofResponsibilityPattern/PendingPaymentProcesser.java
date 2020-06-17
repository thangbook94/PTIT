package ApplyToProject.Ex5.ChainofResponsibilityPattern;

public class PendingPaymentProcesser extends AbstractOrderProcesser {

    public PendingPaymentProcesser(int status) {
        this.status = status;
    }

    @Override
    protected void doProcessing(String message) {
        System.out.println("Processing for order with  Pending payment status...");
    }

}
