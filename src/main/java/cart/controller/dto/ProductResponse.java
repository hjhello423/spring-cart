package cart.controller.dto;

import cart.domain.Product;

public class ProductResponse {

    private long id;
    private String name;
    private String image;
    private long price;

    public ProductResponse() {
    }

    public ProductResponse(long id, String name, String image, long price) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.price = price;
    }

    public static ProductResponse of(Product product) {
        return new ProductResponse(product.getId(), product.getName(), product.getImage(), product.getPrice());
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public long getPrice() {
        return price;
    }
}
