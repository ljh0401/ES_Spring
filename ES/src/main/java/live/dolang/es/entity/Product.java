package live.dolang.es.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "product_index")
@Getter
public class Product {
    @Id
    private Long id;

    private String name;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }

    private String description;
    private double price;

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public static Product fromEntity(ProductEntity entity) {
        Product doc = new Product();
        doc.setId(entity.getId());
        doc.setName(entity.getName());
        doc.setDescription(entity.getDescription());
        doc.setPrice(entity.getPrice());
        return doc;
    }
}