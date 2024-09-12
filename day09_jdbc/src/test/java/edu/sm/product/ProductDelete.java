package edu.sm.product;

import edu.sm.service.ProductService;

public class ProductDelete {
    public static void main(String[] args) {
        ProductService productService = new ProductService();
        int id = 1; // 삭제할 제품의 ID
        try {
            boolean result = productService.remove(id);
            if (result) {
                System.out.println("제품이 성공적으로 삭제되었습니다. ID: " + id);
            } else {
                System.out.println("제품 삭제에 실패했습니다. ID: " + id);
            }
        } catch (Exception e) {
            System.out.println("제품 삭제 중 오류 발생: " + e.getMessage());
            e.printStackTrace();
        }
    }
}