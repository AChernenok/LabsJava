package by.gsu.pms;

public class Orders {
    private String name;
    private int cost;

    public Orders(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }

    public Orders(int orderId, String orderName, int orderCost) {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
