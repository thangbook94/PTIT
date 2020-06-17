package Question1;

public class CategoryB implements SalaryCalculator {
    final static double commission = 0.02;
    double baseSalary;
    double salesAmt;

    public CategoryB(double baseSalary, double salesAmt) {
        this.baseSalary = baseSalary;
        this.salesAmt = salesAmt;
    }

    @Override
    public double getSalary() {
        return baseSalary + commission * salesAmt;
    }
}