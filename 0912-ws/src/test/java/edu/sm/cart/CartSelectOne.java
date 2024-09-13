// CartSelectOne.java
package edu.sm.cart;

import edu.sm.dto.Cart;
import edu.sm.service.CartService;

import java.sql.SQLException;

public class CartSelectOne {
    public static void main(String[] args) {
        CartService cartService = new CartService();
        int id = 1; // 조회할 장바구니 아이템의 ID
        try {
            Cart product = cartService.get(id);
                System.out.println("조회된 장바구니 상품: " + product);
        }catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
        catch (Exception e) {
            System.out.println("장바구니 아이템 조회 실패: " + e.getMessage());
        }
    }
}
