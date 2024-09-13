package edu.sm.order;

import edu.sm.dto.Order;
import edu.sm.service.OrderService;

import java.util.List;

public class OrderSelect {
    public static void main(String[] args) {
        OrderService orderService = new OrderService();
        try {
            List<Order> orders = orderService.get();
            System.out.println("주문 목록:");
            for (Order order : orders) {
                System.out.println(order);
            }
        } catch (Exception e) {
            System.out.println("주문 조회 실패: " + e.getMessage());
        }
    }
}
