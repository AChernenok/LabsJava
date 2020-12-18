package by.gsu.pms;

public class Couriers {
    private String name;
    private int salary;

    public Couriers(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public Couriers(int courierId, String courierName, int courierSalary) {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
