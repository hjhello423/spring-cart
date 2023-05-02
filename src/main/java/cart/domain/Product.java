package cart.domain;

import java.math.BigDecimal;

public class Product {

    private Long id;
    private String name;
    private String image;
    private Money price;

    private Product(long id, String name, String image, Money price) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.price = price;
    }

    private Product(String name, String image, Money price) {
        this.name = name;
        this.image = image;
        this.price = price;
    }

    public static Product of(String name, String image, int price) {
        return new Product(name, image, Money.of(price));
    }

    // TODO 삭제
    public static Product of(long id, String name, String image, int price) {
        return new Product(id, name, image, Money.of(price));
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public Money getPrice() {
        return price;
    }

    public BigDecimal price() {
        return getPrice().getValue();
    }

}
