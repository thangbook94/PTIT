package Question1;

public class MainApp {
    public static void main(String[] args) {
        SalaryCalculator salaryCalculator = new CategoryA(1000, 200);
        Employee employee = new Employee(salaryCalculator, "Thang");
        employee.display();
        salaryCalculator = new CategoryB(2000, 800);
        employee = new Employee(salaryCalculator, "Nam");
        employee.display();
    }
}
