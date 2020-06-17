package Question2.Interface;

public class SalesRep implements Employee {
    private String id;
    private String name;

    public SalesRep(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public void save() {
        System.out.println("Save salesRep done");
    }

    @Override
    public String computeCompensation() {
        return "salesRep";
    }
}
