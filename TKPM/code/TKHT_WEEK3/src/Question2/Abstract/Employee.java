package Question2.Abstract;

public abstract class Employee {
    private String name;
    private String id;

    public Employee(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public String getId() {
        return this.id;
    }

    public void save() {
        System.out.println("Do something");
    }

    public String toString() {
        return id + " " + name;
    }

    public abstract String computeCompensation();
}
