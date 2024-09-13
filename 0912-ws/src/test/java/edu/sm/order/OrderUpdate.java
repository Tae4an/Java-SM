package edu.sm.order;

import edu.sm.dto.Order;
import edu.sm.service.OrderService;

import java.util.Date;

public class OrderUpdate {
    public static void main(String[] args) {
        OrderService orderService = new OrderService();
        Order order = Order.builder()
                .id(1)
                .custId("id01")
                .orderDate(new Date())
                .totalPrice(150)
                .build();
        try {
            orderService.modify(order);
            System.out.println("주문 수정 성공: " + order);
        } catch (Exception e) {
            System.out.println("주문 수정 실패: " + e.getMessage());
        }
    }
}
