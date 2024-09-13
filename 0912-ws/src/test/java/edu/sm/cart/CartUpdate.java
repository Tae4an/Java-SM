





// CartUpdate.java
package edu.sm.cart;

import edu.sm.dto.Cart;
import edu.sm.service.CartService;

public class CartUpdate {
    public static void main(String[] args) {
        CartService cartService = new CartService();
        Cart item = Cart.builder()
                .id(1)
                .custId("id01")
                .productId(1)
                .quantity(3)
                .build();
        try {
            cartService.modify(item);
            System.out.println("장바구니 아이템 수정 성공: " + item);
        } catch (Exception e) {
            System.out.println("장바구니 아이템 수정 실패: " + e.getMessage());
        }
    }
}