package Magazine;

import Magazine.Classes.Customer;
import Magazine.Classes.Order;
import Magazine.Classes.Product;
import Magazine.Constant.ProductCategory;


import java.util.List;

public class Main {
    public static void main(String[] args) {
        OrderManager<Order> orderManager = new OrderManager();
        Product product1 = new Product("P001", "Laptop", 1200.00, ProductCategory.ELECTRONICS);
        Product product2 = new Product("P002", "Headphones", 150.00, ProductCategory.ELECTRONICS);
        Product product3 = new Product("P003", "Book", 20.00, ProductCategory.LITERATURE);
        System.out.println("Создали продукты");
        Customer customer1 = new Customer("C001", "Alice", "alice@example.com");
        Customer customer2 = new Customer("C002", "Bob", "bob@example.com");
        System.out.println("Создали пользователей");
        Order order1 = new Order("O001", customer1);

        order1.addProduct(product1);
        order1.addProduct(product2);

        Order order2 = new Order("O002", customer2);
        order2.addProduct(product3);

        orderManager.addOrder(order1);
        orderManager.addOrder(order2);
        System.out.println("Создали заказы и загрузили в менеджер");

        System.out.println("Orders for customer " + customer1.getName() + ":");
        List<Order> ordersForAlice = orderManager.findOrdersByCustomer(customer1.getId());
        for (Order order : ordersForAlice) {
            order.processOrder();
        }
        orderManager.saveOrdersToFile("orders.txt");

        OrderManager<Order> newOrderManager = new OrderManager<>();
        newOrderManager.loadOrdersFromFile("orders.txt");

        System.out.println("\nLoaded orders:");
        for (Order order : newOrderManager.findOrdersByCustomer(customer1.getId())) {
            order.processOrder();
        }

    }
}
