package live.dolang.es.repository.es;

import live.dolang.es.entity.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.elasticsearch.annotations.Query;

import java.util.List;

public interface ProductSearchRepository extends ElasticsearchRepository<Product, Long> {
    // (Full-Text 검색)
    @Query("{\"wildcard\": {\"name\": \"*?0*\"}}")
    List<Product> searchByName(String keyword);
}