package ApplyToProject.Ex5.ChainofResponsibilityPattern;


public class ShippingProcesser extends AbstractOrderProcesser {

    public ShippingProcesser(int status) {
        this.status = status;
    }

    @Override
    protected void doProcessing(String message) {
        System.out.println("Processing for order with  Shipping status...");
    }

}
