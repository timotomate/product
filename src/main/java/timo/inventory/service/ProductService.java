//로직 중심. 실제 기능을 처리. (예: 상품 등록, 재고 증감 등)
package timo.inventory.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import timo.inventory.domain.Product;
import timo.inventory.repository.ProductRepository;

import java.util.List;

@Service
@RequiredArgsConstructor // 생성자 자동 생성
public class ProductService {
    private final ProductRepository productRepository;

    // 등록
    public Product saveProduct(Product product){
        return productRepository.save(product);
        // JPA에서 기본적으로 제공함
    }

    // 전체 조회
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // 특정 상품 조회
    public Product getProduct(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("상품을 찾을 수 없습니다. ID: " + id));
    }
}
