package Question2.Interface;

public class MainApp {
    public static void main(String[] args) {
        Employee consultant = new Consultant("1", "Thang");
        Employee salesRep = new SalesRep("2", "Nam");
        System.out.println(consultant.toString());
        System.out.println(consultant.computeCompensation());
        System.out.println(salesRep.toString());
        System.out.println(salesRep.computeCompensation());
    }
}
