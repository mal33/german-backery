package de.backery.backerydbproxyservice.to;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderTo {

    private String orderId;
    private String description;
}
