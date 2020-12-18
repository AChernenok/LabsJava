package by.gsu.pms;

public class DeliveryRecord {
    private int deliveryId;
    private int orderId;
    private int courierId;
    private int deliveryTime;

    public DeliveryRecord(int deliveryId, int orderId, int courierId, int deliveryTime) {
        this.deliveryId = deliveryId;
        this.orderId = orderId;
        this.courierId = courierId;
        this.deliveryTime = deliveryTime;
    }

    public DeliveryRecord(int deliveryId, int orderId, int courierId) {
    }

    public int getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(int deliveryId) {
        this.deliveryId = deliveryId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getCourierId() {
        return courierId;
    }

    public void setCourierId(int courierId) {
        this.courierId = courierId;
    }

    public int getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(int deliveryTime) {
        this.deliveryTime = deliveryTime;
    }
}
