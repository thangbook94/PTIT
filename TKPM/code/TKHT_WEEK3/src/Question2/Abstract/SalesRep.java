package Question2.Abstract;

public class SalesRep extends Employee {
    public SalesRep(String id, String name) {
        super(id, name);
    }

    @Override
    public String computeCompensation() {
        return "SalesRep";
    }
}
