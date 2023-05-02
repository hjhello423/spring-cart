package cart.application;

import cart.controller.dto.ProductsResponse;
import cart.domain.Product;
import cart.domain.ProductRepository;
import cart.domain.Products;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductsResponse getAllProducts() {
//        Products products = productRepository.findAll();
        Product product = Product.of(1L, "상품의 이름", "/images/tteokbokki.jpg", 1000);
        List<Product> products1 = List.of(product);
        Products products = new Products(products1);

        return ProductsResponse.of(products);
    }

}
