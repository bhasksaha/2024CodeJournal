package Programs;

public class Employee {

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    private String id;
    private int salary;

    public Programs.resourceInfo getResourceInfo() {
        return resourceInfo;
    }

    public void setResourceInfo(Programs.resourceInfo resourceInfo) {
        this.resourceInfo = resourceInfo;
    }

    private resourceInfo resourceInfo;
}

