// CartInsert.java
package edu.sm.cart;

import edu.sm.dto.Cart;
import edu.sm.service.CartService;

public class CartInsert {
    public static void main(String[] args) {
        CartService cartService = new CartService();
        Cart cart = Cart.builder()
                .custId("id01")
                .productId(1)
                .quantity(2)
                .build();
        try {
            cartService.add(cart);
            System.out.println("장바구니에 상품 추가 성공: " + cart);
        } catch (Exception e) {
            System.out.println("장바구니 추가 실패: " + e.getMessage());
        }
    }
}