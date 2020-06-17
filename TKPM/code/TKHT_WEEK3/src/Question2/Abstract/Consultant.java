package Question2.Abstract;

public class Consultant extends Employee {
    public Consultant(String id, String name) {
        super(id, name);
    }

    @Override
    public String computeCompensation() {
        return "Consultant";
    }
}
