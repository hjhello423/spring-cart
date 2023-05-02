package cart.controller.dto;

import java.math.BigDecimal;

public class ProductResponse {

    private final String name;
    private final String image;
    private final BigDecimal price;

    public ProductResponse(String name, String image, BigDecimal price) {
        this.name = name;
        this.image = image;
        this.price = price;
    }

}
