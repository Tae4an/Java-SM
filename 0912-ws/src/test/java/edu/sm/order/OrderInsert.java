// OrderInsert.java
package edu.sm.order;

import edu.sm.dto.Order;
import edu.sm.service.OrderService;

import java.util.Date;
import java.util.List;

public class OrderInsert {
    public static void main(String[] args) {
        OrderService orderService = new OrderService();
        Order order = Order.builder()
                .custId("id01")
                .orderDate(new Date())
                .totalPrice(100)
                .build();
        try {
            orderService.add(order);
            System.out.println("주문 생성 성공: " + order);
        } catch (Exception e) {
            System.out.println("주문 생성 실패: " + e.getMessage());
        }
    }
}
