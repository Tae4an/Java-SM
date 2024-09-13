package edu.sm.product;

import edu.sm.dto.Product;
import edu.sm.service.ProductService;

public class ProductUpdate {
    public static void main(String[] args) {
        ProductService productService = new ProductService();
        Product product = Product.builder()
                .id(1) // 수정할 제품의 ID
                .name("밥 먹고 싶다")
                .price(15000)
                .build();
        try {
            Product updatedProduct = productService.modify(product);
            System.out.println("제품이 성공적으로 수정되었습니다: " + updatedProduct);
        } catch (Exception e) {
            System.out.println("제품 수정 중 오류 발생: " + e.getMessage());
            e.printStackTrace();
        }
    }
}