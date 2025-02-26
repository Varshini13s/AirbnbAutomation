package com.automation.pojo;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.Date;

@Getter
@Setter
@ToString
@EqualsAndHashCode

public class CreateOrderPojo {
    int id;
    int petId;
    int quantity;
    Date shipDate;
    String status;
    boolean complete;
}
