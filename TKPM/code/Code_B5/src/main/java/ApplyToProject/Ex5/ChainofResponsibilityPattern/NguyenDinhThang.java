package ApplyToProject.Ex5.ChainofResponsibilityPattern;

public class NguyenDinhThang {

    private static AbstractOrderProcesser getChainOfProcessers() {

        AbstractOrderProcesser pendingPaymentProcesser = new PendingPaymentProcesser(AbstractOrderProcesser.PENDING_PAYMENT);
        AbstractOrderProcesser staffCheckingProcesser = new StaffCheckingProcesser(AbstractOrderProcesser.STAFF_CHECKING);
        AbstractOrderProcesser shippingProcesser = new ShippingProcesser(AbstractOrderProcesser.SHIPPING);
        AbstractOrderProcesser completeProcesser = new CompleteProcesser(AbstractOrderProcesser.COMPPLETE);

        pendingPaymentProcesser.setNextLogger(staffCheckingProcesser);
        staffCheckingProcesser.setNextLogger(shippingProcesser);
        shippingProcesser.setNextLogger(completeProcesser);

        return pendingPaymentProcesser;
    }

    public static void main(String[] args) {
        AbstractOrderProcesser processer = getChainOfProcessers();

        processer.handle(AbstractOrderProcesser.PENDING_PAYMENT, "Payment success, finish pending payment!");
        processer.handle(AbstractOrderProcesser.STAFF_CHECKING, "Need staff checking order before shhipping.");
    }

}
