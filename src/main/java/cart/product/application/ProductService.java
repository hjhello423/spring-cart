package cart.product.application;

import cart.product.controller.dto.ProductRequest;
import cart.product.controller.dto.ProductResponse;
import cart.product.controller.dto.ProductsResponse;
import cart.product.domain.Product;
import cart.product.domain.ProductRepository;
import cart.product.domain.Products;
import cart.exception.ErrorType;
import cart.exception.ServiceException;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductsResponse getAllProducts() {
        Products products = productRepository.findAll();

        return ProductsResponse.of(products);
    }

    public ProductResponse createProduct(ProductRequest request) {
        Product product = request.toProduct();
        productRepository.save(product);

        return ProductResponse.of(product);
    }

    public ProductResponse updateProduct(long id, ProductRequest request) {
        Product product = findProduct(id);
        product.update(request.getName(), request.getImage(), request.getPrice());
        productRepository.update(product);

        return ProductResponse.of(product);
    }

    private Product findProduct(long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ServiceException(ErrorType.PRODUCT_NOT_FOUND));
    }

    public void deleteProduct(long id) {
        Product product = findProduct(id);
        productRepository.delete(product);
    }

}
