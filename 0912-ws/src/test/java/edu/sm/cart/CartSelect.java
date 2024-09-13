
// CartSelect.java
package edu.sm.cart;

import edu.sm.dto.Cart;
import edu.sm.service.CartService;

import java.util.List;

public class CartSelect {
    public static void main(String[] args) {
        CartService cartService = new CartService();
        try {
            List<Cart> products = cartService.get();
            System.out.println("장바구니 상품 목록:");
            for (Cart item : products) {
                System.out.println(item);
            }
        } catch (Exception e) {
            System.out.println("장바구니 아이템 조회 실패: " + e.getMessage());
        }
    }
}