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

    // 01. 등록
    public Product saveProduct(Product product){
        return productRepository.save(product);
        // JPA에서 기본적으로 제공함
    }

    // 02. 전체 조회
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // 03. 특정 상품 조회
    public Product getProduct(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("상품을 찾을 수 없습니다. ID: " + id));
    }

    // 04. 재고변경
    public Product updateStock(Long id, int quantity) {
        Product product = getProduct(id); // 기존 상품 조회
        int newStock = product.getStock() + quantity;

        if (newStock < 0) {
            throw new IllegalArgumentException("재고가 부족합니다.");
        }

        // setter가 없으므로 직접 필드 변경 불가 → 새 객체 생성 방식 또는 setter 사용
        // 여기서는 setter 방식으로 간단 처리

        product.setStock(newStock);
        return productRepository.save(product);
    }
}
