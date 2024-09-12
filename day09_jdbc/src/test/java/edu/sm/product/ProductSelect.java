package edu.sm.product;

import edu.sm.dto.Product;
import edu.sm.service.ProductService;

import java.util.List;

public class ProductSelect {
    public static void main(String[] args) {
        ProductService productService = new ProductService();
        List<Product> products = null;
        try {
            products = productService.get();
            System.out.println("모든 제품 목록:");
            for (Product product : products) {
                System.out.println(product);
            }
        } catch (Exception e) {
            System.out.println("제품 목록 조회 중 오류 발생: " + e.getMessage());
            e.printStackTrace();
        }
    }
}