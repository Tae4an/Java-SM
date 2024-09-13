package edu.sm.order;

import edu.sm.service.OrderService;

public class OrderDelete {
    public static void main(String[] args) {
        OrderService orderService = new OrderService();
        int id = 1; // 삭제할 주문의 ID
        try {
            boolean result = orderService.remove(id);
            if (result) {
                System.out.println("주문 삭제 성공: ID = " + id);
            } else {
                System.out.println("주문 삭제 실패: 해당 ID의 주문이 없습니다.");
            }
        } catch (Exception e) {
            System.out.println("주문 삭제 실패: " + e.getMessage());
        }
    }
}
