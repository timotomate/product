package timo.inventory.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity // 이 클래스가 DB 테이블과 매핑됨
@Getter  // Lombok: getter 자동 생성
@NoArgsConstructor  // Lombok: 기본 생성자 자동 생성
public class Product {

    @Id  // 이 필드가 Primary Key임을 명시
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // 자동 생성 (Auto Increment)
    private Long id;

    private String name;     // 상품명
    private Integer price;   // 가격
    private Integer stock;   // 현재 재고 수량
}
