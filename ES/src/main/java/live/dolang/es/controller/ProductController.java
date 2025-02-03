package live.dolang.es.controller;

import live.dolang.es.entity.Product;
import live.dolang.es.entity.ProductEntity;
import live.dolang.es.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // 제품 저장 API
    @PostMapping
    public ProductEntity saveProduct(@RequestBody ProductEntity productEntity) {
        return productService.saveProduct(productEntity);
    }

    // 검색 API (Elasticsearch에서 검색)
    @GetMapping("/search")
    public List<Product> searchProducts(@RequestParam String keyword) {
        return productService.searchProducts(keyword);
    }
}
