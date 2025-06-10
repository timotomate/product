package timo.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import timo.inventory.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    // 기본적인 CRUD메서드가 자동으로 생성됨.
}