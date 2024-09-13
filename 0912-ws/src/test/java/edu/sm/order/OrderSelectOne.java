package edu.sm.order;

import edu.sm.dto.Order;
import edu.sm.service.OrderService;

public class OrderSelectOne {
    public static void main(String[] args) {
        OrderService orderService = new OrderService();
        int id = 1; // 조회할 주문의 ID
        try {
            Order order = orderService.get(id);
            if (order != null) {
                System.out.println("조회된 주문: " + order);
            } else {
                System.out.println("해당 ID의 주문이 없습니다.");
            }
        } catch (Exception e) {
            System.out.println("주문 조회 실패: " + e.getMessage());
        }
    }
}
