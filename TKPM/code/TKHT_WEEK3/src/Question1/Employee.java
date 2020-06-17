package Question1;

public class Employee {
    SalaryCalculator empType;
    String name;

    public Employee(SalaryCalculator empType, String name) {
        this.empType = empType;
        this.name = name;
    }

    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Salary: " + empType.getSalary());
    }
}
