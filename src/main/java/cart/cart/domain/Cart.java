package cart.cart.domain;

import cart.exception.ErrorType;
import cart.exception.ServiceException;

public class Cart {

    private static final int MIN_QUANTITY = 1;

    private Long id;
    private Long memberId;
    private Long productId;
    private Integer quantity;

    private Cart(Long id, long memberId, long productId, int quantity) {
        this.id = id;
        this.memberId = memberId;
        this.productId = productId;
        this.quantity = quantity;
    }

    public static Cart of(long memberId, long productId) {
        return Cart.builder()
                .memberId(memberId)
                .productId(productId)
                .quantity(MIN_QUANTITY)
                .build();
    }

    private void validate() {
        if (memberId == null) {
            throw new ServiceException(ErrorType.INVALID_CART_MEMBER_ID);
        }
        if (productId == null) {
            throw new ServiceException(ErrorType.PRODUCT_NOT_FOUND);
        }
        if (quantity == null) {
            throw new ServiceException(ErrorType.INVALID_CART_QUANTITY);
        }
    }

    public static CartBuilder builder() {
        return new CartBuilder();
    }

    public Long getId() {
        return id;
    }

    public long getMemberId() {
        return memberId;
    }

    public long getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public static class CartBuilder {
        private Long id;
        private Long memberId;
        private Long productId;
        private Integer quantity;

        public CartBuilder id(long id) {
            this.id = id;
            return this;
        }

        public CartBuilder memberId(long memberId) {
            this.memberId = memberId;
            return this;
        }

        public CartBuilder productId(long productId) {
            this.productId = productId;
            return this;
        }

        public CartBuilder quantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public Cart build() {
            return new Cart(id, memberId, productId, quantity);
        }
    }

}
