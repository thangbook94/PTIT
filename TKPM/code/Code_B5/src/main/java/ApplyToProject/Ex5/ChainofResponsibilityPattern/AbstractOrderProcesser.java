package ApplyToProject.Ex5.ChainofResponsibilityPattern;


public abstract class AbstractOrderProcesser {

    public static int PENDING_PAYMENT = 1;
    public static int STAFF_CHECKING = 2;
    public static int SHIPPING = 3;
    public static int COMPPLETE = 4;

    protected int status;

    protected AbstractOrderProcesser nextProcesser;

    public void setNextLogger(AbstractOrderProcesser nextProcesser) {
        this.nextProcesser = nextProcesser;
    }

    public void handle(int status, String action) {
        if (this.status == status) {
            doProcessing(action);
        }
        if (nextProcesser != null) {
            nextProcesser.handle(status, action);
        }
    }

    abstract protected void doProcessing(String s);

}
