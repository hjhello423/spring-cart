package cart.cart.domain;

import java.util.List;

public class Carts {

    private List<Cart> value;

    public Carts(List<Cart> carts) {
        this.value = carts;
    }

    public List<Cart> getValue() {
        return value;
    }

}
