package edu.sm.product;

import edu.sm.dto.Product;
import edu.sm.service.ProductService;

public class ProductSelectOne {
    public static void main(String[] args) {
        ProductService productService = new ProductService();
        int id = 7;
        Product product = null;
        try {
            product = productService.get(id);
            if (product != null) {
                System.out.println("조회된 제품: " + product);
            } else {
                System.out.println("제품을 찾을 수 없습니다. ID: " + id);
            }
        } catch (Exception e) {
            System.out.println("제품 조회 중 오류 발생: " + e.getMessage());
            e.printStackTrace();
        }
    }
}