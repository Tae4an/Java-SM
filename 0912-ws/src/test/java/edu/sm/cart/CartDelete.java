// CartDelete.java
package edu.sm.cart;

import edu.sm.service.CartService;

public class CartDelete {
    public static void main(String[] args) {
        CartService cartService = new CartService();
        int id = 1; // 삭제할 장바구니 아이템의 ID
        try {
            boolean result = cartService.remove(id);
            if (result) {
                System.out.println("장바구니 아이템 삭제 성공: ID = " + id);
            } else {
                System.out.println("장바구니 아이템 삭제 실패: 해당 ID의 아이템이 없습니다.");
            }
        } catch (Exception e) {
            System.out.println("장바구니 아이템 삭제 실패: " + e.getMessage());
        }
    }
}