package by.gsu.pms;

public class Mapper {
    public DeliveryRecordDTO mapDeliveryDTO(DeliveryRecord deliveryRecord, Couriers couriers, Orders orders){
        return DeliveryRecordDTO.builder()
                .deliveryId(deliveryRecord.getDeliveryId())
                .orderName(orders.getName())
                .orderCost(orders.getCost())
                .courierName(couriers.getName())
                .courierSalary(couriers.getSalary())
                .deliveryTime(deliveryRecord.getDeliveryTime())
                .build();
    }
}
