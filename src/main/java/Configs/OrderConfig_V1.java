package Configs;

import lombok.Builder;
import lombok.Getter;
import lombok.Value;

@Getter
@Value
@Builder
public class OrderConfig_V1 {

    private String vegName;
    private int vegQty;
    private int vegPrice;

}
