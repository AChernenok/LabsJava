package by.gsu.pms;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryRecordDTO {
    private int deliveryId;
    private String orderName;
    private int orderCost;
    private String courierName;
    private int courierSalary;
    private int deliveryTime;
}
