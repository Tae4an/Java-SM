package edu.sm.product;

import edu.sm.dto.Product;
import edu.sm.service.ProductService;

import java.util.Date;

public class ProductInsert {
    public static void main(String[] args) {
        ProductService productService = new ProductService();
        Product product = Product.builder()
                .name("새로운 제품")
                .price(10000)
                .regDate(new Date())
                .build();
        try {
            Product addedProduct = productService.add(product);
            System.out.println("제품이 성공적으로 추가되었습니다: " + addedProduct);
        } catch (Exception e) {
            System.out.println("제품 추가 중 오류 발생: " + e.getMessage());
            e.printStackTrace();
        }
    }
}