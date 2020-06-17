package Question1;

public class CategoryA implements SalaryCalculator {
    double baseSalary;
    double OT;

    public CategoryA(double baseSalary, double OT) {
        this.baseSalary = baseSalary;
        this.OT = OT;
    }

    @Override
    public double getSalary() {
        return baseSalary + OT;
    }
}
