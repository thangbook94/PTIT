package ApplyToProject.Ex5.ChainofResponsibilityPattern;

public class StaffCheckingProcesser extends AbstractOrderProcesser {

    public StaffCheckingProcesser(int status) {
        this.status = status;
    }

    @Override
    protected void doProcessing(String message) {
        System.out.println("Processing for order with  Staff checking status...");
    }

}
