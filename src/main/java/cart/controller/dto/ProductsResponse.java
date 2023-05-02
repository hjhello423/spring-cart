package cart.controller.dto;

import cart.domain.Product;
import cart.domain.Products;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class ProductsResponse {

    private List<ProductDto> products;

    private ProductsResponse(List<ProductDto> products) {
        this.products = products;
    }

    public static ProductsResponse of(Products products) {
        List<Product> productsValue = products.getValue();
        List<ProductDto> productDtos = productsValue.stream()
                .map(ProductDto::of)
                .collect(Collectors.toList());

        return new ProductsResponse(productDtos);
    }

    public List<ProductDto> getProducts() {
        return products;
    }

    private static class ProductDto {

        private final long id;
        private final String name;
        private final String image;
        private final BigDecimal price;

        private ProductDto(long id, String name, String image, BigDecimal price) {
            this.id = id;
            this.name = name;
            this.image = image;
            this.price = price;
        }

        public static ProductDto of(Product product) {
            return new ProductDto(product.getId(), product.getName(), product.getImage(), product.price());
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

        public BigDecimal getPrice() {
            return price;
        }
    }

}
