package Question2.Abstract;

public class MainApp {
    public static void main(String[] args) {
        Employee consultant = new Consultant("1", "Thang");
        Employee salesRep = new SalesRep("2", "Name");
        Employee employee = new Employee("3", "Hoang") {
            @Override
            public String computeCompensation() {
                return "abc do something";
            }
        };
        System.out.println(consultant.toString());
        System.out.println(consultant.computeCompensation());
        System.out.println(salesRep.toString());
        System.out.println(salesRep.computeCompensation());
        System.out.println(employee.toString());
        System.out.println(employee.computeCompensation());
    }
}
