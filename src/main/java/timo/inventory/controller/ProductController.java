package timo.inventory.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import timo.inventory.domain.Product;
import timo.inventory.dto.ProductRequest;
import timo.inventory.dto.ProductResponse;
import timo.inventory.dto.StockUpdateRequest;
import timo.inventory.service.ProductService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    // 상품 등록
    @PostMapping
    public ProductResponse create(@RequestBody ProductRequest request) {
        Product product = new Product(
                null,
                request.getName(),
                request.getPrice(),
                request.getStock()
        );
        Product saved = productService.saveProduct(product);
        return new ProductResponse(saved.getId(), saved.getName(), saved.getPrice(), saved.getStock());
    }

    // 상품 전체 조회
    @GetMapping
    public List<ProductResponse> getAll() {
        return productService.getAllProducts()
                .stream()
                .map(p -> new ProductResponse(p.getId(), p.getName(), p.getPrice(), p.getStock()))
                .collect(Collectors.toList());
    }

    // 입출고
    @PatchMapping("/{id}/stock")
    public ProductResponse updateStock(@PathVariable Long id, @RequestBody StockUpdateRequest request) {
        Product updated = productService.updateStock(id, request.getQuantity());
        return new ProductResponse(updated.getId(), updated.getName(), updated.getPrice(), updated.getStock());
    }

}