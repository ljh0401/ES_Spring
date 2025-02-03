package live.dolang.es.service;

import live.dolang.es.entity.Product;
import live.dolang.es.entity.ProductEntity;
import live.dolang.es.repository.jpa.ProductRepository;
import live.dolang.es.repository.es.ProductSearchRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductSearchRepository productSearchRepository;

    public ProductService(ProductRepository productRepository, ProductSearchRepository productSearchRepository) {
        this.productRepository = productRepository;
        this.productSearchRepository = productSearchRepository;
    }

    // MySQL에 저장하면서 Elasticsearch에도 동기화
    public ProductEntity saveProduct(ProductEntity productEntity) {
        // 1. MySQL에 먼저 저장하여 ID를 생성
        ProductEntity savedEntity = productRepository.save(productEntity);

        // 2. Elasticsearch용 문서 변환 후 저장
        Product document = Product.fromEntity(savedEntity);
        productSearchRepository.save(document);

        return savedEntity;
    }

    // Elasticsearch에서 검색
    public List<Product> searchProducts(String keyword) {
        List<Product> results = productSearchRepository.searchByName(keyword);
        System.out.println("🔍 검색어: " + keyword);
        System.out.println("🔍 검색 결과 개수: " + results.size());
        for (Product result : results) System.out.println(result.toString());
        return results;
    }
}