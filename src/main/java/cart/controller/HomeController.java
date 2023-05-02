package cart.controller;

import cart.application.ProductService;
import cart.controller.dto.ProductsResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final ProductService productService;

    public HomeController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String home(Model model) {

        ProductsResponse products = productService.getAllProducts();
        model.addAttribute("products", products.getProducts());

        return "index";
    }

    @GetMapping("/admin")
    public String admin(Model model) {
        ProductsResponse products = productService.getAllProducts();
        model.addAttribute("products", products.getProducts());

        return "admin";
    }

    @GetMapping("/settings")
    public String settings(Model model) {

        return "settings";
    }

    @GetMapping("/cart")
    public String cart(Model model) {


        return "cart";
    }

}
