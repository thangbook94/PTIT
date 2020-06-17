package Question2.Interface;

public class Consultant implements Employee {
    private String id;
    private String name;

    public Consultant(String id, String name) {
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
        System.out.println("Save Consultant done");
    }

    @Override
    public String computeCompensation() {
        return "Consultant";
    }
}
