package edu.sm.app;

import edu.sm.dto.Cust;
import edu.sm.dto.Product;
import edu.sm.dto.Cart;
import edu.sm.dto.Order;
import edu.sm.exception.DuplicatedIdException;
import edu.sm.exception.NotFoundException;
import edu.sm.service.CustService;
import edu.sm.service.ProductService;
import edu.sm.service.CartService;
import edu.sm.service.OrderService;

import java.util.List;
import java.util.Scanner;
import java.util.Date;
import java.util.stream.Collectors;

public class Main {
    private static CustService custService = new CustService();
    private static ProductService productService = new ProductService();
    private static CartService cartService = new CartService();
    private static OrderService orderService = new OrderService();
    private static Scanner scanner = new Scanner(System.in);
    private static String loggedInUserId = null;

    public static void main(String[] args) {
        while (true) {
            showMainMenu();
            int choice = getIntInput();
            switch (choice) {
                case 1 -> signUp();
                case 2 -> { if(login()) showLoggedInMenu(); }
                case 3 -> {
                    System.out.println("프로그램을 종료합니다. 감사합니다!");
                    scanner.close();
                    return;
                }
                default -> System.out.println("잘못된 선택입니다. 다시 선택해주세요.");
            }
        }
    }
    private static int getIntInput() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("올바른 숫자를 입력해주세요: ");
            }
        }
    }
    private static void showLoggedInMenu() {
        while(true){
            System.out.println("\n===== 사용자 메뉴 =====");
            System.out.println("1. 상품 등록");
            System.out.println("2. 상품 조회");
            System.out.println("3. 장바구니 담기");
            System.out.println("4. 장바구니 조회");
            System.out.println("5. 상품 주문하기");
            System.out.println("6. 로그아웃");
            System.out.println("=======================");
            System.out.print("선택해주세요: ");

            int choice = getIntInput();
            switch (choice) {
                case 1 -> registerProduct();
                case 2 -> viewProducts();
                case 3 -> addToCart();
                case 4 -> viewCart();
                case 5 -> orderProduct();
                case 6 -> {
                    loggedInUserId = null;
                    System.out.println("로그아웃 되었습니다. 메인 메뉴로 돌아갑니다.");
                    return;
                }
                default -> System.out.println("잘못된 선택입니다. 다시 선택해주세요.");
            }
        }
    }

    private static void showMainMenu() {
        System.out.println("\n===== 쇼핑몰 메인 메뉴 =====");
        System.out.println("1. 회원가입");
        System.out.println("2. 로그인");
        System.out.println("3. 종료");
        System.out.println("===========================");
        System.out.print("선택해주세요: ");
    }

    private static void signUp() {
        System.out.println("\n=== 회원가입 ===");
        System.out.print("아이디: ");
        String id = scanner.nextLine();
        System.out.print("비밀번호: ");
        String pwd = scanner.nextLine();
        System.out.print("이름: ");
        String name = scanner.nextLine();

        if (id.isEmpty() || pwd.isEmpty() || name.isEmpty()) {
            System.out.println("모든 필드를 입력해주세요.");
            return;
        }

        Cust newCust = Cust.builder()
                .id(id)
                .pwd(pwd)
                .name(name)
                .build();

        try {
            custService.add(newCust);
            System.out.println("회원가입이 완료되었습니다.");
        } catch (DuplicatedIdException e) {
            System.out.println("아이디가 중복되었습니다. 다른 아이디를 입력해주세요.");
        } catch (Exception e) {
            System.out.println("회원가입 중 오류가 발생했습니다: " + e.getMessage());
        }
    }


    private static boolean login() {
        System.out.println("\n=== 로그인 ===");
        System.out.print("아이디: ");
        String id = scanner.nextLine();
        System.out.print("비밀번호: ");
        String pwd = scanner.nextLine();

        try {
            Cust cust = custService.get(id);
            if (cust != null && cust.getPwd().equals(pwd)) {
                System.out.println("로그인 성공! 환영합니다, " + cust.getName() + "님.");
                loggedInUserId = id;
                return true;
            } else {
                System.out.println("아이디 또는 비밀번호가 일치하지 않습니다.");
                return false;
            }
        } catch (NotFoundException e) {
            System.out.println("존재하지 않는 아이디입니다.");
        } catch (Exception e) {
            System.out.println("로그인 중 오류가 발생했습니다: " + e.getMessage());
        }
        return false;
    }

    private static void registerProduct() {
        System.out.println("\n=== 상품 등록 ===");
        System.out.print("상품명: ");
        String name = scanner.nextLine();
        System.out.print("가격: ");
        int price = scanner.nextInt();
        scanner.nextLine();

        Product newProduct = Product.builder()
                .name(name)
                .price(price)
                .regDate(new Date())
                .build();

        try {
            productService.add(newProduct);
            System.out.println("상품이 등록되었습니다.");
        } catch (Exception e) {
            System.out.println("상품 등록 중 오류가 발생했습니다: " + e.getMessage());
        }
    }

    private static void viewProducts() {
        System.out.println("\n======= 상품 목록 =======");
        try {
            List<Product> products = productService.get();
            if (products.isEmpty()) {
                System.out.println("등록된 상품이 없습니다.");
                return;
            }

            System.out.println("--------------------------------------------------------");
            System.out.printf("| %-5s | %-20s | %-10s | %-12s |\n", "ID", "상품명", "가격", "등록일");
            System.out.println("--------------------------------------------------------");

            for (Product product : products) {
                System.out.printf("| %-5d | %-20s | %-10d | %-12s |\n",
                        product.getId(),
                        product.getName(),
                        product.getPrice(),
                        product.getRegDate().toString().split(" ")[0]);
            }
            System.out.println("--------------------------------------------------------");
        } catch (Exception e) {
            System.out.println("상품 조회 중 오류가 발생했습니다: " + e.getMessage());
        }
    }


    private static void addToCart() {
        System.out.println("\n=== 장바구니 담기 ===");
        System.out.print("상품 ID: ");
        int productId = scanner.nextInt();
        System.out.print("수량: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();

        Cart newCartItem = Cart.builder()
                .custId(loggedInUserId)
                .productId(productId)
                .quantity(quantity)
                .build();

        try {
            cartService.add(newCartItem);
            System.out.println("상품이 장바구니에 담겼습니다.");
        } catch (Exception e) {
            System.out.println("장바구니 담기 중 오류가 발생했습니다: " + e.getMessage());
        }
    }

    private static void viewCart() {
        System.out.println("\n=== 장바구니 조회 ===");
        try {
            List<Cart> cartItems = cartService.get();
            List<Cart> userCartItems = cartItems.stream()
                    .filter(item -> item.getCustId().equals(loggedInUserId))
                    .toList();

            if (userCartItems.isEmpty()) {
                System.out.println("장바구니가 비어있습니다.");
                return;
            }

            System.out.println("-------------------------------------------------------");
            System.out.printf("| %-5s | %-20s | %-10s | %-10s |\n", "번호", "상품명", "수량", "가격");
            System.out.println("-------------------------------------------------------");

            int totalAmount = 0;
            int itemNumber = 1;

            for (Cart item : userCartItems) {
                try {
                    Product product = productService.get(item.getProductId());
                    int itemTotal = product.getPrice() * item.getQuantity();
                    totalAmount += itemTotal;

                    System.out.printf("| %-5d | %-20s | %-10d | %-10d \n",
                            itemNumber++,
                            product.getName(),
                            item.getQuantity(),
                            itemTotal);
                } catch (NotFoundException e) {
                    System.out.printf("| %-5d | %-20s | %-10d | %-10s \n",
                            itemNumber++,
                            "상품 정보 없음",
                            item.getQuantity(),
                            "N/A");
                }
            }

            System.out.println("-------------------------------------------------------");
            System.out.printf("| %-38s | %-10d |\n", "총 금액", totalAmount);
            System.out.println("-------------------------------------------------------");

        } catch (Exception e) {
            System.out.println("장바구니 조회 중 오류가 발생했습니다: " + e.getMessage());
        }
    }

    private static void orderProduct() {
        System.out.println("\n=== 상품 주문하기 ===");
        System.out.print("주문할 상품 ID: ");
        int productId = scanner.nextInt();
        System.out.print("수량: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();

        try {
            Product product = productService.get(productId);
            int totalAmount = product.getPrice() * quantity;

            Order newOrder = Order.builder()
                    .custId(loggedInUserId)
                    .orderDate(new Date())
                    .totalPrice(totalAmount)
                    .build();

            orderService.add(newOrder);
            System.out.println("주문이 완료되었습니다. 총 금액: " + totalAmount);
        } catch (Exception e) {
            System.out.println("주문 중 오류가 발생했습니다: " + e.getMessage());
        }
    }
}